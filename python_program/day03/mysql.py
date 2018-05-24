#!/usr/bin/python3
import pymysql
db = pymysql.connect("127.0.0.1","pu3147","1qaz@WSX","pu3147",charset='UTF8')

cur = db.cursor();
cur.execute("select member_id,member_name from t_mem_member order by member_id limit 5");
# 使用 fetchone() 方法获取一条数据
memberList = cur.fetchmany(100)
print(memberList)
for result in memberList:
	memberId = result[0]
	memberName = result[1]
#	print(memberId,memberName)
# 关闭数据库连接

#另外一个查询
cur.execute("select member_id,member_name from t_mem_member order by member_id limit 2");
data = cur.fetchone()
print("data>>>>>",data)
db.close()