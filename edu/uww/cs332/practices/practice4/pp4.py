import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

A=np.array([1,2,3,4,5])
print(len(A), A.shape)
print(A[2:])
for a in A:
    print(a)
B=np.ones(5) #1d array
C=np.zeros((5,5)) #2d array pass a tuple with the dimensions

A=100*np.random.rand(5,5)
B=100*np.random.rand(5,5)
print(A+B, A-B, A*B, A/B) #point operations

X=np.array([[1,2,3,4],[5,6,7,8],[9,10,11,12]]) #initialize 2d array
print(X.size)
print(X[:,:2], X[:,2], X[1,:])

Y=X.transpose() #transpose
print(Y.size)
print(Y)
csum=np.sum(X, axis=0) #sum along columns
print(csum)
rsum=np.sum(X, axis=1) #sum along rows
print(rsum)

print(X.dot(Y)) #matrix multiplication
