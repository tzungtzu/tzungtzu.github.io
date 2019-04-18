
## Asus AC5300 安装 homebridge 踩坑记录（1） - 安装 Entware

###1. Merlin 的基本设置

+ 开启 SSH
    系统管理 - 系统设置 - SSH Deamon
+ 启用 JFFS 自定义脚本和配置
    Enable JFFS custom scripts and configs

此时，这个系统是没有包管理功能的，并且多数目录都是只读的。虽然你是 root 权限的用户，但是你没法在随意写入文件。例如，你在根目录创建一个文件夹，会提示：

        tzungtzu@RT-AC5300-6730:/# mkdir test_dir
        mkdir: can't create directory 'test_dir': Read-only file system

你在绝大部分目录下都是如此，虽然你可以在 /tmp 目录下任意写入内容，但是毕竟是 /tmp，重启可能就消失了。
咋一看，这个系统不能自由的写入内容的话，好像什么用都没有了。其实不是，既然内置空间是“有保护”的，那么我们可以用外置设备充当额外的“硬盘空间”，就可以有完全的读写权限的空间使用了。当然这个“硬盘”对于路由器而言，就是外置的 U 盘。


###2. 自动挂载 U 盘

梅林用 Entware 需要一个可随意读写的空间，这个空间需要挂载到 /opt 目录。插上 U 盘，执行df 命令，可以通过输出知道，我的 U 盘是 /tmp/mnt/sdb, 记住这个名字，执行一下命令。

        cat << EOF > /tmp/script_usbmount.tmp
        if [ \$1 = "/tmp/mnt/sda" ]
        then
        ln -sf \$1 /tmp/opt
        /opt/etc/init.d/rc.unslung start
        fi
        EOF
        nvram set script_usbmount="`cat /tmp/script_usbmount.tmp`"

        cat << EOF > /tmp/script_usbumount.tmp
        if [ \$1 = "/tmp/mnt/sda" ]
        then
        /opt/etc/init.d/rc.unslung stop
        fi
        EOF

其中“/tmp/mnt/sda”替换为自己的 U 盘路径，然后执行（将上面的脚本内容永久的保存在 NVRAM 中）：

        nvram set script_usbumount="`cat /tmp/script_usbumount.tmp`"
        nvram commit 

即可看到效果。其目的是自动挂载（卸载） U 盘到 /opt 目录。待系统启动以后，cd 进入 /opt 自行确认是否是 U 盘路径。

注意：在使用 U 盘前，请先格式化成 Linux 所兼容的文件系统，对于 AC5300 的 Merlin 推荐 ext3/4 格式 。

        diskutil list
        ##确定 U 盘位置

        diskutil unmountDisk /dev/disk2
        sudo $(brew --prefix e2fsprogs)/sbin/mkfs.ext3 /dev/disk2


###3. 安装Entware

Merlin 在 15 年开始的某个版本上就已经内置了 Entware 的安装脚本了，直接终端执行即可：

        entware-setup.sh

进入交互，输入1，进入下一步。就安装完成了。此时，/opt 目录呈现 Entware 的文件系统。

### References:
1. [玩转路由之 AsusWRT-Merlin 与 Entware](https://blog.bluerain.io/p/AsusWRT-Merlin.html)
2. [How To Install New Generation Entware](https://www.hqt.ro/how-to-install-new-generation-entware/)
3. 




diskutil list

sudo $(brew --prefix e2fsprogs)/sbin/mkfs.ext3 /dev/disk2