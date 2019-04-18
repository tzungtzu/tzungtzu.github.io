---
layout: post
title: 在墙外用iPad看youku的美剧+新进美剧Castle
categories:
- Technology
tags:
- ipad
- 代理
- 美剧
- Castle

---

买了Pad以后，就不想在笔记本上看美剧了，但是身在墙外，youku，sohu视频的美剧都会告诉你此视频只限中国大陆播放。chrome浏览器可以通过Unblock Youku插件来翻回墙内，觉得一定有pad也有办法，果不其然搜寻找到了lovelucy的一篇[博文][1]。里面提到ios设备也可以通过设置proxy代理达到Unblock Youku插件一样的效果。
![][image-1]

## 1. 代理设置
其实只要在iPad的网络设置中设置一个http代理即可，而Unblock Youku提供了一个代理自动配置PAC文件。地址如下

	    http://yo.uku.im/proxy.pac

<font color="red">**2015更新两个地址：**</font>

	    http://pac.uku.im/pac.pac
	    http://pac.unblockcn.com


只需要将地址打开当前使用wifi的http代理，设为自动即可。
![][image-2]

**2016更新：**实测104.236.189.178是好用的DNS，可以直接加入这个dns到你的网络连接配置里。

## 2. 浏览器设置方法
如果你习惯用Firefox，或是在linux下不能使用chrome插件，同样可以在浏览器设置的高级选项里面设置http代理，方法如下。
![][image-3]

## 3. 检查代理是否设置成功
点击[这里][2]查看是否成功设置代理。
如果页面显示true，则说明代理设置成功；如果false,则请检查代理地址是否写错。
![][image-4]


---
微博好友知道我喜欢Criminal Minds, 推荐给我一部悬疑剧Castle, 中文名灵书妙探，虽然已经出到第五季了我才刚开始看，不过照我这速度应该很快就能赶上= =。大概看到第五集决定开始追这部剧，角色不多，虽然没有很强的TEAM，这部剧特别在男作家与女警探的互动，同时castle家的萝莉和老妈也很有亮点，很温馨。配乐也很赞。偶尔还有一句让人爆笑的台词。

唯一让我感到别扭的是每集开头一定要先放出各种pose的尸体（想想其实罪案剧都要先引出尸体，CM不也是嘛）以及曲折得有点过头的破案过程（但这也是为了突出奇情）。不过不影响我对这部剧的喜欢，四颗星～

![][image-5]

说到Castle，让我想起了zhihu里看到的男人应有的特质，有趣和有担当，有趣在一起才不会枯燥，有担当才能够可靠。扯远了。。向着这个方向努力吧～







[1]:	http://www.lovelucy.info/unblock-youku-on-ipad.html/comment-page-1#comment-1118
[2]:	http://ipservice.163.com/isFromMainland

[image-1]:	/media/files/2013/01/11/tv.png
[image-2]:	/media/files/2013/01/11/set.png
[image-3]:	/media/files/2013/01/11/firefox-proxy.png
[image-4]:	/media/files/2013/01/11/check.png
[image-5]:	/media/files/2013/01/11/castle.jpg