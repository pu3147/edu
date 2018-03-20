for tmp in range(1,5):
    index = str(tmp)
    day = input("the day of the")
    if day =='1':
        print(index + " 星期一")
    elif day =='2':
        print(index + " 星期二")
    elif day == '3':
        print(index + " 星期三")
    elif day == '4':
        print(index + " 星期四")
    elif day == '5':
        print(index + " 星期五")
    elif day == '6' or day == '7':
        print(index + " 周末")
    else:
        print(index + " 输入错误")
