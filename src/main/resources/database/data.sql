INSERT INTO position (position_id, position_name) VALUES (1, 'Lễ tân');
INSERT INTO position (position_id, position_name) VALUES (2, 'Phục vụ');
INSERT INTO position (position_id, position_name) VALUES (3, 'Chuyên viên');
INSERT INTO position (position_id, position_name) VALUES (4, 'Giám sát');
INSERT INTO position (position_id, position_name) VALUES (5, 'Quản lý');
INSERT INTO position (position_id, position_name) VALUES (6, 'Giám đốc');

INSERT INTO education_degree (education_degree_id, education_degree_name) VALUES (1, 'Trung cấp');
INSERT INTO education_degree (education_degree_id, education_degree_name) VALUES (2, 'Cao đẳng');
INSERT INTO education_degree (education_degree_id, education_degree_name) VALUES (3, 'Đại học');
INSERT INTO education_degree (education_degree_id, education_degree_name) VALUES (4, 'Sau đại học');

INSERT INTO division (division_id, division_name) VALUES (1, 'Sale – Marketing');
INSERT INTO division (division_id, division_name) VALUES (2, 'Hành Chính');
INSERT INTO division (division_id, division_name) VALUES (3, 'Phục vụ');
INSERT INTO division (division_id, division_name) VALUES (4, 'Quản lý');

INSERT INTO role (role_id, role_name) VALUES (1, 'user');
INSERT INTO role (role_id, role_name) VALUES (2, 'admin');

INSERT INTO user (username, password) VALUES ('userquang', '123');
INSERT INTO user (username, password) VALUES ('adminquang', '123');

INSERT INTO user_role (role_id, username) VALUES (1, 'userquang');
INSERT INTO user_role (role_id, username) VALUES (2, 'adminquang');

INSERT INTO employee (employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, 
employee_address, position_id, education_degree_id, division_id, username)
 VALUES (1, 'Nguyễn Ngọc Quang', '1995-03-12', '123456789', 10000000, '(+84)123456789', 'quang@gmail.com', 'Quảng Trị', 1, 1, 1, 'userquang');

INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES (1, 'Diamond');
INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES (2, 'Platinium');
INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES (3, 'Gold');
INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES (4, 'Silver');
INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES (5, 'Member');

INSERT INTO customer (customer_id, customer_code, customer_type_id, customer_name, customer_birthday, customer_gender, 
customer_id_card, customer_phone, customer_email, customer_address) VALUES (1, 'KH-0001', 1, 'Nguyễn Văn A', '2000-01-01', 0,
'23456854', '(+84)123456789', 'khachhang1@gmail.com', 'Đà Nẵng');

INSERT INTO service_type (service_type_id, service_type_name) VALUES (1, 'Villa');
INSERT INTO service_type (service_type_id, service_type_name) VALUES (2, 'House');
INSERT INTO service_type (service_type_id, service_type_name) VALUES (3, 'Room');

INSERT INTO rent_type (rent_type_id, rent_type_name, rent_type_cost) VALUES (1, 'năm'  , 60000000);
INSERT INTO rent_type (rent_type_id, rent_type_name, rent_type_cost) VALUES (2, 'tháng', 5000000);
INSERT INTO rent_type (rent_type_id, rent_type_name, rent_type_cost) VALUES (2, 'ngày' , 1000000);
INSERT INTO rent_type (rent_type_id, rent_type_name, rent_type_cost) VALUES (2, 'giờ'  , 200000);

INSERT INTO service (service_id, service_code, service_name, service_area, service_cost, service_max_people,
rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, free_service_included) 
VALUES (1, 'DV-0001' , 'Villa', 100, 10000000, 20, 1, 1, 'Phòng tiêu chuẩn', 'Phòng đẹp', 10.2, 5, 'Bim Bim');

INSERT INTO contract (contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
employee_id, customer_id, service_id) 
VALUES (1, '2022-05-05', '2022-06-06', 1000000, 8000000, 1, 1, 1);

INSERT INTO attach_service (attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) 
VALUES (1, 'Nhậu'  , 2000000, 1, 'Nhậu mệt nghỉ');

INSERT INTO contract_detail (contract_detail_id, contract_id, attach_service_id, quantity) 
VALUES (1, 1, 1, 5);