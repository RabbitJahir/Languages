import numpy as np

array0 = np.array('A')
array1 = np.array(['A','B','c'])
array2 = np.array([
                    ['A','B','c'],
                    ['apple', 'bagan', 'cha']
                    ])

array3 = np.array([
                    [    
                    ['a','b','1'],
                    ['c','d','1']
                ],
                    [
                    ['e','f','1'],
                    ['g','h','1']
                ],
                    [
                    ['i','j','o'],
                    ['k','l','1']
                ]
                    ])

####################################

print(array0.ndim) # number of dimensions
print(array1.ndim)
print(array2.ndim)
print(array3.ndim)

####################################

print(array1.shape) # row
print(array2.shape) # row, column
print(array3.shape) # layer, row, column


####################################

print(array3[1][0][1]) # chain indexing
print(array3[1,0,1]) # multidemensional indexing is faster 

####################################

word = array3[1,0,1] + array3[2,1,1] + array3[2,0,2] + array3[0,1,0] + array3[2,1,0]
print(word)