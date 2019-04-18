

## Asus AC5300 安装 homebridge 踩坑记录（2） - 安装 Debian

一个 Node.js 项目，首先想到的安装方法，就是通过 Entware-ng 安装 Node.js 和 npm, 再通过 npm 安装 node.js. 但发现 Homebridge 需要依赖 mdns 等组件，而 mdns 包含 C/C++ 代码，编译过程中需要 avahi 的 lib 和头文件，而这些文件 Entware-ng 没有提供。自己编译 avahi 觉得太麻烦，所以开始尝试其他方法。

###1.  Download and extract prepared archive

        cd /opt
        wget -c -O debian_jessie8.9-arm_clean.tgz goo.gl/MZHjgv
        tar -xvzf ./debian_jessie8.9-arm_clean.tgz

发现终端不能翻墙，我将后面的链接改为 https://files.hqt.ro/debian/arm/debian_jessie8.9-arm_clean.tgz 。

解压发现会出现 tar: corrupted data tar: short read 的错误。判断可能是内存不足的错误
于是我在本地解压后，通过 scp 命令复制到 ssh。

        scp -r ~/Downloads/debian tzungtzu@192.168.50.1:/opt/

###2. Create startup script for installed services

        vi /opt/etc/init.d/S99debian

Paste all this lines

        #!/bin/sh
        PATH=/opt/bin:/opt/sbin:/sbin:/bin:/usr/sbin:/usr/bin
        # Folder with Debian Jessie
        CHROOT_DIR=/tmp/mnt/sda/entware/debian
        # Some folder outside of sandbox, 
        # will be mounted to /mnt folder in Debian
        # Uncommented next line if you need to mount a folder inside debian (remove #)
        # EXT_DIR=/tmp/mnt/sda/Media/
        CHROOT_SERVICES_LIST=/opt/etc/chroot-services.list
        if [ ! -e "$CHROOT_SERVICES_LIST" ]; then
            echo "Please, define Debian services to start in 
        $CHROOT_SERVICES_LIST first!"
            echo "One service per line. Hint: this is a script names from 
        Debian's /etc/init.d/"
            exit 1
        fi
        MountedDirCount="$(mount | grep $CHROOT_DIR | wc -l)"
        start() {
            if [ $MountedDirCount -gt 0 ]; then
                echo "Chroot'ed services seems to be already started, 
        exiting..."
                exit 1
            fi
            echo "Starting chroot'ed Debian services..."
            for dir in dev proc sys; do
                mount -o bind /$dir $CHROOT_DIR/$dir
            done
            [ -z "$EXT_DIR" ] || mount -o bind $EXT_DIR $CHROOT_DIR/mnt
            for item in $(cat $CHROOT_SERVICES_LIST); do
                chroot $CHROOT_DIR /etc/init.d/$item start
            done
            }
        stop() {
            if [ $MountedDirCount -eq 0 ]; then
                echo "Chroot'ed services seems to be already stopped, 
        exiting..."
                exit 1
            fi
            echo "Stopping chroot'ed Debian services..."
            for item in $(cat $CHROOT_SERVICES_LIST); do
                chroot $CHROOT_DIR /etc/init.d/$item stop
                sleep 2
            done
            mount | grep $CHROOT_DIR | awk '{print $3}' | xargs umount -l
            }
        restart() {
            if [ $MountedDirCount -eq 0 ]; then
                echo "Chroot'ed services seems to be already stopped"
                start
                else
                echo "Stopping chroot'ed Debian services..."
            for item in $(cat $CHROOT_SERVICES_LIST); do
                chroot $CHROOT_DIR /etc/init.d/$item stop
                sleep 2
            done
            mount | grep $CHROOT_DIR | awk '{print $3}' | xargs umount -l
                echo "Restarting chroot'ed Debian services..."
            for dir in dev proc sys; do
                mount -o bind /$dir $CHROOT_DIR/$dir
            done
            [ -z "$EXT_DIR" ] || mount -o bind $EXT_DIR $CHROOT_DIR/mnt
            for item in $(cat $CHROOT_SERVICES_LIST); do
                chroot $CHROOT_DIR /etc/init.d/$item start
            done
            fi
            }   
        enter() {
            [ -z "$EXT_DIR" ] || mount -o bind $EXT_DIR $CHROOT_DIR/mnt
            mount -o bind /dev/ /opt/debian/dev/
            mount -o bind /dev/pts /opt/debian/dev/pts
            mount -o bind /proc/ /opt/debian/proc/
            mount -o bind /sys/ /opt/debian/sys/
            chroot /opt/debian /bin/bash
            }
        status() {
            if [ $MountedDirCount -gt 0 ]; then
                echo "Chroot'ed services running..."
            else
                echo "Chroot'ed services not running!"
            fi
            }
        case "$1" in
            start)
                start
                ;;
            stop)
                stop
                ;;
            restart)
                restart
                ;;
            enter)
                enter
                ;;  
            status) status
                ;;
            *)
                echo "Usage: (start|stop|restart|enter|status)"
                exit 1
                ;;
        esac
        echo Done.
        exit 0

修改权限：

        chmod 755 /opt/etc/init.d/S99debian

注意，将  CHROOT_DIR=/tmp/mnt/sda/entware/debian 中 sda 和 entware 改成你自己的

###3. Create symlink to start-stop services or enter debian easier

        touch /opt/etc/chroot-services.list
        ln -s /opt/etc/init.d/S99debian /opt/bin/debian

运行服务： 

        debian start

###4. Copy hosts file to debian (usefull for some debian packages)

        cp /etc/hosts /opt/debian/etc/

###5. Enter chrooted debian
 
        debian enter

###6. Run update to see if some recent packages are available

        apt update && apt upgrade -y

###7. Set your country time zone

        dpkg-reconfigure tzdata

###8. Install some packages, ex. wget

        apt install wget

chroot 环境下的 debian 服务无法开机自动启动，如果需要 HomeBridge 开机自动运行，还需修改 /opt/debian/chroot-services.list 文件，添加 dbus, avahi-daemon, homebridge 三行内容。



### References:
1. [How to Install Debian Jessie - Arm](https://www.hqt.ro/how-to-install-debian-jessie-arm/)
2. [EntWare环境安装Debian 7.8 ARM](http://bbs.a9vg.com/thread-4668280-1-1.html)
3. [RT1900ac 折腾笔记：安装 Homebridge 和 Plex Media Server](https://blanboom.org/2017/plex-on-rt1900ac/)