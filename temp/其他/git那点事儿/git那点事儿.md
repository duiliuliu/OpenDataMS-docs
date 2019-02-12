![git](../image/git流.jpg)

我们应该每天都在用 git，常用的命令也就那几个：

## 初始化 git init

让我们创建一个项目目录，然后进入该目录

    $ mkdir git-demo-project
    $ cd git-demo-project

接着 `git init` 初始化 git 仓库

    $ git init

git init 主要做的事，那就是在项目的根目录下创建.git 子目录来保存版本信息

    $ ls .git

    branches/
    config
    description
    HEAD
    hooks/
    info/
    objects/
    refs/

上述命令显示了.git 子目录中的内容

## 保存对象

创建好 git 本地仓库后，我们可以写文件然后进行保存

    $ touch README.md
    $ echo 这是我的git练习仓库 > README.md

Git 提供了 git add 命令来保存已更改的对象。

    $ git add --all

也可以指定单个文件进行保存

    $ git add README.md

而 git add 命令的实质是由两部分构成的：

- 保存对象
- 更新索引

## 提交

## 分支

- git commit -m "first commit"
- git push -u origin master
- git pull -u origin master
