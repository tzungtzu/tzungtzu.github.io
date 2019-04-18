---
layout: post
title: broadlink rm pro plus 连接 homebridge
categories: 
- Technology
tags:
- homebridge
- homekit
- broadlink

---





hroadlink rm pro 也可以通过 homebridge 连接 homekit，但是比小米设备复杂，不止安装插件，配置文件需要修改。

        sudo npm install -g homebridge-broadlink-rm

这个插件需要nodev7.6.0以上

射频和红外控制：客厅灯，空调，风扇。


配置文件中设备 type 有 switch, switch-multi, switch-repeat
data: on, off 都有对应的学习代码，用来控制开关。。



添加好HB后，发现Learn按键, 点击按下Learn 键，此时RM PRO灯处于橙色状态，把要学习的红外/或者射频的遥控器按键按下让RM PRO学习   (通过哪种方式打开 learn code 按钮)

5、查看HEX码（HomeKit 16进制码）
查看日志运行：sudo journalctl –no-pager -u homebridge –since today


433M射频遥控
HEX码转换去 Base64码



RM-Pro 内置了温度感应器
控制 apple tv


### References:
1. [解放你的双手 — 让普通家电也能被Siri召唤_生活记录_什么值得买](https://post.smzdm.com/p/532100/)
2. [记一次完整的用siri+homekit+broadlinkrm pro 控制空调+调温开关 - 『HomeKit』综合讨论区 - 『瀚思彼岸』» 智能家居第一站 - Hassbian.com](https://bbs.hassbian.com/thread-441-1-1.html)
3. [homebridge博联插件控制空调电视等应用简明指引 - 『HomeKit』综合讨论区 - 『瀚思彼岸』» 智能家居第一站 - Hassbian.com](https://bbs.hassbian.com/thread-450-1-1.html)
4. [有没有什么方法将空调加入homekit中去？或者有海尔之外的homekit空调吗？ - HAChina 中文网](https://www.hachina.io/forums/topic/1424)
5. [【新提醒】关于安装博联RM插件后，homebridge自启动无效/报错的解决方法 - 『HomeKit』综合讨论区 - 『瀚思彼岸』» 智能家居第一站 - Hassbian.com](https://bbs.hassbian.com/thread-734-1-1.html)
6. [博联万能遥控器 - 奇怪Wiki](https://homekit.loli.ren/docs/show/30)
7. [利用 Hassio 中 homebridge-broadlink-rm 将博联(黑豆等)接入 HomeKit - 『HomeKit』综合讨论区 - 『瀚思彼岸』» 智能家居第一站 - Hassbian.com](https://bbs.hassbian.com/thread-2320-1-1.html)
8. [Buttons are there now - but no code is learning - RM3 Pro + (plus) · Issue #222 · lprhodes/homebridge-broadlink-rm](https://github.com/lprhodes/homebridge-broadlink-rm/issues/222)