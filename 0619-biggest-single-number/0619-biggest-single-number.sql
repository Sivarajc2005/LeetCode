# Write your MySQL query statement below
select max(num) as num 
from (
    select *
    from mynumbers 
    group by num
    having count(*) < 2
) as tem;