#!/usr/bin/python
import _thread
import time
import os

def svnUpdate():
	os.popen("svn cleanup",'r',1)
	svnlog = os.popen("svn update",'r',1).read()
	return svnlog
	
def checkApp(svnLog):
	file = open("deploy.txt",'r')
	appList = []
	for app in file.readLines():
		if snvlog.find(app):
			#更新了需要操作
			appList.append(app)
			updateMvn(app)
	return appList

def updateMvn(app):
	batStr = 'updateMvn.bat ' + app
	os.popen(batStr,'r',1).read()

def chekcChemChina():
	svnLog = svnUpdate();
	appList =  checkApp(svnLog)
	for app_tmp in appList:
		updateMvn(app_tmp)

def bang(threadName):
	print(threadName,"count Time")
	count = 0;
	while True:
		
		print('%s Runing at %s'%(threadName,time.ctime(time.time())))
		#延迟1小时
		time.sleep(60*60)
		chekcChemChina()

	print("Bang")

try:
	_thread.start_new_thread(bang,('定时检查SVN版本信息',))
except e:
	print("线程失败！")
print("设置完毕")
