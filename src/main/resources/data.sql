insert into course (id,name,created_date,last_updated_date)
values (101,'Java',sysdate(),sysdate());
insert into course (id,name,created_date,last_updated_date)
values (102,'Spring',sysdate(),sysdate());
insert into course (id,name,created_date,last_updated_date)
values (103,'Spring boot',sysdate(),sysdate());
insert into course (id,name,created_date,last_updated_date)
values (104,'Hibernate',sysdate(),sysdate());

insert into Passport(id,number)
values (301,'J123456');
insert into Passport(id,number)
values (302,'M123456');
insert into Passport(id,number)
values (303,'N123456');

insert into Student (id,name,passport_id)
values (201,'Jagadeesh',301);
insert into Student (id,name)
values (202,'Mahesh');
insert into Student (id,name,passport_id)
values (203,'Naresh',303);



insert into Review(id,rating,description)
values (401,'1','Bad');
insert into Review(id,rating,description)
values (402,'3','Okayish');
insert into Review(id,rating,description)
values (403,'5','Excellent');
