cdh 机器排坑：

1. scala 
2. spark2-submit/shell  
    对应的路径：/opt/cloudera/parcels/SPARK2-2.3.0.cloudera2-1.cdh5.13.3.p0.316101/lib/spark2/

    能够正常编译simpleApp, 运行没有结果，需要解决。
3. sbt 打包报错，依赖包问题。尝试用 maven 打包
4. 单机spark maven 打包。
    
    Maven 项目管理和构建自动化工具
    mvn -v

    linux下使用maven自动构建项目
    mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

5.  



### References:
1. [Maven编译Spark源码总结 - CSDN博客](https://blog.csdn.net/yizheyouye/article/details/60602753)
2. [linux下使用maven自动构建项目 - CSDN博客](https://blog.csdn.net/sxs_smile/article/details/71024355)
3. [spark开发环境搭建（基于idea 和maven） - CSDN博客](https://blog.csdn.net/u012373815/article/details/53266301)
4. [Linux下Maven的安装与使用-大九刘的博客-51CTO博客](http://blog.51cto.com/9820245/1611484)
5. [使用 maven 创建 scala 项目问题总结 | 海牛部落 高品质的 大数据技术社区](http://www.hainiubl.com/topics/39)
