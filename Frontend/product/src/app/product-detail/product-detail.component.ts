import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService } from '../service/cart.service';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class ProductDetailComponent implements OnInit {
  product: Product | undefined;
  quantity: number = 1;
  selectedSize: string = 'Small'; // Default size is Small

  // Toast message variables
  showToast = false;
  toastMessage = '';

  constructor(
    private route: ActivatedRoute,
    private cartService: CartService,
    private productService: ProductService,
    private location: Location
  ) {}

  ngOnInit(): void {
    const productId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadProductFromBackend(productId);
  }

  // Load product from backend
  loadProductFromBackend(productId: number): void {
    this.productService.getProductById(productId).subscribe({
      next: (data) => {
        this.product = data;

        // Always default to Small if size is missing
        if (!this.product.size || this.product.size.trim() === '') {
          this.selectedSize = 'Small';
        } else {
          this.selectedSize = this.product.size;
        }
      },
      error: (err) => {
        console.error('Error loading product details:', err);
      }
    });
  }

  // Get product image safely
  getProductImage(product: Product): string {
    if (!product || !product.imageFile) return 'assets/products/default.jpg';
    const encodedFile = encodeURIComponent(product.imageFile.trim());
    return `assets/products/${encodedFile}.jpg`;
  }

  // Add to Cart with toast
  addToCart(): void {
    if (this.product) {
      const productToAdd = {
        ...this.product,
        selectedSize: this.selectedSize
      };

      this.cartService.addToCart(productToAdd, this.quantity, this.selectedSize);

      // Show toast message
      this.toastMessage = `${this.quantity} × ${this.product.name} (${this.selectedSize}) added to cart!`;
      this.showToast = true;

      setTimeout(() => {
        this.showToast = false;
      }, 2000);
    }
  }

  // Go back
  goBack(): void {
    this.location.back();
  }

  // Image fallback
  onImageError(event: any): void {
    event.target.src = 'assets/products/default.jpg';
  }

  // Fade-in on image load
  onImageLoad(event: any): void {
    event.target.classList.add('loaded');
  }
}
