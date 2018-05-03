-- Дамп структуры базы данных car_catalog
CREATE DATABASE IF NOT EXISTS `car_catalog`
USE `car_catalog`;

-- Дамп структуры для таблица car_catalog.brands_car
CREATE TABLE IF NOT EXISTS `brands_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.cars
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandID` int(11) NOT NULL DEFAULT '0',
  `modelID` int(11) NOT NULL DEFAULT '0',
  `carClass` varchar(50) NOT NULL DEFAULT '0',
  `minPrice` int(11) NOT NULL DEFAULT '0',
  `maxPrice` int(11) NOT NULL DEFAULT '0',
  `userID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_cars_brand` (`brandID`),
  KEY `fk_cars_model` (`modelID`),
  CONSTRAINT `fk_cars_brand` FOREIGN KEY (`brandID`) REFERENCES `brands_car` (`id`),
  CONSTRAINT `fk_cars_model` FOREIGN KEY (`modelID`) REFERENCES `models_car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.models_car
CREATE TABLE IF NOT EXISTS `models_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandID` int(11) NOT NULL DEFAULT '0',
  `model` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_models_brands` (`brandID`),
  CONSTRAINT `fk_models_brands` FOREIGN KEY (`brandID`) REFERENCES `brands_car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_roles_idx` (`roleID`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`roleID`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.favorites
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL DEFAULT '0',
  `carID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_favorites_user` (`userID`),
  KEY `fk_favorites_car` (`carID`),
  CONSTRAINT `fk_favorites_car` FOREIGN KEY (`carID`) REFERENCES `cars` (`id`),
  CONSTRAINT `fk_favorites_user` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_catalog.brands_car
INSERT INTO `brands_car` (`id`, `brand`) VALUES
  (1, 'Audi'),
  (2, 'BMW'),
  (3, 'Chevrolet'),
  (4, 'Citroen'),
  (5, 'Ford'),
  (6, 'Geely'),
  (7, 'Honda\r\n'),
  (8, 'Hyundai'),
  (9, 'KIA');

-- Дамп данных таблицы car_catalog.models_car
INSERT INTO `models_car` (`id`, `brandID`, `model`) VALUES
  (1, 1, 'A3 Sportback'),
  (2, 1, 'A4 седан'),
  (3, 1, 'A4 универсал'),
  (4, 2, '3 серия седан'),
  (5, 2, '5 серия седан'),
  (6, 2, 'M5 седан'),
  (7, 3, 'Cruze седан'),
  (8, 3, 'Captiva'),
  (9, 3, 'Orlando');

-- Дамп данных таблицы car_catalog.roles
INSERT INTO `roles` (`id`, `role`) VALUES
  (1, 'admin'),
  (2, 'user');

-- Дамп данных таблицы car_catalog.users
INSERT INTO `users` (`id`, `login`, `email`, `password`, `roleID`) VALUES
  (1, 'admin', 'admin@gmail.com', 'admin', 1),
  (2, 'user', 'user@gmail.com', 'user', 2);