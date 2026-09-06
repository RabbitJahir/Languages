## Byte Pair Encoding


# Give words directly, into letters
words = [
    ["l", "o", "w"],
    ["l", "o", "w", "e", "r"],
    ["l", "o", "w", "e", "s", "t"]
]

merges = []

# run untill the words are formed
n=0
while n <6:
# 1 pair counts
    pair_count={}

# go through each row
    for row in words:

        for j in range (len(row)-1):
            # make pairs of 2 letters, 
            pair = (row[j],row[j+1])

            # search / put the pairs in pair_count and count them
            if pair in pair_count:
                pair_count[pair]+=1
            else:
                pair_count[pair]=1

    # 1 mixed with 2- most common find

    # max(letters/words, with key/value)
    # get the letters with most values, most used
    most_common = max(pair_count,key=pair_count.get)

    # saving the most_common
    merges.append(most_common)


    # 3 merging most-common
    # change the original letter list, find the most common and merge them under one string
    for row in words:

        i = 0

        while i<len(row)-1:

            if (row[i],row[i+1])==most_common:

                row[i]=most_common
                row.pop(i+1)
            else:
                i+=1
    n+=1

print(words)
print(merges)