


让我们从macOS app的启动来开始我们的学习，在app启动时有三个组件需要我们注意：
1.AppDelegate.swift：代码运行的入口， AppDelegate.swift 是一个很重要的文件，负责提供app在整个生命周期中（启动、闲置、进入后台、进入前台、激活、完全退出）与操作系统交互的方法。在运行代码时为你提供来自macOS的通知，例如Handoff请求、命令行参数和推送通知等。
2.Main.storyboard：故事板具有指定的“入口点”，这允许系统在app启动时构建UI，这个入口点如图所示：




你可以很清晰的看出来哪些场景将构建出app的初始UI界面。
3.Info.plist：在一个app中可以有多个storyboard，那么macOS怎么知道用哪一个来构建初始UI呢？我们可以在 Info.plist 文件中向操作系统提供这个信息，如下图：


### References:
1. [Mac应用开发入门](http://www.cocoachina.com/bbs/read.php?tid=151757)
2. [初识Xcode · macOS开发教程](https://zhi-ming-zhang.gitbooks.io/macos/Tutorial-for-Beginner/Intro-to-Xcode.html)
3. [一步一步，开始上手Mac 开发（一） - 简书](http://www.jianshu.com/p/feadeb1ae7ae)
4. [初识Xcode · macOS开发教程](https://zhi-ming-zhang.gitbooks.io/macos/content/Tutorial-for-Beginner/Intro-to-Xcode.html)
5. [[译] 零基础 macOS 应用开发（二） - 程序园](http://www.voidcn.com/article/p-fodjozsv-bnz.html)