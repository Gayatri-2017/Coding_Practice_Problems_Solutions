import pandas as pd
from io import StringIO

data = """
user_id,date_visited
u001,2022-08-01
u001,2022-08-01
u004,2022-08-01
u005,2022-08-01
u005,2022-08-01
u003,2022-08-02
u004,2022-08-02
u004,2022-08-02
u004,2022-08-02
u004,2022-08-02
u005,2022-08-02
u005,2022-08-02
u001,2022-08-03
u002,2022-08-03
u002,2022-08-03
u004,2022-08-03
u005,2022-08-03
u001,2022-08-04
u004,2022-08-04
u005,2022-08-04
u001,2022-08-05
u004,2022-08-05
u005,2022-08-05
u006,2022-08-05
u004,2022-08-05
u005,2022-08-05
u006,2022-08-06
u006,2022-08-06
u003,2022-08-06
u003,2022-08-06
u003,2022-08-06
u004,2022-08-06
u005,2022-08-06
u006,2022-08-07
u001,2022-08-07
u001,2022-08-07
u001,2022-08-07
u003,2022-08-07
u004,2022-08-07
u005,2022-08-07
u006,2022-08-08
u001,2022-08-08
u002,2022-08-08
u002,2022-08-08
u002,2022-08-08
u003,2022-08-08
u003,2022-08-08
u004,2022-08-08
u005,2022-08-08
u005,2022-08-08
u001,2022-08-09
u003,2022-08-09
u003,2022-08-09
u004,2022-08-09
u005,2022-08-09
u001,2022-08-10
u002,2022-08-10
u003,2022-08-10
u004,2022-08-10
u005,2022-08-10
u001,2022-08-11
u002,2022-08-11
u003,2022-08-11
u004,2022-08-11
u005,2022-08-11
"""

# Create DataFrame
df = pd.read_csv(StringIO(data), parse_dates=['date_visited'])
print("% rows of output")
print(df.head())

# Assume df has: user_id, date_visited
df['date_visited'] = pd.to_datetime(df['date_visited'])

# Step 1: Filter out dates after Aug 10, 2022
df = df[df['date_visited'] <= '2022-08-10']

# Step 2: Drop duplicate visits
df = df.drop_duplicates(subset=['user_id', 'date_visited'])

# Step 3: Sort by user_id and date
df = df.sort_values(['user_id', 'date_visited'])

# Step 4: For each user, check if current date is 1 day after previous
df['prev_date'] = df.groupby('user_id')['date_visited'].shift()
df['is_consecutive'] = (df['date_visited'] - df['prev_date']) == pd.Timedelta(days=1)

# Step 5: When not consecutive, it starts a new streak
df['streak_id'] = (~df['is_consecutive']).cumsum()

# Step 6: Count length of each streak
streak_lengths = df.groupby(['user_id', 'streak_id']).size().reset_index(name='streak_length')

# Step 7: Get the longest streak per user
user_max_streaks = streak_lengths.groupby('user_id')['streak_length'].max().reset_index()

# Step 8: Rank users by streak length and filter top 3 (with ties)
user_max_streaks['rank'] = user_max_streaks['streak_length'].rank(method='dense', ascending=False)
top_users = user_max_streaks[user_max_streaks['rank'] <= 3]

# Output
print("*"*10)
print("Final Output")
print(top_users[['user_id', 'streak_length']].sort_values("streak_length", ascending=False))
