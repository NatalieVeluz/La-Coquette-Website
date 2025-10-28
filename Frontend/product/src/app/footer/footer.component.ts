import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface FooterLink {
  label: string;
  path: string;
}

interface SocialLink {
  icon: string[];
  label: string;
  url: string;
}

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
  standalone: false
})
export class FooterComponent {

  constructor(private router: Router) {}

  quickLinks: FooterLink[] = [
    { label: 'Home', path: '/home' },
    { label: 'Contact Us', path: '/contact' },
    { label: 'Products', path: '/product' },
    { label: 'Cart', path: '/cart' },
    { label: 'Orders', path: '/orders' }
  ];

  socialLinks: SocialLink[] = [
    { icon: ['fa-brands', 'fa-facebook'], label: 'Facebook', url: '#' },
    { icon: ['fa-brands', 'fa-instagram'], label: 'Instagram', url: '#' },
    { icon: ['fa-brands', 'fa-twitter'], label: 'Twitter', url: '#' },
    { icon: ['fa-brands', 'fa-tiktok'], label: 'TikTok', url: '#' }
  ];

  navigate(path: string) {
    this.router.navigate([path]).then(() => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }
}
