[root@pvcent107 ~]# nohup ping www.ibm.com &
[1] 3059
nohup: appending output to `nohup.out'
[root@pvcent107 ~]# ps -ef |grep 3059
root      3059   984  0 21:06 pts/3    00:00:00 ping www.ibm.com
root      3067   984  0 21:06 pts/3    00:00:00 grep 3059
[root@pvcent107 ~]#



$ pgrep firefox
1827

看到了什么？没错火狐的PID，接下来又要打字了：

$kill -s 9 1827


pkill -９ firefox


[【转】linux下杀死进程（kill）的N种方法 - CSDN博客](http://blog.csdn.net/andy572633/article/details/7211546)