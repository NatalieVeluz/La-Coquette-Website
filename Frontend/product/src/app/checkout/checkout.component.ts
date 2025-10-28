import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService, CartItem } from '../service/cart.service';
import { OrderService } from '../service/order.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class CheckoutComponent implements OnInit {
  cartItems: CartItem[] = [];
  total: number = 0;
  paymentMethod: 'QR' | 'COD' = 'COD';
  shippingAddress: string = '';

  constructor(
    private cartService: CartService,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cartService.cartItems$.subscribe(items => {
      this.cartItems = items;
      this.total = this.cartService.getTotal();
    });
  }

  submitOrder(): void {
    if (!this.shippingAddress.trim()) {
      alert('Please enter your shipping address!');
      return;
    }

    if (this.cartItems.length === 0) {
      alert('Your cart is empty!');
      return;
    }

    const customerId = Number(localStorage.getItem('userId'));
    if (!customerId) {
      alert('Please log in first!');
      this.router.navigate(['/login']);
      return;
    }

    const paymentMethod =
      this.paymentMethod === 'QR' ? 'gcash' : 'cod';

    const orderData = {
      customerId,
      totalPrice: this.total,
      status: 'pending',
      paymentMethod,
      shippingAddress: this.shippingAddress,
      items: this.cartItems.map(item => ({
        product: { id: item.product.id },
        quantity: item.quantity,
        price: item.price,
        size: item.size,
        status: 0,
        customer: { id: customerId }
      }))
    };

    console.log('Sending order data:', orderData);

    this.orderService.createOrder(orderData).subscribe({
      next: () => {
        alert('Order placed successfully!');
        this.cartService.clearCart();
        this.router.navigate(['/orders']);
      },
      error: err => {
        console.error('Checkout error:', err);
        alert('Error placing your order. Please try again.');
      }
    });
  }
}
