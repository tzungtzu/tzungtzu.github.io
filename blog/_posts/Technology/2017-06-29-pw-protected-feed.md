---
layout: post
title: How to subscribe to password protected feeds
categories:
- Technology

tags:
- rss
- feed

---



Usually, we use rss reader like feedly, inoreader to read RSS feeds. This feature makes it possible to subscribe to RSS feeds using any RSS news reader which supports HTTP authentication.

For subscribing to password-protected feeds, most RSS readers are not supported as feedly, or should get upgraded feature like inoreder. But we have other method to solve the problem. 

To subscribe to a password-protected RSS feed, use the following formation for the RSS URL:

	http://[username]:[password]@[domain]/[path]


Note that the '@' character in the username (if you use) must be replaced with %40 (the URL for the '@' character).