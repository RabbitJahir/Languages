def apply_merge(tokens, pair):

    i = 0

    while i < len(tokens) - 1:

        if (tokens[i], tokens[i + 1]) == pair:
            tokens[i] = tokens[i] + tokens[i + 1]
            tokens.pop(i + 1)
        else:
            i += 1

    return tokens
###################################


tokens = ["l", "o", "w"]

pair = ("l", "o")

merges = [
    ("l", "o"),
    ("lo", "w")
]



for pair in merges:
    tokens = apply_merge(tokens, pair)

print(tokens)


