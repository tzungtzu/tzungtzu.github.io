## neo4j-spark-connector

安装第三方包 neo4j-contrib 和 graphframe

    spark-shell --packages neo4j-contrib:neo4j-spark-connector:2.0.0-M2,graphframes:graphframes:0.5.0-spark2.0-s_2.11
    import org.neo4j.spark._
    val neo = Neo4j(sc)
    val rdd = neo.cypher("MATCH (n:Person) RETURN id(n) as id ").loadRowRdd


###算法
    a.groupBy(x => { if (x % 2 == 0) "even" else "odd" }).collect
    rdd.map(x=> {if (x==3) (1,x) else (2,x)}).collect()
    rdd.countByKey()


### References:
1. [https://github.com/neo4j-contrib/neo4j-spark-connector]()
