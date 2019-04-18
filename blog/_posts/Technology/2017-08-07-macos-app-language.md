---
layout: post
title: macOS 下修改 app 语言
categories: 
- Technology
tags:
- macOS
- language

---

macOS 系统语言为英文情况下，修改特定 app 语言为中文。以下以 maps 为例。


 ~<!--more-->~

1. [View]-> [Labels]-> [Always Show Labels in English]  取消后，地图上显示的名字将本地化，显示为中文。

2. 如果需要 app 的设置都为中文，使用命令行：
''defaults write com.apple.Maps AppleLanguages '("zh-CN")'
    
macOS 界面在默认英文语言环境下最赏心悦目，也不用担心翻译带来的歧义；而对于地图等本地化软件，使用中文界面更好。