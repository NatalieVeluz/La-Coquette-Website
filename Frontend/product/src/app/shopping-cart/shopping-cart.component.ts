import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService, CartItem } from '../service/cart.service';

@Component({
  selector: 'app-shopping-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {   // Make sure this is exported correctly
  cartItems: CartItem[] = [];

  constructor(private cartService: CartService, private router: Router) {}

  ngOnInit(): void {
    this.cartService.cartItems$.subscribe(items => (this.cartItems = items));
  }

  updateQuantity(item: CartItem, newQuantity: number) {
    const qty = Math.max(1, newQuantity);
    if (item.id) this.cartService.updateQuantity(item.id, qty);
  }

  removeItem(item: CartItem) {
    if (item.id) this.cartService.removeFromCart(item.id);
  }

  getSubtotal(item: CartItem): number {
    return item.price * item.quantity; // Fixed subtotal formula
  }

  getTotal(): number {
    return this.cartService.getTotal();
  }

  proceedToCheckout() {
    this.router.navigate(['/checkout']);
  }
}
