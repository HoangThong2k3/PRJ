INSERT INTO users (`first_name`,`last_name`,`email`,`avatar`,`username`,`password`,`address`,`phone`,`role_id`) VALUES
(N'admin', N'', 'admin@gmail.com', 'view/assets/home/img/users/admin.png', 'admin', '12345', N'Quận 9', '0912345678', 1),
(N'Hoàng', N'Thống', 'Thonghpqe170132@fpt.edu.vn', 'view/assets/home/img/users/u thong.jpg','Miner', '12345', N'Khu Công Nghệ Cao Hòa Lạc, Thạch Hoà, Thạch Thất, Hà Nội', '0989421953', 1),
(N'Đinh', N'Hiệp', 'Hiepdsqe180120@fpt.edu.vn', 'view/assets/home/img/users/u hiep.jpg','Hellcat', '12345', N'R639+HM2, Khu đô thị mới, Thành phố Qui Nhơn, Bình Định 55117', '0912198702', 2),
(N'Lê', N'Trung', 'Trunglqse184012@fpt.edu.vn', 'view/assets/home/img/users/u trung.jpg','TrungLe', '12345', N'Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh 700000', '0992103065', 2),
(N'Nguyễn', N'Quyết', 'Quyetnbqe170091@fpt.edu.vn', 'view/assets/home/img/users/u quyet.jpg', 'QuyetNguyen', '12345', N'184 Đ. 2 Tháng 9, Hòa Cường, Hải Châu, Đà Nẵng 550000', '0979417322', 1),
(N'User', N'1', 'user1@gmail.com', 'view/assets/home/img/users/user1.jpg','user1', '12345', N'Mỹ tho', '0926895078', 2),
(N'User', N'2', 'user2@gmail.com', 'view/assets/home/img/users/user1.jpg','user2', '12345', N'Nhà ấu đến từ châu cai', '0976862320', 2);
/*tất cả số điện thoại là random*/

INSERT INTO Types (`name`) VALUES
(N'Đồ Ăn'),
(N'Nước Uống');

INSERT INTO Categories (`category_name`,`type_id`) VALUES
(N'Đồ khô',1),
(N'Bánh tráng',1),
(N'Đồ ăn khác',1),
(N'Trà Sữa',2),
(N'Nước Ép',2);

INSERT INTO Payments (`payment_method`) VALUES
(N'Tiền mặt'),
(N'Credit Card');

INSERT INTO Products (`product_name`,`category_id`,`description`,`images`,`price`,`status`,`type_id`) VALUES

