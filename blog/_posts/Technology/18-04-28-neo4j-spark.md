

Spark-GraphX


## neo4j-spark-connector

config   

spark-defaults.conf 的 内网IP

安装第三方包 neo4j-contrib 和 graphframe

    $SPARK_HOME/bin/spark-shell --packages neo4j-contrib:neo4j-spark-connector:2.0.0-M2,graphframes:graphframes:0.5.0-spark2.0-s_2.11
    import org.neo4j.spark._
    val neo = Neo4j(sc)
    val rdd = neo.cypher("MATCH (n:uid) RETURN count(n) as id ").loadRowRdd
    rdd.collect()


###算法
    a.groupBy(x => { if (x % 2 == 0) "even" else "odd" }).collect
    rdd.map(x=> {if (x==3) (1,x) else (2,x)}).collect()
    rdd.countByKey()


运行spark程序的方式


 23 export SPARK_HOME=/home/ubuntu/data/spark-2.0.1-bin-hadoop2.6
 24 export SPARK_LOCAL_DIRS=/home/ubuntu/data/spark-2.0.1-bin-hadoop2.6/tmp
 25 export HADOOP_HOME=/home/ubuntu/data/hadoop-2.6.4
 26 export HADOOP_CONF_DIR=/home/ubuntu/data/hadoop-2.6.4/etc/hadoop
 27 export SCALA_HOME=/home/ubuntu/data/scala-2.12.0
 28 export JAVA_HOME=/home/ubuntu/data/jdk1.8.0_92
 29 export SPARK_WORK_DIR=/home/ubuntu/data/spark-2.0.1-bin-hadoop2.6/work



###build.sbt

      1 name := "AL Graph"
      2
      3 version := "1.0"
      4
      5 scalaVersion := "2.11.8"
      6
      7 assemblyJarName in assembly := "Alg.jar"
      8
      9 resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"
     10
     11 libraryDependencies ++= Seq(
     12   "org.apache.spark" %% "spark-sql" % "2.0.1" % "provided",   // for packages in $SPARK_HOME/jars
     13   "neo4j-contrib" % "neo4j-spark-connector" % "2.0.0-M2"  //for packages in folder
     14 )

sbt clean assembly

添加 project/plugin.sbt


$SPARK_HOME/bin/spark-submit --class "testApp" target/scala-2.11/Alg.jar



          1 import org.apache.spark._
          2 import org.neo4j.spark._
          3
          4 object testApp{
          5         def main(args:Array[String]){
          6                 val sc = new SparkContext(new SparkConf())
          7                 val neo = Neo4j(sc)
          8
          9                 val rdd = neo.cypher("MATCH (n:uid) RETURN n LIMIT 10").loadRowRdd
         10                 println(rdd.collect())
         11         }
         12 }



### References:
1. [https://github.com/neo4j-contrib/neo4j-spark-connector]()
2. [运行spark程序的方式 | smallx's sth.](http://smallx.me/2016/06/07/%E8%BF%90%E8%A1%8Cspark%E7%A8%8B%E5%BA%8F%E7%9A%84%E6%96%B9%E5%BC%8F/)
3. [基于spark运行scala程序（sbt和命令行方法） - CSDN博客](https://blog.csdn.net/zhangyuming010/article/details/37700557)

5. 