---
layout: post
title: Mac 环境配置
categories: 
- Technology
tags:
- mac
- dropbox
- brew
- vim

---


### 1. 翻墙工具：
> Surge/Shadowsocks (保存在 iCloud)

### 2. 常用工具：
> Chrome, Dropbox, 1Password, SourceTree, Alfred, BTT, Paste，iTerm，Sublimes, Bartender, Fantastical ...  

 <!--more-->

- 很多配置在 Dropbox 所以首先要下载 Dropbox, 个人将 licences，settings， backups 都存在 Dropbox。
- Alfred 通过 Advanced-Syncing 同步（必须主设备先同步，从设备的配置会被覆盖） <del>workflow需要另外下载</del>workflow 也可以自动同步。

- 输入法 Caps Lock 切换

- 允许不明开发者的app:  sudo spctl --master-disable 

- dock 显示加速： defaults write com.apple.Dock autohide-delay -float 0 && killall Dock

- dock resent apps： defaults write com.apple.dock persistent-others -array-add '{ "tile-data" = { "list-type" = 1; }; "tile-type" = "recents-tile"; }' && killall Dock

- 隐藏窗口图标变暗： defaults write com.apple.dock showhidden -bool true; Killall Dock

- Launchpad图标大小：

		defaults write com.apple.dock springboard-rows -int 7

		defaults write com.apple.dock springboard-columns -int 8

		defaults write com.apple.dock ResetLaunchPad -bool TRUE;killall Dock

- 显示隐藏文件： defaults write com.apple.finder AppleShowAllFiles -boolean true ; killall Finder

### 3. 配置工作环境：

iTerms 配置

* Homebrew：
		/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
	 

 Homebrew的使用

• 添加到环境变量 `echo 'export PATH="/usr/local/bin:$PATH"' >> ~/.bash_profile`

• 检查并更新 `brew doctor; brew update`

• 安装包 `brew install <package_name>`

• 更新包 `brew upgrade <package_name>`

• 清理旧版本 `brew cleanup`

• 列出包 `brew list --versions` 

* Zsh:
		brew install zsh zsh-completions
		wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O - | sh
		#设置theme 
		#下载zsh语法高亮
		##brew install zsh-syntax-highlighting，需要把 source /usr/local/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh 添加到 .zshrc 的最后面。
		##zsh aliasz
		##zsh_stats 可以查看常用代码

[http://get.ftqq.com/992.get][1]
[http://blog.jobbole.com/80620/][2]

* python 
		brew install python

  * pip
		curl https://bootstrap.pypa.io/ez_setup.py -o - | sudo python
		sudo easy_install pip
		或者
		wget 
		sudo python get-pip.py

###4.  vim语法高亮
		sudo cp /usr/share/vim/vimrc ~/.vimrc 
		sudo mkdir colors
		sudo mv solarized.vim ~/.vim/colors
		syntax on #.vimrc文件的第一行写入

###5. '~/.ssh/conf, zshrc'配置

		# Example aliases
		alias clr='clear'
		alias grep="grep --color=auto"
		alias -s html='vim'   # 在命令行直接输入后缀为 html 的文件名，会在 Vim 中打开
		alias -s rb='vim'     # 在命令行直接输入 ruby 文件，会在 Vim 中打开
		alias -s py='vim'      # 在命令行直接输入 python 文件，会用 vim 中打开，以下类似
		alias -s js='vim'
		alias -s c='vim'
		alias -s java='vim'
		alias -s txt='vim'
		alias -s gz='tar -xzvf' # 在命令行直接输入后缀为 gz 的文件名，会自动解压打开
		alias -s tgz='tar -xzvf'
		alias -s zip='unzip'
		alias -s bz2='tar -xjvf'
		alias zshconfig='vi ~/.zshrc'
		alias vimconfig='vi ~/.vimrc'
		alias ll='ls -l'
		alias vi='vim'
		alias subl='open -a "Sublime Text"'
		alias zshconfig='vi ~/.zshrc'
		alias vimconfig='vi ~/.vimrc'


###6. Markdown Sublime [shortcut](https://github.com/SublimeText-Markdown/MarkdownEditing#key-bindings)

###7. Mackup [配置恢复](https://github.com/lra/mackup)

permission error 解决方法： 修改owner 为 tzungtzu

###8. pip 安装制定版本
	pip list|grep 'py'
	pip install py2neo==2.0.9


### sublime 配置

[Installation - Package Control](https://packagecontrol.io/installation)


### 移动dropbox 目录需要修改的 （2018-12-5 添加

1. mackup config
2. softlink for macSync Folders
3. Alfred Sync folder


### References:
1. [小土刀][3]()
2. [][4]()

[1]:	http://get.ftqq.com/992.get
[2]:	http://blog.jobbole.com/80620/
[3]:	http://wdxtub.com/2016/08/08/mac-work-env/
[4]:	https://github.com/zsh-users/zsh-syntax-highlighting/blob/master/INSTALL.md
https://sspai.com/post/33493
https://sspai.com/post/33366
