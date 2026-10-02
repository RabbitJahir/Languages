# numerical python

# numpy is written in C, thus makes the number patterns 10x faster

import numpy

print(numpy.__version__)

###################################

this_list = [1,2,3]

print(this_list * 2) # just doubles the list

###################################
###################################
###################################

new_list = numpy.array([1,2,3])

print(type(new_list))
print(new_list)
print(new_list * 2) # this multiples the digits inside with 2
