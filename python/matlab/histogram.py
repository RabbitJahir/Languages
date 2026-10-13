import matplotlib.pyplot as mat
import numpy as np

# loc is middle, mean position
scores = np.random.normal(loc=80, scale=10, size=100)

# bins = x axis bars
mat.hist(scores, bins=10, color="lightgreen", edgecolor="black")

mat.show()
