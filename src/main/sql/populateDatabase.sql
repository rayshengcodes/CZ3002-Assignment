/* Create database */
create database `ase-assignment`;

/* Create table */
CREATE TABLE `ase-assignment`.`Login` (
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`username`));

/* Populating the value from database*/
INSERT INTO `ase-assignment`.`login` (`username`, `password`) VALUES ('adam',  'steve');
INSERT INTO `ase-assignment`.`login` (`username`, `password`) VALUES ('root', 'admin');
INSERT INTO `ase-assignment`.`login` (`username`, `password`) VALUES ('test', 'test2');
INSERT INTO `ase-assignment`.`login` (`username`, `password`) VALUES ('abram',  'aben');

/** Template to add more records (Specify the values in the brackets) */
INSERT INTO `ase-assignment`.`login` (`username`, `password`) VALUES (``, ``)


/* Show all login info */
Select * from `ase-assignment`.`login`;
