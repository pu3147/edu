#!/usr/bin/python

import sys
def addInfo(n):
	a,b,count = 0,1,0
	while True:
		if(count>n):
			return
		yield a
				
		a,b = b,a+b
		count = count +1
		print('addInfo:%d\t%d,%d'%(count,a,b))
f = addInfo(10)
for item in f:
	print("item:",item)


def showParamer(name,age=10,*other):
	print("*"*50)
	print("name:%s"%(name))
	print("name:%d"%(age))
	print(type(other))
	for tmp in other:
		print(tmp)
	print("*"*50)

showParamer('info',30,123,123)
showParamer('info')

showParamer('info',10,123,123,[1,2,3,4],(22,33,44,55))


max = lambda arg1,arg2:arg1+arg2

print(max(1,2))