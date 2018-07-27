##### 标识符

​	关于标识符，我建议按照标准或者规范来，虽然像汉字命名经过试验是可以的，但是却不是可行的

​	可以以下划线开头

##### 注释

​	注释有两种（只有）：跨行的 ''''''或""""

​						单行的 #

##### 关于Python编码

​	刚开始学习python时，一定会碰到这个问题，就是注释中一旦有汉字程序就报错

​	其实这个问题是由于Python的默认编码格式是acii，它是不支持汉字的

​	因此解决这个问题有两个办法：

```
#!usr/bin/python
#-*-coding:utf-8-*-
```

​	或者这种方式（这种代码少）

```
#coding=utf-8
```

##### 数据类型

​	每种语言支持那些数据类型一定是最重要最基础的，但是我在此处就不详细说了，大体写一下吧

​	Numbers（数字）、String、List（列表）、Tuple（元组）、Sets（集合）、Dictionaries（字典）

​	Tuple是一种特殊的List，因为它是元素不能修改的List，它的表示是圆括号

```python
>>> a = (1991, 2014, 'physics', 'math') #这是元组Tuple
>>> print(a, type(a), len(a))
(1991, 2014, 'physics', 'math') <class 'tuple'> 4
```

​	List支持不同类型的数据、支持修改、Python中使用最频繁的数据类型

```python
world = 'Python'
print(world[0],world[-1],world[3])#('P', 'n', 'h')
```

​	【我更想写一些自己的心得体会与理解】

##### List

​	为什么我要着重单写一下List呢，笨蛋啦很显然因为它是最重要的嘛（这还用说！）

​	怎么知道它是一个List呢？？？

​		List（列表）是写在方括号之间、用逗号分隔开的就是列表List啦

​	特点

​		列表中的元素的类型可以不相同

​		和字符串一样，列表同样可以被索引和切片，列表被切片后返回一个包含所需元素的新列表

```python
a = [1, 2, 3,'Python',2+4]
print(a) # [1, 2, 3, 'Python', 6]

a[-1] = 'me'
print(a) # [1, 2, 3, 'Python', 'me']

a[2:4] = ['3',5]
print(a) # [1, 2, '3', 5, 'me']
```

##### 字符串

```python
str = 'ilovePython'
print(str[1:5]) # love
print(str[:]) # ilovePython
print(str[2:])# ovePython
print(str[:7])# ilovePy
print(str[-1:6])#
print(str[6:-2])# yth
print(str[6:-5])#
print(str[6:-3])# yt
print(str[6:-4])# y
str[-1]='9'#这是不对的，因为python中的字符串是不能修改值的
```

​	Python中的字符串有两种索引方式，第一种是从左到右，从0开始依次增加、第二种是从右到左，从-1开始依次减少

​	如果想要原样输出某个字符串时，可以在字符串前面添加一个 r 或者 R ，r表示原始字符串

##### Sets(集合)

​	集合（set）是一个无序不重复的集合

​	基本功能是进行成员关系测试和消除重复元素

​	可以使用大括号或者set（）函数创建set集合【注意：创建一个空集合必须使用set()而不是{}，因为{}是用来创建一个空字典】

```python

基本功能是进行成员关系测试和消除重复元素。

可以使用大括号 或者 set()函数创建set集合，注意：创建一个空集合必须用 set() 而不是 { }，因为{ }是用来创建一个空字典。
'''
student = {'Tom', 'Jim', 'Mary', 'Tom', 'Jack', 'Rose'}
print(student) #重复的元素会被自动去掉
print('liang' in student) # False ,是一种成员测试(membership testing)
a = set('abracadabra')
b = set('alacazam')
print(a,b) # (set(['a', 'r', 'b', 'c', 'd']), set(['a', 'c', 'z', 'm', 'l']))
'''a 和 b的差集'''
print(a - b) # set(['r', 'b', 'd'])
'''a 和 b的并集'''
print(a | b) # set(['a', 'c', 'b', 'd', 'm', 'l', 'r', 'z'])
'''a 和 b的交集'''
print(a & b) # set(['a', 'c'])
'''a 和 b中不同时存在的元素'''
print(a ^ b) # set(['b', 'd', 'm', 'l', 'r', 'z'])
c = set()
print(type(c),c) # (<type 'set'>, set([]))
```

##### Dictionaries(字典)

​	dictionaries是Python中另一个非常有用的内置数据类型

​	字典dictionaries是一种映射类型（mapping type），它是一个无序的键：值对集合

​	关键字必须使用不可变类型，也就是说list和包含可变类型的tuple不能做关键字

​	在同一个字典dictionaries，关键字还必须互不相同

​	









