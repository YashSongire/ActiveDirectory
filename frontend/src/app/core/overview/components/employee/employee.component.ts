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
      { headerName: "Name", field: "name", sortable: true, filter: true },
      { headerName: "Designation", field: "designation", sortable: true, filter: true },
      { headerName: "Address", field: "address", sortable: true, filter: true, flex:1 },
      { headerName: "Country", field: "country", sortable: true, filter: true },
      { headerName: "Email Address", field: "email", sortable: true, filter: true, flex : 1 },
      { headerName: "Status", field: "status", sortable: true, filter: true },
      { headerName: "Manager", field: "manager.name", sortable: true, filter: true },
      { headerName: "Department", field: "department.domain.name", sortable: true, filter: true }
    ];
  }

  gridOptions: GridOptions = {
    onGridReady: (params) => {
      this.gridApi = params.api; // Store the grid API for later use
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
