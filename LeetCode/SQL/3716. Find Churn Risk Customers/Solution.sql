-- Table: subscription_events

-- +------------------+---------+
-- | Column Name      | Type    | 
-- +------------------+---------+
-- | event_id         | int     |
-- | user_id          | int     |
-- | event_date       | date    |
-- | event_type       | varchar |
-- | plan_name        | varchar |
-- | monthly_amount   | decimal |
-- +------------------+---------+
-- event_id is the unique identifier for this table.
-- event_type can be start, upgrade, downgrade, or cancel.
-- plan_name can be basic, standard, premium, or NULL (when event_type is cancel).
-- monthly_amount represents the monthly subscription cost after this event.
-- For cancel events, monthly_amount is 0.
-- Write a solution to Find Churn Risk Customers - users who show warning signs before churning. A user is considered churn risk customer if they meet ALL the following criteria:

-- Currently have an active subscription (their last event is not cancel).
-- Have performed at least one downgrade in their subscription history.
-- Their current plan revenue is less than 50% of their historical maximum plan revenue.
-- Have been a subscriber for at least 60 days.
-- Return the result table ordered by days_as_subscriber in descending order, then by user_id in ascending order.

-- The result format is in the following example.

 

-- Example:

-- Input:

-- subscription_events table:

-- +----------+---------+------------+------------+-----------+----------------+
-- | event_id | user_id | event_date | event_type | plan_name | monthly_amount |
-- +----------+---------+------------+------------+-----------+----------------+
-- | 1        | 501     | 2024-01-01 | start      | premium   | 29.99          |
-- | 2        | 501     | 2024-02-15 | downgrade  | standard  | 19.99          |
-- | 3        | 501     | 2024-03-20 | downgrade  | basic     | 9.99           |
-- | 4        | 502     | 2024-01-05 | start      | standard  | 19.99          |
-- | 5        | 502     | 2024-02-10 | upgrade    | premium   | 29.99          |
-- | 6        | 502     | 2024-03-15 | downgrade  | basic     | 9.99           |
-- | 7        | 503     | 2024-01-10 | start      | basic     | 9.99           |
-- | 8        | 503     | 2024-02-20 | upgrade    | standard  | 19.99          |
-- | 9        | 503     | 2024-03-25 | upgrade    | premium   | 29.99          |
-- | 10       | 504     | 2024-01-15 | start      | premium   | 29.99          |
-- | 11       | 504     | 2024-03-01 | downgrade  | standard  | 19.99          |
-- | 12       | 504     | 2024-03-30 | cancel     | NULL      | 0.00           |
-- | 13       | 505     | 2024-02-01 | start      | basic     | 9.99           |
-- | 14       | 505     | 2024-02-28 | upgrade    | standard  | 19.99          |
-- | 15       | 506     | 2024-01-20 | start      | premium   | 29.99          |
-- | 16       | 506     | 2024-03-10 | downgrade  | basic     | 9.99           |
-- +----------+---------+------------+------------+-----------+----------------+
-- Output:

-- +----------+--------------+------------------------+-----------------------+--------------------+
-- | user_id  | current_plan | current_monthly_amount | max_historical_amount | days_as_subscriber |
-- +----------+--------------+------------------------+-----------------------+--------------------+
-- | 501      | basic        | 9.99                   | 29.99                 | 79                 |
-- | 502      | basic        | 9.99                   | 29.99                 | 69                 |
-- +----------+--------------+------------------------+-----------------------+--------------------+
-- Explanation:

-- User 501:
-- Currently active: Last event is downgrade to basic (not cancelled) 
-- Has downgrades: Yes, 2 downgrades in history 
-- Current revenue (9.99) vs max (29.99): 9.99/29.99 = 33.3% (less than 50%) 
-- Days as subscriber: Jan 1 to Mar 20 = 79 days (at least 60) 
-- Result: Churn Risk Customer
-- User 502:
-- Currently active: Last event is downgrade to basic (not cancelled) 
-- Has downgrades: Yes, 1 downgrade in history 
-- Current revenue (9.99) vs max (29.99): 9.99/29.99 = 33.3% (less than 50%) 
-- Days as subscriber: Jan 5 to Mar 15 = 70 days (at least 60) 
-- Result: Churn Risk Customer
-- User 503:
-- Currently active: Last event is upgrade to premium (not cancelled) 
-- Has downgrades: No downgrades in history 
-- Result: Not at-risk (no downgrade history)
-- User 504:
-- Currently active: Last event is cancel
-- Result: Not at-risk (subscription cancelled)
-- User 505:
-- Currently active: Last event is 'upgrade' to standard (not cancelled) 
-- Has downgrades: No downgrades in history 
-- Result: Not at-risk (no downgrade history)
-- User 506:
-- Currently active: Last event is downgrade to basic (not cancelled) 
-- Has downgrades: Yes, 1 downgrade in history 
-- Current revenue (9.99) vs max (29.99): 9.99/29.99 = 33.3% (less than 50%) 
-- Days as subscriber: Jan 20 to Mar 10 = 50 days (less than 60) 
-- Result: Not at-risk (insufficient subscription duration)
-- Result table is ordered by days_as_subscriber DESC, then user_id ASC.

-- Note: days_as_subscriber is calculated from the first event date to the last event date for each user.

-- https://leetcode.com/problems/find-churn-risk-customers/description/


# Write your MySQL query statement below

WITH calc_cte AS (
    SELECT 
            user_id,
            FIRST_VALUE(event_date) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS first_event_date,
            LAST_VALUE(event_date) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS curr_event_date,
            LAST_VALUE(monthly_amount) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS curr_month_amt,
            MAX(monthly_amount) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS max_month_amt,
            SUM(CASE WHEN event_type='downgrade' THEN 1 ELSE 0 END) OVER (PARTITION BY user_id
                                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) as all_downgrades,
            LAST_VALUE(event_type) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS curr_event_type,
            LAST_VALUE(plan_name) OVER (PARTITION BY user_id 
                                    ORDER BY event_date ASC 
                                    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS curr_plan_name
    FROM subscription_events
)
    SELECT user_id,
            curr_plan_name AS current_plan,
            curr_month_amt AS current_monthly_amount,
            max_month_amt AS max_historical_amount,
            DATEDIFF(curr_event_date, first_event_date) AS days_as_subscriber
    FROM calc_cte
    WHERE curr_event_type <> 'cancel'
    AND curr_month_amt < 0.5*max_month_amt
    AND DATEDIFF(curr_event_date, first_event_date) >= 60
    AND all_downgrades >= 1
    GROUP BY 1
    ORDER BY 5 DESC, 1 ASC
