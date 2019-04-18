python 多版本共存

1. 

brew update 

brew install pyenv


2. 然后在 .bash_profile 文件中添加

    if which pyenv > /dev/null; then eval "$(pyenv init -)"; fi


3.     查看能够安装的版本： 

    pyenv install --list 

    只有版本号的为官方的版本，其他的为衍生版。注意自己到需要。 


    安装需要的版本： 

    pyenv install 3.4.3 -v 

    CFLAGS="-I$(brew --prefix openssl)/include" \
    LDFLAGS="-L$(brew --prefix openssl)/lib" \
    pyenv install -v 3.4.3

    完成后更新数据库： 

    pyenv rehash 

  查看系统已安装的版本： 

    pyenv versions 

     pyenv global 3.4.3 

### References:
1. [Mac OS下多版本python共存 - ILKY - ITeye博客](http://lovekaiyuan.iteye.com/blog/2214417)
2. [Common build problems · pyenv/pyenv Wiki](https://github.com/pyenv/pyenv/wiki/Common-build-problems)
3. [Mac OS下多版本python共存 - ILKY - ITeye博客](http://lovekaiyuan.iteye.com/blog/2214417)
4. [利用pyenv，pyenv-virtualenv管理你的python(Mac) - 简书](http://www.jianshu.com/p/70a603058f7b)
5. [在 Mac OS X 10.10 安装 pyenv 的一个小坑 - CSDN博客](http://blog.csdn.net/gzlaiyonghao/article/details/46343913)
6. [Python多版本管理工具pyenv及环境隔离工具virtualenv | blueyi's notes](http://notes.maxwi.com/2017/03/06/python-pyenv-virtualenv/)