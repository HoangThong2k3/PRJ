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
(N'Nước ép vị cam',5,'Nước Ép Cam là một thức uống tự nhiên và bổ dưỡng, được sản xuất từ cam tươi ngon và không chứa chất bảo quản hoặc đường tinh lọc. Với hương vị tươi mát và giàu vitamin C, nước ép cam là lựa chọn lý tưởng để tăng cường sức khỏe và giải khát trong mọi dịp.','view/assets/home/img/products/THjuicecam.jpg',15000,1,2),
(N'Nước ép vị dâu',5,'Nước Ép Dâu là một thức uống tự nhiên và sảng khoái, được tạo ra từ dâu tươi ngon và không chứa chất bảo quản hoặc đường tinh lọc. Với hương vị tươi mới và ngọt ngào của dâu, nước ép dâu là lựa chọn tuyệt vời để thưởng thức trong mùa hè.','view/assets/home/img/products/THjuicedau.jpg',15000,1,2),
(N'Nước ép vị chuối',5,'Nước Ép Chuối là một thức uống tự nhiên và bổ dưỡng, được chế biến từ chuối tươi ngon và không chứa chất bảo quản hay đường tinh lọc. Đây là một lựa chọn thú vị và dinh dưỡng cho mọi thực khách, đặc biệt là trong những ngày nắng nóng.','view/assets/home/img/products/THjuicechuoi.jpg',15000,1,2),
(N'Nước ép việt quất',5,'Nước Ép Việt Quất là một thức uống tự nhiên và bổ dưỡng, được chế biến từ trái việt quất tươi ngon và không chứa chất bảo quản hay đường tinh lọc. Đây là một lựa chọn hấp dẫn và dinh dưỡng cho mọi thực khách, đặc biệt là trong những ngày nắng nóng.','view/assets/home/img/products/THjuicevietquoc.jpg',15000,1,2),
(N'Cá khô rim',1,'Cá Khô Rim là một món ngon truyền thống của nền văn hóa ẩm thực Việt Nam, được chế biến từ cá khô tươi ngon và gia vị đậm đà. Đây là một món ăn đặc biệt, thú vị và bổ dưỡng, thích hợp cho cả bữa ăn gia đình và những buổi gặp gỡ bạn bè.','view/assets/home/img/products/cakho.jpg','60000',1,1),
(N'Snack rong biển',3,'Snack Rong Biển là một loại snack thơm ngon và bổ dưỡng được làm từ rong biển tươi ngon, chế biến với các gia vị tự nhiên và nước mắm, tạo ra một món ăn nhẹ đầy hấp dẫn và dinh dưỡng.','view/assets/home/img/products/seaweed.jpg','30000',1,1),
(N'Bánh tráng sa tế',2,'Bánh Tráng Sa Tế là một loại bánh tráng truyền thống được làm từ bột gạo tự nhiên, được phủ một lớp gia vị sa tế đậm đà và thơm ngon. Đây là một món ăn vặt phổ biến trong ẩm thực Việt Nam, mang lại trải nghiệm vị giác đặc biệt và độc đáo.','view/assets/home/img/products/banhtrangsate.jpg','30000',1,1);
