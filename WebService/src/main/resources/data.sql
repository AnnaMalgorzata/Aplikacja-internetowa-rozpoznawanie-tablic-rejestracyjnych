INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (1, 'KR1AZ12', 'KIA', 'Sportage', 1);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (2, 'KR2RT56', 'Suzuki', 'Baleno', 2);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (3, 'KR4FC56', 'Fiat', '500', 3);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (4, 'WE316XL', 'Audi', ' A3', 4);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (5, 'KR6KI89', 'Toyota', 'Yaris', 5);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (6, 'RJS2503', 'Mazda', 'CX-30', 6);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (7, 'SJ93602', 'Opel', 'Corsa', 7);
INSERT INTO cars (id, license_plate, manufacturer, brand, user_id) VALUES (8, '29A33185', 'Renault', 'Laguna', 8);


INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (1, 'extra promo 10','FOR_DAY', 'NO', 'NO',0);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (2, 'black 20','FOR_WEEKEND', 'NO', 'YES', 2);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (3, 'promo 15','FOR_NIGHT', 'NO', 'NO', 1);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (4, 'extra promo 20','FOR_WEEKEND', 'NO', 'YES', 2);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (5, 'extra 20','FOR_SEASON', 'YES', 'YES', 3);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (6, 'okazja 15','FOR_NIGHT', 'NO', 'NO', 1);
INSERT INTO abonaments (id, name, type, priority, discount, multiple_count) VALUES (7, 'black 20','FOR_DAY', 'NO', 'NO', 0);


INSERT INTO payments (id, type, reduced_value) VALUES (1, 'BY_CARD', 20);
INSERT INTO payments (id, type, reduced_value) VALUES (2, 'BY_TANSFER', 0);
INSERT INTO payments (id, type, reduced_value) VALUES (3, 'BY_CARD', 10);
INSERT INTO payments (id, type, reduced_value) VALUES (4, 'BY_TANSFER', 10);
INSERT INTO payments (id, type, reduced_value) VALUES (5, 'BY_TANSFER', 0);
INSERT INTO payments (id, type, reduced_value) VALUES (6, 'BY_CARD', 0);
INSERT INTO payments (id, type, reduced_value) VALUES (7, 'BY_CARD', 20);


INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (1, 1, 1, 1, '2022-11-07', '2023-11-28');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (2, 2, 2, 2, '2022-10-17', '2023-06-25');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (3, 3, 3, 3, '2022-09-03', '2023-01-25');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (4, 4, 4, 4, '2022-12-11', '2023-05-25');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (5, 5, 5, 5, '2022-11-13', '2023-07-25');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (6, 6, 6, 6, '2022-10-27', '2023-01-25');
INSERT INTO schedules (id, car_id, abonament_id, payment_id, start_date, end_date ) VALUES (7, 7, 7, 7, '2022-11-22', '2023-09-25');



INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (1, 'Ewaryst', 'Zabielski', 46, 'ewaryst@gmail.com', 'ewaryst','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (2, 'Otton', 'Głuch', 31, 'głuch@interia.pl', 'głuch','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (3, 'Rosłan', 'Drozd', 66, 'drozd@op.pl', 'drozd','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (4, 'Walentyn', 'Kołaczek', 59, 'kołaczek@interia.pl', 'kołaczek','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (5, 'Celestia', 'Brodziak', 28, 'brodziak@op.pl', 'brodziak','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (6, 'Żywisława', 'Zientek', 69, 'zientek@wp.pl', 'Zientek','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (7, 'Idzisława', 'Wójciak', 54, 'email@gmail.com', 'wójciak','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (8, 'Adamina', 'Bienias', 22, 'bienias@gmail.com', 'bienias','$2a$12$GmxaW6nud8CUdJzHohHrIOl3v0DBApQUYDrNv.i0r4PTcY7.2ZROu', false);
INSERT INTO users (id, first_name, last_name, age, email, username, password, is_admin) VALUES (9, 'Administrator', 'admin', 18, 'email2@interia.pl', 'admin','$2a$12$PFewDXiLlhzbmF1uBD3btu6fGV.6.zT99UdvA62MOvMjGe/1rU/fy', true);
