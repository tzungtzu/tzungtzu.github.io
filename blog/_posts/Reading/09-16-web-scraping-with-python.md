python 网络数据采集


urllib python 标准库，包含了从网络请求数据，处理cookies，甚至改变请求头和用户代理这些源数据的函数。

urlopen 用来打开病毒去一个从网络获取的远程对象。


    soup.select("div._4rbun [src^=https://]")
    soup.findAll("div",{"class":"_e3il2"})


利用 HTTP 从网络服务获取信息有四种方式：
* GET
* POST
* PUT
* DELETE

import csv csvFile = open("../files/test.csv", 'w+') try :

writer = csv.writer(csvFile) writer.writerow(('number', 'number plus 2', 'number times 2')) for i in range(10):

writer.writerow( (i, i+2, i*2)) finally :

csvFile.close()
