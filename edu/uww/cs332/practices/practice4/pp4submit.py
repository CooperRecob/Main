import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.preprocessing import MinMaxScaler

df=pd.read_csv('edu/uww/cs332/practices/practice4/iris.csv')

fieldnames=list(df.keys())
print(fieldnames)

labels=np.array(df['variety'])
data=np.array(df.iloc[:,0:4])

ind1=np.where(data[:,0]<5)
ind2=np.where(data[:,2]>2)
ind=np.intersect1d(ind1,ind2)
pruneddata=data[ind,:]
print(pruneddata)

n,m=data.shape
cmean=np.mean(data, axis=0)
data_norm=np.zeros(data.shape)
for i in range(n):
    data_norm[i,:]=data[i,:]-cmean
    s=np.std(data_norm[i,:])
    data_norm[i,:]=data_norm[i,:]/s

scaler=MinMaxScaler((0,1))
scaler.fit(data)
data_norm2=scaler.transform(data)
print(data_norm2)

for k in np.unique(labels):
    ind=np.where(labels==k)
    plt.scatter(data_norm2[ind,0],data_norm2[ind,1],label=k)
plt.legend()
plt.show()

fig=plt.figure(figsize=(10,7))
ax=plt.axes(projection='3d')
for k in np.unique(labels):
    ind=np.where(labels==k)
    ax.scatter3D(data_norm2[ind,0],data_norm2[ind,1],data_norm2[ind,2],label=k)
plt.legend()
plt.show()
