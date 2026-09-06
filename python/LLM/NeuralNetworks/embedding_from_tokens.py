words = [
    ["I", "</w>"],
    ["L", "i", "k", "e", "</w>"],
    ["r", "a", "b", "b", "i", "t", "s", "</w>"]
]

import string

vocab = {}

for letter in string.ascii_lowercase:
    vocab[letter] = len(vocab)

vocab["</w>"] = len(vocab)
vocab["<UNK>"] = len(vocab)

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
print(vocab, len(vocab))

print("Merges:")
print(merges)

print("Words:")
print(words)


# BPE TOKENIZER

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

# !
tokens, ids = tokenize_sentence("banana", merges, vocab)

print("\nTokens:", tokens,"\nIDs:", ids, "\nLength: ",len(tokens))
###################################

vocab_size = len(vocab)
embedding_dim=8
print("Embedding_dim: ",embedding_dim)

import random

embedding = []

for _ in range(vocab_size):
    vector = []

    for _ in range(embedding_dim):
        vector.append(random.uniform(-1,1))

    embedding.append(vector)
embedded_tokens = []

for each_id in ids:
    embedded_tokens.append(embedding[each_id])

# print (embedding)
# print(embedded_tokens)

#########################################

import math

def positional_encoding(sequence_length, embedding_dim):
    positional_encoding = []
    for pos in range(sequence_length):
        row = []

        for i in range(embedding_dim):

            if i%2 == 0:
                value = math.sin(
                        pos / ( 10000 ** (i/embedding_dim) )
                    )
            else:
                value = math.cos(
                        pos/ ( 10000 ** ( (i-1)/embedding_dim ))
                    )
            row.append(value)

        positional_encoding.append(row)

    return positional_encoding

pe = positional_encoding( len(embedded_tokens), embedding_dim )

#######################################

final_input = []

for i in range (len(embedded_tokens)):

    row = []
    for j in range(embedding_dim):
            row.append(
                embedded_tokens[i][j] + pe[i][j]
            )
    final_input.append(row)


print(final_input)

####################### Weights

def random_matrix(rows, cols):

    matrix = []

    for _ in range(rows):

        row = []

        for _ in range(cols):
            row.append(random.uniform(-1, 1))

        matrix.append(row)

    return matrix

Wq = random_matrix(embedding_dim, embedding_dim)
Wk = random_matrix(embedding_dim, embedding_dim)
Wv = random_matrix(embedding_dim, embedding_dim)

##################################

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

Q = matmul(final_input, Wq)
K = matmul(final_input, Wk)
V = matmul(final_input, Wv)

# print(len(Q), len(Q[0]))
# print(len(K), len(K[0]))
# print(len(V), len(V[0]))

def transpose(A):

    result = []

    for j in range(len(A[0])):

        row = []

        for i in range(len(A)):
            row.append(A[i][j])

        result.append(row)

    return result

KT = transpose(K)
scores = matmul(Q, KT)

# print(len(scores))
# print(len(scores[0]))

dk = len(K[0])

scaled_scores = []

for row in scores:

    new_row = []

    for value in row:
        new_row.append(value / math.sqrt(dk))

    scaled_scores.append(new_row)

attention_weights = []

for row in scaled_scores:

    attention_weights.append(
        softmax(row)
    )

# for row in attention_weights:
#     print(sum(row))

attention_output = matmul(attention_weights, V)

print(len(attention_output))
print(len(attention_output[0]))
