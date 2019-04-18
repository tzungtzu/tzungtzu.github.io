---
layout: post
title: ssh使用公钥授权不通过的问题解决
categories: 
- Technology
tags:
- ssh
- mac
- pem

---

如果你连接 ssh 出现问题：
	Permission denied (publickey,gssapi-keyex,gssapi-with-mic).


## 不用怀疑，是你的pem文件有错误。

 <!--more-->

不过，偶尔也会有以下的情况：
1、下面两个目录的所有权必须是user，所属组也应该是user，权限必须为700
	\home\user
	\home\user\.ssh
2、下面公钥文件的所有权必须是user，所属组也应该是user，权限必须为644
	\home\user\.ssh\authorized_keys
3、下面私钥文件的所有权必须是user，所属组也应该是user，权限必须是600
	\home\user\.ssh\id_rsa

如果还有问题：将 `tc/ssh/sshd_config` 文件进行如下修改：
	RSAAuthentication yes
	PubkeyAuthentication yes
	AuthorizedKeysFile     .ssh/authorized_keys 

重启sshd 服务

—
### Mac 设置 ssh 登录免密登录

#### 客户端 生成密钥

#### ssh 服务端配置



### References:
1. [http://laowafang.blog.51cto.com/251518/1364298]()()
2. [http://www.jianshu.com/p/1fdcd9d9cb2f ][2]



[2]:	http://www.jianshu.com/p/1fdcd9d9cb2f "http://www.jianshu.com/p/1fdcd9d9cb2f"