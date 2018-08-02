CREATE TABLE shippers (
  shipper_id bigint NOT NULL,
  companyName varchar(255) DEFAULT NULL,
  PRIMARY KEY (shipper_id)
);

CREATE TABLE shipper_contacts (
  shipper_id bigint NOT NULL,
  contactName varchar(255) DEFAULT NULL,
  contactJobTitle varchar(255) NOT NULL,
  PRIMARY KEY (shipper_id,contactJobTitle),
  CONSTRAINT FK_fsy5ejb1nq7oifedyw7qmupmd FOREIGN KEY (shipper_id) REFERENCES shippers (shipper_id)
) ;

CREATE TABLE suppliers (
  supplier_id bigint NOT NULL,
  city varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  line1 varchar(255) DEFAULT NULL,
  line2 varchar(255) DEFAULT NULL,
  zip varchar(255) DEFAULT NULL,
  companyName varchar(255) DEFAULT NULL,
  contactName varchar(255) DEFAULT NULL,
  contactJobTitle varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  fax varchar(10) DEFAULT NULL,
  phoneMobile varchar(10) DEFAULT NULL,
  phoneOffice varchar(10) DEFAULT NULL,
  PRIMARY KEY (supplier_id)
);

CREATE TABLE products(
  product_id bigint NOT NULL,
  buyUnitPrice decimal(19,2) DEFAULT NULL,
  productCode varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  reorderLevel int DEFAULT NULL,
  suggestedUnitPrice decimal(19,2) DEFAULT NULL,
  unitsInStock int DEFAULT NULL,
  unitsOnOrder int DEFAULT NULL,
  PRIMARY KEY (product_id)
) ;

CREATE TABLE product_suppliers (
  product_id bigint NOT NULL,
  supplier_id bigint NOT NULL,
  CONSTRAINT FK_m5c8fbl3n4s6da0ydxq272lau FOREIGN KEY (product_id) REFERENCES products (product_id),
  CONSTRAINT FK_rq5ytrabidf76skjerqafve7h FOREIGN KEY (supplier_id) REFERENCES suppliers (supplier_id)
) ;

CREATE TABLE employees (
  employee_id bigint NOT NULL,
  city varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  line1 varchar(255) DEFAULT NULL,
  line2 varchar(255) DEFAULT NULL,
  zip varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  firstName varchar(255) DEFAULT NULL,
  jobTitle varchar(255) DEFAULT NULL,
  lastName varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  reportsTo bigint DEFAULT NULL,
  PRIMARY KEY (employee_id),
  CONSTRAINT FK_jsrfhxraxneam0gtuo58po1d1 FOREIGN KEY (reportsTo) REFERENCES employees (employee_id)
) ;

CREATE TABLE customers (
  customer_id bigint NOT NULL,
  city varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  line1 varchar(255) DEFAULT NULL,
  line2 varchar(255) DEFAULT NULL,
  zip varchar(255) DEFAULT NULL,
  company varchar(255) DEFAULT NULL,
  fax varchar(10) DEFAULT NULL,
  phoneMobile varchar(10) DEFAULT NULL,
  phoneOffice varchar(10) DEFAULT NULL,
  PRIMARY KEY (customer_id)
) ;

CREATE TABLE costumer_contacts (
  customer_id bigint NOT NULL,
  contactName varchar(255) DEFAULT NULL,
  contactJobTitle varchar(255) NOT NULL,
  PRIMARY KEY (customer_id,contactJobTitle),
  CONSTRAINT FK_rll46cxdfe91om3c9kaciv3f4 FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
) ;

CREATE TABLE orders (
  order_id bigint NOT NULL,
  orderDate timestamp DEFAULT NULL,
  orderStatus varchar(255) DEFAULT NULL,
  requiredDtae timestamp DEFAULT NULL,
  shipToCity varchar(255) DEFAULT NULL,
  shipToCountry varchar(255) DEFAULT NULL,
  shipToLine1 varchar(255) DEFAULT NULL,
  shipToLine2 varchar(255) DEFAULT NULL,
  shipToZip varchar(255) DEFAULT NULL,
  shipToName varchar(255) DEFAULT NULL,
  shipDate timestamp DEFAULT NULL,
  customer_id bigint NOT NULL,
  employee_id bigint DEFAULT NULL,
  shipper_id bigint DEFAULT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT FK_astys1dv61mdlp0n0wx0574r2 FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
  CONSTRAINT FK_hmrgh9qfuadey4iavtus8lrd3 FOREIGN KEY (employee_id) REFERENCES employees (employee_id),
  CONSTRAINT FK_lux2vpxrc0cm00uelve1fyovm FOREIGN KEY (shipper_id) REFERENCES shippers (shipper_id)
) ;

CREATE TABLE orderlines (
  order_id bigint NOT NULL,
  product_id bigint NOT NULL,
  lineNumber int DEFAULT NULL,
  quantity int DEFAULT NULL,
  unitPrice decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (order_id,product_id),
  CONSTRAINT FK_g0ucodlwd9ft2f4x20uo3xorw FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT FK_i5to8w4qcdy7k77q11m787ewa FOREIGN KEY (product_id) REFERENCES products (product_id)
) ;

CREATE TABLE invoices (
  invoice_id bigint NOT NULL,
  invoiceDate timestamp DEFAULT NULL,
  orderStatus varchar(255) DEFAULT NULL,
  order_id bigint NOT NULL,
  PRIMARY KEY (invoice_id),
  CONSTRAINT FK_gnfabg6rvhoc3c9o4deqb1hn4 FOREIGN KEY (order_id) REFERENCES orders (order_id)
) ;

CREATE TABLE invoicelines (
  invoice_id bigint NOT NULL,
  product_id bigint NOT NULL,
  lineNumber int DEFAULT NULL,
  unitPrice decimal(19,2) DEFAULT NULL,
  unitsShipped int DEFAULT NULL,
  PRIMARY KEY (invoice_id,product_id),
  CONSTRAINT FK_fpwkr0iaja953wr2sygamqwe5 FOREIGN KEY (invoice_id) REFERENCES invoices (invoice_id),
  CONSTRAINT FK_ij00c1dvxwv2ybb6mfcoy509v FOREIGN KEY (product_id) REFERENCES products (product_id)
) ;

CREATE TABLE payments (
  payment_id bigint NOT NULL,
  amount decimal(19,2) DEFAULT NULL,
  checkNumber varchar(255) DEFAULT NULL,
  payementDate timestamp DEFAULT NULL,
  order_id bigint DEFAULT NULL,
  PRIMARY KEY (payment_id),
  CONSTRAINT FK_mf7n8wo2rwrxsd6f3t9ub2mep FOREIGN KEY (order_id) REFERENCES orders (order_id)
) ;
