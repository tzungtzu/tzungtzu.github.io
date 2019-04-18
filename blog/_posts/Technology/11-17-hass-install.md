---
layout: post
title: entware 安装 hass
categories: 
- Technology
tags:
- hass
- router
- entware

---

接 安装 entware

安装 Python

到这一步，Merlin 已经配置好了，Entware 也完成了，基本大功告成了，此时的 Merlin 可以当作一个自由的嵌入式 Linux 使用了。那么，我首先推荐安装支持最为完美的脚本语言 Python 的环境：

安装 python3：

    opkg install python3

安装 pip3

    opkg install python-pip

安装虚拟环境

    pip3 install --upgrade virtualenv

创建安装目录

    mkdir homeassistant

创建虚拟环境

    virtualenv -p python3 homeassistant/

进入虚拟环境

    source /homeassistant/bin/activate


安装homeassistant

    pip3 install --upgrade homeassistant


运行hass看看是否安装成功

    homeassistant/bin/hass


配置文件在/root/.homeassistant 

### References:
1.  [LEDE X64下安装home assistant（有坑，望大神指点） - 『HomeAssistant』综合讨论区 - 『瀚思彼岸』» 智能家居第一站 - Hassbian.com](https://bbs.hassbian.com/thread-1567-1-1.html)