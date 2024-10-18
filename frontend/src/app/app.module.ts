import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './core/overview/design/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeComponent } from './core/overview/components/employee/employee.component';
import { AgGridModule } from 'ag-grid-angular';
import { GridComponent } from './core/overview/design/grid/grid.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    EmployeeComponent,
    GridComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AgGridModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
