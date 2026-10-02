import numpy as np

ages = np.array([[21,19,16,18,27,41,52],
                 [39,23,13,15,17,61,29]])

teenages = ages[ages<18]
adults = ages[(ages>=18) & (ages<30)]
seniors = ages[ages>=30]

adult_fill = np.where(ages>=18, ages, 0) # slower, although preserves the previous shape


print(teenages)
print(adults)
print(seniors)

print()
print(adult_fill)