drop database if exists reubica_db;
CREATE SCHEMA IF NOT EXISTS `reubica_db`;
USE `reubica_db` ;

CREATE TABLE IF NOT EXISTS `reubica_db`.`users` (
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `loggedIn` boolean NOT NULL ,
  PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `reubica_db`.`protectora` (
  `idprotectora` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `ciudad` VARCHAR(80) NOT NULL,
  `img` VARCHAR(100) NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `mail` VARCHAR(80) NOT NULL,
  `maps` VARCHAR(100) NULL DEFAULT NULL,
   PRIMARY KEY (`idprotectora`)
    );

CREATE TABLE IF NOT EXISTS `reubica_db`.`perro` (
  `idperro` INT NOT NULL AUTO_INCREMENT,
  `caracter` VARCHAR(999) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `edad` INT NOT NULL,
  `img` VARCHAR(100) NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `protectora_idprotectora` INT NOT NULL,
  `sexo` ENUM("macho", "hembra") NOT NULL,
  `tamano` ENUM("pequeño", "mediano", "grande") NOT NULL,
  PRIMARY KEY (`idperro`),
  FOREIGN KEY (`protectora_idprotectora`)
    REFERENCES `reubica_db`.`protectora` (`idprotectora`)
    );

insert into users(username, password, loggedIn) 
values
("admin@gmail.com", "admin",False);

insert into protectora(nombre,ciudad, descripcion, mail,img)
values
("Adopte","barcelona", "Protectora de animales sin fines de lucro con su objetivo principal fijado en rescatar y reubicar perros en situacion de calle", "info@adopte.com","adopte.webp"),
("Huellas Callejeras","barcelona", "Protectora de animales sin fines de lucro con su objetivo principal fijado en rescatar y reubicar perros en situacion de calle", "info@huellascallejeras.com","huellas.png"),
("Palevlas","barcelona", "Protectora de animales sin fines de lucro con su objetivo principal fijado en rescatar y reubicar perros en situacion de calle", "contacto@palevlas.com","palevlas.png"),
("Protecms","barcelona", "Protectora de animales sin fines de lucro con su objetivo principal fijado en rescatar y reubicar perros en situacion de calle", "hola@protecms.com","protecms.png");


insert into perro(img,nombre,edad,sexo,tamano,caracter,descripcion,protectora_idprotectora)
values
("arif.jpg","arif",5,"hembra","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("asia.jpg","asia",3,"hembra","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("axel.jpg","axel",7,"macho","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("bob.jpg","bob",10,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("boby.jpg","boby",1,"macho","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("braulio.jpg","braulio",1,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("brownie.jpg","brownie",2,"hembra","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("chocachoca.jpg","chocachoca",3,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("donuts.jpg","donuts",8,"macho","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("grace.jpg","grace",9,"hembra","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("heihei.jpg","heihei",19,"hembra","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("ina.jpg","ina",17,"hembra","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("jhon.jpg","jhon",15,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("jose.jpg","jose",12,"macho","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("lulu.jpg","lulu",8,"hembra","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("max.jpg","max",6,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("ramon.jpg","ramon",4,"macho","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("siroko.jpg","siroko",3,"macho","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("tawa.jpg","tawa",2,"hembra","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("vaca.jpg","vaca",1,"hembra","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("amer.png","amer",2,"hembra","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("raul.png","raul",4,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("xena.png","xena",12,"hembra","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",3),
("chococho.webp","chococho",11,"macho","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",4),
("fred.webp","fred",8,"macho","grande","[calmado]","Es un perro tranquilo que rescatado en invierno",1),
("laica.webp","laica",5,"hembra","mediano","[calmado]","Es un perro tranquilo que rescatado en invierno",2),
("laura.webp","laura",3,"hembra","pequeño","[calmado]","Es un perro tranquilo que rescatado en invierno",3);