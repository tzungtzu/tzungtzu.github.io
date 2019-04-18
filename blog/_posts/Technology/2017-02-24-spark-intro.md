---
layout: post
title: Spark 入门遇到的一些坑
categories: 
- Technology
tags:
- spark
- scala

---



Apache Spark 是一个新兴的大数据处理通用引擎，提供了分布式的内存抽象。

用[官方文档][1]入门的时候遇到一些问题，以下是解决办法。

 <!--more-->


### 1.  找不到 README.md 文件
需要将Spark目录下的README.md 文件放到Spark使用的文件系统的相应位置。如果使用的是HDFS，应该放在 /usr/YOUR\_USER\_NAME 目录下，或者将文件路径改为绝对路径。如：

	val textFile = “/usr/mine/path/README.md” 

    区分hdfs:///和 file:///

    "file:///home/ubuntu/data/spark-2.0.1-bin-hadoop2.6/LICENSE"

### 2. 安装 simpleApp 的目录结构
新建文件夹，包含simpleApp.scala, simple.sbt 两个文件

### 3. 无法使用 sbt
Spark 中没有自带 sbt，需要自行[安装][2]

### 4.  connector

下载最新  否则 mvn install 报错
 https://spark-packages.org/package/neo4j-contrib/neo4j-spark-connector

 安装graphframe

 spark-shell --packages neo4j-contrib:neo4j-spark-connector:2.0.0-M2

 tips  修改bolt 地址，如果是内网ip 需要写内网ip

 dataframe 看作是结构化的RDD

 dataframe 遵守RDD具有的规则，r如转换和行动。另外还有额外的SQL接口
 df.select('year').count()   其中select 为转换， count 为行动操作。


### 5. graphframe 安装错误


    file:/home/ubuntu/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar 

    把相关的依赖包安装到指定位置即可


##[error] (*:update) java.lang.IllegalArgumentException: commons-codec#commons-codec;1.4!commons-codec.jar origin location must be absolute: file:/home/ubuntu/.m2/repository/commons-codec/commons-codec/1.4/commons-codec-1.4.jar


[1]:	https://spark.apache.org/docs/latest/quick-start.html
[2]:	http://www.scala-sbt.org/0.13/docs/zh-cn/Installing-sbt-on-Linux.html
[3]:    