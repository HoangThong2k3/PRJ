SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `SnackFood` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


USE `SnackFood`;
CREATE TABLE User (
          `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID, tự động tăng',
          `first_name` NVARCHAR(30) NOT NULL    COMMENT 'tên',
          `last_name` NVARCHAR(30) NOT NULL     COMMENT 'họ',
          `avatar` varchar(200) NOT NULL       COMMENT 'ảnh (img)',
          `email` NVARCHAR(50) NOT NULL        COMMENT 'email',
          `username` VARCHAR(30) NOT NULL      COMMENT 'username để đăng nhập',
          `password` VARCHAR(64) NOT NULL      COMMENT 'password (hash bằng...)',
          `address` NVARCHAR(200) NOT NULL     COMMENT 'địa chỉ để nhận ship',
          `phone` NVARCHAR(15) NOT NULL        COMMENT 'số điện thoại để nhận ship',
          `role_id` INT NOT NULL                COMMENT 'admin/user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE Types(
          `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT 'loại sản phẩm, ví dụ 1 là đồ ăn, 2 là thức uống',
          `name` NVARCHAR(100)                          COMMENT 'đồ ăn/thức uống/...'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE Categories(
          `category_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'loại đồ ăn/thức uống, ví dụ 1 là khô gà, 2 bánh tráng,...',
          `category_name` NVARCHAR(30)                          COMMENT 'khô gà/bánh tráng/trà sữa/...',
          `type_id` INT                                        COMMENT 'chẳng hạn category_id = 1 là khô gà -> typeid = 1, category_id = 3 là trà sữa -> type id = 2',
          FOREIGN KEY (type_id) REFERENCES Types(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE Products(
          `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT 'ID sản phẩm',
          `product_name` NVARCHAR(30) NOT NULL           COMMENT 'tên sản phẩm',
          `category_id` INT                              COMMENT 'tên thể loại sản phẩm',
          `description` NVARCHAR(500)                    COMMENT 'comment',
          `images` VARCHAR(255) NOT NULL                COMMENT 'ảnh sản phẩm',
          `price` DECIMAL(10,2) NOT NULL                COMMENT 'giá sản phẩm',
          `status` bit not null                         COMMENT 'còn hay hết',
          `type_id` INT                                  COMMENT 'loại sản phẩm (đồ ăn/thức uống/...)',
          FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE SET NULL ON UPDATE CASCADE,
          FOREIGN KEY (type_id) REFERENCES Types(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE Payments(
          `payment_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID của kiểu giao dịch',
          `payment_method` NVARCHAR(30)                       COMMENT 'trả tiền mặt/chuyển khoảng bằng...'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE Orders(
          `order_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID của đơn hàng',
          `order_date` DATETIME                               COMMENT 'ngày order',
          `total_price` DECIMAL(10,2)                         COMMENT 'tổng tiền',
          `payment_id` INT NOT NULL                           COMMENT 'ID của kiểu giao dịch',
          `user_id` INT NOT NULL                             COMMENT 'ID của người dùng',
          `status` bit NOT NULL                              COMMENT 'Đã giao hay chưa giao, status',
          FOREIGN KEY (payment_id) REFERENCES Payments(payment_id),
          FOREIGN KEY (user_id) REFERENCES User(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE OrderItem(
          `order_item_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'không biết giải thích sao :D',
          `quantity` INT                                          COMMENT 'số lượng item order',
          `price` DECIMAL(10,2)                                   COMMENT 'tổng giá của đống item đó',
          `product_id` INT NOT NULL                               COMMENT 'ID của sản phẩm',
          `order_id` INT NOT NULL                                 COMMENT 'ID của order',
          FOREIGN KEY (product_id) REFERENCES Products(id) ON DELETE CASCADE,
          FOREIGN KEY (order_id) REFERENCES Orders(order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
