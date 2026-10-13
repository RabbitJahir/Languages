# Aggregate function
import pandas as pd

df = pd.read_csv("pokemon_data.csv", index_col="Name")


# print(df.mean(numeric_only=True))
# print(df.sum(numeric_only=True))
# print(df.min(numeric_only=True))
# print(df.max(numeric_only=True))
# print(df.count())


# print(df["Height"].mean())
# print(df["Weight"].max())
# print(df["Height"].min())

group = df.groupby("Type1")

# print(group)
# print(group["Height"].mean())
# print(group["Weight"].max())
# print(group["Height"].count())