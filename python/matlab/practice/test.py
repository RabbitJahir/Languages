import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

url = "anime.csv"


def homework(anime_data: pd.DataFrame, metric_column: str, n: int) -> pd.Series:
    ranks = anime_data[metric_column].rank(ascending=False, method='first')

    groups = pd.qcut(ranks, q=n)

    divide = anime_data[metric_column].groupby(groups).sum() / anime_data[metric_column].sum()

    divide = divide.sort_values(ascending=False)

    divide.index = [f"Group {i+1}" for i in range(n)]

    return divide