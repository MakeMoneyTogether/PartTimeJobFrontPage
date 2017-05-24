# PartTimeJobFrontPage
一个拥有完整的MVC的前端页面，不包含数据库，吐出的为死数据
-----
下面为接口规范

# 接口规范
## 用户界面接口
### 根据城市请求区县
- url:	`util/city/districts/${cityCode}`
- 输入参数:  ${cityCode}城市代码
- 输出参数:  城市下行政区的代码和名称的列表，例如`[{dcode:001,dname:'江宁区'},{dcode:002,dname:'鼓楼区'}]`

### 获取所有兼职类型
- url:	`util/city/labels`
- 输入参数:	无
- 输出参数:	所有的兼职类型名称和代码，例如`[{lcode:001,lname:'发单'},{lcode:002,lname:'销售'}]`

### 分页查询兼职列表（带筛选功能）
- url:	`jzurl/pages/select/${offset}/${length}`
- 输入参数:	${offset}起始下标，${length}查询长度
- 表单域1:		dises行政区代码（all或者行政区代码逗号隔开，例如`001,002,003`或`all`）
- 表单域2:		labels类型代码（all或者类型代码逗号隔开，例如`001,002,003`或`all`）
- 表单域3:		dates时间代码(all或者是一段时间,例如`all`或者`2017-05-01`)
- 表单域4:		city城市代码(城市的邮编例如`100000`代表北京)
- 输出参数:	兼职列表

### 分页查询兼职列表（带模糊匹配）
- url:	`jzurl/pages/search/${offset}/${length}`
- 输入参数:	${offset}起始下标，${length}查询长度
- 表单域1:		keys关键字（就是用于模糊匹配的关键字）
- 表单域4:		city城市代码(城市的邮编例如`100000`代表北京)
- 输出参数:	兼职列表

### 兼职详情(初步实现，后台功能已测试, 后面兼职相关的，url我写的是job/不是pages/，你可以调整一下)
- url:	`jzurl/pages/item/${jid}`
- 输入参数:	${jid}兼职id
- 输出参数:	兼职详情的json数据

### 用户参与的兼职列表(初步实现，后台功能已测试)
- url:	`jzurl/pages/sitem/{uid}/{statuId}`
- 输入参数: ${uid}用户Id,${statuId}状态ID(0:已报名;1:已录用;2:已到岗;3:已结算)
- 输出参数: 兼职列表

### 验证用户登录(初步实现，后台功能已测试，后面用户相关的，url我写的是user/不是pages/，你可以调整一下)
- url:	`uurl/pages/login`
- 表单域1:	phone手机号码
- 表单域2:	pwd登录密码
- 输出参数:	一个数字(0:验证成功;1:用户名和密码出错)

### 获取用户信息(初步实现，后台功能已测试)
- url:	`uurl/pages/me`
- 表单域1:	phone手机号码
- 表单域2:	pwd登录密码
- 输出参数:	用户基本信息

### 发送手机验证码
- url:	`util/sendCode`
- 表单域:	phone手机号码
- 输出参数:	一个数字(0:已发送;1:手机号已被注册;2验证码发送失败)

### 用户注册(初步实现，后台功能已测试)
- url:	`uurl/register`
- 表单域2:	pwd用户密码
- 表单域3:	phone手机号码
- 表单域4:	code手机验证码
- 表单域5:	invitation邀请码
- 输出参数:	0表示注册成功，1表示验证码出错

### 修改密码(初步实现，后台功能已测试)
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

### 获取用户与兼职之间的关系(初步实现，未测试)
- url:	`jzurl/pages/u2j/{phone}/{jid}"`
- 输入参数:	${phone}手机号码,${jid}兼职id
- 输出参数: 一个数字(0-4)分别代表无关系、已报名、已录取、已到岗、已结算

### 用户报名兼职
- url:	`jzurl/pages/apply/{phone}/{jid}`
- 输入参数:	${phone}手机号码,${jid}兼职id
- 输出参数: json格式的数据{code:${codeId},applied:${applied},all:${all}} (code表示功能码，具体查询功能码表，applied表示已经报名的人数，all表示需求总人数)

### 获取用户邀请的人和状态
- url:	`uurl/invitation`
- 表单域1:	phone手机号码
- 输出参数:	json格式的数据[{name:${name},statu:${statu}}](name表示被邀请人的姓名，statu表示是否完成了一次兼职0表示没有，1表示完成了，参考功能码表)

### 用户提现
- url:	`uurl/cash`
- 表单域1:	phone手机号码
- 表单域2:	rmb提现金额
- 输出参数:	1个数字(0,1,2分别表示，成功，余额不足，提现失败)

### 获取用户提现交易单
- url:	`uurl/schedule`
- 表单域1:	phone手机号码
- 输出参数:	json格式的数据[{rmb:${name},statu:${statu}}](rmb表示提现金额，statu表示提现状态，0表示以提现成功，1表示正在处理中，2表示平台拒绝，参考功能码表)

### 获取手机兼职列表(初步实现，后台功能已测试)
- url:	`jzurl/pages/net/{offset}/{length}`
- 输入参数:	${offset}起始下标，${length}查询长度
- 输出参数: 手机兼职列表

### 获取手机兼职详情(初步实现，后台功能已测试)
- url:	`jzurl/pages/netitem/{jid}`
- 输入参数:	${jid}兼职id
- 输出参数: 手机兼职详情

## 商户界面接口
### 商户登出
- url:	`uurl/pages/logout`
- 表单域1:	phone手机号码
- 输出参数:	一个数字(0:验证成功;1:退出难道还有错？)

### 获取商户主页信息
- url:	`merurl/json/me`
- 表单域1:	phone商家手机
- 表单域2:	password商家密码
- 输出参数:	商家基本信息{商家名称,可用资产,冻结资产}

### 修改商户信息
- url:	`merurl/json/update`
- 表单域1:	mname商户名称
- 表单域2:	citycode商户所在城市代码（可为空）
- 表单域3:	local商户详细地址
- 表单域4:	connectname联系人姓名
- 表单域5:	phone联系人电话
- 表单域6:	code验证码
- 输出参数:	一个数字，0表示成功。

### 获取商户所有信息
- url:	`merurl/json/merme`
- 表单域1:	phone商家手机
- 输出参数:	商家所有信息{mname:商户名称,local:详细地址,connectname:法人姓名,phone:法人电话}

### 获取商户提现列表
- url:	`merurl/json/schedule`
- 表单域1:	phone商家手机
- 输出参数:	商户提现信息列表单个元素格式如下{"id":交易流水号,"money":提现金额,"statu":提现状态}，提现状态0为等待，1为拒绝，2为成功

### 发布兼职
- url:	`merkurl/json/issue`
- 表单域:	兼职的必要信息
- 输出参数:	一个整型（如果成功则是兼职的id，如果余额不足为1）

### 获取商户兼职列表
- url:	`merurl/json/jzs`
- 表单域1:	phone商家手机
- 输出参数:	兼职list（不用区分兼职状态，在前端判断状态）
