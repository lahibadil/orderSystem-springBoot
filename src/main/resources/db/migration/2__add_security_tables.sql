CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `referenceId` varchar(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `credentialsexpired` tinyint(1) NOT NULL DEFAULT '0',
  `expired` tinyint(1) NOT NULL DEFAULT '0',
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  `version` int(11) NOT NULL,
  `createdBy` varchar(100) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedBy` varchar(100) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_Account_ReferenceId` (`referenceId`),
  UNIQUE KEY `UQ_Account_Username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) NOT NULL,
  `label` varchar(100) NOT NULL,
  `ordinal` int(11) NOT NULL,
  `effectiveAt` datetime NOT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_Role_Code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `accountrole` (
  `accountId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`accountId`,`roleId`),
  KEY `FK_AccountRole_RoleId` (`roleId`),
  CONSTRAINT `FK_AccountRole_AccountId` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`),
  CONSTRAINT `FK_AccountRole_RoleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
