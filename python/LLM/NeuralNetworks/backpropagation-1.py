weight = 0.3

learning_rate = 0.1

x = 1
target = 1

for epoch in range(10):

    # -----------------
    # FORWARD
    # -----------------

    prediction = x * weight

    # -----------------
    # LOSS
    # -----------------

    loss = (prediction - target) ** 2

    # -----------------
    # BACKPROPAGATION
    # -----------------

    gradient = 2 * (prediction - target) * x

    # -----------------
    # UPDATE
    # -----------------

    weight = weight - learning_rate * gradient

    print(
        "Epoch:", epoch,
        "Prediction:", prediction,
        "Loss:", loss,
        "Weight:", weight
    )