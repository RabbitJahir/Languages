import math


def softmax(values):

    exp_values = []

    for value in values:
        exp_values.append(math.exp(value))

    total = sum(exp_values)

    result = []

    for value in exp_values:
        result.append(value / total)

    return result


def matmul(A, B):

    result = []

    for i in range(len(A)):

        row = []

        for j in range(len(B[0])):

            total = 0

            for k in range(len(B)):

                total += A[i][k] * B[k][j]

            row.append(total)

        result.append(row)

    return result


def transpose(A):

    result = []

    for j in range(len(A[0])):

        row = []

        for i in range(len(A)):
            row.append(A[i][j])

        result.append(row)

    return result


X = [
    [1, 2],
    [3, 1],
    [2, 4]
]


Wq = [
    [1, 0],
    [0, 1]
]

Wk = [
    [1, 0],
    [0, 1]
]

Wv = [
    [1, 0],
    [0, 1]
]


# Q, K, V

Q = matmul(X, Wq)
K = matmul(X, Wk)
V = matmul(X, Wv)


# QK^T

KT = transpose(K)

scores = matmul(Q, KT)


# Scale

dk = len(K[0])

scaled_scores = []

for row in scores:

    new_row = []

    for value in row:
        new_row.append(value / math.sqrt(dk))

    scaled_scores.append(new_row)


# Softmax

attention_weights = []

for row in scaled_scores:
    attention_weights.append(softmax(row))


# Multiply by V

attention_output = matmul(attention_weights, V)


print("Q:")
print(Q)

print("K:")
print(K)

print("V:")
print(V)

print("Scores:")
print(scores)

print("Scaled scores:")
print(scaled_scores)

print("Attention weights:")
print(attention_weights)

print("Attention output:")
print(attention_output)