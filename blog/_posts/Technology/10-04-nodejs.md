nodejs

JS， 基本的操作——为 web 页面添加交互


node.js， 服务端的 javascript

Node.js 事实上就是另外一种上下文，它允许在后端（脱离浏览器环境）运行 JavaScript 代码。

让 JS 享受到底层操作系统的异步接口，从而实现将其带到服务器端的目的。这就是Node.js的设计思路。


console.log 会输出到控制台。事实上，console.log 做了这样的事情：它在指定的字符串后加上 \n （换行）字符，并将其写到stdout 流中。
 

基于事件驱动的回调



###sublime 运行 node

1. 首先安装nodejs
2. 添加 build system
3. 在sublime text中依次打开Tools -> Build System -> New Build System... 粘贴以下代码后保存(如Node.sublime-build), 然后把Build System设成Automatic

        {
            "cmd": ["node", "--use-strict", "--harmony", "$file"],
            "selector": "source.js"
        }