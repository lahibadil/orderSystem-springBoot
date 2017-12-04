import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MyNavBarComponent } from './my-nav-bar/my-nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    MyNavBarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
