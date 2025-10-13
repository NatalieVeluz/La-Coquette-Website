import { Component, OnInit } from '@angular/core';
import { MenuService } from '../service/menu.service';
import { Menu } from '../model/menu';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  standalone: false
})
export class HeaderComponent implements OnInit  {
  public menus: Menu[] = []

  constructor(private menuService: MenuService) {
    // Sample menu data since backend is not available
    this.menus = [
      { id: 1, name: 'Home', description: 'Home page', routerPath: '', categoryName: 'navigation' },
      { id: 2, name: 'Products', description: 'Product catalog', routerPath: 'product', categoryName: 'navigation' },
      { id: 3, name: 'Customer', description: 'Customer service', routerPath: 'customer', categoryName: 'navigation' },
      { id: 4, name: 'Cart', description: 'Shopping cart', routerPath: 'cart', categoryName: 'navigation' },
      { id: 5, name: 'Orders', description: 'Order management', routerPath: 'order', categoryName: 'navigation' },
      { id: 6, name: 'Contact Us', description: 'Contact information', routerPath: 'contact', categoryName: 'navigation' }
    ];
  }

  ngOnInit(): void {
      // Comment out API call since we're using sample data
      // this.menuService.getData().subscribe(data => {this.menus = data; });
  }

  onImageError(event: any): void {
    console.error('GMART logo failed to load:', event.target.src);
    console.error('Error details:', event);
  }

  onImageLoad(event: any): void {
    console.log('GMART logo loaded successfully:', event.target.src);
  }
}
