INSERT INTO UsersInfo (`firstname`,`lastname`,`email`,`avatar`,`username`,`password`,`address`,`phone`,`roleid`) VALUES
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

INSERT INTO Categories (`categoryname`,`type_id`) VALUES
(N'Đồ khô',1),
(N'Bánh tráng',1),
(N'Đồ ăn khác',1),
(N'Trà Sữa',2),
(N'Nước Ép',2);

INSERT INTO Payments (`payment_method`) VALUES
(N'Tiền mặt'),
(N'Credit Card');

INSERT INTO Products (`productname`,`categoryid`,`description`,`images`,`price`,`status`,`typeid`) VALUES
(N'Khô gà lá chanh',1,'Khô gà lá chanh là một món ngon độc đáo kết hợp giữa hương vị đậm đà của thịt gà và hương thơm dịu nhẹ từ lá chanh. Đây là một sản phẩm ẩm thực truyền thống, được chế biến tỉ mỉ từ những nguyên liệu chất lượng nhất.','view/assets/home/img/products/khoga1.jpg',60000,1,1),
(N'Khô bò sợi',1,'Khô bò sợi là một món ngon truyền thống được chế biến từ thịt bò tươi ngon, qua quá trình chế biến đặc biệt để tạo ra những sợi thịt mềm và thơm ngon. Đây là một lựa chọn lý tưởng cho những ai yêu thích hương vị đậm đà và thích thưởng thức các loại thực phẩm chế biến tỉ mỉ.','view/assets/home/img/products/khobo1.jpg',60000,0,1),
(N'Khô heo cháy tỏi',1,'Khô heo cháy tỏi là một món ngon đặc trưng trong ẩm thực, kết hợp giữa hương vị đặc biệt của thịt heo và hương thơm dịu nhẹ từ tỏi. Sản phẩm này được chế biến tỉ mỉ từ những nguyên liệu chất lượng nhất, mang lại trải nghiệm ẩm thực đậm đà và hấp dẫn cho mọi thực khách.','view/assets/home/img/products/khoheo1.jpg',60000,1,1),
(N'Bánh tráng phơi sương',2,'Bánh tráng phơi sương là một loại bánh truyền thống được làm từ bột gạo mịn và các nguyên liệu tự nhiên khác, sau đó được phơi khô dưới ánh nắng mặt trời tự nhiên. Quá trình phơi sương giúp bánh tráng trở nên mềm mại, dai và có một màu sắc tự nhiên và hương vị đặc trưng.','view/assets/home/img/products/banhtrangphoisuong.jpg',30000,1,1),
(N'Bánh tráng phô mai',2,'Bánh tráng phô mai là một sự kết hợp độc đáo giữa bánh tráng truyền thống và phô mai, tạo nên một món ăn ngon và hấp dẫn. Bánh tráng mềm mại và mỏng được phủ lớp phô mai béo ngậy, tạo ra một hương vị đặc biệt và thú vị cho mọi thực khách.','view/assets/home/img/products/banhtrangphomai.jpg',30000,1,1),
(N'Cơm cháy',3,'Cơm cháy là một món ăn truyền thống có nguồn gốc từ Việt Nam, nổi tiếng với hương vị thơm ngon, giòn rụm và hấp dẫn. Được làm từ cơm nếp tươi ngon và các nguyên liệu tự nhiên khác, cơm cháy là một lựa chọn lý tưởng cho bữa ăn sáng hoặc món nhẹ trong các bữa tiệc.','view/assets/home/img/products/comchay.jpg',45000,1,1),
(N'Mực rim me',3,'Mực rim me là một món ăn biển độc đáo và hấp dẫn, được chế biến từ mực tươi ngon, rim cùng với một hỗn hợp gia vị thơm ngon và chua ngọt của mơ me. Đây là một món ăn phổ biến trong ẩm thực Việt Nam, thường được thưởng thức cùng cơm trắng nóng hổi.','view/assets/home/img/products/mucrimme.jpg',60000,1,1),
(N'Trà sữa thái xanh',4,'Trà sữa Thái Xanh là một biến thể đặc biệt của trà sữa, sử dụng trà xanh Thái Nguyên chất lượng cao kết hợp với sữa tươi béo ngậy. Đây là một lựa chọn lý tưởng cho những người yêu thích hương vị trà xanh đặc trưng và muốn thưởng thức sự kết hợp độc đáo của trà và sữa.','view/assets/home/img/products/trasua1thaixanh.jpg',25000,1,2),
(N'Trà sữa khoai môn',4,'Trà sữa khoai môn là một biến thể đặc biệt của trà sữa, sử dụng trà xanh Thái Nguyên chất lượng cao kết hợp với sữa tươi béo ngậy. Đây là một lựa chọn lý tưởng cho những người yêu thích hương vị trà xanh đặc trưng và muốn thưởng thức sự kết hợp độc đáo của trà và sữa.','view/assets/home/img/products/trasua2khoaimon.jpg',25000,1,2),
(N'Trà sữa socola',4,'Trà sữa Socola là một biến thể đặc biệt của trà sữa, sử dụng trà xanh Thái Nguyên chất lượng cao kết hợp với sữa tươi béo ngậy. Đây là một lựa chọn lý tưởng cho những người yêu thích hương vị trà xanh đặc trưng và muốn thưởng thức sự kết hợp độc đáo của trà và sữa.','view/assets/home/img/products/trasua3socola.jpg',25000,1,2),
(N'Trà sữa dâu tây',4,'Trà sữa dâu tây là một biến thể đặc biệt của trà sữa, sử dụng trà xanh Thái Nguyên chất lượng cao kết hợp với sữa tươi béo ngậy. Đây là một lựa chọn lý tưởng cho những người yêu thích hương vị trà xanh đặc trưng và muốn thưởng thức sự kết hợp độc đáo của trà và sữa.','view/assets/home/img/products/trasua4dautay.jpg',25000,1,2),
(N'TH juice vị cam',5,'Sản phẩm nước ép hương cam thơm ngon hảo hạng được làm từ nguồn trái chất lượng tại trang trại sữa TH nổi tiếng. Nước ép trái cây TH True Juice Milk thơm ngon, hương vị trái cây tươi mát, dinh dưỡng.','view/assets/home/img/products/THjuicecam.jpg',15000,1,2),
(N'TH juice vị dâu',5,'Sản phẩm nước ép hương dâu thơm ngon hảo hạng được làm từ nguồn trái cây chất lượng tại trang trại sữa TH nổi tiếng. Nước ép trái cây TH True Juice Milk thơm ngon, hương vị trái cây tươi mát, dinh dưỡng.','view/assets/home/img/products/THjuicedau.jpg',15000,1,2),
(N'TH juice vị chuối',5,'Sản phẩm nước ép hương chuối thơm ngon hảo hạng được làm từ nguồn trái cây chất lượng tại trang trại sữa TH nổi tiếng. Nước ép trái cây TH True Juice Milk thơm ngon, hương vị trái cây tươi mát, dinh dưỡng.','view/assets/home/img/products/THjuicechuoi.jpg',15000,1,2),
(N'TH juice việt quất',5,'Sản phẩm nước ép hương việt quất thơm ngon hảo hạng được làm từ nguồn trái cây chất lượng tại trang trại sữa TH nổi tiếng. Nước ép trái cây TH True Juice Milk thơm ngon, hương vị trái cây tươi mát, dinh dưỡng.','view/assets/home/img/products/THjuicevietquoc.jpg',15000,1,2);