HomeBridge



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


### References:
1. [Homebridge插件连接小米空气净化器 | ≮硬件技巧≯ - 驱动天空论坛 - Powered by PHPWind](http://bbs.drvsky.com/read.php?tid=13645)
2. [Cannot find module '../build/Release/dns_sd_bindings' · Issue #905 · nfarina/homebridge](https://github.com/nfarina/homebridge/issues/905)
3. [Homekit + Siri 控制小米插座 ：基于 HomeBridge 与 homebridge-miio | 玩点什么『智能硬件社区』](https://www.wandianshenme.com/play/siri-iphone-homekit-control-xiaomi-devices-by-homebridge-miio/)