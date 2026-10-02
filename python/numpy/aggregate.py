import numpy as np

array = np.array([[1,2,3,4,5],
                  [6,7,8,9,10]])

print(np.sum(array))
print(np.sum(array, axis = 0)) # sum columns
print(np.sum(array, axis = 1)) # sum rows

print()
print(np.mean(array))

print()
print(np.max(array))
print(np.argmax(array))

print()
print(np.min(array))
print(np.argmin(array))

print()
print(np.std(array))
print(np.var(array))
##########