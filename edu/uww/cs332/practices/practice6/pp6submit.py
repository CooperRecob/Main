import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.metrics import confusion_matrix

df = pd.read_csv('edu/uww/cs332/practices/practice6/iris.csv')

fieldnames = list(df.keys())

labels = np.array(df['variety'])

labels_int = np.zeros(150, dtype=int)
for i in range(len(labels)):
    if labels[i] == 'Setosa':
        labels_int[i] = 0
    elif labels[i] == 'Versicolor':
        labels_int[i] = 1
    elif labels[i] == 'Virginica':
        labels_int[i] = 2

data = np.array(df.iloc[:,0:4])

plt.scatter(data[:,0], data[:,1], c=labels_int)
plt.xlabel(fieldnames[0])
plt.ylabel(fieldnames[1])
plt.show()

def find_index_thres(data, cols, thresholds):
    ind = np.ones(len(data), dtype=bool)
    for i, col in enumerate(cols):
        if col < data.shape[1]:
            ind = ind & (data[:,col] >= thresholds[i][0]) & (data[:,col] <= thresholds[i][1])
    return ind

thresholds = [[4.5, 7], [2.5, 3.5]]

ind = find_index_thres(data, [0,1], thresholds)

predict = np.zeros(data.shape[0], dtype=int)
predict[ind] = 1

accuracy = np.sum(predict == labels_int)/len(labels_int)
print("Accuracy:", accuracy)

cm = confusion_matrix(labels_int, predict)
print("Confusion Matrix:\n", cm)

for i in range(len(cm)):
    tp = cm[i,i]
    fp = np.sum(cm[:,i]) - tp
    fn = np.sum(cm[i,:]) - tp
    print("Class", i, "TP:", tp, "FP:", fp, "FN:", fn)
