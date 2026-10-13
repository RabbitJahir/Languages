import matplotlib.pyplot as mat
import numpy as np

devil_fruit_types = np.array(["Paramecia", "Zoan", "Logia", "SMILE Fruits"])
users = np.array([94,57,13,200])
colors= ["blue", "orange", "red", "yellow"]

mat.pie(users, labels=devil_fruit_types, autopct="%1.1f%%", colors=colors, explode=[0,0,0.05,0],
        shadow=True, startangle=300)

mat.title("Amount of devil fruits")
mat.show()