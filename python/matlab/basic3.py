import matplotlib.pyplot as mat
import numpy as np

outer_style=dict(family="Tahoma", fontweight="bold")

mat.title("Lays Color popularity", fontsize="20", color="green", **outer_style)
mat.xlabel("Year", **outer_style)
mat.ylabel("Loved by people in Argentina (Percent)", **outer_style)

x = np.array([2021,2022,2023,2024,2025,2026])
green = np.array([0,15,20,35,55,75])
blue = np.array( [0,55,57,60,39,21])
red = np.array(  [0,30,23, 5, 6, 4])

line_style = dict(lw="3", marker="*", ms="12")

mat.plot(x, red, c="red", **line_style)

mat.plot(x, green, c="green", **line_style)

mat.plot(x, blue, **line_style)

mat.tick_params(axis="both", colors="purple")

mat.show()