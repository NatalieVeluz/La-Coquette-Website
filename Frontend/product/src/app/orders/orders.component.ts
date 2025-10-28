import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: any[] = [];
  customerId: number = 0;

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (userId) {
      this.customerId = Number(userId);
      this.loadOrders();
    } else {
      console.error('No logged-in user found.');
    }
  }

  loadOrders(): void {
    this.orderService.getOrdersByCustomer(this.customerId).subscribe({
      next: (data) => {
        this.orders = data.sort((a, b) => b.id - a.id);
        console.log('Orders loaded:', data);
      },
      error: (err) => {
        console.error('Error loading orders:', err);
      }
    });
  }

  // Cancel Order
  cancelOrder(orderId: number): void {
    if (!confirm('Are you sure you want to cancel this order?')) return;

    this.orderService.updateOrderStatus(orderId, 'cancelled').subscribe({
      next: () => {
        alert('Order cancelled successfully!');
        this.loadOrders();
      },
      error: (err) => {
        console.error('Error cancelling order:', err);
        alert('Failed to cancel order. Please try again.');
      }
    });
  }

  // Mark as Received (Completed)
  markAsReceived(orderId: number): void {
    if (!confirm('Confirm you have received your order?')) return;

    this.orderService.updateOrderStatus(orderId, 'completed').subscribe({
      next: () => {
        alert('Order marked as completed!');
        this.loadOrders();
      },
      error: (err) => {
        console.error('Error updating order:', err);
        alert('Failed to update order. Please try again.');
      }
    });
  }
}
