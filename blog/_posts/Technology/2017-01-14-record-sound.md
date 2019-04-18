---
layout: post
title: Mac 录屏／录音 内录系统声音
categories: 
- Technology
tags:
- mac
- preference
- sound

---

因为私人原因，需要录系统播放声音。可以通过录屏软件 ScreenFlow。QuickTime 为了防止盗版，不能录系统音频。但是可以通过安装 SoundFlower 解决。SoundFlower 是一个虚拟音频设备（下载地址点[这里][1]）

 <!--more-->

### 打开 Audio MIDI Setup：

- 新建一个 “Multi Output Device”，选择“Built-in Output” 和 “Soundflower(2ch)“
- 新建一个 “Aggregate Device”，选择“External Microphone”和“Soundflower(2ch)”

<br  />

### **在 Preference - Sound 里设置音频输出源**

- 输出源设置为刚刚设置的 “Multi Output Device”

<br  />

### 接下来打开QuickTime，在音频／录屏录制部分选择输入源

 - 如果在内录的时候需要不录下 mic 的声音，就在输入源选择 “Soundflower（2ch）”
- 如果在内录的时候需要录下 mic 的声音，就在输入源选择 “Aggregate Device”


<br  />

### 最后，可选择压缩文件。

<br  />

### 注意

经过修改输出源，无法调节系统的声音大小。等用完了录屏需求，可以将输出源修改回内置麦克风。





[1]:	https://github.com/mattingalls/Soundflower/releases/tag/2.0b2