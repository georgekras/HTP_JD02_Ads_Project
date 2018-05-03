-- -----------------------------------------------------
-- Data for table `krasutski`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `krasutski`;
INSERT INTO `krasutski`.`roles` (`ID`, `Role`) VALUES (1, 'Administrator');
INSERT INTO `krasutski`.`roles` (`ID`, `Role`) VALUES (2, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `krasutski`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `krasutski`;
INSERT INTO `krasutski`.`users` (`ID`, `Login`, `Password`, `Email`, `Nickname`, `PhoneNumber`, `roles_ID`) VALUES (1, 'admin', 'admin', 'admin@it.by', 'Administrator', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `krasutski`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `krasutski`;
INSERT INTO `krasutski`.`category` (`ID`, `Name`) VALUES (1, 'Smartphone');
INSERT INTO `krasutski`.`category` (`ID`, `Name`) VALUES (2, 'Laptop');
INSERT INTO `krasutski`.`category` (`ID`, `Name`) VALUES (3, 'TV');
INSERT INTO `krasutski`.`category` (`ID`, `Name`) VALUES (4, 'Console');
INSERT INTO `krasutski`.`category` (`ID`, `Name`) VALUES (5, 'Games');

COMMIT;