use master
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
    description Nvarchar(255),
    time varchar (5),
    status bit default(1),
    created_at datetime default CURRENT_TIMESTAMP
)
    INSERT INTO tbl_movies(name, image, type_id, format_id, country_id, price, performer, description, time) VALUES
('Kubo and the Two Strings', 'image1.jpg', '1', '1', '1', '123000', N'Comic, Magic', N'Mô tả', '60'),
('The Hurricane Heist', 'image2.jpg', '2', '2', '2', '22000', N'Nguyễn Văn A', N'Mô tả', '60'),
('Jumanji: Welcome to the Jungle', 'image3.jpg', '3', '1', '1', '511000', N'Cartoon, Sci-fi', N'Mô tả', '60'),
('Death Wish', 'image4.jpg', '1', '2', '2', '66000', N'Nguyễn Văn A', N'Mô tả', '60'),
('Supersonic', 'image5.jpg', '1', '1', '1', '50000', N'Cartoon, Magic', N'Mô tả', '60')
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
    short_name varchar(100),
    phone_number varchar(50),
    address Nvarchar(255),
    room_id varchar(100),
    total varchar(100),
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1),
)
    GO
INSERT INTO tbl_branch(name, short_name, phone_number, address, room_id) VALUES
(N'Beta Mỹ Đình', 'BT_MD', '0987654321', N'Tầng hầm B1, tòa nhà Golden Palace, Đường Mễ Trì, Phường Mễ Trì, Quận Nam Từ Liêm, Hà Nội', '1'),
(N'Beta Thanh Xuân', 'BT_TX', '0987654321', N'Tầng hầm B1, tòa nhà Golden West, Số 2, Lê Văn Thiêm, Thanh Xuân, Hà Nội', '2'),
(N'BHD Star Cầu Giấy', 'BHDS_CG', '0987654321', N'Tầng 8, TTTM Discovery, 302 Cầu Giấy, P. Dịch Vọng, Q. Cầu Giấy, Tp. Hà Nội', '3')


CREATE TABLE tbl_hours
(
    id int identity primary key,
    name varchar(100),
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1),
)
    INSERT INTO tbl_hours(name) VALUES
('6:00'),
('10:00'),
('13:00'),
('15:00'),
('20:00'),
('23:00'),
('1:00')
CREATE TABLE tbl_room
(
    id int identity primary key,
    branch_id int,
    name Nvarchar(100),
    col varchar(5),
    row varchar(5),
    total varchar(5),
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1),
)
    INSERT INTO tbl_room(branch_id, name, col, row, total) VALUES
('1', 'A1', '7', '6', '42'),
('2', 'A2', '5', '6', '30'),
('3', 'A3', '5', '7', '35')
GO
CREATE TABLE tbl_showtimes
(
    id int identity primary key,
    name varchar(100),
    movies_id varchar(100),
    branch_id varchar(100),
    room_id varchar(100),
    hours_id varchar(100),
    movie_day Date,
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1)
)
    INSERT INTO tbl_showtimes(name, movies_id, branch_id, room_id, hours_id, movie_day) VALUES
('1', '1', '1', '1', '1', '2023-01-11'),
('2', '2', '1', '1', '1', '2023-01-11'),
('3', '3', '1', '1', '1', '2023-01-11'),
('4', '4', '1', '1', '1', '2023-01-11')
    GO
CREATE TABLE tbl_request
(
    id int identity primary key,
    movie Nvarchar(200),
    branch Nvarchar(200),
    room varchar(200),
    hour_id varchar(200),
    price varchar(200),
    total_price varchar(200),
    movie_day varchar(200),
    slot varchar(200),
    phoneNumber varchar(50),
    ticket_id varchar(100),
    created_at datetime default CURRENT_TIMESTAMP,
    status bit default(1)
)