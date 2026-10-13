import matplotlib.pyplot as plt
import numpy as np

# print(matplotlib.__version__) 

x = np.array([2018,2019,2020,2021,2022,2023,2024,2025,2026])
y = np.array([8,9,8,3,6,5,4,3,7])

plt.plot(x, y)

plt.show()