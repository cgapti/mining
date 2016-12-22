--------------------------------------------------------
--  File created - Wednesday-December-21-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TBL_STONE_DETAILS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."TBL_STONE_DETAILS" 
   (	"STONE_SLNO" NUMBER, 
	"STONE_WIDTH" NUMBER(10,2), 
	"STONE_HEIGHT" NUMBER(10,2), 
	"STONE_LENGTH" NUMBER(10,2), 
	"STONE_TYPE" VARCHAR2(20 BYTE), 
	"STONE_COLOUR" VARCHAR2(20 BYTE), 
	"STONE_QTY" NUMBER, 
	"CREATED_BY" VARCHAR2(20 BYTE), 
	"CREATED_DATE" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.TBL_STONE_DETAILS
SET DEFINE OFF;
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (3,11.5,8.5,11.5,'TILE','WHITE',10,'SYSTEM',to_date('09-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (7,11,9,10,'TILE','WHITE',11,'Malli',to_date('13-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (9,11.6,9.4,10.6,'TILE','WHITE',16,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (10,11.5,9.3,10.3,'TILE','WHITE',11,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (8,12.77,91.88,10.5,'TILE','BLACK',16,null,to_date('13-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (11,11.5,9.3,10.3,'TILE','WHITE',11,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (12,11.1,9.1,10.2,'TILE','PINK',12,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (13,11.1,9.1,10.2,'TILE','PINK',12,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (14,11.1,9.1,10.2,'TILE','PINK',12,null,to_date('15-12-16','DD-MM-RR'));
Insert into SYSTEM.TBL_STONE_DETAILS (STONE_SLNO,STONE_WIDTH,STONE_HEIGHT,STONE_LENGTH,STONE_TYPE,STONE_COLOUR,STONE_QTY,CREATED_BY,CREATED_DATE) values (15,10.03,9.1,10.2,'TILE','PINK',12,null,to_date('15-12-16','DD-MM-RR'));
