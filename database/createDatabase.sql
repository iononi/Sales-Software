CREATE DATABASE `restaurante`;

CREATE TABLE `categorias` (
  `ID_Categoria` int NOT NULL AUTO_INCREMENT,
  `Categoria` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_Categoria`)
);

CREATE TABLE `cocineros` (
  `ID_Cocinero` varchar(5) NOT NULL,
  `Nombre_Cocinero` varchar(30) DEFAULT NULL,
  `ApellidoP` varchar(30) DEFAULT NULL,
  `ApellidoM` varchar(30) DEFAULT NULL,
  `Turno` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID_Cocinero`)
);

CREATE TABLE `mesa` (
  `ID_Mesa` int NOT NULL AUTO_INCREMENT,
  `Num_Comensales` int DEFAULT NULL,
  `Ubicacion` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`ID_Mesa`)
);

CREATE TABLE `meseros` (
  `ID_Mesero` varchar(5) NOT NULL,
  `Nombre_Mesero` varchar(30) DEFAULT NULL,
  `ApellidoP` varchar(30) DEFAULT NULL,
  `ApellidoM` varchar(30) DEFAULT NULL,
  `Turno` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID_Mesero`)
);

CREATE TABLE `clientes` (
  `ID_Cliente` int NOT NULL AUTO_INCREMENT,
  `Nombre_Cliente` varchar(30) DEFAULT NULL,
  `ApellidoP` varchar(30) DEFAULT NULL,
  `ApellidoM` varchar(30) DEFAULT NULL,
  `Observaciones` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_Cliente`)
);

CREATE TABLE `platillos` (
  `ID_Platillo` int NOT NULL AUTO_INCREMENT,
  `Platillo` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  `Imagen` varchar(150) DEFAULT NULL,
  `R_Categoria` int DEFAULT NULL,
  PRIMARY KEY (`ID_Platillo`),
  KEY `R_Categoria` (`R_Categoria`),
  CONSTRAINT `platillos_ibfk_1` FOREIGN KEY (`R_Categoria`) REFERENCES `categorias` (`ID_Categoria`)
);

CREATE TABLE `factura` (
  `ID_Factura` int NOT NULL AUTO_INCREMENT,
  `R_Cliente` int DEFAULT NULL,
  `R_Mesero` varchar(5) DEFAULT NULL,
  `R_Mesa` int DEFAULT NULL,
  `Fecha_Factura` date DEFAULT NULL,
  PRIMARY KEY (`ID_Factura`),
  KEY `ID_Cliente_idx` (`R_Cliente`),
  KEY `ID_Mesero_idx` (`R_Mesero`),
  KEY `ID_Mesa_idx` (`R_Mesa`),
  CONSTRAINT `ID_Cliente` FOREIGN KEY (`R_Cliente`) REFERENCES `clientes` (`ID_Cliente`),
  CONSTRAINT `ID_Mesa` FOREIGN KEY (`R_Mesa`) REFERENCES `mesa` (`ID_Mesa`),
  CONSTRAINT `ID_Mesero` FOREIGN KEY (`R_Mesero`) REFERENCES `meseros` (`ID_Mesero`)
);

CREATE TABLE `detallefactura` (
  `ID_Orden` int NOT NULL AUTO_INCREMENT,
  `R_Factura` int DEFAULT NULL,
  `R_Platillo` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  PRIMARY KEY (`ID_Orden`),
  KEY `ID_Factura_idx` (`R_Factura`),
  KEY `ID_Platillo` (`R_Platillo`),
  CONSTRAINT `ID_Factura` FOREIGN KEY (`R_Factura`) REFERENCES `factura` (`ID_Factura`),
  CONSTRAINT `ID_Platillo` FOREIGN KEY (`R_Platillo`) REFERENCES `platillos` (`ID_Platillo`)
);
