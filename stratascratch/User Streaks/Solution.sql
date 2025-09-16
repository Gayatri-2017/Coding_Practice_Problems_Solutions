-- User Streaks
-- Hard
-- ID 2131
-- Provided a table with user id and the dates they visited the platform, find the top 3 users with the longest continuous streak of visiting the platform as of August 10, 2022. Output the user ID and the length of the streak.
-- In case of a tie, display all users with the top three longest streaks.
-- Table: user_streaks
-- https://platform.stratascratch.com/coding/2131-user-streaks?code_type=3

WITH distinct_user_visits AS (
    SELECT DISTINCT user_id, date_visited
    FROM user_streaks
    WHERE date_visited <= '2022-08-10'
), 
user_visits_with_rn AS (
    SELECT user_id,
           date_visited,
           ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY date_visited) AS rn
    FROM distinct_user_visits
),
streak_keys AS (
    SELECT user_id,
           date_visited,
           DATE_SUB(date_visited, INTERVAL rn DAY) AS streak_key
    FROM user_visits_with_rn
),
user_streak_lengths AS (
    SELECT user_id,
           streak_key,
           COUNT(*) AS streak_count
    FROM streak_keys
    GROUP BY user_id, streak_key
),
top_user_streaks AS (
    SELECT user_id,
           streak_count,
           DENSE_RANK() OVER (ORDER BY streak_count DESC) AS streak_rank
    FROM user_streak_lengths
)
SELECT user_id,
       streak_count AS streak_length
FROM top_user_streaks
WHERE streak_rank <= 3;
