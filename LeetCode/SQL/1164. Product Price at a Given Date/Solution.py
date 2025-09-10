import pandas as pd
from datetime import datetime
def price_at_given_date(products: pd.DataFrame) -> pd.DataFrame:
    
    # Create DataFrame
    products['change_date'] = pd.to_datetime(products['change_date'])

    # Target date
    target_date = pd.to_datetime('2019-08-16')

    # Step 1: Filter price changes on or before target date
    df_past = products[products['change_date'] <= target_date]

    # Step 2: For each product, find the row with the latest change_date <= target_date
    latest_changes = df_past.sort_values(['product_id', 'change_date']) \
                            .groupby('product_id') \
                            .last() \
                            .reset_index()

    # Step 3: Get list of all product_ids from the full dataset
    all_products = products['product_id'].unique()

    # Step 4: Create a DataFrame with all products and merge with latest_changes to fill missing prices
    result = pd.DataFrame({'product_id': all_products})

    result = result.merge(latest_changes[['product_id', 'new_price']], on='product_id', how='left')

    # Step 5: Fill missing prices with default price 10
    result['price'] = result['new_price'].fillna(10).astype(int)

    # Drop the intermediate column
    result = result.drop(columns=['new_price'])

    # Display result
    return(result)
