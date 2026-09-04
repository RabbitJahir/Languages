vocab = {
    "I": 0,
    "like": 1,
    "rabbits": 2,
    "dogs": 3
}

training_data = [
    (0, 1),
    (1, 2),
    (2, 3)
]

import random
import math

vocab_size = 4
embedding_dim = 3

embedding = []

for _ in range(vocab_size):

    row = []

    for _ in range(embedding_dim):
        row.append(random.uniform(-1, 1))

    embedding.append(row)

def random_matrix(rows, cols):

    matrix = []

    for _ in range(rows):

        row = []

        for _ in range(cols):
            row.append(random.uniform(-1, 1))

        matrix.append(row)

    return matrix

W = random_matrix(embedding_dim, vocab_size)

input_id = 0
target_id = 1

x = embedding[input_id]

print("Input embedding:", x)


logits = []

for j in range(vocab_size):

    score = 0

    for i in range(embedding_dim):
        score += x[i] * W[i][j]

    logits.append(score)

print("Logits:", logits)

def softmax(values):

    max_value = max(values)

    exp_values = []

    for value in values:
        exp_values.append(
            math.exp(value - max_value)
        )

    total = sum(exp_values)

    result = []

    for value in exp_values:
        result.append(value / total)

    return result

probabilities = softmax(logits)

print("Probabilities:", probabilities)

loss = -math.log(probabilities[target_id])

print("Loss:", loss)

d_logits = probabilities.copy()

d_logits[target_id] -= 1

print("Gradient:", d_logits)


dW = []

for i in range(embedding_dim):

    row = []

    for j in range(vocab_size):

        row.append(
            x[i] * d_logits[j]
        )

    dW.append(row)

learning_rate = 0.1

for epoch in range(1000):

    # forward
    x = embedding[input_id]

    logits = []

    for j in range(vocab_size):

        score = 0

        for i in range(embedding_dim):
            score += x[i] * W[i][j]

        logits.append(score)

    probabilities = softmax(logits)

    loss = -math.log(probabilities[target_id])


    # update
    for i in range(embedding_dim):

        for j in range(vocab_size):
            W[i][j] -= learning_rate * dW[i][j]

    if epoch % 100 == 0:
        print("Epoch:", epoch, "Loss:", loss)