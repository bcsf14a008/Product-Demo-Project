CREATE TABLE product_schema.product (
	product_code uuid NOT NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_code)
);