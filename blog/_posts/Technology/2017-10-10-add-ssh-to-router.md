---
layout: post
title: 为路由器设置免密码登录的 ssh 连接
categories: 
- Technology
tags:
- asus
- router
- ssh

---


###1. 把公钥添加到远端
只需要在本地用：

		ssh-copy-id user@host

就可以自动把公钥传输到远程主机上了。该命令实际上就是把公钥文件的内容附加到了远程主机的 authorized_keys 文件中，通常该文件路径为：~/.ssh/authorized_keys。

这样以后就可以用 ssh admin@192.168.1.1 直接登录到路由器而不必输入密码了。

<!--more-->

###2. 设置 ssh 的 config 文件

每次连接路由器要输入 ssh admin@192.168.1.1 其实还是挺烦的，可以在本地的 ssh配置文件中设置路由器的 host 信息，以后只要用这个主机名连接就可以了。

用文本编辑器打开 ~/.ssh/config 文件，如果没有就新建一个，然后添加如下信息：

        Host my_host_name
            HostName 192.168.1.1
            User admin

其中 my_host_name 就是自己为路由器起的一个名字，以后只需要

$ ssh my_host_name
就可以登录了。

config 文件还有很多其他设置，可以参考 man 页面的介绍。


### References:
1. [为 OpenWrt 路由器设置免密码登录的 SSH 连接](http://weining.me/2016/11/04/add-ssh-key-to-openwrt-router)