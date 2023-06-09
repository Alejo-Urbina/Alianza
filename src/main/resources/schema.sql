DROP TABLE IF EXISTS client;
DROP SEQUENCE IF EXISTS CLIENT_SEQ;

CREATE SEQUENCE CLIENT_SEQ;
ALTER SEQUENCE CLIENT_SEQ INCREMENT by 1;

CREATE TABLE client (ID INTEGER AUTO_INCREMENT PRIMARY KEY ,
                  SHAREDKEY VARCHAR(15),
                  BUSINESSID VARCHAR(20),
                  EMAIL VARCHAR(20),
                  PHONE VARCHAR(10),
                  STARTDATE DATE,
                  ENDDATE DATE
                   );