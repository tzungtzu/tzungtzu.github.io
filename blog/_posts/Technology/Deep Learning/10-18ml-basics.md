##《Deep Learning》读书笔记————第五章：Machine Learning Basics



####机器学习定义：
一个计算机程序，如果它能做到在任务T中的性能P随着经验E可以提高，那就可以称它是关于某类任务T和性能衡量P，从经验E中学习。

####机器学习任务（T）
类别：分类（classification）/缺失输入数据的分类（classification with missing data）/回归（regression）/转录（transciption）/机器翻译（machine translation）/结构化输出（structured output）/异常检测（anomaly detection）/合成和采样（synthesis and smapling）/缺失值填补（imputation of missing data）/去噪（denoising）/密度估计（density estimation）

####机器学习的性能（P）：
P因为T的不同而不同。对于像分类/缺失输入数据的分类/转录，使用准确率（accuracy）来衡量性能；而对于密度估计，通常输出模型在一些样本上概率对数的平均值。

####机器学习的经验（E）：
根据经验的不同，分为监督学习和无监督学习。监督学习：学习p(x)；无监督学习：学习p(y|x)。通常来说，无监督学习通常指代从不需要人工标注数据中提取信息。

####泛化（generalization）：
在先前未观测到的输入上表现良好的能力被称为泛化。

####欠拟合（underfitting）和过拟合（overfitting）：
机器学习的性能取决于两点因素：1.使训练误差更小；2.使训练误差和测试误差的差距更小。分别对应欠拟合的改善和过拟合的改善。

####模型的容量（capacity）：
模型的容量是指其拟合各种函数的能力。

####VC维（Vapnik-Chervonenkis dimension）：
VC维用来度量二分类器的容量。假设存在mm个不同的xx点的训练集，分类器可以任意地标记该mm个不同的xx点，VC维即mm的最大可能值。详细解释

####奥卡姆剃刀（Occam's razor）：
在同样能够解释已知观测现象的假设中，我们应该挑选”最简单”的那一个。

####没有免费的午餐定理（no free lunch theorem）：
所有分类算法在分类没有见过的点的时候，他们的错误率的期望是一样的。这个定理告诉我们，必须要针对特定的任务去设计机器学习算法。

####正则化（Regularization）：
正则化是指我们针对减少泛化误差而不是训练误差，在一个机器学习算法上做的任何改动。

####超参数（Hyperparameters）：
超参数的值不能通过学习算法本身学习出来。

#### 验证集（Validation Sets）：
验证集用来调超参数。


#### 点估计（Point Estimation）：

试图为某些参数提供一个“最优”的预测。

将参数θ的点估计记为$θ$̂，令${x^{(1)},...,x^{(m)}}$是m个独立同分布(i.i.d.)的数据点。点估计是这些数据的任意函数：$θ̂ =g(x^{(1)},...,x^{(m)})$

#### 估计的偏差（Bias）：

估计的偏差被定义为:$bias(θ̂ m)=E(θ̂ m)−θ$，即，估计的期望和真实值的差。

如果$bias(θ̂_m)=0$,那么估计量$θ_m$被称为是无偏估计。

####最大似然估计（Maximum Likelihood Estimation, MLE）

参数θ的最大似然估计：$θML=argmax_θ p_{model}(𝕏;θ)=argmax_θ \Pi^m_{i=1}p_{model}(x^{(i)};θ)$, 其中$ 𝕏={x^{(1)},...,x^{(m)}}$.

似然函数：$p_{model}(𝕏;θ)$ 是一族由θθ确定在相同空间上的概率分布。可以看到，这里θ并不是一个随机变量，而仅仅是一个参数。

对数形式：θML=argmaxθ∑mi=1logpmodel(x(i);θ)。

是一种点估计方法。

#### 贝叶斯统计（Bayesian Statistics）

最大似然估计是频率学派的观点，认为参数θ是固定的，但是未知；贝叶斯统计观点认为，数据集是直接观察得到的，因此数据集不是随机的，但是参数θ是一个随机变量。

在观察到数据前,我们将θ的已知知识表示成先验概率分布(prior probability distribution) $p(θ)$。

$p(θ|x(1),x(2),...,x(m))=\frac{p(x^{(1)},x^{(2)},...,x^{(m)}|θ)p(θ)}{p(x^{(1)},x^{(2)},...,x^{(m)})}$

####最大后验(Maximum A Posteriori, MAP)估计
θMAP=argmaxθp(θ∣x)=argmaxθlogp(x∣θ)+logp(θ)θMAP=argmaxθp(θ∣x)=argmaxθlogp(x∣θ)+logp(θ)
我们可以认出上式右边的logp(x|θ)logp(x|θ)对应着标准的对数似然项，logp(θ)logp(θ)对应着先验分布。

正如全贝叶斯推断,MAP 贝叶斯推断的优势是能够利用来自先验的信息,这些信息无法从训练数据中获得。该附加信息有助于减少最大后验点估计的方差，然而,这个优点的代价是增加了偏差。

依然是一种点估计方法。


5. Machine Learning Basics
机器学习定义：一个计算机程序，如果它能做到在任务T中的性能P随着经验E可以提高，那就可以称它是关于某类任务T和性能衡量P，从经验E中学习。

机器学习任务（TT）类别：分类（classification）/缺失输入数据的分类（classification with missing data）/回归（regression）/转录（transciption）/机器翻译（machine translation）/结构化输出（structured output）/异常检测（anomaly detection）/合成和采样（synthesis and smapling）/缺失值填补（imputation of missing data）/去噪（denoising）/密度估计（density estimation）

