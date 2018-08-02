CREATE TABLE account (
  id bigint NOT NULL ,
  username varchar(100) NOT NULL,
  password varchar(200) NOT NULL,
  email varchar(200) NOT NULL,
  enabled boolean NOT NULL DEFAULT '1',
  credentialsexpired boolean NOT NULL DEFAULT '0',
  expired boolean NOT NULL DEFAULT '0',
  locked boolean NOT NULL DEFAULT '0',
  version int NOT NULL,
  createdBy varchar(100) NOT NULL,
  createdAt timestamp NOT NULL,
  updatedBy varchar(100) DEFAULT NULL,
  updatedAt timestamp DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE role (
  id bigint NOT NULL,
  code varchar(50) NOT NULL,
  label varchar(100) NOT NULL,
  ordinal int NOT NULL,
  effectiveAt timestamp NOT NULL,
  expiresAt timestamp DEFAULT NULL,
  createdAt timestamp NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE account_role (
  account_id bigint NOT NULL,
  role_id bigint NOT NULL,
  PRIMARY KEY (account_id,role_id),
  CONSTRAINT FK_AccountRole_AccountId FOREIGN KEY (account_id) REFERENCES account (id),
  CONSTRAINT FK_AccountRole_RoleId FOREIGN KEY (role_id) REFERENCES role (id)
);
