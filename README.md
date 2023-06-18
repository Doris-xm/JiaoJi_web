# README

### 前端router逻辑

<App/>定义了登录、登出、主页的router

==》跳转至BasicView，检验用户权限（未登录页面和user一致）

==》跳至HomeView（用户界面，管理员是AdminHomeView），HomeView中定义了用户所有界面的route逻辑，根据菜单跳转



TODO：

- [x] 注册功能
- [x] 报名限制
- [x] 界面美化
- [x] 软件测试
- [ ] websocket时事评论
- [x] 百度地图接入
- [x] Jaccount接口
- [x] 推荐算法
- [ ] 数据库清理



---

2023.6.17 12：10

\+ com.example.jaoji_app_back.algorithm.Recommend：推荐算法

\+ com.example.jiaoji_app_back.constant.ActivityClass：常数定义

+++ 在UserService一套中加了getAll方法

---

17：52

修改了SignUpDaoImp和Repository关于朋友圈发布的函数

修改了前端Moment所有，发布的时候可以更新，按时间排序

增加了注册，以及用户名检验

5:37

Jaccout完全实现，新用户自动注册，默认密码为Jaccout用户名

注册用户完全实现，实现了实时检验用户名重复

登录界面修改完成，+游客模式登录

**TODO：Jaccout登录没有封装，登陆界面链接未实现**

6:35

单元测试controller类