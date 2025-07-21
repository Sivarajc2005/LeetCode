# Write your MySQL query statement below
select u.name , t.amt as balance
from (select * , sum(amount) as amt
from Transactions 
group by account ) t 
inner join Users u on u.account = t.account
where t.amt > 10000 ;
