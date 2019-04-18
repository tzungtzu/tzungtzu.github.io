---
layout: post
title: ssh 常用命令
categories: 
- Technology
tags:
- ssh
- scp

---

传统的网络服务程序，如 rsh、FTP、POP 和 Telnet 其本质上都是不安全的；因为它们在网络上用明文传送数据、用户帐号和用户口令，很容易受到中间人（man-in-the-middle）攻击方式的攻击。就是存在另一个人或者一台机器冒充真正的服务器接收用户传给服务器的数据，然后再冒充用户把数据传给真正的服务器。


### - 登陆
		ssh 主机名@主机IP   #输入对方密码就ok了。如果需要pem，加入-i。
		
### - 远程复制(secure copy)

 <!--more-->

	scp -r  要传输的文件  我的主机名@主机的IP：路径
	scp [参数] [原路径] [目标路径] ##-r 递归复制整个目录。



从本地服务器复制到远程服务器
	scp local_file remote_username@remote_ip:remote_folder
	$scp -r local_folder remote_username@remote_ip:remote_folder

scp -i ~/Workspace/keys\&/dataModelingRuntime.pem ubuntu@13.228.227.208:/home/ubuntu/hubo.sql ~/Downloads

	scp root@10.6.159.147:/opt/soft/demo.tar /opt/soft/

### - 关闭远程登录
		exit  #主动断开和对方的连接
		

### - 重启服务器
		sudo reboot

### - 关机
		shutdown -h now 现在立即关机
		shutdown -r now 现在立即重启
		shutdown -r +3 三分钟后重启

###Write failed: Broken pipe

造成这个错误的原因是SSH空闲链接时间太长导致的，我们需要修改SSH默认配置来让它自动关闭链接。

####针对服务器端的修改办法


####针对客户端的修改办法

		//编辑文件：
		 ~/.ssh/config
		//在里边添加如下语句：
		ServerAliveInterval 60
		//针对某一服务器的写法：
		//使用如下选项连接服务器：
		ssh -o ServerAliveInterval=60 user@sshserver

shadowsocks代理属于socks5代理，通俗的理解，socks5只是局部代理，不能像vpn那样把整个电脑都代理。因此，一般情况下只有支持socks5的软件才能使用shadowsocks代理。
我们使用的IE浏览器就不支持socks5代理，一般的游戏，也不支持socks5代理，那么这些软件如何使用代理？除了使用vpn，我们还有一种不错的办法，那就是把socks5代理转换成全局代理，效果跟vpn几乎一样。




要求终端走socks5 端口
[http://blog.ihipop.info/2011/01/1988.html][1]
[https://juejin.im/entry/5821840cd203090055134cc0][2]
[http://www.jianshu.com/p/ff4093ed893f][3]
[https://www.google.com.hk/search?q=%E7%BB%88%E7%AB%AF+socks+5+%E7%AB%AF%E5%8F%A3&gws\_rd=cr,ssl][4]

$\sigma$


[http://chaishiwei.com/blog/830.html][5]

[1]:	http://blog.ihipop.info/2011/01/1988.html
[2]:	https://juejin.im/entry/5821840cd203090055134cc0
[3]:	http://www.jianshu.com/p/ff4093ed893f
[4]:	https://www.google.com.hk/search?q=%E7%BB%88%E7%AB%AF+socks+5+%E7%AB%AF%E5%8F%A3&gws_rd=cr,ssl
[5]:	http://chaishiwei.com/blog/830.html

### References:
1. [[SSH 系列 1]：什么是 SSH、背景知识，SSH 协议需求与设计难点 | 土豆不好吃](https://www.bennythink.com/ssh-1.html)
2. [当SSH遇到“Write failed: Broken pipe” | 落格博客](https://www.logcg.com/archives/897.html)