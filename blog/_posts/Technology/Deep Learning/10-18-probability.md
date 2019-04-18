---
layout: post
title: 《Deep Learning》读书笔记————第三章：Probability and Information Theory
categories: 
- reading
tags:
- deep learning
- probability

---
### 概率论部分


__频率学派概率（frequentist probability）__：认为概率和事件发生的 __频率相关__ 。

__贝叶斯学派概率（Bayesian probability）__：认为概率是的对某件事发生的 __确定程度__，可以理解成是确信的程度（degree of belief）。

贝叶斯学派和频率学派最大的不同、根上的不同，就是在于模型 y=wx+b 其中的w和b两个参数，频率学派认为参数是固定的，只要通过不停的采样、不停的观测训练，就能够估算参数w和b，因为它们是固定不变的；而贝叶斯学派相反，他们认为这些参数是变量，它们是服从一定的分布的，这是它最根本的差别。

<!--more-->

__随机变量（random variable）__：一个可能随机获取不同值的变量。

__概率质量函数（probability mass function，PMF）__：用来描述离散随机变量的概率分布。表示为P(x)，是状态到概率的映射。

__概率密度函数（probability density function，PDF）__：用来描述连续随机变量的概率分布，$p(x)$。

__条件概率（conditional probability）__：$P(y=y|x=x)=\frac{P(y=y,x=x)}{P(x=x)}$

__条件概率的链式法则（chain rule of conditional probability）__：$P(x^{(1)},...,x^{(n)})=P(x^{(1)})\Pi^n_{i=2}P(x^{(i)}|x^{(1)},...,x^{(i−1)})$

__独立（independence）__：$∀x∈x,y∈y,p(x=x,y=y)=p(x=x)p(y=y)$

__条件独立（conditional independence）__：$∀x∈x,y∈y,z∈z,p(x=x,y=y|z=z)=p(x=x|z=z)p(y=y|z=z)$

__贝努力分布（Bernoulli Distribution）__：随机变量只有两种可能的分布，只有一个参数：$Φ$，即x=1的概率。

__多项式分布（Multinoulli Distribution）__: 随机变量有k种可能的分布，参数是一个长度为$k−1$的向量pp。

__高斯分布（Gaussian Distribution）__ :

* 即正态分布（normal distribution）

* $N(x;μ,σ^2)=\frac{1}{2πσ^2}exp(−\frac{1}{2σ2}(x−μ)^2)$

* 中心极限定理（central limit theorem）认为，大量的独立随机变量的和近似于一个高斯分布，这一点可以大量使用在应用中，我们可以认为噪声是属于正态分布的。

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018101454_WNjgGK_Screenshot.jpeg" alter="" width="50%">


__多元正态分布（multivariate normal distribution）__：

* 给定协方差矩阵ΣΣ（正定对称），

* $N(x;\mu,\Sigma)=\sqrt{\frac{1}{(2π)^ndet(Σ)}}exp(−\frac{1}{2}(x−μ)^T\Sigma^{−1}(x−μ))$

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018102837_Eqs1CH_Screenshot.jpeg" alter="" width="50%">


__指数分布（exponential distribution）__：

* 在深度学习的有研究中，经常会用到__在x=0点获得最高__的概率的分布，

* $p(x;λ)=λ\mathbf{1}_{x≥0}exp(−\lambda x)$ 或者：
$
\begin{equation}f(x)=
\begin{cases}
\lambda exp(-\lambda), &x\geq 0\cr 0, &x\end{cases}
\end{equation}
$
其中$λ > 0$是分布的一个参数，常被称为率参数（rate parameter）。


* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018103710_SuSobD_Screenshot.jpeg" alter="" width="50%">


![概率分布之间的关系](http://7xo4c2.com1.z0.glb.clouddn.com/20171018140619_WzhHmR_59a49cf0df2fb.jpeg)

伯努利分布相当于是扔硬币，扔一次；

扔了很多次以后就变成二项分布；

扔多次直到成功就是几何分布，比如扔了三次，看第一次出现正面的概率；

负二项分布，是说实验n次，成功r次才停止；

超几何分布跟二项分布是不同的，最核心的不同在于它是不放回的抽样，而二项分布是放回的；

最核心的当然就是正态分布了。

__拉普拉斯分布（Laplace Distribution）__：

* 另一个可以在一个点获得比较高的概率的分布。

* $Laplace(x;μ,γ)=12γexp(−|x−μ|γ)$

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018110455_yXzIhR_Screenshot.jpeg" alter="" width="50%">


__迪拉克分布（Dirac Distribution）__：

* $p(x)=\delta(x−μ)$，这是一个泛函数。迪拉克分布经常被用于组成经验分布（empirical distribution）

* $p(x)=\frac{1}{m}\Sigma^m_{i=1}δ(x−x^{(i)})$

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018111028_8XRyl4_Screenshot.jpeg" alter="" width="50%">

* FYI: [Dirichlet function](https://www.wikiwand.com/zh-hk/%E7%8B%84%E5%88%A9%E5%85%8B%E9%9B%B7%E5%87%BD%E6%95%B0)

__逻辑斯蒂函数（logistic function）__：

sigmoid 函数

* $σ(x)=\frac{1}{1+exp(−x)σ(x)}$，常用来生成贝努力分布的Φ参数。

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018112623_5xZ6QJ_Screenshot.jpeg" alter="" width="75%">


__softplus function__:

* ζ(x)=log(1+exp(x))，是“取正”函数的“soft”版
* x+=max(0,x) 如上，强制非负校正函数 max(0,x) 平滑版本
* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018140811_jq42eG_Screenshot.jpeg" alter="" width="75%">


__贝叶斯公式（Bayes' Rule）__：$P(x|y)=\frac{P(x)P(y|x)}{P(y)}$

###信息论部分

###图模型（Structured Probabilistic Models）
####有向图模型（Directed Model）：

* $p(x)=\Pi_i p(x_i|Pa_g(xi))$， 其中$Pa_g(x_i)$是$x_i$的父节点。

* <img src="http://7xo4c2.com1.z0.glb.clouddn.com/20171018115900_U6cyDq_Screenshot.jpeg" alter="" width="70%">

* $P(a,b,c,d,e)=p(a)p(b|a)p(c|a,b)p(d|b)p(e|c)$



### References:
1. [《Deep Learning》读书笔记————第三章：Probability and Information Theory](https://applenob.github.io/deep_learning_3)
2. [浅谈深度学习中的激活函数 - The Activation Function in Deep Learning](http://www.cnblogs.com/rgvb178/p/6055213.html)
















