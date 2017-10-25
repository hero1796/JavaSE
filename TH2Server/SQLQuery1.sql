use StudentDB
go
create table tblStudent
(
id int primary key
, name nvarchar(100)
, dOb datetime
, address nvarchar(100)
)

create table tblSubject
(
id int primary key
, name nvarchar(100)
, numTinChi int
)

create table tblSubjectClass
(
id int
, name nvarchar(100)
, learnTime nvarchar(100)
, room nvarchar(100)
, maxSlot int
, subjectID int
, primary key(id, subjectID)
)

create table tblLearning
(
studentID int
, subjectClassID int
, subjectID int
, ccPoint int
, tbktPoint int
, btlPoint int
, primary key(studentID, subjectID)
)

alter table tblSubjectClass add constraint Fk_tblSubjectClass_subjectID foreign key(subjectID) references tblSubject(id)
alter table tblLearning add constraint Fk_tblLearning_studentID foreign key(studentID) references tblStudent(id)
alter table tblLearning add constraint Fk_tblLearning_subjectClassID foreign key(subjectClassID, subjectID) references tblSubjectClass(id, subjectID)

insert into tblSubject(id, name, numTinChi) values(1, 'Hoa hoc', 3)
insert into tblSubject(id, name, numTinChi) values(2, 'Vat ly', 2)
insert into tblSubject(id, name, numTinChi) values(3, 'Ngu van', 4)

insert into tblSubjectClass(id, subjectID, name, room, learnTime, maxSlot) 
	values(1, 2, 'VL1', '401-a1', '7h Thu 2', 40)
insert into tblSubjectClass(id, subjectID, name, room, learnTime, maxSlot) 
	values(2, 2, 'VL2', '402-a1', '7h Thu 3', 40)
insert into tblSubjectClass(id, subjectID, name, room, learnTime, maxSlot) 
	values(1, 3, 'NV1', '405-a1', '9h Thu 4', 40)
insert into tblSubjectClass(id, subjectID, name, room, learnTime, maxSlot) 
	values(1, 1, 'HH1', '405-a1', '9h Thu 5', 40)
insert into tblSubjectClass(id, subjectID, name, room, learnTime, maxSlot) 
	values(2, 1, 'HH2', '401-a1', '12h Thu 6', 40)

insert into tblStudent(id, name, dOb, address) values(1, 'Hung', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(2, 'Hoang', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(3, 'Dung', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(4, 'Phuong', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(5, 'Long', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(6, 'Tinh', 1996-02-01, 'Ha Noi')
insert into tblStudent(id, name, dOb, address) values(7, 'Quyet', 1996-02-01, 'Ha Noi')

insert into tblLearning(studentID, subjectID, subjectClassID) values(1, 1, 2)
insert into tblLearning(studentID, subjectID, subjectClassID) values(2, 1, 2)
insert into tblLearning(studentID, subjectID, subjectClassID) values(3, 1, 1)
insert into tblLearning(studentID, subjectID, subjectClassID) values(2, 2, 1)
insert into tblLearning(studentID, subjectID, subjectClassID) values(5, 2, 1)
insert into tblLearning(studentID, subjectID, subjectClassID) values(6, 3, 1)
insert into tblLearning(studentID, subjectID, subjectClassID) values(7, 2, 2)
insert into tblLearning(studentID, subjectID, subjectClassID) values(1, 3, 1)







