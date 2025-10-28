import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [RouterModule, FormsModule]
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private router: Router, private authService: AuthService) {}

  login() {
    if (this.username && this.password) {
      this.authService.login({ username: this.username, password: this.password }).subscribe({
        next: (res) => {
          alert(res.message || 'Login successful!');
          this.router.navigate(['/home']);
        },
        error: (err) => {
          alert(err.error?.message || 'Invalid username or password');
        }
      });
    } else {
      alert('Please fill in all fields');
    }
  }
}
