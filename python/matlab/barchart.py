import matplotlib.pyplot as mat
import numpy as np

devil_fruit_types = np.array(["Paramecia", "Zoan", "Logia", "SMILE Fruits"])
users = np.array([94,57,13,200])


mat.bar(devil_fruit_types, users)
# mat.barh(devil_fruit_types, users)

mat.title("Amount of fruits for each types", fontsize="20", fontweight="bold")
mat.xlabel("Devil fruit types")
mat.ylabel("Number of fruits")

mat.tick_params(axis="both", color="red")
mat.show()