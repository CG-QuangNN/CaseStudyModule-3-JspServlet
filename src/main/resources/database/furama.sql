create database furama;

use furama;

create table position (
	position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name varchar(45)
);

create table education_degree (
	education_degree_id INT AUTO_INCREMENT PRIMARY KEY,
    education_degree_name varchar(45)
);

create table division (
	division_id INT AUTO_INCREMENT PRIMARY KEY,
    division_name varchar(45)
);

create table role (
	role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name varchar(255)
);

create table user (
	username varchar(255) PRIMARY KEY,
    password varchar(255)
);

create table user_role (
	role_id INT,
    username varchar(255),
    primary key(role_id, username),
    CONSTRAINT FK_role_id FOREIGN KEY (role_id) REFERENCES role(role_id),
    CONSTRAINT FK_username FOREIGN KEY (username) REFERENCES user(username)
);

create table employee (
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name varchar(45),
    employee_birthday DATE,
    employee_id_card varchar(45),
	employee_salary double,
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
	username varchar(255),
    CONSTRAINT FK_username_employee FOREIGN KEY (username) REFERENCES user(username)
);

create table customer_type (
	customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_name varchar(45)
);

create table customer (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_code char(7) NOT NULL,
    customer_type_id int,
    customer_name varchar(45),
    customer_birthday DATE,
    customer_gender BIT(1),
	customer_id_card varchar(45),
	customer_phone varchar(45),
	customer_email varchar(45),
	customer_address varchar(45),
    CONSTRAINT FK_customer_type_id FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id),
    CONSTRAINT UC_customer_code UNIQUE (customer_code)
);

create table service_type (
	service_type_id INT AUTO_INCREMENT PRIMARY KEY,
    service_type_name varchar(45)
);

create table rent_type (
	rent_type_id INT AUTO_INCREMENT PRIMARY KEY,
    rent_type_name varchar(45),
    rent_type_cost double
);

create table service (
	service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_code char(7) NOT NULL,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room  varchar(45),
    description_other_convenience  varchar(45),
    pool_area double,
    number_of_floors int,
    free_service_included varchar(45),
    CONSTRAINT FK_service_type_id FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id),
    CONSTRAINT FK_rent_type_id FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id),
    CONSTRAINT UC_service_code UNIQUE (service_code)
);

create table contract (
	contract_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id int,
    service_id int,
    CONSTRAINT FK_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT FK_service_id FOREIGN KEY (service_id) REFERENCES service(service_id)
);

create table attach_service (
	attach_service_id INT AUTO_INCREMENT PRIMARY KEY,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45)
);

create table contract_detail (
	contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
	contract_id INT,
	attach_service_id INT,
	quantity INT,
    CONSTRAINT FK_contract_id FOREIGN KEY (contract_id) REFERENCES contract(contract_id),
    CONSTRAINT FK_attach_service_id FOREIGN KEY (attach_service_id) REFERENCES attach_service(attach_service_id)
);