#!/usr/bin/python
list1 = ['abc','cde','efg']
print(list1)
print(list1[1:2])
id(list1)
list1[2] = 'ghi'
id(list1)

print(list1)
list1.append("adf")
print(list1)
del list1[2]
print(list1)

list1.append("123")
list1.append("456")
list1.append("789")


print('eeee' in list1)

for x in list1:
	print(x,end='______\n')

for index,value in enumerate(list1):
	print("index:%d,value:%s"%(index,value))

list2 = range(1,10);


print(list2)
for valu1,value2 in zip(list1,list2):
	print(valu1,value2)
print(list1[1])
print(list1[2:])
print(list1[-1:0])

print(len(list1))

print("count 123:",list1.count("123"))
print("count eee:",list1.count("eee"))
if list1.count('eee') ==0:
	list1.append('eee')
	list1.insert(0,'eee')
print("count eee:",list1.count("eee"))
print(list1)

baseAry = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
print(baseAry)
print(max(baseAry))
print(max(list1))

print('-'*3,'='*3,'-'*3)
type(list1)
type(baseAry)



tuple2 = tuple(list1)
print(list1)
print(tuple2)

print("==="*50,'dist')
dist1 = {"name":'gaopan','age':31}
print(dist1)
print(dist1['name'])

dist1.clear()
print(dist1)

dist1['class'] = "className"
dist1[(123,123)] = [1231,12313]
dist1[123] = 123
print(dist1)
print(type(dist1))

for item_key in dist1:
	print(type(item_key))
	print(item_key,'---->',dist1[item_key],sep='====')

for item_key,item_value in dist1.items():
	print("key:%s--->value:%s"%(item_key,item_value))



print(dist1.keys())
print(dist1.values())

print("迭代器")
it = iter(dist1)
for item in it:
	print(item,dist1[item],sep='\t\t   ')


print('*'*30,'SET','*'*30)

set1 = set(list1)
print(list1)

print(set1)


print("helo___{1},Wel__{0}".format('a','b'))

value = '123'
print(type(value))
value = int(value)
print(type(value))

def inputInfo():
	while True:
		inputStr = input('Send your Name:')
		list1.append(inputStr)
		if '###' == inputStr:
			return
inputInfo()
print("inputInfo Result:",list1)


print('=='*10,'END','=='*10)
