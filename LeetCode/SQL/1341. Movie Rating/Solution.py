import pandas as pd

def movie_rating(movies: pd.DataFrame, users: pd.DataFrame, movie_rating: pd.DataFrame) -> pd.DataFrame:
    
    users_movie_count_df = movie_rating.merge(users, on="user_id", how="left", suffixes=["_mr", "_u"])
    movie_count_df = users_movie_count_df.groupby(by="name").size().reset_index()
    
    movie_count_df.columns = ["results", "movie_count"]
    movie_count_df = movie_count_df.sort_values(by=["movie_count", "results"], ascending=[False, True])[["results"]].head(1)

    movie_rating_df = movie_rating.merge(movies, on="movie_id", how="left", suffixes=["_mr", "_m"])
    movie_rating_df["created_at"] = pd.to_datetime(movie_rating_df["created_at"])
    movie_rating_df = movie_rating_df[(movie_rating_df["created_at"] >= '2020-02-01' ) & (movie_rating_df["created_at"] <= '2020-02-29' )]
    movie_rating_df = movie_rating_df.groupby(by="title").mean().reset_index()
    movie_rating_df = movie_rating_df[["title", "rating"]]
    movie_rating_df.columns = ["results", "movie_rating"]
    movie_rating_df = movie_rating_df.sort_values(by=["movie_rating", "results"], ascending=[False, True])[["results"]].head(1)

    return pd.concat([movie_count_df[["results"]], movie_rating_df[["results"]]], ignore_index=True)
