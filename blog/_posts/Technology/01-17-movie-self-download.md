---
layout: post
title: 美剧更新自动下载脚本
categories: 
- Technology
tags:
- router
- aria
- drama
- python

---

需求：

有了梅林固件的 DDNS 和 Aria2，可以很方便的随时下载电影，不过对于固定要看点电影，每周下载还是过于繁琐，所以设置更新自动下载的脚本。 

<!--more-->

步骤：

1. 注册 [zimuzu.tv](http://www.zimuzu.tv/)，将需要订阅的美剧收藏，查看收藏列表。
2. 两小时一次的定时任务查看最近两小时上线的资源，通过爬虫获取资源。
3. 通过邮件发送到电脑，点击通过迅雷远程下载（比 Aria 速度快）。

TODO：
1. 通过迅雷远程或者 Aria 自动下载
2. 标记已下载、未下载，通过标签来判断是否下载。

###定时任务爬取资源：

1. 通过 requests 登陆网站
2. 通过 bs4 读取网站数据
3. 数据清洗，返回 url 列表
4. 通过 Webhooks 发送邮件
    a. 通过 ifttt 设置 webhooks
    b. 在程序里运行函数，返回指定结果



### References:
1. [产品经理乱写代码—美剧自动下载脚本](https://zhuanlan.zhihu.com/p/28561414)
