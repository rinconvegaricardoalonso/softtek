CREATE TABLE `softtek`.`proveedor` (
  `idproveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `identificacion` VARCHAR(10) NULL,
  `direccion` VARCHAR(255) NULL,
  `correo` VARCHAR(50) NULL,
  `disponibilidad` INT NULL,
  PRIMARY KEY (`idproveedor`));