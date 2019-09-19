#!/usr/bin/env python3
from selenium import webdriver
import time
driver = webdriver.Chrome()     # 创建Chrome对象.
driver.implicitly_wait(10) #默认的等待时间

 

# 操作这个对象.
driver.get('http://bg.cwxx.cn/schoolcloud-oauthserver/login') 

driver.find_element_by_id("userName").send_keys("19162289")
driver.find_element_by_name("password").send_keys("abc12345")

driver.find_element_by_id("a_login").click();


driver.get('http://bg.cwxx.cn/newelective/#/JoinElective')

driver.find_element_by_link_text("选课报名").click();

#选修课报名
trObjList = driver.find_elements_by_xpath("//span[text()='科学探索4']/../../..")

trObject= trObjList[0]

print(object.text)
trObjList.find_elements_by_xpath("/child")

#19162243
#abc12345

#
'''

 scopedSlots: t._u([{
                            key: "default",
                            fn: function(e) {
                                return [1 == e.row.studentCourseStatus ? s("span", {
                                    staticClass: "course-label check-show btn-list-item",
                                    attrs: {
                                        disabled: t.canCommit
                                    },
                                    on: {
                                        click: function(s) {
                                            t.applyCourse(e.row.id)
                                        }
                                    }
                                }, [t._v("申请选修")]) : t._e(), t._v(" "), 3 == e.row.studentCourseStatus ? s("span", {
                                    staticClass: "cou


'''