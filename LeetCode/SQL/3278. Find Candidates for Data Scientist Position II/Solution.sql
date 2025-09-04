-- Table: Candidates

-- +--------------+---------+ 
-- | Column Name  | Type    | 
-- +--------------+---------+ 
-- | candidate_id | int     | 
-- | skill        | varchar |
-- | proficiency  | int     |
-- +--------------+---------+
-- (candidate_id, skill) is the unique key for this table.
-- Each row includes candidate_id, skill, and proficiency level (1-5).
-- Table: Projects

-- +--------------+---------+ 
-- | Column Name  | Type    | 
-- +--------------+---------+ 
-- | project_id   | int     | 
-- | skill        | varchar |
-- | importance   | int     |
-- +--------------+---------+
-- (project_id, skill) is the primary key for this table.
-- Each row includes project_id, required skill, and its importance (1-5) for the project.
-- Leetcode is staffing for multiple data science projects. Write a solution to find the best candidate for each project based on the following criteria:

-- Candidates must have all the skills required for a project.
-- Calculate a score for each candidate-project pair as follows:
-- Start with 100 points
-- Add 10 points for each skill where proficiency > importance
-- Subtract 5 points for each skill where proficiency < importance
-- If the candidate's skill proficiency equal to the project's skill importance, the score remains unchanged
-- Include only the top candidate (highest score) for each project. If there’s a tie, choose the candidate with the lower candidate_id. If there is no suitable candidate for a project, do not return that project.

-- Return a result table ordered by project_id in ascending order.

-- The result format is in the following example.


-- https://leetcode.com/problems/find-candidates-for-data-scientist-position-ii/description/

-- Online Solution
with candidate_info as(
    select candidate_id,project_id,count(skill)skills,
    100+sum(
        case when proficiency>importance  then 10
        when proficiency<importance  then -5
        else 0 end
    )score
    from Candidates 
    join projects
    using(skill)
    group by 1,2
),
project_info as(
select project_id  ,count(skill)skills
from projects
group by 1
),
cte as(
    select project_id  ,candidate_id ,score,
    dense_rank() over(partition by project_id order by score desc,candidate_id )rnk
    from candidate_info
    join project_info
    using(skills,project_id)
    )
    select project_id  ,candidate_id ,score
    from cte
    where rnk=1

-- My Solution
-- # Write your MySQL query statement below
with count_proj_skill AS
(
    SELECT p.project_id, p.skill, p.importance, count(p.skill) over(partition by p.project_id) as proj_skill_cnt
    FROM Projects p
)
, joined_table as 
(select p.project_id, p.skill as proj_skill, p.importance, p.proj_skill_cnt,
        c.candidate_id, c.skill as cand_skill, c.proficiency, count(c.skill) over(partition by c.candidate_id, p.project_id) as cand_skill_cnt
from count_proj_skill p
left join candidates c
on p.skill = c.skill
where c.candidate_id is not null)
, temp_score as (
    select project_id, candidate_id,
    case 
    when proficiency>importance then 10
    when proficiency<importance then -5
    else 0
    end as score_ops
    from joined_table
    where proj_skill_cnt = cand_skill_cnt
)
, combined_score as 
(select project_id, candidate_id, 100+sum(score_ops) as score
from temp_score
group by 1, 2
)
, max_score_per_proj as 
(select project_id, candidate_id, score, ROW_NUMBER() over(partition by project_id order by score desc, candidate_id ASC) as rn
from combined_score
)
, final_result as 
(select project_id, candidate_id, score
from max_score_per_proj
where rn = 1 
order by project_id asc)
select * from final_result
