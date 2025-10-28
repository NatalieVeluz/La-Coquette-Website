import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService } from '../service/cart.service';
import { ProductService } from '../service/product.service';
import { ProductCategory } from '../model/product-category';
import { Product } from '../model/product';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class ProductCategoryComponent implements OnInit, AfterViewInit {
  public productsCategory: ProductCategory[] = [];
  public selectedCategory: string | null = null;

  // ✅ For toast notification
  showToast = false;
  toastMessage = '';

  constructor(
    private cartService: CartService,
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadProductsFromBackend();

    // ✅ Get category from query params (e.g., ?category=Tops)
    this.route.queryParams.subscribe(params => {
      this.selectedCategory = params['category'] || null;
    });
  }

  ngAfterViewInit(): void {
    // ✅ Wait a bit for the products to render before scrolling
    setTimeout(() => {
      if (this.selectedCategory) {
        const target = document.getElementById(this.selectedCategory);
        if (target) {
          target.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }
      }
    }, 500);
  }

  // ✅ Load products and group them by category
  loadProductsFromBackend(): void {
    this.productService.getAllProducts().subscribe({
      next: (products: Product[]) => {
        this.productsCategory = this.groupProductsByCategory(products);
      },
      error: (err) => {
        console.error('Error loading products:', err);
      }
    });
  }

  private groupProductsByCategory(products: Product[]): ProductCategory[] {
    const grouped: { [key: string]: Product[] } = {};

    products.forEach((product) => {
      const category =
        product.categoryName?.trim() && product.categoryName.trim() !== ''
          ? product.categoryName.trim()
          : 'Uncategorized';

      if (!grouped[category]) {
        grouped[category] = [];
      }
      grouped[category].push(product);
    });

    return Object.keys(grouped).map((categoryName) => ({
      categoryName,
      products: grouped[categoryName]
    }));
  }

  // ✅ Properly handle image paths
  getProductImage(prod: Product): string {
    if (!prod || !prod.imageFile) {
      return 'assets/products/default.jpg';
    }

    const cleanFile = prod.imageFile
      .replace(/\.(jpg|jpeg|png)$/i, '')
      .trim();

    const encodedFile = encodeURIComponent(cleanFile);
    return `assets/products/${encodedFile}.jpg`;
  }

  // ✅ Add to Cart with toast message
  addToCart(product: Product): void {
    this.cartService.addToCart(product, 1);

    this.toastMessage = `${product.name} has been added to your cart!`;
    this.showToast = true;

    // Hide the toast after 2 seconds
    setTimeout(() => {
      this.showToast = false;
    }, 2000);
  }

  // ✅ Go to Product Details Page
  goToDetails(product: Product): void {
    this.router.navigate(['/product', product.id]);
  }

  // ✅ Fallback for broken images
  onImageError(event: any): void {
    event.target.src = 'assets/products/default.jpg';
  }

  // ✅ Add fade-in effect on image load
  onImageLoad(event: any): void {
    event.target.classList.add('loaded');
  }
}
