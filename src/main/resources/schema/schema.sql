
-- =============================================================================================
-- CA_PRINCIPAL
-- =============================================================================================
CREATE
  TABLE CA_PRINCIPAL
  (
        ID NUMBER NOT NULL,
        NAME VARCHAR2(255) NOT NULL,
        PRINCIPAL_TYPE NUMBER(1) NOT NULL,
        LOCKED NUMBER(1) DEFAULT 0,
        -- METADATA
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
  );

ALTER TABLE CA_PRINCIPAL ADD CONSTRAINT PK_CA_PRINCIPAL PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_PRINCIPAL_NAME ON CA_PRINCIPAL (NAME);

CREATE SEQUENCE SEQ_CA_PRINCIPAL START WITH 11 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_USER
-- =============================================================================================
CREATE
    TABLE CA_USER
    (
        ID NUMBER NOT NULL,
        REALNAME VARCHAR2(100) NOT NULL,
        PASSWORD VARCHAR2(200) NOT NULL,
        CONSUMER_ID NUMBER
    );

ALTER TABLE CA_USER ADD CONSTRAINT PK_CA_USER PRIMARY KEY(ID);

ALTER TABLE CA_USER ADD CONSTRAINT FK_CA_USER_1 FOREIGN KEY (ID) REFERENCES CA_PRINCIPAL (ID);

-- =============================================================================================
-- CA_USER_ROLE
-- =============================================================================================

CREATE
    TABLE CA_USER_ROLE
    (
        ID NUMBER NOT NULL,
        ROLE VARCHAR2(50) NOT NULL,
        USER_ID NUMBER NOT NULL,
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP,
        CONSTRAINT CNT_USER_ROLE UNIQUE (ROLE,USER_ID)
                    USING INDEX (CREATE UNIQUE INDEX IDX_USER_ROLE ON CA_USER_ROLE(ROLE,USER_ID))
    );

ALTER TABLE CA_USER_ROLE ADD CONSTRAINT PK_CA_USER_ROLE PRIMARY KEY(ID);

ALTER TABLE CA_USER_ROLE ADD CONSTRAINT FK_CA_USER_ROLE_1 FOREIGN KEY (USER_ID) REFERENCES CA_USER (ID);

CREATE SEQUENCE SEQ_CA_USER_ROLE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CA_GROUP
-- =============================================================================================
CREATE
    TABLE CA_GROUP
    (
        ID NUMBER NOT NULL
    );

ALTER TABLE CA_GROUP ADD CONSTRAINT PK_CA_GROUP PRIMARY KEY(ID);

ALTER TABLE CA_GROUP ADD CONSTRAINT FK_CA_GROUP_1 FOREIGN KEY (ID) REFERENCES CA_PRINCIPAL (ID);

-- =============================================================================================
-- CA_GROUP_MEMBER
-- =============================================================================================

CREATE
    TABLE CA_GROUP_MEMBER
    (
        ID NUMBER NOT NULL,
        GROUP_ID NUMBER NOT NULL,
        PRINCIPAL_ID NUMBER NOT NULL, -- use principal, it might be user or another group
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP,
        CONSTRAINT CNT_GROUP_MEMBER UNIQUE (GROUP_ID,PRINCIPAL_ID)
                    USING INDEX (CREATE UNIQUE INDEX IDX_GROUP_MEMBER ON CA_GROUP_MEMBER(GROUP_ID,PRINCIPAL_ID))
    );

ALTER TABLE CA_GROUP_MEMBER ADD CONSTRAINT PK_CA_GROUP_MEMBER PRIMARY KEY(ID);

ALTER TABLE CA_GROUP_MEMBER ADD CONSTRAINT FK_CA_GROUP_MEMBER_1 FOREIGN KEY (GROUP_ID) REFERENCES CA_GROUP (ID);

ALTER TABLE CA_GROUP_MEMBER ADD CONSTRAINT FK_CA_GROUP_MEMBER_2 FOREIGN KEY (PRINCIPAL_ID) REFERENCES CA_PRINCIPAL (ID);

CREATE INDEX IDX_CA_GROUP_MEMBER_2 ON CA_GROUP_MEMBER(GROUP_ID);

CREATE INDEX IDX_CA_GROUP_MEMBER_3 ON CA_GROUP_MEMBER(PRINCIPAL_ID);

