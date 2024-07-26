create database superMarket_Database;
use superMarket_Database;

-- create table for items details
use superMarket_Database;
create table itemsDetails(
item_ID int not null primary key,
item_name varchar(30) not null,
item_type int not null,
quantity int not null default 0,
rate_per_piece Decimal(10,2)  not null  default 0.00,
expiry_date date not null,
total_amount Decimal(10,2)  not null  default 0.00
 );
-- drop table itemsDetails;

-- create table for buyer details of supermarket
use superMarket_Database;
create table buyersDetails(
buyer_Id int not null auto_increment primary key,
buyer_name varchar(30) not null,
mobile_no bigint not null,
email_id varchar(25) null,
payment_type varchar(15) not null,
date_time datetime not null,
item_ID int not null ,  -- add foreign key here in this column
quantity int not null,
rate_per_piece Decimal(10,2)  not null  default 0.00,
total_amount Decimal(10,2)  not null  default 0.00,
discount int default 0,
foreign key(item_ID) references itemsdetails (item_ID)
);

-- create table for add stock details of supermarket (where comes and history of stock)
use superMarket_Database;
create table newStock(
 item_ID int not null,
 item_name varchar(30) not null,
 item_type varchar(20) not null primary key,
 quantity int not null ,
 rate_per_piece Decimal(10,2)  not null  default 0.00,
 expiry_date date not null,
 date_time date not null,
 total_amount Decimal(10,2)  not null  default 0.00
 foreign key(item_type) references itemTypeTable (item_type_ID)
);

-- create table for item type details of supermarket (grocery, electroinces)
use superMarket_Database;
create table itemTypeTable(
 item_type_ID varchar(20) not null primary key,
  item_name_type varchar(30) not null,
 item_insert_date date not null,
 insert_by varchar(20) not null,
--foreign key(item_type_ID) references newStock (item_type)
);


-- create table for user and admin data details of supermarket 
use superMarket_Database;
create table adminUserDetails(
  serial_no int not null auto_increment primary key,
  username varchar(30) not null unique key,
  full_name varchar(20) not null,
  email_Id varchar(20) not null unique key,
  mobile_no bigint(10) not null unique key,
  address varchar(40) not null,
  date_time datetime not null,
  user_type varchar(20) not null
);