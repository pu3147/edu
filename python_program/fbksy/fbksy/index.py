from django.http import HttpResponse
from django.shortcuts import render

def index_bak1(request):
    return HttpResponse("Hello Django!")

def index(request):
    context={}
    context["hello"] = "Hello Django!!"
    context["size"] = 100
    context['stuList'] = ['张三','李四','王五']
    return render(request,"index.html",context)