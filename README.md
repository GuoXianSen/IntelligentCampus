# 智慧校园

> 本项目旨在开发一款专门为常州工学院在校大学生设计的一个综合服务平台，包含了教务信息、校园信息、校园商城、校园论坛等模块，极大的方便了常州工学院在校学子的一个日常生活。

> 智慧校园开发组
> 组长：郭寅之 核心成员：丁路遥 陆春健 陆帅虎 马唯 罗刘方舟

## 项目分工

### 后端

郭寅之 丁路遥

### 前端

陆春健 陆帅虎 马唯 罗刘方舟

## 项目模块

### 用户管理

对系统的用户进行管理

### 商城管理

微信小程序商城的后台，可以对小程序端商城的物品进行管理，可以进行修改价格，添加商品等操作

### 健康码管理

绿码：代表一切正常

黄码：代表正实施7天内隔离

红码：代表正实施14天隔离

### 教务信息管理

通过Python从教务系统爬取数据，利用Flask框架制作接口，前端通过ajax向http://localhost:5000发送请求，获得课程表和学生成绩，最终将返回的json数据展示在前台。

+ 课表查询
+ 成绩查询

### 校园资讯管理

+ 从学校官网首页爬取最新的新闻展示在小程序首页。

## 项目技术要点

### 后端

+ 数据库
  + c3p0连接池技术
  + 数据库分页查询
  + 数据库并发问题解决
  + 数据库自增主键重新排序
+ ajax数据请求
+ 爬虫技术
+ Flask制作接口
+ Redis数据缓存技术
+ 接口测试工具 Postman
+ RESTful接口

### 前端

+ 小程序开发技术
+ layui框架

### 团队协作开发

+ svn项目管理

## 项目演示

### 后端登录界面

![QQ截图20201228232508](https://gitee.com/clay_guo/pic-bed/raw/master/img/QQ%E6%88%AA%E5%9B%BE20201228232508.png)

### 后端注册界面

![QQ截图20201228232617](https://gitee.com/clay_guo/pic-bed/raw/master/img/QQ%E6%88%AA%E5%9B%BE20201228232617.png)

### 用户管理页面

![img-1](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-1.png)

### 用户信息编辑页面

![img-2](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-2.png)

### 添加用户页面

![img-3](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-3.png)

### 商品管理页面

![img-6](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-6.png)

### 添加商品页面

![img-8](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-8.png)

### 编辑商品页面

![img-7](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-7.png)

### 登录-小程序端

![img-4](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-4.png)

### 注册-小程序端

![img-5](https://gitee.com/clay_guo/pic-bed/raw/master/img/img-5.png)





### 校园资讯-小程序端

> 小程序的首页是一个轮播图，显示近期的热点新闻，图片也是可以点击进去查看详情的。

<center class="half">
    <img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-12.png" width="350"/><img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-13.png" width="350"/>/>
</center>



### 校园商城-小程序端

> 商城小程序可以进行搜索、按类别查询、上滑加载更多（分页查询）等，点击商品即可查看商品的详情，其中商品的标题、价格、已购数量等信息均是存储在数据库后台的

<center class="half">    <img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-9.png" width="25%"/><img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-14.png" width="25%"/><img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-10.png" width="25%"/><img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/img-11.png" width="25%"/> </center>



## 项目中的一些问题QA

### 1.数据库自增主键重新排序

Mysql数据库表的自增主键ID号经过一段时间的添加与删除之后乱了，需要重新排列。

原理：删除原有的自增ID，重新建立新的自增ID。

```sql
-- 1，删除原有主键：

ALTER  TABLE  `table_name` DROP `id`;
-- 2，添加新主键字段：

ALTER  TABLE  `table_name` ADD `id` MEDIUMINT( 8 ) NOT NULL  FIRST;
-- 3，设置新主键：

ALTER  TABLE  `table_name` MODIFY COLUMN  `id` MEDIUMINT( 8 ) NOT NULL  AUTO_INCREMENT,ADD PRIMARY  KEY(id);
```

### 2.c3p0连接池报错，显示`too many connections`

解决方法：重启IDEA项目即可，或者见[4](#4.数据库修改最大连接数量)

### 3.控制台中文乱码

![image-20201221085701816](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201221085701816.png)

![image-20201221085748075](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201221085748075.png)

可能存在的两个问题

+ tomcat 设置编码错误
+ java项目设置编码为GBK，因为windows电脑的编码为GBK

修改方法

![image-20201221085851494](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201221085851494.png)

### 4.数据库修改最大连接数量

方法一：通过命令

可以通过 `set GLOBAL max_connections=100; `命令将最大连接数设置为100，此方法是即时生效的，不需要重启mysql服务。如下图所示：

 show variables like "max_connections";

方法二：修改配置文件

找到MySQL配置文件`my.ini`，推荐使用listery进行快速搜索

![image-20201222153225456](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201222153225456.png)

修改文件的最大连接数量为1000

![image-20201222153146156](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201222153146156.png)

### 5.Python中JSON转换中文乱码

代码如下

```python
jsondata = json.dumps(jsondata)

print(jsondata)
```

显示如下

![image-20201223210217506](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201223210217506.png)

更正方法：

```python
jsondata = json.dumps(jsondata, ensure_ascii=False)
```

![image-20201223210337504](https://gitee.com/clay_guo/pic-bed/raw/master/img/image-20201223210337504.png)

## 捐赠

本项目为开源免费的，但你也可以请作者喝一杯咖啡来加快工作速度。

<center class="half">
    <img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/IMG_4924(20201222-131847).JPG" alt="IMG_4924(20201222-131847)" style="zoom:25%;" /><img src="https://gitee.com/clay_guo/pic-bed/raw/master/img/IMG_4923(20201222-131836).JPG" alt="IMG_4923(20201222-131836)" style="zoom: 33%;" />
<center/>



## 参考

`[1]` Layui官方文档  *https://www.layui.com/*

`[2]` Github  *https://www.github.com/*

`[3]` 零基础玩转微信小程序 *https://www.bilibili.com/video/BV1nE41117BQ?p=51*

`[4]` IDEA控制台乱码终极解决办法 *https://blog.csdn.net/weixin_40367591/article/details/106965919*

`[5]` 总结MySQL修改最大连接数的两个方式 *https://www.cnblogs.com/justuntil/p/8809249.html*

