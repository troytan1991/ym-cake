alter table owcake.tt_comment add column PRODUCT_ID int(11);
alter table owcake.tt_comment add column rate smallint;     

alter table tt_delivery change column type deliver_method smallint;  
alter table tt_delivery change column receive_time deliver_date date;
alter table tt_delivery add column deliver_time varchar(30);         