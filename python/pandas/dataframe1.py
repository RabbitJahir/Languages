import pandas as pd

data = {"Name": ["Spongebob", "Patrick", "Sandy", "Squidward"],
        "Age": [23,25,26,31]}

df = pd.DataFrame(data, index=["Employee 1","Employee 2","Non-Employee","Employee 3"])

# print(df.iloc[0])

# new column
df["Position"] = ["Cook", "Player", "Boxer", "Cashier"]

# print(df)

# new row

new_row = pd.DataFrame([
    {"Name": "Eugene Krabs", "Age": 45, "Position": "Owner of Krabby paddy"},
    {"Name": "Plankton", "Age": 35, "Position": "Another restaurent owner"}],
                       index = ["Owner", "Owner2"])

df = pd.concat([df, new_row])

print(df)