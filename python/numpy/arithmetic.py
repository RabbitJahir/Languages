import numpy as np

# scalar arithmetic

array = np.array([1,2,3])

print(array + 1 )
print(array - 3 )
print(array / 2 )
print(array % 2 )
print(array ** 2 )
print(array * 3 )


# vectorized math functions

array1 = np.array([1.43,4.5,6.78])

print(np.sqrt(array))

print(np.floor(array1))
print(np.ceil(array1))
print(np.pi)

radius = np.array([3,2,4.5])

print(np.pi * (radius ** 2) )

# element wise arithmetic

arr1 = np.array([1,3,4])
arr2 = np.array([1,3,4])

print(arr1 + arr2)
print(arr1 - arr2)
print(arr1 / arr2)
print(arr1 ** arr2)

# comparion operator

scores = np.array([91,10,100,45,78,91,88])

print(scores == 100)
print(scores > 90)
print(scores < 60)

# filtering

scores[scores<60] = 0

print(scores)

