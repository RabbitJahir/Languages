import random

# Training data
data = [
    (1, 3),
    (2, 5),
    (3, 7),
    (4, 9)
]

# Random starting weight
weight = random.uniform(-1, 1)

learning_rate = 0.01

for epoch in range(100):

    total_loss = 0

    for x, target in data:

        # ----------------
        # FORWARD
        # ----------------

        prediction = x * weight

        # ----------------
        # LOSS
        # ----------------

        loss = (prediction - target) ** 2

        total_loss += loss

        # ----------------
        # BACKPROP
        # ----------------

        gradient = 2 * (prediction - target) * x

        # ----------------
        # UPDATE
        # ----------------

        weight = weight - learning_rate * gradient

    print(
        "Epoch:", epoch,
        "Loss:", total_loss,
        "Weight:", weight
    )