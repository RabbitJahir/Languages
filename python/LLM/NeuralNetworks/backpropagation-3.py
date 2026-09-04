import random


def relu(x):

    if x > 0:
        return x
    else:
        return 0


def relu_derivative(x):

    if x > 0:
        return 1
    else:
        return 0


# -----------------------
# PARAMETERS
# -----------------------

W1 = random.uniform(-1, 1)
b1 = 0

W2 = random.uniform(-1, 1)
b2 = 0

learning_rate = 0.01


# -----------------------
# TRAINING DATA
# -----------------------

data = [
    (1, 2),
    (2, 4),
    (3, 6),
    (4, 8),
    (5, 10),
    (6, 12)
]


# -----------------------
# TRAIN
# -----------------------

for epoch in range(1000):

    total_loss = 0

    for x, target in data:

        # =================
        # FORWARD
        # =================

        z1 = x * W1 + b1

        a1 = relu(z1)

        prediction = a1 * W2 + b2


        # =================
        # LOSS
        # =================

        loss = (prediction - target) ** 2

        total_loss += loss


        # =================
        # BACKPROPAGATION
        # =================

        d_loss = 2 * (prediction - target)


        # W2 / b2

        d_W2 = d_loss * a1

        d_b2 = d_loss


        # hidden layer

        d_a1 = d_loss * W2

        d_z1 = d_a1 * relu_derivative(z1)


        # W1 / b1

        d_W1 = d_z1 * x

        d_b1 = d_z1


        # =================
        # UPDATE
        # =================

        W1 = W1 - learning_rate * d_W1
        b1 = b1 - learning_rate * d_b1

        W2 = W2 - learning_rate * d_W2
        b2 = b2 - learning_rate * d_b2


    if epoch % 100 == 0:
        print(
        "Epoch:", epoch,
        "Loss:", total_loss,
        "W1:", W1,
        "W2:", W2,
        "b1:", b1,
        "b2:", b2
    )


# -----------------------
# TEST
# -----------------------

print("\nTesting:")

# for x, target in data:

#     z1 = x * W1 + b1
#     a1 = relu(z1)

#     prediction = a1 * W2 + b2

#     print(
#         "Input:", x,
#         "Target:", target,
#         "Prediction:", prediction
#     )

x = 7

z1 = x * W1 + b1
a1 = relu(z1)
prediction = a1 * W2 + b2

print("Prediction for 7:", prediction)
