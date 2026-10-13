import matplotlib.pyplot as plt
import numpy as np

# print(matplotlib.__version__) 

x = np.array([2018,2019,2020,2021,2022,2023,2024,2025,2026])
y = np.array([4,8,7,5,5,7,4,3,2])

plt.plot(x, y, marker="H", markersize="20", markerfacecolor="red", markeredgecolor="black", linestyle="dashdot", linewidth="5", color="green")

# matplotlib markers
# . , o v ^ < > 1 2 3 4 8 s p * h H + x 

# marker, m
# markersize, ms
# markerfacecolor, mfc
# markeredgecolor, mec
# linestyle, ls
# linewidth, lw
# color, c


plt.show()