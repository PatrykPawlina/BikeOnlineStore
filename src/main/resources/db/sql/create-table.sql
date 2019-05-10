DROP TABLE BIKES IF EXISTS;

CREATE TABLE BIKES
(
    ID             VARCHAR(25) PRIMARY KEY,
    NAME           VARCHAR(50),
    DESCRIPTION    VARCHAR(1000),
    UNIT_PRICE     DECIMAL,
    MANUFACTURER   VARCHAR(50),
    CATEGORY       VARCHAR(50),
    CONDITION      VARCHAR(50),
    UNITS_IN_STOCK BIGINT,
    UNITS_IN_ORDER BIGINT,
    DISCONTINUED   BOOLEAN
);
