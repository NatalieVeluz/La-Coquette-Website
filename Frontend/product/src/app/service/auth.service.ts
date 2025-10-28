import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';
  private loggedIn = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this.loggedIn.asObservable();

  constructor(private http: HttpClient) {
    this.restoreLoginState();
  }

  // Signup new user
  signup(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, data);
  }

  // Login existing user
  login(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, data).pipe(
      tap((res: any) => {
        if (res && res.userId) {
          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('userId', res.userId);
          localStorage.setItem('username', res.username);
          this.loggedIn.next(true);
        }
      })
    );
  }

  // Logout safely — clear local storage only
  logout() {
    // Optional: Notify backend just for consistency (not required)
    this.http.post(`${this.apiUrl}/logout`, {}).subscribe({
      next: () => console.log('Backend logout acknowledged'),
      error: err => console.warn('Logout warning:', err)
    });

    // Clear local session
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('userId');
    localStorage.removeItem('username');

    this.loggedIn.next(false);
    window.location.href = '/login'; // redirect to login
  }

  // Restore login state on page reload
  restoreLoginState() {
    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    if (isLoggedIn) {
      this.loggedIn.next(true);
    }
  }

  // Helper getter
  get isLoggedIn(): boolean {
    return this.loggedIn.value;
  }

  // Helper getter for customerId
  get customerId(): number | null {
    const id = localStorage.getItem('userId');
    return id ? Number(id) : null;
  }
}
