#!/usr/bin/python3
import redis

r=  redis.Redis(host='127.0.0.1',port=6379)

print(r)
value = r.get("get")

print(value)