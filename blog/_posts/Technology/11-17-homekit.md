###mac 安装 homebridge

1. Xcode
2. homebrew
3. nodejs npm
 
        brew install node
    
    To test out your Node and npm install, try installing Grunt (you might be asked to run with sudo):

        npm install -g grunt-cli
4. homebridge
 
        sudo npm -g install homebridge
        or
        sudo npm install -g --unsafe-perm homebridge

5. 
        homebridge




犹豫现在使用的是 macbook 运行 homebridge，所以需要 macbook 合盖不休眠。

所以需要运行：
        
         caffeinate -disu &


HomeBridge

---

throw err 错误通过[2]解决，

        /usr/local/lib/node_modules/homebridge
        sudo npm install --unsafe-perm mdns
        sudo npm rebuild --unsafe-perm

如果登陆后找不到 Yeelight，可能是因为没有打开 develop mode，需要下载 Yeelight 软件在 LAN Setting 中设置




sudo npm -g install homebridge-yeelight
sudo npm install -g homebridge-miio

### 小米净化器。

        miio --discover --sync

获取 ip 和 token

    "accessories": [
    {
      "accessory": "MiAirPurifier",
      "name": "Air Purifier",
      "ip": "ADDRESS_OF_THE_AIR_PURIFIER",
      "token": "TOKEN",
      "showTemperature": true,
      "showHumidity": true,
      "showAirQuality": true
    }
  ]

###小米wifi插座 






###google home


###hass

 概念

HomeKit：苹果于 2015 年 5 月发布的智能家居平台。
HomeBridge：一个开源程序，用于让 HomeKit 支持一些原生不支持 HomeKit 的设备（如米家家居）。
HomeAssistant：一个第三方的智能家居平台。



### References:
1. [小米网关接入Homekit | El Psy Congroo](http://blog.yongbin.me/2017/03/14/homebridge/)
2. [Homebridge + Mac 智能家居指南一：介绍及安装篇](https://zhuanlan.zhihu.com/p/26484470)
3. [gyp WARN EACCES user "root" does not have permission to access the dev dir "/root/.node-gyp/4.2.2" · Issue #405 · nfarina/homebridge](https://github.com/nfarina/homebridge/issues/405)
4. [xcode-select: error: tool 'xcodebuild' requires Xcode, but active developer directory '/Library/Developer/CommandLineTools' is a command line tools instance · Issue #569 · nodejs/node-gyp](https://github.com/nodejs/node-gyp/issues/569)
5. [一分钟教你搞懂，Yeelight联动Google Home这件事！ Yeelight](https://www.yeelight.com/zh_CN/blog/62)
6. [智能家居场景之一：配合 Google Home 来控制 Yeelight 灯泡 - Wei Xia's Blog](http://weixia.info/2018/01/02/yeelight-with-google-home/)
7. [Homebridge插件连接小米空气净化器 | ≮硬件技巧≯ - 驱动天空论坛 - Powered by PHPWind](http://bbs.drvsky.com/read.php?tid=13645)
8. [Cannot find module '../build/Release/dns_sd_bindings' · Issue #905 · nfarina/homebridge](https://github.com/nfarina/homebridge/issues/905)
9. [Homekit + Siri 控制小米插座 ：基于 HomeBridge 与 homebridge-miio | 玩点什么『智能硬件社区』](https://www.wandianshenme.com/play/siri-iphone-homekit-control-xiaomi-devices-by-homebridge-miio/)
