import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../service/auth.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-main-body',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './main-body.component.html',
  styleUrls: ['./main-body.component.css']
})
export class MainBodyComponent implements OnInit {
  public categoryButtons = [
    { 
      name: 'Tops', 
      category: 'Tops', 
      image: 'assets/images/Tops.jpg' 
    },
    { 
      name: 'Bottoms', 
      category: 'Bottoms', 
      image: 'assets/images/Bottoms.jpg' 
    },
    { 
      name: 'Dresses', 
      category: 'Dresses', 
      image: 'assets/images/Dress.jpg' 
    }
  ];


  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  // Navigate to Product Page with category query param
  goToCategory(category: string): void {
    this.router.navigate(['/product'], { queryParams: { category } });
  }
}
