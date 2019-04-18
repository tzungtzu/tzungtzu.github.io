---
layout: post
title: Spark GraphX in Action 笔记
categories: 
- Reading
tags:
- Spark
- GraphX

---

一、

Hadoop的关键能力：
1. HDFS —— 分布式存储
2. MapReduce —— 分布式计算

GraphX 用边RDD 和顶点RDD 来表示一个图。

GraphX 内部是一个批处理系统，并没有融入Spark Streaming.

图存储: 分布式文件存储与图数据库
两全其美： 事务用图数据库，图处理用GraphX。

图是模型化**连接**数据的自然和强大的使用方式

Spark 也提供了M/R API（分布式计算）和分布式存储。与 Hadoop 不同，Spark 在集群的内存中保存数据，Hadoop 在集群的磁盘中存储。

图数据的类型，图算法

<!--more-->

二、

spark—shell 提醒变量 sc可以直接使用。启动时在上下文创建一个 org.apache.spark.SparkContext 对象的实例sc.

Spark Shell 是 REPL（读取-求值-输出） 的一个实例。

import org.apache.spark.graphx._ 
scala 用 _ 作通配符， java 用 *。
导入依赖，

val graph = GraphLoader.edgeListFile(sc,"file:///home/ubuntu/data/users/zongwei/data/cit-HepTh.txt")

GraphLoader是 GraphX库里的对象， edgeListFile是GL里面的函数，用于加载边列表格式的文本文件，生成图


graph.inDegrees.reduce((a,b)=>if(a._2>b._2) a else b)
图对象调用 inDegrees 方法。得到一个VertexRDD
reduce()函数，将每两条数据归并成一个结果。并且Scala的匿名函数可以将函数作为参数传递到其他函数(无需声明的内联函数的形式) 

val v = graph.pageRank(0.001).vertices
v.reduce((a,b)=>if(a._2>b._2) a else b)

三、
1. 不变性
2. 函数是一等公民

轻松声明函数为内联的并且可以到处传递它们。


3. 声明式迭代技术

函数式编程不推荐使用for循环

函数式编程的天然迭代方式是 map() 和递归

map() 接受一个函数作为参数并将其应用于集合中的每一个元素。

递归用来让函数调用自身

map & reduce
map() 函数将传入的一个转换函数作为参数，把一个集合转变成另一个集合。
reduce() 函数传入一个两两合并的聚集函数作为参数((Int,Int) => Int),把一个集合聚集为单个值。

_+_是 (a,b)=>a+b 的简写。
Scala 特有的归并/聚集用法。

Spark:

scala 影响 Spark 最重要的设计概念 RDD。
RDD是分布在集群多个节点上的数据集合。 RDD是不可变的（不能被修改或更新）。但是可以从已有RDD根据转换方法生成新的RDD。

延迟求值

RDD的API函数有两种： transformation（map()） 和 action（reduce()）. 
前者：传入一个RDD，输出一个新的RDD。后者：除了前者的部分 
reduce(func), collect(), count(), first(), take(n), saveAsTextFile(path), foreach(func), countByKey()

DAG(有向无环图)对RDD的处理被隐藏起来以便于对外提供基础的功能。

Spark 需要两个主要系统：分布式文件系统（HDFS）和集群管理系统（YARN）。
Distributed Storage & Cluster Manager


SparkContext 对象是使用 Spark 的入口。

常用RDD操作
1. m/r 
2. 键值对
3. zip()
    同时迭代两个集合，保存在RDD中。
    zipWithIndex()，union()（未必是追加在后面）,distinct() 
4. MLlib

四、

GraphX 的基础类

Graph 是 GraphX 的基础类，它包含边RDD和顶点RDD，

triplets() 方法根据VertexId 将顶点和边联合在一起。返回 EdgeTriplet
[VD,ED] 类型的RDD，它是 Edge[ED] 的子类。
