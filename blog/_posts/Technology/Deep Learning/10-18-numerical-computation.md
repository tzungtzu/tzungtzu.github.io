---
layout: post
title: Numerical Computation
categories: 
- Reading
tags:
- deep learning

---

####数值优化（Numerical Computation）：

通常指代那些在解决数学问题时，不使用从符号表达式中直接推导出解析解，而是使用迭代更新的方式获取答案的算法。

####梯度下降（gradient descent）：

$x′=x−ε▿xf(x)x′=x−ε▽xf(x)$，其中，ε是学习率。

####Hessian 矩阵（Hessian matrix）：

$H(f)(x)_{i,j}=\frac{∂^2}{∂x_i∂x_j}f(x)$

可以知道，Hessian矩阵是对称阵。

####牛顿法（Newton's method）：

将函数用二阶的泰勒公式近似：

$f(x)≈f(x^{(0)})+(x−x^{(0)})^T▿_xf(x^{(0)}+1/2(x−x^{(0)})^T H(f)(x^{(0)})(x−x^{(0)})$，求解临界点 $x∗=x(0)−H(f)(x^{(0)})−1▿_xf(x^{(0)})$。

梯度下降(Gradient Desecent)称为“一阶优化算法”；牛顿法称为“二阶优化算法”。


####拉格朗日函数：

$L(x,α,β)=f(x)+\Sigma^k_{i=1}α_ic_i(x)+\Sigma^l_{j=1}β_jh_j(x)$

$α_i$和$β_j$，称为拉格朗日乘子，$α_i≥0$。

####KKT条件：

1.拉格朗日函数对xx，λλ，αα求偏导都为0：
$▿xL(x∗,α∗,β∗)=0$
$▿αL(x∗,α∗,β∗)=0$
$▿βL(x∗,α∗,β∗)=0$

2.对于不等式约束，$α∗ici(x∗)=0      i=1,...,k$（对偶互补条件）。


### References:
1. [「Deep Learning」读书系列分享第四章：数值计算 | 分享总结](https://www.leiphone.com/news/201709/IeXHVVEyLE4wnNkt.html)
