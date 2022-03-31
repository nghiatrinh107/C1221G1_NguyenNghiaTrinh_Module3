use quanlysinhvien;
select `subject`.*  from `subject` where Credit = (select max(Credit) from `subject`);
select `subject`.* from `subject`inner join mark on  `subject`.SubId = mark.SubId 
 where mark.Mark = (select max(Mark) from mark);
 select student.*, avg(mark.mark) as `avg` from student inner join mark on student.StudentId = mark.StudentId
 group by student.StudentId
 order by `avg` desc;