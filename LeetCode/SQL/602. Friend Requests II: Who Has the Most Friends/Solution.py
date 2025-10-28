import pandas as pd

def most_friends(request_accepted: pd.DataFrame) -> pd.DataFrame:
    df = request_accepted.copy()
    df_1 = pd.DataFrame()
    df_1 = pd.concat([df['requester_id'], df['accepter_id']], ignore_index=True)
    df_1 = df_1.value_counts().reset_index()
    df_1.columns = ["id", "num"]
    df_1 = df_1.sort_values("num",ascending=False)

    return df_1.head(1)
