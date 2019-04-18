---
layout: post
title: 没有打断感
categories:
- Technology

tags:
- macOS
- Alfred
- AppleScript

---


喜欢 Tweetbot 在背景页面打开连接这个细节。以及在 Chrome 查看网页的时候会使用「从背景页打开」。

于是做了一个在 Alfred 里的 Workflow（也完全可以在 Automator 里创建 Services 实现）。实现的功能是：

> 在「任何」软件阅读的时候可以选中文字进行搜索，自动在背景页面打开，需要的时候再在 Chrome 查看，达到没有打断感的体验。

<!--more-->

具体来说，

### 1. 实现的基本动作，是选中文本进行 Google 搜索。

我采用的语言是基于 macOS 系统层面的 AppleScript，主要原因是简单。（当然我也在看脚本运行的方法，它们更加强大）

	 tell application "Google Chrome"
	        tell window 1
	            set newTab to make new tab with properties {URL:myurl}
	        end tell
	end tell

其中 myurl 就是我们要搜索的 URL。

### 2. 对不同的应用进行不同处理。

如果当前在 Chrome， 则从 Chrome 背景页面打开；如果当前在其他 App，只需要在 Chrome 打开新页面即可，方便跳转 App 的时候查看。
只需要做一个条件判断当前 Focus 的 App 是否为 Chrome。

	tell application "System Events"
	    set activeApp to name of first application process 
	end tell
	
	if 
	else
	endif

在这里我们把它设为 activeApp.

### 3. 加强搜索能力。

如果想要继续加强这个搜索，比如我查看网页时会看到没有加入超链接的链接，可以考虑直接选中就打开链接，避免搜索这个重复过程。同时也可以将这个快捷键同时作用于这两种搜索方法上。

### 4. 避免误按。

通过异常抛出来处理当选中文字为空字符串的误用。 
 
### 5. 设置不同快捷键给特定搜索。

可以设置更多快捷键给 wiki，douban 等专门的搜索。

最后给出这个 workflow 的[下载地址][1]吧。







[1]:	https://github.com/tzungtzu/alfred-workflows/raw/master/Downloads/Google%20Search%20HotKey.alfredworkflow