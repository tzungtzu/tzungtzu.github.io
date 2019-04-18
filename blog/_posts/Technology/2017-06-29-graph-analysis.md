## Graph Analysis


## Centrality
+ node centrality
	* $C_d（v_i）=\frac{d_i}{n-1}$
+ closeness centrality
	* $C_c(v_i)=\frac{1}{\frac{\Sigma_j(l_{ij})}{n-1}}$
	* 那些在社交网络中经常与人互动、人际关系颇好的人，比如公司中的八卦传播者，往往亲近中心性得分较高。
	* 消息传播者
+ betweenness centrality
	* $C_b(v_i)=\frac{\Sigma l_{st}(i)}{l_{st}}$
	* $c_b(v_i)_{norm} = \frac{c_b(v_i)}{(n-1)(n-2)}$
	* 节点的居间程度越大，那么它在节点相互之间的信息传播起到的作用也就越大。在两个社会网络之间的人，比如跨界者，往往拥有较高的居间中心性。
	* 所以在社区分析的时候，也是重要的评判标准

 <!--more-->

+ eigenvalue centrality
	* 网络中的每个节点都有一个相对指数值，高指数节点的连接对一个节点的贡献度比低指数节点的贡献度高。
当前节点的中心性取决lj于邻居节点们的中心性。

+ cluster coefficient
	*  顶点之间结集成团的程度的系数
	*  C= 3×tri/（3×tri+open tri）zs
	*  Ci = 2|ejk|/i(i-1)

三种指标所表达的“重要”，其含义是不完全一样的

## 社区发现
1. GN
	* 分裂法
        - step0: 计算每条边的介数（$O(nm)$ with BFS）
        - 
        - 
2. Louvain
	* 模块度 (http://www.cnblogs.com/tychyg/p/5277137.html)
    * $Q=\frac{1}{2m} \Sigma(A_{ij}-\frac{k_i k_j}{2m}) \delta(c_i,c_j)$
	* 模块度（modularity）指的是网络中连接社区结构内部顶点的边所占的比例，减去在同样的社团结构下任意连接这两个节点的比例的期望值。
3. label propagation algrithm
4. K-means


####references
1. 复杂网络中聚类算法总结(http://www.cnblogs.com/tychyg/p/5277137.html)

