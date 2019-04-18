---
layout: post
title:  利用Hazel和脚本文件自动转电子书格式
categories:
- Technology 
tags:
- ePub
- mobi
- ebook
---



[上篇文章][1]说到利用Calibre的Command Line Interface可以将mobi格式转为ePub格式。更进一步（更加偷懒），每当下载一个mobi文件，系统自动将mobi文件进行格式转换，并把它放进eBook文件夹。这整个workflow可以通过Hazel这个软件实现。

 <!--more-->

## Hazel
Hazel是一个自动整理文件辅助软件，可以根据你设定的规则自动将文件移动（复制）到指定位置。同时也支持Shell，AppleScript这样的脚本文件。

我觉得Hazel是个很强大的软件，不过目前只会用它做一些简单的整理类的动作。希望有机会做一些更有趣的事情。

在这里不做过多介绍，通过这个实例来介绍如何Hazel运行规则。

## 建立格式转换规则

<img src="http://7xo4c2.com1.z0.glb.clouddn.com/hazel.jpeg" alter="hazel" width="75%">

如图整个流程是个if...then...语句。在Download文件夹一旦出现mobi格式的文件，自动在文件夹内运行内嵌的脚本文件，脚本文件第一行获取文件的文件名（不包括后缀），第二行对mobi文件进行转换，生成相同文件名的ePub文件。下一步再将文件移动到eBook文件夹。


> 任何一个需要部署或者配置三遍以上的动作，就值得花时间写脚本出来。重复劳动是笨的体现。


[1]:	http://tzungtzu.cshozzy.com/2016/09/03/convert_to_epub.html