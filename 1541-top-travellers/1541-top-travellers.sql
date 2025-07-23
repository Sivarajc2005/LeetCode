# Write your MySQL query statement below
select u.name , ifNull(res.dt , 0) as  travelled_distance
from Users u
left join (select r.user_id , sum(distance) as dt
from Rides r
group by r.user_id) res on u.id = res.user_id
order by res.dt desc,u.name asc;