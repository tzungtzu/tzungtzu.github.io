---
layout: post
title: 导出 1Password 密码到 iCloud Keychain
categories: 
- Techonology
tags:
- 1Password
- iCloud
- Keychain

---

随着 iOS 11 和 iPhone X 的 Face id，iPhone 上通过原生 Keychain 输入密码越来越方便，只需要扫脸就可以了。所以自己把 1Password 里的密码导出同步到 iCloud Keychain。

<!--more-->

方法的原理是通过 Applescript 批量输入密码到 Safari 的密码管理里，自动同步到 iCloud Keychain。 

1. 输出 1Password 的密码，注意文件为 csv 文件，格式为 url, username, password 
2. 数据清洗。输入到 Safari 的数据不需要引号，将 csv 中的引号全部删除。
3. 运行 csv2keychain，程序会自动打开并添加密码。完成。


代码见：[tzungtzu/csv2keychain: import your passwords from 1Password to iCloud Keychain](https://github.com/tzungtzu/csv2keychain)


### References:
1. [lifepillar/CSVKeychain: Import/export between Apple Keychain.app and plain CSV file.](https://github.com/lifepillar/CSVKeychain)