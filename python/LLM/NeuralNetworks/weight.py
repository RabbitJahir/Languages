x = [0.2, -0.4, 0.7, 0.1]

W = [
    [0.1, 0.2, -0.3],
    [0.4, -0.5, 0.6],
    [-0.7, 0.8, 0.9],
    [0.2, -0.1, 0.3]
]

# logits
outputs = []

for j in range(3):

    total = 0

    for i in range(4):
        total += x[i] * W[i][j]

    outputs.append(total)

print(outputs)