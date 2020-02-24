CREATE TABLE Queue(
ID NUMBER NOT NULL,
NAME VARCHAR2(50) NOT NULL,
DETAILS VARCHAR2(200),
MODIFIED_DATE TIMESTAMP(2) NOT NULL,
PRIMARY KEY(ID)
);

CREATE TABLE TASK(
ID NUMBER NOT NULL,
QUEUE_ID NUMBER NOT NULL,
NAME VARCHAR2(50) NOT NULL,
DETAILS VARCHAR2(200),
OWNER VARCHAR2(20),
FROM_QUEUE VARCHAR2(50),
TO_QUEUE VARCHAR2(50),
ASSIGNED VARCHAR2(20),
STATUS VARCHAR2(20),
MODIFIED_DATE TIMESTAMP(2) NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(QUEUE_ID) REFERENCES QUEUE(ID)
);
