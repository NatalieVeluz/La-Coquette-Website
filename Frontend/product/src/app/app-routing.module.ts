import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainBodyComponent } from './main-body/main-body.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { OrdersComponent } from './orders/orders.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  // Home routes
  { path: '', component: MainBodyComponent },
  { path: 'home', component: MainBodyComponent },

  // Auth routes
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },

  // Product routes
  { path: 'product', component: ProductCategoryComponent },
  { path: 'product/:id', component: ProductDetailComponent },

  // Other routes
  { path: 'contact', component: ContactUsComponent },
  { path: 'cart', component: ShoppingCartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'orders', component: OrdersComponent },

  // Fallback
  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }