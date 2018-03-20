#!/usr/bin/python
import sys
print("model!")
print(len(sys.argv))
for i in sys.argv:
	print("sys.argv:",i)

print(sys.path)
for pa in sys.path:
	print("path:",pa)


if __name__ == '__main__':
	print("执行自身!")
else:
	print("被引用")