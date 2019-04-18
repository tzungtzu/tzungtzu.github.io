---
layout: post
title: Resilio Sync 无法获取tracker问题解决
categories: 
- Technology
tags:
- resilio
- hosts
- gfw

---

今天碰到这样的问题–软件件下方提示 无法获取追踪器列表 的，英文版本提示 cannot get the list of trackers。

<!--more-->

目前解决的办法也很简单:

WINDOWS 用户修改 C:\Windows\System32\drivers\etc\hosts
Linux Mac 等用户修改 /etc/hosts
用记事本打开修改就可以，添加下面一行

        54.230.143.112 config.getsync.com config.resilio.com

退出重新启动 Resilio Sync 软件。就可以飞起来了。


手机用户处理方法：
可以修改hosts的手机自然可以参照上面。如果想iphone这种无法修改hosts的，可以尝试修改dns来解决。
将dns修改为121.43.60.16 。然后重新打开Resilio Sync。


用Surge、Shadowrocket 改hosts也是一种办法，

操作步骤：Edit→Local DNS Map→点右上角+号→填写IP：music·163·com  108.61.201.11、music·163·com  103.27.77.201


### References:
1. [resilio sync 无法获取追踪器列表？](https://www.zhihu.com/question/60919926)
2. [Resilio Sync 无法获取追踪器列表的解决办法](https://bbs.btnimei.xyz/topic/449/resilio-sync-%E6%97%A0%E6%B3%95%E8%8E%B7%E5%8F%96%E8%BF%BD%E8%B8%AA%E5%99%A8%E5%88%97%E8%A1%A8%E7%9A%84%E8%A7%A3%E5%86%B3%E5%8A%9E%E6%B3%95/3)
3. [Surge Hosts ](https://patricorgi.github.io/2016/10/31/iOS%20%E5%8F%8A%20Mac%20OS%20%E7%A7%91%E5%AD%A6%E4%B8%8A%E7%BD%91%E6%96%B9%E6%B3%95%E5%88%86%E4%BA%AB%E5%85%B6%E4%B8%80/)