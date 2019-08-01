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

### 版本：why-session-failed
* 问题：当用户登录后，用户无须再次登录就可执行相关的操作，如通过`/about`页面查看自己的信息。为此：
  * 当用户登录成功后，后端应该把用户登录成功的信息保存在`session`中，并把`session`的`id`返回给前端。`session`的中文名叫**会话**
  * 登录后的用户在后面的请求中，可以将这个`session`的`id`同时发送给后端，后端由此可知该用户是否已经登录。
  * 对于一些操作，必须要检查用户是否已经登录（权限）。如果没有登录，应该拒绝操作（403）。
  * 因此，如果前端在发送请求时，没有携带`session`的`id`，那么服务器将无法得到`session`对象，从而无法得到用户已经登录的信息。
  * 因此，在这个版本中，尽管已经登录，每次显示`/about`时，浏览器的Console窗口总是显示403。
* 此版本加入了 `vue-router` 为每个不同的组件配置了不同的地址
   * 原来的`App.vue`的内容移到了`Login.vue`组件中
   * 新增的`About.vue`组件对应的地址是`/about'
   * `Loging.vue` 组件对应的地址为 `/login`
   * 当输入默认地址时，会跳转到 `/login` 地址
   * 为配合`/about`页面，后端添加`/about`接口。该接口通过session获取用户是否已经登录，如果没有，返回403，如果已经登录，返回用户信息
