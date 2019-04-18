---
layout: post
title: MCMC 学习
categories:
- Research
tags:
- networks
- Markov Chain
- Mento Carlo
- MCMC

---

### 采样

### Mento Carlo

蒙特卡罗方法是一种通过在一定范围内均匀随机抽样来得到结果的计算方法。大致的思路框架如下：

> 
+ 针对计算问题选定抽样范围
+ 在范围内进行随机抽样
+ 根据问题定义，对样本进行归类
+ 整合这些统计值，得到结果
> 

 <!--more-->

#### 圆周率计算示例

在正方形中做一个内切圆，随机抽样n个点，记在内切圆中的点的数量为c，那么有

$$\frac{πr^2}{(2r)^2} = \frac{c}{n}  =\> π=\frac{4c}{n} $$



python代码如下：


\`\`\`python
import random 

n = 100000
c = 0

for \_ in range(1,n):
	x = random.uniform(-1,1)
	y = random.uniform(-1,1)
	if x*x+y*y<1: c+=1

pai = 4\*c/float(n)
print 'π equals %s'%pai
\`\`\`

	π equals 3.13412


#### 定积分计算

同理，计算${\int\_{0}^{2} x^2}dx$也可以同样采样，

$$\frac{\int}{2\*4} = \frac{c}{n} =\> \int = \frac{8c}{n}$$

python 代码如下：


\`\`\`python
import random

n = 1000000
c = 0

for \_ in range(1,n):
	x = random.uniform(0,2)
	y = random.uniform(0,4)
	if x*x > y: c+=1

print 8\*c/float(n)
\`\`\`

	2.671912


### Marcov Chain

如果一个非周期马氏链具有概率转移矩阵 $P$，且它的任何两个状态是连通的，则 $P^n_{ij}$ 存在且与 $i$ 无关（即矩阵 $P^n$ 的每行元素都相同），记作 $\lim\limits_{n \to \infty }{P^n\_{ij}} = π(j)$，且

$$\lim\limits_{n \to \infty }{P^n_{ij}} =  \left[
 \begin{matrix}
   π(1) & π(2) & π(3) &... &π(j) &... \\
   π(1) & π(2) & π(3) &... &π(j) &... \\
   ... & ... & ... &... &... &... \\
   π(1) & π(2) & π(3) &... &π(j) &... \\
   ... & ... & ... &... &... &... \\
  \end{matrix}
  \right] \tag{3}$$
  
  
$$π(j) = \sum_{n=0}^{\infty} = πP_{ij} $$

$$π = πP$$

[未完待续]


\`\`\`python

\`\`\`

### References:

1. http://sunyi514.github.io/2016/03/05/mcmc%E6%96%B9%E6%B3%95%E5%B0%8F%E8%AE%B0/
2. http://blog.csdn.net/lanchunhui/article/details/50363851
3. http://blog.csdn.net/lanchunhui/article/details/50452515
4. http://www.dongzhuoyao.com/mcmc/