# -*- coding: utf-8 -*-
# author: pengr


import requests
from lxml import html
# import time

# time.sleep(10)


url = "https://movie.douban.com/subject/30331149/comments?status=P"

response = requests.get(url)

htm = html.fromstring(response.text)

xpath_str = '//*[@id="comments"]/div'

res_list = htm.xpath(xpath_str)

user_name_list = htm.xpath('//*[@class="comment-info"]/a/text()')
user_view_list = htm.xpath('//*[@class="comment-info"]/span[2]/@title')
commit_date_list = htm.xpath('//*[@class="comment-info"]/span[3]')
comments_list = htm.xpath('//*[@id="comments"]/div/div/p/span/text()')


# print(len(comments_list))

filename = "comments.txt"

with open(filename,'w',encoding="utf-8") as f:
    headers = ["用户名","用户看法","发表日期","评论文本"]
    f.write("\t".join(headers))
    f.write("\n")
    for i in range(len(user_name_list)-1):
        data = [user_name_list[i],user_view_list[i],commit_date_list[i].text.strip(),comments_list[i]]
        f.write("\t".join(data))
        f.write("\n")


我 是  一个 人

[ wo  shi  yige  ren ]


pip install

# user_name
# user_view
# commit_date
# comments
