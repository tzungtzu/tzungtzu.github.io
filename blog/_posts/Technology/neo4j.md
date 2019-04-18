
neo4j 

表现数据的联系

适合 Neo4j 的领域：

1. 社区网络：认识更多好友
2. 推荐引擎：查看哪些观众没看热门电影
3. 交通运输：班次，调度等各种数据
4. 物流管理：在包裹分拣中心找出每一个包裹配送的最短路径
5. 主数据管理
6. 访问控制： 处理关联数据，实现访问控制
7. **欺诈检测**：使用关联数据理清一个账号或者一个号码的关系和行为，找出某些异常举动。通过关联数据来进行预测，推荐建议。

只有企业版才能分布式安装，并且提供负载均衡和高可用配置等功能。社区版智能单机使用，最多可以使用数十亿个节点、关系和属性


Cypher 读/写查询结构：

[MATCH WHERE]
[OPTIONAL MATCH WHERE]
[WITH [ORDER BY] [SKIP] [LIMIT]]
(CREATE [UNIQUE]| MERGE)\*
[SET|DELETE|REMOVE|FOREACH]\*
[RETURN [ORDER BY] [SKIP] [LIMIT]]

CREATE 创建节点，关系：
	CREATE (n:LABEL {Property: value})
2. UNWIND 来展开集合[{},{}]
		UNWIND [] AS p CREATE (n:Test) SET n=p

MERGE 创建节点，关系：
会检查节点，关系是否存在，如果已经存在，则使用已有节点，如果不存在，则创建新节点。


联合查询 UNION：联合查询结果
使用链接 WITH：将上一条查询语句的结果链接起来，用于下一条查询语句中，起到管道的功能

	p = shortestpath((p1)-[:friend_of*..10]-(p2))

字符匹配

    MATCH (n) WHERE n.name STARTS WITH 'Pet' RETURN n.name, n.age


##复制关系

    MATCH (a:uid {name : '905792'})-[r:call_history]-(o), (d:uid {name :'900002'})  create (d)-[:call_history]->(o)

前提是 node d 已经创建。否则无变化。

使用函数

性能分析： 在设计的查询语句和算法中，都可以在前面加上一个关键字PROFILE 来进行性能分析。
使用唯一属性约束，可以加快效率