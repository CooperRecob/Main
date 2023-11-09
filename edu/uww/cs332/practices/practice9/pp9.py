import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.metrics.pairwise import euclidean_distances
from sklearn.metrics import confusion_matrix
import scipy.stats as sp
from PP8 import normalize
from PP8 import myKNN

df = pd.read_csv('titanic_train.csv')[['Age', 'Pclass', 'Fare', 'SibSp', 'Parch', 'Survived']]
df.head()
test = df[df.isnull().any(axis=1)]
train = df.drop(test.index)

train_label = train['Age'].to_numpy()
train_data = train.drop(columns=['Age']).to_numpy()

test_label = test['Age'].to_numpy()
test_data = test.drop(columns=['Age']).to_numpy()

n1,m = train_data.shape
n2,m = test_data.shape

data = np.concatenate((train_data, test_data), axis=0)
data = normalize(data)
data_train = data[0:n1,:]
data_test = data[n1:n1+n2,:]
k=19
predict_test = myKNN(data_train, train_label, data_test, k)

knn = KNeighborsClassifier(n_neighbors=k)
param_grid = {'n_neighbors': np.arange(1, 100)}
knn_opt = GridSearchCV(knn, param_grid, cv=5)
knn_opt.fit(data_train, np.round(train_label, 0))
print(knn_opt.best_params_)

knn.fit(data_train, np.round(train_label))
predict_test2 = knn.predict(data_test)
print(predict_test, predict_test2)
notmatching = (predict_test != predict_test2).astype('uint8').sum()/n2
print(notmatching)
