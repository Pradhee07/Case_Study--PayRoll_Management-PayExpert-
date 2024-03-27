-- Pay Expert --

create database proj;
use proj;

-- Employee table creation --

create table employee(
employee_id int primary key,
first_name varchar(25),
last_name varchar(25),
dob date,
gender varchar(10),
email varchar(25),
phone_no bigint,
address varchar(30),
j_position varchar(25),
join_date date,
terminate_date date); 

alter table employee modify column phone_no varchar(15);


INSERT INTO Employee (employee_id, first_name, last_name, dob, gender, email, phone_no, address, j_position, join_date, terminate_date)
VALUES
    (1, 'John', 'Doe', '1990-05-15', 'Male', 'john.doe@example.com', '1234567890', '123 Main St', 'Software Engineer', '2020-01-01', NULL),
    (2, 'Jane', 'Smith', '1985-09-20', 'Female', 'jane.smith@example.com', '9876543210', '456 Oak St', 'Project Manager', '2018-03-15', NULL),
    (3, 'Michael', 'Johnson', '1993-11-10', 'Male', 'michael@example.com', '5551112222', '789 Elm St', 'Data Analyst', '2021-07-10', NULL),
    (4, 'Emily', 'Brown', '1988-03-25', 'Female', 'emily.brown@example.com', '9998887777', '101 Pine St', 'HR Manager', '2017-02-20', NULL),
    (5, 'David', 'Wilson', '1995-08-12', 'Male', 'david.wilson@example.com', '4443332222', '202 Cedar St', 'Sales Executive', '2022-05-03', NULL);


-- Payroll table creation --

create table payroll(
payroll_id int primary key,
employee_id int,
foreign key (employee_id) references employee(employee_id),
payperiod_start_date date,
payperiod_end_date date,
basic_salary bigint,
overtime_pay bigint,
deductions bigint,
net_salary bigint);

alter table payroll modify column basic_salary double;
alter table payroll modify column overtime_pay double;
alter table payroll modify column deductions double;
alter table payroll modify column net_salary double;

INSERT INTO Payroll (payroll_id,employee_id, payperiod_start_date, payperiod_end_date, basic_salary, overtime_pay, deductions, net_salary)
VALUES
    (101, 1, '2024-03-01', '2024-03-15', 4000.00, 200.00, 500.00, 3700.00),
    (102, 2, '2024-03-01', '2024-03-15', 4500.00, 300.00, 600.00, 4200.00),
    (103, 3, '2024-03-01', '2024-03-15', 3800.00, 150.00, 450.00, 3500.00),
    (104, 4, '2024-03-01', '2024-03-15', 5000.00, 250.00, 700.00, 4550.00),
    (105, 5, '2024-03-01', '2024-03-15', 4200.00, 200.00, 550.00, 3850.00);

-- Tax table creation --

create table tax (
tax_id int primary key,
employee_id int,
foreign key (employee_id) references employee(employee_id),
tax_year year,
tax_income bigint,
tax_amount bigint);

alter table tax modify column tax_amount double;

INSERT INTO Tax (tax_id, employee_id, tax_year , tax_income, TaxAmount)
VALUES
    (1, 1, 2024, 45000.00, 8000.00),
    (2, 2, 2024, 50000.00, 8500.00),
    (3, 3, 2024, 42000.00, 7500.00),
    (4, 4, 2024, 55000.00, 9200.00),
    (5, 5, 2024, 48000.00, 8200.00);

-- Financial_Record tablec creation -- 

create table financial_record(
record_id int primary key,
employee_id int,
foreign key (employee_id) references employee(employee_id),
record_date date,
descrip varchar(50),
amount bigint,
record_type varchar(15));

alter table financial_record modify column amount double;

INSERT INTO financial_record (record_id, employee_id, record_date, descrip, amount, record_type)
VALUES
    (1001, 1, '2024-03-10', 'Bonus', 1000.00, 'Income'),
    (1002, 2, '2024-03-10', 'Travel Expenses', 200.00, 'Expense'),
    (1003, 3, '2024-03-10', 'Conference Registration Fee', 300.00, 'Expense'),
    (1004, 4, '2024-03-10', 'Consulting Income', 1200.00, 'Income'),
    (1005, 5, '2024-03-10', 'Sales Commission', 500.00, 'Income');