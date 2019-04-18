---
layout: post
title: Markov Chain
categories:
- Research
tags:
- network
- mc

---

马尔可夫随机过程

###定理一： 如果一个非周期马氏链具有**概率转移矩阵**P，且它的任何两个状态都是联通的，则


                π = πP 有唯一的非负解。
其中π=[π(1),π(2),π(3)...,π(j),...], π称为马氏链的平稳分布。


定理二：
细致平稳条件（Detailed Balance Condition）

                sigma π(i)Pij = π(j)Pji


MCMC的关键：主动构造马氏链，使其有我们想要的平稳分布π，


references：

1. http://blog.csdn.net/lanchunhui/article/details/50451620
2. http://blog.csdn.net/lanchunhui/article/details/50363851