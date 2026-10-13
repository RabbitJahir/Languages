import matplotlib.pyplot as mat
import numpy as np


x = np.array([2023,2024,2025,2026])
green = np.array([10, 25, 35, 50])
blue = np.array([40,50,52,54])
red = np.array([20,29,32,44])

line_style = dict(lw="3", marker="*", ms="12")

mat.plot(x, red, c="red", **line_style)

mat.plot(x, green, c="green", **line_style)

mat.plot(x, blue, **line_style)

# removes random ticks from x axis, try commenting this line and run again
mat.xticks(x)

mat.show()