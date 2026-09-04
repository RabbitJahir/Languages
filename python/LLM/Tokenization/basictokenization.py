text="hello"

# make letters be numbers
for letter in text:
    print(letter, ord(letter))


# give numbers to words
vocab = {
    "i":1,
    "love":2,
    "rabbits":3
}

sentence = "I Love Rabbits"

# lower case the sentence and split into words
words = sentence.lower().split()

# match words and vocab then print
for word in words:
    print(vocab[word])