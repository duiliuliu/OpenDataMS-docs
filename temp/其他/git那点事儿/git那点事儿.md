![git](../image/git流.jpg)

我们应该每天都在用 git，常用的命令也就那几个：

## 初始化 git init

让我们创建一个项目目录，然后进入该目录

    $ mkdir git-demo-project
    $ cd git-demo-project

接着 `git init` 初始化 git 仓库

    $ git init


以下命令作用差不多：

    # 在当前目录新建一个Git代码库
    $ git init
    # 新建一个目录，将其初始化为Git代码库
    $ git init [project-name]
    # 下载一个项目和它的整个代码历史
    $ git clone [url]

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

## 配置

Git的设置文件为.gitconfig，它可以在用户主目录下（全局配置），也可以在项目目录下（项目配置）

配置主要是用来存储用户信息

     显示当前的Git配置
    $ git config --list
    # 编辑Git配置文件
    $ git config -e [--global]
    # 设置提交代码时的用户信息
    $ git config [--global] user.name "[name]"
    $ git config [--global] user.email "[email address]"

## 保存对象

创建好 git 本地仓库后，我们可以写文件然后进行保存

    $ touch README.md
    $ echo 这是我的git练习仓库 > README.md

Git 提供了 git add 命令来保存已更改的对象。

    $ git add --all

也可以指定单个文件进行保存

    $ git add README.md

作用类似的命令

    # 添加指定文件到暂存区
    $ git add [file1] [file2] ...
    # 添加指定目录到暂存区，包括子目录
    $ git add [dir]
    # 添加当前目录的所有文件到暂存区
    $ git add .
    # 添加每个变化前，都会要求确认
    # 对于同一个文件的多处变化，可以实现分次提交
    $ git add -p
    # 删除工作区文件，并且将这次删除放入暂存区
    $ git rm [file1] [file2] ...
    # 停止追踪指定文件，但该文件会保留在工作区
    $ git rm --cached [file]
    # 改名文件，并且将这个改名放入暂存区
    $ git mv [file-original] [file-renamed]

而 git add 命令的实质是由两部分构成的：

- 保存对象
  
    接下来让我们创建一个新的空文件test.txt。

        $ touch test.txt

    然后把这个文件添加到Git代码库中，这一步将创建test.txt现有内容的一个副本。

        $ git hash-object -w test.txt

        e69de29bb2d1d6434b8b29ae775ad8c2e48c5391

    在上述代码中，git hash-object命令将test.txt现有的内容压缩成二进制文件，并保存到Git中。该压缩文件叫做Git对象，保存在.git/objects目录中。

    我们可以通过这个命令根据对象的文件名获取当前内容，并计算成SHA1 哈希（长度为40的字符串）。让我们看看下列新生成的Git对象文件。

        $ ls -R .git/objects

        .git/objects/e6:
        9de29bb2d1d6434b8b29ae775ad8c2e48c5391

    如上述代码所示，.git/objects目录下又多出了一个子目录，而且这个子目录名是上述哈希值的前两个字符。在这个子目录下有一个文件，文件名是上述哈希值中其余的38个字符。

    让我们再来看看文件内容。

        $ cat .git/objects/e6/9de29bb2d1d6434b8b29ae775ad8c2e48c5391

    上述代码输出的文件内容是一些二进制字符。你可能会问既然test.txt是空文件，又怎么会有这些内容呢？这是因为该二进制对象中还存储了一些元数据。

    如果你想看看该文件原始的文本内容，那么应该使用git cat-file。

        $ git cat-file -p e69de29bb2d1d6434b8b29ae775ad8c2e48c5391

    因为原文件为空，所以上述命令什么都没有显示。现在我们往test.txt文件中写点东西。

        $ echo 'hello world' > test.txt

    这个文件的内容已经改变了，所以你需要再次把它保存为Git对象。

        $ git hash-object -w test.txt

        3b18e512dba79e4c8300dd08aeb37f8e728b8dad

    如上述代码所示，test.txt的哈希值已经随着文件内容的改变而发生了变化。同时还生成了新文件
    git/objects/3b/18e512dba79e4c8300dd08aeb37f8e728b8dad。现在你可以看到这个文件的内容了。

        $ git cat-file -p 3b18e512dba79e4c8300dd08aeb37f8e728b8dad

        hello world
- 更新索引
- 
    当文件保存成二进制对象以后，你需要告诉Git哪个文件发生了变化。Git会在一个名叫“索引”（或阶段）的区域记录所有发生了变化的文件。然后等到所有的变更都结束后，将索引中的这些文件一起写入正式的版本历史记录中。

        $ git update-index --add --cacheinfo 100644 
        3b18e512dba79e4c8300dd08aeb37f8e728b8dad test.txt

    上述命令记录了文件名test.txt、二进制对象名（哈希值）以及索引中文件的访问权限。

    git ls-files命令可以显示索引中当前的内容。

        $ git ls-files --stage

        100644 3b18e512dba79e4c8300dd08aeb37f8e728b8dad 0   test.txt

    上述代码显示索引中只有一个test.txt文件，还显示了该文件的二进制对象名和访问该文件的权限。如果你知道该二进制对象名，就可以查看.git/objects子目录中该文件的内容。

    git status命令可以输出更多可读的结果。

        $ git status

        Changes to submit：
            The new file：   test.txt

    上述代码显示索引中只有一个新文件test.txt，该文件正在等候写入版本的历史记录中。

- git add 命令
  
    针对每个文件执行上述两个步骤非常繁琐。所以Git提供了git add命令来简化这些操作。

        $ git add --all

    上述命令相当于针对当前项目中所有发生了变化的文件执行上述两个步骤


