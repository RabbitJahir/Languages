import matplotlib.pyplot as mat

x = [1,2,3,4,5]
y = [10,20,30,40,50]

# mat.grid()
# mat.grid(axis="x")
# mat.grid(axis="y")

mat.grid(linewidth="2", color="orange", linestyle="dotted")

mat.plot(x,y)
mat.show()