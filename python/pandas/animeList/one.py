import pandas as pd

anime = pd.read_csv("anime_cleaned.csv")

Columns = [
    [0, "MAL_ID"],
    [1, "Name"],
    [2, "Score"],
    [3, "Genres"],
    [4, "English name"],
    [5, "Japanese name"],
    [6, "Type"],
    [7, "Episodes"],
    [8, "Aired"],
    [9, "Premiered"],
    [10, "Producers"],
    [11, "Licensors"],
    [12, "Studios"],
    [13, "Source"],
    [14, "Duration"],
    [15, "Rating"],
    [16, "Ranked"],
    [17, "Popularity"],
    [18, "Members"],
    [19, "Favorites"],
    [20, "Watching"],
    [21, "Completed"],
    [22, "On-Hold"],
    [23, "Dropped"],
    [24, "Plan to Watch"],
    [25, "Score-10"],
    [26, "Score-9"],
    [27, "Score-8"],
    [28, "Score-7"],
    [29, "Score-6"],
    [30, "Score-5"],
    [31, "Score-4"],
    [32, "Score-3"],
    [33, "Score-2"],
    [34, "Score-1"]
]


def homework(anime_data_extracted):

    result = anime_data_extracted.groupby("Type")["Score"].mean().sort_values(ascending=False)

    return result

print(homework(anime))