## 提交

提交的命令：

    # 提交暂存区到仓库区
    $ git commit -m [message]
    # 提交暂存区的指定文件到仓库区
    $ git commit [file1] [file2] ... -m [message]
    # 提交工作区自上次commit之后的变化，直接到仓库区
    $ git commit -a
    # 提交时显示所有diff信息
    $ git commit -v
    # 使用一次新的commit，替代上一次提交
    # 如果代码没有任何新变化，则用来改写上一次commit的提交信息
    $ git commit --amend -m [message]
    # 重做上一次commit，并包括指定文件的新变化
    $ git commit --amend [file1] [file2] ...

提交的实质：

- 提交
  
  索引保存发生了变化的文件信息。等到修改完成，所有这些信息都会被写入版本的历史记录中，这相当于生成一个当前项目的快照。

    项目的历史记录由不同时间点的项目快照组成。Git可以将项目恢复成任何一个快照。在Git中“快照”有一个专门的术语，即“提交”（commit）。所以生成快照也可以称之为完成提交。

    下列所有“快照”的引用指的都是提交。

- 完成提交
  
    首先，我们需要设置好用户名和邮件地址。在你保存快照的时候，Git需要记录是谁执行的提交。

        $ git config user.name "username" 
        $ git config user.email "Email address"

    接下来，保存现有的目录结构。在本文的前面我们讨论了保存对象只会保存一个文件，并不会记录文件之间的目录结构。

    git write-tree命令可以根据当前目录结构生成一个Git对象。

        $ git write-tree

        c3b8bb102afeca86037d5b5dd89ceeb0090eae9d

    在上述代码中，目录结构保存成了二进制对象，而对象的名字是哈希值。它也保存在.git/objects目录中。

    让我们来看看该文件的内容。

        $ git cat-file -p c3b8bb102afeca86037d5b5dd89ceeb0090eae9d

        100644 blob 3b18e512dba79e4c8300dd08aeb37f8e728b8dad    test.txt

    可以看到，当前目录中只有一个文件test.txt。

    这个所谓的快照就是保存当前的目录结构，以及每个文件相对应的二进制对象。之前的操作已经保存了文件结构，所以现在你需要把这个目录结构和一些元数据一起写入版本的历史记录中。

    git commit-tree可以将目录树对象写入到版本的历史记录中。

        $ echo "first commit" | git commit-tree c3b8bb102afeca86037d5b5dd89ceeb0090eae9d

        c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa

    在上述代码中，在提交时你需要提供提交的描述，而且你可以通过echo "first commit"提供提交描述。git commit-tree命令会根据元数据以及目录树生成一个Git对象。现在，让我们来看看该对象的内容。

        $ git cat-file -p c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa

        tree c3b8bb102afeca86037d5b5dd89ceeb0090eae9d
        author jam  1538889134 +0800
        committer jam  1538889134 +0800

        first commit

    在上述代码中，第一行输出是对应于该快照的目录树对象，而第二行和第三行是有关作者和提交者的信息，最后一行内容是提交的描述。

    通过git log命令我们还可以查看某个快照的信息。

        $ git log --stat c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa

        commit c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa
        Author: jam 
        Date:   Sun Oct 7 13:12:14 2018 +0800

            first commit

        test.txt | 1 +
        1 file changed, 1 insertion(+)

- git commit 命令

    Git提供了git commit来简化上述提交操作。在保存到索引后，你只需要执行git commit命令，就可以同时提交目录结构和描述，并生成快照。

        $ git commit -m "first commit"

    另外，还有两个命令也非常实用。

    通过git checkout命令，我们可以切换到某个快照。

        $ git checkout c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa

    通过git show命令，我们可以显示某个快照的所有代码变更。

        $ git show c9053865e9dff393fd2f7a92a18f9bd7f2caa7fa

## 分支

与分支相关的命令：

    # 列出所有本地分支
    $ git branch
    # 列出所有远程分支
    $ git branch -r
    # 列出所有本地分支和远程分支
    $ git branch -a
    # 新建一个分支，但依然停留在当前分支
    $ git branch [branch-name]
    # 新建一个分支，并切换到该分支
    $ git checkout -b [branch]
    # 新建一个分支，指向指定commit
    $ git branch [branch] [commit]
    # 新建一个分支，与指定的远程分支建立追踪关系
    $ git branch --track [branch] [remote-branch]
    # 切换到指定分支，并更新工作区
    $ git checkout [branch-name]
    # 切换到上一个分支
    $ git checkout -
    # 建立追踪关系，在现有分支与指定的远程分支之间
    $ git branch --set-upstream [branch] [remote-branch]
    # 合并指定分支到当前分支
    $ git merge [branch]
    # 选择一个commit，合并进当前分支
    $ git cherry-pick [commit]
    # 删除分支
    $ git branch -d [branch-name]
    # 删除远程分支
    $ git push origin --delete [branch-name]
    $ git branch -dr [remote/branch]

## 远程同步

相关命令：

    # 下载远程仓库的所有变动
    $ git fetch [remote]
    # 显示所有远程仓库
    $ git remote -v
    # 显示某个远程仓库的信息
    $ git remote show [remote]
    # 增加一个新的远程仓库，并命名
    $ git remote add [shortname] [url]
    # 取回远程仓库的变化，并与本地分支合并
    $ git pull [remote] [branch]
    # 上传本地指定分支到远程仓库
    $ git push [remote] [branch]
    # 强行推送当前分支到远程仓库，即使有冲突
    $ git push [remote] --force
    # 推送所有分支到远程仓库
    $ git push [remote] --all