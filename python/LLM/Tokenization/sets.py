dictionary = ["i","my","you","mine","him","her","their","them","name","am","is","are","rabit","mamunur","kamrul","kanji","how","what","when","born","hello"]

vocab = {}

# 0 to end of dictionary, each word that is words are given a value
for i,each_word in enumerate(dictionary):
    vocab[each_word]=i

sentence = "My name is rabit"

words = sentence.lower().split()

tokens=[]

# match words and give the unique numbers
for word in words:
    tokens.append(vocab[word])

print(tokens)