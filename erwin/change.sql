alter table owcake.tt_comment add column PRODUCT_ID int(11);
alter table owcake.tt_comment add column rate smallint;     

alter table tt_delivery change column type deliver_method smallint;  
alter table tt_delivery change column receive_time deliver_date date;
alter table tt_delivery add column deliver_time varchar(30);   

alter table tt_order add column pay_method smallint;      

alter table tm_user add column role smallint;
CREATE TABLE TT_NEWS
(
	MEDIA_ID             VARCHAR(50)  NOT NULL,
	title                VARCHAR(50) NULL,
	digest               VARCHAR(100) NULL,
	url                  VARCHAR(200) NULL,
	content              TEXT NULL,
	created_on           DATETIME NULL,
	updated_on           DATETIME NULL,
	type                 SMALLINT NULL,
	PRIMARY KEY (MEDIA_ID)
);
CREATE UNIQUE INDEX XPKTT_NEWS ON TT_NEWS
(
	MEDIA_ID ASC
);