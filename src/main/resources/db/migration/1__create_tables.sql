CREATE TABLE `shippers` (
  `shpper_id` bigint NOT NULL AUTO_INCREMENT,
  `compnayName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shpper_id`)
);

CREATE TABLE `shiper_contacts` (
  `shiper_id` bigint NOT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `contactJobTitle` varchar(255) NOT NULL,
  PRIMARY KEY (`shiper_id`,`contactJobTitle`),
  CONSTRAINT `FK_fsy5ejb1nq7oifedyw7qmupmd` FOREIGN KEY (`shiper_id`) REFERENCES `shipper` (`shpper_id`)
) ;

CREATE TABLE `suppliers` (
  `supplier_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `line1` varchar(255) DEFAULT NULL,
  `line2` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `compnayName` varchar(255) DEFAULT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `contactJobTitle` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(10) DEFAULT NULL,
  `phoneMobile` varchar(10) DEFAULT NULL,
  `phoneOffice` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`),
  UNIQUE KEY `UK_7xjelmr991hpn0lwpgsiex0gm` (`phoneMobile`),
  UNIQUE KEY `UK_coien085l137d7nfem2w9ynk4` (`phoneOffice`)
) ;

CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `buyUnitPrice` decimal(19,2) DEFAULT NULL,
  `productCode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `reorderLevel` int(11) DEFAULT NULL,
  `suggestedUnitPrice` decimal(19,2) DEFAULT NULL,
  `unitsInStock` int(11) DEFAULT NULL,
  `unitsOnOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `productsuppliers` (
  `product_id` bigint NOT NULL,
  `supplier_id` bigint NOT NULL,
  KEY `FK_rq5ytrabidf76skjerqafve7h` (`supplier_id`),
  KEY `FK_m5c8fbl3n4s6da0ydxq272lau` (`product_id`),
  CONSTRAINT `FK_m5c8fbl3n4s6da0ydxq272lau` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_rq5ytrabidf76skjerqafve7h` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employees` (
  `employee_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `line1` varchar(255) DEFAULT NULL,
  `line2` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `reportsTo` bigint DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK_jsrfhxraxneam0gtuo58po1d1` (`reportsTo`),
  CONSTRAINT `FK_jsrfhxraxneam0gtuo58po1d1` FOREIGN KEY (`reportsTo`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customers` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `line1` varchar(255) DEFAULT NULL,
  `line2` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `fax` varchar(10) DEFAULT NULL,
  `phoneMobile` varchar(10) DEFAULT NULL,
  `phoneOffice` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `costumer_contacts` (
  `customer_id` bigint NOT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `contactJobTitle` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`,`contactJobTitle`),
  CONSTRAINT `FK_rll46cxdfe91om3c9kaciv3f4` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `orderDate` datetime DEFAULT NULL,
  `orderStatus` varchar(255) DEFAULT NULL,
  `requiredDtae` datetime DEFAULT NULL,
  `shipToCity` varchar(255) DEFAULT NULL,
  `shipToCountry` varchar(255) DEFAULT NULL,
  `shipToLine1` varchar(255) DEFAULT NULL,
  `shipToLine2` varchar(255) DEFAULT NULL,
  `shipToZip` varchar(255) DEFAULT NULL,
  `shipToName` varchar(255) DEFAULT NULL,
  `shipDate` datetime DEFAULT NULL,
  `customer_id` bigint NOT NULL,
  `employee_id` bigint DEFAULT NULL,
  `shipper_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_astys1dv61mdlp0n0wx0574r2` (`customer_id`),
  KEY `FK_hmrgh9qfuadey4iavtus8lrd3` (`employee_id`),
  KEY `FK_lux2vpxrc0cm00uelve1fyovm` (`shipper_id`),
  CONSTRAINT `FK_astys1dv61mdlp0n0wx0574r2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FK_hmrgh9qfuadey4iavtus8lrd3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK_lux2vpxrc0cm00uelve1fyovm` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shpper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `orderlines` (
  `order_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `lineNumber` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unitPrice` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FK_i5to8w4qcdy7k77q11m787ewa` (`product_id`),
  CONSTRAINT `FK_g0ucodlwd9ft2f4x20uo3xorw` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FK_i5to8w4qcdy7k77q11m787ewa` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `invoices` (
  `invoice_id` bigint NOT NULL AUTO_INCREMENT,
  `invoiceDate` datetime DEFAULT NULL,
  `orderStatus` varchar(255) DEFAULT NULL,
  `order_id` bigint NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `FK_gnfabg6rvhoc3c9o4deqb1hn4` (`order_id`),
  CONSTRAINT `FK_gnfabg6rvhoc3c9o4deqb1hn4` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `invoicelines` (
  `invoice_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `lineNumber` int(11) DEFAULT NULL,
  `unitPrice` decimal(19,2) DEFAULT NULL,
  `unitsShipped` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`,`product_id`),
  KEY `FK_ij00c1dvxwv2ybb6mfcoy509v` (`product_id`),
  CONSTRAINT `FK_fpwkr0iaja953wr2sygamqwe5` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  CONSTRAINT `FK_ij00c1dvxwv2ybb6mfcoy509v` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `payments` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `checkNumber` varchar(255) DEFAULT NULL,
  `payementDate` datetime DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FK_mf7n8wo2rwrxsd6f3t9ub2mep` (`order_id`),
  CONSTRAINT `FK_mf7n8wo2rwrxsd6f3t9ub2mep` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
