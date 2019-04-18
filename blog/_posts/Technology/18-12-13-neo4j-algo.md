add 图算法插件




plugins

apoc-3.2.3.5-all.jar  graph-algorithms-algo-3.3.5.0.jar




CALL algo.unionFind.stream()
YIELD nodeId,setId
RETURN setId,count(*) as size_of_component
ORDER BY size_of_component DESC LIMIT 20


CALL algo.louvain.stream('uid', 'self_device_id', {})
YIELD nodeId, community RETURN count(distinct nodeId) as count_of_components


CALL apoc.meta.graph


conf/neo4j.conf
dbms.security.procedures.unrestricted=algo.*,apoc.*



### References:
1. [Neo4j Install APOC and Graph Algorithms Neo.ClientError.Procedure.ProcedureRegistrationFailed - Stack Overflow](https://stackoverflow.com/questions/48773505/neo4j-install-apoc-and-graph-algorithms-neo-clienterror-procedure-procedureregis)
2. [graph - How to return top n biggest cluster in Neo4j? - Stack Overflow](https://stackoverflow.com/questions/49134739/how-to-return-top-n-biggest-cluster-in-neo4j)
3. [5.5. The Triangle Counting / Clustering Coefficient algorithm - Chapter 5. Community detection algorithms](https://neo4j.com/docs/graph-algorithms/current/algorithms/triangle-counting-clustering-coefficient/)
