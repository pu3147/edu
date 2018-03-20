try:
    f = open('./info.txt','r',encoding='utf-8')
    #txt = f.read()
    #print(txt)
    for strTmp in f.readlines():
        print(strTmp)
finally:
    if f:
        f.close()


try:
    f = open('./info.txt','r',encoding='utf-8')
    f2 = open('./info_bak.txt','w+')
    for strInfo in f.readlines():
        size = f2.write(strInfo)
        print("Write:",size)
finally:
    if f:
        f.close()
    if f2:
        f2.close()

value = ('www.runoob.com', 14)
s = str(value)

try:
    file = open("./python.log",'w+')
    file.write("ssssssssssssssssssss")
    info = str(value)
    print("strInfo:",info)
    file.write(info)
finally:
    if file:
            file.close()


obj = (123,1231321)
obj = str(obj)
print(obj)


#pickle
print('*'*30,'pickle','*'*30)
import pickle
dumpInfoLis = None
dumpFile = input("send FileName:")
dumpFile = dumpFile + '.dump'
while True:
    if None == dumpInfoLis :
        dumpInfoLis = [];
    dumpInfo = input(str(len(dumpInfoLis)+1)+"send FileName:")
    if '#' == dumpInfo:
        break
    dumpInfoLis.append(dumpInfo)

print(dumpFile)
print("Write to Fil:",dumpFile)


dumpObj = open(dumpFile,'wb')

pickle.dump(dumpInfoLis, dumpObj, 2)
dumpObj.close()

dumpInObje = open(dumpFile,'rb')
dumpInfoLis2 = pickle.load(dumpInObje)
print(id(dumpInfoLis))
print(id(dumpInfoLis2))

print(dumpInfoLis)
print(dumpInfoLis2)