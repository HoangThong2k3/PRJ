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
(N'Khô gà lá chanh',1,'Indulge in the tantalizing fusion of flavors with our Khô gà lá chanh. Crafted with tender strips of premium chicken breast, each piece is meticulously marinated in a zesty blend of tangy citrus juices and aromatic herbs. Infused with the essence of fresh lime leaves, this jerky offers a refreshing twist on traditional poultry snacks.','view/assets/home/img/products/khoga1.jpg',60000,1,1),
(N'Khô bò sợi',1,'Savor the rich, hearty flavor of our Khô bò sợi. Made from the finest cuts of premium beef, each strip is meticulously seasoned and slow-dried to perfection, ensuring a tender yet satisfyingly chewy texture that is perfect for any occasion.','view/assets/home/img/products/khobo1.jpg',60000,0,1),
(N'Khô heo cháy tỏi',1,'Indulge in the irresistible fusion of flavors with our Khô heo cháy tỏi. Crafted from premium cuts of pork, each slice is delicately marinated in a robust blend of savory garlic and aromatic spices, then meticulously air-dried to achieve a crispy, satisfying texture.','view/assets/home/img/products/khoheo1.jpg',60000,1,1),
(N'Bánh tráng phơi sương',2,'Bánh tráng phơi sương is a traditional Vietnamese delicacy often enjoyed as a snack or accompaniment to various dishes. Made from a mixture of rice flour, tapioca starch, water, and salt, this translucent rice paper is spread thinly over bamboo mats and left to dry under the morning dew, a process that imparts a unique flavor and texture.','view/assets/home/img/products/banhtrangphoisuong.jpg',30000,1,1),
(N'Bánh tráng phô mai',2,'Bánh tráng phô mai is a delectable Vietnamese treat that combines the crispiness of traditional rice paper with the savory richness of cheese. Made by layering thin sheets of rice paper with a generous sprinkling of finely grated cheese, this snack offers a delightful fusion of textures and flavors.','view/assets/home/img/products/banhtrangphomai.jpg',30000,1,1),
(N'Cơm cháy',3,'Cơm cháy in Vietnamese, is a popular dish that transforms leftover rice into a crispy and flavorful delicacy. To prepare this dish, cooked rice is left to cool and dry out slightly before being shaped into small cakes or patties.','view/assets/home/img/products/comchay.jpg',45000,1,1),
(N'Mực rim me',3,'Mực rim me in Vietnamese, is a flavorful and savory dish that showcases the tender texture of squid paired with the tangy sweetness of tamarind sauce.','view/assets/home/img/products/mucrimme.jpg',60000,1,1),
(N'Trà sữa thái xanh',4,'Trà sữa in Vietnamese, is a beloved beverage enjoyed by many across Vietnam. It is a delightful concoction that combines the rich flavor of black tea with the creaminess of milk, typically served over ice.','view/assets/home/img/products/trasua1thaixanh.jpg',25000,1,2),
(N'Trà sữa khoai môn',4,' in Vietnamese, is a beloved beverage enjoyed by many across Vietnam. It is a delightful concoction that combines the rich flavor of black tea with the creaminess of milk, typically served over ice.','view/assets/home/img/products/trasua2khoaimon.jpg',25000,1,2),
(N'Trà sữa socola',4,' in Vietnamese, is a beloved beverage enjoyed by many across Vietnam. It is a delightful concoction that combines the rich flavor of black tea with the creaminess of milk, typically served over ice.','view/assets/home/img/products/trasua3socola.jpg',25000,1,2),
(N'Trà sữa dâu tây',4,' in Vietnamese, is a beloved beverage enjoyed by many across Vietnam. It is a delightful concoction that combines the rich flavor of black tea with the creaminess of milk, typically served over ice.','view/assets/home/img/products/trasua4dautay.jpg',25000,1,2),
(N'Nước ép vị cam',5,'Nước Ép Cam in Vietnamese, is a classic and refreshing beverage enjoyed throughout Vietnam and around the world. It is made from freshly squeezed oranges, yielding a vibrant and tangy drink that is bursting with flavor and nutrition.','view/assets/home/img/products/THjuicecam.jpg',15000,1,2),
(N'Nước ép vị dâu',5,'Nước Ép Dâu is a delightful and refreshing beverage made from freshly pressed strawberries. This vibrant red juice captures the sweet and tangy essence of ripe strawberries, creating a deliciously fruity drink that is perfect for quenching thirst on a hot day.','view/assets/home/img/products/THjuicedau.jpg',15000,1,2),
(N'Nước ép vị chuối',5,'Nước Ép Chuối is a creamy and delicious beverage made from ripe bananas. This smooth and indulgent juice captures the natural sweetness and creamy texture of bananas, offering a delightful treat for banana lovers.','view/assets/home/img/products/THjuicechuoi.jpg',15000,1,2),
(N'Nước ép việt quất',5,'Nước Ép Việt Quất is a flavorful and refreshing beverage made from ripe blueberries. This vibrant purple juice captures the sweet and tart flavors of blueberries, offering a delightful and nutritious drink.','view/assets/home/img/products/THjuicevietquoc.jpg',15000,1,2),
(N'Cá khô rim',1,'Cá Khô Rim is a traditional Vietnamese dish that combines the intense flavors of dried fish with a rich and aromatic spice blend.','view/assets/home/img/products/cakho.jpg','60000',1,1),
(N'Snack rong biển',3,'Snack Rong Biển is a delicious and nutritious treat made from crispy sheets of roasted seaweed. This popular snack is enjoyed for its unique flavor, satisfying crunch, and health benefits.','view/assets/home/img/products/seaweed.jpg','30000',1,1),
(N'Bánh tráng sa tế',2,'Bánh Tráng Sa Tế is a flavorful and crunchy snack popular in Vietnamese cuisine. Made from rice paper, this snack is seasoned with a spicy and savory mixture, typically including ingredients like chili, garlic, sugar, salt, and sesame seeds.','view/assets/home/img/products/banhtrangsate.jpg','30000',1,1);
