## 课前回顾

## 本节主讲

### Python 基础

- Python 特点

编译性

- python 约定

  - 编码
    - UtF-8
    - python2 # -_- coding=utf-8 -_-
  - 缩进
  - 引号

        ```

            sql = """
                select ***
                from table
            """


            sql = 'select ** ' +
                ' from table'

            dict{key:value}
            ''

            student={
                'name':wawa",
                'gender':''
            }
        ```

    import re,sys

    import re
    import sys

    i = i + 1

    # 这是注释

    """
    这是注释
    """

    命名规范
     模块 html_parse 小写
     类 驼峰 AnimalFarm
     函数 变量
     常量 MAX_VALUE

- 数据类型

  - number
    - long
    - float
  - String
  - list

    ```
    l = []
    l1 = [1,2,3]
    l = l1
    ```

  - tuple 元组

    ```
        t = ()
        t2 = (1 ,2,3)
    ```

  - dictionary
    d ={
        key1:v1,
        k2:v2
    }


    生成器
    切片

- 语法结构

    逻辑运算符
    与  &&  and  a and b
    或  ||   or  a or b
    非   !   not 

    成员运算符
    contain

    in     1 in l1
    not in

    身份运算符
    is  ==
    ```
        is 比较内存
        == 判断的值
    ```
    is ===
- 变量、函数定义

    i = 1
    i+=1


    def funtion_name(param1=22,param2=3):
        pass

    if x=3:
        pass
    else :
        pass

    range(5) = [0,1,2,3,4]
    xrange(5) = [0,1,2,3,4]

    range(start,end,step)
    range(0,5,1)

    for i in range(5):
        print(i)
    >>> 0 1 2 3 4

    l = [2,4,5]

    for i in l:
        print(i)


    while x=2:
        pass
    else:
        pass

    

### Python 简单爬虫

模拟客户端，请求网页，解析网页，获取数据

pip install package_name

- python 网络库 urllib
    urllib.request 
    urlib.error
    urllib.parse
    urlib.robotparse   robot.txt

    

- Python 网络库 requests
- Python 网页解析库 bs4  beautiful soup -- > selector
- Python 网页解析库 lxml   -- > xpath


网页--> dom 树


### Python 简单实战爬虫

## 划重点

## 课后作业

使用 python 爬取豆瓣上<西红柿首富>

挑战 1：得出<西红柿首富>评论中出现次数最多的前 10 个词语

- 解决方案
- 结果数据

挑战 2：将<西红柿首富>评论中的词语进行词云绘制

- 解决方案
- 结果数据

## 面试题

- Python 中元组与列表有什么区别？
- python is 与 ==
