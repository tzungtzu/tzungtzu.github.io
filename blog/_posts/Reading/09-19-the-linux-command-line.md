##the linux command line

| 目录 | comment |
|---|---|
|/bin |包含系统启动和运行所必须的二进制程序。|
|/boot|包含 Linux 内核|
|/etc|这个目录包含所有系统层面的配置文件。它也包含一系列 的 shell 脚本|
|/sbin|这个目录包含“系统”二进制文件。|


I/O 重定向允许我们可以更改输出走向和输入来向。一般地，输出送到屏幕，输入来自键 盘，但是通过 I/O 重定向，我们可以改变输入输出方向。
* 重定向标准输出
        ls -l ~/Workspace > ls-output.txt
* 重定向标准输入
        cat movie.mpeg.0* > movie.mpeg

grep全称是Global Regular Expression Print


文件

内容

/etc/proﬁle

应用于所有用户的全局配置脚本。

˜/.bash proﬁle

用户私人的启动文件。可以用来扩展或重写全局配置脚本中 的设置。

˜/.bash login

如果文件 脚本。

˜/.bash proﬁle 没有找到，bash 会尝试读取这个

˜/.proﬁle

如果文件 ˜/.bash proﬁle 或文件 ˜/.bash login 都没有找到， bash 会试图读取这个文件。这是基于 Debian 发行版的默认 设置，比方说 Ubuntu。

表 12-2: 登录 shell 会话的启动文件 136 非登录 shell 会话会读取以下启动文件：

文件

内容

/etc/bash.bashrc

应用于所有用户的全局配置文件。

˜/.bashrc

用户私有的启动文件。可以用来扩展或重写全局配置脚本中 的设置。