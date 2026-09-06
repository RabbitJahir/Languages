import math

logits = [0.2, 2.5, -0.4]

exp_values = []

for value in logits:
    exp_values.append(math.exp(value))

total = sum(exp_values)

probabilities = []

for value in exp_values:
    probabilities.append(value / total)

print(probabilities)