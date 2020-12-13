import { HttpIntercepterBasicAuthService } from './service/htpp/http-intercepter-basic-auth.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ListProductComponent } from './list-product/list-product.component';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    MenuComponent,
    FooterComponent,
    ErrorComponent,
    LoginComponent,
    LogoutComponent,
    ListProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxDatatableModule,
    CommonModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterBasicAuthService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
