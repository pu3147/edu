#!/usr/bin/python
from urllib import request
import re
import logging
import thread
import time


logging.basicConfig(level=logging.DEBUG,#控制台打印的日志级别
                    filename='new.log',
                    filemode='a',##模式，有w和a，w就是写模式，每次都会重新写日志，覆盖之前的日志
                    #a是追加模式，默认如果不写的话，就是追加模式
                    format=
                    '%(asctime)s - %(pathname)s[line:%(lineno)d] - %(levelname)s: %(message)s'
                    #日志格式
                    )

headers = {
    'User-Agent': 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)',
    'Host': 'httpbin.org'
}

#获取总数
def getTogalSzie():
	url='http://chem.ckcest.cn/channel/details/chanpin-youji?order=score&desc=true&size=10&page=1'
	req=request.Request(url=url,headers=headers)
	rep=request.urlopen(req)
	resBody = rep.read().decode('utf‐8')

	total = re.search('<a>共 .* 条记录</a>',resBody).group(0)
	print(total)
	total = total[5:-7]
	print(total)
	return int(total)


#也没信息
def getDetailInfo(detailUrl):

	print(detailUrl)
	logging.debug(detailUrl)

	req=request.Request(url=detailUrl,headers=headers)
	rep=request.urlopen(req)
	resBody = rep.read().decode('utf‐8')
	resBody = resBody.replace("\n","")
	resBody = resBody.replace("\t","")
	resBody = resBody.replace("\\","")
	#logging.debug(resBody)
	#print(resBody)

	productInfo = re.search("<dl.*</dl>",resBody,re.I).group(0)

	"""
	    <dt>
            产品编号
        </dt>
        <dd>
            C02091515
        </dd>

        <dt>
            英文名称
        </dt>
        <dd>
            3-Hydroxy-4-methylbenzoic acid
        </dd>



        <dt>
            分子式
        </dt>
        <dd>
            C8H8O3
        </dd>

        <dt>
            用途
        </dt>
        <dd>
            用作有机合成中间体，用于制药等
        </dd>
    """
	# logging.debug(productInfo)



	splitInfo = re.split("<dl class=\"dl-horizontal\">|</dl>|<dd>|</dd>|<dt>|</dt>", productInfo)

	logInfo=""
	for tmp in splitInfo:
		tmp = tmp.strip()
		if len(tmp) >0:
			logInfo=logInfo + "," + tmp

	if len(logInfo) >0:
		logging.debug("productInfo:"+logInfo)



#分页信息
def getPageInfo(pageUrl):
	print(pageUrl)
	req=request.Request(url=pageUrl,headers=headers)
	rep=request.urlopen(req)
	resBody = rep.read().decode('utf‐8')
	#print(resBody)

	urlList = re.findall("/article/details/.*\" class=\"article-title",resBody)
	#print(urlList)
	
	for detailUrl in urlList:
		detailUrl = "http://chem.ckcest.cn/" + detailUrl[1:-22]
		getDetailInfo(detailUrl)


pageId=0
pageSize=100
totalPage = getTogalSzie() / pageSize
while pageId < totalPage:
	pageId = pageId+1
	url='http://chem.ckcest.cn/channel/details/chanpin-youji?order=score&desc=true&size='+str(pageSize)+'&page=' + str(pageId)
	getPageInfo(url)
