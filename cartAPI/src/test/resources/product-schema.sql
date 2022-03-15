DROP TABLE IF EXISTS `product` CASCADE;
CREATE TABLE `product` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT, 
	`title` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255),
	`price` DECIMAL(5, 2) CHECK (price<=10000 AND price>=1), 
	`in_stock` BOOLEAN
);