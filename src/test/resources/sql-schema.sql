drop table `item`; 
drop table `order`;
drop table `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `item` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` float DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `order`(
`order_item` VARCHAR(40) DEFAULT NULL,
`order_no` INT(11) NOT NULL AUTO_INCREMENT,
`item_quantity` INT(11) DEFAULT NULL,
`order_id` INT(11) DEFAULT '0' NOT NULL,
 PRIMARY KEY (`order_no`),
 FOREIGN KEY (`order_id`) references `customers`(`id`) ON DELETE CASCADE
 );