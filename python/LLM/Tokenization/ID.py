words = [
    ["l", "o", "w", "</w>"],
    ["l", "o", "w", "e", "r", "</w>"],
    ["l", "o", "w", "e", "s", "t", "</w>"]
]

vocab = {}

for row in words:
    for token in row:
        if token not in vocab:
            vocab[token] = len(vocab)

vocab["<UNK>"] = len(vocab)

merges = []

num_merges = 9

for _ in range(num_merges):

    pair_count = {}

    # make pairs
    for row in words:

        for j in range(len(row) - 1):

            pair = (row[j], row[j + 1])

            if pair in pair_count:
                pair_count[pair] += 1
            else:
                pair_count[pair] = 1

    # Find most common pair
    most_common = max(pair_count, key=pair_count.get)

    # Remember the merge rule
    merges.append(most_common)

    # Merge
    for row in words:

        i = 0

        while i < len(row) - 1:

            if (row[i], row[i + 1]) == most_common:

                new_token = row[i] + row[i + 1]

                if new_token not in vocab:
                    vocab[new_token] = len(vocab)

                row[i] = new_token
                row.pop(i + 1)

            else:
                i += 1

print("Vocabulary:")
print(vocab)

print("Merges:")
print(merges)

print("Words:")
print(words)


# =========================
# BPE TOKENIZER
# =========================

def tokenize(word, merges, vocab):

    word = word.strip().lower()

    tokens = list(word) + ["</w>"]

    for pair in merges:

        i = 0

        while i < len(tokens) - 1:

            if (tokens[i], tokens[i + 1]) == pair:

                tokens[i] = tokens[i] + tokens[i + 1]
                tokens.pop(i + 1)

            else:
                i += 1

    ids = []

    for token in tokens:
        if token in vocab:
            ids.append(vocab[token])
        else:
            ids.append(vocab["<UNK>"])

    return tokens, ids

def tokenize_sentence(sentence, merges, vocab):

    words = sentence.lower().split()

    all_tokens = []
    all_ids = []

    for word in words:

        tokens, ids = tokenize(word, merges, vocab)

        all_tokens.extend(tokens)
        all_ids.extend(ids)

    return all_tokens, all_ids

# =========================
# TEST
# =========================

tokens, ids = tokenize_sentence("big lowes lowerest", merges, vocab)

print("Tokens:", tokens)
print("IDs:", ids)

