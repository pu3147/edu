#!/usr/bin/python3
 
import pymysql
import sys
 
#sys.setdefaultencoding('utf-8')

# 打开数据库连接
db = pymysql.connect("127.0.0.1","pu3147","1qaz@WSX","demo",charset='utf8')
 
# 使用 cursor() 方法创建一个游标对象 cursor
cursor = db.cursor()
 
# 使用 execute()  方法执行 SQL 查询 
cursor.execute("SELECT VERSION()")
 
# 使用 fetchone() 方法获取单条数据.
data = cursor.fetchone()
 
print ("Database version : %s " % data)
 
# 关闭数据库连接
db.close()



db = pymysql.connect("127.0.0.1","pu3147","1qaz@WSX","demo",charset='utf8' )
cursor = db.cursor()
cursor.execute("select * from t_mem_member limit 10")

resultLit = cursor.fetchall()

for row in resultLit:
	value1 = row[0]
	value2 = row[1]
	value3 = row[2]
	value4 = row[3]
	value5 = row[4]
	print(value1)
	print(value2)
	print(value3)
	print(value4)
	print(value5)
	print(row)
print(resultLit)	
	#print("value1=%s,value2=%s,value3=%s,value4=%s,value5=%s")

db.close()