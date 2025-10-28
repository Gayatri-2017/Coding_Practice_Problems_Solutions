import pandas as pd

def find_golden_hour_customers(restaurant_orders: pd.DataFrame) -> pd.DataFrame:
    df = restaurant_orders.copy()
    df['order_timestamp'] = pd.to_datetime(df['order_timestamp'])
    df['order_time'] = df['order_timestamp'].dt.time

    morning_peak_start = pd.to_datetime('11:00:00').time()
    morning_peak_end = pd.to_datetime('14:00:00').time()
    evening_peak_start = pd.to_datetime('18:00:00').time()
    evening_peak_end = pd.to_datetime('21:00:00').time()

    df['peak_hour'] = df['order_time'].between(morning_peak_start, morning_peak_end) | \
                    df['order_time'].between(evening_peak_start, evening_peak_end) 

    df['null_rating'] = np.where(df['order_rating'].isna(), 0, 1)

    grp_df = df.groupby('customer_id') \
                .agg(total_orders=('order_id', 'nunique'),
                    peak_hour_orders=('peak_hour', 'sum'),
                    null_rating_orders=('null_rating', 'sum'),
                    average_rating=('order_rating', 'mean')
                    )\
                .reset_index()

    grp_df["average_rating"] = round(grp_df["average_rating"], 2)
    grp_df['peak_hour_percentage'] = round((grp_df['peak_hour_orders']*100.0)/grp_df['total_orders'], 0)
    grp_df['null_rating_percentage'] = (grp_df['null_rating_orders']*100.0)/grp_df['total_orders']

    grp_df = grp_df[(grp_df["peak_hour_percentage"] >= 60) & (grp_df["null_rating_percentage"] >= 50) & \
                    (grp_df["average_rating"] >= 4.0) & (grp_df["total_orders"] >= 3) ]

    grp_df = grp_df[["customer_id", "total_orders", "peak_hour_percentage", "average_rating"]]\
            .sort_values(["average_rating", "customer_id"], ascending=[False, False])

    return grp_df
