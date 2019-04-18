
逻辑函数（sigmoid函数）定义的累计分布又叫逻辑斯蒂分布，对分布函数求导得到概率密度函数。

#logistic regression
from sklearn.linear_model import LogisticRegression
logreg = LogisticRegression().fit(train_feature, train_label)
print("Training set score: {:.3f}".format(logreg.score(train_feature, train_label)))
print("Test set score: {:.3f}".format(logreg.score(test_feature, test_label)))
print("Number of features used: {}".format(np.sum(logreg.coef_ != 0)))
print(logreg.coef_)  

from matplotlib import pyplot as plt
plt.plot(logreg.coef_.T, 'o',label="lambda=1")
plt.xticks(range(feature_num),col_names[0:feature_num],rotation=90)
xlims = plt.xlim()
plt.hlines(0, xlims[0], xlims[1])
plt.xlim(xlims)
plt.ylim(-5, 5)
plt.xlabel("feature names")
plt.ylabel("Coefficient magnitude")
plt.legend()
plt.show()
