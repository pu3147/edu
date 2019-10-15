import os
import oss2
import sys
import datetime

changeLog = open('changeFile.log', mode='r')
changFileList = changeLog.readlines()
#OssClient

auth = oss2.Auth('', '')
bucket = oss2.Bucket(auth, 'http://vpc100-oss-cn-beijing.aliyuncs.com', 'uatimg')

print("start Upload UAT OSS\n")
for updateFile in changFileList:
        if updateFile.startswith('src/main/webapp/resources/'):
                updateFile=updateFile.replace('\n','')
                print(updateFile)
                if os.path.exists(updateFile):
                        ossFilePath = 'ec-web/resources/' + updateFile.replace('src/main/webapp/resources/','')
                        print('https://e-.com/'+ossFilePath)
                        bucket.put_object_from_file(ossFilePath, updateFile)
                        print('\n')
changeLog.close()
print("End Upload UAT OSS")