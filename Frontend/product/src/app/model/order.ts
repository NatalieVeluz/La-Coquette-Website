// src/app/model/order.ts
import { Product } from './product';

export interface Order {
  id: number;
  products: Product[];
  total: number;
  paymentMethod: 'QR' | 'COD';
  status: 'Pending' | 'Paid' | 'Shipped';
  createdAt: Date;
  shippingAddress?: string; // Added optional shipping address
}
