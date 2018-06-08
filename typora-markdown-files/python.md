### python进阶之路

##### 1.hello world

```
print "hello world";
```

##### 2.简单爬数据例子

```
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 31 19:51:25 2017

@author: Administrator
"""

import urllib.request
from bs4 import  BeautifulSoup
import urllib.parse

class Spider(object):

    def __init__(self):
        self.user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.109 Safari/537.36'
        self.headers = {'User-Agent': self.user_agent}   

    def getcode(self,url):
        try:
            request=urllib.request.Request(url,headers=self.headers)
            response=urllib.request.urlopen(request)
            data=response.read()
            soup = BeautifulSoup(data, 'html.parser', from_encoding='utf-8')
            links = soup.find_all('table',class_='fn_cm_table')
            codes0=[]
            str2=[]
            for link in links:
                codes0.append(link.get_text())
            str0=codes0[0].split('\n\n\n')
            for str1 in str0:
                str2.append(str1.split('\n'))
#            从网页中分离出所需数据
            with open("H:\学习资料\机器学习\爬虫\股票爬虫\codes.txt",'a') as fp:
                fp.write(str2[2][2]+"\t"+str2[2][3]+"\n")    
                print(str2[2][2]+"\t"+str2[2][3])
#             由于第一个元素前多一个空格，所以与其他元素分开   
            for i in range(3,len(str2)):
                with open("H:\学习资料\机器学习\爬虫\股票爬虫\codes.txt",'a') as fp:
                    fp.write(str2[i][1]+"\t"+str2[i][2]+"\n")
                    print(str2[i][1]+"\t"+str2[i][2])
#            print(str2)     
        except Exception as e:
            print(e)

if __name__=='__main__':   
    url0="http://quotes.money.163.com/data/caibao/yjgl_ALL.html?reportdate=20170930&sort=publishdate&order=desc&page="  
    for i in range(0,138):
        url=url0+str(i)
        spider=Spider()
        spider.getcode(url)
```

