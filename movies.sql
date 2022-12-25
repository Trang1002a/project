DROP DATABASE Movies
GO
CREATE DATABASE Movies
GO
USE Movies
GO
CREATE TABLE tbl_movies
(
	id int identity primary key,
	name Nvarchar(100),
	image varchar(255),
	type_id varchar(100),
    format_id varchar(100),
    country_id varchar(100),
	price varchar(100),
    performer varchar(100),
    description varchar(255),
    time varchar (5),
	status bit default(1),
	created_at datetime default CURRENT_TIMESTAMP
)
INSERT INTO tbl_movies(name, image, type, country, price) VALUES
(N'Thanh Sói', 'link', 'HD', 'VN', 123456)
CREATE TABLE tbl_type
(
	id int identity primary key,
	name Nvarchar(100),
	short_name varchar(50) unique,
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
INSERT INTO tbl_type(name, short_name) VALUES
(N'Hành Động', 'HD'),
(N'Hoạt Hình', 'HH'),
(N'Hài', 'H')
GO
CREATE TABLE tbl_format
(
    id int identity primary key,
    name Nvarchar(100),
    short_name varchar(50) unique,
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1),
)
INSERT INTO tbl_format(name, short_name) VALUES
(N'2D', '2'),
(N'3D', '3'),
(N'4D', '4')

CREATE TABLE tbl_country
(
	id int identity primary key,
	name Nvarchar(100),
	short_name varchar(50) unique,
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
INSERT INTO tbl_country(name, short_name) VALUES
(N'Việt Nam', 'VN'),
(N'Mỹ', 'USA'),
(N'Trung Quốc', 'CHINA')

CREATE TABLE tbl_branch
(
	id int identity primary key,
	name Nvarchar(100),
	short_name varchar(50) unique,
	phone_number varchar(50),
	address Nvarchar(100),
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
INSERT INTO tbl_branch(name, short_name, phone_number, address) VALUES
(N'Beta Mỹ Đình', 'BT_MD', '0987654321', N'Tầng hầm B1, tòa nhà Golden Palace, Đường Mễ Trì, Phường Mễ Trì, Quận Nam Từ Liêm, Hà Nội'),
(N'Beta Thanh Xuân', 'BT_TX', '0987654321', N'Tầng hầm B1, tòa nhà Golden West, Số 2, Lê Văn Thiêm, Thanh Xuân, Hà Nội'),
(N'BHD Star Cầu Giấy', 'BHDS_CG', '0987654321', N'Tầng 8, TTTM Discovery, 302 Cầu Giấy, P. Dịch Vọng, Q. Cầu Giấy, Tp. Hà Nội')


CREATE TABLE tbl_time_slot
(
	id int identity primary key,
	name varchar(100),
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
INSERT INTO tbl_time_slot(name) VALUES
('6:00'),
('10:00'),
('13:00'),
('15:00'),
('20:00'),
('23:00'),
('1:00')
CREATE TABLE tbl_date_frame
(
	id int identity primary key,
	name Nvarchar(100),
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
GO
CREATE TABLE tbl_seat_code
(
	id int identity primary key,
	code varchar(100),
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1),
)
INSERT INTO tbl_seat_code(code) VALUES
('A0'),
('A1'),
('A2'),
('A3'),
('A4'),
('A5'),
('B0'),
('B1'),
('B2'),
('B3'),
('B4'),
('B5'),
('C0'),
('C1'),
('C2'),
('C3'),
('C4'),
('C5'),
('D0'),
('D1'),
('D2'),
('D3'),
('D4'),
('D5'),
('E0'),
('E1'),
('E2'),
('E3'),
('E4'),
('E5')
GO
CREATE TABLE tbl_showtimes
(
	id int identity primary key,
	movie_id int,
	branch_id int,
	movie_day Date,
	time_slot_id varchar,
	created_at datetime default CURRENT_TIMESTAMP,
)
INSERT INTO tbl_showtimes(movie_id, branch_id, movie_day, time_slot_id) VALUES
(1, 1, '2022-12-14', '1')
GO
CREATE TABLE tbl_request
(
	id int identity primary key,
	movie_id int,
	branch_id int,
	movie_day Date,
	time_slot_id int,
	phoneNumber varchar(50),
	name varchar(100),
	created_at datetime default CURRENT_TIMESTAMP,
	status bit default(1)
)
INSERT INTO tbl_request(movie_id, branch_id, movie_day, time_slot_id, phoneNumber, name) VALUES
(1, 1, '2022-12-14', 1, '0987654321', 'Nguyen A'),
(1, 1, '2022-12-14', 2, '0987654321', 'Nguyen A'),
(1, 1, '2022-12-14', 3, '0987654321', 'Nguyen A')
GO
CREATE TABLE tbl_ticket
(
    id int identity primary key,
--     movie_id int,
--     branch_id int,
--     movie_day Date,
--     time_slot_id int,
--     phoneNumber varchar(50),
--     name varchar(100),
--     created_at datetime default CURRENT_TIMESTAMP,
--     status bit default(1)
)