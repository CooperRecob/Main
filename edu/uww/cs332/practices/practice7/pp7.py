import numpy as np
import matplotlib.pyplot as plt
from sklearn.metrics.pairwise import euclidean_distances
from sklearn.metrics import confusion_matrix

def myKmeans(data, C, n, k, numiter):
    oldC = C
    O=[]
    for i in range(0, numiter):
        # Assignment step
        D = euclidean_distances(data, C)
        Cls = np.argmin(D, axis=1)

        # Center finding step
        for j in range(0, k):
            indclass = np.where(Cls == j)
            datafromthisclass = np.array(data[indclass, :])

            C[j, :] = np.mean(datafromthisclass, axis=1)
        # to find objective
        D = euclidean_distances(data, C)
        obj = np.min(D, axis=1).sum()
        O.append(obj)
        #print(C, obj)
    #plt.plot(O)
    return Cls, obj


def callKmeans(data, k, n, numIterR):
    O = np.zeros(numIterR)
    Cls_all = np.zeros((numIterR, n))
    for i in range(0, numIterR):
        p = np.random.permutation(n)
        C = data[p[0:k], :]  # random intilization of K centers
        print(C)
        numiter = 100
        Cls, obj = myKmeans(data, C, n, k, numiter)
        O[i] = obj
        Cls_all[i, :] = Cls
    indlowest = np.argmin(O)
    finalClass = Cls_all[indlowest, :]
    return finalClass


data = np.genfromtxt("edu/uww/cs332/practices/practice7/DS2.txt", dtype=float)
n, m = data.shape
label = data[:, m-1]
data = data[:, 0:m-1]
#plt.scatter(data[:, 0], data[:, 1])

k = 6  # number of clusters
Cls = callKmeans(data, k, n, 10)
for i in np.unique(Cls):
    ind = np.where(Cls == i)
    plt.scatter(data[ind, 0], data[ind, 1], label=i)
plt.legend()
plt.show()

#print confusion matrix
C = confusion_matrix(label, Cls)
print(C)
