-- Write your MySQL query statement below
SELECT round(sum(a.immed)*100/ COUNT(*), 2)  AS immediate_percentage
FROM 
(SELECT CASE order_date
            WHEN customer_pref_delivery_date THEN 1
            ELSE 0
        END AS immed
FROM Delivery) a
