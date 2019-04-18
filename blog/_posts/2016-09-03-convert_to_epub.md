---
layout: post
title:  电子书格式转换，mobi转为ePub格式
categories:
- Technology 
tags:
- ePub
- mobi
- ebook
---


### 需求：

由于现在基本用apple三件套看电子书，在家一般用Pad，出门带上iPhone，有时候就用iBooks杀时间看看书。只有在用电非常有限的时候（徒步）才会带上Kindle。

但是网上下载电子书资源，基本上还是mobi格式居多，需要自己转换成ePub格式。一般都会通过网站在线转换。去的次数多了，觉得很不方便。需要打开网页，选定文件，才能转换。自己做事一般能省一步就省一步，所以想通过找到一些提供支持的服务来简化步骤。

 <!--more-->

目前常用的支持CLI(Command Line Interface)的文件格式转换软件（服务）以及优缺点如下：
1. Calibre ：主打电子书管理，功能非常全面，从一键发送kindle，添加图书信息，添加tag，文件转换。一应俱全。 ；文件太。。大。

2. [pandoc ][1]： 支持很多格式之间的文档转换。（HTML,XML,ePub,PDF, Tex）；不支持mobi格式作为输入或者输出

3. [convertio][2] ：在线文件转换服务，提供API，可以利用CLI在线命令行转换。  暂时有bug



## Calibre
安装好Calibre后，还不能直接使用CLI，
需要建立[软链接][3]

	ln -s /Applications/calibre.app/Contents/MacOS/ebook-convert /usr/local/bin

或者设置全局变量

	export PATH=$PATH:/Applications/calibre.app/Contents/MacOS

之后即可转换文件

	ebook-convert input_file output_file

具体可选配置可以点[这里][4]。



## Convertio

1. 注册获取API Key

2. Installation

		wget --no-check-certificate -O '/usr/local/bin/convertio' https://api.convertio.co/convertio
		chmod +x /usr/local/bin/convertio

3. Convert

		export CONVERTIO\_API\_KEY=\_YOUR\_API\_KEY\_
		convertio -f jpg input.pdf


<img src="http://7xo4c2.com1.z0.glb.clouddn.com/convertio.jpeg" alter="convertio" width="75%">

在这一点上，Kindle做的很好，不但有相关的服务，还有KindleGen这样的软件，可以直接利用CLI将不同格式文件转化为mobi格式。


[1]:	http://pandoc.org/
[2]:	https://convertio.co/zh/cli/
[3]:	https://github.com/GitbookIO/gitbook/issues/333
[4]:	https://manual.calibre-ebook.com/generated/en/cli-index.html#