---
layout: post
title: Playing with Instagram's API 
categories: 
- 
tags:
- instagram
- api
- cron

---

以下是一个关于使用 Instagram API 的 turtorial。 同时给出利用 API 用脚本给女朋友点赞的例子。（enlightened by cyan）

<!--more-->

1. 安装 instagram python api.


        #prerequisites
        pip install httplib2
        pip install simplejson
        #
        pip install python-instagram


！！特别注意：

由于这个包已经不再维护，导致有一些代码需要修改，否则后续报错。下面会提示。

2. 获取 access token
    
    + 在 Instagram 的开发者中心创建一个 app，获取后续需要的 *client_id* 和 *client_secret* 。
    + 下载[get_access_token.py](http://movii.github.io/blog/2017/03/14/node-instagram-get-access-token/)并运行，按要求输入 *client_id,client_secret,redirect_url* 以及 *code*，输出 *access_token*
    
        fix for OAuth2AuthExchangeError: You must provide a client_id 
        在 *~/Library/Python/2.7/site-package *中 *instagram/oauth2.py* 102行

            -        response, content = http_object.request(url, method="POST", body=data)
            +        headers = {'Content-Type': 'application/x-www-form-urlencoded'}
            +        response, content = http_object.request(url, method="POST", body=data, headers=headers)


3.  通过 access token 点赞。
    
    main.py

        from time import sleep  
        from instagram.client import InstagramAPI
        import logging

        access_token = ""ENTER YOUR ACCESS TOKEN HERE""
        api = InstagramAPI(access_token=access_token,  
                    client_ips="YOUR IP",
                    client_secret="YOUR SECRET")

        recent_media, next_ = api.user_recent_media(user_id="5106250160", count=20)

        for media in recent_media:  
            # Where the media is
            id_ = media.id

            users = [user.username for user in media.likes]
            print users

                if "YOUR USERNAME" in users:
                print("IN PHOTO")

            else:
                print("LIKING PICTURE")
                api.like_media(media_id=id_)

    其中 user_id="5106250160" 改成要点赞的好友的id。
    解决 KeyError: 'data' with Python Instagram API client[5] 即可。

    需要注意，由于沙盒机制，必须先邀请好友进入沙盒。


4. 设置定时任务。
    
     */2 * * * *  表示每两分钟执行一次。crontab 

     crontab -l
     crontab -e


Tips:
https://www.instagram.com/tzungtzu/media/ 可以获取 media without auth.

TODO： 想获取自己like 的照片，好像不行，

有机会试试Telegtam BOT 完成一些自动化。

[BotFather](https://t.me/BotFather)


### References:
1. [笔记：获取 Instagram API 的 access token](http://movii.github.io/blog/2017/03/14/node-instagram-get-access-token/)
2. [http://leesonhsu.blogspot.hk/2016/04/instagram-api.html](http://leesonhsu.blogspot.hk/2016/04/instagram-api.html)
3. [https://smashballoon.com/instagram-feed/find-instagram-user-id/?username=gromitintardis&5611zzl19832tjrl=4](https://smashballoon.com/instagram-feed/find-instagram-user-id/?username=gromitintardis&5611zzl19832tjrl=4)
4. [instagram-python](https://github.com/vgavro/python-instagram/commit/9dfc264571ad7c343af3899445d13afedf23e3aa)
5. [https://stackoverflow.com/questions/33924581/keyerror-data-with-python-instagram-api-client](https://stackoverflow.com/questions/33924581/keyerror-data-with-python-instagram-api-client)
6. [https://github.com/facebookarchive/python-instagram/blob/master/README.md](https://github.com/facebookarchive/python-instagram/blob/master/README.md)
7. [linux笔记：crontab计划任务 - CSDN博客](http://blog.csdn.net/xrt95050/article/details/3980567)


