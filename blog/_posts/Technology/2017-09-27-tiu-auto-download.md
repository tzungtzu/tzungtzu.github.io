---
layout: post
title: 下载 TIU 最新剧集视频
categories: 
- Technology
tags:
- spider
- thisisus
- folx

---




###1. 爬虫抓取ttmj的torrent

	用正则匹配最新的 720p 的 torrent 文件即可
			(https://?[^"]+?\.(S\d+)(E\d+)+?720+\.(torrent))


###2. 下载torrent

	利用 urllib 包的 urlretrieve 函数，注意添加文件路径。

###3. Folx 下载

	设置 Folx 自动下载 Downloads 文件夹中的文件。


以上基本解决自动下载的问题。

[see the code here](https://github.com/tzungtzu/spider/blob/master/tiu-downloader/spider.py)



### References:
1. [python下载图片并保存到文件夹](http://www.jianshu.com/p/938763947de3)