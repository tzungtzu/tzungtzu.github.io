---
layout: post
title: python 模拟鼠标键盘操作
categories: 
- Technology
tags:
- python
- mac
- mouse
- keyboard
- pyuserinput

---

出于用键盘打开 mac 下通知中心提醒的需求，开始了解用 python 模拟鼠标动作。发现了[PyUserInput][1]这个项目。在配置完成后，调用非常简便。

 <!--more-->

### 1.准备

进入项目主页，可以看到这个Python库是跨平台支持的，但是对应不同平台，需要安装依赖库。

> Linux - Xlib (python-xlib)  
> Mac - Quartz, AppKit  
> Windows - pywin32, pyHook

由附录2可知，pyobjc 包含了 Mac 下需要的两个依赖，所以只需安装 pyobjc 包。

	pip install pyobjc
	pip install PyUserInput

### 2.调用方法

在安装完PyUserInput后，pymouse和pykeyboard模块就被安装到你的Python路径下。
建立一个鼠标和键盘对象：

	from pymouse import PyMouse
	from pykeyboard import PyKeyboard
	m = PyMouse()
	k = PyKeyboard()

接下来是一个示例，完成点击屏幕中央并键入“Hello, World!”的功能：

	x_dim, y_dim = m.screen_size()
	m.click(x_dim/2, y_dim/2, 1)
	k.type_string('Hello, World!')

写到这里，发现自己不会写 Alfred Workflow 的 python 文件，于是我用 BetterTouchTool 的多步鼠标动作完成了这个需求🤦🏻‍♂️。


### References:
1. [http://www.jianshu.com/p/552f96aa85dc]()()
2. [http://blog.chunnorris.cc/2015/03/osx-10102-yosemite-pyuserinput-python.html]()()

[1]:	https://github.com/SavinaRoja/PyUserInput/wiki/Installation
