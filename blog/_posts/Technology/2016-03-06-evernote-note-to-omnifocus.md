---
layout: post
title: 利用IFTTT将Evernote note同步到OmniFocus
categories: 
-  Technology
tags:
-  Evernote
- OmniFocus
- IFTTT

---



## Background

我是个爱折腾的人，看我的博客就知道。经常使用一些效率软件，写作软件。有时候想让笔记互相流通或是利用软件做一些自己想做的事情。比如想提醒自己以后查看某个Evernote，利用Alfred快速记录到Day One, 用Alfred快速查看OmniFocus Inbox等等。这些想法我都在脑洞大开的时候纪录在Evernote[文件]()，偶尔看看自己是否能实现。今天例行整理Evernote时看到标题这条，正好趁着看综艺的时候把它做出来分享。

 <!--more-->
用过IFTTT的朋友都知道，自动化任务都是将需求分解，分别实现。而我们的任务就可以分解成：
1. 读取（抓取）指定的Evernote note。
2.  将note 发送给OmniFocus。

## Trigger

第一步很简单，你可以自己手动选择，复制链接。也可以通过tag选取（这是IFTTT里我们选择的方式）

## Action

对于第二步。通过[OmniFocus拓展][2]我们知道，可以通过Mail Drop发送邮件或者Siri语音从第三方建立Inbox新项目。所以可以通过两个途径，发送项目到OmniFocus。两种方法都可以实现，我们来分别讲讲。

1. Mail Drop 的方法比较简单，利用IFTTT里的Gmail的Action，可以通过Gmail将指定元素发送到指定的邮箱。而指定邮箱我们使用OmniFocus的**Mail Drop 地址**。这个方法的好处是Note的标题作为Inbox item标题，同时将Note的内容一起发送到item的note中。
2. 利用iOS自带功能的方法比较复杂。利用Siri语音第三方建立新项目其实是通过先用Siri建立Reminder的新项目，再将新项目发送到OmniFocus来实现的。所以利用IFTTT实际上是将note发送到iOS的Reminder，再开启OmniFocus的同步Reminder功能来同步item。特别需要注意的是，IFTTT设置的Reminder List必须和OmniFocus同步的List一致。这个方法有两个缺点：一是必须下载IFTTT手机客户端；二是麻烦，实际上是走了两条分支来实现功能。所以，一般情况下推荐使用第一种方法。

## Set Time
关于第三方导入OmniFocus Inbox的项目都无法设置时间。不过通过Apple Reminder设置的待办事项同步到Inbox是自动同步时间的。所以可以通过Alfred快速写入到Fantastical来写入待办事项到Reminder再同步到Inbox。不过只能精确到日期。这也进一步说明，GTD步骤里，对Inbox内容整理是一个单独的动作。不可以省略。

 <a target="_blank" href="https://ifttt.com/recipes/393556-send-evernote-note-to-omnifocus"> IFTTT Recipe: Send Evernote Note to OmniFocus </a>

[2]:	https://support.omnigroup.com/doc-assets//OmniFocus-iOS/OmniFocus-iOS-v2.6.0.0/zh/EPUB/xhtml/16_extended.xhtml