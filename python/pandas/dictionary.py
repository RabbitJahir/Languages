import pandas as pd

calories = {"Days": "Calories eaten","Day 1": 1750,"Day 2": 2300, "Day 3": 1800, "Day 4": 1500}

test = pd.Series(calories)

# print(test)
# print(test.loc["Day 1"])

calories2 = {"Day 1": 1750,"Day 2": 2300, "Day 3": 1800, "Day 4": 1500}
test2 = pd.Series(calories2)

more_than_2k = test2[test2 <= 2000]

print(more_than_2k)