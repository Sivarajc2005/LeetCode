# Write your MySQL query statement below
select r.contest_id , round( (count(distinct r.user_id) / (select count(*) from Users) ) * 100 , 2 ) as percentage
from Register r
group by r.contest_id
order by percentage desc ,  contest_id asc;
