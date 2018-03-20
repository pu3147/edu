print("Hello World!")
name = 'pu3147'
age = 100
print("Hello World %s %d"%(name,age))

name = input("get your name:")
for tmp in name:
    print(tmp)
print(type(name))

age = input("get your age")
age = int(age)
print("the age is %d"%age)
#我是一个注释
'''
这是注释1
注释2
注释3
'''

def helloFunction(age=345):
    print("your send age is %d"%age)
    return "sfsfs " * 3
helloFunction(123)
#函数的默认值
helloFunction()

returnValue = helloFunction()
print("returnValue:%s"%returnValue)
