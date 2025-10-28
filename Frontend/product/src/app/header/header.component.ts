import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../model/menu';
import { MenuService } from '../service/menu.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  standalone: false
})
export class HeaderComponent implements OnInit {
  public menus: Menu[] = [];
  isLoggedIn = false;

  constructor(
    private menuService: MenuService,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    // Restore login state on page load
    this.authService.restoreLoginState();

    // Subscribe to login status and update menu
    this.authService.isLoggedIn$.subscribe(status => {
      this.isLoggedIn = status;
      this.updateMenu();
    });

    // Initialize the menu once
    this.updateMenu();
  }

  updateMenu(): void {
    this.menus = [
      { id: 1, name: 'Home', description: 'Home page', routerPath: 'home', categoryName: 'navigation' },
      { id: 2, name: 'About', description: 'Contact information', routerPath: 'contact', categoryName: 'navigation' },
      { id: 3, name: 'Products', description: 'Product catalog', routerPath: 'product', categoryName: 'navigation' },
      { id: 4, name: 'Cart', description: 'Shopping cart', routerPath: 'cart', categoryName: 'navigation' },
      { id: 5, name: 'Orders', description: 'Order management', routerPath: 'orders', categoryName: 'navigation' },
      this.isLoggedIn
        ? { id: 8, name: 'Logout', description: 'Logout', routerPath: 'logout', categoryName: 'navigation' }
        : { id: 7, name: 'Login', description: 'User authentication', routerPath: 'login', categoryName: 'navigation' }
    ];
  }

  onMenuClick(menu: Menu): void {
    if (menu.routerPath === 'login') {
      this.router.navigate(['/login']);
    } else if (menu.routerPath === 'logout') {
      this.authService.logout();
      alert('Logged out successfully!');
      this.router.navigate(['/login']);
    } else {
      this.router.navigate(['/', menu.routerPath]);
    }
  }

  goHome(): void {
    this.router.navigate(['/home']);
  }

  onImageLoad(event: any): void {
    console.log('GMART logo loaded successfully:', event.target.src);
  }

  onImageError(event: any): void {
    console.error('GMART logo failed to load:', event.target.src);
  }
}
