---
layout: post
title: 群晖 docker 安装 teslamate
categories: 
- Technology
tags:
- nas
- tesla
- teslamate
- postgresql
- grafana
- mqtt

---

方法比较简单，通过官网(https://docs.teslamate.org/docs/installation/docker) 方法安装，过程大致如下：
1. 群晖打开ssh
2. ssh登陆，新建 docker-compose 的yaml文件，一键安装。

<!--more-->

几个问题需要注意一下，自己有遇到：
1. yaml文件中的密码需要自己写，并且等号后面不要空格，如果出现空格，teslamate和postgresql都可以正常使用，但是 grafana 无法读取密码中第一个空格，会报错误 metric requests error。
2. postgresql 在第一次创建容器的时候就会创建数据库，用户名和密码就设定好了。删除重新新建容器无法修改密码，必须通过ssh进入容器修改密码。修改密码后，三个容器都可以正常连接。
3. 如果需要用自己的mqtt broker，在yaml文件中不需要新建 mqtt 容器，在 teslamate 容器环境中添加 MQTT_HOST, MQTT_USERNAME, MQTT_PASS 就可以连接。


### References:
1. [postgresql - password authentication failed for user "postgres" with docker-compose up on EC2 - Stack Overflow](https://stackoverflow.com/questions/55667583/password-authentication-failed-for-user-postgres-with-docker-compose-up-on-ec2)
2. [postgresql忘记密码了，重置postgres用户密码的方式（docker下）_胡振伟博客-CSDN博客_postgres修改密码](https://blog.csdn.net/huzhenwei/article/details/120272523)