---
layout: post
title: py2neo version 4 中的变化
categories: 
- Technology
tags:
- neo4j
- python
- py2neo

---


py2neo 最新版本已经到 4.0.0b9，可以通过github 更新到最新版本：

        $ pip install git+https://github.com/technige/py2neo.git#egg=py2neo

<!--more-->

其中有些变化需要注意。

在2和3版本，可以直接调用 Graph 类的 data 方法获得结果。如：

        graph = Graph('http://neo4j:XXX@localhost:7474/db/data')
        uid = graph.data("MATCH (a:uid) RETURN a.name LIMIT 4")

在版本4中，不再有 data 方法，会返回如下错误：

        'Graph' object has no attribute 'data'

不过可以通过 Cursor 类的 to_table 函数达到一样的效果。

        graph = Graph('http://neo4j:XXX@localhost:7474/db/data')
        uid = graph.run("match (n:uid) return n.name limit 10").to_table()

特别的，当输出结果是一个值的时候，可以使用 evaluate 函数。一般情况下，默认返回 recordlist 的第一个值。


### References:
1. [py2neo.database — The Py2neo v4 Handbook](http://py2neo.org/v4/_modules/py2neo/database.html#Graph.data)
2. [py2neo/database.py at v4 · technige/py2neo](https://github.com/technige/py2neo/blob/v4/py2neo/database.py)
