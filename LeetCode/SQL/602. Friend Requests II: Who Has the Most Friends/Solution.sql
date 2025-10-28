-- Table: RequestAccepted

-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | requester_id   | int     |
-- | accepter_id    | int     |
-- | accept_date    | date    |
-- +----------------+---------+
-- (requester_id, accepter_id) is the primary key (combination of columns with unique values) for this table.
-- This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date when the request was accepted.
 

-- Write a solution to find the people who have the most friends and the most friends number.

-- The test cases are generated so that only one person has the most friends.

-- The result format is in the following example.

 

-- Example 1:

-- Input: 
-- RequestAccepted table:
-- +--------------+-------------+-------------+
-- | requester_id | accepter_id | accept_date |
-- +--------------+-------------+-------------+
-- | 1            | 2           | 2016/06/03  |
-- | 1            | 3           | 2016/06/08  |
-- | 2            | 3           | 2016/06/08  |
-- | 3            | 4           | 2016/06/09  |
-- +--------------+-------------+-------------+
-- Output: 
-- +----+-----+
-- | id | num |
-- +----+-----+
-- | 3  | 3   |
-- +----+-----+
-- Explanation: 
-- The person with id 3 is a friend of people 1, 2, and 4, so he has three friends in total, which is the most number than any others.
 

-- Follow up: In the real world, multiple people could have the same most number of friends. Could you find all these people in this case?

-- https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

-- My Solution

# Write your MySQL query statement below
with requester_count_friend AS (
    SELECT requester_id
            , COUNT(accepter_id) AS requester_count
    FROM RequestAccepted
    GROUP BY 1
)
, accepter_count_friend AS (
    SELECT accepter_id
            , COUNT(requester_id) AS accepter_count
    FROM RequestAccepted
    GROUP BY 1
)
SELECT id
        , num
FROM (SELECT r.requester_id  AS id
        , r.requester_count +  COALESCE(a.accepter_count, 0) as num
FROM requester_count_friend r
LEFT JOIN accepter_count_friend a
ON r.requester_id = a.accepter_id
UNION ALL
SELECT COALESCE(r.requester_id, a.accepter_id)  AS id
        , COALESCE(r.requester_count, 0) +  a.accepter_count as num
FROM requester_count_friend r
RIGHT JOIN accepter_count_friend a
ON r.requester_id = a.accepter_id
WHERE r.requester_id IS NULL
) a
GROUP BY 1
ORDER BY 2 DESC
LIMIT 1

-- Simpler Solution

-- with base as(select requester_id id from RequestAccepted
-- union all
-- select accepter_id id from RequestAccepted)


-- select id, count(*) num  from base group by 1 order by 2 desc limit 1
