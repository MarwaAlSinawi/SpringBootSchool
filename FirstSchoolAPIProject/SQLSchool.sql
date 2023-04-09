create database ApiDatabase;
use ApiDatabase;

Select * From school;
Select * From student;
Select * From course;
Select * From mark;

INSERT INTO school (is_active,school_name) VALUES ('true','abcd');
INSERT INTO student (is_active,student_name,roll_number,school_id) VALUES ('true','fatma',54,1);
INSERT INTO student (is_active,student_name,roll_number,school_id) VALUES ('true','marwa',55,1);
INSERT INTO student (is_active,student_name,roll_number,school_id) VALUES ('true','jannat',56,1);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-08-01','2020-03-05','true','Java',1);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-08-01','2020-03-05','true','A+',98,1);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-08-01','2020-03-05','true','B',98,2);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-08-01','2020-03-05','true','C+',98,2);