机器学习的性能（PP）：PP因为TT的不同而不同。对于像分类/缺失输入数据的分类/转录，使用准确率（accuracy）来衡量性能；而对于密度估计，通常输出模型在一些样本上概率对数的平均值。

机器学习的经验（EE）：根据经验的不同，分为监督学习和无监督学习。监督学习：学习p(x)p(x)；无监督学习：学习p(y|x)p(y|x)。通常来说，无监督学习通常指代从不需要人工标注数据中提取信息。

泛化（generalization）：在先前未观测到的输入上表现良好的能力被称为泛化。

欠拟合（underfitting）和过拟合（overfitting）：机器学习的性能取决于两点因素：1.使训练误差更小；2.使训练误差和测试误差的差距更小。分别对应欠拟合的改善和过拟合的改善。

模型的容量（capacity）：模型的容量是指其拟合各种函数的能力。

VC维（Vapnik-Chervonenkis dimension）：VC维用来度量二分类器的容量。假设存在mm个不同的xx点的训练集，分类器可以任意地标记该mm个不同的xx点，VC维即mm的最大可能值。详细解释

奥卡姆剃刀（Occam's razor）：在同样能够解释已知观测现象的假设中，我们应该挑选”最简单”的那一个。

没有免费的午餐定理（no free lunch theorem）：所有分类算法在分类没有见过的点的时候，他们的错误率的期望是一样的。这个定理告诉我们，必须要针对特定的任务去设计机器学习算法。

正则化（Regularization）：正则化是指我们针对减少泛化误差而不是训练误差，在一个机器学习算法上做的任何改动。

超参数（Hyperparameters）：超参数的值不能通过学习算法本身学习出来。

验证集（Validation Sets）：验证集用来调超参数。

统计学的一些基本概念：估计（Estimators）/偏差（Bias）/方差（Variance）
点估计（Point Estimation）：

试图为某些参数提供一个“最优”的预测。

将参数θθ的点估计记为θ̂ θ^，令{x(1),...,x(m)}{x(1),...,x(m)}是mm个独立同分布(i.i.d.)的数据点。点估计是这些数据的任意函数：θ̂ =g(x(1),...,x(m))θ^=g(x(1),...,x(m))
估计的偏差（Bias）：

估计的偏差被定义为:bias(θ̂ m)=E(θ̂ m)−θbias(θ^m)=E(θ^m)−θ，即，估计的期望和真实值的差。

如果bias(θ̂ m)=0bias(θ^m)=0,那么估计量θmθm被称为是无偏估计。

估计的方差（Variance）：

就是一个方差Var(θ̂ )Var(θ^)。

Var(X)=E[(X−μ)2]Var(X)=E[(X−μ)2]，其中μ=E[X]μ=E[X]。

均方误差（mean squared error， MSE）：

MSE=E[(θ̂ m−θ)2]=Bias(θ̂ m)2+Var(θ̂ m)MSE=E[(θ^m−θ)2]=Bias(θ^m)2+Var(θ^m)
最大似然估计（Maximum Likelihood Estimation, MLE）
参数θ的最大似然估计：θML=argmaxθpmodel(𝕏;θ)=argmaxθ∏mi=1pmodel(x(i);θ)θML=argmaxθpmodel(X;θ)=argmaxθ∏i=1mpmodel(x(i);θ)，其中𝕏={x(1),...,x(m)}X={x(1),...,x(m)}。

似然函数：pmodel(𝕏;θ)pmodel(X;θ)是一族由θθ确定在相同空间上的概率分布。可以看到，这里θθ并不是一个随机变量，而仅仅是一个参数。

对数形式：θML=argmaxθ∑mi=1logpmodel(x(i);θ)θML=argmaxθ∑i=1mlogpmodel(x(i);θ)。

是一种点估计方法。

贝叶斯统计（Bayesian Statistics）
最大似然估计是频率学派的观点，认为参数θ是固定的，但是未知；贝叶斯统计观点认为，数据集是直接观察得到的，因此数据集不是随机的，但是参数θ是一个随机变量。

在观察到数据前,我们将θθ的已知知识表示成先验概率分布(prior probability distribution)p(θ)p(θ)。

p(θ|x(1),x(2),...,x(m))=p(x(1),x(2),...,x(m)|θ)p(θ)p(x(1),x(2),...,x(m))p(θ|x(1),x(2),...,x(m))=p(x(1),x(2),...,x(m)|θ)p(θ)p(x(1),x(2),...,x(m))
最大后验(Maximum A Posteriori, MAP)估计
θMAP=argmaxθp(θ∣x)=argmaxθlogp(x∣θ)+logp(θ)θMAP=argmaxθp(θ∣x)=argmaxθlogp(x∣θ)+logp(θ)
我们可以认出上式右边的logp(x|θ)logp(x|θ)对应着标准的对数似然项，logp(θ)logp(θ)对应着先验分布。

正如全贝叶斯推断,MAP 贝叶斯推断的优势是能够利用来自先验的信息,这些信息无法从训练数据中获得。该附加信息有助于减少最大后验点估计的方差，然而,这个优点的代价是增加了偏差。

依然是一种点估计方法。

####  机器学习算法的常见组成部分：
一个数据集（dataset）+一个损失函数（cost function）+一个优化过程（optimization procedure）+一个模型（model）
