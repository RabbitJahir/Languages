# cleaning
import pandas as pd

df = pd.read_csv("pokemon_data.csv", index_col="Name")

# df = df.drop(columns="Legendary")

# df = df.drop(columns=["Legendary", "No"])

# print(df)

# dropna = drop not available
# df = df.dropna(subset = ["Type2"])
# print(df.to_string())

# df = df.fillna({"Type2": "None"})

# df["Type1"] = df["Type1"].replace({"Grass": "GRASS"})

# because name is now the index, otherwise would have called name like i did with type1
# df.index = df.index.str.lower()

# df["Legendary"] = df["Legendary"].astype(bool)

# df = df.drop_duplicates()

# print(df.to_string())