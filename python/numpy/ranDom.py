import numpy as np

rng = np.random.default_rng()
fixed_rng = np.random.default_rng(seed=1)
# print(rng)
# print(fixed_rng)


# print(rng.integers(1, 7))
# 
# print(rng.integers(low=1, high=101, size = 5))
# 
# print(rng.integers(low=1, high=101, size = (3,2)))
# 
# print(fixed_rng.integers(1, 7, 4)) # this will now be fixed after the first generation

##############################################################################################

np.random.seed(seed=1)
# print(np.random.uniform(low = -1, high = 1, size=(3,2)))

##############################################################################################


shuffle = np.random.default_rng()
array = np.array([1,2,3,4,5,6])

fruits= np.array(['apple','watermelon','coconut','pineapple'])

shuffle.shuffle(array)
print(array)

print(fruits)

fruit = rng.choice(fruits)
fruit2 = rng.choice(fruits, size=2)
shuffle.shuffle(fruits)

print(fruit)
print(fruit2)