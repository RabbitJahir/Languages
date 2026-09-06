import math

probabilities = [0.8, 0.1, 0.1]

target = 1

loss = -math.log(probabilities[target])

print(loss)