---
layout: post
title:  Integrate Spark(Scala & PySpark) with Jupiter Notebook
categories: 
- Technology
tags:
- Jupyter Notebook
- Spark
- Scala
- Toree

---

Jupyer Notebook is an interactive notebook environment and it supports Spark.



### 1 . jupyter Notebook installation

### 2 . Scala, Spark installation

### 3 . **Toree installation**

 Apache Toree is tool to configure Jupiter notebook to run with Spark.

	$sudo pip install -i http://pypi.anaconda,org/hyoon/simple toree

 <!--more-->

### 4 . Configure different Apache Toree kernels

for Scala:

	$jupyter toree install spark_home=~/data/spark-2.0.1-bin-hadoop2.6/
 
for PySpark:

	$jupyter toree install --spark_home=~/data/spark-2.0.1-bin-hadoop2.6/  --interpreters=PySpark

even SparkR, SQL

	$Jupyter toree install --interpreter=SparkR,SQL

### 5 .  and you can Check installation by
	$jupyter kernelspec list


### 6. add 3rd Party Libraries
1. List all packages you will use.

SPARK_PKGS=$(cat << END | xargs echo | sed 's/ /,/g'
neo4j-contrib:neo4j-spark-connector:2.0.0-M2
graphframes:graphframes:0.5.0-spark2.0-s_2.11
END)

2. Define SPARK_OPTS and SPARK_HOME.

SPARK_OPTS="--packages=$SPARK_PKGS"
SPARK_HOME=~/data/spark-2.0.1-bin-hadoop2.6/

3. Configure Toree to use these packages.

sudo jupyter toree install \
  --spark_home=$SPARK_HOME \
  --spark_opts=$SPARK_OPTS


Adding Remote Packages
You can use Apache Toree's AddDeps magic to add dependencies from Maven central. You must specify the company name, artifact ID, and version. To resolve any transitive dependencies, you must explicitly specify the --transitive flag.

### references:

1. [https://toree.incubator.apache.org/documentation/user/installation.html][1]
2. [http://stackoverflow.com/questions/39149541/integrate-pyspark-with-jupyter-notebook][2]


<details>
<summary> More details</summary>

Detail test


</details>

[1]:	https://toree.incubator.apache.org/documentation/user/installation.html "Apache Toree Installation"
[2]:	http://stackoverflow.com/questions/39149541/integrate-pyspark-with-jupyter-notebook " solution is to install Apache Toree."
[3]:    https://github.com/asimjalis/apache-toree-quickstart
[4]: 4. [Jupyter运行scala程序 - CSDN博客](https://blog.csdn.net/qq_24452475/article/details/79766781)
5. [jupyter配置scala和Spark学习环境 - CSDN博客](https://blog.csdn.net/qq_30901367/article/details/73296887)
6. [可以"跑"的博客](https://qszhuan.github.io/python/2016/03/05/runnable_blog)