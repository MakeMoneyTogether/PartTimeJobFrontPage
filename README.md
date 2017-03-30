# PartTimeJobFrontPage
一个拥有完整的MVC的前端页面，不包含数据库，吐出的为死数据
-----
下面为接口规范

# 接口规范
## 用户界面接口
### 根据城市请求区县
- url:  util/city/districts/${cityCode}
- 输入参数:  ${cityCode}城市代码
- 输出参数:  城市下行政区的代码和名称的列表，例如`[{dcode:001,dname:'江宁区'},{dcode:002,dname:'鼓楼区'}]`

### 获取所有兼职类型
- url: util/city/labels
- 输入参数:	无
- 输出参数:	所有的兼职类型名称和代码，例如`[{lcode:001,lname:'发单'},{lcode:002,lname:'销售'}]`