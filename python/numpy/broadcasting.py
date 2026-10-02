# allows numpy to perform arithmetics on different dimension matrix 
# row and must columns must match or be 1
import numpy as np

arr1 = np.array([[1,2,3,4]]) 
arr2 = np.array([[1],[2],[3],[4]]) 
arr3 = np.array([[1,2,3,4],
                [5,6,7,8],
                [9,10,11,12],
                [13,14,15,16]])


print(arr1.shape)
print(arr2.shape)
print(arr3.shape)
print()
print(arr1 * arr2)
print(arr2*arr3)
print()
####################################################

array1 = np.array([[1,2,3,4,5,6,7,8,9,10]])
array2 = np.array([[1],[2],[3],[4],[5],[6],[7],[8],[9],[10]])

print(array1 * array2)