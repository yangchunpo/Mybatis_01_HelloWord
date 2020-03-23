-- 创建表
CREATE TABLE "hj_ycp"."tb_person" (
  "id" INT IDENTITY(1, 1) NOT NULL,
  "name" varchar2(20),
  "age" int,
  "birth" date,
  "registerTime" datetime,
  "salary" double,
  PRIMARY KEY ("id")
);

-- 插入
INSERT INTO hj_ycp.tb_person(NAME,age,birth,registerTime,salary) 
VALUES('李四',27,CURRENT_DATE(),NOW(),3000.05);
commit;
 
-- 查询
select * from hj_ycp.tb_person;
================================================================

select column_name || ',' from all_col_comments where table_name = 'tb_person';
================================================================
-- 猫
CREATE TABLE "hj_ycp"."tb_cat" (
  "id" INT IDENTITY(1, 1) NOT NULL,
  "catName" varchar2(200),
  "age" INT,
  "birth" date,
  PRIMARY KEY ("id")
);

INSERT INTO hj_ycp.tb_cat(catName,age,birth) VALUES('whiteCat',7,CURRENT_DATE());
INSERT INTO hj_ycp.tb_cat(catName,age,birth) VALUES('blackCat',5,CURRENT_DATE());
INSERT INTO hj_ycp.tb_cat(catName,age,birth) VALUES('yellowCat',3,CURRENT_DATE());
commit;

select * from hj_ycp.tb_cat;
================================================================
-- 狗

CREATE TABLE "hj_ycp"."tb_dog" (
 "id" INT IDENTITY(1, 1) NOT NULL,
 "dog_Name" varchar2(200),
 "dog_Weight" int,
 PRIMARY KEY ("id")
);

INSERT INTO hj_ycp.tb_dog(dog_Name,dog_Weight) VALUES('ww1',10);
INSERT INTO hj_ycp.tb_dog(dog_Name,dog_Weight) VALUES('ww2',15);
commit;

SELECT * FROM hj_ycp.tb_dog;
================================================================
-- 学生

drop table hj_ycp.tbl_student;

CREATE TABLE "hj_ycp"."tb_student" (
"id" INT IDENTITY(1, 1) NOT NULL,
"name" VARCHAR2(300),
"score" DOUBLE,
"birth" DATE,
"age" INT,
PRIMARY KEY ("id")
);

INSERT INTO hj_ycp.tb_student(NAME,score,birth,age) VALUES('li4',89.5,CURRENT_DATE(),22);
INSERT INTO hj_ycp.tb_student(NAME,score,birth,age) VALUES('li5',93.5,CURRENT_DATE(),23);
INSERT INTO hj_ycp.tb_student(NAME,score,birth,age) VALUES('li6',77.5,CURRENT_DATE(),24);

SELECT * FROM hj_ycp.tb_student;
================================================================

-- 钥匙 和 锁

drop table hj_ycp.tb_lock;
drop table hj_ycp.tb_key;

CREATE TABLE "hj_ycp"."tb_key"
(
"id" INT IDENTITY(1, 1) NOT NULL,
"keyName" VARCHAR2(20),
CLUSTER PRIMARY KEY("id")) STORAGE(ON "MAIN", CLUSTERBTR) ;


CREATE TABLE "hj_ycp"."tb_lock"
(
"id" INT IDENTITY(1, 1) NOT NULL,
"lockName" VARCHAR2(20),
"key_id" INT,
CLUSTER PRIMARY KEY("id"),
CONSTRAINT "fk_tbKey_id" FOREIGN KEY("key_id") REFERENCES "hj_ycp"."tb_key"("id")) STORAGE(ON "MAIN", CLUSTERBTR) ;

insert into hj_ycp.tb_key(keyName) values ('goldKey');commit;

insert into hj_ycp.tb_lock(lockName,key_id) values ('goldLock',1);commit;
================================================================

-- 钥匙 和 锁（测试）

drop table hj_ycp.tb_lock;
drop table hj_ycp.tb_key;

CREATE TABLE "hj_ycp"."tb_key"
(
"id" INT,
"keyName" VARCHAR2(20));


CREATE TABLE "hj_ycp"."tb_lock"
(
"id" INT,
"lockName" VARCHAR2(20));


insert into hj_ycp.tb_key(id,keyName) values (1,'goldKey');commit;

insert into hj_ycp.tb_lock(id,lockName) values (1,'goldLock');commit;

insert into hj_ycp.tb_key(id,keyName) values (1,'tuKey');commit;

insert into hj_ycp.tb_lock(id,lockName) values (1,'tuLock');commit;
================================================================
-- 员工与部门表：建表语句
drop table "hj_ycp"."tb_dept";
drop table "hj_ycp"."tb_emp";

CREATE TABLE "hj_ycp"."tb_dept" (
 "id" INT IDENTITY(1, 1) NOT NULL,
 "deptName" VARCHAR2(30),
 "locAdd" VARCHAR2(40),
 PRIMARY KEY ("id")
);

CREATE TABLE "hj_ycp"."tb_emp" (
 "id" INT IDENTITY(1, 1) NOT NULL,
 "name" VARCHAR2(20),
 "deptId" INT,
 PRIMARY KEY ("id"),
 CONSTRAINT "fk_dept_id" FOREIGN KEY ("deptId") REFERENCES "hj_ycp"."tb_dept" ("id")
);
================================================================
-- 用户
CREATE TABLE hj_ycp.tb_user(
  id INT IDENTITY(1, 1) NOT NULL,
  NAME VARCHAR(20), 
  age INT
);
INSERT INTO hj_ycp.tb_user(NAME, age) VALUES('苏武', 22);
INSERT INTO hj_ycp.tb_user(NAME, age) VALUES('李青', 31);
commit;
================================================================


