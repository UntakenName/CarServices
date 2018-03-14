-- begin SERVICES_CUSTOMER
create table SERVICES_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CUSTOMER_TYPE varchar(31),
    --
    NAME varchar(200) not null,
    PHONE varchar(10),
    EMAIL varchar(50),
    --
    primary key (ID)
)^
-- end SERVICES_CUSTOMER
-- begin SERVICES_EMPLOYEE
create table SERVICES_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTH_DATE date not null,
    EMAIL varchar(100),
    SALARY decimal(10, 2) not null,
    CENTER_ID uuid,
    --
    primary key (ID)
)^
-- end SERVICES_EMPLOYEE
-- begin SERVICES_REPAIR
create table SERVICES_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    CENTER_ID uuid,
    EMPLOYEE_ID uuid,
    --
    primary key (ID)
)^
-- end SERVICES_REPAIR
-- begin SERVICES_CITY
create table SERVICES_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    DEFAULT_CITY boolean,
    --
    primary key (ID)
)^
-- end SERVICES_CITY
-- begin SERVICES_CAR_SERVICE_CENTER
create table SERVICES_CAR_SERVICE_CENTER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE varchar(10),
    CITY_ID uuid not null,
    ADDRESS varchar(255) not null,
    --
    primary key (ID)
)^
-- end SERVICES_CAR_SERVICE_CENTER
-- begin SERVICES_CUSTOMER_SERVICE
create table SERVICES_CUSTOMER_SERVICE (
    CENTER_ID uuid,
    CUSTOMER_ID uuid,
    primary key (CENTER_ID, CUSTOMER_ID)
)^
-- end SERVICES_CUSTOMER_SERVICE
-- begin SERVICES_INDIVIDUAL
create table SERVICES_INDIVIDUAL (
    INDIVIDUAL_ID uuid,
    --
    PASSPORT_NO varchar(10) not null,
    --
    primary key (INDIVIDUAL_ID)
)^
-- end SERVICES_INDIVIDUAL
-- begin SERVICES_COMPANY
create table SERVICES_COMPANY (
    CUSTOMER_ID uuid,
    --
    INN varchar(12) not null,
    --
    primary key (CUSTOMER_ID)
)^
-- end SERVICES_COMPANY
