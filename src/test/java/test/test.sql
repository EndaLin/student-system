CREATE TABLE IF NOT EXISTS class (
  cid      INT(11)     NOT NULL AUTO_INCREMENT,
  cname    VARCHAR(20) NOT NULL ,
  cgrade   INT(11)     NOT NULL ,

  PRIMARY KEY (cid),
  CONSTRAINT class_pk UNIQUE (cname, cgrade)
);

CREATE TABLE IF NOT EXISTS student (
  sid      INT(11)       NOT NULL AUTO_INCREMENT,
  sname    VARCHAR(10)   NOT NULL,
  cid      INT(11)       NOT NULL,

  PRIMARY KEY (sid),
  FOREIGN KEY (cid) REFERENCES class (cid)
);

CREATE TABLE IF NOT EXISTS user
(
  account  VARCHAR(20)               not null,
  password VARCHAR(20) DEFAULT '123' not null,
  type     INT         DEFAULT '0'   not null,

  PRIMARY KEY (account)
);

CREATE TABLE IF NOT EXISTS course (
  id      INT(11)       NOT NULL AUTO_INCREMENT,
  name    VARCHAR(20)   NOT NULL UNIQUE ,

  PRIMARY KEY (id)
);

CREATE VIEW student_class AS
SELECT sid ,sname, class.cid, cname, cgrade
FROM student, class
WHERE student.cid = class.cid;

SELECT * from student where sid = 1111;

update student set sname = '李庭辉', cid = 11 where sid = 5555;


CREATE TABLE IF NOT EXISTS student_course(
	stu_id      INT(11)       NOT NULL,
  cou_id      INT(11)       NOT NULL,
  score       INT(11)       NOT NULL DEFAULT -1,
	grade       INT(11)       NOT NULL,

	FOREIGN KEY (stu_id) REFERENCES student(sid),
	FOREIGN KEY (cou_id) REFERENCES course(id),
	CONSTRAINT stu_sub_pk UNIQUE (stu_id, cou_id, grade)
);

CREATE VIEW select_course AS
SELECT stu_id ,stu.sname, c.cid, c.cname, cou_id AS courseid , cou.name AS coursename,  sc.score, grade
FROM student AS stu, class AS c, student_course AS sc, course AS cou
WHERE (
  stu.cid = c.cid
  AND stu.sid = sc.stu_id
  AND sc.cou_id = cou.id
);

insert student_course (stu_id, cou_id, grade) values (4185,111,20111);

select distinct grade from student_course where stu_id = 4185;

select distinct cou_id, name from select_course where stu_id = 4185;

select stu_id, sname, cid , cname, sum(score) AS sumScore, grade
from select_course
where (cid = 54 AND grade = 20111 AND score != -1)
group by stu_id;

select max(sid) AS sid from student;