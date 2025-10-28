import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Layout Components
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { XboxComponent } from './xbox/xbox.component';
import { ContactUsComponent } from './contact-us/contact-us.component';

// Standalone Feature Components
import { MainBodyComponent } from './main-body/main-body.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { OrdersComponent } from './orders/orders.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

// Services
import { AuthService } from './service/auth.service';
import { CustomerService } from './service/customer.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    XboxComponent,
    ContactUsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    AppRoutingModule,

    // ✅ These are all standalone: import them directly, not declare them
    MainBodyComponent,
    ProductCategoryComponent,
    ProductDetailComponent,
    ShoppingCartComponent,
    CheckoutComponent,
    OrdersComponent,
    LoginComponent,
    SignupComponent
  ],
  providers: [AuthService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
