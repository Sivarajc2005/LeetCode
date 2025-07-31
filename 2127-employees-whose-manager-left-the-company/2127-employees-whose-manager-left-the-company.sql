# Write your MySQL query statement below
with temp as(
    select * 
    from Employees e
    where manager_id is not null  and e.salary < 30000
    
)

select e.employee_id 
from temp e
left join Employees e1 on e.manager_id = e1.employee_id
where e1.employee_id is null
order by e.employee_id;
