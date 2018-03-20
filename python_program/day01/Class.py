#!/usr/bin/python
class animal:
	def __init__(self):
		print("animal。。。init")
	__age = 0

	def addAge(self):
		self.__age = self.__age+1

	def getAge(self):
		return self.__age

	def run(self):
		print("蠕动的的精华")



class HumMan(animal):
	'''
	人类
	'''
	def __init__(self):
		animal.__init__(self)
		print("HumMan")

	def say(self):
		print("哈哈哈！")

	def run(self):
		print("奔跑")

#判断是否是导入的
if __name__ == '__main__':

	animal1 = animal()
	animal1.addAge();
	print(animal1.getAge())

	animal2 = animal()
	animal2.addAge();
	animal2.addAge();

	print(animal2.getAge())

	print('*'*30,'HumMan','*'*30)

	per1 = HumMan()
	per1.say()
	per1.run()