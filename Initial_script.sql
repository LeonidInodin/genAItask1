CREATE DATABASE IF NOT EXISTS store;
USE store;
CREATE TABLE item( 
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description VARCHAR(1000) NOT NULL,
price DECIMAL(10, 2) NOT NULL,
quantity int NOT null
);
INSERT INTO item (id, name, description, price, quantity) VALUES
(1, 'Hammer', 'A durable and versatile tool for various tasks.', 19.99, 50),
(2, 'Screwdriver Set', 'A set of precision screwdrivers for different types of screws.', 14.95, 30),
(3, 'Paint Rollers', 'High-quality paint rollers for smooth and even painting.', 8.75, 75),
(4, 'Power Drill', 'Cordless power drill with multiple speed settings.', 79.99, 20),
(5, 'Adjustable Wrench', 'A versatile wrench for adjusting nuts and bolts.', 12.50, 40),
(6, 'Extension Cord', 'Extra-long extension cord for increased reach.', 15.25, 60),
(7, 'Safety Goggles', 'Protective goggles for eye safety during work.', 5.99, 100),
(8, 'Measuring Tape', 'Durable measuring tape for accurate measurements.', 9.50, 25),
(9, 'Pliers Set', 'A set of different pliers for various tasks.', 18.49, 35),
(10, 'Cordless Screwdriver', 'Compact cordless screwdriver with rechargeable battery.', 29.99, 15);
