export interface Employee {
    id: number;
    name: string;
    designation: string;
    address: string;
    country: string;
    email: string;
    status: string;
    manager: {
      name: string;
    };
    department: {
      name: string;
    };
  }