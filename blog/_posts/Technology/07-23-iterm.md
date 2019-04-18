
Terminator 是 unbutu 中非常好用的终端工具，macOS 中的替代品是 iTerm

下面推荐几个iTerm 新手用到的很方便的点。

### 1. 选中即复制
智能选中？
### 2. 路径重复
	在新Tab中自动使用前Tab路径，Profiles-General-working Directory
### 3. 屏幕切割
### 4. 全屏切换
### 5. 快速复制，粘贴，删除
### 6. 查看历史记录
iTerm2 也可以使用历史记录，按⌘+Shift+h弹出历史粘贴记录窗口，⌘+Shift+;弹出历史命令记录窗口。

执行以下操作应该做的伎俩(使用setopt来重新启用它们)：
	unsetopt inc_append_history
	unsetopt share_historyhttps://gxnotes.com/article/58062.html

### 7. 位置书签
在当前会话中按Command + Shift + m可以保存当前位置，之后可以按Command + Shift + j跳回这个位置。


设置 caps lock 为 ctrl


快捷键大全

@: 2016-11-27-shortcut

[https://cnbin.github.io/blog/2015/06/20/iterm2-kuai-jie-jian-da-quan/22][1]



让我们的终端变得更 Cool，让它来无影去无踪。这一步我要 iTerm 启动后不再出现在 Dock 上，打开终端输入下面的命令，然后重启 iTerm。

	/usr/libexec/PlistBuddy  -c "Add :LSUIElement bool true" /Applications/iTerm.app/Contents/Info.plist

这个方法是通用的，LSUIElement1可控制 app 以无Dock，无菜单栏的方式运行，另外LSBackgroundOnly2可让 app 以无窗口的方式在后台运行。详细说明可查

/usr/libexec/PlistBuddy  -c "Delete :LSUIElement" /Applications/iTerm.app/Contents/Info.plist
想要方便开关 Dock 图标，可将下面的内容添加到 /.zshrc 或 /.bash_profile中，然后只需要输入 toggleiTerm，按提示操作即可。[4][2]

## 		使用 option + ‘<-,->’ 在单词间跳转

[Mac下iTerm2光标按照单词快速移动设置 - CSDN博客](https://blog.csdn.net/skyyws/article/details/78480132)




### References:
1. [http://wulfric.me/2015/08/iterm2/]()
2. [http://www.yangzhiping.com/tech/iterm2.html][4]
3. [http://blog.csdn.net/thinkdiff/article/details/25075047][5]
4. [http://blog.csdn.net/thinkdiff/article/details/25075047][6]
5. [https://blog.xinshangshangxin.com/2015/09/13/iTerm2/][7]
6. [https://gxnotes.com/article/58062.html][8]

[1]:	https://cnbin.github.io/blog/2015/06/20/iterm2-kuai-jie-jian-da-quan/
[2]:	4
[4]:	http://www.yangzhiping.com/tech/iterm2.html
[5]:	http://blog.csdn.net/thinkdiff/article/details/25075047
[6]:	http://blog.csdn.net/thinkdiff/article/details/25075047
[7]:	https://blog.xinshangshangxin.com/2015/09/13/iTerm2/
[8]:	https://gxnotes.com/article/58062.html