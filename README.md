# README

### 前端router逻辑

<App/>定义了登录、登出、主页的router

==》跳转至BasicView，检验用户权限（未登录页面和user一致）

==》跳至HomeView（用户界面，管理员是AdminHomeView），HomeView中定义了用户所有界面的route逻辑，根据菜单跳转



TODO：

- [ ] 注册功能
- [x] 报名限制
- [ ] 界面美化
- [ ] websocket时事评论
- [ ] 百度地图接入
- [ ] Jaccount接口
- [x] 推荐算法
- [ ] 数据库清理



---

2023.6.17 

\+ com.example.jaoji_app_back.algorithm.Recommend：推荐算法

\+ com.example.jiaoji_app_back.constant.ActivityClass：常数定义

+++ 在UserService一套中加了getAll方法

---

17：52

修改了SignUpDaoImp和Repository关于朋友圈发布的函数

修改了前端Moment所有，发布的时候可以更新，按时间排序