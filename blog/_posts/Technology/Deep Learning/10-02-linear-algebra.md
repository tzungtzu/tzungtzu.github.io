---
layout: post
title: 《Deep Learning》读书笔记————第二章：Linear Algebra
categories: 
- reading
tags:
- deep learning
- probability


第二章，Linear Algebra： 

张量是矩阵基础上更高维度的抽象，它的维度可能比前面还要高，主要对应于包含若干坐标轴的规则网格。

跟向量有关的两种运算，一种是内积，第二种是外积。根据定义，内积会生成一个数，外积会生成一个向量；需要根据右手坐标系来定方向，保持手掌、四指与大拇指相互垂直，将手掌与四指分别对应两个向量，一比划，就得到大拇指的方向，大小就按照sin这个公式算出来。

关于向量长度，有个度量方法：范数。向量长度按照范数来度量，分别对应不同的表达式。

范数的目标就是衡量矩阵的大小。有很多种类别，但不是什么函数都能当做范数的，有些基本的要求：比如必须要保证有一个零值，然后还要满足三角形不等式，也就是三角形两边之和大于第三边，还有数乘，对应的是等比例缩放。缩放就是一个函数乘以一个实数，这是一个线性空间里的基本运算。

####范数（Norm）：

用来衡量vector的尺寸。
$L^p norm:||x||_p=(\Sigma_i|x_i|^p)^{\frac{1}{p}}

####Frobenius-norm:

用来衡量matrix的尺寸。
类似于 $L2 norm:||A||F=\sqrt{\Sigma_{i,j}A^2_{i,j}}$


特征向量，特征值的含义

$v$ 在 A 的作用下，保持方向不变，进行了比例为 lambda 的伸缩。




####奇异矩阵（singular matrix）：

前提是方阵
如果A(n×n)为奇异矩阵（singular matrix）<=> A的秩$Rank(A)
如果A(n×n)为非奇异矩阵（nonsingular matrix）<=> A满秩，Rank(A)=nRank(A)=n。






### References:
1. [](https://www.leiphone.com/news/201708/iL1S8jkc4ytZFzHS.html)