CREATE SEQUENCE SEQ_CA_GROUP_MEMBER START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CA_GROUP_MEMBER
-- =============================================================================================

CREATE
    TABLE CA_GROUP_ROLE
    (
        ID NUMBER NOT NULL,
        GROUP_ID NUMBER NOT NULL,
        ROLE VARCHAR2(50) NOT NULL,
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP,
        CONSTRAINT CNT_GROUP_ROLE UNIQUE (GROUP_ID,ROLE)
                    USING INDEX (CREATE UNIQUE INDEX IDX_GROUP_ROLE ON CA_GROUP_ROLE(GROUP_ID,ROLE))
    );

ALTER TABLE CA_GROUP_ROLE ADD CONSTRAINT PK_CA_GROUP_ROLE PRIMARY KEY(ID);

ALTER TABLE CA_GROUP_ROLE ADD CONSTRAINT CA_GROUP_ROLE_FK_1 FOREIGN KEY (GROUP_ID) REFERENCES CA_GROUP (ID);

CREATE SEQUENCE SEQ_CA_GROUP_ROLE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CA_CONFIGURATION
-- =============================================================================================

CREATE
    TABLE CA_CONFIGURATION
    (
        ID NUMBER NOT NULL,
        CONFIG_KEY VARCHAR2(255) NOT NULL,
        CONFIG_VALUE VARCHAR2(255),
        DESCRIPTION VARCHAR2(255),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_CONFIGURATION ADD CONSTRAINT PK_CA_CONFIGURATION PRIMARY KEY(ID);

ALTER TABLE CA_CONFIGURATION ADD CONSTRAINT UNQ_CA_CONFIGURATION UNIQUE (CONFIG_KEY);

CREATE SEQUENCE SEQ_CA_CONFIGURATION START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;



-- =============================================================================================
-- CA_FUND
-- =============================================================================================

CREATE
    TABLE CA_FUND
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR2(10) NOT NULL,
        DESCRIPTION VARCHAR2(255),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_FUND ADD CONSTRAINT PK_CA_FUND PRIMARY KEY(ID);

ALTER TABLE CA_FUND ADD CONSTRAINT UNQ_CA_FUND UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_FUND START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;




-- =============================================================================================
-- CA_PROJECT
-- =============================================================================================

CREATE
    TABLE CA_PROJECT
    (
        ID NUMBER NOT NULL,
        PARENT_ID NUMBER,
        CODE VARCHAR2(4) NOT NULL,
        DESCRIPTION VARCHAR2(255),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_PROJECT ADD CONSTRAINT PK_CA_PROJECT PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_PROJECT_CODE ON CA_PROJECT (CODE ASC);

ALTER TABLE CA_PROJECT
ADD CONSTRAINT FK_CA_PROJECT_1 FOREIGN KEY (PARENT_ID) REFERENCES CA_PROJECT (ID);

CREATE SEQUENCE SEQ_CA_PROJECT START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_ACCOUNT
-- 000-0000-00
-- =============================================================================================

CREATE
    TABLE CA_ACCOUNT
    (
    	ID NUMBER NOT NULL,
    	LOCATION_CODE_ID NUMBER NOT NULL,
    	ACCOUNT_CODE_ID NUMBER NOT NULL,
    	PROJECT_CODE_ID NUMBER NOT NULL,
        CODE VARCHAR2(20) NOT NULL,
        DESCRIPTION VARCHAR2(300),
        ALIAS VARCHAR2(100),
        POSTING_TYPE NUMBER(1),
        BALANCE_TYPE NUMBER(1),
        ACCOUNT_TYPE NUMBER(1),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_ACCOUNT ADD CONSTRAINT PK_CA_ACCOUNT PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_ACCOUNT_CODE ON CA_ACCOUNT (CODE ASC);

ALTER TABLE CA_ACCOUNT ADD CONSTRAINT UNQ_CA_ACCOUNT UNIQUE (CODE);

ALTER TABLE CA_ACCOUNT ADD CONSTRAINT FK_CA_ACCOUNT_1 FOREIGN KEY (LOCATION_CODE_ID) REFERENCES CA_LOCATION_CODE(ID);

ALTER TABLE CA_ACCOUNT ADD CONSTRAINT FK_CA_ACCOUNT_2 FOREIGN KEY (ACCOUNT_CODE_ID) REFERENCES CA_ACCOUNT_CODE (ID);

ALTER TABLE CA_ACCOUNT ADD CONSTRAINT FK_CA_ACCOUNT_3 FOREIGN KEY (PROJECT_CODE_ID) REFERENCES CA_PROJECT_CODE (ID);

CREATE SEQUENCE SEQ_CA_ACCOUNT START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CA_FISCAL
-- =============================================================================================

CREATE
    TABLE CA_FISCAL
    (
    	ID NUMBER NOT NULL,
    	ALIAS VARCHAR2(100),
        DESCRIPTION VARCHAR2(255) NOT NULL,
        START_DATE DATE,
        END_DATE DATE,
        ACTIVE NUMBER(1) DEFAULT 0,
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_FISCAL ADD CONSTRAINT PK_CA_FISCAL PRIMARY KEY(ID);

ALTER TABLE CA_FISCAL ADD CONSTRAINT FK_CA_FISCAL_1 FOREIGN KEY (COST_CENTER_ID) REFERENCES CA_COST_CENTER (ID);

CREATE INDEX IDX_CA_FISCAL_COST_CENTER_ID ON CA_FISCAL (COST_CENTER_ID ASC);

CREATE SEQUENCE SEQ_CA_FISCAL START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;



-- =============================================================================================
-- CA_LOCATION_CODE
-- =============================================================================================

CREATE
    TABLE CA_LOCATION_CODE
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR2(4) NOT NULL,
        ALIAS VARCHAR2(100),
        DESCRIPTION VARCHAR2(255),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_LOCATION_CODE ADD CONSTRAINT PK_CA_LOCATION_CODE PRIMARY KEY(ID);

ALTER TABLE CA_LOCATION_CODE ADD CONSTRAINT UNQ_CA_LOCATION_CODE UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_LOCATION_CODE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_ACCOUNT_CODE
-- =============================================================================================

CREATE
    TABLE CA_ACCOUNT_CODE
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR2(4) NOT NULL,
        ALIAS VARCHAR2(100),
        DESCRIPTION VARCHAR2(255),
        POSTING_TYPE NUMBER(1),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_ACCOUNT_CODE ADD CONSTRAINT PK_CA_ACCOUNT_CODE PRIMARY KEY(ID);

ALTER TABLE CA_ACCOUNT_CODE ADD CONSTRAINT UNQ_CA_ACCOUNT_CODE UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_ACCOUNT_CODE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_PROJECT_CODE
-- =============================================================================================

CREATE
    TABLE CA_PROJECT_CODE
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR2(4) NOT NULL,
        ALIAS VARCHAR2(100),
        DESCRIPTION VARCHAR2(255),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_PROJECT_CODE ADD CONSTRAINT PK_CA_PROJECT_CODE PRIMARY KEY(ID);

ALTER TABLE CA_PROJECT_CODE ADD CONSTRAINT UNQ_CA_PROJECT_CODE UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_PROJECT_CODE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_ITEM_CODE
-- =============================================================================================

CREATE
  TABLE CA_ITEM_CODE
  (
        ID NUMBER NOT NULL,
        SODO_ID NUMBER,
        PARENT_ID NUMBER,
        INCOME_ID NUMBER,
        CODE VARCHAR2(7) NOT NULL,
        DESCRIPTION VARCHAR2(255) NOT NULL,
        SUB_TYPE VARCHAR2(50),
        ITEM_TYPE NUMBER(3) NOT NULL,
        TAXABLE_AP NUMBER(1) NOT NULL,
        TAXABLE_AR NUMBER(1) NOT NULL,
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
  );

ALTER TABLE CA_ITEM_CODE ADD CONSTRAINT PK_CA_ITEM_CODE PRIMARY KEY(ID);

ALTER TABLE CA_ITEM_CODE ADD CONSTRAINT UNQ_CA_ITEM_CODE UNIQUE (CODE);

ALTER TABLE CA_ITEM_CODE ADD CONSTRAINT FK_CA_ITEM_CODE_1 FOREIGN KEY (INCOME_ID) REFERENCES CA_INCOME_CODE (ID);

CREATE SEQUENCE SEQ_CA_ITEM_CODE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_BANK
-- =============================================================================================

CREATE
    TABLE CA_BANK
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR2(20),
        CODE_JPA VARCHAR2(10),
        CODE_IBG VARCHAR2(10),
        CODE_SWIFT VARCHAR2(20),
        DESCRIPTION VARCHAR2(50),
        NAME VARCHAR(100),
        -- ADDRESS
        ADDRESS1 VARCHAR(100),
        ADDRESS2 VARCHAR(100),
        ADDRESS3 VARCHAR(100),
        ADDRESS4 VARCHAR(100),
        POSTCODE VARCHAR(100),
        CITY_ID NUMBER ,
        DISTRICT_ID NUMBER ,
        STATE_ID NUMBER,
        COUNTRY_ID NUMBER ,
        -- CONTACT
        PERSON VARCHAR(100),
        EMAIL VARCHAR(100),
        PHONE VARCHAR(100),
        FAX VARCHAR(100),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_BANK ADD CONSTRAINT PK_CA_BANK PRIMARY KEY(ID);

ALTER TABLE CA_BANK ADD CONSTRAINT UNQ_CA_BANK UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_BANK START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;



-- =============================================================================================
-- CA_REFERENCE_NO
-- =============================================================================================

CREATE
  TABLE CA_REFERENCE_NO
  (
        ID NUMBER NOT NULL,
        CAMPUS_ID NUMBER, -- can be null for universal
        CODE VARCHAR2(100) NOT NULL,
        DESCRIPTION VARCHAR2(255) NOT NULL,
        PREFIX VARCHAR2(50),
        REFERENCE_FORMAT VARCHAR2(50),
        SEQUENCE_FORMAT VARCHAR2(50),
        CURRENT_VALUE NUMBER(22),
        INCREMENT_VALUE NUMBER(22),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
  );

ALTER TABLE CA_REFERENCE_NO ADD CONSTRAINT PK_CA_REFERENCE_NO PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_REFERENCE_NO_NAME ON CA_REFERENCE_NO (CAMPUS_ID, CODE);

ALTER TABLE CA_REFERENCE_NO ADD CONSTRAINT FK_CA_REFERENCE_NO_1 FOREIGN KEY (CAMPUS_ID) REFERENCES CA_CAMPUS (ID);

CREATE SEQUENCE SEQ_CA_REFERENCE_NO START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;



-- =============================================================================================
-- CA_CONSUMER
-- =============================================================================================

CREATE
    TABLE CA_CONSUMER
    (
        ID NUMBER NOT NULL,
        CODE VARCHAR(100) NOT NULL,
        NAME VARCHAR2(255) NOT NULL,
        IDENTITY_NO VARCHAR2(100) NOT NULL,
        DESCRIPTION VARCHAR2(255),
        CONSUMER_TYPE NUMBER(1) NOT NULL,
        PAYMENT_METHOD NUMBER(1) DEFAULT 0,
        -- ADDRESS
        ADDRESS1 VARCHAR(100),
        ADDRESS2 VARCHAR(100),
        ADDRESS3 VARCHAR(100),
        ADDRESS4 VARCHAR(100),
        POSTCODE VARCHAR(100),
        CITY_ID NUMBER ,
        DISTRICT_ID NUMBER ,
        STATE_ID NUMBER,
        COUNTRY_ID NUMBER ,
        -- CONTACT
        PHONE VARCHAR2(60),
        FAX VARCHAR2(60),
        EMAIL VARCHAR2(200),
        EMAIL2 VARCHAR2(200),
        -- CREDIT
        BANK_ID NUMBER,
        BANK_BRANCH_ID NUMBER,
        BANK_ACCOUNT VARCHAR2(30),
        CREDIT_TERM NUMBER(1) DEFAULT 0,
        CREDIT_RATING FLOAT DEFAULT 100.00,
        BLACK_LISTED NUMBER(1) DEFAULT 0,
        BLACK_LISTED_START_DATE DATE,
        BLACK_LISTED_END_DATE DATE,
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_CONSUMER ADD CONSTRAINT PK_CA_CONSUMER PRIMARY KEY(ID);

ALTER TABLE CA_CONSUMER ADD CONSTRAINT UNQ_CA_CONSUMER UNIQUE (CODE);

ALTER TABLE CA_USER ADD CONSTRAINT FK_CA_USER_2 FOREIGN KEY (CONSUMER_ID) REFERENCES CA_CONSUMER (ID);

CREATE SEQUENCE SEQ_CA_CONSUMER START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_PERSON
-- identity no = nric no/old id/army no/police no
-- =============================================================================================

CREATE
    TABLE CA_PERSON
    (
        ID NUMBER NOT NULL,
        POSITION_ID NUMBER,
        SALARY NUMBER(15,2) DEFAULT 0,
        SYARIKAT_FK NUMBER
    );

ALTER TABLE CA_PERSON ADD CONSTRAINT PK_CA_PERSON PRIMARY KEY(ID);

-- =============================================================================================
-- CA_STAFF
-- identity no = staff no
-- =============================================================================================
CREATE
    TABLE CA_STAFF
    (
        ID NUMBER NOT NULL,
        POSITION_ID NUMBER,
        INTERIM_POSITION_ID NUMBER, -- MEMANGKU POSITION, MENANGUNG TAK PERLU TAHU
        -- PAYROLL
        PAYROLL_COST_CENTER_ID NUMBER,
        PAYROLL_PAYMENT_METHOD NUMBER(1) DEFAULT 0, -- payroll payment method
        -- START NO
        NRIC_NO VARCHAR2(100),
        ARPO_NO VARCHAR2(100),
        EPF_NO VARCHAR2(100),
        SOCSO_NO VARCHAR2(100),
        KWAP_NO VARCHAR2(100),
        FILE_NO VARCHAR2 (100),
        TH_NO VARCHAR2 (100),
        TAX_NO VARCHAR2(100),
        ASB_NO VARCHAR2 (100),
        COOP_NO VARCHAR2 (100),
        BPP1_NO VARCHAR2 (100),
        BPP2_NO VARCHAR2 (100),
        -- END NO
        PCB_CODE VARCHAR2(100),
        EPF_CODE VARCHAR2(100),
        SOCSO_CODE VARCHAR2(100),
        WIFE_CODE VARCHAR2(1),
        SALARY NUMBER(15,2) DEFAULT 0,
        INTERIM_SALARY NUMBER(15,2) DEFAULT 0,     -- GAJI MEMANGKU
        ASSUMED NUMBER (1) DEFAULT 0,  -- MENANGGUNG
        INTERIMED NUMBER (1) DEFAULT 0, -- MEMANGKU
        STATUS NUMBER(1) DEFAULT 0,     -- FsStaffStatus
        SUB_STATUS NUMBER(1) DEFAULT 0, -- FsStaffSubStatus
        SUSPENDED NUMBER (1) DEFAULT 0, -- for emolument
        CITIZEN NUMBER (1) DEFAULT 0,
        CIVILIAN NUMBER (1) DEFAULT 0,
        -- DATE
        START_DATE DATE, -- TODO: SERVICE_START_DATE
        END_DATE DATE,   -- TODO:SERVICE_END_DATE
        -- INDICATOR
        EPF_ACTIVE NUMBER (1) DEFAULT 0,
        SOCSO_ACTIVE NUMBER (1) DEFAULT 0,
        PCB_ACTIVE NUMBER (1) DEFAULT 0,
        KWAP_ACTIVE NUMBER (1) DEFAULT 0
    );

ALTER TABLE CA_STAFF ADD CONSTRAINT PK_CA_STAFF PRIMARY KEY(ID);

ALTER TABLE CA_STAFF ADD CONSTRAINT FK_CA_STAFF_1 FOREIGN KEY (ID) REFERENCES CA_CONSUMER (ID);


-- =============================================================================================
-- CA_UNIT_CODE
-- =============================================================================================


CREATE
  TABLE CA_UNIT_CODE
  (
    	ID NUMBER NOT NULL,
        CODE VARCHAR2(3),
        DESCRIPTION VARCHAR2 (255),
        -- STANDARD METADATA COLUMN
        M_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
  );


ALTER TABLE CA_UNIT_CODE ADD CONSTRAINT PK_CA_UNIT_CODE PRIMARY KEY(ID);

ALTER TABLE CA_UNIT_CODE ADD CONSTRAINT UNQ_CA_UNIT_CODE UNIQUE (CODE);

CREATE SEQUENCE SEQ_CA_UNIT_CODE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CA_JOURNAL
-- =============================================================================================

CREATE
    TABLE CA_JOURNAL
    (
    	ID NUMBER NOT NULL,
        DOCUMENT_ID NUMBER NULL,
        REFERENCE_NO VARCHAR2(20) NOT NULL,
        SOURCE_NO VARCHAR2(20),
        AUDIT_NO VARCHAR2(20),
        DESCRIPTION VARCHAR2(300),
        POSTED_DATE DATE,
        POSTING_STATUS NUMBER(1),
        JOURNAL_TYPE NUMBER(1),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_JOURNAL ADD CONSTRAINT PK_CA_JOURNAL PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_JOURNAL_CODE ON CA_JOURNAL (REFERENCE_NO ASC);

ALTER TABLE CA_JOURNAL ADD CONSTRAINT UNQ_CA_JOURNAL UNIQUE (REFERENCE_NO);

ALTER TABLE CA_JOURNAL ADD CONSTRAINT FK_CA_JOURNAL_1 FOREIGN KEY (DOCUMENT_ID) REFERENCES CA_DOCUMENT (ID);

CREATE SEQUENCE SEQ_CA_JOURNAL START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

CREATE
    TABLE CA_POSTING
    (
    	ID NUMBER NOT NULL,
    	JOURNAL_ID NUMBER NOT NULL,
    	ACCOUNT_ID NUMBER NOT NULL,
        DESCRIPTION VARCHAR2(300) NOT NULL,
        AMOUNT NUMBER(15,2) NOT NULL,
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_POSTING ADD CONSTRAINT PK_CA_POSTING PRIMARY KEY(ID);

ALTER TABLE CA_POSTING ADD CONSTRAINT FK_CA_POSTING_1 FOREIGN KEY (JOURNAL_ID) REFERENCES CA_JOURNAL (ID);

ALTER TABLE CA_POSTING ADD CONSTRAINT FK_CA_POSTING_2 FOREIGN KEY (ACCOUNT_ID) REFERENCES CA_ACCOUNT (ID);

CREATE SEQUENCE SEQ_CA_POSTING START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


-- =============================================================================================
-- CA_DOCUMENT
-- =============================================================================================

CREATE
    TABLE CA_DOCUMENT
    (
    	ID NUMBER NOT NULL,
        REFERENCE_NO VARCHAR2(20) NOT NULL,
        SOURCE_NO VARCHAR2(20),
        AUDIT_NO VARCHAR2(20),
        DESCRIPTION VARCHAR2(300),
        POSTED_DATE DATE,
        POSTING_STATUS NUMBER(1),
        DOCUMENT_TYPE NUMBER(1),
        -- STANDARD METADATA COLUMN
        MD_ST NUMBER(1) DEFAULT 0,
        C_ID NUMBER DEFAULT 0,
        C_TS TIMESTAMP DEFAULT SYSTIMESTAMP,
        M_ID NUMBER,
        M_TS TIMESTAMP,
        D_ID NUMBER,
        D_TS TIMESTAMP
    );

ALTER TABLE CA_DOCUMENT ADD CONSTRAINT PK_CA_DOCUMENT PRIMARY KEY(ID);

CREATE UNIQUE INDEX IDX_CA_DOCUMENT_CODE ON CA_DOCUMENT (REFERENCE_NO ASC);

ALTER TABLE CA_DOCUMENT ADD CONSTRAINT UNQ_CA_DOCUMENT UNIQUE (REFERENCE_NO);

CREATE SEQUENCE SEQ_CA_DOCUMENT START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;


CREATE
    TABLE CA_PURCHASE_ORDER
    (
    	ID NUMBER NOT NULL,
    	PURCHASE_ORDER_TYPE NUMBER(1) DEFAULT 0,
    	WORKFLOW_PRIORITY NUMBER(1) DEFAULT 0
    );

ALTER TABLE CA_PURCHASE_ORDER ADD CONSTRAINT PK_CA_PURCHASE_ORDER PRIMARY KEY(ID);

ALTER TABLE CA_PURCHASE_ORDER ADD CONSTRAINT FK_CA_PURCHASE_ORDER_1 FOREIGN KEY (ID) REFERENCES CA_DOCUMENT (ID);
