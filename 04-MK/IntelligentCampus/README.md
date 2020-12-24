# 智慧校园

> 本项目旨在开发一款专门为常州工学院在校大学生设计的一个综合服务平台，包含了教务信息、校园信息、校园商城、校园论坛等模块，极大的方便了常州工学院在校学子的一个日常生活。

> 智慧校园开发组
> 组长：郭寅之 核心成员：丁路遥 陆春健 陆帅虎 马唯 罗刘方舟

## 项目分工

### 后端

郭寅之 丁路遥

### 前端

陆春健 陆帅虎 马唯 罗刘方舟

## 项目技术要点

### 后端

+ 数据库
  + c3p0连接池技术
+ ajax数据请求
+ 爬虫技术
+ Redis数据缓存技术
+ 数据库分页查询
+ 数据库自增主键重新排序
+ 接口测试工具 Postman
+ RESTful接口

### 前端

+ 小程序开发技术
+ layui框架

### 团队协作开发

+ svn项目管理

## 项目演示





## 项目中的一些问题QA

### 数据库自增主键重新排序

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

### c3p0连接池报错，显示`too many connections`

解决方法：重启IDEA项目即可

### Ajax传值后台请求`request`为null

决绝方法：将前端ajax中的data区域改为

```
data{
    "username":$("#username").val(),
}
```
即可

## 捐赠



## 参考

