words = [
    ["l", "o", "w", "</w>"],
    ["l", "o", "w", "e", "r", "</w>"],
    ["l", "o", "w", "e", "s", "t", "</w>"]
]

vocab = {}

# turn each letter into an unique number identifier
# </w>, word ender,
for row in words:
    for token in row:
        if token not in vocab:
            vocab[token] = len(vocab)

merges = []

num_merges = 9

for _ in range(num_merges):

    pair_count = {}

    # Count pairs
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

                # new words are sent to vocab with new unique len
                new_token = row[i] + row[i + 1]
                
                if new_token not in vocab:
                    vocab[new_token] = len(vocab)

                row[i] = row[i] + row[i + 1]
                row.pop(i + 1)

            else:
                i += 1


print("Vocabulary")
print(vocab)
print("Learned merges:")
print(merges)

print("Final words:")
print(words)