Dynamic Network Embedding by Modeling Triadic Closure Process


Network embedding

将网络中的节点用比较低维的向量去表达，同时在这个向量空间中，网络结构的一些性质仍能够保持。

传统的network embedding很难能够获取到这些结构的演变模式。


网络表示学习

向量化（Embedding）技术

动态网络中的网络嵌入问题，即动态网络嵌入，已经变得越来越流行，一方面它继承了网络嵌入的所有优点——为图像提取可靠的压缩特征，另一方面它适用于动态场景，这在我们现实世界中是经常遇到的。据我们所知，目前还没有一种被广泛接受的动态网络嵌入算法在实践中被证明是运行良好的。

大多数现有的动态网络嵌入算法普遍持两种常见的假设，即社会同质性（social homophily）和时间平滑性（temporal smoothness）[6,7]。



我们先定义了每个假设的损失函数，然后将嵌入（embedding）任务转化为优化问题。用EM算法可以有效地解决优化问题。关于损失函数的详细介绍，可参阅文献[1]。



向量化（Embedding）技术


在这些方法中，受研究和应用关注最多的就是节点向量化（Node Embedding），即对于一个图 G=(V,E)G=(V,E)，学习一种映射：

f:vi→zi∈ℝd

准确率(Accuracy), 精确率(Precision), 召回率(Recall)和F1-Measure


[An introduction to machine learning on graph databases](https://medium.com/octavian-ai/an-introduction-to-machine-learning-on-graph-databases-24ee502fd12e)ls

### References:
1. [Representation Learning on Network 网络表示学习笔记 - CSDN博客](https://blog.csdn.net/u012052268/article/details/78985331)
2. [机器学习降维算法四：Laplacian Eigenmaps 拉普拉斯特征映射 - CSDN博客](https://blog.csdn.net/xbinworld/article/details/8855796)
3. [网络表示学习概述](https://zhuanlan.zhihu.com/p/32504175)
4. 