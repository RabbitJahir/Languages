import matplotlib.pyplot as mat

x = [1,2,3,4,5,6,7,8,9,10]
y = [40,35,55,65,70,100,130,150,200,300]

x1 = [4,1,3,6,5,6,5,8,9,10]
y1 = [19,34,190,12,34,54,120,110,140,200]

mat.scatter(x,y, label="Zed", color="red")
mat.scatter(x1,y1, label="Xex", color="blue")

mat.legend()
mat.show()