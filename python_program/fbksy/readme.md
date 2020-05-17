#创建第一个项目
django-admin startproject fbsky

#目录说明
<ul>
<li>fbksy   项目容器</li>
<li>manager.py命令行工具，可让你以各种方式与该 Django 项目进行交互</li>
<li>fbsky/__init__.py: 一个空文件，告诉 Python 该目录是一个 Python 包</li>
<li>fbsky/settings.py: 该 Django 项目的设置/配置。</li>
<li>fbsky/urls.py: 该 Django 项目的 URL 声明; 一份由 Django 驱动的网站"目录"。</li>
<li>fbsky/wsgi.py: 一个 WSGI 兼容的 Web 服务器的入口，以便运行你的项目。</li>
</ul>
# 启动
python3 manage.py runserver 0.0.0.0:8000
#Paht
from django.urls import path

#安装数据库API
pip install mysqlclient