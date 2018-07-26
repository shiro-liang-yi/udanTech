/**
1.git commit -a  <=> git add . ; git commit 
	但是无法管理新增文件和新增文件夹
2.git diff 只在add之前使用有效；如果已经git add了，那么此命令输出为空
3.git diff --cached这个命令只在git add之后git commit之前有效
4.git status这个命令在git commit之前有效，表示都有哪些文件发生了改动
5.git log可以查看项目开发到现在的所有的开发日志
	git log -p这个命令会输出非常详细的日志内容，这个命令很重要，记牢
6.开启一个分支dev，如果在分支上开发成功则合并到主分支，否则放弃该分支dev
	//①先查看当前的所有分支
	git branch
	//②创建一个dev
	git branch dev
	//③切换到该分支
	git checkout dev //git checkout -b dev
	//切换到主分支上，才能合并其它分支
	git checkout master
	git merge dev
	//删除分支
	git branch -d dev
	//如果分支失败，使用-D来抛弃并删除分支
	git branch -D dev
7.远程ssh登录，只给出一个主机地址的话，我们一般通过ssh协议来远程登录操作
8.git config --global http.postBuffer 1024 //ps 参数多于一位的，一般都是 --
9.git config --global core.edit gvim
10.git log -p --author="" hello.scala //显示详细、作者、对特定文件hello.scala
11.git log --online master..some-feature
12.etc/profile
13.yum
14.cat /etc/password 
	cat /etc/password | grep loa
	cat /etc/group
15.useradd jack ; passwd jack	userdel -r jack
16./home   
17.chmod//变更某个目录的权限 -R是一种递归处理
	chmod 将某个目录的权限修改为可读、可写、可执行
	chown 然后这个命令将这个目录交给某个用户，实现了这个用户对这个目录的所有权限
18.sudo systemctl stop firewalld.service
19./etc/sudoers
20.vim ~/.vimrc 
21.elasticsearch
22.樱桃樊素口、杨柳小蛮腰  --两个侍妾
23.val fs = require("fs")
	fs.readFile("input.txt",function(err,data){
		if(err) return console.error(err);
		console.log(data.toString);
	});
	var out = fs.readFileSync("output.txt");
	console.log(out.toString);



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
*/
	