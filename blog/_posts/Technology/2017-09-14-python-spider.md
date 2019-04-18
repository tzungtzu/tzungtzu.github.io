---
layout: post
title: python 抓取网页信息
categories: 
- Technology
tags:
- spider
- python

---

###登录信息
1. 账号密码
    查看HTML源码，Google里可以使用CTRL+U查看，然后使用CTRL+F输入input看看有哪些字段值。
    通过 chrome 的 network 的 login 的 Form Data 获取需要的字段。
    zhihu 还有一个隐藏字段 `_xsrf`，需要另外获取。简单的网站就是基本的字段。

<!--more-->

    通过request.session的 post 方法 进行登录。 get 方法获取网页信息。

        session = requests.session()
        login_data = {'email':email,'passwd':passwd}
        session.post('http://hk2.app.akulaku.com:60100/auth/login',data = login_data)
        r = session.get('http://hk2.app.akulaku.com:60100/user')

2. cookies

###爬虫爬取

        import bs4

        soup = bs4.BeautifulSoup(r.text,"lxml")
        r = session.get('url')
        name = soup.select('.hidden-xs')[0].get_text()

        注意最后，需要通过.get_text()方法转为中文字符。


###抓包

###ConfigParser

读取配置文件信息
        cf = ConfigParser.ConfigParser()
        cf.read('config.ini')
        email = cf.get('info','email')


### References:
1. [python爬取需要登录的网站信息](http://python.jobbole.com/83588/）
2. [抓包](http://www.jianshu.com/p/9822e3f28f0a)
3. http://www.csuldw.com/2016/11/05/2016-11-05-simulate-zhihu-login/
4. [github](https://github.com/lining0806/PythonSpiderNotes/blob/master/ZhihuSpider/ZhihuSpider.py)
5. [spider](http://www.lining0806.com/python%E5%85%A5%E9%97%A8%E7%BD%91%E7%BB%9C%E7%88%AC%E8%99%AB%E4%B9%8B%E7%B2%BE%E5%8D%8E%E7%89%88/)
6. [python 抓取网页](http://wuchong.me/blog/2014/04/24/easy-web-scraping-with-python/)