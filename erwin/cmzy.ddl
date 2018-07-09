
CREATE TABLE TT_CUSTOMER
(
	CUSTOMER_ID          INTEGER NOT NULL AUTO_INCREMENT,
	NAME                 VARCHAR(20) NULL,
	PHONE                VARCHAR(20) NULL,
	AREA                 VARCHAR(20) NULL,
	LEVEL                VARCHAR(20) NULL,
	PRIMARY KEY (CUSTOMER_ID)
);

CREATE TABLE TT_DESIGNER
(
	DESIGNER_ID          INTEGER NOT NULL AUTO_INCREMENT,
	NAME                 VARCHAR(20) NULL,
	ORDER_NUM            INTEGER NULL,
	PHOTO                VARCHAR(200) NULL,
	DESCRIPTION          VARCHAR(200) NULL,
	PHOTO_DETAIL         VARCHAR(200) NULL,
	CREATE_ON            DATETIME NULL,
	CREATE_BY            VARCHAR(20) NULL,
	UPDATE_ON            DATETIME NULL,
	UPDATE_BY            VARCHAR(20) NULL,
	PRIMARY KEY (DESIGNER_ID)
);

CREATE TABLE TT_FITMENT
(
	FITMENT_ID           INTEGER NOT NULL AUTO_INCREMENT,
	COVER_URL            VARCHAR(200) NULL,
	CLASSIFY             SMALLINT NULL,
	LABEL                VARCHAR(20) NULL,
	PRIMARY KEY (FITMENT_ID)
);

CREATE TABLE TT_FITMENT_DETAIL
(
	FITMENT_DETAIL_ID    INTEGER NOT NULL AUTO_INCREMENT,
	IMG_URL              VARCHAR(200) NULL,
	FITMENT_ID           INTEGER NOT NULL,
	PRIMARY KEY (FIEMENT_DETAIL_ID)
);

CREATE TABLE TT_WORK
(
	WORK_ID              INTEGER NOT NULL AUTO_INCREMENT,
	IMG_URL              VARCHAR(200) NULL,
	DESIGNER_ID          INTEGER NOT NULL,
	IS_COVER             boolean NULL,
	PRIMARY KEY (WORK_ID)
);

CREATE TABLE TT_WORKER
(
	WORKER_ID            INTEGER NOT NULL AUTO_INCREMENT,
	IMG_URL              VARCHAR(100) NULL,
	PRIMARY KEY (WORKER_ID)
);

ALTER TABLE TT_FITMENT_DETAIL
ADD FOREIGN KEY R_C_2 (FITMENT_ID) REFERENCES TT_FITMENT (FITMENT_ID);

ALTER TABLE TT_WORK
ADD FOREIGN KEY R_C_1 (DESIGNER_ID) REFERENCES TT_DESIGNER (DESIGNER_ID);


alter table owcake.tt_designer modify column photo varchar(200) comment  '头像';
alter table owcake.tt_designer modify column description varchar(200) comment  '描述';
alter table owcake.tt_designer modify column photo_detail varchar(200) comment  '设计师详情';

alter table owcake.tt_work modify column img_url varchar(200) comment  '作品';
alter table owcake.tt_work modify column designer_id int(11) comment  '设计师id';
alter table owcake.tt_work modify column is_cover tinyint(1) comment  '是否封面';

alter table owcake.tt_fitment modify column classify smallint(1) comment  '1工裝，2家裝，3案例 4工地';
