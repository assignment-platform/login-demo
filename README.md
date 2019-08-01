### 项目说明
* 使用vue + spring boot 开发的简单的登录应用

### 版本：basic-login
* 最简单的登录
* 前端使用最基本的表单
* 前端使用Axios库对后端进行访问
* 后端建有`User`类，包含`id`和`password`两个属性。
* 后端`UserController`类处理的登录的函数为`login`
* 登录接口对应的HTTP请求API为`http://localhost/user/login`
* 后端没有使用数据库，所有的数据放在`UserController`的`users`数组中
* 运行：

  * 前端：`yarn serve` 或 `npm run serve`，后端：在IDEA中运行`Application.java`
  * 打开浏览器的Console窗口
  * 在表单中输入'001'和'000'，点登录Console会显示登录成功
  * 输入别的信息，点登录会返回401错误信息
