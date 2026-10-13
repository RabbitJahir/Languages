import pandas as pd


df = pd.read_csv("pokemon_data.csv")
df_name = pd.read_csv("pokemon_data.csv", index_col="Name")

# ------ Selection by column

# print(df)
# print(df.to_string()) 
# print(df_name.to_string())

# print(df["Name"])
# print(df["Name"].to_string())
# print(df["Height"].to_string())

# print(df[["Name","Height", "Weight"]].to_string())


# ------ Selection by row

# print(df_name.loc["Venusaur"])

# print(df_name.loc["Charizard", ["Height", "Weight"]])
# print(df_name.loc["Charizard":"Blastoise", ["Height", "Weight"]])

# print(df_name.iloc[0:11])
# print(df_name.iloc[0:11, 0:3])
