##处理键值对

>键值对是 Spark 中常见的一种数据类型。键值对 RDD 通
常用于聚合操作，也经常会将一些初始 ETL(提取，转换，加载)获取的数据保存
为键值对的格式。键值对的 RDD 也暴露了一些新的操作（比如每个产品的评价
计数，按相同的键对数据进行分组，对两个不同的 RDD 分组）。

- reduceByKey()： 对每个键的数据分别进行聚合
- join(): 对两个 RDD 中相同的元素进行分组合并

- 聚合
- 调整并行级别
- 数据分组

    如果你发现你写的代码先 groupByKey()然后对返回值执行 reduce()或 fold()，那
    么你大概可以通过调用某个基于主键的聚合函数更高效的得到相同的结果。。应
    该对数据按每个主键进行归约得到每个主键对应的归约后的值的 RDD，而不是
    归 约 数 据 到 一 个 内 存 值 中 。 例 如 ， rdd.reduceByKey(func) 生 成 了 和
    rdd.groupByKey().mapValues(value => value.reduce(func))相同的 RDD，但是更高
    效。因为避免了为每个主键创建列表的步骤。
- 连接
- 数据排序
- 数据分区 


