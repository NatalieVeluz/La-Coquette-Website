import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  standalone: true,
  imports: [RouterModule, FormsModule]
})
export class SignupComponent {
  username = '';
  email = '';
  password = '';
  name = '';
  address = '';
  phone = '';

  constructor(private router: Router, private authService: AuthService) {}

  signup() {
    if (this.username && this.email && this.password && this.name) {
      const data = {
        username: this.username,
        email: this.email,
        password: this.password,
        name: this.name,
        address: this.address,
        phone: this.phone
      };

      this.authService.signup(data).subscribe({
        next: (res) => {
          alert(res.message || 'Signup successful!');
          this.router.navigate(['/login']);
        },
        error: (err) => {
          alert(err.error?.message || 'Signup failed. Try again.');
        }
      });
    } else {
      alert('Please fill in all required fields');
    }
  }
}
