import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { Product } from '../model/product';

export interface CartItem {
  id?: number;
  product: Product;
  quantity: number;
  price: number;
  size: string;
  status?: number;
  customer: { id: number };
  orderId?: number | null;
}

@Injectable({ providedIn: 'root' })
export class CartService {
  private baseUrl = 'http://localhost:8080/api/cart';
  private cartItemsSubject = new BehaviorSubject<CartItem[]>([]);
  cartItems$ = this.cartItemsSubject.asObservable();

  constructor(private http: HttpClient) {
    this.loadCart();
  }

  // Get current logged-in user ID
  private get customerId(): number {
    const userId = localStorage.getItem('userId');
    return userId ? Number(userId) : 0;
  }

  // Load user's cart from backend
  loadCart() {
    if (!this.customerId) return;
    this.http.get<CartItem[]>(`${this.baseUrl}/${this.customerId}`).subscribe({
      next: items => this.cartItemsSubject.next(items),
      error: err => console.error('Error loading cart:', err)
    });
  }

  // Add product to cart (merge duplicates + show message every time)
  addToCart(product: Product, quantity: number = 1, size: string = 'Small') {
    if (!this.customerId) {
      alert('Please log in first!');
      return;
    }

    const currentCart = this.cartItemsSubject.getValue();
    const normalizedSize = (size || 'Small').trim().toLowerCase();

    // Check if same product + size already exists
    const existingItem = currentCart.find(
      item =>
        item.product.id === product.id &&
        item.size.trim().toLowerCase() === normalizedSize
    );

    if (existingItem) {
      // If it exists, increase quantity
      const newQty = existingItem.quantity + quantity;
      this.http
        .put(`${this.baseUrl}/${existingItem.id}?quantity=${newQty}`, {})
        .subscribe({
          next: () => {
            this.loadCart();
            // Always show confirmation
            alert(`${product.name} (${size}) quantity updated in your cart!`);
          },
          error: err => console.error('Error updating quantity:', err)
        });
    } else {
      // Otherwise, create a new cart item
      const newItem: CartItem = {
        product,
        quantity,
        price: Number(product.price) * quantity,
        size: size || 'Small',
        customer: { id: this.customerId },
        orderId: null,
        status: 0
      };

      this.http.post(`${this.baseUrl}`, newItem).subscribe({
        next: () => {
          this.loadCart();
          // Show confirmation for first add
          alert(`${product.name} (${size}) added to your cart!`);
        },
        error: err => console.error('Error adding to cart:', err)
      });
    }
  }

  // Update quantity manually (for + / - buttons or input field)
  updateQuantity(id: number, quantity: number) {
    this.http.put(`${this.baseUrl}/${id}?quantity=${quantity}`, {}).subscribe({
      next: () => this.loadCart(),
      error: err => console.error('Error updating quantity:', err)
    });
  }

  // Remove specific item
  removeFromCart(id: number) {
    this.http.delete(`${this.baseUrl}/${id}`).subscribe({
      next: () => this.loadCart(),
      error: err => console.error('Error removing item:', err)
    });
  }

  // Clear the entire cart for this customer
  clearCart() {
    this.http.delete(`${this.baseUrl}/clear/${this.customerId}`).subscribe({
      next: () => this.loadCart(),
      error: err => console.error('Error clearing cart:', err)
    });
  }

  // Calculate total price
  getTotal(): number {
    const items = this.cartItemsSubject.getValue();
    return items.reduce((sum, item) => sum + item.price, 0);
  }
}
