DROP TABLE IF EXISTS CREDIT_CARDS;
CREATE TABLE CREDIT_CARDS(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(80) NOT NULL,
    CREATION_DATE DATE,
    CARD_TYPE VARCHAR(80),
    MINIMUM_AGE INTEGER NOT NULL,
    MAXIMUM_AGE INTEGER NOT NULL,
    MINIMUM_INCOME INTEGER NOT NULL,
    MAXIMUM_INCOME INTEGER,
    BENEFITS VARCHAR(512) NOT NULL,
    CREDIT_CARD_ANNUITY INTEGER NOT NULL,
    PASSIONS VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);