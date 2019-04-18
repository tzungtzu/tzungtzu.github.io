---
layout: post
title: github部署博客小记
categories:
- Technology
tags:
- blogging
- github
- 部署
---

10月把sinaapp博客和tu的博客连接的时候把sinaapp弄坏了，于是尝试了一下github+jekyll建博，觉得是个很轻便的博客，并且又有版本控制，可以保证资料存储。于是有了搬家到github的想法。在前人的帮助和自己慢慢摸索下，终于把博客搭好，主题，评论系统。基本能够正常运行了，以后有什么东西再慢慢添加。

在写添加博文的时候出现了一个问题，修改前的文章在blog中依然存在，这是因为虽然在目录下删除了文件，但是没有进行git删除，所以只是本地删除了，github上没有删除，只需要git删除后再提交就能解决。代码如下：

	    $git rm -rf XXX.md
	    $git commit -m "del post"
	    $git push origin master

另外，针对本地预览出现的一些问题，一些解决方法。

1. 安装ruby,jekyll版本问题和gem的问题：可以通过[这里][1]提供的方法安装解决。
2. jekyll --server时出现的编码问题：

		"Ruby193/lib/ruby/gems/1.9.1/gems/jekyll-0.11.2/lib/jekyll/convertible.rb:29:in ‘read_yaml’: invalid byte sequence in GBK (ArgumentError)"
  找到ruby目录下gems/jekyll-0.11.0/lib/jekyll/convertible.rb29行修改为下面的内容

	    self.content = File.read(File.join(base, name), :encoding => "utf-8")
最后

	    jekyll --server --auto
即可通过

一些小技巧：
## 1
### 2
**3**

---

最后感谢参考文献下的大牛们，才能有现在的博客

Reference:
1.[http://beiyuu.com/github-pages/][2]
2.[http://www.ruanyifeng.com/blog/2012/08/blogging\_with\_jekyll.html][3]
3.[http://xiaoxiongmao.me/2012/06/30/jekyll-github-markdown.html][4]
4.[http://www.worldhello.net/2011/11/29/jekyll-based-blog-setup.html][5]
5.[http://www.yangzhiping.com/tech/github.html][6]



[1]:	http://hbin.iteye.com/blog/1146748
[2]:	http://beiyuu.com/github-pages/
[3]:	http://www.ruanyifeng.com/blog/2012/08/blogging_with_jekyll.html
[4]:	http://xiaoxiongmao.me/2012/06/30/jekyll-github-markdown.html
[5]:	http://www.worldhello.net/2011/11/29/jekyll-based-blog-setup.html
[6]:	http://www.yangzhiping.com/tech/github.html