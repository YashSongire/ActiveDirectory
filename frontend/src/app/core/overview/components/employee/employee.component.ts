import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../services/employee.service';
import { Employee } from '../../shared/model/employee.model';
import { GridApi, GridOptions } from 'ag-grid-community';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss' ] // Corrected 'styleUrl' to 'styleUrls'
})
export class EmployeeComponent implements OnInit {
  isDropdownOpen = false;
  gridVisible = false;
  gridApi!: GridApi;
  rowData: Employee[] = []; // Specify type if using a model
  colDef: any[];

  constructor(private employeeService: EmployeeService) {
    this.colDef = [
      { headerName: "Name", field: "name" },
      { headerName: "Designation", field: "designation" },
      { headerName: "Address", field: "address" },
      { headerName: "Country", field: "country", width: 20 },
      { headerName: "Email Address", field: "email", width:100
       },
      { headerName: "Status", field: "status" },
      { headerName: "Manager", field: "manager.name" },
      { headerName: "Department", field: "department.domain.name" }
    ];
  }

  gridOptions: GridOptions = {
    onGridReady: (params) => {
    }
  };

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  showGrid() {
    this.gridVisible = true; // Show the grid when clicked
    this.isDropdownOpen = false; // Close the dropdown
  }

  ngOnInit(): void {
    this.getData();
  }

  getData(): void {
    this.employeeService.getAllemployee().subscribe(
      (data) => {
        this.rowData = data;
      },
      (error) => {
        console.error('Error fetching employee data:', error);
      }
    );
  }
}
