---
layout: post
title: Install matplotlib on macOS Sierra
categories: 
- Technology
tags:
- python
- matplotlab
- 踩过的坑

---


在 macOS 下安装 matplotlab 报错，

<img src="https://ww4.sinaimg.cn/large/006tNc79gy1fc4e38a0dwj31380isk0g.jpg" alter="" width="75%">

Google 看到解决方法：
 <!--more-->
	sudo pip -H install matplotlib

	sudo pip install matplotlib --ignore-installed six

 以及关闭SIP（system integrity protection）

都不能成功安装。

最后找到了解决办法：

#### 1.install pig-config
	brew install pkg-config

#### 2.install freetype
	brew install freetype

#### 3.install matplotlib
	pip install matplotlib

<img src="https://ww3.sinaimg.cn/large/006tNc79gy1fc4dp1hflpj313k0i0aha.jpg" alter="" width="75%">

Enjoy!