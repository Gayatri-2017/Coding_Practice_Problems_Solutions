import pandas as pd

def find_covid_recovery_patients(patients: pd.DataFrame, covid_tests: pd.DataFrame) -> pd.DataFrame:

    covid_tests["test_date"] = pd.to_datetime(covid_tests["test_date"])

    positives = covid_tests[covid_tests["result"] == "Positive"].copy().sort_values("test_date").groupby("patient_id", as_index=False).first()
    negatives = covid_tests[covid_tests["result"] == "Negative"].copy()


    joined_df = positives.merge(negatives,on="patient_id",suffixes=('_pos', '_neg'))

    joined_df = joined_df[joined_df["test_date_pos"] < joined_df["test_date_neg"]]

    joined_df = joined_df.sort_values("test_date_neg").groupby("patient_id", as_index=False).first()

    joined_df["recovery_time"] = (joined_df["test_date_neg"] - joined_df["test_date_pos"]).dt.days
    joined_df = joined_df.merge(patients, on="patient_id", how="left")

    joined_df = joined_df[["patient_id", "patient_name", "age", "recovery_time"]]
    joined_df = joined_df.sort_values(by=["recovery_time", "patient_name"], ascending=[True, True])

    return joined_df
