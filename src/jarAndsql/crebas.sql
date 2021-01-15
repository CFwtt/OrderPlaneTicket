/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2021/1/13 9:20:07                            */
/*==============================================================*/


alter table customer_order
   drop constraint FK_CUSTOMER_REFERENCE_CUSTOMER;

alter table customer_order
   drop constraint FK_CUSTOMER_REFERENCE_ORDERS;

alter table dict
   drop constraint FK_DICT_REFERENCE_FLIGHT;

alter table dictitem
   drop constraint FK_DICTITEM_REFERENCE_DICT;

alter table orders
   drop constraint FK_ORDERS_REFERENCE_FLIGHT;

drop table customer cascade constraints;

drop table customer_order cascade constraints;

drop table dict cascade constraints;

drop table dictitem cascade constraints;

drop table flight cascade constraints;

drop table orders cascade constraints;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer  (
   customer_id          VARCHAR2(32)                    not null,
   customer_type        VARCHAR2(10),
   name                 VARCHAR2(20),
   phone                VARCHAR2(20),
   card_id              VARCHAR2(18),
   birthday             DATE,
   constraint PK_CUSTOMER primary key (customer_id)
);

/*==============================================================*/
/* Table: customer_order                                        */
/*==============================================================*/
create table customer_order  (
   customer_id          VARCHAR2(32),
   order_id             VARCHAR2(32)
);

/*==============================================================*/
/* Table: dict                                                  */
/*==============================================================*/
create table dict  (
   dict_id              VARCHAR2(32)                    not null,
   id                   VARCHAR2(32),
   DICT_NAME            VARCHAR2(32),
   DICT_CODE            VARCHAR2(32),
   constraint PK_DICT primary key (dict_id)
);

/*==============================================================*/
/* Table: dictitem                                              */
/*==============================================================*/
create table dictitem  (
   itemID               VARCHAR2(32£©                    not null,
   dict_id              VARCHAR2(32),
   DITEM_VALUE          VARCHAR2(32),
   constraint PK_DICTITEM primary key (itemID)
);

/*==============================================================*/
/* Table: flight                                                */
/*==============================================================*/
create table flight  (
   id                   VARCHAR2(32)                    not null,
   flight_id            VARCHAR2(32)                    not null,
   plane_type           VARCHAR2(20),
   total_seats_num      NUMBER(3),
   departure_airport    VARCHAR2(30),
   destination_airport  VARCHAR2(30),
   departure_time       VARCHAR2(20),
   constraint PK_FLIGHT primary key (id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders  (
   order_id             VARCHAR2(32)                    not null,
   id                   VARCHAR2(32),
   jpjg                 NUMBER(7,2),
   air_port_tax         NUMBER(7,2),
   ryf                  NUMBER(7,2),
   hkzhx                NUMBER(7,2),
   jptgx                NUMBER(7,2),
   yhq                  NUMBER(7,2),
   hszj                 NUMBER(7,2),
   constraint PK_ORDERS primary key (order_id)
);

alter table customer_order
   add constraint FK_CUSTOMER_REFERENCE_CUSTOMER foreign key (customer_id)
      references customer (customer_id);

alter table customer_order
   add constraint FK_CUSTOMER_REFERENCE_ORDERS foreign key (order_id)
      references orders (order_id);

alter table dict
   add constraint FK_DICT_REFERENCE_FLIGHT foreign key (id)
      references flight (id);

alter table dictitem
   add constraint FK_DICTITEM_REFERENCE_DICT foreign key (dict_id)
      references dict (dict_id);

alter table orders
   add constraint FK_ORDERS_REFERENCE_FLIGHT foreign key (id)
      references flight (id);

