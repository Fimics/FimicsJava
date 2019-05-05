## git应用开发详解 
[toc]

--张龙，讲解清晰，以后再关注其他内容
--gitbook比较好用
Linux 没有结果就是最好的结果
--画图工具 paintbrush
teamCity ,YouTrack


### 1.ZSH 环境准备

1. iTerm2 + oh my zsh +agnoster 打造最强Mac终端[环境配置]( https://blog.csdn.net/huihut/article/details/61418136)
2. .zshrc 环境变量配置
```bash
source $ZSH/oh-my-zsh.sh

# User configuration

# export MANPATH="/usr/local/man:$MANPATH"
# 如果使用oh-my-zsh,就不用使用bash_profile文件设置环境变量了，可以直接在.zshrc下
# 设置
# 系统环境变量
export PATH="/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
```

### 2.vim
1. 尽量少使用鼠标，运程ssh 鼠标是不起作用的
2. man rm 
3. Homebrew... insall  brew install tree
4. vim set number显示行号
5. vim dd 直接按两次d 删除当前行 | :2,4d
6. echo hello.txt >|>>hello1.txt 文件重定向 写入到文件中
7.  mac下 crtl+a 光标跳到行首，crtl+e 光标跳到行尾

### 3.入门指引

1. 直接记录快照，而非差异比较
2. 几乎所有的操作都在本地执行
3. 时刻保持数据完整性
4. 多数操作仅添加数据
5. 文件的三种状态
    ![3e8fddf830a66fe07a2d80a9d135a8bb.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p660)
    ![0821996fa91f9043bc3a6f8673a84884.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p661)
6. 本地版本库与服务器版本库关系
   ![4f265d49bcf7ba325bd303b9c495578d.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p662)
   
   
### 4.仓库初始化 init ,clone

1. git init 所甩的信息都放在.git目录下
2. git clone 'url' mygit| mygit 为修改后的项目目录


### 5.文件添加 add 

1. git add 把已修改的文件添加到暂存区
2. git reset HEAD a.txt 从cache区移除
3. git commit -am "message" = git add . +git commit -m "message"
4. git checkout -- hello.txt 用3时先用2 把所有的修改丢掉，使用要小心
5. git add 的三作用
    1. 把未跟踪的文件纳入到跟踪列表中
    2. 把已跟踪的文件纳入缓存区
    3. 解决冲突(标记为已解决)

### 6.文件提交 commit

1. git commit 修改的文件全部提交，如果没有注释会终止提交,把暂存区的文件提交到版本库中
2. git commit -m ""
3. git cm = git commit -m 
4. git commit --amend -m 把上次提交的message 改成这次提交的message,其实两次提交 是同一次提交

### 7.文件删除 git rm | rm


1. git rm 
    1. git rm a.txt
    2. 删除了一个文件，把被删除的文件纳入到暂存区，想恢复文件需要进行两个动作
    3. git reset HEAD a.txt 把待删除的文件从暂存区恢复到工作区
    4. git checkout -- a.txt 把工作区的修改丢弃掉
2. rm  
    1. rm -rf（递归的删除目录下的文件）
    2. rm a.txt
    3. 被删除的文件没有纳入到暂存区，如想纳入暂存区调用 git add .
    
### 8. status
 1. git status = git s
 
 
### 9.git log
1. crtl+f crtl+b
2. q exit
3. git log -n 最近的n条log
4. git log --pretty=oneline 以一行显示
5. git log --graph 图形化显示
6. git log --graph --abbrev-commit
7. git log --graph --pretty=oneline --abberv-commit
8. git reflog 查看操作日志 任何一个操作都能拿到


### 10.账号配置（user.name ,user.email三个地方可以设置账号 local的优先级最高）

1. /etc/gitconfig(所有用户都会用这个账号) 使用的情况比较少
    1. git config --system
2. ~/.gitconifg(很常用，针对特定用户)
    1. git config --global user.name "Your Name"
    2. git config --global user.email "your email"
3. 针对特定项目  在项目目录下的.git/config中
    1. git config --local
4. 查看地当前项目的用户名
    1. cd .git -->cat config
5. 修改用户
    1. git commit --amend --reset-author
6. git config help 
    1. git help config
    2. git config -- help
    3. man git config
7. 查看信息
    1. git config -l
    2. git config user.name
    3. git config user.email


### 11.重命名与目录

1. mv |git mv 重命名
2. rmdir app 要求app下不能有子目录
3. rm -rf app
4. mkdir app && cd app 创建并进入app目录
5. cd - 回到上一次的目录 ，cd .. 回去上一层目录

### 12.gitgnore

1. .gitgnore
    1. 支持正则表达式与通配符
      ![4c614f779f68fd944251f35ca0d56736.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p663)
    2. .gitignore 放在项目根目录下  
    3. 空目录 git直接忽略掉
    4. /*/test.txt 根目录下，一个子目录下的test.txt（*表示特定的一个目录，** 表示所有的目录）
    5. 注释 #

   

### 13.分支重要操作 

1. 查看分支
    1. git branch 
    2. git branch 最近的一条提交消息
    3. git branch -a 查看所有分支，包括远程分支
    4. git branch -av 列出所以分支，包括最后一次提交的信息
    5. git branch -m feature1 feature 本地分支重命名
    6. 先删掉远程分支--再重命名本地分支->把本地分支推送到远程分支：远程分支重命名
2. 创建分支
    1. git branch new_branch
    2. git checkout -b new_branch 创建并切换分支
    3. git branch new 63f8ae0b 以某个提交点为基础创建分支
3. 切换分支 
    1. git checkout new_branch 
    2. git checkout - 切换到以前的分支上
4. 删除分支 | 不能删除所处在的分支
    1. git branch -d new_branch (没有文件改动) 
    2. git branch -D new_branch  没合并的分支使用  
5. 分支合并
    1. git merge dev 把dev分支合并到当前分支
    2. 快进合并(Fast forward) master有3个提交，dev有4个提交 ，调用git merge dev 时，master直接由第三个提交指向了第四个提交，没有任何冲突
        1. 如果可能，合并分支时Git会使用fast-forward模式
        2. 在这种模式下，删除分支时会丢掉分支信息
        3. git merge --no-ff dev合并时加上--no-ff参数会禁用fast-forward,这这样会多出一个commit id
        4. 查看log git log --graph 图片化的形式显示
    3. 冲突全并，手到解决，然后add 然后commit
6. 分支的本质是什么？
   ![f58b1ff91a67761ceb0bbda9611f613e.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p664)
   
7. HEAD 指向的是当前的分支 ，Master 指向的是提交
![365922ca0a7e564e0607a4188cf9957d.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p665)



### 14.版本回退

1. 回退到上一版本
    1. git reset --hard HEAD^ 回退一个版本 ^^^几个符号回退几个提交
    2. git reset HEAD a.txt 将之前添加到暂存区的内容从暂存区移除到工作区
    3. git reset --hard HEAD~3 回退三个提交
    4. git reset --hard commit_id 又向reset, 从第三个提交回到第四个提交
2. x

### 15.checkout与stash

1. checkout
    1. git checkout -- a.txt 丢弃掉相对于暂存区中最后一次添加的文件内容所做的变更
    2. git checkout 9e7f3（游离状态的点） 回到某个提交点， git checkout master 回到master提交点
    3. n
2. stash
    1. git stash | git stash save "git stash save" 切换分支时把没有commit的工作临时保存起来，
    2. git stash list 列出临时保存的记录
    3. git stash pop | 恢复文件状态 同时把临时保存的记录删改掉
    4. git stash apply | 恢复文件 但不删除记录

### 16.标签

1. git tag v1.0.1 创建一个轻量级标签（它是一个指针）
2. git tag -a v1.0.2 -m "release version"(它是一个对象)
3. git tag -d tag_name 删除标签
4. git tag |git show v1.0 查看标签
5. git tag -l 'v*' 标签查找
6. git push origin v1.0 |git push origin v1.0 v2.0|git push origin --tags(把本地未推送的标签全部推送上去)把tag 推送到远程 
7. git pull -->git tag -->git show v1.0
8. git push origin(空格):refs/tags/v1.0 |git push origin --delete tag v5.0 删除远程标签
9. git fetch origin tag v7.0 拉取远程标签

### 17.blame

1. git blame 查看文件的修改内容

### 18.diff

1. diff -u a.txt b.txt mac自带命令 -对应第一个文件 +对应第二个文件
2. git diff 工作区与暂存区的差别
3. git diff commitid  比较工作区与commitid的区别
4. git diff HEAD 比较工作区与最新的提交
5. git diff --cached  比较的是最新的提交与暂存区之间的差别

### 19.远程与github

1. push 推送
    1. git remote add origin https://github.com/lpjhblpj/FimicsGit.git |origin -->远程仓库的别名
    2. git push -u origin master |-u表示本地master与远程master做关联
    3. git remote show |git remote show origin 显示远程仓库
    4. git push mapping simple
        1. push 1.0 | git config --global push.default simple
        2. push 2.0
    5. x
2. git pull （push=fetch+merge） 拉取，同时会执行合并merge
3. git pull 会把远程分支的所有改变拉回本地

### 20.branch分支模型

1. gitflow
    1. 只是一种建议与参考，比较复杂，
2. 基于分支的开发
    1. master 生产发布分支
    2. dev  会频繁变化的分支，开发人员之间协作开发
    3. test 分支，测试与产品人员使用的分支，变化不是特别频繁的分支
    4. feature  功能开发
    5. release 分支
    6. hotfix(bugfix) 分支(生产系统中出现了紧急bug,用于紧急修复的分支，直接从master上拉出分支修复)
    

### 21.git远程协作模型

1. git push 发生了什么？
![d4a1b8a167ba549e6b63fc4a96e8be59.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p666)

    1. 开始 master 与 orgin/master 想到指向对方， 当master 修改文件并提交后，master 指向新提交 e789dad
    2. 当调用 git push时 git会把master最新提交的数据同步到远程库，同时 orgin/master也会指向最新提交 e789dad origin/master是不能修改的 由git维护
https://www.jianshu.com/p/97f33b7fac80?utm_source=oschina-app

1. git config --global alias.br branch
2. git config --global alias.unstage 'reset HEAD' 两个单词用引号引起来
3. git config --global alias.ui '!gitk' |gitk是外部命令 用!表示
3. cat ~/.gitconfig 别名文件
4. https://github.com/robbyrussell/oh-my-zsh/wiki/Cheatsheet|https://www.jianshu.com/p/97f33b7fac80?utm_source=oschina-app|/Users/lipengju/.oh-my-zsh/plugins/git| oh-my-zsh 别名 
 

### 22.refspe（引用规范）

1. refspec(引用规范 表示本地分支与远程分支的对应关系)
2. A分支创建dev分支并推送到远程
    1. `git checkout -b dev |git branch dev |git checkout dev`
    2. git push --set-upstream origin dev |git push -u origin test
    3. git push --set-upstream origin dev（本地分支）:dev2(远程分支)
3. 从远程分支拉取dev分支
    1. git checkout -b dev  origin/dev 可以给分支起名| git checkout --track origin/test 和远程分支名字一样
4. 删除远程分支
    1. git push|pull 的完整写法: git push|pull origin src:dest
    2. git push origin （空格）:test
    3. git push origin --delete test
    4. 现在远程与两个用户分别有三个分支(master,dev ,test) A->同时删除远程与本地的test分支，此时B(当前在dev 分支) 调用 git pull 会发生 but no such ref was fetched ,修复方法
        1. git branch -m dev test |重命名
        2. git remote prune origin |prune 裁剪掉 git br -av 变得干净
        3. vim .git/config
    5. 在缺省情况下，refspec会被git remote add 命令所自动生成，git会获取远程上refs/heads下的所有引用，并把他们写到本地的refs/remote/origin目录下，如果远程上有一个master分支，就可以在本地通过以下几种方式访问他们的历史记录
        1. git log origin/master
        2. git log remotes/origin/master
        3. git log refs/remotes/origin/master
    6. git fetch origin master:refs/remotes/origin/loaclmaster 把远程master分支拉取到本地remotes/origin/mymaster 如果没有分支会创建

### 23.HEAD标记

1. HEAD文件是一个指向你当前所在分支的引用标识符,该文件内部并不包含SHA-a值，而是指向另外一个引用的指针
2. refs/heads/dev HEAD 指向dev分支
3. 当执行git commit命令时。git会创建一个commit对象，并且把这个commit对象的parent指针设置为HEAD所指向的引用的SHA-a值，
4. 我们对于HEAD修改的任何操作，都会被git reflog记录下来 ，凡是commit 都会涉及到HEAD变化，强烈不建议手到修改HEAD文件来修改分支
5. 实际上，我们可以通过git底层命令symbolic-ref来实现对HEAD文件内容的修改 git symbolic-ref HEAD(读取)|git symbolic-ref HEAD refs/heads/dev （写入）

### 24.远程分支底层剖析

1. .git/config
```bash
[core]
        repositoryformatversion = 0
        filemode = true
        bare = false
        logallrefupdates = true
        ignorecase = true
        precomposeunicode = true
[remote "origin"]
        url = https://lpjhblpj@github.com/lpjhblpj/FimicsGit.git
        fetch = +refs/heads/*:refs/remotes/origin/*
        /**
        * fetch操作会获取 远程refs/heads/*下所有的内容 并写到本地 refs/remotes/origin/*
        /
[branch "master"]
        remote = origin
        merge = refs/heads/master
[user]
        name = git2
        email = lpjhblpj@git2.com
[branch "dev"]
        remote = origin
        merge = refs/heads/dev
```

### 25.Git gc

1. git gc 主要是做一些文件压缩，对分散的文件合到一起
2. git gc 调用之后把压缩内容放到.git/packed-refs下，同时对对象进行压缩
3. git commit每次提交的对象都保存到 .git/objects下

### 26.裸库与submodule

1. Git裸库
    1. git裸库，没有工作区的库，主要是远程库，用来文件交换与合并 ，起到中介作用
    2. git init --bare 创建裸库
2. submodule
    1. 为啥使用submodule ?开发中的项目，依赖一个单独的项目(chat聊天) 这时该如何做？
    2. 把聊天库打成一个jar包，放在nexus中，通过maven ,gradle引用,如果chat项目改动频繁，每天就得多次上传到nexus上，太麻烦
    3. 直接手动拷代码，这样会丢失提交记录
    4. submodule原理
    5. git submodule add https://lpjhblpj@github.com/lpjhblpj/FimicsGitSub.git sub ,添加submodule 把远程submodule的代码clone到 sub(也可以是多级目录)目录下，但这个目录不能提前存在
    6. cd sub | git pull 进入sub目录 git pull 获取变化
    7. git submodule foreach git pull |在当前目录下不用进入子目录 ，更新所有依赖的子目录
    8. 项目clone 默认不会clone子项目 ，需要手支clone 
        1. git submodule init|在父目录下执行 sub 初始化
        2. git submodule update --recursive|递归更新 1，2是一组
        3. git submodule update --init
        4. git submodule update 更新
        5. git clone https://lpjhblpj@github.com/lpjhblpj/FimicsGit.git FimicsGit2 --rursive |把父目录子目录一块clone下来
        6. 删除submodule  ？

### 22.subtree(不是git内置的命令)

1. git submodule 配置文件过多删除太麻烦，存在双向修改不方便的问题而且父子工程都可以修改子工程的内容
2.添加subtree 
    1. git remote add subtree-origin 
    https://lpjhblpj@github.com/lpjhblpj/FimicsGitSubTree.git 
    2. git subtree add --prefix =subtree(放在本地目录，可以是多级目录) 
       git subtree add --prefix subtree
       git subtree add -P subtree
    subtree-origin master --squash（合并参数(如dev要合并到master会把dev上的提交记录合并到master上，父子项目必须同时使用--squash 不然冲突比较多)，git merge也可以使用这个命令）
3. subtree 更新 git subtree pull --prefix =subtree subtree-origin master --squash
4. subtree 提交 git subtree push --prefix=subtree subtree-origin master

### 27.cherry-pick

1. git cherry-pick 3a23393 主要应用在本地分支（把dev 上的c1,c2 两个提交应用到 master上,切换到master上操作）
2. 可以用reset ,checkout 从dev上 新分出一个分支，然后把dev删除，再以checkout的点创建一个分支

### 28.rebase原理深度剖析

1. rebase(变基，衍合) 功能类似于merge 那么二者差别是什么？ merege不会修改提交历史，rebase会修改提交历史
2. merge 原理
![4260be7eabfc084220e24fee12c7435e.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p667)

3. rebase 原理(把一个分支的修改应用到另一个分支上)
![cba5c18c6b4f5e38fab9dbb36015e184.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p668)
![981d8015f43ae0830557701e4c89f120.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p669)
![5398417896b27491e30127f200e29932.png](evernotecid://A6C15C60-B0FE-4087-82CE-12650CC824BD/appyinxiangcom/13667750/ENResource/p673)



4. 不要在与其他人共识的分支上去做rebase操作，不要在master上执行rebase
5. git checkout test -->git rebase dev,把dev合并到test上, git 会把多出的几个提交保存成补丁，应用到dev上
 
