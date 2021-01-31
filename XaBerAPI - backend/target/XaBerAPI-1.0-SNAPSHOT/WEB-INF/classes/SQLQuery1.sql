create database XaBerChords

create table Chords(
id int identity(1,1) not null constraint pk_id Primary key,
name1 varchar(5) not null,
image1 varchar(164) not null,
description1 varchar(150) 
)

insert into Chords(name1,image1,description1) VALUES('A','link','testDecription')
insert into Chords(name1,image1,description1) VALUES('Am','link','testDecription')
insert into Chords(name1,image1,description1) VALUES('B','link','testDecription')
select * from Chords
select * from Chords where name1 = 'A'