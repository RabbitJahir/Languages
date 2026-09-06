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

print (positional_encoding(3,5) )