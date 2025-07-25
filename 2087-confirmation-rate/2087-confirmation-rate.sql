# Write your MySQL query statement below
select s.user_id , 
        -- (sb.cr / sb.tr) as 'cp'
    round(case when sb.tr is null then 0 else (sb.cr / sb.tr) end , 2 ) as 'confirmation_rate'
from (select  
    user_id , 
    count(case when action = 'confirmed' then 1 end) as 'cr' , 
    count(*) as 'tr'
from confirmations
group by user_id) sb   
right join Signups s
on s.user_id = sb.user_id;