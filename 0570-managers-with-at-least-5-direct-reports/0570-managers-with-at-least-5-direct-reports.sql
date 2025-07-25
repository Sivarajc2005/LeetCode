# Write your MySQL query statement below
select e.name
from 
(select * , count(*) as report
from employee
group by  managerId
having count(*) >= 5) s1 
inner join employee e on s1.managerId = e.id;