use dummy;

CREATE TABLE Department (
 dept_id INT NOT NULL PRIMARY KEY,
 dept_name VARCHAR(50) NOT NULL
);
CREATE TABLE Employee (
 emp_id INT NOT NULL PRIMARY KEY,
 emp_name VARCHAR(50) NOT NULL,
 emp_dept_id INT NOT NULL,
 CONSTRAINT fk_emp_dept
  FOREIGN KEY (emp_dept_id)
  REFERENCES Department(dept_id)
);
INSERT INTO department (dept_id, dept_name) VALUES
(1, 'Sales'),
(2, 'Marketing'),
(3, 'Engineering'),
(4, 'HR');

INSERT INTO Employee (emp_id, emp_name, emp_dept_id)
VALUES
 (1, 'John Doe', 1),
 (2, 'Jane Smith', 1),
 (3, 'Bob Johnson', 2),
 (4, 'Alice Lee', 3),
 (5, 'Tom Wilson', 2),
 (6, 'Sara Davis', 1),
 (7, 'Mike Brown', 3);
 

 
 
 select e.emp_id as EmployeeID, e.emp_name as EmployeeName, d.dept_name as DepartmentName from employee as e join department as d on e.emp_dept_id = d.dept_id;
 
 select e.emp_id as EmployeeID, e.emp_name as EmployeeName, d.dept_name as DepartmentName from employee as e join department as d on e.emp_dept_id = d.dept_id where d.dept_name like "%sale%";
 
 select e.emp_name from Employee as e where e.emp_name like "%john%";
 
 /*left join*/
 select e.emp_name, d.dept_name from Employee e left join Department d on e.emp_dept_id = d.dept_id;
 
 select e.emp_name, d.dept_name from Employee e right join Department d on e.emp_dept_id = d.dept_id;
 
 drop table Department;
 drop table Employee;