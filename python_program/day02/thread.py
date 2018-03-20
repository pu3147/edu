#!/usr/bin/python
import _thread
import time

def bang(threadName,delay):
	print(threadName,"count Time")
	count = 0;
	while count <=100:
		time.sleep(delay)
		print('%s Runing at %s'%(threadName,time.ctime(time.time())))
		count +=1
	print("Bang")

try:
	_thread.start_new_thread(bang,('延迟5秒',5))
	_thread.start_new_thread(bang,('延迟10秒',10))
except e:
	print("线程失败！")
print("设置完毕")

bang('延迟5秒',5)
