# Write your MySQL query statement below
select name as Customers
from customers 
left join orders 
on customers.id = orders.customerID
where customerID is null;