# PartTimeJobFrontPage
一个拥有完整的MVC的前端页面，不包含数据库，吐出的为死数据
-----
下面为接口规范

# 接口规范
## 用户界面接口
### 根据城市请求区县
- url:  `util/city/districts/${cityCode}`
- 输入参数:  ${cityCode}城市代码
- 输出参数:  城市下行政区的代码和名称的列表，例如`[{dcode:001,dname:'江宁区'},{dcode:002,dname:'鼓楼区'}]`

### 获取所有兼职类型
- url: `util/city/labels`
- 输入参数:	无
- 输出参数:	所有的兼职类型名称和代码，例如`[{lcode:001,lname:'发单'},{lcode:002,lname:'销售'}]`

### 分页查询兼职列表（带筛选功能）
- url: `jzurl/pages/select/${offset}/${length}`
- 输入参数:	${offset}起始下标，${length}查询长度
- 表单域1:		dises行政区代码（all或者行政区代码逗号隔开，例如`001,002,003`或`all`）
- 表单域2:		labels类型代码（all或者类型代码逗号隔开，例如`001,002,003`或`all`）
- 表单域3:		dates时间代码(all或者是一段时间,例如`all`或者`2017-05-01`)
- 表单域4:		city城市代码(城市的邮编例如`100000`代表北京)
- 输出参数:	兼职列表

### 分页查询兼职列表（带模糊匹配）
- url: `jzurl/pages/search/${offset}/${length}`
- 输入参数:	${offset}起始下标，${length}查询长度
- 表单域1:		keys关键字（就是用于模糊匹配的关键字）
- 表单域4:		city城市代码(城市的邮编例如`100000`代表北京)
- 输出参数:	兼职列表

### 兼职详情
- url: `jzurl/pages/item/${jid}`
- 输入参数:	${jid}兼职id
- 输出参数:	兼职详情的json数据

### 用户参与的兼职列表
- url: `jzurl/pages/sitem/{uid}/{statuId}`
- 输入参数: ${uid}用户Id,${statuId}状态ID(0:已报名;1:已录用;2:已到岗;3:已结算)
- 输出参数: 兼职列表

### 验证用户登录
- url: `uurl/pages/login`
- 表单域1:	phone手机号码
- 表单域2:	password登录密码
- 输出参数:	一个数字(0:验证成功;1:用户名和密码出错)

### 获取用户信息
- url: `uurl/pages/me`
- 表单域1:	phone手机号码
- 表单域2:	password登录密码
- 输出参数:	用户基本信息

### 发送手机验证码
- url: `util/sendCode`
- 表单域:	phone手机号码
- 输出参数:	一个数字(0:已发送;1:手机号已被注册;2验证码发送失败)

### 用户注册
- url:	`uurl/register`
- 表单域2:	pwd用户密码
- 表单域3:	phone手机号码
- 表单域4:	code手机验证码
- 表单域5:	invitation邀请码
- 输出参数:	0表示注册成功，1表示验证码出错

### 修改密码
- url:	`uurl/rpwd`
- 表单域1:	phone手机号码
- 表单域2:	pwd用户密码
- 表单域3:	npwd新密码
- 输出参数:	0表示修改成功

### 编辑简历
- url:	`uurl/editcv`
- 表单域1:	phone手机号码
- 表单域2:	pwd用户密码
- 表单域n:	其他好多
- 输出参数:	0表示修改成功