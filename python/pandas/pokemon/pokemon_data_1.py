import pandas as pd

pokedata = pd.read_csv("pokemon_data.csv", index_col="Name")


while True:
    pokemon_name = input("Enter pokemon name: ")


    if(pokemon_name=="q"):
        break

    try:
        print(pokedata.loc[pokemon_name])
        print()
    except KeyError:
        print(f"{pokemon_name} not found.")