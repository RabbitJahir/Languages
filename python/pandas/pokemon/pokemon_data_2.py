import pandas as pd

df = pd.read_csv("pokemon_data.csv", index_col="Name")

tall_pokemon = df[df["Height"] >=2]

heavy_pokemon = df[df["Weight"] >=100]

legendary = df[df["Legendary"] == 1 ]

water = df[ (df["Type1"] == "Water") |  (df["Type2"] == "Water")]

print(water)