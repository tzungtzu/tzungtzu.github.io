---
layout: post
title: ssh 服务器间跳转
categories: 
- Technology
tags:
- ssh
- macos

---


有些时候，无法直连到某台服务器，需要中间服务器做跳板（gateway）,这个过程也可以自动化。首先确保你已经为服务器配置了公钥访问，并开启了agent forwarding，现在你就可以通过2条命令来连接目标服务器，不会有任何提示输入：

	$ ssh gateway
	gateway $ ssh db

如果你在远程服务器上的用户名和你本地的用户名不同，你同样可以在SSH配置中进行设置：

然后在你的本地SSH配置中，添加下面这条配置：

Host db
HostName db.internal.example.com
ProxyCommand ssh gateway netcat -q 600 %h %p

现在你就可以通过一条命令来直接连接目标服务器了:

$ ssh db

这里你可能会需要等待长一点的时间，因为SSH需要进行两次认证，，注意netcat也有可能被写成nc或者ncat或者前面还需要加上g，你需要检查你的中间服务器来确定实际的参数。


### References:
1. [高效使用 SSH 的 16 个技巧 - 文章 - 伯乐在线](http://blog.jobbole.com/33790/)
2. [SSH穿越跳板机登录远程服务器 | kikoroc](https://kikoroc.com/2016/06/30/ssh-login-remote-server-over-jump.html)
3. [iTerm2 结合 Linux expect 实现 ssh 自动登陆, 通过跳板机登录服务器内网功能 - 志哥专栏 - SegmentFault](https://segmentfault.com/a/1190000009826457)


ssh -i ~/Workspace/keys\&/baolei.pem -oProxyCommand="nc -x 127.0.0.1:6153 %h %p" ubuntu@52.77.156.128
