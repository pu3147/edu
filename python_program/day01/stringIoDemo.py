from io import StringIO
from io import BytesIO

f = StringIO()
f.write('Hello String IO')

print(f.getvalue())


bFile = BytesIO()
#print(type())
bFile.write('hello Worle'.encode())
print(bFile.getvalue())
print(type(bFile.getvalue()))

#bObj = bytes

