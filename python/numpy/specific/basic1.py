import numpy as np

URL = '/home/rabbit/github/Languages/python/numpy/specific/sample_report.csv'

raw = np.loadtxt(URL, delimiter=",", usecols=[6,7,8], skiprows=1)

print(raw.shape)

print(raw[0:7, 0]) # 7x1
print(raw[:7, 0:]) # 7x2