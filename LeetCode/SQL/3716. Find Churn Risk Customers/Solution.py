import pandas as pd

def find_churn_risk_customers(subscription_events: pd.DataFrame) -> pd.DataFrame:
    df = subscription_events.copy()
    df["event_date"] = pd.to_datetime(df["event_date"])

    df["first_event_date"] = df.groupby("user_id")["event_date"].transform('first')
    df["curr_event_date"] = df.groupby("user_id")["event_date"].transform('last')
    df["curr_month_amt"] = df.groupby("user_id")["monthly_amount"].transform('last')
    df["max_historical_amount"] = df.groupby("user_id")["monthly_amount"].transform('max')
    df["current_monthly_amount"] = df.groupby("user_id")["monthly_amount"].transform('last')
    df["curr_event_type"] = df.groupby("user_id")["event_type"].transform('last')
    df["current_plan"] = df.groupby("user_id")["plan_name"].transform('last')
    df["days_as_subscriber"] = (df["curr_event_date"] - df["first_event_date"]).dt.days
    df["all_downgrades"] = df.groupby("user_id")["event_type"].transform(lambda x: (x=='downgrade').sum())

    df = df[(df["curr_event_type"] != 'cancel') \
            & (df["current_monthly_amount"] < 0.5*df["max_historical_amount"])\
            & (df["days_as_subscriber"] >= 60) \
            & (df["all_downgrades"] >= 1)
    ]

    df = df[["user_id", "current_plan", "current_monthly_amount", "max_historical_amount","days_as_subscriber"]].drop_duplicates()
    
    df = df.sort_values(by=["days_as_subscriber", "user_id"], ascending=[False, True])

    return df
