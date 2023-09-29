"""practice2.py"""
import pandas as pd

df = pd.read_csv("edu/uww/cs332/practices/mydata.csv")
print(df)
print(df.head())
print(df.size)
print(df.shape)

# switch to array
dfArray = df.values.tolist()

# print the array, length, and first row
print(dfArray)
print(len(dfArray))
print(dfArray[0])

r1 = dfArray[0]

for i in r1:
    print(i)

for i in enumerate(len(r1)):
    print(i, r1[i])

for i in range(len(r1)-1, -1, -1):
    print(r1[i])

for i in range(len(r1)-1, -1, -1):
    print(i, r1[i])

for i in range(10):
    for j in range(10):
        print('*', end='')
    print()

for i in range(5):
    for j in range(i+1):
        print('*', end='')
    print()
