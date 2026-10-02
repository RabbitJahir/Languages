import pandas as pd

data = [100,401,205,102,104,202,223,280,501,203]
data1 = [100.1,100.4,104.8]
data2 = [100.1,"A",102,104]

indexs=["a","b","c","d"]

series = pd.Series(data)
series1 = pd.Series(data1, index=["a","b","c"])
series2 = pd.Series(data2, index=indexs)

# print(data2)

# print(series)
# print(series1)
# print(series2)

# loc = location by label
# iloc = location by index

# print(series2.loc["b"])
# print(series.iloc[0],series.iloc[1])

# print(series[series>=200])
# print(series[(series>=200) & (series<=300)])
