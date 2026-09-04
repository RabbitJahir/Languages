import math

# Input embedding
x = [0.2, -0.4, 0.7, 0.1]

# Weights
W = [
    [0.1, 0.2, -0.3],
    [0.4, -0.5, 0.6],
    [-0.7, 0.8, 0.9],
    [0.2, -0.1, 0.3]
]

# Bias
bias = [0.1, -0.2, 0.3]


# -------------------------
# Linear layer
# -------------------------

logits = []

for j in range(3):

    total = 0

    for i in range(4):
        total += x[i] * W[i][j]

    total += bias[j]

    logits.append(total)


# -------------------------
# Softmax
# -------------------------

exp_values = []

for value in logits:
    exp_values.append(math.exp(value))

total = sum(exp_values)

probabilities = []

for value in exp_values:
    probabilities.append(value / total)


print("Logits:")
print(logits)

print("Probabilities:")
print(probabilities)