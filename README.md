

# SSM-TianMao

**ssm电商项目，仿天猫**

整站分为前端和后端两部分。

知识点：Java的基础知识，前端（HTML+CSS+Javascript,JQuery,Ajax,bootstrap),J2EE(tomcat,servlet,Jsp,Filter)

框架（spring  springmvc  mybatis ssm)

<!--more-->

数据库 mysql

IDE:IntelliJ 或eclipse

确保学习的项目可以在本地演示并可以导入IDEA，并启动tomcat

有个大致的概念，然后哪里有问题再去查询学习

没有前后端分离，主要是jsp



# 一 Javaweb以及SSM框架用到的一些原理

**SSM是sping+springMVC+mybatis集成的框架**。

**MVC即model view controller**。

![MVC 设计思想](https://img-blog.csdnimg.cn/20200924120221766.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

## 01 Spring

"spring"的中文意思是“春天”。**Spring makes Java simple**，这是spring官网首页的大标题，意思就是说Spring让Java开发更简单。

实质上它是一个**Java的轻量级框架**，由Rod Johnson创建，**目的**是为了解决企业级应用开发的业务逻辑层和其他各层的**耦合**问题。

轻量级：就是它很小，在电脑中的文件夹只有几M大小。

耦合：模块间是相互关联的

最重要的是它**开源免费**！

"没有对象就new一个"这句话是不是很耳熟。

```java
GirlFriend  g1 =   new GirlFriend();
```

这句话是程序员自己主动敲出来的，但在spring中就不需要了，Spring会帮我们new一个对象。

就好比中午饿了，本来需要自己动手烧菜做饭，但现在可以点外卖，让商家帮我们做。

实际的应用程序由很多组件组成，每个组件负责一部分功能，需要和其他的组件进行协调，共同完成任务。

就好比一家公司，有技术部，市场部，行政部，人力部等等各个部门组成，每个部门有自己的任务，但有需要相互协作，共同完成任务。

### 1-1 Ioc(DI)

**控制反转**    **（Inversion of Control）**

**依赖注入（Dependency Injection）**就是由IOC容器在运行期间，动态地将某种依赖关系注入到对象之中

**依赖注入（DI）**和**控制反转（IOC）**是从不同的角度的描述的同一件事情，指就是**通过引入IOC容器，利用依赖关系注入的方式，实现对象之间的解耦**

### 1-2 AOP

面向切面编程



## 02  SpringMVC原理

![img](https://img-blog.csdnimg.cn/20200924120222125.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```
SpringMVC流程

1、  用户发送请求至前端控制器DispatcherServlet。

2、  DispatcherServlet收到请求调用HandlerMapping处理器映射器。

3、  处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。

4、  DispatcherServlet调用HandlerAdapter处理器适配器。

5、  HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。

6、  Controller执行完成返回ModelAndView。

7、  HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。

8、  DispatcherServlet将ModelAndView传给ViewReslover视图解析器。

9、  ViewReslover解析后返回具体View。

10、DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。

11、 DispatcherServlet响应用户。
```



## 03  Mybatis原理及流程

![img](https://stepimagewm.how2j.cn/4205.png)

1. 应用程序找Mybatis要数据
2. mybatis从数据库中找来数据
   2.1 通过mybatis-config.xml 定位哪个数据库
   2.2 通过Category.xml执行对应的select语句
   2.3 基于Category.xml把返回的数据库记录封装在Category对象中
   2.4 把多个Category对象装在一个Category集合中
3. 返回一个Category集合



![](![img](https://img-blog.csdn.net/20180421203113233)





![img](https://img-blog.csdnimg.cn/20200924120221845.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```
1.通过SqlSessionFactoryBuilder 解析mybatis-config.xml 文件中的 Configuration 创建一个 sqlSessionFactory

2.通过sqlSessionFactory 创建一个SqlSession

3.SqlSession调用一个 quary(查询)Executor执行器，是为了执行sql语句

4. 创建一个新的StatementHandler (参数执行器)

5. 调用ResultSetHandler （结果器返回结果），执行SQl语句,不同的SQl语句返回不同的结果
```

# 二 电商网站SSM项目开发流程笔记

## 1.商业开发的流程

1. **需求分析**（前台和后台）：需要做哪些功能

   前台又分为单纯要展示的那些功能-**需求分析-展示**，以及会提交数据到服务端的哪些功能-**需求分析-交互**。

2. **表结构设计**（围绕着功能需求）

   表与表之间的关系，SQL语句，表和页面功能的一一对应

   <!--more-->

3. **界面原型**（与客户沟通）

   低成本，高效率，需求的一致性，前台原型与后台原型

4. **后台分类管理**

   查询，分页，增删改查

5. **项目重构**

   ssm存在的一些问题，改进，提高效率

6. **后台其他管理**

7. **前台首页**

8. **前台无需登录**

9. **前台需要登录**

10. **总结**



## 2.需求分析

### 2.1 前台展示

**在前端页面上显示数据库中的数据**，如首页，产品页，购物车，分类页面等等。

前端页面如何组织显示，页面布局，css样式设置，Javascript交互等

### 2.2 前台交互

通过POST,GET等http协议，与服务端进行同步或者异步数据交互。 比如购买，购物车，生成订单，登录等等功能。

### 2.3 后台

对支撑整站需要用到的数据，进行管理维护。 比如分类管理，分类属性管理， 产品管理，产品图片管理，用户管理，订单管理等等。



## 3.表结构设计

#### 3.1 表与表的关系



![表关系图](https://img-blog.csdnimg.cn/20200924120221851.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



表与表之间的关系，基本上是3种
**一对一**
**一对多**
**多对一**

正确的分析表与表之间的关系的方法是这样：
**一个**分类对应 **多个** 产品

**一个**产品对应 **一个** 分类

![](https://img-blog.csdnimg.cn/20200924120221835.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

![表一对多](https://img-blog.csdnimg.cn/20200924120221860.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

### 3.2 Mysql数据库

1.**数据库（Database）**是存储和管理数据的仓库。
2.**SQL（结构化查询语言）**

3.MySQL是一个DBMS，DBMS实际上就是一个**数据库管理系统**。一般的中小型网站都选择MySQL作为网站的数据库，因为它可以使用SQL语言进行操作，而且它的速度快，最重要的是它免费。

4.（Linux系统+xfe终端）

安装MySQL安装服务端`sudo apt-get install mysql-server`

安装客户端：sudo apt-get install mysql-client验证是否安装并启动成功：`sudo netstat -tap | grep mysql`
5.打开MySQL启动MySQL服务：sudo service mysql start

登陆 mysql  -u root

6.查看数据库show databases;

7.连接数据库use 数据库名

8.查看表show tables;

9.退出quit或exit

### 3.3建表SQL语句

![](https://img-blog.csdnimg.cn/20200924120221938.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```mysql
DROP DATABASE IF EXISTS tmall_ssm;
CREATE DATABASE tmall_ssm DEFAULT CHARACTER SET utf8;
USE tmall_ssm;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;   #用户表

CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;  #分类表

CREATE TABLE property (
  id int(11) NOT NULL AUTO_INCREMENT,
  cid int(11) DEFAULT NULL,             #本表的外键cid，指向分类表的id字段
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_property_category FOREIGN KEY (cid) REFERENCES category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;   #属性表，有外键约束

CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,      #产品名称
  subTitle varchar(255) DEFAULT NULL,  #小标题
  originalPrice float DEFAULT NULL,    #原始价格
  promotePrice float DEFAULT NULL,     #优惠价格
  stock int(11) DEFAULT NULL,          #库存
  cid int(11) DEFAULT NULL,            #外键cid，指向分类表的id字段
  createDate datetime DEFAULT NULL,    #createDate: 创建日期
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category FOREIGN KEY (cid) REFERENCES category (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8; #产品表

CREATE TABLE propertyvalue (
  id int(11) NOT NULL AUTO_INCREMENT,
  pid int(11) DEFAULT NULL,  #外键pid，指向产品表的id字段
  ptid int(11) DEFAULT NULL, #外键ptid，指向属性表的id字段
  value varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_propertyvalue_property FOREIGN KEY (ptid) REFERENCES property (id),
  CONSTRAINT fk_propertyvalue_product FOREIGN KEY (pid) REFERENCES product (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;  #属性值表

CREATE TABLE productimage (
  id int(11) NOT NULL AUTO_INCREMENT,
  pid int(11) DEFAULT NULL,       #本表的外键pid，指向产品表的id字段
  type varchar(255) DEFAULT NULL, #type表示类型，产品图片分单个图片和详情图片两种
  PRIMARY KEY (id),
  CONSTRAINT fk_productimage_product FOREIGN KEY (pid) REFERENCES product (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  #产品图片表

CREATE TABLE review (
  id int(11) NOT NULL AUTO_INCREMENT,
  content varchar(4000) DEFAULT NULL,
  uid int(11) DEFAULT NULL, #外键uid，指向用户表的id字段
  pid int(11) DEFAULT NULL, #外键pid，指向产品表的id字段
  createDate datetime DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_review_product FOREIGN KEY (pid) REFERENCES product (id),
    CONSTRAINT fk_review_user FOREIGN KEY (uid) REFERENCES user (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8; #评价表

CREATE TABLE order_ (
  id int(11) NOT NULL AUTO_INCREMENT,
  orderCode varchar(255) DEFAULT NULL,  #订单号
  address varchar(255) DEFAULT NULL,    #收货地址
  post varchar(255) DEFAULT NULL,       #邮编
  receiver varchar(255) DEFAULT NULL,   #收货人信息
  mobile varchar(255) DEFAULT NULL,     #手机号码
  userMessage varchar(255) DEFAULT NULL,#用户备注信息
  createDate datetime DEFAULT NULL,     #订单创建日期
  payDate datetime DEFAULT NULL,        #支付日期
  deliveryDate datetime DEFAULT NULL,   #发货日期
  confirmDate datetime DEFAULT NULL,    #确认收货日期
  uid int(11) DEFAULT NULL,             #外键uid，指向用户表id字段
  status varchar(255) DEFAULT NULL,     #订单状态
  PRIMARY KEY (id),
  CONSTRAINT fk_order_user FOREIGN KEY (uid) REFERENCES user (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8; #订单表

CREATE TABLE orderitem (
  id int(11) NOT NULL AUTO_INCREMENT,
  pid int(11) DEFAULT NULL,    #外键pid，指向产品表id字段
  oid int(11) DEFAULT NULL,    #外键oid，指向订单表id字段
  uid int(11) DEFAULT NULL,    #外键uid，指向用户表id字段
  number int(11) DEFAULT NULL, #number字段表示购买数量
  PRIMARY KEY (id),
  CONSTRAINT fk_orderitem_user FOREIGN KEY (uid) REFERENCES user (id),
  CONSTRAINT fk_orderitem_product FOREIGN KEY (pid) REFERENCES product (id),
  CONSTRAINT fk_orderitem_order FOREIGN KEY (oid) REFERENCES order_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8; #订单项表

```



## 4.原型-后端

CRUD维护管理页面

前端需要的数据，都要先通过后台的功能维护在数据库中，才可以拿到。

所以，**先**进行**后台**功能的开发，然**后**再是**前台**功能的开发。

首先使用SSM模式开发出第一个**分类管理模块**。然后分析弊端，对其进行**项目重构**，重构使得框架更加紧凑，后续开发更加便利和高效率。


### 4.1静态资源

#### 4.1.1在**webapp/img/site目录**存放静态图片

#### 4.1.2在webapp/css目录里有3个子目录

- [ ] **back**
  这个目录里有一个**style.css**,这是**后台界面**用到的**样式**

- [ ] **bootstrap**

  存放的是bootstrap的**css样式文**

- [ ] **fore**
  这个目录里**也**有一个**style.css**,这是**前台界面**用到的**样式

#### 4.1.3在**webapp/js**目录里有2个子目录**

- [ ] **bootstrap**

  bootstrap用到的js文件

- [ ] **jquery**

  jquery用到的js文件

#### 4.1.4除了图片资源外，还用到了各种第三方的jar包



### 4.2 JSP包含关系

#### 4.2.1 Servlet

Servlet它是运行在**服务器**上的一个Java小程序，它可以**接收**客户端发送过来的**请求**并**响应**数据给客户端。

Tomcat是一个Web服务器

![Image](https://img-blog.csdnimg.cn/20200924120221845.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

![](https://img-blog.csdnimg.cn/20200924120223353.gif#pic_center)



**如何去实现一个servlet程序呢？**

1,编写一个类去实现servlet接口。

2,实现service方法，处理请求并响应数据。

3,到web.xml中去配置servlet程序的访问地址。



![image-20200812125042627](C:\Users\hk199\Desktop\Java学习总结\SSM电商项目\servlet原理1.png)



![image-20200812125320609](https://img-blog.csdnimg.cn/20200924120222132.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

#### 4.2.2  JSP

**在html中写或运行java代码**，因为JSP被转译成了**Servlet。**

![执行过程](https://img-blog.csdnimg.cn/20200924120221780.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

![页面元素](https://img-blog.csdnimg.cn/20200924120221887.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



**webapp/admin/各种Jsp**



#### 4.2.3 页面跳转

开发web应用时，**页面跳转**会经常遇到。

比如登录成功或是失败后，分别会跳转到不同的页面。

跳转的方式有两种，**服务端跳转**和**客户端跳转**。

首先在web目录下准备两个页面 success.html,fail.html
分别用于显示登录成功 或者登录失败

如果<u>登录成功了</u>，就**服务端跳转**到success.html

如果<u>登录失败了</u>，就**客户端跳转**到fail.html

![首先准备两个页面 success.html fail.html](https://img-blog.csdnimg.cn/20200924120221647.png#pic_center)

##### 01 在**Servlet**中进行服务端跳转的方式

在service(HttpServletRequest request, HttpServletResponse response)方法中

```java
request.getRequestDispatcher("success.html").forward(request, response);
```

服务端跳转后，浏览器的地址依然是/login 路径，并不会变成success.html

![服务端跳转](https://img-blog.csdnimg.cn/20200924120221770.png#pic_center)

##### 02 在Servlet中进行客户端跳转的方式

在service(HttpServletRequest request, HttpServletResponse response)方法中

```java
response.sendRedirect("fail.html");
```

跳转后浏览器地址发生了变化。

![客户端跳转](https://stepimagewm.how2j.cn/1567.png)

![服务端跳转与客户端跳转图示](https://img-blog.csdnimg.cn/20200924120221865.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



##### 03 在**jsp**中进行服务端跳转的方式

```jsp
request.getRequestDispatcher("hello.jsp").forward(request, response);
```

简化：

```jsp
<jsp:forward page="hello.jsp"/>
```



##### 04  在jsp中进行客户端跳转的方式

```jsp
response.sendRedirect("hello.jsp");
```

### 4.3 创建项目

#### 4.3.1新建项目

File-->New Project新建项目

#### 4.3.2选中maven webapp格式

左边选中Maven --> 勾选Create from archetype-->选中 org.apache.maven.archetypes:maven-archetype-webapp--> Next

<!--more-->

![image-20200815081714219](https://img-blog.csdnimg.cn/20200924120221942.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

#### 4.3.3项目参数

![image-20200815081608844](https://img-blog.csdnimg.cn/20200924120221671.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



***GroupId:com.how2java.tmall**(名字随意)

#### 4.3.4   Maven仓库

**Maven** 是专门用于构建和**管理Java项目**的工具。

- 相同的项目结构
- 统一维护jar包  

​       **仓库**是用于存放项目需要的jar包的
​       maven采用**一个仓库，多个项目**的方式，让<u>多个项目共享一个仓库里的相同jar包</u>。

maven 本地仓库（Local repository) 的默认目录是：${user.home}/.m2/repository。

```
C:\Users\hk199\.m2\repository
```

项目所需要的jar包都复制进去。

jar（Java ARchive，Java 归档），**压缩包**，里面有许多class文件。

![image-20200816112809762](https://img-blog.csdnimg.cn/20200924120221875.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

**groupId** 项目包名(从右向左看就是域名/网址）: com.kun.tmall（或com.how2java.tmall,随意）
**artifactId** 项目实际名称:tmall_ssm
**archetypeArtifactId** 项目类型: maven-archetype-webapp

#### 4.3.5 pom.xml

pom.xml 用于维护当前项目都用了哪些jar包

```xml
<!-- xmlns是XML Namespaces的缩写，中文名称是XML命名空间 -->
<!-- xsd（XML Schema Definition)用来定义xml文档结构的。 XML解析器可以根据一个XSD文件的内容来解析另一个XML文件，判断该文件的结构是否和 XSD 文件中定义的一致, XSD文件可以理解为XML文档可以自定义的语法或格式检查器-->

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
 <!--pom版本，一般都是4.0.0 -->  
  <modelVersion>4.0.0</modelVersion>
    
<!--组织结构， 如com.kun.tmall生成的相对路径为：/com/kun/tmall -->  
  <groupId>com.how2java.tmall</groupId>
    
   <!--项目实际名 -->  
  <artifactId>tmall_ssm</artifactId>
    
  <!--项目当前版本，格式为:主版本.次版本.增量版本-限定版本号 -->  
  <version>0.0.1-SNAPSHOT</version>
    
  <!--打包机制，例如jar、war、ear、pom -->  
  <packaging>war</packaging>

  <!--定义在该文件中的常量，常有定义编码的常量-->
  <properties>
    <spring.version>4.1.3.RELEASE</spring.version>
    <pagehelper.version>5.1.2-beta</pagehelper.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.spring.version>1.2.3</mybatis.spring.version>
    <mybatis.version>3.1.1</mybatis.version>
    <junit.version>4.12</junit.version>
    <jstl.version>1.2</jstl.version>
    <jsqlparser.version>1.0</jsqlparser.version>
    <jackson.version>1.2.7</jackson.version>
    <servlet-api.version>3.1.0</servlet-api.version>
    <druid.version>1.0.18</druid.version>
    <log4j.version>1.2.16</log4j.version>
    <commons-logging.version>1.2</commons-logging.version>
    <commons-fileupload.version>1.2.1</commons-fileupload.version>
    <commons-io.version>1.3.2</commons-io.version>
    <commons-lang.version>2.6</commons-lang.version>
    <aopalliance.version>1.0</aopalliance.version>
    <mybatis-generator.version>1.3.5</mybatis-generator.version>
  </properties>

  <dependencies>
<!--使用groupId、artifactId和version确定所依赖的jar等-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>${junit.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>${mybatis.spring.version}</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>${druid.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <!-- JSP相关 -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>${jstl.version}</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>${servlet-api.version}</version>
      <scope>provided</scope>
    </dependency>

    <!-- pageHelper -->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>${pagehelper.version}</version>
    </dependency>

    <!--jsqlparser-->
    <dependency>
      <groupId>com.github.jsqlparser</groupId>
      <artifactId>jsqlparser</artifactId>
      <version>${jsqlparser.version}</version>
    </dependency>
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>${log4j.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>${commons-logging.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>${commons-fileupload.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>${commons-io.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>${commons-lang.version}</version>
    </dependency>

    <dependency>
      <groupId>aopalliance</groupId>
      <artifactId>aopalliance</artifactId>
      <version>${aopalliance.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-core</artifactId>
      <version>${mybatis-generator.version}</version>
    </dependency>

  </dependencies>

  <!--编译配置-->
  <build>
    <!--定义输出的文件名-->
    <finalName>${project.artifactId}</finalName>
    <!--使用已定义的插件-->
    <plugins>
      <!-- 资源文件拷贝插件 -->
      <!--定义插件，使用artifactId和groupId还有版本定义，并使用configuration进行配置-->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-resources-plugin</artifactId>
        <version>2.7</version>
        <configuration>
          <encoding>UTF-8</encoding>
        </configuration>
      </plugin>
      <!-- java编译插件 -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.2</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
          <encoding>UTF-8</encoding>
        </configuration>
      </plugin>
    </plugins>
    <!--定义使用的插件，和dependencyManagement相似，只定义并未引用-->
    <pluginManagement>
      <plugins>
        <!-- 配置Tomcat插件 -->
        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
        </plugin>
      </plugins>
    </pluginManagement>

    <!--定义使用的资源文件-->
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
          <include>**/*.tld</include>
        </includes>
        <filtering>false</filtering>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
    </resources>

  </build>

</project>
```



#### 4.3.6   model，service，mapper， controller各层的作用

![img](https://img-blog.csdnimg.cn/2020092412022211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



##### 01 model层

即**entity层**

**存放实体类**，与数据库中的属性值基本保持一致。



##### 02 service层

**存放业务逻辑处理**，也是一些关于数据库处理的操作，但不是直接和数据库打交道，他有接口还有接口的实现方法，在接口的实现方法中需要导入mapper层。



##### 03 mapper层

即**dao层**，现在用<u>mybatis逆向工程生成的mapper层</u>，其实就是dao层。

mapper层是**直接跟数据库打交道的**，它也是个**接口**，**只有方法名字**，<u>具体实现在mapper.xml文件里，service是供我们使用的方法。</u>

**对数据库进行数据持久化操作**，他的方法语句是直接针对数据库操作的，而service层是针对我们controller，也就是针对我们使用者。**service的impl**是把mapper和service进行整合的文件。

（数据持久化操作就是指，把数据放到持久化的介质中，同时提供增删改查操作，比如数据通过hibernate插入到数据库中。）



##### 04 controller层

**控制器**，**导入service层**，因为service中的方法是我们使用到的，controller通过接收前端传过来的参数进行业务操作，在返回一个指定的路径或者数据表。

在实际开发中的Service层可能被处理为**实体Service层**，而不是接口，业务逻辑直接写在Service（Class，不是Interface）层中，**Controller直接调用Service，Service调用Mapper，Service之间也是可以互相调用。**



#### 4.3.7新建java源代码目录

maven web项目默认是没有java源代码目录的，所以需要手动创建，并设置其为源代码目录
右键main目录-> New->Directory->输入java->右键java->Mark Directory as-> Sources Root
这样就创建了存放java源文件的目录了

![新建java源代码目录](https://img-blog.csdnimg.cn/20200924120222147.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



鼠标左键**选中java**， 然后右键->New->Directory 输入 **com.how2java.tmall.pojo** 创建包

鼠标左键**选中java**，然后右键->New->Directory 输入 **com.how2java.tmall.mapper** 创建包

鼠标左键**选中java**，然后右键->New->Directory 输入 **com.how2java.tmall.controller** 创建包

鼠标左键**选中 java**，然后右键->New->Directory输入 **com.how2java.tmall.service** 创建包

![4.3.7查询](https://img-blog.csdnimg.cn/20200924120221685.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



#### 4.3.8查询  

##### 01 Category类

**实体类，**声明了id和name,以及对应的setter,getter

选中**pojo包**，然后单击右键-->Java Class，创建Category类。

```java
package com.how2java.tmall.pojo;

public class Category {
    private Integer id;
    private String name;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name == null ? null:name.trim();  //trim()方法用于删除字符串的头尾空白符
    }
}
```

##### 02 CategoryMapper接口

选中**mapper包**，然后单击右键-->Java Class（选择第二项Interface)，创建CategoryMapper接口。

![image-20200820114459842](https://img-blog.csdnimg.cn/20200924120221939.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

因为目前只做查询，所以只声明了一个list方法

```java
package com.how2java.tmall.mapper;
import com.how2java.tmall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    public List<Category> list();
}
```



##### 03 CategoryService接口

**服务层service用来编写接口和实现类**

选中**service包**，然后单击右键-->Java Class（选择第二项Interface)，创建CategoryService接口。

```java
package com.how2java.tmall.service;
import com.how2java.tmall.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> list();
}
```



##### 04 CategoryServiceImpl类

是CategoryService接口的实现类

首先点中源目录：java 然后菜单->File->New->Package 输入 **com.how2java.tmall.service.impl** 创建包

```java
package com.how2java.tmall.service.impl;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//注解@Service声明当前类是一个Service业务类  
@Service
public class CategoryServiceImpl implements CategoryService{
    //通过自动装配@Autowired引入CategoryMapper,在list方法中调用CategoryMapper 的list方法
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> list() {
        return categoryMapper.list();
    }
}
```

@Autowired注解是一个用于容器(container)配置的注解。

它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。

自动装配，Spring容器中的bean自动的和需要的bean类组装在一起。

java的注解实现的核心技术是**反射**

**反射机制**指在程序运行过程中，对任意一个类都能**获取其所有属性和方法**，并且对任意一个对象都能调用其任意一个方法。这种动态获取类和对象的信息，以及动态调用对象的方法的功能被称为Java语言的反射机制。

Class对象的由来是将class文件读入内存，并为之创建一个Class对象（类对象）

该Class对象是反射的核心，通过它可以调用类的任意方法。

-  Class.forName
-  类名.class
-  new 类名().getClass()

**类的正常加载过程，反射原理与class对象：**

![img](https://img-blog.csdn.net/20180929094923857?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E3NDUyMzM3MDA=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

Class对象的newInstance()方法来创建Class对象对应类的实例。



##### 05  CategoryController

在**controller包**中新建CategoryController类

```java
package com.how2java.tmall.controller;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//使用org.springframework.web.bind.annotation.RequestMapping注解类型将请求与处理方法一一对应。
/**
 * Controller实现类包含了对用户请求的处理逻辑，是用户请求和业务逻辑之间的“桥梁,负责具体的业务逻辑处理
 * 在Spring MVC中使用扫描机制找到应用中所有基于注解的控制器类
 */

import java.util.List;
//注解@Controller声明当前类是一个控制器
@Controller
//注解@RequestMapping("")表示访问的时候无需额外的地址
@RequestMapping("")
public class CategoryController {
    //注解@Autowired把CategoryServiceImpl自动装配进了CategoryService 接口
    @Autowired
    CategoryService categoryService;
    //注解@RequestMapping("admin_category_list") 映射admin_category_list路径的访问
    @RequestMapping("admin_category_list")
    public String list(Model model){
        List<Category> cs = categoryService.list(); //获取所有的Category对象，然后放在"cs"中。
        model.addAttribute("cs",cs);
        return "admin/listCategory"; //服务端跳转到 “admin/listCategory” 视图
        //“admin/listCategory” 会根据后续的springMVC.xml 配置文件，跳转到 WEB-INF/jsp/admin/listCategory.jsp 文件
    }
}
```



##### 06  CategoryMapper.xml

1. 在resources目录下，新建mapper目录
2. 右键mapper目录->New->File 新建文件CategoryMapper.xml
   CategoryMapper.xml的namespace必须是com.how2java.tmall.mapper.CategoryMapper,以和CategoryMapper保持一致。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    <select id="list" resultType="Category">
<!--这条sql语句用id: list 进行标示以供后续代码调用。resultType="Category" 表示返回的数据和Category关联起来-->
      select * from category order by id desc
    </select>
</mapper>

<!--在上述映射文件中，<mapper>元素是配置文件的根元素，它包含了一个namespace属性，
该属性值通常设置为“包名+SQL映射文件名”，
指定了唯一的命名空间;
子元素<select>、<insert>、<update>以及<delete>中的信息是
用于执行查询、添加、修改以及删除操作的配置,SQL语句。-->
```



##### 07  log4j.properties

在resources目录下新建log4j.properties

该配置文件的作用是**开启日志**，当访问页面的时候，查看mybatis运行的情况，执行了什么SQL语句，以及sql语句的返回情况等信息。

```properties
# Global logging configuration
#设置日志输出的等级为ERROR,低于ERROR就不会输出了
#设置日志输出到stdout
log4j.rootLogger=ERROR, stdout
# MyBatis logging configuration...
log4j.logger.com.how2java.tmall=TRACE
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
# %5p [%t] (%F:%L) - %m%n 就表示宽度是5的优先等级 线程名称 (文件名:行号) - 信息 回车
#%c 输出日志信息所属的类的全名
#%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-MM-dd HH:mm:ss }，输出类似：2002-10-18- 22：10：28
#%f 输出日志信息所属的类的类名
#%l 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行
#%m 输出代码中指定的信息，如log(message)中的message
#%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
#%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推
#%r 输出自应用启动到输出该日志信息所耗费的毫秒数
#%t 输出产生该日志事件的线程名
#可以从MyBatis使用手册中的Logging小节复制，然后进行简单修改
#在日志文件中配置了全局的日志配置、MyBatis的日志配置和控制台输出
```

##### 08 jdbc.properties

在resources目录下新建jdbc.properties

```properties
#数据库的配置文件jdbc.properties，此配置文件给出了访问数据库需要的必须信息：
#1. 驱动 jdbc.driver=com.mysql.jdbc.Driver
#2. url jdbc.url=jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8
#3. 账号 jdbc.username=root
#4. 密码 jdbc.password=admin

jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&charcterEncoding=utf8
jdbc.username=root
jdbc.password=admin
```



##### 09  applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- 启动对注解的识别
    在Spring MVC中使用扫描机制找到应用中所有基于注解的控制器类，
    所以，为了让控制器类被Spring MVC框架扫描到，需要在配置文件中声明spring-context，
    并使用<context：component-scan/>元素指定控制器类的基本包-->
    <context:annotation-config />
    <context:component-scan base-package="com.how2java.tmall.service" />

    <!-- 导入数据库配置文件, 指定对jdbc.properties的引用 -->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!-- 配置数据库连接池 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />

        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="1" />
        <property name="minIdle" value="1" />
        <property name="maxActive" value="20" />

        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="60000" />

        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000" />

        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="300000" />

        <property name="validationQuery" value="SELECT 1" />
        <property name="testWhileIdle" value="true" />
        <property name="testOnBorrow" value="false" />
        <property name="testOnReturn" value="false" />

        <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        <property name="poolPreparedStatements" value="true" />
        <property name="maxPoolPreparedStatementPerConnectionSize"
                  value="20" />
    </bean>

    <!--Mybatis的SessionFactory配置
    配置Mybatis的SessionFactory，其中声明了别名，
    并且使用前面配置的数据源，扫描CategoryMapper.xml配置文件
     扫描Mapper类： CategoryMapper-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="typeAliasesPackage" value="com.how2java.tmall.pojo" />
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
        <!--分页插件，目前先注释，后面重构的时候才会使用
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <value>
                        </value>
                    </property>
                </bean>
            </array>
        </property>
        -->
    </bean>

    <!--Mybatis的Mapper文件识别-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.how2java.tmall.mapper"/>
    </bean>

</beans>
```



##### 10 springMVC.xml

在resources目录下新建springMVC.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">

    <!--启动注解识别-->
    <context:annotation-config/>

    <context:component-scan base-package="com.how2java.tmall.controller">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <mvc:annotation-driven />

    <!--开通静态资源的访问-->
    <mvc:default-servlet-handler />

    <!-- 视图定位 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>

    <!-- 对上传文件的解析-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
</beans>
```



##### 11 修改 web.xml

1. 指定spring的配置文件为classpath下的applicationContext.xml
2. 设置中文过滤器
3. 指定spring mvc配置文件为classpath下的springMVC.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
 
  <!-- spring的配置文件-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
 
  <!--中文过滤器-->
  <filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
 
  <!-- spring mvc核心：分发servlet -->
  <servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- spring mvc的配置文件 -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springMVC.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
 
</web-app>
```



##### 12 静态资源

https://how2j.cn/frontdownload?bean.id=1478

下载解压到webapp目录中

**HTML:超文本标记语言（HyperText Markup Language）**

HTML是一种用来定义网页的文本，会HTML，就可以编写网页.

HTTP是在网络上传输HTML的协议，用于浏览器和服务器的通信

在Web应用中，浏览器请求一个URL，服务器就把生成的HTML网页发送给浏览器，而浏览器和服务器之间的传输协议是HTTP

HTTP协议是一个基于TCP协议之上的请求-响应协议

<标签>内容</标签>

```html
<html>
  <body>
    <p>Hello HTML</p>
  </body>
</html>
```

**CSS:指层叠样式表 (Cascading Style Sheets)**

改变页面的布局和外观

<style> </style>改变所有页面的布局和外观

selector {property: value}  即 选择器{属性:值}

**Javascript 脚本语言**

像[HTML]页面添加交互行为，嵌入动态文本于HTML页面，对浏览器事件做出响应等

<script> 与 </script> 标签

函数式编程

https://www.runoob.com

##### 13 listCategory.jsp

12步骤后，就会在WEB-INF下创建jsp目录。

 然后在jsp目录中创建admin目录，接着创建listCategory.jsp文件
listCategory.jsp主要作用是通过43行的forEach标签遍历"cs"里的内容，然后挨个显示出来

![image-20200824133244077](https://img-blog.csdnimg.cn/20200924120221699.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
        if(!checkEmpty("categoryPic","分类图片"))
            return false;
        return true;
    });
});
 
</script>
 
<title>分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>图片</th>
                    <th>分类名称</th>
                    <th>属性管理</th>
                    <th>产品管理</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                 
                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>
                         
                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>                   
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>                  
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
     
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
    <div class="pageDiv">
        <%//@include file="../include/admin/adminPage.jsp" %>
    </div>
     
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增分类</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类圖片</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
      </div>
    </div>
     
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```

##### 14 测试

首先点中源目录：java 然后菜单->File->New->Package 输入 **com.how2java.tmall.test** 创建包
接着创建测试TestTmall, 其作用是借助JDBC, 运行代码，创建10条分类测试数据。

```java
package com.how2java.tmall.test;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
  
public class TestTmall {
  
    public static void main(String args[]){
        //准备分类测试数据：
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
                        "root", "admin");
                Statement s = c.createStatement();
        )
        {
            for (int i = 1; i <=10 ; i++) {
                String sqlFormat = "insert into category values (null, '测试分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }
             
            System.out.println("已经成功创建10条分类测试数据");
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
  
}
```



![image-20200824195020922](https://img-blog.csdnimg.cn/20200924120221840.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



![image-20200824195135659](https://img-blog.csdnimg.cn/20200924120221986.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



##### 15  总结



![思路图 ](https://img-blog.csdnimg.cn/20200924120221912.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



1. 首先浏览器上访问路径 /admin_category_list
2. tomcat根据web.xml上的配置信息，拦截到了/admin_category_list，并将其交由DispatcherServlet处理。
3. DispatcherServlet 根据springMVC的配置，将这次请求交由CategoryController类进行处理，所以需要进行这个类的实例化
4. 在实例化CategoryController的时候，注入CategoryServiceImpl
5. 在实例化CategoryServiceImpl的时候，又注入CategoryMapper
6. 根据ApplicationContext.xml中的配置信息，将CategoryMapper和CategoryMapper.xml关联起来了。
7. 这样就拿到了实例化好了的CategoryController,并调用list方法
8. 在list方法中，访问CategoryService,并获取数据，并把数据放在"cs"上，接着服务端跳转到listCategory.jsp去
9. 最后在listCategory.jsp 中显示数据







#### 4.3.9 分页

选中java目录，右键->New -> Package -> com.how2java.tmall.util包

##### 01 新建Page.java

新增Page这个实体类专门为分页提供必要信息
**属性**：
int start; 开始位置
int count; 每页显示的数量
int total; 总共有多少条数据
String param; 参数(这个属性在后续有用到，但是分类的分页查询里并没有用到，请忽略)

**方法**：
getTotalPage 根据 每页显示的数量count以及总共有多少条数据total，计算出总共有多少页
getLast 计算出最后一页的数值是多少
isHasPreviouse 判断是否有前一页
isHasNext 判断是否有后一页

```java
package com.how2java.tmall.util;

public class Page {

    private int start; //开始页数
    private int count; //每页显示个数
    private int total; //总数
    private String param; //参数

    private static final int defaultCount = 5; //默认每页显示5条

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page(){
        count = defaultCount;
    }

    public Page(int start, int count){
        this();
        this.start = start;
        this.count = count;
    }

    public boolean isHasPreviouse(){
        if(start==0){
            return false;
        }
        return true;
    }

    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }
    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
            // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;

        if(0==totalPage)
            totalPage = 1;
        return totalPage;

    }

    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;
        last = last<0?0:last;
        return last;
    }

    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }

    public int getTotal() {
        return total;
    }

    
    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}
```





##### 02  修改CategoryMapper

**Mapper层**

提供一个**支持分页的查询方法**list(Page page)和**获取总数的方法**total

```java
package com.how2java.tmall.mapper;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.pojo.Category;
  
import java.util.List;
  
public interface CategoryMapper {
    public List<Category> list(Page page);
 
    public int total();
}
```



##### 03  修改CategoryMapper.xml

**Mybatis配置Sql**

修改CategoryMapper.xml，以提供**带分页的查询语句**和**获取总数**的sql语句

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    
    <select id="list" resultType="Category">
      select * from category order by id desc
        <!--Mybatis 动态SQL里的if标签-->
        <if test="start!=null and count!=null">
            <!-- 使用#{}意味着使用的预编译的语句,即在使用jdbc时的preparedStatement-->
            limit #{start},#{count}
            <!-- 根据分页数据start和count查询数据 -->
        </if>
    </select>

    <!-- 查询用户记录总数 -->
    <select id="total" resultType="int">
        select count(*) from category
        <!--Select count(*) 返回的是记录的数目-->
    </select>
      
</mapper>
```



##### 04 修改CategoryService

提供一个支持分页的查询方法list(Page page)和获取总数的方法total

```java
package com.how2java.tmall.service;
import com.how2java.tmall.pojo.Category;

import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    
    public int total();
    public List<Category> list(Page page);
    
}
```



##### 05 修改CategoryServiceImpl

提供一个支持分页的查询方法list(Page page)和获取总数的方法total

```java
package com.how2java.tmall.service.impl;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//注解@Service声明当前类是一个Service业务类  
@Service
public class CategoryServiceImpl implements CategoryService{
    //通过自动装配@Autowired引入CategoryMapper,在list方法中调用CategoryMapper 的list方法
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }
    @Override 
    public int total(){
        return categoryMapper.total();
    }
}
```



##### 06 修改CategoryController

1. 为方法list增加参数Page用于获取浏览器传递过来的分页信息

2. categoryService.list(page); 获取当前页的分类集合
3. 通过categoryService.total(); 获取分类总数
4. 通过page.setTotal(total); 为分页对象设置总数
5. 把分类集合放在"cs"中

6. 把分页对象放在 "page“ 中

7. 跳转到listCategory.jsp页面

```java
package com.how2java.tmall.controller;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;

import com.how2java.tmall.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//使用org.springframework.web.bind.annotation.RequestMapping注解类型将请求与处理方法一一对应。
/*
 Controller实现类包含了对用户请求的处理逻辑，是用户请求和业务逻辑之间的“桥梁,负责具体的业务逻辑处理
 在Spring MVC中使用扫描机制找到应用中所有基于注解的控制器类
 */

import java.util.List;

//注解@Controller声明当前类是一个控制器
@Controller
//注解@RequestMapping("")表示访问的时候无需额外的地址
@RequestMapping("")
public class CategoryController {
    //注解@Autowired把CategoryServiceImpl自动装配进了CategoryService 接口
    @Autowired
    CategoryService categoryService;
    //注解@RequestMapping("admin_category_list") 映射admin_category_list路径的访问
    @RequestMapping("admin_category_list")
    public String list(Model model，Page page){ //为方法list增加参数Page用于获取浏览器传递过来的分页信息
        List<Category> cs = categoryService.list(page); //获取当前页的分类集合
        int total = categoryService.total(); //获取分类总数
        page.setTotal(total);  //为分页对象设置总数
        model.addAttribute("cs",cs);//把分类集合放在"cs"中
        model.addAttribute("page",page); //把分页对象放在 "page“ 中
        return "admin/listCategory"; //跳转到listCategory.jsp页面
    }
}
```



##### 07 listCategory.jsp 

webapp/WEB-INF/jsp/admin/listCategory.jsp

![image-20200825114731283](C:\Users\hk199\Desktop\Java学习总结\SSM电商项目\4.39listcategoryjsp.png)

 

**JSTL**  JSP Standard Tag Library 标准标签库

JSTL允许开人员可以像使用HTML标签那样在JSP中开发Java功能。



```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--prefix="c" 表示后续的标签使用都会以<c: 开头 -->

<!--taglib 标签的作用：声明用户使用*自定义*的标签，将标签库描述符文件导入到jsp页面。
属性：uri属性:定位标签库描述符的位置。唯一标识和前缀相关的标签库描述符，可以使用绝对或相对URL。
prefix属性：标签的前缀，区分多个自定义标签。不可以使用保留前缀和空前缀，遵循XML命名空间的命名约定。-->


<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){

        $("#addForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
            if(!checkEmpty("categoryPic","分类图片"))
                return false;
            return true;
        });
    });

</script>

<title>分类管理</title>

<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <!-- 使用JSTL中的c:forEach 循环来遍历集合cs -->
            <c:forEach items="${cs}" var="c">
            <!-- var="c" 表示把每一个集合中的元素放在c上-->

                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>

                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <% @include file="../include/admin/adminPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增分类</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类圖片</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>
```

 

##### 08 adminPage.jsp

BootStrap 是Twitter的工程师开发的**前端框架**，可以非常方便的设计出好看的页面效果。

以<!DOCTYPE html>开头

接着导入js和css
Bootstrap需要**JQuery**才能正常工作，所以需要导入jquery.min.js
接着是 **Bootstrap的css**，里面定义了各种样式
最后是 **Bootstrap的js**，用于产生交互效果，比如关闭警告框

```javascript
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
```

<nav> 标签定义导航链接的部分



```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
$(function(){
    $("ul.pagination li.disabled a").click(function(){
        return false;
    });
});
 
</script>
 
<nav>
  <ul class="pagination">
      <!--首页超链：-->
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=0${page.param}" aria-label="Previous" >
        <span aria-hidden="true">«</span>
      </a>
    </li>
 
     <!--上一页超链：-->
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=${page.start-page.count}${page.param}" aria-label="Previous" >
        <span aria-hidden="true">‹</span>
      </a>
    </li>   
 
    <!--中间页-->
    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                <a href="?start=${status.index*page.count}${page.param}"
                <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                >${status.count}</a>
            </li>
         
    </c:forEach>
 
    <!--下一页超链：-->
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
        <span aria-hidden="true">›</span>
      </a>
    </li>
     
    <!--最后一页-->
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.last}${page.param}" aria-label="Next">
        <span aria-hidden="true">»</span>
      </a>
    </li>

  </ul>
</nav>
```

![image-20200905094956387](https://img-blog.csdnimg.cn/20200924120221795.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

#### 4.3.10 增加

##### 01 listCategory.jsp

###### 1 新增分类

增加分类的代码是整合在**listCategory.jsp**中的

![image-20200905073132492](https://img-blog.csdnimg.cn/20200924120221832.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

1. method="post" 用于保证中文的正确提交
2. 必须有enctype="multipart/form-data"，表示提交的数据是二进制文件，这样才能上传文件
3. accept="image/*" 这样把上传的文件类型限制在了图片

```jsp
<div class="panel panel-warning addDiv">
     <div class="panel-heading">新增分类</div>
     <div class="panel-body">
         <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
             <table class="addTable">
                 <tr>
                     <td>分类名称</td>
                     <td><input  id="name" name="name" type="text" class="form-control"></td>
                 </tr>
                 <tr>
                     <td>分类图片</td>
                     <td>
                         <input id="categoryPic" accept="image/*" type="file" name="image" />
                     </td>
                 </tr>
                 <tr class="submitTR">
                     <td colspan="2" align="center">
                         <button type="submit" class="btn btn-success">提 交</button>
                     </td>
                 </tr>
             </table>
         </form>
     </div>
```

###### 2 图片为空判断

对分类名称和分类图片做了为空判断，当为空的时候，不能提交

![image-20200905074258457](https://img-blog.csdnimg.cn/20200924120221791.png#pic_center)

```jsp
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
        if(!checkEmpty("categoryPic","分类图片"))
            return false;
        return true;
    });
});
 
</script>
```

其中用到的函数**checkEmpty**，在**adminHeader.jsp**中定义

```javascript
function checkEmpty(id, name){
	var value = $("#"+id).val();
	if(value.length==0){
		alert(name+ "不能为空");
		$("#"+id)[0].focus();
		return false;
	}
	return true;
}
```

**listCategory.jsp** 

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--prefix="c" 表示后续的标签使用都会以<c: 开头 -->

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){

        $("#addForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
            if(!checkEmpty("categoryPic","分类图片"))
                return false;
            return true;
        });
    });

</script>

<title>分类管理</title>

<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <!-- 使用JSTL中的c:forEach 循环来遍历集合cs -->
            <c:forEach items="${cs}" var="c">
            <!-- var="c" 表示把每一个集合中的元素放在c上-->

                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>

                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <% @include file="../include/admin/adminPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增分类</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类圖片</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>
```



##### 02  CategoryMapper.xml

在CategoryMapper.xml中新增加 插入分类的SQL语句

```xml
 <insert id="add"  keyProperty="id"  useGeneratedKeys="true" parameterType="Category" >
        insert into category ( name ) values (#{name})
    </insert>
```

需要加上2个属性：keyProperty="id" useGeneratedKeys="true" 以确保Category对象通过mybatis增加到数据库之后得到的id增长值会被设置在Category对象上。 因为在保存分类图片的时候需要用到这个id值，所以这一步是必须的。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    <select id="list" resultType="Category">
        select * from   category         order by id desc
        <if test="start!=null and count!=null">
            limit #{start},#{count}
        </if>
 
    </select>
    <select id="total" resultType="int">
        select count(*) from category
    </select>
    <insert id="add"  keyProperty="id"  useGeneratedKeys="true" parameterType="Category" >
        insert into category ( name ) values (#{name})
    </insert>
</mapper>
```



##### 03 CategoryMapper

新增add方法

```java
package com.how2java.tmall.mapper;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.pojo.Category;
  
import java.util.List;
  
public interface CategoryMapper {
     List<Category> list(Page page);
 
     int total();
 
     void add(Category category);
}
```



##### 04 CategoryService

新增add方法

```java
package com.how2java.tmall.service;
 
        import com.how2java.tmall.pojo.Category;
        import com.how2java.tmall.util.Page;
        import java.util.List;
 
public interface CategoryService{
    int total();
    List<Category> list(Page page);
 
    void add(Category category);
 
}
```



##### 05 CategoryServiceImpl

新增add方法的实现

```java
package com.how2java.tmall.service.impl;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }
 
    @Override
    public int total() {
        return categoryMapper.total();
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
}
```



##### 06 UploadedImageFile

在util包中新增UploadedImageFile.java ，其中有一个MultipartFile 类型的属性，用于接受上传文件的注入

```html
<input id="categoryPic" accept="image/*" type="file" name="image" />
```

 这里的属性名称image必须和**页面中的增加分类部分**中的type="file"的name值保持一致。

```java
package com.how2java.tmall.util;
 
import org.springframework.web.multipart.MultipartFile;
  
public class UploadedImageFile {
    MultipartFile image;
  
    public MultipartFile getImage() {
        return image;
    }
  
    public void setImage(MultipartFile image) {
        this.image = image;
    }
  
}
```



##### 07 ImageUtil工具类

ImageUtil 工具类提供3个方法

**change2jpg**
确保图片文件的二进制格式是jpg。
仅仅通过ImageIO.write(img, "jpg", file);不足以保证转换出来的jpg文件显示正常。

这段转换代码，可以确保转换后jpg的图片显示正常，而不会出现暗红色( 有一定几率出现)。

后两种resizeImage用于改变图片大小，在上传产品图片的时候会用到。 

```java
package com.how2java.tmall.util;
  
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
  
import javax.imageio.ImageIO;
  
public class ImageUtil {
  
    public static BufferedImage change2jpg(File f) {
        try {
            Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
            pg.grabPixels();
            int width = pg.getWidth(), height = pg.getHeight();
            final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
            final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
            WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
            BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
            return img;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
  
    public static void resizeImage(File srcFile, int width,int height, File destFile) {
        try {
            if(!destFile.getParentFile().exists())
                destFile.getParentFile().mkdirs();
            Image i = ImageIO.read(srcFile);
            i = resizeImage(i, width, height);
            ImageIO.write((RenderedImage) i, "jpg", destFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    public static Image resizeImage(Image srcImage, int width, int height) {
        try {
  
            BufferedImage buffImg = null;
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
  
            return buffImg;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
  
}
```



##### 08 CategoryController

CategoryController新增**add方法**

```java
//add方法映射路径admin_category_add的访问
@RequestMapping("admin_category_add")
/*
1 参数 Category c接受页面提交的分类名称
2 参数 session 用于在后续获取当前应用的路径
3 UploadedImageFile 用于接受上传的图片
*/
public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
    //通过categoryService保存c对象
    categoryService.add(c); 
    /*
    通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
    该项目使用idea中的tomcat部署，那么图片存放在:C:\Users\hk199\Desktop\Java学习总结\tmall-ssm\img\category 中
    */
    File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
    //根据分类id创建文件名
    File file = new File(imageFolder,c.getId()+".jpg");
    //如果/img/category目录不存在，则创建该目录，否则后续保存浏览器传过来图片，会提示无法保存
    if(!file.getParentFile().exists())
        file.getParentFile().mkdirs();
    //通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
    uploadedImageFile.getImage().transferTo(file);
    //通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
    BufferedImage img = ImageUtil.change2jpg(file);
    ImageIO.write(img, "jpg", file);
    //客户端跳转到admin_category_list
    return "redirect:/admin_category_list";
}
```

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
  
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
   
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        List<Category> cs= categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
 
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
 
        return "redirect:/admin_category_list";
    }
 
}
```

##### 09 中文问题

中文问题，统一交由web.xml中定义的org.springframework.web.filter.CharacterEncodingFilter来进行处理

<url-pattern>/*</url-pattern>表示所有的访问都会过滤

<url-pattern>*.jsp</url-pattern>就表示只过滤jsp

```xml
 <!--中文过滤器-->
  <filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

在jsp中要加上下方代码，其中contentType="text/html; charset=UTF-8"的作用是告诉浏览器提交数据的时候，使用UTF-8编码

在form里method="post" 才能正确提交中文

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
```

![Filter概念 ](https://img-blog.csdnimg.cn/20200924120221723.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

配置Tomcat,deployment 这里一定要选 tmall_ssm:war exploed



#### 4.3.11 删除

###### 01  listCategory.jsp

**用于删除的超链**

指向地址admin_category_delete,并且会传递当前分类对象的id过去。

```html
<a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class=" 	glyphicon glyphicon-trash"></span></a>
```

###### 02 adminHeader.jsp

**删除前的确认操作**

在adminHeader.jsp中对所有的删除连接都进行了**监听**

```javascript
$(function(){
    $("a").click(function(){
        var deleteLink = $(this).attr("deleteLink");
        console.log(deleteLink);
        if("true"==deleteLink){
            var confirmDelete = confirm("确认要删除");
            if(confirmDelete)
                return true;
            return false;
             
        }
    });
})
```

###### 03 CategoryMapper.xml

增加删除sql语句

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    
    <select id="list" resultType="Category">
        select * from   category         order by id desc
        <if test="start!=null and count!=null">
            limit #{start},#{count}
        </if>
    </select>
    
    <select id="total" resultType="int">
        select count(*) from category
    </select>
    
    <insert id="add"  keyProperty="id"  useGeneratedKeys="true" parameterType="Category" >
        insert into category ( name ) values (#{name})
    </insert>
    
    <delete id="delete">
        delete from category where id= #{id}
    </delete>
    
</mapper>
```



###### 04 CategoryMapper

增加删除方法

```java
package com.how2java.tmall.mapper;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.pojo.Category;
  
import java.util.List;
  
public interface CategoryMapper {
     List<Category> list(Page page);
 
     int total();
 
     void add(Category category);
 
     void delete(int id);
}
```

###### 05 CategoryService

增加删除方法

```java
package com.how2java.tmall.service;
import com.how2java.tmall.pojo.Category
import com.how2java.tmall.util.Page;
import java.util.List;
 
public interface CategoryService{
    int total();
    List<Category> list(Page page);
 
    void add(Category category);
 
    void delete(int id);
 
```

###### 06 CategoryServiceImpl

增加删除方法

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }
 
    @Override
    public int total() {
        return categoryMapper.total();
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }
}
```

###### 07 CategoryController

增加删除方法

```java
//映射路径admin_category_delete
@RequestMapping("admin_category_delete")
//提供参数接受id注入
//提供session参数，用于后续定位文件位置   
public String delete(int id,HttpSession session) throws IOException {
    //通过categoryService删除数据
    categoryService.delete(id);
    //通过session获取ControllerContext然后获取分类图片位置，接着删除分类图片
    File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
    File file = new File(imageFolder,id+".jpg");
    file.delete();
 
    //客户端跳转到 admin_category_list
    return "redirect:/admin_category_list";
}
```



```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
  
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
   
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        List<Category> cs= categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
 
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(c);
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
 
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
 
        return "redirect:/admin_category_list";
    }
 
}
```



##### 4.3.12 编辑

###### 01 listCategory.jsp

用于编辑的超链，指向地址admin_category_edit,并且会传递当前分类对象的id过去。

```jsp
<a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a>
```



###### 02 CategoryMapper.xml

增加通过id获取Category对象的sql语句

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    <select id="list" resultType="Category">
        select * from   category         order by id desc
        <if test="start!=null and count!=null">
            limit #{start},#{count}
        </if>
 
    </select>
    <select id="total" resultType="int">
        select count(*) from category
    </select>
    <insert id="add"  keyProperty="id"  useGeneratedKeys="true" parameterType="Category" >
        insert into category ( name ) values (#{name})
    </insert>
    <delete id="delete">
        delete from category where id= #{id}
    </delete>
 
    <select id="get" resultType="Category">
        select * from category  where id= #{id}
    </select>
</mapper>
```



###### 03 CategoryMapper

增加get方法

```java
package com.how2java.tmall.mapper;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.pojo.Category;
 
import java.util.List;
 
public interface CategoryMapper {
     List<Category> list(Page page);
 
     int total();
 
     void add(Category category);
 
     void delete(int id);
 
     Category get(int id);
}
```

###### 04 CategoryService

增加get方法

```java
package com.how2java.tmall.service;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryService{

    int total();
    List<Category> list(Page page);
    void add(Category category);
    void delete(int id);
    Category get(int id);
}
```



###### 05 CategoryServiceImpl

增加get方法

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.util.Page;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }
 
    @Override
    public int total() {
        return categoryMapper.total();
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }
 
    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }
}
```

###### 06 CategoryController

增加edit方法

```java
//映射admin_category_edit路径的访问
@RequestMapping("admin_category_edit")
//参数id用来接受注入
public String edit(int id,Model model) throws IOException {
    //通过categoryService.get获取Category对象
    //把对象放在“c"上
    Category c= categoryService.get(id);
    model.addAttribute("c", c);
    //返回editCategory.jsp
    return "admin/editCategory";
}
```

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
  
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
   
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        List<Category> cs= categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
 
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(c);
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
 
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
 
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
 
}
```



###### 07 editCategory.jsp

![image-20200905114845994](https://img-blog.csdnimg.cn/20200924120221805.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑分类</title>
 
<script>
    $(function(){
 
        $("#editForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
 
            return true;
        });
    });
 
</script>
 
<div class="workingArea">
 
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li class="active">编辑分类</li>
    </ol>
 
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_category_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${c.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
```



点击**编辑**下的小图标，会跳转到下面的编辑分类

![image-20200905115429823](https://img-blog.csdnimg.cn/20200924120221852.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

##### 4.3.13 修改

###### 01 listCategory.jsp

编辑页面提交数据到admin_category_update

```jsp
<form method="post" id="editForm" action="admin_category_update"  enctype="multipart/form-data">
```



###### 02 CategoryMapper.xml

增加修改的sql语句

```xml
<update id="update" parameterType="Category" >
        update category set name=#{name} where id=#{id}
</update>
```



###### 03 CategoryMapper

增加update方法

```java
void update(Category category);
```



###### 04 CategoryService

增加update方法

```java
void update(Category category);
```



###### 05 CategoryServiceImpl

增加update方法

```java
@Override
public void update(Category category) {
      categoryMapper.update(category);
    }
```



###### 06 CategoryController

新增update方法

```java
//update 方法映射路径admin_category_update的访问
@RequestMapping("admin_category_update")
//参数 Category c接受页面提交的分类名称
//参数 session 用于在后续获取当前应用的路径
//UploadedImageFile 用于接受上传的图片
public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        //通过categoryService更新c对象
        categoryService.update(c);
        //通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            // //首先判断是否有上传图片，如果有上传，那么通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径。
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            //根据分类id创建文件名
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            //通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg
            BufferedImage img = ImageUtil.change2jpg(file);
            //客户端跳转到admin_category_list
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
```

## 5 重构

#### 5.1 概述

分类管理中的CategoryMapper.xml使用很直接的SQL语句开发出来，这样的好处是简单易懂，便于理解。
可是，随着本项目功能的展开和复杂度的提升，使用这种直接的SQL语句方式的开发效率较低，需要自己手动写每一个SQL语句，而且其维护起来也比较麻烦。
所以在理解和消化了分类管理的基础上，做进一步的改进，主要是在**分页方式**和**逆向工程**方面做了**重构**。

<!--more-->

###### 1分页方式

目前的分页方式是自己写分页对应的limit SQL语句，并且提供一个获取总数的count(*) SQL。 不仅如此, mapper, service, service.impl 里都要提供两个方法：
list(Page page), count()

分类是这么做的，后续其他所有的实体类要做分页管理的时候都要这么做，所以为了提高开发效率，把目前的分页方式改为使用 **pageHelper分页插件**来实现。

PageHelper也相当于物理分页。即数据库自带的分页，如mysql是limit。 PageHelper本质也是数据库查询。

因为是第三方插件，所以需要额外的jar包：pagehelper-5.1.0-beta2.jar，jsqlparser-1.0.jar

在mybatis-config.xml中，添加以下代码，表示开启PageHelper插件

```xml
 <plugins>
        <plugin interceptor="com.github.pagehelper.PageInterceptor">      
        </plugin>
    </plugins>   
```

```java
PageHelper.offsetPage(0, 5); //表示查出第一页的数据，每页5条

PageInfo page= new PageInfo<>(cs); //可以获取分页信息，包括总数以及其他的信息
```

###### 2 逆向工程

**MyBatis是当前主流的Java持久层框架之一，与Hibernate一样，也是一种ORM框架**

目前分类管理中Mybatis中相关类都是自己手动编写的，包括：Category.java, CategoryMapper.java和CategoryMapper.xml。

尤其是CategoryMapper.xml里面主要是SQL语句，可以预见在接下来的开发任务中，随着业务逻辑的越来越复杂，SQL语句也会越来越复杂，进而导致开发速度降低，出错率增加，维护成本上升等问题。

为了解决手动编写SQL语句效率低这个问题，对Mybatis部分的代码，使用逆向工程进行重构。

所谓的**逆向工程**，就是在已经存在的数据库表结构基础上，通过工具，**自动生成**Category.java, CategoryMapper.java和CategoryMapper.xml。



#### 5.2  分页方式重构

##### 01 CategoryMapper.xml

1. 去掉total SQL语句
2. 修改list SQL语句，去掉其中的limit

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.how2java.tmall.mapper.CategoryMapper">
    <select id="list" resultType="Category">
        select * from   category         order by id desc
    </select>
 
    <insert id="add"  keyProperty="id"  useGeneratedKeys="true" parameterType="Category" >
        insert into category ( name ) values (#{name})
    </insert>
    <delete id="delete">
        delete from category where id= #{id}
    </delete>
 
    <select id="get" resultType="Category">
        select * from category  where id= #{id}
    </select>
 
    <update id="update" parameterType="Category" >
        update category set name=#{name} where id=#{id}
    </update>
</mapper>
```



##### 02 CategoryMapper

1. 去掉total()方法
2. 去掉list(Page page)方法
3. 新增list() 方法

```java
package com.how2java.tmall.mapper;
 
import com.how2java.tmall.pojo.Category;
 
import java.util.List;
 
public interface CategoryMapper {
     List<Category> list();
 
     void add(Category category);
 
     void delete(int id);
 
     Category get(int id);
 
     void update(Category category);
}
```



##### 03 CategoryService

1. 去掉total()方法
2. 去掉list(Page page)方法
3. 新增list() 方法

```java
package com.how2java.tmall.service;
 
import com.how2java.tmall.pojo.Category;
import java.util.List;
 
public interface CategoryService{
    List<Category> list();
 
    void add(Category category);
 
    void delete(int id);
 
    Category get(int id);
 
    void update(Category category);
}
```

##### 04  CategoryServiceImpl

1. 去掉total()方法
2. 去掉list(Page page)方法
3. 新增list() 方法

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }
 
    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }
 
    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }
}
```

##### 05 CategoryController



```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
  
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
   
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        //通过分页插件指定分页参数
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list(); //调用list() 获取对应分页的数据
        int total = (int) new PageInfo<>(cs).getTotal();//通过PageInfo获取总数
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
 
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(c);
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
 
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
 
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
 
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
 
}
```

##### 06 applicationContext.xml

之前是注释掉的，现在释放出来

```xml
<property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <value>
                        </value>
                    </property>
                </bean>
            </array>
        </property>
```



#### 5.3  分类的逆向工程

数据库版本是 MySQL5.5

**逆向工程**，就是在已经存在的数据库表结构基础上，通过工具，**自动生成**Category.java, CategoryMapper.java和CategoryMapper.xml。

##### 01 OverIsMergeablePlugin

Mybatis Generator是一个用于Mybatis逆向工程的工具。

MybatisGenerator插件是Mybatis官方提供的，这个插件存在一个固有的Bug，即当第一次生成了CategoryMapper.xml之后，再次运行会导致CategoryMapper.xml生成重复内容，而影响正常的运行。

需要自己写**(copy,paste)**一个小插件类**OverIsMergeablePlugin**

```Java
package com.how2java.tmall.util;
 
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
 
import java.lang.reflect.Field;
import java.util.List;
 
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
 
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
```



##### 02 generatorConfig.xml

在**resouces**下创建generatorConfig.xml文件，其**目的**就是为了正确使用本插件而提供必要的配置信息

1. 使用OverIsMergeablePlugin插件

   ```java
   <plugin type="com.how2java.tmall.util.OverIsMergeablePlugin" />
   ```

2. 在生成的代码中，不提供注释,如果提供注释，生成出来的代码，看上去乱七八糟的。

   ```java
   <commentGenerator>
   ```

3. 指定链接数据库

   ```java
   <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://localhost/tmall_ssm" userId="root" password="admin">
   ```

4. 的账号和密码，逆向工程，首先要链接到数据库

5. 指定生成的pojo,mapper, xml文件的存放位置

6. 生成对应表及类名，目前只开放了category表，其他表都注释掉了。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
 
    <context id="DB2Tables"    targetRuntime="MyBatis3">
        <!--避免生成重复代码的插件-->
        <plugin type="com.how2java.tmall.util.OverIsMergeablePlugin" />
 
        <!--是否在代码中显示注释-->
        <commentGenerator>
            <property name="suppressDate" value="true" />
            <property name="suppressAllComments" value="true" />
        </commentGenerator>
 
        <!--数据库链接地址账号密码-->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://localhost/tmall_ssm" userId="root" password="admin">
        </jdbcConnection>
        <!--不知道做什么用的。。。反正贴上来了~-->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
        <!--生成pojo类存放位置-->
        <javaModelGenerator targetPackage="com.how2java.tmall.pojo" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!--生成xml映射文件存放位置-->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!--生成mapper类存放位置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.how2java.tmall.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
 
        <!--生成对应表及类名-->
 
        <table tableName="category" domainObjectName="Category" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
            <property name="my.isgen.usekeys" value="true"/>
            <property name="useActualColumnNames" value="true"/>
            <generatedKey column="id" sqlStatement="JDBC"/>
 
        </table>
        <!--
                <table tableName="property" domainObjectName="Property" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="product" domainObjectName="Product" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="productImage" domainObjectName="ProductImage" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="order_" domainObjectName="Order" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="propertyValue" domainObjectName="PropertyValue" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="review" domainObjectName="Review" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="user" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="orderItem" domainObjectName="OrderItem" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
                -->
    </context>
</generatorConfiguration>
```



##### 03 MybatisGenerator

**运行即生成pojo.mapper和xml**

生成代码成功，只能执行一次，以后执行会覆盖掉mapper,pojo,xml 等文件上做的修改。

必须把today变量修改为今天才可以执行，这样明天再执行就无法运行了，以免以后对Category类做了改动，不小心运行了MybatisGenerator 导致Category类上做的手动改动被覆盖掉了。

```java
package com.how2java.tmall.util;
 
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
 
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
public class MybatisGenerator {
 
    public static void main(String[] args) throws Exception {
        String today = "2020-09-09";
 
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date now =sdf.parse(today);
        Date d = new Date();
 
        if(d.getTime()>now.getTime()+1000*60*60*24){
            System.err.println("——————未成成功运行——————");
            System.err.println("——————未成成功运行——————");
            System.err.println("本程序具有破坏作用，应该只运行一次，如果必须要再运行，需要修改today变量为今天，如:" + sdf.format(new Date()));
            return;
        }
 
        if(false)
            return;
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream is= MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
 
        System.out.println("生成代码成功，只能执行一次，以后执行会覆盖掉mapper,pojo,xml 等文件上做的修改");
 
    }
}
```

**运行MybatisGenerator**，

- **自动生成Category**,

  插件自动生成的代码

- **自动生成的CategoryExample**

  ( 它的作用是进行排序，条件查询的时候使用)

- **自动生成CategoryMapper.xml**

  插件自动生成的xml，与手动写的也差不了多少，主要区别在于提供了一个 id="Example_Where_Clause"的SQL，借助这个可以进行多条件查询。

- **自动生成CategoryMapper**

  与手动编写的CategoryMapper比起来，CategoryMapper也是提供CURD一套，不过方法名发生了变化，比如：
  delete叫做deleteByPrimaryKey,
  update叫做updateByPrimaryKey.
  除此之外，修改还提供了一个updateByPrimaryKeySelective，其作用是只修改变化了的字段，未变化的字段就不修改了

  查询list,变成了selectByExample(CategoryExample example); 

- **CategoryService没变化**

- **CategoryController没变化**

##### 04 修改CategoryServiceImpl

原先手动编写的：

```java
package com.how2java.tmall.service.impl;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//注解@Service声明当前类是一个Service业务类
@Service
public class CategoryServiceImpl implements CategoryService{
    //通过自动装配@Autowired引入CategoryMapper,在list方法中调用CategoryMapper 的list方法
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }
    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }
    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }
    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }
}
```

因为CategoryMapper的方法名发生了变化，所以CategoryServiceImpl要做相应的调整。

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.CategoryExample;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list() {
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example); //传递一个example对象，这个对象指定按照id倒排序来查询
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
 
    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
```

**修改之后，分类的pojo,xml.mapper都不用自己手动编写，大大提高了生产效率。**



#### 5.4  所有的逆向工程

把其余所有的实体类，example类，mapper和xml都生成。
为什么呢？ 因为随着业务的推进，需要对实体类进行修改，而修改之后，再通过插件创建的话，会覆盖掉实体类中的修改的。 所以干脆一口气把其余所有的实体类都生成

##### 01 修改generatorConfig.xml

修改generatorConfig.xml，把所有的table都释放出来

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
 
    <context id="DB2Tables"    targetRuntime="MyBatis3">
        <!--避免生成重复代码的插件-->
        <plugin type="com.how2java.tmall.util.OverIsMergeablePlugin" />
 
        <!--是否在代码中显示注释-->
        <commentGenerator>
            <property name="suppressDate" value="true" />
            <property name="suppressAllComments" value="true" />
        </commentGenerator>
 
        <!--数据库链接地址账号密码-->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://localhost/tmall_ssm" userId="root" password="admin">
        </jdbcConnection>
        <!--不知道做什么用的。。。反正贴上来了~-->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
        <!--生成pojo类存放位置-->
        <javaModelGenerator targetPackage="com.how2java.tmall.pojo" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!--生成xml映射文件存放位置-->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!--生成mapper类存放位置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.how2java.tmall.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
 
        <!--生成对应表及类名-->
 
        <table tableName="category" domainObjectName="Category" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
            <property name="my.isgen.usekeys" value="true"/>
            <property name="useActualColumnNames" value="true"/>
            <generatedKey column="id" sqlStatement="JDBC"/>
 
        </table>
 
                <table tableName="property" domainObjectName="Property" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="product" domainObjectName="Product" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="productImage" domainObjectName="ProductImage" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="order_" domainObjectName="Order" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="propertyValue" domainObjectName="PropertyValue" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="review" domainObjectName="Review" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="user" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
                <table tableName="orderItem" domainObjectName="OrderItem" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="true" selectByExampleQueryId="false">
                    <property name="my.isgen.usekeys" value="true"/>
                    <property name="useActualColumnNames" value="true"/>
                    <generatedKey column="id" sqlStatement="JDBC"/>
                </table>
 
    </context>
</generatorConfiguration>
```

**运行MybatisGenerator**，today变量修改为**今天**

自动生成的生成的pojo和Example：

![image-20200910071654428](https://img-blog.csdnimg.cn/20200924120221706.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

生成的Mapper类：

![image-20200910071745266](https://img-blog.csdnimg.cn/20200924120221776.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

xml文件：

![image-20200910071830832](https://img-blog.csdnimg.cn/20200924120221712.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

## 6  后台其他页面

### 6.1 属性管理

##### 01 Property

Property实体类已经和其他所有的实体类一起，在所有逆向工程 这个环节就一起自动生成好了。 不过仅仅有自动生成的实体类代码，还不足以支撑业务需要，所以在Property基础上增加了一个Category 字段。

<!--more-->

```java
package com.how2java.tmall.pojo;
 
public class Property {
    private Integer id;
 
    private Integer cid;
 
    private String name;
 
    /*非数据库字段*/
    private Category  category;
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getCid() {
        return cid;
    }
 
    public void setCid(Integer cid) {
        this.cid = cid;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
```



##### 02  PropertyService

新建PropertyService，提供CRUD一套。 需要注意的是，因为在业务上需要查询某个分类下的属性，所以list方法会带上对应分类的id

```java
package com.how2java.tmall.service;
  
import com.how2java.tmall.pojo.Property;
 
import java.util.List;
 
public interface PropertyService {
    void add(Property c);
    void delete(int id);
    void update(Property c);
    Property get(int id);
    List list(int cid);
}
```



##### 03  PropertyServiceImpl

新增PropertyServiceImpl实现[PropertyService]对应的方法。

通过调用自动生成的PropertyMapper就可以实现大部分方法了。
值得注意的是查询的时候用到了辅助查询类：PropertyExample，它的使用也很方便，这一行表示查询cid字段

```java
example.createCriteria().andCidEqualTo(cid);
```



```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyExample;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;
 
    @Override
    public void add(Property p) {
        propertyMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Property p) {
        propertyMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Property get(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }
 
    @Override
    public List list(int cid) {
        PropertyExample example =new PropertyExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }
 
}
```



##### 04  PropertyController

控制器类，用于映射不同路径的访问。

```java
package com.how2java.tmall.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page;
 
@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;
    
    //在PropertyController通过参数Property 接受注入
    @RequestMapping("admin_property_add")
    public String add(Model model, Property p) {
        propertyService.add(p); //通过propertyService保存到数据库
        return "redirect:admin_property_list?cid="+p.getCid(); //客户端跳转到admin_property_list,并带上参数cid
    }
 
    @RequestMapping("admin_property_delete")
    //在PropertyController的delete方法中获取id
    public String delete(int id) {
        //根据id获取Property对象
        Property p = propertyService.get(id);
        // 借助propertyService删除这个对象对应的数据
        propertyService.delete(id);
        //客户端跳转到admin_property_list，并带上参数cid
        return "redirect:admin_property_list?cid="+p.getCid();
    }
 
    @RequestMapping("admin_property_edit")
    public String edit(Model model, int id) {
        //在PropertyController的edit方法中，根据id获取Property对象
        Property p = propertyService.get(id);
        //根据properoty对象的cid属性获取Category对象，并把其设置在Property对象的category属性上
        Category c = categoryService.get(p.getCid());
        //把Property对象放在request的 "p" 属性中
        p.setCategory(c);
        model.addAttribute("p", p);
        //服务端跳转到admin/editProperty.jsp
        return "admin/editProperty";
    }
 
    @RequestMapping("admin_property_update")
    ////在PropertyController的update方法中获取Property对象
    public String update(Property p) {
        //借助propertyService更新这个对象到数据库
        propertyService.update(p);
        //客户端跳转到admin_property_list，并带上参数cid
        return "redirect:admin_property_list?cid="+p.getCid();
    }
 
    //查询地址admin_property_list映射的是PropertyController的list()方法                                         
    @RequestMapping("admin_property_list")
   //获取分类 cid,和分页对象page
    public String list(int cid, Model model,  Page page) {
        Category c = categoryService.get(cid);
        //通过PageHelper设置分页参数
        PageHelper.offsetPage(page.getStart(),page.getCount());
        //基于cid，获取当前分类下的属性集合
        List<Property> ps = propertyService.list(cid);
        //通过PageInfo获取属性总数
        int total = (int) new PageInfo<>(ps).getTotal();
        //把总数设置给分页page对象
        page.setTotal(total);
        //拼接字符串"&cid="+c.getId()，设置给page对象的Param值。 因为属性分页都是基于当前分类下的分页，所以分页的时候需要传递这个cid
        page.setParam("&cid="+c.getId());
        //把属性集合设置到 request的 "ps" 属性上
        model.addAttribute("ps", ps);
        //把分类对象设置到 request的 "c" 属性上
        model.addAttribute("c", c);
        //把分页对象设置到 request的 "page" 对象上
        model.addAttribute("page", page);
        //服务端跳转到admin/listProperty.jsp页面
        return "admin/listProperty";
    }
}
```



##### 04  listProperty.jsp+editProperty.jsp

查询和编辑的jsp页面

![image-20200910080852791](https://img-blog.csdnimg.cn/20200924120221715.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

**listProperty.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
    $(function() {
 
        $("#addForm").submit(function() {
            if (checkEmpty("name", "属性名称"))
                return true;
            return false;
        });
    });
</script>
 
<title>属性管理</title>
 
<div class="workingArea">
 
    <!--面包屑导航-->
    <ol class="breadcrumb">
      <!--第一个连接跳转到admin_category_list-->
      <li><a href="admin_category_list">所有分类</a></li>
       <!--第二个连接跳转到admin_property_list?cid=-->
      <li><a href="admin_property_list?cid=${c.id}">${c.name}</a></li>
      <li class="active">属性管理</li>
    </ol>
 
    <div class="listDataTableDiv">
        <table
            class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>属性名称</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <!--在listProperty.jsp页面上使用c:forEach 遍历ps集合，并显示-->
                <c:forEach items="${ps}" var="p">
 
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td><a href="admin_property_edit?id=${p.id}"><span
                                class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a deleteLink="true"
                            href="admin_property_delete?id=${p.id}"><span
                                class="     glyphicon glyphicon-trash"></span></a></td>
 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>
 
    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增属性</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_property_add">
                <table class="addTable">
                    <tr>
                        <td>属性名称</td>
                        <td><input id="name" name="name" type="text"
                            class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <!-- 在listProperty.jsp页面提交数据的时候，除了提交属性名称，还会提交cid-->
                            <input type="hidden" name="cid" value="${c.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```

**editProperty.jsp**

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑属性</title>
 
<div class="workingArea">
    <ol class="breadcrumb">
      <li><a href="admin_category_list">所有分类</a></li>
      <li><a href="admin_property_list?cid=${p.category.id}">${p.category.name}</a></li>
      <li class="active">编辑属性</li>
    </ol>
 
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑属性</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_property_update">
                <table class="editTable">
                    <tr>
                        <td>属性名称</td>
                        <td><input id="name" name="name" value="${p.name}"
                            type="text" class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                        <!--在editProperty.jsp中显示属性名称-->
                        <input type="hidden" name="id" value="${p.id}">
                        <!--在editProperty.jsp中隐式提供id和cid( cid 通过 p.category.id 获取)-->
                        <input type="hidden" name="cid" value="${p.category.id}">
                        <button type="submit" class="btn btn-success">提 交</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
```

![image-20200910081511576](https://img-blog.csdnimg.cn/20200924120221941.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



### 6.2 产品管理

##### 01 Product

Product在自动生成的基础上增加category属性

```java
package com.how2java.tmall.pojo;
 
import java.util.Date;
import java.util.List;
 
public class Product {
    private Integer id;
 
    private String name;
 
    private String subTitle;
 
    private Float originalPrice;
 
    private Float promotePrice;
 
    private Integer stock;
 
    private Integer cid;
 
    private Date createDate;
 
    /*非数据库字段*/
    private Category  category;
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
 
    public String getSubTitle() {
        return subTitle;
    }
 
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }
 
    public Float getOriginalPrice() {
        return originalPrice;
    }
 
    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }
 
    public Float getPromotePrice() {
        return promotePrice;
    }
 
    public void setPromotePrice(Float promotePrice) {
        this.promotePrice = promotePrice;
    }
 
    public Integer getStock() {
        return stock;
    }
 
    public void setStock(Integer stock) {
        this.stock = stock;
    }
 
    public Integer getCid() {
        return cid;
    }
 
    public void setCid(Integer cid) {
        this.cid = cid;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
}
```



##### 02 ProductService

新增ProductService，提供CRUD一套

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
}
```

##### 03 ProductServiceImpl

新增ProductServiceImpl ，提供CRUD一套。 值得一提的是， get和list方法都会把取出来的Product对象设置上对应的category

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
 
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setCategory(p);
        return p;
    }
 
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
 
    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }
}
```

##### 04 ProductController

```java
package com.how2java.tmall.controller;
 
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;
 
@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
 
    @RequestMapping("admin_product_add")
    public String add(Model model, Product p) {
        p.setCreateDate(new Date());
        productService.add(p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
 
    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
 
    @RequestMapping("admin_product_edit")
    public String edit(Model model, int id) {
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("p", p);
        return "admin/editProduct";
    }
 
    @RequestMapping("admin_product_update")
    public String update(Product p) {
        productService.update(p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
 
    @RequestMapping("admin_product_list")
    public String list(int cid, Model model, Page page) {
        Category c = categoryService.get(cid);
 
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> ps = productService.list(cid);
 
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());
 
        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
 
        return "admin/listProduct";
    }
}
```

##### 05 listProduct.jsp+editProduct.jsp

然后是查询和编辑的jsp页面

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
    $(function() {
        $("#addForm").submit(function() {
            if (!checkEmpty("name", "产品名称"))
                return false;
//          if (!checkEmpty("subTitle", "小标题"))
//              return false;
            if (!checkNumber("originalPrice", "原价格"))
                return false;
            if (!checkNumber("promotePrice", "优惠价格"))
                return false;
            if (!checkInt("stock", "库存"))
                return false;
            return true;
        });
    });
</script>
 
<title>产品管理</title>
 
<div class="workingArea">
 
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${c.id}">${c.name}</a></li>
        <li class="active">产品管理</li>
    </ol>
 
    <div class="listDataTableDiv">
        <table
                class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>产品名称</th>
                <th>产品小标题</th>
                <th width="53px">原价格</th>
                <th width="80px">优惠价格</th>
                <th width="80px">库存数量</th>
                <th width="80px">图片管理</th>
                <th width="80px">设置属性</th>
                <th width="42px">编辑</th>
                <th width="42px">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ps}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>
 
                        <%--<c:if test="${!empty p.firstProductImage}">--%>
                            <%--<img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg">--%>
                        <%--</c:if>--%>
 
                    </td>
                    <td>${p.name}</td>
                    <td>${p.subTitle}</td>
                    <td>${p.originalPrice}</td>
                    <td>${p.promotePrice}</td>
                    <td>${p.stock}</td>
                    <td><a href="admin_productImage_list?pid=${p.id}"><span
                            class="glyphicon glyphicon-picture"></span></a></td>
                    <td><a href="admin_propertyValue_edit?pid=${p.id}"><span
                            class="glyphicon glyphicon-th-list"></span></a></td>
 
                    <td><a href="admin_product_edit?id=${p.id}"><span
                            class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true"
                           href="admin_product_delete?id=${p.id}"><span
                            class="     glyphicon glyphicon-trash"></span></a></td>
 
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>
 
    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增产品</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_product_add">
                <table class="addTable">
                    <tr>
                        <td>产品名称</td>
                        <td><input id="name" name="name" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>产品小标题</td>
                        <td><input id="subTitle" name="subTitle" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>原价格</td>
                        <td><input id="originalPrice" value="99.98" name="originalPrice" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>优惠价格</td>
                        <td><input id="promotePrice"  value="19.98" name="promotePrice" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>库存</td>
                        <td><input id="stock"  value="99" name="stock" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="cid" value="${c.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑产品</title>
 
<script>
    $(function() {
        $("#editForm").submit(function() {
            if (!checkEmpty("name", "产品名称"))
                return false;
//          if (!checkEmpty("subTitle", "小标题"))
//              return false;
            if (!checkNumber("originalPrice", "原价格"))
                return false;
            if (!checkNumber("promotePrice", "优惠价格"))
                return false;
            if (!checkInt("stock", "库存"))
                return false;
            return true;
        });
    });
</script>
 
<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${p.category.id}">${p.category.name}</a></li>
        <li class="active">${p.name}</li>
        <li class="active">编辑产品</li>
    </ol>
 
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑产品</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_product_update">
                <table class="editTable">
                    <tr>
                        <td>产品名称</td>
                        <td><input id="name" name="name" value="${p.name}"
                                   type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>产品小标题</td>
                        <td><input id="subTitle" name="subTitle" type="text"
                                   value="${p.subTitle}"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>原价格</td>
                        <td><input id="originalPrice" value="${p.originalPrice}" name="originalPrice" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>优惠价格</td>
                        <td><input id="promotePrice"  value="${p.promotePrice}" name="promotePrice" type="text"
                                   class="form-control"></td>
                    </tr>
                    <tr>
                        <td>库存</td>
                        <td><input id="stock"  value="${p.stock}" name="stock" type="text"
                                   class="form-control"></td>
                    </tr>
 
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${p.id}">
                            <input type="hidden" name="cid" value="${p.category.id}">
                            <button type="submit" class="btn btn-success">提 交</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
```



### 6.3  产品图片管理

**ProductImage**直接使用自动生成的，没有变化

##### 01 ProductImageService

创建ProductImageService，提供CURD。

```Java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.ProductImage;
 
public interface ProductImageService {
 
    //两个常量，分别表示单个图片和详情图片：
    String type_single = "type_single";
    String type_detail = "type_detail";
 
    void add(ProductImage pi);
    void delete(int id);
    void update(ProductImage pi);
    ProductImage get(int id);
    //根据产品id和图片类型查询的list方法
    List list(int pid, String type);
}
```

##### 02 ProductImageServiceImpl

创建ProductImageServiceImpl，实现CURD相关方法

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.ProductImageMapper;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.pojo.ProductImageExample;
import com.how2java.tmall.service.ProductImageService;
 
@Service
public class ProductImageServiceImpl implements ProductImageService {
 
    @Autowired
    ProductImageMapper productImageMapper;
    @Override
    public void add(ProductImage pi) {
        productImageMapper.insert(pi);
    }
 
    @Override
    public void delete(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(ProductImage pi) {
        productImageMapper.updateByPrimaryKeySelective(pi);
 
    }
 
    @Override
    public ProductImage get(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }
 
    @Override
    public List list(int pid, String type) {
        ProductImageExample example =new ProductImageExample();
        //关于list方法，使用了ProductImageExample 类，这样的写法表示同时匹配pid和type。
        example.createCriteria()
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return productImageMapper.selectByExample(example);
    }
}
```

##### 03 ProductImageController

提供了list,add和delete方法

```java
package com.how2java.tmall.controller;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
 
@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    ProductService productService;
 
    @Autowired
    ProductImageService productImageService;
 
    @RequestMapping("admin_productImage_add")
    public String add(ProductImage  pi, HttpSession session, UploadedImageFile uploadedImageFile) {
        productImageService.add(pi);
        String fileName = pi.getId()+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder= session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small= session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle= session.getServletContext().getRealPath("img/productSingle_middle");
        }
        else{
            imageFolder= session.getServletContext().getRealPath("img/productDetail");
        }
 
        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();
        try {
            uploadedImageFile.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);
 
            if(ProductImageService.type_single.equals(pi.getType())) {
                File f_small = new File(imageFolder_small, fileName);
                File f_middle = new File(imageFolder_middle, fileName);
 
                ImageUtil.resizeImage(f, 56, 56, f_small);
                ImageUtil.resizeImage(f, 217, 190, f_middle);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }
 
    @RequestMapping("admin_productImage_delete")
    public String delete(int id,HttpSession session) {
        ProductImage pi = productImageService.get(id);
 
        String fileName = pi.getId()+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
 
        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder= session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small= session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle= session.getServletContext().getRealPath("img/productSingle_middle");
            File imageFile = new File(imageFolder,fileName);
            File f_small = new File(imageFolder_small,fileName);
            File f_middle = new File(imageFolder_middle,fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();
 
        }
        else{
            imageFolder= session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder,fileName);
            imageFile.delete();
        }
 
        productImageService.delete(id);
 
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }
 
    @RequestMapping("admin_productImage_list")
    public String list(int pid, Model model) {
        Product p =productService.get(pid);
        List<ProductImage> pisSingle = productImageService.list(pid, ProductImageService.type_single);
        List<ProductImage> pisDetail = productImageService.list(pid, ProductImageService.type_detail);
 
        model.addAttribute("p", p);
        model.addAttribute("pisSingle", pisSingle);
        model.addAttribute("pisDetail", pisDetail);
 
        return "admin/listProductImage";
    }
}
```

##### 04 listProductImage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
    $(function(){
        $(".addFormSingle").submit(function(){
            if(checkEmpty("filepathSingle","图片文件")){
                $("#filepathSingle").value("");
                return true;
            }
            return false;
        });
        $(".addFormDetail").submit(function(){
            if(checkEmpty("filepathDetail","图片文件"))
                return true;
            return false;
        });
    });
 
</script>
 
<title>产品图片管理</title>
 
<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${p.category.id}">${p.category.name}</a></li>
        <li class="active">${p.name}</li>
        <li class="active">产品图片管理</li>
    </ol>
 
    <table class="addPictureTable" align="center">
        <tr>
            <td class="addPictureTableTD">
                <div>
                    <div class="panel panel-warning addPictureDiv">
                        <div class="panel-heading">新增产品<b class="text-primary"> 单个 </b>图片</div>
                        <div class="panel-body">
                            <form method="post" class="addFormSingle" action="admin_productImage_add" enctype="multipart/form-data">
                                <table class="addTable">
                                    <tr>
                                        <td>请选择本地图片 尺寸400X400 为佳</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="filepathSingle" type="file" name="image" />
                                        </td>
                                    </tr>
                                    <tr class="submitTR">
                                        <td align="center">
                                            <input type="hidden" name="type" value="type_single" />
                                            <input type="hidden" name="pid" value="${p.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr class="success">
                            <th>ID</th>
                            <th>产品单个图片缩略图</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pisSingle}" var="pi">
                            <tr>
                                <td>${pi.id}</td>
                                <td>
                                    <a title="点击查看原图" href="img/productSingle/${pi.id}.jpg"><img height="50px" src="img/productSingle/${pi.id}.jpg"></a>
                                </td>
                                <td><a deleteLink="true"
                                       href="admin_productImage_delete?id=${pi.id}"><span
                                        class="     glyphicon glyphicon-trash"></span></a></td>
 
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
 
                </div>
            </td>
            <td class="addPictureTableTD">
                <div>
 
                    <div class="panel panel-warning addPictureDiv">
                        <div class="panel-heading">新增产品<b class="text-primary"> 详情 </b>图片</div>
                        <div class="panel-body">
                            <form method="post" class="addFormDetail" action="admin_productImage_add" enctype="multipart/form-data">
                                <table class="addTable">
                                    <tr>
                                        <td>请选择本地图片 宽度790  为佳</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="filepathDetail"  type="file" name="image" />
                                        </td>
                                    </tr>
                                    <tr class="submitTR">
                                        <td align="center">
                                            <input type="hidden" name="type" value="type_detail" />
                                            <input type="hidden" name="pid" value="${p.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr class="success">
                            <th>ID</th>
                            <th>产品详情图片缩略图</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pisDetail}" var="pi">
                            <tr>
                                <td>${pi.id}</td>
                                <td>
                                    <a title="点击查看原图" href="img/productDetail/${pi.id}.jpg"><img height="50px" src="img/productDetail/${pi.id}.jpg"></a>
                                </td>
                                <td><a deleteLink="true"
                                       href="admin_productImage_delete?id=${pi.id}"><span
                                        class="     glyphicon glyphicon-trash"></span></a></td>
 
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </td>
        </tr>
    </table>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```

![image-20200910094227242](https://img-blog.csdnimg.cn/20200924120221841.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

##### 05 Product

回到产品管理，在产品列表页面，是没有图片的。 因为当时还没有产品图片管理功能，现在支持了，所以需要对Product做一些调整。

新增属性:

```java
private ProductImage firstProductImage;
```

```java
package com.how2java.tmall.pojo;
 
import java.util.Date;
import java.util.List;
 
public class Product {
    private Integer id;
 
    private String name;
 
    private String subTitle;
 
    private Float originalPrice;
 
    private Float promotePrice;
 
    private Integer stock;
 
    private Integer cid;
 
    private Date createDate;
 
    /*非数据库字段*/
    private Category  category;
 
    private ProductImage firstProductImage;
 
    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }
 
    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
 
    public String getSubTitle() {
        return subTitle;
    }
 
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }
 
    public Float getOriginalPrice() {
        return originalPrice;
    }
 
    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }
 
    public Float getPromotePrice() {
        return promotePrice;
    }
 
    public void setPromotePrice(Float promotePrice) {
        this.promotePrice = promotePrice;
    }
 
    public Integer getStock() {
        return stock;
    }
 
    public void setStock(Integer stock) {
        this.stock = stock;
    }
 
    public Integer getCid() {
        return cid;
    }
 
    public void setCid(Integer cid) {
        this.cid = cid;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
}
```

##### 06 ProductService

新增方法：

```java
 void setFirstProductImage(Product p);
```

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
 
}
```



##### 07 ProductServiceImpl

增加方法 setFirstProductImage(Product p)：
根据pid和图片类型查询出所有的单个图片，然后把第一个取出来放在firstProductImage上。

增加方法 setFirstProductImage(List<Product> ps)
给多个产品设置图片

在get方法中调用setFirstProductImage(Product p) 为单个产品设置图片
在list方法中调用setFirstProductImage(List<Product> ps) 为多个产品设置图片

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
 
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setFirstProductImage(p);
        setCategory(p);
        return p;
    }
 
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
 
    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        setFirstProductImage(result);
        return result;
    }
 
    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
 
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
 
}
```

##### 08 listProduct.jsp

把注释去掉：

```jsp
 <c:if test="${!empty p.firstProductImage}">
     <img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg">
 </c:if>
```

### 6.4  产品属性值设置

##### 01 PropertyValue

为PropertyValue增加一个Property属性以及getter,setter

```java
package com.how2java.tmall.pojo;
 
public class PropertyValue {
    private Integer id;
 
    private Integer pid;
 
    private Integer ptid;
 
    private String value;
 
    /*非数据库字段*/
    private Property property;
 
    public Property getProperty() {
        return property;
    }
 
    public void setProperty(Property property) {
        this.property = property;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getPid() {
        return pid;
    }
 
    public void setPid(Integer pid) {
        this.pid = pid;
    }
 
    public Integer getPtid() {
        return ptid;
    }
 
    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}
```

##### 02 PropertyValueService

```java
package com.how2java.tmall.service;
 
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
 
import java.util.List;
 
public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);
 
    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}
```

##### 03 PropertyValueServiceImpl

PropertyValueServiceImpl实现了PropertyValueService：

1. get(int ptid, int pid)
   根据属性id和产品id获取PropertyValue对象
2. list(int pid)
   根据产品id获取所有的属性值
3. init方法
   3.1 这个方法的作用是初始化PropertyValue。 为什么要初始化呢？ 因为对于PropertyValue的管理，没有增加，只有修改。 所以需要通过初始化来进行自动地增加，以便于后面的修改。
   3.2 首先根据产品获取分类，然后获取这个分类下的所有属性集合
   3.3 然后用属性和id产品id去查询，看看这个属性和这个产品，是否已经存在属性值了。
   3.4 如果不存在，那么就创建一个属性值，并设置其属性和产品，接着插入到数据库中。
   这样就完成了属性值的初始化。
4. update（PropertyValue pv)
   更新

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.PropertyValueMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.pojo.PropertyValueExample;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
 
    @Autowired
    PropertyValueMapper propertyValueMapper;
 
    @Autowired
    PropertyService propertyService;
 
    @Override
    public void init(Product p) {
 
        List<Property> pts = propertyService.list(p.getCid());
 
        for (Property pt: pts) {
            PropertyValue pv = get(pt.getId(),p.getId());
            if(null==pv){
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }
 
    }
 
    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }
 
    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs= propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty())
            return null;
        return pvs.get(0);
    }
 
    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : result) {
            Property property = propertyService.get(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }
}
```

##### 04 PropertyValueController

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import java.util.List;
 
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;
 
    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model,int pid) {
        Product p = productService.get(pid);
        propertyValueService.init(p);
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
 
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "admin/editPropertyValue";
    }
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}
```

##### 05 editPropertyValue.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑产品属性值</title>
 
<script>
$(function() {
    $("input.pvValue").keyup(function(){
        var value = $(this).val();
        var page = "admin_propertyValue_update";
        var pvid = $(this).attr("pvid");
        var parentSpan = $(this).parent("span");
        parentSpan.css("border","1px solid yellow");
        $.post(
                page,
                {"value":value,"id":pvid},
                function(result){
                    if("success"==result)
                        parentSpan.css("border","1px solid green");
                    else
                        parentSpan.css("border","1px solid red");
                }
            );     
    });
});
</script>
 
<div class="workingArea">
    <ol class="breadcrumb">
      <li><a href="admin_category_list">所有分类</a></li>
      <li><a href="admin_product_list?cid=${p.category.id}">${p.category.name}</a></li>
      <li class="active">${p.name}</li>
      <li class="active">编辑产品属性</li>
    </ol>
     
    <div class="editPVDiv">
        <c:forEach items="${pvs}" var="pv">
            <div class="eachPV">
                <span class="pvName" >${pv.property.name}</span>
                <span class="pvValue"><input class="pvValue" pvid="${pv.id}" type="text" value="${pv.value}"></span>
            </div>
        </c:forEach>
    <div style="clear:both"></div> 
    </div>
     
</div>
```



### 6.5 用户管理

##### 01 User

User使用自动生成的，没变化

##### 02 UserService

新增接口UserService，提供CRUD一套

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.User;
 
public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
}
```

##### 03 UserServiceImpl

新建类UserServiceImpl，提供CURD一套

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
 
    @Override
    public void add(User u) {
        userMapper.insert(u);
    }
 
    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }
 
    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
 
    public List<User> list(){
        UserExample example =new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
 
    }
 
}
```

##### 04  UserController

新建UserController类，提供分页查询

```java
package com.how2java.tmall.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Page;
 
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
  
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
 
        List<User> us= userService.list();
 
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
 
        model.addAttribute("us", us);
        model.addAttribute("page", page);
 
        return "admin/listUser";
    }
 
}
```

##### 05 listUser.jsp

listUser.jsp页面

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
</script>
 
<title>用户管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >用户管理</h1>
 
    <br>
    <br>
 
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${us}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```



### 6.6 订单管理

##### 01  OrderItem

OrderItem在自动创建的基础上增加了一个product属性。 因为在订单管理页面需要看到订单下面的订单项里的产品图片。

```java
package com.how2java.tmall.pojo;
 
public class OrderItem {
    private Integer id;
 
    private Integer pid;
 
    private Integer oid;
 
    private Integer uid;
 
    private Integer number;
 
    /*非数据库字段*/
    private Product product;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getPid() {
        return pid;
    }
 
    public void setPid(Integer pid) {
        this.pid = pid;
    }
 
    public Integer getOid() {
        return oid;
    }
 
    public void setOid(Integer oid) {
        this.oid = oid;
    }
 
    public Integer getUid() {
        return uid;
    }
 
    public void setUid(Integer uid) {
        this.uid = uid;
    }
 
    public Integer getNumber() {
        return number;
    }
 
    public void setNumber(Integer number) {
        this.number = number;
    }
 
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
}
```



##### 02 Order.java

```java
package com.how2java.tmall.pojo;
 
import com.how2java.tmall.service.OrderService;
 
import java.util.Date;
import java.util.List;
 
public class Order {
    private Integer id;
 
    private String orderCode;
 
    private String address;
 
    private String post;
 
    private String receiver;
 
    private String mobile;
 
    private String userMessage;
 
    private Date createDate;
 
    private Date payDate;
 
    private Date deliveryDate;
 
    private Date confirmDate;
 
    private Integer uid;
 
    private String status;
 
    /*如下是非数据库字段*/
    //该订单下的订单项列表
    private List<OrderItem> orderItems;
    //该订单对应的用户
    private User user;
    //该订单的总计金额
    private float total;
    //该订单的总计数量
    private int totalNumber;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getOrderCode() {
        return orderCode;
    }
 
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
 
    public String getPost() {
        return post;
    }
 
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }
 
    public String getReceiver() {
        return receiver;
    }
 
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }
 
    public String getMobile() {
        return mobile;
    }
 
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
 
    public String getUserMessage() {
        return userMessage;
    }
 
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage == null ? null : userMessage.trim();
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
    public Date getPayDate() {
        return payDate;
    }
 
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
 
    public Date getDeliveryDate() {
        return deliveryDate;
    }
 
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
 
    public Date getConfirmDate() {
        return confirmDate;
    }
 
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
 
    public Integer getUid() {
        return uid;
    }
 
    public void setUid(Integer uid) {
        this.uid = uid;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
 
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
 
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
     
    public static void main(String args[]){
        Order o  = new Order();
        o.setStatus(OrderService.delete);
        System.out.println(o.getStatusDesc());
    }
    //getStatusDesc方法，用于把英文表达的Status信息转换为中文
    public String getStatusDesc(){
        String desc ="未知";
        switch(status){
            case OrderService.waitPay:
                desc="待付款";
                break;
            case OrderService.waitDelivery:
                desc="待发货";
                break;
            case OrderService.waitConfirm:
                desc="待收货";
                break;
            case OrderService.waitReview:
                desc="等评价";
                break;
            case OrderService.finish:
                desc="完成";
                break;
            case OrderService.delete:
                desc="刪除";
                break;
            default:
                desc="未知";
        }
        return desc;
    }
 
    public float getTotal() {
        return total;
    }
 
    public void setTotal(float total) {
        this.total = total;
    }
 
    public int getTotalNumber() {
        return totalNumber;
    }
 
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}
```

##### 03 OrderItemService

新建OrderItemService，声明CRUD一套，以及fill(Order order) 和fill(List<Order> orders) 

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
 
public interface OrderItemService {
      
    void add(OrderItem c);
 
    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();
 
    void fill(List<Order> os);
 
    void fill(Order o);
 
}
```

##### 04 OrderItemServiceImpl

OrderItemServiceImpl实现OrderItemService，提供CRUD一套方法的实现。

同时还提供fill(Order order)和fill(List<Order> orders), 先说fill(Order order) :
为什么要提供这个方法呢？ 因为在订单管理界面，首先是遍历多个订单，然后遍历这个订单下的多个订单项。 而由MybatisGenerator逆向工程所创建的一套自动生成代码，是不具备一对多关系的，需要自己去二次开发。 这里就是做订单与订单项的一对多关系。
在fill(Order order)中：

1. 根据订单id查询出其对应的所有订单项
2. 通过setProduct为所有的订单项设置Product属性
3. 遍历所有的订单项，然后计算出该订单的总金额和总数量
4. 最后再把订单项设置在订单的orderItems属性上。

在fill(List<Order> orders) 中，就是遍历每个订单，然后挨个调用fill(Order order)。

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.OrderItemMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.OrderItemExample;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductService;
 
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
 
    @Override
    public void add(OrderItem c) {
        orderItemMapper.insert(c);
    }
 
    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }
 
    public List<OrderItem> list(){
        OrderItemExample example =new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
 
    }
 
    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }
 
    public void fill(Order o) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        setProduct(ois);
 
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(ois);
 
    }
 
    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi: ois) {
            setProduct(oi);
        }
    }
 
    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        oi.setProduct(p);
    }
}
```



##### 05 OrderService

创建OrderService,提供CRUD一套，并提供订单状态的常量值

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
 
public interface OrderService {
 
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
 
    void add(Order c);
 
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List list();
}
```

##### 06 OrderServiceImpl

创建OrderServiceImpl ，实现CRUD一套方法

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.OrderMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderExample;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.UserService;
 
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
 
    @Autowired
    UserService userService;
 
    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }
 
    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }
 
    public List<Order> list(){
        OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result =orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }
    public void setUser(List<Order> os){
        for (Order o : os)
            setUser(o);
    }
    public void setUser(Order o){
        int uid = o.getUid();
        User u = userService.get(uid);
        o.setUser(u);
    }
 
}
```

##### 07 OrderController.java

因为订单的增加和删除，都是在前台进行的。 所以OrderController提供的是list方法和delivery(发货)方法

```java
package com.how2java.tmall.controller;
 
import java.io.IOException;
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.util.Page;
 
@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
 
    @RequestMapping("admin_order_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
 
        List<Order> os= orderService.list();
 
        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
        model.addAttribute("page", page);
 
        return "admin/listOrder";
    }
 
    @RequestMapping("admin_order_delivery")
    public String delivery(Order o) throws IOException {
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return "redirect:admin_order_list";
    }
}
```

##### 08 listOrder.jsp

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
    $(function(){
        $("button.orderPageCheckOrderItems").click(function(){
            var oid = $(this).attr("oid");
            $("tr.orderPageOrderItemTR[oid="+oid+"]").toggle();
        });
    });
 
</script>
 
<title>订单管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >订单管理</h1>
    <br>
    <br>
 
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover1  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>状态</th>
                <th>金额</th>
                <th width="100px">商品数量</th>
                <th width="100px">买家名称</th>
                <th>创建时间</th>
                <th>支付时间</th>
                <th>发货时间</th>
                <th>确认收货时间</th>
                <th width="120px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${os}" var="o">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.statusDesc}</td>
                    <td>￥<fmt:formatNumber type="number" value="${o.total}" minFractionDigits="2"/></td>
                    <td align="center">${o.totalNumber}</td>
                    <td align="center">${o.user.name}</td>
 
                    <td><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${o.confirmDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 
                    <td>
                        <button oid=${o.id} class="orderPageCheckOrderItems btn btn-primary btn-xs">查看详情</button>
 
                        <c:if test="${o.status=='waitDelivery'}">
                            <a href="admin_order_delivery?id=${o.id}">
                                <button class="btn btn-primary btn-xs">发货</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
                <tr class="orderPageOrderItemTR"  oid=${o.id}>
                    <td colspan="10" align="center">
 
                        <div  class="orderPageOrderItem">
                            <table width="800px" align="center" class="orderPageOrderItemTable">
                                <c:forEach items="${o.orderItems}" var="oi">
                                    <tr>
                                        <td align="left">
                                            <img width="40px" height="40px" src="img/productSingle/${oi.product.firstProductImage.id}.jpg">
                                        </td>
 
                                        <td>
                                            <a href="foreproduct?pid=${oi.product.id}">
                                                <span>${oi.product.name}</span>
                                            </a>
                                        </td>
                                        <td align="right">
 
                                            <span class="text-muted">${oi.number}个</span>
                                        </td>
                                        <td align="right">
 
                                            <span class="text-muted">单价：￥${oi.product.promotePrice}</span>
                                        </td>
 
                                    </tr>
                                </c:forEach>
 
                            </table>
                        </div>
 
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>
```

## 7 原型-前端

在开发功能之前，都会先有原型界面。 通常原型界面的数据不是真实的，是临时写在页面上，为用户提供一个直观的界面感受的。

原型的目的通常有两个：

1. 用于和客户沟通交流，一图胜千言，哪里可以保留，哪里需要修改，在原型界面的基础上，就可以高效率的沟通了。
2. 指导功能开发，有可视的原型界面，开发人员可以更准确的设计系统和功能，同时在设计系统的过程中，又能反过来验证是否支持这些界面上的功能。

<!--more-->

### 7.1  前台首页

前台也包括许多功能， 与后台-分类管理类似的，首先做前台-首页这个功能。

1. 前台无需登录
   从前台模块之间的依赖性，以及开发顺序的合理性来考虑，把前台功能分为了 无需登录 即可使用的功能，和需要登录 才能访问的功能。 建立在前一步前台-首页的基础之上，开始进行一系列的无需登录功能开发。

2. 前台需要登录
   接着是需要登录的前台功能。 这部分功能基本上都是和购物相关的。 因此，一开始先把购物流程 单独拿出来捋清楚，其中还特别注明了购物流程环节与表关系，这样能够更好的建立对前端购物功能的理解。随着这部分功能的开发，就会进入订单生成部分，在此之前，先准备了一个 订单状态图，在理解了这个图之后，可以更好的进行订单相关功能的开发。

##### 01 静态图片资源

下载地址：https://how2j.cn/frontdownload?bean.id=1515

解压到tmall-ssm\src\main\webapp\img

##### 02 ForeController1

专门用来对应前台页面的路径

![7-102](https://stepimagewm.how2j.cn/6551.png)



##### 03 home 方法

那么首页需要什么数据呢？ 从 **首页展示需求分析**上来看：

1. 在横向导航栏上提供4个分类连接

2. 在纵向导航栏上提供全部17个分类连接

3. 当鼠标移动到某一个纵向分类连接的时候，显示这个分类下的推荐产品列表

4. 按照每种分类显示5个商品的方式，显示所有17种分类

   

##### 04 Category

Category新增两个瞬时字段products和productsByRow。

```java
List<Product> products; //代表一个分类下有多个产品。
List<List<Product>> productsByRow;    
/*productsByRow这个属性的类型是List<List<Product>> productsByRow。
即一个分类又对应多个 List<Product>，提供这个属性，是为了在首页竖状导航的分类名称右边显示推荐产品列表。*/
```

一个分类会对应多行产品，而一行产品里又有多个产品记录。
为了实现界面上的这个功能，为Category类设计了
List<List<Product>> productsByRow
这样一个集合属性

![Category](https://img-blog.csdnimg.cn/20200924120221784.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

```java
package com.how2java.tmall.pojo;
 
import java.util.List;
 
public class Category {
    private Integer id;
 
    private String name;
 
    /*如下是非数据库字段*/
    private List<Product> products;
 
    private List<List<Product>> productsByRow;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
 
    public List<Product> getProducts() {
        return products;
    }
 
    public void setProducts(List<Product> products) {
        this.products = products;
    }
 
    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }
 
    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
}
```



##### 04 ProductService

ProductService新增加3个方法

```java
public void fill(List<Category> categorys);
public void fill(Category category);
public void fillByRow(List<Category> categorys);
```

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
 
    void fill(List<Category> cs);
 
    void fill(Category c);
 
    void fillByRow(List<Category> cs);
}
```

##### 05 ProductServiceImpl

为ProductService中新增加的三个方法提供实现。

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
 
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setFirstProductImage(p);
        setCategory(p);
        return p;
    }
 
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
 
    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        setFirstProductImage(result);
        return result;
    }
 
    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
 
    @Override
    //为分类填充产品集合
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
 
    @Override
    //为多个分类填充产品集合
    public void fill(Category c) {
        List<Product> ps = list(c.getId());
        c.setProducts(ps);
    }
 
    @Override
    //为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }
 
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
 
}
```

##### 06 ForeController2

home()方法映射首页访问路径 "forehome".

1. 查询所有分类
2. 为这些分类填充产品集合
3. 为这些分类填充推荐产品集合
4. 服务端跳转到home.jsp

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
}
```

##### 07 home.jsp

观察模仿天猫前端，可以发现前台页面有如下特点：

1. 有共同的置顶导航
2. 有共同的搜索栏
3. 有共同的页脚

根据这样的特点，在设计前台jsp页面的时候，就制作了很多**公共页面**，其他前台页面就共享这些公共页面，使得开发和维护成本降低不少

根据前台页面的特点，我们把home.jsp设计成如代码所示。

1. header.jsp
   引入标准标签库，js,css，自定义javascript函数等
2. top.jsp
   置顶导航
3. search.jsp
   搜索栏
4. homePage.jsp
   首页业务页面
5. footer.jsp
   页脚

![home.jsp 所包含页面](https://img-blog.csdnimg.cn/20200924120221757.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\home.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/search.jsp"%>
<%@include file="../include/fore/home/homePage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```



##### 08 header.jsp

声明为html5格式

```jsp
<!DOCTYPE html>
```

让浏览器以UTF显示中文，本页面的中文文字采用UTF-8编码，启动EL表达式

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
```

引入标准标签库

c通常用于条件判断和遍历
fmt用于格式化日期和货币
fn用于校验长度

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
```

引入bootstrap和jquery

```jsp
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
```

自定义前端样式

```jsp
<link href="css/fore/style.css" rel="stylesheet">
```

除了轮播和图标，前端几乎没用Bootstrap中的样式，所有的自定义样式都在这个文件里。



tmall_ssm \src\main\webapp\WEB-INF\jsp\include\fore\header.jsp

```jsp
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
 
<head>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/fore/style.css" rel="stylesheet">
<script>
function formatMoney(num){
    num = num.toString().replace(/\$|\,/g,''); 
    if(isNaN(num)) 
        num = "0"; 
    sign = (num == (num = Math.abs(num))); 
    num = Math.floor(num*100+0.50000000001); 
    cents = num%100; 
    num = Math.floor(num/100).toString(); 
    if(cents<10) 
    cents = "0" + cents; 
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++) 
    num = num.substring(0,num.length-(4*i+3))+','+ 
    num.substring(num.length-(4*i+3)); 
    return (((sign)?'':'-') + num + '.' + cents); 
}
function checkEmpty(id, name){
    var value = $("#"+id).val();
    if(value.length==0){
         
        $("#"+id)[0].focus();
        return false;
    }
    return true;
}
 
$(function(){
 
    $("a.productDetailTopReviewLink").click(function(){
        $("div.productReviewDiv").show();
        $("div.productDetailDiv").hide();
    });
    $("a.productReviewTopPartSelectedLink").click(function(){
        $("div.productReviewDiv").hide();
        $("div.productDetailDiv").show();      
    });
     
    $("span.leaveMessageTextareaSpan").hide();
    $("img.leaveMessageImg").click(function(){
         
        $(this).hide();
        $("span.leaveMessageTextareaSpan").show();
        $("div.orderItemSumDiv").css("height","100px");
    });
     
    $("div#footer a[href$=#nowhere]").click(function(){
        alert("模仿天猫的连接，并没有跳转到实际的页面");
    });
     
    $("a.wangwanglink").click(function(){
        alert("模仿旺旺的图标，并不会打开旺旺");
    });
    $("a.notImplementLink").click(function(){
        alert("这个功能没做，蛤蛤~");
    });
     
});
 
</script>
</head>
 
<body>
```

##### 09 top.jsp

tmall_ssm \src\main\webapp\WEB-INF\jsp\include\fore\top.jsp

**置顶导航页面**
这里会根据用户是否登录，决定是否显示退出按钮，或者登录注册按钮，以及购物车中的商品数量。

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
 
<nav class="top ">
    <a href="${contextPath}">
        <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
        天猫首页
    </a>
 
    <span>喵，欢迎来天猫</span>
 
    <c:if test="${!empty user}">
        <a href="loginPage">${user.name}</a>
        <a href="forelogout">退出</a>
    </c:if>
 
    <c:if test="${empty user}">
        <a href="loginPage">请登录</a>
        <a href="registerPage">免费注册</a>
    </c:if>
 
    <span class="pull-right">
            <a href="forebought">我的订单</a>
            <a href="forecart">
            <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
            购物车<strong>${cartTotalItemNumber}</strong>件</a>
        </span>
 
</nav>
```

##### 10 search.jsp

这里会从request的属性"cs" 中获取到分类集合，并取第5个到第8个，一共4个来显示。

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
    <a href="${contextPath}">
        <img id="logo" src="img/site/logo.gif" class="logo">
    </a>
     
    <form action="foresearch" method="post" >
        <div class="searchDiv">
            <input name="keyword" type="text" placeholder="时尚男鞋  太阳镜 ">
            <button  type="submit" class="searchButton">搜索</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=5 and st.count<=8}">
                        <span>
                            <a href="forecategory?cid=${c.id}">
                                ${c.name}
                            </a>
                            <c:if test="${st.count!=8}">             
                                <span>|</span>             
                            </c:if>
                        </span>          
                    </c:if>
                </c:forEach>     
            </div>
        </div>
    </form>  
```

##### 11 footer.jsp

页脚部分

1. tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\footer.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
           pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="modal.jsp" %>
   
  <div id="footer"  class="footer" style="display: block;">
   
      <div id="footer_ensure" class="footer_ensure">
          <a href="#nowhere">
              <img src="img/site/ensure.png">
          </a>
      </div>
   
      <div class="horizontal_line">
      </div>
   
      <div id="footer_desc" class="footer_desc">
          <div class="descColumn">
              <span class="descColumnTitle">购物指南</span>
              <a href="#nowhere" >免费注册</a>
              <a href="#nowhere" >开通支付宝</a>
              <a href="#nowhere" >支付宝充值</a>
          </div>
          <div class="descColumn">
              <span class="descColumnTitle">天猫保障</span>
              <a href="#nowhere" >发票保障</a>
              <a href="#nowhere" >售后规则</a>
              <a href="#nowhere" >缺货赔付</a>
          </div>
          <div class="descColumn">
              <span class="descColumnTitle">支付方式</span>
              <a href="#nowhere" >快捷支付</a>
              <a href="#nowhere" >信用卡</a>
              <a href="#nowhere" >蚂蚁花呗</a>
              <a href="#nowhere" >货到付款</a>
          </div>
          <div class="descColumn">
              <span class="descColumnTitle">商家服务</span>
              <a href="#nowhere" >商家入驻</a>
              <a href="#nowhere" >商家中心</a>
              <a href="#nowhere" >天猫智库</a>
              <a href="#nowhere" >天猫规则</a>
              <a href="#nowhere" >物流服务</a>
              <a href="#nowhere" >喵言喵语</a>
              <a href="#nowhere" >运营服务</a>
          </div>
          <div class="descColumn">
              <span class="descColumnTitle">手机天猫</span>
              <a href="#nowhere" ><img src="img/site/ma.png"></a>
          </div>
   
      </div>
   
      <div style="clear:both">
   
      </div>
   
      <div id="copyright" class="copyright">
          <div class="coptyrightMiddle">
              <img id="cateye" class="cateye" src="img/site/cateye.png">
              <div class="white_link" >
                  <a href="#nowhere" style="padding-left:0px" >关于天猫</a>
                  <a href="#nowhere" > 帮助中心</a>
                  <a href="#nowhere" >开放平台</a>
                  <a href="#nowhere" >  诚聘英才</a>
                  <a href="#nowhere" >联系我们</a>
                  <a href="#nowhere" >网站合作</a>
                  <a href="#nowhere" >法律声明</a>
                  <a href="#nowhere" >知识产权</a>
                  <a href="#nowhere" >  廉正举报    </a>
              </div>
              <div class="white_link" >
                  <a href="#nowhere"  style="padding-left:0px" > 阿里巴巴集团</a><span class="slash">|</span>
                  <a href="#nowhere" > 淘宝网</a><span class="slash">|</span>
                  <a href="#nowhere" >天猫 </a><span class="slash">|</span>
                  <a href="#nowhere" >  聚划算</a><span class="slash">|</span>
                  <a href="#nowhere" >全球速卖通</a><span class="slash">|</span>
                  <a href="#nowhere" >阿里巴巴国际交易市场</a><span class="slash">|</span>
                  <a href="#nowhere" >1688</a><span class="slash">|</span>
                  <a href="#nowhere" >阿里妈妈</a><span class="slash">|</span>
                  <a href="#nowhere" >  阿里旅行·去啊 </a><span class="slash">|</span>
                  <a href="#nowhere" >  阿里云计算   </a><span class="slash">|</span>
                  <a href="#nowhere" >  阿里通信    </a><span class="slash">|</span>
                  <a href="#nowhere" >  YunOS   </a><span class="slash">|</span>
                  <a href="#nowhere" >  阿里旅行·去啊 </a><span class="slash">|</span>
                  <a href="#nowhere" >   万网 </a><span class="slash">|</span>
                  <a href="#nowhere" >  高德  </a><span class="slash">|</span>
                  <a href="#nowhere" > 优视   </a><span class="slash">|</span>
                  <a href="#nowhere" >  友盟  </a><span class="slash">|</span>
                  <a href="#nowhere" >  虾米  </a><span class="slash">|</span>
                  <a href="#nowhere" >  天天动听    </a><span class="slash">|</span>
                  <a href="#nowhere" >  来往  </a><span class="slash">|</span>
                  <a href="#nowhere" >  钉钉  </a><span class="slash">|</span>
                  <a href="#nowhere" >  支付宝         </a>
              </div>
   
              <div class="license">
                  <span>增值电信业务经营许可证： 浙B2-20110446</span>
                  <span>网络文化经营许可证：浙网文[2015]0295-065号</span>
                  <span>互联网医疗保健信息服务 审核同意书 浙卫网审【2014】6号 </span>
                  <span>互联网药品信息服务资质证书编号：浙-（经营性）-2012-0005</span>
                  <div class="copyRightYear">© 2003-2016 TMALL.COM 版权所有</div>
                  <div>
                      <img src="img/site/copyRight1.jpg">
                      <img src="img/site/copyRight2.jpg">
                  </div>
              </div>
          </div>
      </div>
  </div>
  </body>
  </html>
  ```

  

  除了显示页脚的静态信息外，还包含了modal.jsp

  这个modal.jsp里提供了两个模态窗口

    1. 登录模态窗口
    
    当用户在未登录状态，于产品页点击购买的时候会弹出
    
    2. 删除模态窗口
    
    当用户在我的订单页面,和购物车页面进行删除操作的时候，就会弹出模态删除窗口。

  tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\modal.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <div class="modal " id="loginModal" tabindex="-1" role="dialog" >
      <div class="modal-dialog loginDivInProductPageModalDiv">
              <div class="modal-content">
                      <div class="loginDivInProductPage">
                          <div class="loginErrorMessageDiv">
                              <div class="alert alert-danger" >
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                                  <span class="errorMessage"></span>
                              </div>
                          </div>
                               
                          <div class="login_acount_text">账户登录</div>
                          <div class="loginInput " >
                              <span class="loginInputIcon ">
                                  <span class=" glyphicon glyphicon-user"></span>
                              </span>
                              <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">        
                          </div>
                           
                          <div class="loginInput " >
                              <span class="loginInputIcon ">
                                  <span class=" glyphicon glyphicon-lock"></span>
                              </span>
                              <input id="password" name="password"  type="password" placeholder="密码">          
                          </div>
                                      <span class="text-danger">不要输入真实的天猫账号密码</span><br><br>
                          <div>
                              <a href="#nowhere">忘记登录密码</a>
                              <a href="register.jsp" class="pull-right">免费注册</a>
                          </div>
                          <div style="margin-top:20px">
                              <button class="btn btn-block redButton loginSubmitButton" type="submit">登录</button>
                          </div>
                      </div>   
            </div>
      </div>
  </div>
   
  <div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
      <div class="modal-dialog deleteConfirmModalDiv">
         <div class="modal-content">
            <div class="modal-header">
              <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title">确认删除？</h4>
            </div>
            <div class="modal-footer">
              <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
              <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
            </div>
          </div>
        </div>
      </div>
  </div>
  ```

  



##### 12.homePage.jsp

首页业务页面

在homePage中要显示如下内容
1 天猫超市连接右侧有4个分类数据
2 竖状导航栏显示17个分类数据
3 每个分类又再对应不同的推荐产品集合
4 中部会显示17个分类
5 每个分类又显示前5款产品
6 每款产品又会显示第一张图片，标题，价格等信息

倘若把这些功能都在一个jsp中开发出来看，那么这个jsp就会变得非常的长，并且难以维护和扩展。在这里，就可以借鉴home.jsp的思路，把一个大的页面，拆成各个小的jsp，这样维护起来就相对容易了

tmall_ssm \src\main\webapp\WEB-INF\jsp\include\fore\home

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<title>模仿天猫官网</title>
 
<div class="homepageDiv">
    <%@include file="categoryAndcarousel.jsp"%>
    <%@include file="homepageCategoryProducts.jsp"%> 
</div>
```

![homePage.jsp 所包含页面关系](https://img-blog.csdnimg.cn/20200924120221753.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

1. categoryAndcarousel.jsp
   分类和轮播
   1.1 categoryMenu.jsp
   竖状分类菜单
   1.2 productsAsideCategorys.jsp
   竖状分类菜单右侧的推荐产品列表
   1.3 carousel.jsp
   轮播
2. homepageCategoryProducts.jsp
   总体17种分类以及每种分类对应的5个产品



##### 13 categoryAndcarousel.jsp

categoryAndcarousel.jsp 页面利用ForeController传递过来的数据，天猫国际几个字旁边显示4个分类超链
另外包含了其他3个页面：
categoryMenu.jsp
productsAsideCategorys.jsp
carousel.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
function showProductsAsideCategorys(cid){
    $("div.eachCategory[cid="+cid+"]").css("background-color","white");
    $("div.eachCategory[cid="+cid+"] a").css("color","#87CEFA");
    $("div.productsAsideCategorys[cid="+cid+"]").show();
}
 
function hideProductsAsideCategorys(cid){
    $("div.eachCategory[cid="+cid+"]").css("background-color","#e2e2e3");
    $("div.eachCategory[cid="+cid+"] a").css("color","#000");
    $("div.productsAsideCategorys[cid="+cid+"]").hide();
}
$(function(){
    $("div.eachCategory").mouseenter(function(){
        var cid = $(this).attr("cid");
        showProductsAsideCategorys(cid);
    });
    $("div.eachCategory").mouseleave(function(){
        var cid = $(this).attr("cid");
        hideProductsAsideCategorys(cid);
    });
    $("div.productsAsideCategorys").mouseenter(function(){
        var cid = $(this).attr("cid");
        showProductsAsideCategorys(cid);
    });
    $("div.productsAsideCategorys").mouseleave(function(){
        var cid = $(this).attr("cid");
        hideProductsAsideCategorys(cid);
    });
     
    $("div.rightMenu span").mouseenter(function(){
        var left = $(this).position().left;
        var top = $(this).position().top;
        var width = $(this).css("width");
        var destLeft = parseInt(left) + parseInt(width)/2;
        $("img#catear").css("left",destLeft);
        $("img#catear").css("top",top-20);
        $("img#catear").fadeIn(500);
                 
    });
    $("div.rightMenu span").mouseleave(function(){
        $("img#catear").hide();
    });
     
    var left = $("div#carousel-of-product").offset().left;
    $("div.categoryMenu").css("left",left-20);
    $("div.categoryWithCarousel div.head").css("margin-left",left);
    $("div.productsAsideCategorys").css("left",left-20);
     
});
</script>
 
<img src="img/site/catear.png" id="catear" class="catear"/>
     
<div class="categoryWithCarousel">
 
<div class="headbar show1">
    <div class="head ">
     
        <span style="margin-left:10px" class="glyphicon glyphicon-th-list"></span>
        <span style="margin-left:10px" >商品分类</span>
         
    </div>
     
    <div class="rightMenu">
        <span><a href=""><img src="img/site/chaoshi.png"/></a></span>
        <span><a href=""><img src="img/site/guoji.png"/></a></span>
 
        <c:forEach items="${cs}" var="c" varStatus="st">
            <c:if test="${st.count<=4}">
                <span>
                <a href="forecategory?cid=${c.id}">
                    ${c.name}
                </a></span>        
            </c:if>
        </c:forEach>
    </div>
     
</div>
 
<div style="position: relative">
    <%@include file="categoryMenu.jsp" %>
</div>
 
<div style="position: relative;left: 0;top: 0;">
    <%@include file="productsAsideCategorys.jsp" %>
</div>
 
<%@include file="carousel.jsp" %>
 
<div class="carouselBackgroundDiv">
</div>
 
</div>
```



##### 14 categoryMenu.jsp

categoryMenu.jsp 显示左侧的竖状分类导航

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div class="categoryMenu">
        <c:forEach items="${cs}" var="c">
            <div cid="${c.id}" class="eachCategory">
                <span class="glyphicon glyphicon-link"></span>
                <a href="forecategory?cid=${c.id}">
                    ${c.name}
                </a>
            </div>
        </c:forEach>
    </div> 
```



##### 15 productsAsideCategorys.jsp

productsAsideCategorys.jsp 进行了三层遍历

1. 先取出每个分类
2. 然后取出每个分类的productsByRow集合
3. 根据productsByRow集合，取出每个产品，把产品的subTitle信息里的第一个单词取出来显示。

JQuery代码解释：

这个是用于随机挑选一个产品作为推荐产品，来进行高亮显示。 严格的说，应该是后台设置那个产品是推荐产品，不过这里偷懒了，直接在前端按照20%的概率，随机挑选了一个产品。

```jsp
$("div.productsAsideCategorys div.row a").each(function(){
	var v = Math.round(Math.random() *6);
	if(v == 1)
		$(this).css("color","#87CEFA");
});
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
$(function(){
    $("div.productsAsideCategorys div.row a").each(function(){
        var v = Math.round(Math.random() *6);
        if(v == 1)
            $(this).css("color","#87CEFA");
    });
});
 
</script>
<c:forEach items="${cs}" var="c">
    <div cid="${c.id}" class="productsAsideCategorys">
      
        <c:forEach items="${c.productsByRow}" var="ps">
            <div class="row show1">
                <c:forEach items="${ps}" var="p">
                    <c:if test="${!empty p.subTitle}">
                        <a href="foreproduct?pid=${p.id}">
                            <c:forEach items="${fn:split(p.subTitle, ' ')}" var="title" varStatus="st">
                                <c:if test="${st.index==0}">
                                    ${title}
                                </c:if>
                            </c:forEach>
                        </a>
                    </c:if>
                </c:forEach>
                <div class="seperator"></div>
            </div>       
        </c:forEach>
    </div>           
</c:forEach>
    
```



##### 16 carousel.jsp

轮播部分，都是静态的页面，没有用到服务端数据

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div id="carousel-of-product"  class="carousel-of-product carousel slide1" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-of-product" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-of-product" data-slide-to="1"></li>
    <li data-target="#carousel-of-product" data-slide-to="2"></li>
    <li data-target="#carousel-of-product" data-slide-to="3"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img class="carousel carouselImage" src="img/lunbo/1.jpg" >
    </div>
    <div class="item">
      <img  class="carouselImage" src="img/lunbo/2.jpg" >
    </div>
    <div class="item">
        <img  class="carouselImage" src="img/lunbo/3.jpg" >
    </div>
 
    <div class="item">
        <img  class="carouselImage" src="img/lunbo/4.jpg" >
    </div>
 
  </div>
 
  <!-- Controls -->
<!--   <a class="left carousel-control" href="#carousel-of-product" role="button" data-slide="prev"> -->
<!--     <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> -->
 
<!--   </a> -->
<!--   <a class="right carousel-control" href="#carousel-of-product" role="button" data-slide="next"> -->
<!--     <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> -->
 
<!--   </a> -->
 
</div>   
```



##### 17 homepageCategoryProducts.jsp

homepageCategoryProducts.jsp 进行了2次遍历

1. 遍历所有的分类，取出每个分类对象
2. 遍历分类对象的products集合，取出每个产品，然后显示该产品的标题，图片，价格等信息

```jsp
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>
 
<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>
 
<div class="homepageCategoryProducts">
    <c:forEach items="${cs}" var="c" varStatus="stc">
        <c:if test="${stc.count<=categorycount}">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">${c.name}</span>
                <br>
                <c:forEach items="${c.products}" var="p" varStatus="st">
                    <c:if test="${st.count<=5}">
                        <div class="productItem" >
                            <a href="foreproduct?pid=${p.id}"><img width="100px" src="img/productSingle_middle/${p.firstProductImage.id}.jpg"></a>
                            <a class="productItemDescLink" href="foreproduct?pid=${p.id}">
                                <span class="productItemDesc">[热销]
                                ${fn:substring(p.name, 0, 20)}
                                </span>
                            </a>
                            <span class="productPrice">
                                <fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
                            </span>
                        </div>
                    </c:if>              
                </c:forEach>
                <div style="clear:both"></div>
            </div>
        </c:if>
    </c:forEach>
     
    <img id="endpng" class="endpng" src="img/site/end.png">
 
</div>
```



虽然首页显示的内容非常多，可以说是前端里最复杂的一个展示页面，但是通过这种拆成小块jsp的思路，每个jsp页面的功能就相对单一了。 可以更好的帮助大家理解。

![image-20200913085921389](https://img-blog.csdnimg.cn/20200924120222236.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

### 7.2 前台无需登录

通过前台-首页的学习，就把前台的思路都理顺了，包括jsp页面的包含关系等。在此基础上，学习其他前台页面就更加容易理解了。
根据模仿天猫的前台功能特点，我们把前台功能分为两部分

1. 无需登录
   有一些功能，无需登录也可以使用的，比如登录，注册本身，分类页面，查询，产品页面等
2. 需要登录
   有一些功能，必须建立在已经登录的基础之上，比如购买，加入购物车，查看购物车，结算页面，订单页面等等。

接下来先讲解无需登录的功能，然后再是需要登录的前台功能。

<!--more-->

#### 7.2.1 注册

##### 01  register.jsp

与首页的home.jsp相仿，register.jsp也包含了header.jsp,top.jsp,footer.jsp等公共页面。
不同的是，没有使用首页的search.jsp,而是用的简单一点的 simpleSearch.jsp

中间是注册业务页面registerPage.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\register.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/simpleSearch.jsp"%>
<%@include file="../include/fore/registerPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

##### 02 PageController

register.jsp 是放在WEB-INF目录下的，是无法通过浏览器直接访问的。 为了访问这些放在WEB-INF下的jsp，准备一个专门的PageController类，专门做**服务端跳转**。 比如访问registerPage，就会服务端跳转到WEB-INF/jsp/fore/register.jsp 去，这样就解决了无法被访问的问题。

这个类很简单，就是单纯用来做服务端跳转用的。

```java
package com.how2java.tmall.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }
    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
}
```

##### 03 simpleSearch.jsp

与首页的search.jsp不太一样的是，这个搜索栏要更简单一些，并且左右分开。

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div >
    <a href="${contextPath}">
        <img id="simpleLogo" class="simpleLogo" src="img/site/simpleLogo.png">   
    </a>
     
    <form action="foresearch" method="post" >
    <div class="simpleSearchDiv pull-right">
        <input type="text" placeholder="平衡车 原汁机" name="keyword">
        <button class="searchButton" type="submit">搜天猫</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count>=8 and st.count<=11}">
                    <span>
                        <a href="forecategory?cid=${c.id}">
                            ${c.name}
                        </a>
                        <c:if test="${st.count!=11}">            
                            <span>|</span>             
                        </c:if>
                    </span>          
                </c:if>
            </c:forEach>         
        </div>
    </div>
    </form>
    <div style="clear:both"></div>
</div>
```

##### 04 registerPage.jsp

注册页面的主体功能，用于提交账号密码。 在提交之前会进行为空验证，以及密码是否一致验证。

这段代码用于当账号提交到服务端，服务端判断当前账号已经存在的情况下，显示返回的错误提示 "用户名已经被使用,不能使用"

```jsp
<c:if test="${!empty msg}">
$("span.errorMessage").html("${msg}");
$("div.registerErrorMessageDiv").css("visibility","visible");		
</c:if>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
$(function(){
     
    <c:if test="${!empty msg}">
    $("span.errorMessage").html("${msg}");
    $("div.registerErrorMessageDiv").css("visibility","visible");      
    </c:if>
     
    $(".registerForm").submit(function(){
        if(0==$("#name").val().length){
            $("span.errorMessage").html("请输入用户名");
            $("div.registerErrorMessageDiv").css("visibility","visible");          
            return false;
        }      
        if(0==$("#password").val().length){
            $("span.errorMessage").html("请输入密码");
            $("div.registerErrorMessageDiv").css("visibility","visible");          
            return false;
        }      
        if(0==$("#repeatpassword").val().length){
            $("span.errorMessage").html("请输入重复密码");
            $("div.registerErrorMessageDiv").css("visibility","visible");          
            return false;
        }      
        if($("#password").val() !=$("#repeatpassword").val()){
            $("span.errorMessage").html("重复密码不一致");
            $("div.registerErrorMessageDiv").css("visibility","visible");          
            return false;
        }      
 
        return true;
    });
})
</script>
 
<form method="post" action="foreregister" class="registerForm">
 
<div class="registerDiv">
    <div class="registerErrorMessageDiv">
        <div class="alert alert-danger" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
            <span class="errorMessage"></span>
        </div>       
    </div>
 
    <table class="registerTable" align="center">
        <tr>
            <td  class="registerTip registerTableLeftTD">设置会员名</td>
            <td></td>
        </tr>
        <tr>
            <td class="registerTableLeftTD">登陆名</td>
            <td  class="registerTableRightTD"><input id="name" name="name" placeholder="会员名一旦设置成功，无法修改" > </td>
        </tr>
        <tr>
            <td  class="registerTip registerTableLeftTD">设置登陆密码</td>
            <td  class="registerTableRightTD">登陆时验证，保护账号信息</td>
        </tr>    
        <tr>
            <td class="registerTableLeftTD">登陆密码</td>
            <td class="registerTableRightTD"><input id="password" name="password" type="password"  placeholder="设置你的登陆密码" > </td>
        </tr>
        <tr>
            <td class="registerTableLeftTD">密码确认</td>
            <td class="registerTableRightTD"><input id="repeatpassword" type="password"   placeholder="请再次输入你的密码" > </td>
        </tr>
                 
        <tr>
            <td colspan="2" class="registerButtonTD">
                <a href="registerSuccess.jsp"><button>提   交</button></a>
            </td>
        </tr>            
    </table>
</div>
</form>
```

##### 05 UserService

UserService新增加isExist(String name)方法

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.User;
 
public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);
}
```



##### 06 UserServiceImpl

UserServiceImpl 新增isExist(String name)的实现，判断某个名称是否已经被使用过了。

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
 
    @Override
    public void add(User u) {
        userMapper.insert(u);
    }
 
    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }
 
    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
 
    public List<User> list(){
        UserExample example =new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
 
    }
 
    @Override
    public boolean isExist(String name) {
        UserExample example =new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> result= userMapper.selectByExample(example);
        if(!result.isEmpty())
            return true;
        return false;
 
    }
 
}
```

##### 07 ForeController.register()

registerPage.jsp 的form提交数据到路径 foreregister,导致ForeController.register()方法被调用

1. 通过参数User获取浏览器提交的账号密码
2. 通过HtmlUtils.htmlEscape(name);把账号里的特殊符号进行转义
3. 判断用户名是否存在
   3.1 如果已经存在，就服务端跳转到reigster.jsp，并且带上错误提示信息
   3.2 如果不存在，则加入到数据库中，并服务端跳转到registerSuccess.jsp页面

注为什么要用 HtmlUtils.htmlEscape？ 因为在恶意注册的时候，会使用诸如 <script>alert('papapa')</script> 这样的名称，会导致网页打开就弹出一个对话框。 那么在转义之后，就没有这个问题了。
注 model.addAttribute("user", null); 这句话的用处是当用户存在，服务端跳转到register.jsp的时候不带上参数user, 否则当注册失败的时候，会在原本是“请登录”的超链位置显示刚才注册的名称。

ForeController.java

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;
 
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
   @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
            model.addAttribute("user", null);
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
 
}
```

##### 08 registerSuccess.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\registerSuccess.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/simpleSearch.jsp"%>
<%@include file="../include/fore/registerSuccessPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

##### 09 registerSuccessPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="registerSuccessDiv">
     
        <img src="img/site/registerSuccess.png">
            恭喜注册成功
</div>
```

http://localhost:8080/tmall_ssm/foreregister

#### 7.2.2  登录

##### 01 login.jsp

与register.jsp相仿，login.jsp也包含了header.jsp,footer.jsp等公共页面。
中间是登录业务页面loginPage.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\login.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/loginPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

##### 02 UserService

增加get(String name, String password)方法

```java
package com.how2java.tmall.service;
 
import java.util.List;
import com.how2java.tmall.pojo.User;
public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);
 
    User get(String name, String password);
}
```

##### 03 UserServiceImpl

增加User get(String name, String password) 方法

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
 
    @Override
    public void add(User u) {
        userMapper.insert(u);
    }
 
    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }
 
    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
 
    public List<User> list(){
        UserExample example =new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
 
    }
 
    @Override
    public boolean isExist(String name) {
        UserExample example =new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> result= userMapper.selectByExample(example);
        if(!result.isEmpty())
            return true;
        return false;
 
    }
 
    @Override
    public User get(String name, String password) {
        UserExample example =new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> result= userMapper.selectByExample(example);
        if(result.isEmpty())
            return null;
        return result.get(0);
    }
 
}
```

##### 04 loginPage.jsp

登陆业务页面，用于向服务器提交账号和密码

与registerPage.jsp类似的，用于显示登录密码错误

```
<c:if test="${!empty msg}">
$("span.errorMessage").html("${msg}");
$("div.loginErrorMessageDiv").show();		
</c:if>
```

其他js函数是用于为空验证

tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\loginPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
    $(function(){
 
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>
 
        $("form.loginForm").submit(function(){
            if(0==$("#name").val().length||0==$("#password").val().length){
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });
 
        $("form.loginForm input").keyup(function(){
            $("div.loginErrorMessageDiv").hide();
        });
 
        var left = window.innerWidth/2+162;
        $("div.loginSmallDiv").css("left",left);
    })
</script>
 
<div id="loginDiv" style="position: relative">
 
    <div class="simpleLogo">
        <a href="${contextPath}"><img src="img/site/simpleLogo.png"></a>
    </div>
 
    <img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackground.png">
 
    <form class="loginForm" action="forelogin" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv">
            <div class="loginErrorMessageDiv">
                <div class="alert alert-danger" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>
 
            <div class="login_acount_text">账户登录</div>
            <div class="loginInput " >
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-user"></span>
                </span>
                <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
            </div>
 
            <div class="loginInput " >
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-lock"></span>
                </span>
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>
            <span class="text-danger">不要输入真实的天猫账号密码</span><br><br>
 
            <div>
                <a class="notImplementLink" href="#nowhere">忘记登录密码</a>
                <a href="registerPage" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit">登录</button>
            </div>
        </div>
    </form>
 
</div>   
```



##### 05 ForeController.login()

loginPage.jsp的form提交数据到路径 forelogin,导致ForeController.login()方法被调用

```java
@RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
}
```

1. 获取账号密码
2. 把账号通过HtmlUtils.htmlEscape进行转义
3. 根据账号和密码获取User对象
   3.1 如果对象为空，则服务端跳转回login.jsp，也带上错误信息，并且使用 loginPage.jsp 中的办法显示错误信息
   3.2 如果对象存在，则把对象保存在session中，并客户端跳转到首页"forehome"
   注 为什么要用 HtmlUtils.htmlEscape？ 因为注册的时候，ForeController.register()，就进行了转义，所以这里也需要转义。有些同学在恶意注册的时候，会使用诸如 <script>alert('papapa')</script> 这样的名称，会导致网页打开就弹出一个对话框。 那么在转义之后，就没有这个问题了。

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
}
```

![image-20200913113148054](https://img-blog.csdnimg.cn/20200924120222406.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



#### 7.2.3 退出

在登录成功后，点击置顶导航的退出

通过访问退出路径：

http://127.0.0.1:8080/tmall_ssm/forelogout

导致ForeController.logout()方法被调用

##### 01 ForeController.logout()

```java
@RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user"); //在session中去掉"user"
        return "redirect:forehome"; //客户端跳转到首页:
    }
}
```

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
}
```



#### 7.2.4 产品页

##### 01 Product

```java
package com.how2java.tmall.pojo;
 
import java.util.Date;
import java.util.List;
 
public class Product {
    private Integer id;
 
    private String name;
 
    private String subTitle;
 
    private Float originalPrice;
 
    private Float promotePrice;
 
    private Integer stock;
 
    private Integer cid;
 
    private Date createDate;
 
    /*非数据库字段*/
    private Category  category;
 
    private ProductImage firstProductImage;
 
    private List<ProductImage> productSingleImages; //单个产品图片集合
 
    private List<ProductImage> productDetailImages; //详情产品图片集合
 
    private int saleCount; //销量
 
    private int reviewCount; //累计评价
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
 
    public String getSubTitle() {
        return subTitle;
    }
 
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }
 
    public Float getOriginalPrice() {
        return originalPrice;
    }
 
    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }
 
    public Float getPromotePrice() {
        return promotePrice;
    }
 
    public void setPromotePrice(Float promotePrice) {
        this.promotePrice = promotePrice;
    }
 
    public Integer getStock() {
        return stock;
    }
 
    public void setStock(Integer stock) {
        this.stock = stock;
    }
 
    public Integer getCid() {
        return cid;
    }
 
    public void setCid(Integer cid) {
        this.cid = cid;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }
 
    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }
 
    public List<ProductImage> getProductSingleImages() {
        return productSingleImages;
    }
 
    public void setProductSingleImages(List<ProductImage> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }
 
    public List<ProductImage> getProductDetailImages() {
        return productDetailImages;
    }
 
    public void setProductDetailImages(List<ProductImage> productDetailImages) {
        this.productDetailImages = productDetailImages;
    }
 
    public int getSaleCount() {
        return saleCount;
    }
 
    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }
 
    public int getReviewCount() {
        return reviewCount;
    }
 
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
}
```



##### 02  Review

修改自动生成的评价类Review, 增加User属性

```java
private User user;
```

```java
package com.how2java.tmall.pojo;
 
import java.util.Date;
 
public class Review {
    private Integer id;
 
    private String content;
 
    private Integer uid;
 
    private Integer pid;
 
    private Date createDate;
    /*非数据库字段*/
    private User user;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
 
    public Integer getUid() {
        return uid;
    }
 
    public void setUid(Integer uid) {
        this.uid = uid;
    }
 
    public Integer getPid() {
        return pid;
    }
 
    public void setPid(Integer pid) {
        this.pid = pid;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}
```



##### 03 ReviewService

增加ReviewService，提供CURD以及通过产品获取评价方法：

```java
List list(int pid);
int getCount(int pid);
```

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Review;
 
public interface ReviewService {
      
    void add(Review c);
 
    void delete(int id);
    void update(Review c);
    Review get(int id);
    List list(int pid);
 
    int getCount(int pid);
}
```



##### 04 User

修改User, 增加一个getAnonymousName方法用于在显示评价者的时候进行匿名显示

```java
package com.how2java.tmall.pojo;
 
public class User {
    private Integer id;
 
    private String name;
 
    private String password;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
 
    public String getAnonymousName(){
        if(null==name)
            return null;
 
        if(name.length()<=1)
            return "*";
 
        if(name.length()==2)
            return name.substring(0,1) +"*";
 
        char[] cs =name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);
 
    }
}
```



##### 05 ReviewServiceImpl

增加ReviewServiceImpl，实现对应方法

```java
package com.how2java.tmall.service.impl;
  
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.how2java.tmall.mapper.ReviewMapper;
import com.how2java.tmall.pojo.Review;
import com.how2java.tmall.pojo.ReviewExample;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.ReviewService;
import com.how2java.tmall.service.UserService;
  
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    UserService userService;
  
    @Override
    public void add(Review c) {
        reviewMapper.insert(c);
    }
  
    @Override
    public void delete(int id) {
        reviewMapper.deleteByPrimaryKey(id);
    }
  
    @Override
    public void update(Review c) {
        reviewMapper.updateByPrimaryKeySelective(c);
    }
  
    @Override
    public Review get(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }
  
    public List<Review> list(int pid){
        ReviewExample example =new ReviewExample();
        example.createCriteria().andPidEqualTo(pid);
        example.setOrderByClause("id desc");
  
        List<Review> result =reviewMapper.selectByExample(example);
        setUser(result);
        return result;
    }
  
    public void setUser(List<Review> reviews){
        for (Review review : reviews) {
            setUser(review);
        }
    }
  
    private void setUser(Review review) {
        int uid = review.getUid();
        User user =userService.get(uid);
        review.setUser(user);
    }
  
    @Override
    public int getCount(int pid) {
        return list(pid).size();
    }
}
```



##### 06 OrderItemService

修改OrderItemService，增加根据产品获取销售量的方法：

```java
int getSaleCount(int  pid);
```

```java
package com.how2java.tmall.service;
 
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
 
public interface OrderItemService {
 
    void add(OrderItem c);
 
    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();
 
    void fill(List<Order> os);
 
    void fill(Order o);
 
    int getSaleCount(int  pid);
}
```



##### 07 OrderItemServiceImpl

修改OrderItemServiceImpl，实现getSaleCount方法

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.OrderItemMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.OrderItemExample;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductService;
 
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
 
    @Override
    public void add(OrderItem c) {
        orderItemMapper.insert(c);
    }
 
    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }
 
    public List<OrderItem> list(){
        OrderItemExample example =new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
 
    }
 
    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }
 
    public void fill(Order o) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        setProduct(ois);
 
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(ois);
 
    }
 
    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi: ois) {
            setProduct(oi);
        }
    }
 
    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        oi.setProduct(p);
    }
 
    @Override
    public int getSaleCount(int pid) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andPidEqualTo(pid);
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        int result =0;
        for (OrderItem oi : ois) {
            result+=oi.getNumber();
        }
        return result;
    }
 
}
```

##### 08 ProductService

修改ProductService，增加为产品设置销量和评价数量的方法：

```java
void setSaleAndReviewNumber(Product p);
void setSaleAndReviewNumber(List<Product> ps);
```

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
 
    void fill(List<Category> cs);
 
    void fill(Category c);
 
    void fillByRow(List<Category> cs);
    void setSaleAndReviewNumber(Product p);
 
    void setSaleAndReviewNumber(List<Product> ps);
}
```



##### 09 ProductServiceImpl

修改ProductServiceImpl，实现为产品设置销量和评价数量的方法：

```java
void setSaleAndReviewNumber(Product p);
void setSaleAndReviewNumber
```

```java
package com.how2java.tmall.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.ReviewService;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
 
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setFirstProductImage(p);
        setCategory(p);
        return p;
    }
 
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
 
    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setFirstProductImage(result);
        setCategory(result);
        return result;
    }
 
    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
 
    @Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
 
    @Override
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }
 
    @Override
    public void setSaleAndReviewNumber(Product p) {
        int saleCount = orderItemService.getSaleCount(p.getId());
        p.setSaleCount(saleCount);
 
        int reviewCount = reviewService.getCount(p.getId());
        p.setReviewCount(reviewCount);
    }
 
    @Override
    public void setSaleAndReviewNumber(List<Product> ps) {
        for (Product p : ps) {
            setSaleAndReviewNumber(p);
        }
    }
 
    @Override
    public void fill(Category c) {
        List<Product> ps = list(c.getId());
        c.setProducts(ps);
    }
 
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
}
```



##### 10 ForeController.product()

通过访问地址

http://127.0.0.1:8080/tmall_ssm/foreproduct?pid=844

导致ForeController.product() 方法被调用

1. 获取参数pid
2. 根据pid获取Product 对象p
3. 根据对象p，获取这个产品对应的单个图片集合
4. 根据对象p，获取这个产品对应的详情图片集合
5. 获取产品的所有属性值
6. 获取产品对应的所有的评价
7. 设置产品的销量和评价数量
8. 把上述取值放在request属性上
9. 服务端跳转到 "product.jsp" 页面

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
}
```



##### 11 product.jsp

与 register.jsp 相仿，product.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。
中间是产品业务页面 productPage.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\ product.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/simpleSearch.jsp"%>
<%@include file="../include/fore/product/productPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```



##### 12 productPage.jsp

productPage.jsp 又由3个页面组成

1. imgAndInfo.jsp
   单个图片和基本信息

2. productReview.jsp
   评价信息

3. productDetail.jsp
   详情图片

   tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\product\productPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <title>模仿天猫官网 ${p.name}</title>
  <div class="categoryPictureInProductPageDiv">
      <img class="categoryPictureInProductPage" src="img/category/${p.category.id}.jpg">
  </div>
   
  <div class="productPageDiv">
   
      <%@include file="imgAndInfo.jsp" %>
       
      <%@include file="productReview.jsp" %>
       
      <%@include file="productDetail.jsp" %>
  </div>
  ```

  

##### 13 imgAndInfo.jsp

1. 左侧显示5张单个图片
   1.1 默认显示第一张图片 

```jsp
<img src="img/productSingle/${p.firstProductImage.id}.jpg" class="bigImg">
```

​       1.2 5张小图片

```jsp
<c:forEach items="${p.productSingleImages}" var="pi">
	<img src="img/productSingle_small/${pi.id}.jpg" bigImageURL="img/productSingle/${pi.id}.jpg" class="smallImage">
</c:forEach>
```

2. 右边显示基本信息
   2.1 标题和小标题

```jsp
<div class="productTitle">
	${p.name}
</div>
<div class="productSubTitle">
	${p.subTitle} 
</div>
```

2.2 原始价格和促销价

```jsp
<fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/>
<fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
```

2.3 销量和累计评价

```jsp
<div>销量 <span class="redColor boldWord"> ${p.saleCount }</span></div>	
<div>累计评价 <span class="redColor boldWord"> ${p.reviewCount}</span></div>
```

2.4 库存

```jsp
<span>库存${p.stock}件</span>
```

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\imgAndInfo.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<script>
 
$(function(){
    var stock = ${p.stock};
    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
     
    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });
     
    $(".addCartLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var pid = ${p.id};
                        var num= $(".productNumberSetting").val();
                        var addCartpage = "foreaddCart";
                        $.get(
                                addCartpage,
                                {"pid":pid,"num":num},
                                function(result){
                                    if("success"==result){
                                        $(".addCartButton").html("已加入购物车");
                                        $(".addCartButton").attr("disabled","disabled");
                                        $(".addCartButton").css("background-color","lightgray")
                                        $(".addCartButton").css("border-color","lightgray")
                                        $(".addCartButton").css("color","black")
                                         
                                    }
                                    else{
                                         
                                    }
                                }
                        );                         
                    }
                    else{
                        $("#loginModal").modal('show');                    
                    }
                }
        );     
        return false;
    });
    $(".buyLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var num = $(".productNumberSetting").val();
                        location.href= $(".buyLink").attr("href")+"&num="+num;
                    }
                    else{
                        $("#loginModal").modal('show');                    
                    }
                }
        );     
        return false;
    });
     
    $("button.loginSubmitButton").click(function(){
        var name = $("#name").val();
        var password = $("#password").val();
         
        if(0==name.length||0==password.length){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();          
            return false;
        }
         
        var page = "foreloginAjax";
        $.get(
                page,
                {"name":name,"password":password},
                function(result){
                    if("success"==result){
                        location.reload();
                    }
                    else{
                        $("span.errorMessage").html("账号密码错误");
                        $("div.loginErrorMessageDiv").show();                      
                    }
                }
        );         
         
        return true;
    });
     
    $("img.smallImage").mouseenter(function(){
        var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
    });
     
    $("img.bigImg").load(
        function(){
            $("img.smallImage").each(function(){
                var bigImageURL = $(this).attr("bigImageURL");
                img = new Image();
                img.src = bigImageURL;
                 
                img.onload = function(){
                    console.log(bigImageURL);  
                    $("div.img4load").append($(img));
                };
            });    
        }
    );
});
 
</script>
 
<div class="imgAndInfo">
 
    <div class="imgInimgAndInfo">
        <img src="img/productSingle/${p.firstProductImage.id}.jpg" class="bigImg">
        <div class="smallImageDiv">
            <c:forEach items="${p.productSingleImages}" var="pi">
                <img src="img/productSingle_small/${pi.id}.jpg" bigImageURL="img/productSingle/${pi.id}.jpg" class="smallImage">
            </c:forEach>
        </div>
        <div class="img4load hidden" ></div>
    </div>
     
    <div class="infoInimgAndInfo">
         
        <div class="productTitle">
            ${p.name}
        </div>
        <div class="productSubTitle">
            ${p.subTitle}
        </div>
         
        <div class="productPrice">
            <div class="juhuasuan">
                <span class="juhuasuanBig" >聚划算</span>
                <span>此商品即将参加聚划算，<span class="juhuasuanTime">1天19小时</span>后开始，</span>
            </div>
            <div class="productPriceDiv">
                <div class="gouwujuanDiv"><img height="16px" src="img/site/gouwujuan.png">
                <span> 全天猫实物商品通用</span>
                 
                </div>
                <div class="originalDiv">
                    <span class="originalPriceDesc">价格</span>
                    <span class="originalPriceYuan">¥</span>
                    <span class="originalPrice">
                     
                        <fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/>                   
                    </span>
                </div>
                <div class="promotionDiv">
                    <span class="promotionPriceDesc">促销价 </span>
                    <span class="promotionPriceYuan">¥</span>
                    <span class="promotionPrice">
                        <fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
                    </span>              
                </div>
            </div>
        </div>
        <div class="productSaleAndReviewNumber">
            <div>销量 <span class="redColor boldWord"> ${p.saleCount }</span></div>  
            <div>累计评价 <span class="redColor boldWord"> ${p.reviewCount}</span></div>   
        </div>
        <div class="productNumber">
            <span>数量</span>
            <span>
                <span class="productNumberSettingSpan">
                <input class="productNumberSetting" type="text" value="1">
                </span>
                <span class="arrow">
                    <a href="#nowhere" class="increaseNumber">
                    <span class="updown">
                            <img src="img/site/increase.png">
                    </span>
                    </a>
                     
                    <span class="updownMiddle"> </span>
                    <a href="#nowhere"  class="decreaseNumber">
                    <span class="updown">
                            <img src="img/site/decrease.png">
                    </span>
                    </a>
                     
                </span>
                     
            件</span>
            <span>库存${p.stock}件</span>
        </div>
        <div class="serviceCommitment">
            <span class="serviceCommitmentDesc">服务承诺</span>
            <span class="serviceCommitmentLink">
                <a href="#nowhere">正品保证</a>
                <a href="#nowhere">极速退款</a>
                <a href="#nowhere">赠运费险</a>
                <a href="#nowhere">七天无理由退换</a>
            </span>
        </div>   
         
        <div class="buyDiv">
            <a class="buyLink" href="forebuyone?pid=${p.id}"><button class="buyButton">立即购买</button></a>
            <a href="#nowhere" class="addCartLink"><button class="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</button></a>
        </div>
    </div>
     
    <div style="clear:both"></div>
     
</div>
```



##### 14  productReview.jsp

借助c:forEach遍历request中的reviews

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="productReviewDiv" >
    <div class="productReviewTopPart">
        <a  href="#nowhere" class="productReviewTopPartSelectedLink">商品详情</a>
        <a  href="#nowhere" class="selected">累计评价 <span class="productReviewTopReviewLinkNumber">${p.reviewCount}</span> </a>
    </div>
     
    <div class="productReviewContentPart">
        <c:forEach items="${reviews}" var="r">
        <div class="productReviewItem">
         
            <div class="productReviewItemDesc">
                <div class="productReviewItemContent">
                    ${r.content }
                </div>
                <div class="productReviewItemDate"><fmt:formatDate value="${r.createDate}" pattern="yyyy-MM-dd"/></div>
            </div>
            <div class="productReviewItemUserInfo">
             
                ${r.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
            </div>
             
            <div style="clear:both"></div>
         
        </div>
        </c:forEach>
    </div>
 
</div>
```



##### 15 productDetail.jsp

如图所示，productDetail.jsp做了两件事

1. 显示属性值

```jsp
<c:forEach items="${pvs}" var="pv">
	<span>${pv.property.name}:  ${fn:substring(pv.value, 0, 10)} </span>
</c:forEach>
```

2. 显示详情图片

   ```jsp
   <c:forEach items="${p.productDetailImages}" var="pi">
   	<img src="img/productDetail/${pi.id}.jpg">
   </c:forEach>
   ```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="productDetailDiv" >
    <div class="productDetailTopPart">
        <a href="#nowhere" class="productDetailTopPartSelectedLink selected">商品详情</a>
        <a href="#nowhere" class="productDetailTopReviewLink">累计评价 <span class="productDetailTopReviewLinkNumber">${p.reviewCount}</span> </a>
    </div>
     
    <div class="productParamterPart">
        <div class="productParamter">产品参数：</div>
         
        <div class="productParamterList">
            <c:forEach items="${pvs}" var="pv">
                <span>${pv.property.name}:  ${fn:substring(pv.value, 0, 10)} </span>
            </c:forEach>
        </div>
        <div style="clear:both"></div>
    </div>
     
    <div class="productDetailImagesPart">
            <c:forEach items="${p.productDetailImages}" var="pi">
                <img src="img/productDetail/${pi.id}.jpg">
            </c:forEach>
    </div>
</div>
```



#### 7.2.5 模拟登录

##### 01 imgAndInfo.jsp

立即购买和加入购物车这两个按钮的监听是放在imgAndInfo.jsp页面中

这两个按钮都会通过JQuery的.get方法，用异步ajax的方式访问forecheckLogin，获取当前是否登录状态
如果返回的不是"success" 即表明是未登录状态，那么就会打开登录的模态窗口

```jsp
$("#loginModal").modal('show');
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  
<script>
  
$(function(){
    var stock = ${p.stock};
    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
      
    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });
      
    $(".addCartLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var pid = ${p.id};
                        var num= $(".productNumberSetting").val();
                        var addCartpage = "foreaddCart";
                        $.get(
                                addCartpage,
                                {"pid":pid,"num":num},
                                function(result){
                                    if("success"==result){
                                        $(".addCartButton").html("已加入购物车");
                                        $(".addCartButton").attr("disabled","disabled");
                                        $(".addCartButton").css("background-color","lightgray")
                                        $(".addCartButton").css("border-color","lightgray")
                                        $(".addCartButton").css("color","black")
                                          
                                    }
                                    else{
                                          
                                    }
                                }
                        );                         
                    }
                    else{
                        $("#loginModal").modal('show');                    
                    }
                }
        );     
        return false;
    });
    $(".buyLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var num = $(".productNumberSetting").val();
                        location.href= $(".buyLink").attr("href")+"&num="+num;
                    }
                    else{
                        $("#loginModal").modal('show');                    
                    }
                }
        );     
        return false;
    });
      
    $("button.loginSubmitButton").click(function(){
        var name = $("#name").val();
        var password = $("#password").val();
          
        if(0==name.length||0==password.length){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();          
            return false;
        }
          
        var page = "foreloginAjax";
        $.get(
                page,
                {"name":name,"password":password},
                function(result){
                    if("success"==result){
                        location.reload();
                    }
                    else{
                        $("span.errorMessage").html("账号密码错误");
                        $("div.loginErrorMessageDiv").show();                      
                    }
                }
        );         
          
        return true;
    });
      
    $("img.smallImage").mouseenter(function(){
        var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
    });
      
    $("img.bigImg").load(
        function(){
            $("img.smallImage").each(function(){
                var bigImageURL = $(this).attr("bigImageURL");
                img = new Image();
                img.src = bigImageURL;
                  
                img.onload = function(){
                    console.log(bigImageURL);  
                    $("div.img4load").append($(img));
                };
            });    
        }
    );
});
  
</script>
  
<div class="imgAndInfo">
  
    <div class="imgInimgAndInfo">
        <img src="img/productSingle/${p.firstProductImage.id}.jpg" class="bigImg">
        <div class="smallImageDiv">
            <c:forEach items="${p.productSingleImages}" var="pi">
                <img src="img/productSingle_small/${pi.id}.jpg" bigImageURL="img/productSingle/${pi.id}.jpg" class="smallImage">
            </c:forEach>
        </div>
        <div class="img4load hidden" ></div>
    </div>
      
    <div class="infoInimgAndInfo">
          
        <div class="productTitle">
            ${p.name}
        </div>
        <div class="productSubTitle">
            ${p.subTitle}
        </div>
          
        <div class="productPrice">
            <div class="juhuasuan">
                <span class="juhuasuanBig" >聚划算</span>
                <span>此商品即将参加聚划算，<span class="juhuasuanTime">1天19小时</span>后开始，</span>
            </div>
            <div class="productPriceDiv">
                <div class="gouwujuanDiv"><img height="16px" src="img/site/gouwujuan.png">
                <span> 全天猫实物商品通用</span>
                  
                </div>
                <div class="originalDiv">
                    <span class="originalPriceDesc">价格</span>
                    <span class="originalPriceYuan">¥</span>
                    <span class="originalPrice">
                      
                        <fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/>                
                    </span>
                </div>
                <div class="promotionDiv">
                    <span class="promotionPriceDesc">促销价 </span>
                    <span class="promotionPriceYuan">¥</span>
                    <span class="promotionPrice">
                        <fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
                    </span>              
                </div>
            </div>
        </div>
        <div class="productSaleAndReviewNumber">
            <div>销量 <span class="redColor boldWord"> ${p.saleCount }</span></div>  
            <div>累计评价 <span class="redColor boldWord"> ${p.reviewCount}</span></div>   
        </div>
        <div class="productNumber">
            <span>数量</span>
            <span>
                <span class="productNumberSettingSpan">
                <input class="productNumberSetting" type="text" value="1">
                </span>
                <span class="arrow">
                    <a href="#nowhere" class="increaseNumber">
                    <span class="updown">
                            <img src="img/site/increase.png">
                    </span>
                    </a>
                      
                    <span class="updownMiddle"> </span>
                    <a href="#nowhere"  class="decreaseNumber">
                    <span class="updown">
                            <img src="img/site/decrease.png">
                    </span>
                    </a>
                      
                </span>
                      
            件</span>
            <span>库存${p.stock}件</span>
        </div>
        <div class="serviceCommitment">
            <span class="serviceCommitmentDesc">服务承诺</span>
            <span class="serviceCommitmentLink">
                <a href="#nowhere">正品保证</a>
                <a href="#nowhere">极速退款</a>
                <a href="#nowhere">赠运费险</a>
                <a href="#nowhere">七天无理由退换</a>
            </span>
        </div>   
          
        <div class="buyDiv">
            <a class="buyLink" href="forebuyone?pid=${p.id}"><button class="buyButton">立即购买</button></a>
            <a href="#nowhere" class="addCartLink"><button class="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</button></a>
        </div>
    </div>
      
    <div style="clear:both"></div>
      
</div>
```

##### 02 ForeController.checkLogin()

在上一步的ajax访问路径/forecheckLogin会导致ForeController.checkLogin()方法被调用。
获取session中的"user"对象
如果不为空，即表示已经登录，返回字符串"success"
如果为空，即表示未登录，返回字符串"fail"

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
 
}
```



##### 03  modal.jsp

modal.jsp 页面被 footer.jsp 所包含，所以每个页面都是加载了的。
通过imgAndInfo.jsp页面中的购买按钮或者加入购物车按钮显示出来。
点击登录按钮时，使用imgAndInfo.jsp 页面中的ajax代码进行登录验证：

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div class="modal " id="loginModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog loginDivInProductPageModalDiv">
            <div class="modal-content">
                    <div class="loginDivInProductPage">
                        <div class="loginErrorMessageDiv">
                            <div class="alert alert-danger" >
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                                <span class="errorMessage"></span>
                            </div>
                        </div>
                             
                        <div class="login_acount_text">账户登录</div>
                        <div class="loginInput " >
                            <span class="loginInputIcon ">
                                <span class=" glyphicon glyphicon-user"></span>
                            </span>
                            <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">        
                        </div>
                         
                        <div class="loginInput " >
                            <span class="loginInputIcon ">
                                <span class=" glyphicon glyphicon-lock"></span>
                            </span>
                            <input id="password" name="password"  type="password" placeholder="密码" type="text">          
                        </div>
                                    <span class="text-danger">不要输入真实的天猫账号密码</span><br><br>
                        <div>
                            <a href="#nowhere">忘记登录密码</a>
                            <a href="register.jsp" class="pull-right">免费注册</a>
                        </div>
                        <div style="margin-top:20px">
                            <button class="btn btn-block redButton loginSubmitButton" type="submit">登录</button>
                        </div>
                    </div>   
          </div>
    </div>
</div>
 
<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog deleteConfirmModalDiv">
       <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">确认删除？</h4>
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
          </div>
        </div>
      </div>
    </div>
</div>
```



##### 04 ForeController.loginAjax()

在上一步modal.jsp中，点击了登录按钮之后，访问路径/foreloginAjax,导致ForeController.loginAjax()方法被调用

1. 获取账号密码
2. 通过账号密码获取User对象
   2.1 如果User对象为空，那么就返回"fail"字符串。
   2.2 如果User对象不为空，那么就把User对象放在session中，并返回"success" 字符串

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
 
}
```



#### 7.2.6 分类页

##### 01 5个Comparator比较器

分类这个页面有排序功能，所以在讲解ForeController之前，先准备5个Comparator比较器

tmall_ssm\src\main\java\comparator

1. ProductAllComparator 综合比较器
   把 销量x评价 高的放前面

  ```java
  package comparator;
   
  import java.util.Comparator;
   
  import com.how2java.tmall.pojo.Product;
   
  public class ProductAllComparator implements Comparator<Product>{
   
      @Override
      public int compare(Product p1, Product p2) {
          return p2.getReviewCount()*p2.getSaleCount()-p1.getReviewCount()*p1.getSaleCount();
      }
   
  }
  ```

  

2. ProductReviewComparator 人气比较器

  把 评价数量多的放前面

  ```java
  package comparator;
   
  import java.util.Comparator;
   
  import com.how2java.tmall.pojo.Product;
   
  public class ProductDateComparator implements Comparator<Product>{
   
      @Override
      public int compare(Product p1, Product p2) {
          return p2.getCreateDate().compareTo(p1.getCreateDate());
      }
   
  }
  ```

  

3. ProductDateComparator 新品比较器
   把 创建日期晚的放前面

  ```java
  package comparator;
   
  import java.util.Comparator;
   
  import com.how2java.tmall.pojo.Product;
   
  public class ProductPriceComparator implements Comparator<Product>{
   
      @Override
      public int compare(Product p1, Product p2) {
          return (int) (p1.getPromotePrice()-p2.getPromotePrice());
      }
   
  }
  ```

  

4. ProductSaleCountComparator 销量比较器
   把 销量高的放前面

  ```java
  package comparator;
   
  import java.util.Comparator;
   
  import com.how2java.tmall.pojo.Product;
   
  public class ProductReviewComparator implements Comparator<Product>{
   
      @Override
      public int compare(Product p1, Product p2) {
          return p2.getReviewCount()-p1.getReviewCount();
      }
   
  }
  ```

  

5. ProductPriceComparator 价格比较器
   把 价格低的放前面

  ```java
  package comparator;
   
  import java.util.Comparator;
   
  import com.how2java.tmall.pojo.Product;
   
  public class ProductSaleCountComparator implements Comparator<Product>{
   
      @Override
      public int compare(Product p1, Product p2) {
          return p2.getSaleCount()-p1.getSaleCount();
      }
   
  }
  ```

  

##### 02 ForeController.category()

1. 获取参数cid
2. 根据cid获取分类Category对象 c
3. 为c填充产品
4. 为产品填充销量和评价数据
5. 获取参数sort
   5.1 如果sort==null，即不排序
   5.2 如果sort!=null，则根据sort的值，从5个Comparator比较器中选择一个对应的排序器进行排序
6. 把c放在model中
7. 服务端跳转到 category.jsp

```java
package com.how2java.tmall.controller;
 
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
}
```



##### 03  category.jsp

与 register.jsp 相仿，category.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。

中间是分类业务页面 categoryPage.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\ category.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/search.jsp"%>
<%@include file="../include/fore/category/categoryPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

##### 04 categoryPage.jsp

categoryPage.jsp 里有3个内容

1. 显示当前分类图片

   ```html
   <img src="img/category/${c.id}.jpg">
   ```


2. 排序条 sortBar.jsp

3. 产品列表 productsByCategory.jsp

   tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\category\categoryPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<title>模仿天猫官网-${c.name}</title>
<div id="category">
    <div class="categoryPageDiv">
        <img src="img/category/${c.id}.jpg">
        <%@include file="sortBar.jsp"%>
        <%@include file="productsByCategory.jsp"%>
    </div>
</div>
```



##### 05 sortBar.jsp

sortBar.jsp 即排序条，做了如下几个与数据相关的事情

1. 根据sort参数判断哪个排序按钮高亮

2. 每个排序按钮提交到本页面，即/forecategory，并带上参数sort

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<script>
$(function(){
    $("input.sortBarPrice").keyup(function(){
        var num= $(this).val();
        if(num.length==0){
            $("div.productUnit").show();
            return;
        }
             
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        $(this).val(num);      
         
        var begin = $("input.beginPrice").val();
        var end = $("input.endPrice").val();
        if(!isNaN(begin) && !isNaN(end)){
            console.log(begin);
            console.log(end);
            $("div.productUnit").hide();
            $("div.productUnit").each(function(){
                var price = $(this).attr("price");
                price = new Number(price);
                 
                if(price<=end && price>=begin)
                    $(this).show();
            });
        }
         
    });
});
</script>
<div class="categorySortBar">
 
    <table class="categorySortBarTable categorySortTable">
        <tr>
            <td <c:if test="${'all'==param.sort||empty param.sort}">class="grayColumn"</c:if> ><a href="?cid=${c.id}&sort=all">综合<span class="glyphicon glyphicon-arrow-down"></span></a></td>
            <td <c:if test="${'review'==param.sort}">class="grayColumn"</c:if> ><a href="?cid=${c.id}&sort=review">人气<span class="glyphicon glyphicon-arrow-down"></span></a></td>
            <td <c:if test="${'date'==param.sort}">class="grayColumn"</c:if>><a href="?cid=${c.id}&sort=date">新品<span class="glyphicon glyphicon-arrow-down"></span></a></td>
            <td <c:if test="${'saleCount'==param.sort}">class="grayColumn"</c:if>><a href="?cid=${c.id}&sort=saleCount">销量<span class="glyphicon glyphicon-arrow-down"></span></a></td>
            <td <c:if test="${'price'==param.sort}">class="grayColumn"</c:if>><a href="?cid=${c.id}&sort=price">价格<span class="glyphicon glyphicon-resize-vertical"></span></a></td>
        </tr>
    </table>
     
    <table class="categorySortBarTable">
        <tr>
            <td><input class="sortBarPrice beginPrice" type="text" placeholder="请输入"></td>
            <td class="grayColumn priceMiddleColumn">-</td>
            <td><input class="sortBarPrice endPrice" type="text" placeholder="请输入"></td>
        </tr>
    </table>
 
</div>
```

##### 06 productsByCategory.jsp

productsByCategory.jsp显示当前分类下的所有产品

通过forEach遍历c.products集合里的每个产品，并把产品标题，价格，图片，评价数，成交数打印出来

解释下：categorycount，这个是用于测试的，在访问地址的时候加这个参数

http://127.0.0.1:8080/tmall_ssm/forecategory?cid=74&categorycount=2

这样就只显示2个产品，仅供测试使用

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>
 
<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>
     
<div class="categoryProducts">
    <c:forEach items="${c.products}" var="p" varStatus="stc">
        <c:if test="${stc.count<=categorycount}">
        <div class="productUnit" price="${p.promotePrice}">
            <div class="productUnitFrame">
                <a href="foreproduct?pid=${p.id}">
                    <img class="productImage" src="img/productSingle_middle/${p.firstProductImage.id}.jpg">
                </a>
                <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/></span>
                <a class="productLink" href="foreproduct?pid=${p.id}">
                 ${fn:substring(p.name, 0, 50)}
                </a>
                 
                <a  class="tmallLink" href="foreproduct?pid=${p.id}">天猫专卖</a>
     
                <div class="show1 productInfo">
                    <span class="monthDeal ">月成交 <span class="productDealNumber">${p.saleCount}笔</span></span>
                    <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span></span>
                    <span class="wangwang">
                    <a class="wangwanglink" href="#nowhere">
                        <img src="img/site/wangwang.png">
                    </a>
                     
                    </span>
                </div>
            </div>
        </div>
        </c:if>
    </c:forEach>
        <div style="clear:both"></div>
</div>
```

#### 7.2.7 搜索

##### 01 search.jsp以及simpleSearch.jsp

每个页面都包含了搜索的jsp，首页和搜索结果页包含的是search.jsp，其他页面包含的是simpleSearch.jsp。

这两个页面都提供了一个form，提交数据keyword到foresearch这个路径

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
    <a href="${contextPath}">
        <img id="logo" src="img/site/logo.gif" class="logo">
    </a>
     
    <form action="foresearch" method="post" >
        <div class="searchDiv">
            <input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋  太阳镜 ">
            <button  type="submit" class="searchButton">搜索</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=5 and st.count<=8}">
                        <span>
                            <a href="forecategory?cid=${c.id}">
                                ${c.name}
                            </a>
                            <c:if test="${st.count!=8}">             
                                <span>|</span>             
                            </c:if>
                        </span>          
                    </c:if>
                </c:forEach>     
            </div>
        </div>
    </form>  
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<div >
    <a href="${contextPath}">
        <img id="simpleLogo" class="simpleLogo" src="img/site/simpleLogo.png">   
    </a>
 
    <form action="foresearch" method="post" >
    <div class="simpleSearchDiv pull-right">
        <input type="text" placeholder="平衡车 原汁机"  value="${param.keyword}" name="keyword">
        <button class="searchButton" type="submit">搜天猫</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count>=8 and st.count<=11}">
                    <span>
                        <a href="forecategory?cid=${c.id}">
                            ${c.name}
                        </a>
                        <c:if test="${st.count!=11}">            
                            <span>|</span>             
                        </c:if>
                    </span>          
                </c:if>
            </c:forEach>         
        </div>
    </div>
    </form>
    <div style="clear:both"></div>
</div>
```

##### 02 ForeController.search()

通过search.jsp或者simpleSearch.jsp提交数据到路径 /foresearch， 导致ForeController.search()方法被调用

1. 获取参数keyword
2. 根据keyword进行模糊查询，获取满足条件的前20个产品
3. 为这些产品设置销量和评价数量
4. 把产品结合设置在model的"ps"属性上
5. 服务端跳转到 searchResult.jsp 页面

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
}
```

##### 03 ProductService

修改ProductService，增加search方法

```java
package com.how2java.tmall.service;
 
import java.util.List;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
 
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
 
    void fill(List<Category> cs);
 
    void fill(Category c);
 
    void fillByRow(List<Category> cs);
 
    void setSaleAndReviewNumber(Product p);
 
    void setSaleAndReviewNumber(List<Product> ps);
 
    List<Product> search(String keyword);
}
```



##### 04 ProductServiceImpl

修改ProductServiceImpl实现search方法，通过关键字进行模糊查询

```java
package com.how2java.tmall.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.ReviewService;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
 
    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }
 
    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
 
    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setFirstProductImage(p);
        setCategory(p);
        return p;
    }
 
    public void setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
 
    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setFirstProductImage(result);
        setCategory(result);
        return result;
    }
 
    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
 
    @Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
 
    @Override
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }
 
    @Override
    public void setSaleAndReviewNumber(Product p) {
        int saleCount = orderItemService.getSaleCount(p.getId());
        p.setSaleCount(saleCount);
 
        int reviewCount = reviewService.getCount(p.getId());
        p.setReviewCount(reviewCount);
    }
 
    @Override
    public void setSaleAndReviewNumber(List<Product> ps) {
        for (Product p : ps) {
            setSaleAndReviewNumber(p);
        }
    }
 
    @Override
    public List<Product> search(String keyword) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameLike("%" + keyword + "%");
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setFirstProductImage(result);
        setCategory(result);
        return result;
    }
 
    @Override
    public void fill(Category c) {
        List<Product> ps = list(c.getId());
        c.setProducts(ps);
    }
 
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
}
```

##### 05 searchResult.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\fore\searchResult.jsp

与 register.jsp 相仿，searchResult.jsp 也包含了header.jsp, top.jsp, search.jsp， footer.jsp 等公共页面。
中间是搜索结果业务页面 searchResultPage.jsp

注： 在search.jsp中，又把参数keyword显示在输入框中

```html
<input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋  太阳镜 ">
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/search.jsp"%>
<%@include file="../include/fore/searchResultPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
    <a href="${contextPath}">
        <img id="logo" src="img/site/logo.gif" class="logo">
    </a>
     
    <form action="foresearch" method="post" >
        <div class="searchDiv">
            <input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋  太阳镜 ">
            <button  type="submit" class="searchButton">搜索</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=5 and st.count<=8}">
                        <span>
                            <a href="forecategory?cid=${c.id}">
                                ${c.name}
                            </a>
                            <c:if test="${st.count!=8}">             
                                <span>|</span>             
                            </c:if>
                        </span>          
                    </c:if>
                </c:forEach>     
            </div>
        </div>
    </form>  
```



##### 06 searchResultPage.jsp

tmall_ssm\src\main\webapp\WEB-INF\jsp\include\fore\searchResultPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div id="searchResult">
     
    <div class="searchResultDiv">
        <%@include file="productsBySearch.jsp"%>
    </div>
 
</div>
```



##### 07 productsBySearch.jsp

productsBySearch.jsp 显示产寻结果：

1. 遍历ps，把每个产品的图片，价格，标题等信息显示出来
2. 如果ps为空，则显示 "没有满足条件的产品"

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div class="searchProducts">
     
    <c:forEach items="${ps}" var="p">
        <div class="productUnit" price="${p.promotePrice}">
            <a href="foreproduct?pid=${p.id}">
                <img class="productImage" src="img/productSingle/${p.firstProductImage.id}.jpg">
            </a>
            <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/></span>
            <a class="productLink" href="foreproduct?pid=${p.id}">
             ${fn:substring(p.name, 0, 50)}
            </a>
             
            <a class="tmallLink" href="foreproduct?pid=${p.id}">天猫专卖</a>
 
            <div class="productInfo">
                <span class="monthDeal ">月成交 <span class="productDealNumber">${p.saleCount}笔</span></span>
                <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span></span>
                <span class="wangwang"><img src="img/site/wangwang.png"></span>
            </div>
             
    </c:forEach>
    <c:if test="${empty ps}">
        <div class="noMatch">没有满足条件的产品<div>
    </c:if>
     
        <div style="clear:both"></div>
        </div>
</div>
```

#### 7.3.1 购买流程

##### 01 购买的业务流程

1. 登录

2. 访问产品页 

3. 立即购买

4. 进入结算页面

   <!--more-->

5. 加入购物车

6. 查看购物车

7. 选中购物车中的商品

8. 又到了第4步的结算页面

9. 在结算页面生成订单

10. 付款

11. 确认收货

12. 评价

![购买的业务流程](https://stepimagewm.how2j.cn/6358.png)



##### 02 购物流程环节与表关系

接着再把购物流程各个环节与表关系搞清楚，这个开发人员必须明白的部分，这个部分稀里糊涂，后面做出来的功能就会越来越乱。

围绕购物流程最重要的两个表是OrderItem 和 Order表

关于OrderItem的业务行为

1. 立即购买 —— 新增 OrderItem
2. 加入购物车 —— 新增 OrderItem
3. 查看购物车 —— 显示未和Order关联的OrderItem
4. 选中购物车中的商品 —— 选中OrderItem
5. 结算页面 —— 显示选中的OrderItem
6. 生成订单 —— 新增Order
7. 付款 —— 修改Order状态
8. 我的订单 —— 显示Order
9. 确认收货 —— 修改Order状态



![购物流程环节与表关系](https://stepimagewm.how2j.cn/6359.png)



#### 7.3.2 立即购买

那么点击购买都做了什么事情呢？ 会在OrderItem表里插入一条数据，这条数据会表示:

1. pid =844 购买的商品id
2. oid = null, 这个订单项还没有生成对应的订单，即还在购物车中
3. uid= 3，用户的id是3
4. number=3, 购买了3件产品



##### 01 OrderItemService

为OrderItemService新增方法listByUser

```java
package com.how2java.tmall.service;
 
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
 
public interface OrderItemService {
 
    void add(OrderItem c);
 
    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();
 
    void fill(List<Order> os);
 
    void fill(Order o);
 
    int getSaleCount(int  pid);
 
    List<OrderItem> listByUser(int uid);
}
```



##### 02 OrderItemServiceImpl

为OrderItemServiceImpl新增加方法listByUser的实现

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.OrderItemMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.OrderItemExample;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.ProductService;
 
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
 
    @Override
    public void add(OrderItem c) {
        orderItemMapper.insert(c);
    }
 
    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }
 
    public List<OrderItem> list(){
        OrderItemExample example =new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
 
    }
 
    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }
 
    @Override
    public int getSaleCount(int pid) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andPidEqualTo(pid);
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        int result =0;
        for (OrderItem oi : ois) {
            result+=oi.getNumber();
        }
        return result;
    }
 
    @Override
    public List<OrderItem> listByUser(int uid) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andUidEqualTo(uid).andOidIsNull();
        List<OrderItem> result =orderItemMapper.selectByExample(example);
        setProduct(result);
        return result;
    }
 
    public void fill(Order o) {
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        setProduct(ois);
 
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(ois);
 
    }
 
    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi: ois) {
            setProduct(oi);
        }
    }
 
    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        oi.setProduct(p);
    }
}
```



##### 03 ForeController.buyone()

通过上个步骤访问的地址 /forebuyone 导致ForeController.buyone()方法被调用

1. 获取参数pid

2. 获取参数num

3. 根据pid获取产品对象p

4. 从session中获取用户对象user

   ```java
   @RequestMapping("forebuyone")
       public String buyone(int pid, int num, HttpSession session) {
           Product p = productService.get(pid);
           int oiid = 0;
    
           User user =(User)  session.getAttribute("user");
           boolean found = false;
           List<OrderItem> ois = orderItemService.listByUser(user.getId());
           for (OrderItem oi : ois) {
               if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                   oi.setNumber(oi.getNumber()+num);
                   orderItemService.update(oi);
                   found = true;
                   oiid = oi.getId();
                   break;
               }
           }
    
           if(!found){
               OrderItem oi = new OrderItem();
               oi.setUid(user.getId());
               oi.setNumber(num);
               oi.setPid(pid);
               orderItemService.add(oi);
               oiid = oi.getId();
           }
           return "redirect:forebuy?oiid="+oiid;
       }
    
   }
   ```

   

接下来就是新增订单项OrderItem， 新增订单项要考虑两个情况
a. 如果已经存在这个产品对应的OrderItem，并且还没有生成订单，即还在购物车中。 那么就应该在对应的OrderItem基础上，调整数量
a.1 基于用户对象user，查询没有生成订单的订单项集合
a.2 遍历这个集合
a.3 如果产品是一样的话，就进行数量追加
a.4 获取这个订单项的 id

b. 如果不存在对应的OrderItem,那么就新增一个订单项OrderItem
b.1 生成新的订单项
b.2 设置数量，用户和产品
b.3 插入到数据库
b.4 获取这个订单项的 id

最后， 基于这个订单项id客户端跳转到结算页面/forebuy

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
}
```

#### 7.3.3 结算页面

![界面效果](https://img-blog.csdnimg.cn/20200924120221881.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

##### 01 ForeController.buy()

立即购买最后，客户端跳转到结算路径： "@forebuy?oiid="+oiid;

http://127.0.0.1:8080/tmall_ssm/forebuy?oiid=1

导致ForeController.buy()方法被调用

```java
@RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
 
}
```

1. 通过字符串数组获取参数oiid
   为什么这里要用字符串数组试图获取多个oiid，而不是int类型仅仅获取一个oiid? 因为根据购物流程环节与表关系，结算页面还需要显示在购物车中选中的多条OrderItem数据，所以为了兼容从购物车页面跳转过来的需求，要用字符串数组获取多个oiid
2. 准备一个泛型是OrderItem的集合ois
3. 根据前面步骤获取的oiids，从数据库中取出OrderItem对象，并放入ois集合中
4. 累计这些ois的价格总数，赋值在total上
5. 把订单项集合放在session的属性 "ois" 上
6. 把总价格放在 model的属性 "total" 上
7. 服务端跳转到buy.jsp

![ForeController.buy()](https://img-blog.csdnimg.cn/20200924120221914.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
 
}
```



##### 02 buy.jsp

与 register.jsp 相仿，buy.jsp也包含了header.jsp, top.jsp, footer.jsp 等公共页面。

中间是结算业务页面 buyPage.jsp



```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/cart/buyPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```



##### 03 buyPage.jsp

1. 从63行到101行 遍历出订单项集合 ois 中的订单项数据
   从立即购买跳转到结算页面来只会有一件产品

2. 显示总金额

   ```jsp
   <%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8" isELIgnored="false"%>
   <div class="buyPageDiv">
     <form action="forecreateOrder" method="post">
      
       <div class="buyFlow">
           <img class="pull-left" src="img/site/simpleLogo.png">
           <img class="pull-right" src="img/site/buyflow.png">
           <div style="clear:both"></div>
       </div>
       <div class="address">
           <div class="addressTip">输入收货地址</div>
           <div>
            
               <table class="addressTable">
                   <tr>
                       <td class="firstColumn">详细地址<span class="redStar">*</span></td>
                        
                       <td><textarea name="address" placeholder="建议您如实填写详细收货地址，例如接到名称，门牌好吗，楼层和房间号等信息"></textarea></td>
                   </tr>
                   <tr>
                       <td>邮政编码</td>
                       <td><input  name="post" placeholder="如果您不清楚邮递区号，请填写000000" type="text"></td>
                   </tr>
                   <tr>
                       <td>收货人姓名<span class="redStar">*</span></td>
                       <td><input  name="receiver"  placeholder="长度不超过25个字符" type="text"></td>
                   </tr>
                   <tr>
                       <td>手机号码 <span class="redStar">*</span></td>
                       <td><input name="mobile"  placeholder="请输入11位手机号码" type="text"></td>
                   </tr>
               </table>
                
           </div>
    
       </div>
       <div class="productList">
           <div class="productListTip">确认订单信息</div>
            
           <table class="productListTable">
               <thead>
                   <tr>
                       <th colspan="2" class="productListTableFirstColumn">
                           <img class="tmallbuy" src="img/site/tmallbuy.png">
                           <a class="marketLink" href="#nowhere">店铺：天猫店铺</a>
                           <a class="wangwanglink" href="#nowhere"> <span class="wangwangGif"></span> </a>
                       </th>
                       <th>单价</th>
                       <th>数量</th>
                       <th>小计</th>
                       <th>配送方式</th>
                   </tr>
                   <tr class="rowborder">
                       <td  colspan="2" ></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                   </tr>
               </thead>
               <tbody class="productListTableTbody">
                   <c:forEach items="${ois}" var="oi" varStatus="st" >
                       <tr class="orderItemTR">
                           <td class="orderItemFirstTD"><img class="orderItemImg" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
                           <td class="orderItemProductInfo">
                           <a  href="foreproduct?pid=${oi.product.id}" class="orderItemProductLink">
                               ${oi.product.name}
                           </a>
                            
                               <img src="img/site/creditcard.png" title="支持信用卡支付">
                               <img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">
                               <img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">
                            
                           </td>
                           <td>
                            
                           <span class="orderItemProductPrice">￥<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></span>
                           </td>
                           <td>
                           <span class="orderItemProductNumber">${oi.number}</span>
                           </td>
                           <td><span class="orderItemUnitSum">
                           ￥<fmt:formatNumber type="number" value="${oi.number*oi.product.promotePrice}" minFractionDigits="2"/>
                           </span></td>
                           <c:if test="${st.count==1}">
                           <td rowspan="5"  class="orderItemLastTD">
                           <label class="orderItemDeliveryLabel">
                               <input type="radio" value="" checked="checked">
                               普通配送
                           </label>
                            
                           <select class="orderItemDeliverySelect" class="form-control">
                               <option>快递 免邮费</option>
                           </select>
    
                           </td>
                           </c:if>
                            
                       </tr>
                   </c:forEach>             
                    
               </tbody>
                
           </table>
           <div class="orderItemSumDiv">
               <div class="pull-left">
                   <span class="leaveMessageText">给卖家留言:</span>
                   <span>
                       <img class="leaveMessageImg" src="img/site/leaveMessage.png">
                   </span>
                   <span class="leaveMessageTextareaSpan">
                       <textarea name="userMessage" class="leaveMessageTextarea"></textarea>
                       <div>
                           <span>还可以输入200个字符</span>
                       </div>
                   </span>
               </div>
                
               <span class="pull-right">店铺合计(含运费): ￥<fmt:formatNumber type="number" value="${total}" minFractionDigits="2"/></span>
           </div>
            
       </div>
    
       <div class="orderItemTotalSumDiv">
           <div class="pull-right">
               <span>实付款：</span>
               <span class="orderItemTotalSumSpan">￥<fmt:formatNumber type="number" value="${total}" minFractionDigits="2"/></span>
           </div>
       </div>
        
       <div class="submitOrderDiv">
               <button type="submit" class="submitOrderButton">提交订单</button>
       </div>
     </form>    
   </div>
   ```

   #### 7.3.4  加入购物车

在产品页面点击加入购物车的，除了得到像立即购买运行效果中在OrderItem表里插入一条数据外，把界面上的加入购物车按钮变成灰色并且不可点击

![运行效果](https://img-blog.csdnimg.cn/20200924120221717.png#pic_center)

##### 01 ForeController.addCart

上一步访问地址/foreaddCart导致ForeController.addCart()方法被调用
addCart()方法和立即购买中的 ForeController.buyone()步骤做的事情是一样的，区别在于返回不一样

1. 获取参数pid

2. 获取参数num

3. 根据pid获取产品对象p

4. 从session中获取用户对象user

   ```java
   @RequestMapping("foreaddCart")
       @ResponseBody
       public String addCart(int pid, int num, Model model,HttpSession session) {
           Product p = productService.get(pid);
           User user =(User)  session.getAttribute("user");
           boolean found = false;
    
           List<OrderItem> ois = orderItemService.listByUser(user.getId());
           for (OrderItem oi : ois) {
               if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                   oi.setNumber(oi.getNumber()+num);
                   orderItemService.update(oi);
                   found = true;
                   break;
               }
           }
    
           if(!found){
               OrderItem oi = new OrderItem();
               oi.setUid(user.getId());
               oi.setNumber(num);
               oi.setPid(pid);
               orderItemService.add(oi);
           }
           return "success";
       }
    
   }
   ```

接下来就是新增订单项OrderItem， 新增订单项要考虑两个情况
a. 如果已经存在这个产品对应的OrderItem，并且还没有生成订单，即还在购物车中。 那么就应该在对应的OrderItem基础上，调整数量
a.1 基于用户对象user，查询没有生成订单的订单项集合
a.2 遍历这个集合
a.3 如果产品是一样的话，就进行数量追加
a.4 获取这个订单项的 id

b. 如果不存在对应的OrderItem,那么就新增一个订单项OrderItem
b.1 生成新的订单项
b.2 设置数量，用户和产品
b.3 插入到数据库
b.4 获取这个订单项的 id

与ForeController.buyone() 客户端跳转到结算页面不同的是， 最后返回字符串"success"，表示添加成功

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
 
}
```



#### 7.3.4 查看购物车页面

##### 01 ForeController.cart()

访问地址/forecart导致ForeController.cart()方法被调用

1. 通过session获取当前用户
   所以一定要登录才访问，否则拿不到用户对象,会报错
2. 获取为这个用户关联的订单项集合 ois
3. 把ois放在model中
4. 服务端跳转到cart.jsp

```java
@RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
}
```

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
}
```

##### 02 cart.jsp

与 register.jsp 相仿，cart.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp，

footer.jsp 等公共页面。
中间是产品业务页面 cartPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/simpleSearch.jsp"%>
 
<%@include file="../include/fore/cart/cartPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```



##### 03  cartPage.jsp

从238行到282行，遍历订单项集合ois

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<script>
var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){
 
    $("a.deleteOrderItem").click(function(){
        deleteOrderItem = false;
        var oiid = $(this).attr("oiid")
        deleteOrderItemid = oiid;
        $("#deleteConfirmModal").modal('show');   
    });
    $("button.deleteConfirmButton").click(function(){
        deleteOrderItem = true;
        $("#deleteConfirmModal").modal('hide');
    });
     
    $('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
        if(deleteOrderItem){
            var page="foredeleteOrderItem";
            $.post(
                    page,
                    {"oiid":deleteOrderItemid},
                    function(result){
                        if("success"==result){
                            $("tr.cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
                        }
                        else{
                            location.href="loginPage";
                        }
                    }
                );
             
        }
    }) 
     
    $("img.cartProductItemIfSelected").click(function(){
        var selectit = $(this).attr("selectit")
        if("selectit"==selectit){
            $(this).attr("src","img/site/cartNotSelected.png");
            $(this).attr("selectit","false")
            $(this).parents("tr.cartProductItemTR").css("background-color","#fff");
        }
        else{
            $(this).attr("src","img/site/cartSelected.png");
            $(this).attr("selectit","selectit")
            $(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
        }
        syncSelect();
        syncCreateOrderButton();
        calcCartSumPriceAndNumber();
    });
    $("img.selectAllItem").click(function(){
        var selectit = $(this).attr("selectit")
        if("selectit"==selectit){
            $("img.selectAllItem").attr("src","img/site/cartNotSelected.png");
            $("img.selectAllItem").attr("selectit","false")
            $(".cartProductItemIfSelected").each(function(){
                $(this).attr("src","img/site/cartNotSelected.png");
                $(this).attr("selectit","false");
                $(this).parents("tr.cartProductItemTR").css("background-color","#fff");
            });        
        }
        else{
            $("img.selectAllItem").attr("src","img/site/cartSelected.png");
            $("img.selectAllItem").attr("selectit","selectit")
            $(".cartProductItemIfSelected").each(function(){
                $(this).attr("src","img/site/cartSelected.png");
                $(this).attr("selectit","selectit");
                $(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
            });            
        }
        syncCreateOrderButton();
        calcCartSumPriceAndNumber();
         
    });
     
    $(".orderItemNumberSetting").keyup(function(){
        var pid=$(this).attr("pid");
        var stock= $("span.orderItemStock[pid="+pid+"]").text();
        var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
         
        var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
         
        syncPrice(pid,num,price);
    });
 
    $(".numberPlus").click(function(){
         
        var pid=$(this).attr("pid");
        var stock= $("span.orderItemStock[pid="+pid+"]").text();
        var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
        var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
 
        num++;
        if(num>stock)
            num = stock;
        syncPrice(pid,num,price);
    });
    $(".numberMinus").click(function(){
        var pid=$(this).attr("pid");
        var stock= $("span.orderItemStock[pid="+pid+"]").text();
        var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
         
        var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
        --num;
        if(num<=0)
            num=1;
        syncPrice(pid,num,price);
    });
     
    $("button.createOrderButton").click(function(){
        var params = "";
        $(".cartProductItemIfSelected").each(function(){
            if("selectit"==$(this).attr("selectit")){
                var oiid = $(this).attr("oiid");
                params += "&oiid="+oiid;
            }
        });
        params = params.substring(1);
        location.href="forebuy?"+params;
    });
     
})
 
function syncCreateOrderButton(){
    var selectAny = false;
    $(".cartProductItemIfSelected").each(function(){
        if("selectit"==$(this).attr("selectit")){
            selectAny = true;
        }
    });
     
    if(selectAny){
        $("button.createOrderButton").css("background-color","#C40000");
        $("button.createOrderButton").removeAttr("disabled");
    }
    else{
        $("button.createOrderButton").css("background-color","#AAAAAA");
        $("button.createOrderButton").attr("disabled","disabled");     
    }
         
}
function syncSelect(){
    var selectAll = true;
    $(".cartProductItemIfSelected").each(function(){
        if("false"==$(this).attr("selectit")){
            selectAll = false;
        }
    });
     
    if(selectAll)
        $("img.selectAllItem").attr("src","img/site/cartSelected.png");
    else
        $("img.selectAllItem").attr("src","img/site/cartNotSelected.png");
     
}
function calcCartSumPriceAndNumber(){
    var sum = 0;
    var totalNumber = 0;
    $("img.cartProductItemIfSelected[selectit='selectit']").each(function(){
        var oiid = $(this).attr("oiid");
        var price =$(".cartProductItemSmallSumPrice[oiid="+oiid+"]").text();
        price = price.replace(/,/g, "");
        price = price.replace(/￥/g, "");
        sum += new Number(price);  
         
        var num =$(".orderItemNumberSetting[oiid="+oiid+"]").val();
        totalNumber += new Number(num);
         
    });
     
    $("span.cartSumPrice").html("￥"+formatMoney(sum));
    $("span.cartTitlePrice").html("￥"+formatMoney(sum));
    $("span.cartSumNumber").html(totalNumber);
}
function syncPrice(pid,num,price){
    $(".orderItemNumberSetting[pid="+pid+"]").val(num);
    var cartProductItemSmallSumPrice = formatMoney(num*price);
    $(".cartProductItemSmallSumPrice[pid="+pid+"]").html("￥"+cartProductItemSmallSumPrice);
    calcCartSumPriceAndNumber();
     
    var page = "forechangeOrderItem";
    $.post(
            page,
            {"pid":pid,"number":num},
            function(result){
                if("success"!=result){
                    location.href="login.jsp";
                }
            }
        );
 
}
</script>
 
<title>购物车</title>
<div class="cartDiv">
    <div class="cartTitle pull-right">
        <span>已选商品  (不含运费)</span>
        <span class="cartTitlePrice">￥0.00</span>
        <button class="createOrderButton" disabled="disabled">结 算</button>
    </div>
     
    <div class="cartProductList">
        <table class="cartProductTable">
            <thead>
                <tr>
                    <th class="selectAndImage">
                            <img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">              
                    全选
                     
                    </th>
                    <th>商品信息</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th width="120px">金额</th>
                    <th class="operation">操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ois }" var="oi">
                    <tr oiid="${oi.id}" class="cartProductItemTR">
                        <td>
                            <img selectit="false" oiid="${oi.id}" class="cartProductItemIfSelected" src="img/site/cartNotSelected.png">
                            <a style="display:none" href="#nowhere"><img src="img/site/cartSelected.png"></a>
                            <img class="cartProductImg"  src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg">
                        </td>
                        <td>
                            <div class="cartProductLinkOutDiv">
                                <a href="foreproduct?pid=${oi.product.id}" class="cartProductLink">${oi.product.name}</a>
                                <div class="cartProductLinkInnerDiv">
                                    <img src="img/site/creditcard.png" title="支持信用卡支付">
                                    <img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">
                                    <img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">
                                </div>
                            </div>
                             
                        </td>
                        <td>
                            <span class="cartProductItemOringalPrice">￥${oi.product.originalPrice}</span>
                            <span  class="cartProductItemPromotionPrice">￥${oi.product.promotePrice}</span>
                             
                        </td>
                        <td>
                         
                            <div class="cartProductChangeNumberDiv">
                                <span class="hidden orderItemStock " pid="${oi.product.id}">${oi.product.stock}</span>
                                <span class="hidden orderItemPromotePrice " pid="${oi.product.id}">${oi.product.promotePrice}</span>
                                <a  pid="${oi.product.id}" class="numberMinus" href="#nowhere">-</a>
                                <input pid="${oi.product.id}" oiid="${oi.id}" class="orderItemNumberSetting" autocomplete="off" value="${oi.number}">
                                <a  stock="${oi.product.stock}" pid="${oi.product.id}" class="numberPlus" href="#nowhere">+</a>
                            </div>                   
                         
                         </td>
                        <td >
                            <span class="cartProductItemSmallSumPrice" oiid="${oi.id}" pid="${oi.product.id}" >
                            ￥<fmt:formatNumber type="number" value="${oi.product.promotePrice*oi.number}" minFractionDigits="2"/>
                            </span>
                         
                        </td>
                        <td>
                            <a class="deleteOrderItem" oiid="${oi.id}"  href="#nowhere">删除</a>
                        </td>
                    </tr>
                </c:forEach>             
            </tbody>
         
        </table>
    </div>
     
    <div class="cartFoot">
        <img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">
        <span>全选</span>
<!--         <a href="#">删除</a> -->
         
        <div class="pull-right">
            <span>已选商品 <span class="cartSumNumber" >0</span> 件</span>
             
            <span>合计 (不含运费): </span>
            <span class="cartSumPrice" >￥0.00</span>
            <button class="createOrderButton" disabled="disabled" >结  算</button>
        </div>
         
    </div>
     
</div>
```

#### 7.3.5 登录拦截器

##### 01 查看购物车页面的问题

查看购物车页面有个问题，必须建立在已经登录的状态之上。 如果没有登录，而访问地址：

http://127.0.0.1:8080/tmall_ssm/forecart

会导致异常产生。

所以在查看购物车之前，应该进行登录操作，但是又不能确保用户一定会记得登录，那么怎么办呢？
准备一个过滤器，当访问那些需要登录才能做的页面的时候，进行是否登录的判断，如果不通过，那么就跳转到login.jsp页面去，提示用户登录。



##### 02 LoginInterceptor

新建一个过滤器LoginInterceptor ，根据解决思路中
哪些页面需要登录？哪些页面不需要呢？
a. 不需要登录也可以访问的
如：注册，登录，产品，首页，分类，查询等等
b. 需要登录才能够访问的
如：购买行为，加入购物车行为，查看购物车，查看我的订单等等
不需要登录也可以访问的已经确定了，但是需要登录才能够访问，截止目前为止还不能确定，所以这个过滤器就判断如果不是注册，登录，产品这些，就进行登录校验

1. 准备字符串数组 noNeedAuthPage，存放哪些不需要登录也能访问的路径
2. 获取uri
3. 去掉前缀/tmall_ssm
4. 如果访问的地址是/fore开头
   4.1 取出fore后面的字符串，比如是forecart,那么就取出cart
   4.2 判断cart是否是在noNeedAuthPage
   4.2 如果不在，那么就需要进行是否登录验证
   4.3 从session中取出"user"对象
   4.4 如果对象不存在，就客户端跳转到login.jsp
   4.5 否则就正常执行

```java
package com.how2java.tmall.interceptor;
import java.util.Arrays;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
  
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
     /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
 
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        String[] noNeedAuthPage = new String[]{
                "home",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"};
 
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
//        System.out.println(uri);
        if(uri.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user =(User) session.getAttribute("user");
                if(null==user){
                    response.sendRedirect("loginPage");
                    return false;
                }
            }
        }
 
        return true;
 
    }
  
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
 
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,   
            ModelAndView modelAndView) throws Exception {
 
    }
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
      
    public void afterCompletion(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) 
    throws Exception { 
            
    } 
        
}
```

##### 03 springMVC.xml

在springMVC.xml中新增对登陆状态拦截器的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">
 
    <!--启动注解识别-->
    <context:annotation-config/>
 
    <context:component-scan base-package="com.how2java.tmall.controller">
        <context:include-filter type="annotation"
                                expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
 
    <mvc:annotation-driven />
 
    <!--开通静态资源的访问-->
    <mvc:default-servlet-handler />
 
    <!-- 视图定位 -->
    <bean
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass"
                  value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
 
    <!-- 对上传文件的解析-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/fore*"/>
            <bean class="com.how2java.tmall.interceptor.LoginInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
</beans>
```



##### 7.3.6 其他拦截器

##### 01 OtherInterceptor

```java
package com.how2java.tmall.interceptor;
import java.util.Arrays;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
  
public class OtherInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
     /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return true;
 
    }
  
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
 
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,   
            ModelAndView modelAndView) throws Exception {
        /*这里是获取分类集合信息，用于放在搜索栏下面*/
        List<Category> cs = categoryService.list();
        request.getSession().setAttribute("cs", cs);
 
        /*这里是获取当前的contextPath:tmall_ssm,用与放在左上角那个变形金刚，点击之后才能够跳转到首页，否则点击之后也仅仅停留在当前页面*/
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        request.getSession().setAttribute("contextPath", contextPath);
 
        /*这里是获取购物车中一共有多少数量*/
        User user =(User)  session.getAttribute("user");
        int  cartTotalItemNumber = 0;
        if(null!=user) {
            List<OrderItem> ois = orderItemService.listByUser(user.getId());
            for (OrderItem oi : ois) {
                cartTotalItemNumber+=oi.getNumber();
            }
         
        }
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
 
    }
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
      
    public void afterCompletion(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) 
    throws Exception { 
            
//        System.out.println("afterCompletion(), 在访问视图之后被调用");
    } 
        
}
```

##### 02 springMVC.xml

新增OtherInterceptor拦截器的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">
 
    <!--启动注解识别-->
    <context:annotation-config/>
 
    <context:component-scan base-package="com.how2java.tmall.controller">
        <context:include-filter type="annotation"
                                expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
 
    <mvc:annotation-driven />
 
    <!--开通静态资源的访问-->
    <mvc:default-servlet-handler />
 
    <!-- 视图定位 -->
    <bean
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass"
                  value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
 
    <!-- 对上传文件的解析-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/fore*"/>
            <bean class="com.how2java.tmall.interceptor.LoginInterceptor"/>
        </mvc:interceptor>
        <mvc:interceptor>
            <mvc:mapping path="/fore*"/>
            <bean class="com.how2java.tmall.interceptor.OtherInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
</beans>
```

#### 7.3.6 购物车页面操作

购物车页面和服务端的交互主要是三个

1. 增加、减少某种产品的数量
2. 删除某种产品
3. 选中产品后，提交到结算页面

##### 01 调整订单数量

点击增加或者减少按钮后，根据 cartPage.jsp 中的js代码，会通过Ajax访问/forechangeOrderItem路径，导致ForeController.changeOrderItem()方法被调用

1. 判断用户是否登录
2. 获取pid和number
3. 遍历出用户当前所有的未生成订单的OrderItem
4. 根据pid找到匹配的OrderItem，并修改数量后更新到数据库
5. 返回字符串"success"

```jsp
var page = "forechangeOrderItem";
    $.post(
            page,
            {"pid":pid,"number":num},
            function(result){
                if("success"!=result){
                    location.href="loginPage";
                }
            }
        );
```

```java
@RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
 
}
```



ForeController

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
 
}
```

##### 02 删除订单项

点击删除按钮后，根据 cartPage.jsp 中的js代码，会通过Ajax访问/foredeleteOrderItem路径，导致ForeController.deleteOrderItem方法被调用

1. 判断用户是否登录
2. 获取oiid
3. 删除oiid对应的OrderItem数据
4. 返回字符串"success"

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
}
```

在选中了购物车中的任意商品之后，结算按钮呈现可点击状态。
点击之后，提交到结算页面，并带上(多个)被选中的OrderItem对象的id

http://127.0.0.1:8080/tmall_ssm/forebuy?oiid=2&oiid=1

之后的流程就进入了结算页面



#### 7.3.7 订单状态图

![订单状态图](https://img-blog.csdnimg.cn/20200924120221953.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)



在开始实现订单相关功能之前，我们把订单的状态捋一捋，这样有助于代码思路更加清晰

1. 首先是创建订单，刚创建好之后，订单处于waitPay 待付款状态
2. 接着是付款，付款后，订单处于waitDelivery 待发货状态
3. 前两步都是前台用户操作导致的，接下来需要到后台做发货操作，发货后，订单处于waitConfirm 待确认收货状态
4. 接着又是前台用户进行确认收货操作，操作之后，订单处于waitReview 待评价状态
5. 最后进行评价，评价之后，订单处于finish 完成状态

以上状态都是一个接一个的，不能跳状态进行。
比较特殊的是，无论当前订单处于哪个状态，都可以进行删除操作。 像订单这样极其重要的业务数据，实际上是不允许真正从数据库中删除掉的，而是把状态标记为删除，以表示其被删掉了，所以在删除之后，订单处于 delete 已删除状态



#### 7.3.8 生成订单

首先通过立即购买或者购物车的提交到结算页面 进入结算页面，然后点击提交订单

提交订单后，在数据库中生成一条Order记录。
不仅如此，订单项的oid字段也会被设置为这条Order记录的id

##### 01 applicationContext.xml

因为增加订单行为需要同时修改两个表

1. 为Order表新增数据
2. 修改OrderItem表
   所以需要进行事务管理，否则当新增了Order表的数据，还没有来得及修改OrderItem的时候出问题，比如突然断电，那么OrderItem的数据就会是脏数据了（没有指向正确的Order表数据）。

在最后增加事务管理配置：

```xml
    <!--事务管理-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd">
    <context:annotation-config />
    <context:component-scan base-package="com.how2java.tmall.service" />
 
    <!-- 导入数据库配置文件 -->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!-- 配置数据库连接池 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
 
        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="1" />
        <property name="minIdle" value="1" />
        <property name="maxActive" value="20" />
 
        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="60000" />
 
        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000" />
 
        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="300000" />
 
        <property name="validationQuery" value="SELECT 1" />
        <property name="testWhileIdle" value="true" />
        <property name="testOnBorrow" value="false" />
        <property name="testOnReturn" value="false" />
 
        <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        <property name="poolPreparedStatements" value="true" />
        <property name="maxPoolPreparedStatementPerConnectionSize"
                  value="20" />
    </bean>
 
    <!--Mybatis的SessionFactory配置-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="typeAliasesPackage" value="com.how2java.tmall.pojo" />
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
 
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <value>
                        </value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>
 
    <!--Mybatis的Mapper文件识别-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.how2java.tmall.mapper"/>
    </bean>
 
    <!--事务管理-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
 
</beans>
```



##### 02 OrderService

新增方法 add(Order c,List<OrderItem> ois);

```java
package com.how2java.tmall.service;
  
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
 
public interface OrderService {
 
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
 
    void add(Order c);
 
    float add(Order c,List<OrderItem> ois);
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List list();
}
```



##### 03 OrderServiceImpl

实现add(Order o, List<OrderItem> ois)方法，该方法通过注解进行事务管理

```java
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
```

41-42行代码用来模拟当增加订单后出现异常，观察事务管理是否预期发生。（需要把false修改为true才能观察到）

```java
        if(false)
            throw new RuntimeException();
```

```java
package com.how2java.tmall.service.impl;
 
import java.util.List;
 
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.mapper.OrderMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderExample;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
 
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
 
    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }
 
    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
 
    public float add(Order o, List<OrderItem> ois) {
        float total = 0;
        add(o);
 
        if(false)
            throw new RuntimeException();
 
        for (OrderItem oi: ois) {
            oi.setOid(o.getId());
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }
 
    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }
 
    public List<Order> list(){
        OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
 
    }
 
}
```

##### 04 ForeController.createOrder

提交订单访问路径 /forecreateOrder, 导致ForeController.createOrder 方法被调用

```java
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
 
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total=java"+total;
}

```

1. 从session中获取user对象
2. 通过参数Order接受地址，邮编，收货人，用户留言等信息
3. 根据当前时间加上一个4位随机数生成订单号
4. 根据上述参数，创建订单对象
5. 把订单状态设置为等待支付
6. 从session中获取订单项集合 ( 在结算功能的ForeController.buy() 13行，订单项集合被放到了session中 )
7. 把订单加入到数据库，并且遍历订单项集合，设置每个订单项的order，更新到数据库
8. 统计本次订单的总金额
9. 客户端跳转到确认支付页forealipay，并带上订单id和总金额



```
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
    @RequestMapping("forecreateOrder")
    public String createOrder( Model model,Order order,HttpSession session){
        User user =(User)  session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUid(user.getId());
        order.setStatus(OrderService.waitPay);
        List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
 
        float total =orderService.add(order,ois);
        return "redirect:forealipay?oid="+order.getId() +"&total="+total;
    }
 
}
```

##### 05 确认支付页

1. 在上一步客户端跳转到路径/forealipay方法，导致PageController.alipay()方法被调用。 alipay()没做什么事情，就是服务端跳转到了alipay.jsp页面。

2. alipay.jsp :
   与 register.jsp 相仿，alipay.jsp也包含了header.jsp, top.jsp， footer.jsp 等公共页面。
   中间是确认支付业务页面 alipayPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="../include/fore/header.jsp"%>
  <%@include file="../include/fore/top.jsp"%>
  <%@include file="../include/fore/cart/alipayPage.jsp"%>
  <%@include file="../include/fore/footer.jsp"%>
  ```

  

3. alipayPage.jsp:
   显示总金额，并且让确认支付按钮跳转到页面 /forepayed页面，并带上oid和金额

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div class="aliPayPageDiv">
    <div class="aliPayPageLogo">
        <img class="pull-left" src="img/site/simpleLogo.png">
        <div style="clear:both"></div>
    </div>
     
    <div>
        <span class="confirmMoneyText">扫一扫付款（元）</span>
        <span class="confirmMoney">
        ￥<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"/></span>
         
    </div>
    <div>
        <img class="aliPayImg" src="img/site/alipay2wei.png">
    </div>
 
    <div>
        <a href="forepayed?oid=${param.oid}&total=${param.total}"><button class="confirmPay">确认支付</button></a>
    </div>
 
</div>
```

##### 06 支付成功页

1. 在上一步确认访问按钮提交数据到/forepayed,导致ForeController.payed方法被调用
   1.1 获取参数oid
   1.2 根据oid获取到订单对象order
   1.3 修改订单对象的状态和支付时间
   1.4 更新这个订单对象到数据库
   1.5 把这个订单对象放在model的属性"o"上
   1.6 服务端跳转到payed.jsp

2. payed.jsp
   与 register.jsp 相仿，payed.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。
   中间是支付成功业务页面 payedPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="../include/fore/header.jsp"%>
  <%@include file="../include/fore/top.jsp"%>
  <%@include file="../include/fore/simpleSearch.jsp"%>
  <%@include file="../include/fore/cart/payedPage.jsp"%>
  <%@include file="../include/fore/footer.jsp"%>
  ```

  

3. payedPage.jsp
   显示订单中的地址，邮编，收货人，手机号码等等

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     
<div class="payedDiv">
    <div class="payedTextDiv">
        <img src="img/site/paySuccess.png">
        <span>您已成功付款</span>
         
    </div>
    <div class="payedAddressInfo">
        <ul>
            <li>收货地址：${o.address} ${o.receiver} ${o.mobile }</li>
            <li>实付款：<span class="payedInfoPrice">
            ￥<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"/>
            </li>
            <li>预计08月08日送达    </li>
        </ul>
                 
        <div class="paedCheckLinkDiv">
            您可以
            <a class="payedCheckLink" href="forebought">查看已买到的宝贝</a>
            <a class="payedCheckLink" href="forebought">查看交易详情 </a>
        </div>
             
    </div>
     
    <div class="payedSeperateLine">
    </div>
     
    <div class="warningDiv">
        <img src="img/site/warning.png">
        <b>安全提醒：</b>下单后，<span class="redColor boldWord">用QQ给您发送链接办理退款的都是骗子！</span>天猫不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
    </div>
 
</div>
```



ForeController

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
    @RequestMapping("forecreateOrder")
    public String createOrder( Model model,Order order,HttpSession session){
        User user =(User)  session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUid(user.getId());
        order.setStatus(OrderService.waitPay);
        List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
 
        float total =orderService.add(order,ois);
        return "redirect:forealipay?oid="+order.getId() +"&total="+total;
    }
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
}
```

#### 7.3.9  我的订单页

##### 01 OrderService

修改OrderService，新增方法

```java
 List list(int uid, String excludedStatus);
```

```java
package com.how2java.tmall.service;
 
import java.util.List;
 
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
 
public interface OrderService {
 
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
 
    void add(Order c);
    float add(Order c,List<OrderItem> ois);
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List list();
    List list(int uid, String excludedStatus);
}
```

##### 02 OrderServiceImpl

```java
package com.how2java.tmall.service.impl;
 
import com.how2java.tmall.mapper.OrderMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderExample;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;
 
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
 
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
 
    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }
 
    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }
 
    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }
 
    public List<Order> list(){
        OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
 
    }
 
    @Override
    public List list(int uid, String excludedStatus) {
        OrderExample example =new OrderExample();
        example.createCriteria().andUidEqualTo(uid).andStatusNotEqualTo(excludedStatus);
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
    }
 
    ;
 
    public void setUser(List<Order> os){
        for (Order o : os)
            setUser(o);
    }
    public void setUser(Order o){
        int uid = o.getUid();
        User u = userService.get(uid);
        o.setUser(u);
    }
 
    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
 
    public float add(Order o, List<OrderItem> ois) {
        float total = 0;
        add(o);
 
        if(false)
            throw new RuntimeException();
 
        for (OrderItem oi: ois) {
            oi.setOid(o.getId());
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }
 
}
```

##### 03 ForeController.bought()

/forebought导致ForeController.bought()方法被调用

1. 通过session获取用户user
2. 查询user所有的状态不是"delete" 的订单集合os
3. 为这些订单填充订单项
4. 把os放在model的属性"os"上
5. 服务端跳转到bought.jsp

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
    @RequestMapping("forecreateOrder")
    public String createOrder( Model model,Order order,HttpSession session){
        User user =(User)  session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUid(user.getId());
        order.setStatus(OrderService.waitPay);
        List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
 
        float total =orderService.add(order,ois);
        return "redirect:forealipay?oid="+order.getId() +"&total="+total;
    }
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
}
```

##### 04 bought.jsp

与 register.jsp 相仿，bought.jsp 也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。
中间是我的订单页面 boughtPage.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>
<%@include file="../include/fore/simpleSearch.jsp"%>
<%@include file="../include/fore/cart/boughtPage.jsp"%>
<%@include file="../include/fore/footer.jsp"%>
```

##### 05 boughtPage.jsp

在boughtPage.jsp中，从93行开始到172行，做二次遍历

1. 遍历订单集合os
   取出每个订单，显示其创建日期，订单号，总数量和总金额等
2. 遍历每个订单下的订单项集合o.orderItemsd
   显示每个订单项对应的产品的图片，标题，原始价格，优惠价格等

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  
<script>
var deleteOrder = false;
var deleteOrderid = 0;
 
$(function(){
    $("a[orderStatus]").click(function(){
        var orderStatus = $(this).attr("orderStatus");
        if('all'==orderStatus){
            $("table[orderStatus]").show();
        }
        else{
            $("table[orderStatus]").hide();
            $("table[orderStatus="+orderStatus+"]").show();        
        }
         
        $("div.orderType div").removeClass("selectedOrderType");
        $(this).parent("div").addClass("selectedOrderType");
    });
     
    $("a.deleteOrderLink").click(function(){
        deleteOrderid = $(this).attr("oid");
        deleteOrder = false;
        $("#deleteConfirmModal").modal("show");
    });
     
    $("button.deleteConfirmButton").click(function(){
        deleteOrder = true;
        $("#deleteConfirmModal").modal('hide');
    });
     
    $('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
        if(deleteOrder){
            var page="foredeleteOrder";
            $.post(
                    page,
                    {"oid":deleteOrderid},
                    function(result){
                        if("success"==result){
                            $("table.orderListItemTable[oid="+deleteOrderid+"]").hide();
                        }
                        else{
                            location.href="login.jsp";
                        }
                    }
                );
             
        }
    })     
     
    $(".ask2delivery").click(function(){
        var link = $(this).attr("link");
        $(this).hide();
        page = link;
        $.ajax({
               url: page,
               success: function(result){
                alert("卖家已秒发，刷新当前页面，即可进行确认收货")
               }
            });
         
    });
});
 
</script>
     
<div class="boughtDiv">
    <div class="orderType">
        <div class="selectedOrderType"><a orderStatus="all" href="#nowhere">所有订单</a></div>
        <div><a  orderStatus="waitPay" href="#nowhere">待付款</a></div>
        <div><a  orderStatus="waitDelivery" href="#nowhere">待发货</a></div>
        <div><a  orderStatus="waitConfirm" href="#nowhere">待收货</a></div>
        <div><a  orderStatus="waitReview" href="#nowhere" class="noRightborder">待评价</a></div>
        <div class="orderTypeLastOne"><a class="noRightborder"></a></div>
    </div>
    <div style="clear:both"></div>
    <div class="orderListTitle">
        <table class="orderListTitleTable">
            <tr>
                <td>宝贝</td>
                <td width="100px">单价</td>
                <td width="100px">数量</td>
                <td width="120px">实付款</td>
                <td width="100px">交易操作</td>
            </tr>
        </table>
     
    </div>
     
    <div class="orderListItem">
        <c:forEach items="${os}" var="o">
            <table class="orderListItemTable" orderStatus="${o.status}" oid="${o.id}">
                <tr class="orderListItemFirstTR">
                    <td colspan="2">
                    <b><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></b>
                    <span>订单号: ${o.orderCode}
                    </span>
                    </td>
                    <td  colspan="2"><img width="13px" src="img/site/orderItemTmall.png">天猫商场</td>
                    <td colspan="1">
                        <a class="wangwanglink" href="#nowhere">
                            <div class="orderItemWangWangGif"></div>
                        </a>
                         
                    </td>
                    <td class="orderItemDeleteTD">
                        <a class="deleteOrderLink" oid="${o.id}" href="#nowhere">
                            <span  class="orderListItemDelete glyphicon glyphicon-trash"></span>
                        </a>
                         
                    </td>
                </tr>
                <c:forEach items="${o.orderItems}" var="oi" varStatus="st">
                    <tr class="orderItemProductInfoPartTR" >
                        <td class="orderItemProductInfoPartTD"><img width="80" height="80" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
                        <td class="orderItemProductInfoPartTD">
                            <div class="orderListItemProductLinkOutDiv">
                                <a href="foreproduct?pid=${oi.product.id}">${oi.product.name}</a>
                                <div class="orderListItemProductLinkInnerDiv">
                                            <img src="img/site/creditcard.png" title="支持信用卡支付">
                                            <img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">
                                            <img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">                      
                                </div>
                            </div>
                        </td>
                        <td  class="orderItemProductInfoPartTD" width="100px">
                         
                            <div class="orderListItemProductOriginalPrice">￥<fmt:formatNumber type="number" value="${oi.product.originalPrice}" minFractionDigits="2"/></div>
                            <div class="orderListItemProductPrice">￥<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></div>
         
                        </td>
                        <c:if test="${st.count==1}">
                          
                            <td valign="top" rowspan="${fn:length(o.orderItems)}" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
                                <span class="orderListItemNumber">${o.totalNumber}</span>
                            </td>
                            <td valign="top" rowspan="${fn:length(o.orderItems)}" width="120px" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
                                <div class="orderListItemProductRealPrice">￥<fmt:formatNumber  minFractionDigits="2"  maxFractionDigits="2" type="number" value="${o.total}"/></div>
                                <div class="orderListItemPriceWithTransport">(含运费：￥0.00)</div>
                            </td>
                            <td valign="top" rowspan="${fn:length(o.orderItems)}" class="orderListItemButtonTD orderItemOrderInfoPartTD" width="100px">
                                <c:if test="${o.status=='waitConfirm' }">
                                    <a href="foreconfirmPay?oid=${o.id}">
                                        <button class="orderListItemConfirm">确认收货</button>
                                    </a>
                                </c:if>
                                <c:if test="${o.status=='waitPay' }">
                                    <a href="forealipay?oid=${o.id}&total=${o.total}">
                                        <button class="orderListItemConfirm">付款</button>
                                    </a>                             
                                </c:if>
                                 
                                <c:if test="${o.status=='waitDelivery' }">
                                    <span>待发货</span>
<%--                                     <button class="btn btn-info btn-sm ask2delivery" link="admin_order_delivery?id=${o.id}">催卖家发货</button> --%>
                                     
                                </c:if>
 
                                <c:if test="${o.status=='waitReview' }">
                                    <a href="forereview?oid=${o.id}">
                                        <button  class="orderListItemReview">评价</button>
                                    </a>
                                </c:if>
                            </td>                    
                        </c:if>
                    </tr>
                </c:forEach>     
                 
            </table>
        </c:forEach>
         
    </div>
     
</div>
```

#### 7.3.10 我的订单页操作

在我的订单页面，根据订单的不同状态，可以做出如下不同的操作：

1. 付款 —— 已经生成，但是未付款

   点击付款按钮直接跳转到在生成订单中的确认支付页环节，属于已经开发的功能，在此不作赘述。

2. 确认收货 —— 通过后台发货后

3. 评价 —— 确认收货后, 讲在评价产品知识点讲解，这里只是提到

4. 删除 —— 任意状态下

##### 01 确认收货

1. 点击确认收货后，访问地址/foreconfirmPay

2. ForeController.confirmPay()方法被调用
   2.1 获取参数oid
   2.2 通过oid获取订单对象o
   2.3 为订单对象填充订单项
   2.4 把订单对象放在request的属性"o"上
   2.5 服务端跳转到 confirmPay.jsp

3. confirmPay.jsp
   与 register.jsp 相仿，confirmPay.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。
   中间是订单确认业务页面 confirmPayPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="../include/fore/header.jsp"%>
  <%@include file="../include/fore/top.jsp"%>
  <%@include file="../include/fore/simpleSearch.jsp"%>
  <%@include file="../include/fore/cart/confirmPayPage.jsp"%>
  <%@include file="../include/fore/footer.jsp"%>
  ```

  

4. confirmPayPage.jsp
   显示订单的创建时间，付款时间和发货时间，以及订单号，收款人信息等
   遍历订单项集合，显示其中的产品图片，产品标题，价格，数量，小计，总结信息
   最后提供确认支付按钮，提交到/foreorderconfirmed路径

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
       
  <div class="confirmPayPageDiv">
      <div class="confirmPayImageDiv">
          <img src="img/site/comformPayFlow.png">
          <div  class="confirmPayTime1">
              <fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
          </div>
          <div  class="confirmPayTime2">
              <fmt:formatDate value="${o.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
          </div>
          <div class="confirmPayTime3">
              yyyy-MM-dd HH:mm:ss
          </div>
           
      </div>
      <div class="confirmPayOrderInfoDiv">
          <div class="confirmPayOrderInfoText">我已收到货，同意支付宝付款</div>
      </div>
      <div class="confirmPayOrderItemDiv">
          <div class="confirmPayOrderItemText">订单信息</div>
          <table class="confirmPayOrderItemTable">
              <thead>
                  <th colspan="2">宝贝</th>    
                  <th width="120px">单价</th>      
                  <th width="120px">数量</th>      
                  <th width="120px">商品总价 </th>       
                  <th width="120px">运费</th>      
              </thead>
              <c:forEach items="${o.orderItems}" var="oi">
                  <tr>
                      <td><img width="50px" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
                      <td class="confirmPayOrderItemProductLink">
                          <a href="#nowhere">${oi.product.name}</a>
                      </td>
                      <td>￥<fmt:formatNumber type="number" value="${oi.product.originalPrice}" minFractionDigits="2"/></td>
                      <td>1</td>
                      <td><span class="conformPayProductPrice">￥<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></span></td>
                      <td><span>快递 ： 0.00 </span></td>
                  </tr>
              </c:forEach>
          </table>
           
          <div class="confirmPayOrderItemText pull-right">
              实付款： <span class="confirmPayOrderItemSumPrice">￥<fmt:formatNumber type="number" value="${o.total}" minFractionDigits="2"/></span>
          </div>
           
      </div>
      <div class="confirmPayOrderDetailDiv">
           
          <table class="confirmPayOrderDetailTable">
              <tr>
                  <td>订单编号：</td>
                  <td>${o.orderCode} <img width="23px" src="img/site/confirmOrderTmall.png"></td>
              </tr>
              <tr>
                  <td>卖家昵称：</td>
                  <td>天猫商铺 <span class="confirmPayOrderDetailWangWangGif"></span></td>
              </tr>
              <tr>
                  <td>收货信息： </td>
                  <td>${o.address}，${o.receiver}， ${o.mobile}，${o.post} </td>
              </tr>
              <tr>
                  <td>成交时间：</td>
                  <td><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
              </tr>
          </table>
           
      </div>
      <div class="confirmPayButtonDiv">
          <div class="confirmPayWarning">请收到货后，再确认收货！否则您可能钱货两空！</div>
          <a href="foreorderConfirmed?oid=${o.id}"><button class="confirmPayButton">确认支付</button></a>
      </div>
  </div>
  ```

  

ForeController

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
  
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total="+total;
}
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
    @RequestMapping("foreconfirmPay")
    public String confirmPay( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("o", o);
        return "fore/confirmPay";
    }
}
```

##### 02 确认收货成功

通过上一步最后的确认支付按钮，提交到路径/foreorderConfirmed，导致ForeController.orderConfirmed()方法被调用

1. ForeController.orderConfirmed() 方法
   1.1 获取参数oid
   1.2 根据参数oid获取Order对象o
   1.3 修改对象o的状态为等待评价，修改其确认支付时间
   1.4 更新到数据库
   1.5 服务端跳转到orderConfirmed.jsp页面

2. orderConfirmed.jsp
   与 register.jsp 相仿，orderConfirmed.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp， footer.jsp 等公共页面。
   中间是确认收货成功业务页面 orderConfirmedPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="../include/fore/header.jsp"%>
  <%@include file="../include/fore/top.jsp"%>
  <%@include file="../include/fore/simpleSearch.jsp"%>
  <%@include file="../include/fore/cart/orderConfirmedPage.jsp"%>
  <%@include file="../include/fore/footer.jsp"%>
  ```

  

3. orderConfirmedPage.jsp
   显示"交易已经成功，卖家将收到您的货款。"

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
       
  <div class="orderFinishDiv">
      <div class="orderFinishTextDiv">
          <img src="img/site/orderFinish.png">
          <span>交易已经成功，卖家将收到您的货款。</span>
      </div>
  </div>
  ```

  

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
  
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total="+total;
}
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
    @RequestMapping("foreconfirmPay")
    public String confirmPay( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("o", o);
        return "fore/confirmPay";
    }
    @RequestMapping("foreorderConfirmed")
    public String orderConfirmed( Model model,int oid) {
        Order o = orderService.get(oid);
        o.setStatus(OrderService.waitReview);
        o.setConfirmDate(new Date());
        orderService.update(o);
        return "fore/orderConfirmed";
    }
}
```

##### 03 评价

点击评价按钮，跳转到路径/forereview

##### 04 删除

在我的订单页 上点击删除按钮，根据 boughtPage.jsp 中的ajax操作，会访问路径/foredeleteOrder，导致ForeController.deleteOrder方法被调用

1. ForeController.deleteOrder()
   1.1 获取参数oid
   1.2 根据oid获取订单对象o
   1.3 修改状态
   1.4 更新到数据库
   1.5 返回字符串"success"
2. boughtPage.jsp 中的javascript代码获取返回字符串是success的时候，隐藏掉当前这行订单数据。

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
  
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total="+total;
}
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
    @RequestMapping("foreconfirmPay")
    public String confirmPay( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("o", o);
        return "fore/confirmPay";
    }
    @RequestMapping("foreorderConfirmed")
    public String orderConfirmed( Model model,int oid) {
        Order o = orderService.get(oid);
        o.setStatus(OrderService.waitReview);
        o.setConfirmDate(new Date());
        orderService.update(o);
        return "fore/orderConfirmed";
    }
    @RequestMapping("foredeleteOrder")
    @ResponseBody
    public String deleteOrder( Model model,int oid){
        Order o = orderService.get(oid);
        o.setStatus(OrderService.delete);
        orderService.update(o);
        return "success";
    }
}
```

#### 7.3.11 评价产品

##### 01 评价产品页面

通过点击评价按钮，来到路径/forereview，导致ForeController.review()方法被调用

1. ForeController.review()
   1.1 获取参数oid
   1.2 根据oid获取订单对象o
   1.3 为订单对象填充订单项
   1.4 获取第一个订单项对应的产品,因为在评价页面需要显示一个产品图片，那么就使用这第一个产品的图片了
   1.5 获取这个产品的评价集合
   1.6 为产品设置评价数量和销量
   1.7 把产品，订单和评价集合放在request上
   1.8 服务端跳转到 review.jsp

2. review.jsp
   与 register.jsp 相仿，review.jsp也包含了header.jsp, top.jsp, simpleSearch.jsp，
   footer.jsp 等公共页面。
   中间是产品业务页面 reviewPage.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
   
  <%@include file="../include/fore/header.jsp"%>
  <%@include file="../include/fore/top.jsp"%>
  <%@include file="../include/fore/simpleSearch.jsp"%>
  <%@include file="../include/fore/cart/reviewPage.jsp"%>
  <%@include file="../include/fore/footer.jsp"%>
  ```

  

3. reviewPage.jsp
   在reviewPage.jsp中显示产品图片，产品标题，价格，产品销量，产品评价数量，以及订单信息等。
   同时还显示出了该产品所有的评价，但是默认是隐藏的

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8" isELIgnored="false"%>
       
  <div class="reviewDiv">
      <div class="reviewProductInfoDiv">
          <div class="reviewProductInfoImg"><img width="400px" height="400px" src="img/productSingle/${p.firstProductImage.id}.jpg"></div>
          <div class="reviewProductInfoRightDiv">
              <div class="reviewProductInfoRightText">
                  ${p.name}
              </div>
              <table class="reviewProductInfoTable">
                  <tr>
                      <td width="75px">价格:</td>
                      <td><span class="reviewProductInfoTablePrice">￥<fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/></span> 元 </td>
                  </tr>
                  <tr>
                      <td>配送</td>
                      <td>快递:  0.00</td>
                  </tr>
                  <tr>
                      <td>月销量:</td>
                      <td><span class="reviewProductInfoTableSellNumber">${p.saleCount}</span> 件</td>
                  </tr>
              </table>
               
              <div class="reviewProductInfoRightBelowDiv">
                  <span class="reviewProductInfoRightBelowImg"><img1 src="img/site/reviewLight.png"></span>
                  <span class="reviewProductInfoRightBelowText" >现在查看的是 您所购买商品的信息
  于<fmt:formatDate value="${o.createDate}" pattern="yyyy年MM月dd"/>下单购买了此商品 </span>
               
              </div>
          </div>
          <div style="clear:both"></div>
      </div>
      <div class="reviewStasticsDiv">
          <div class="reviewStasticsLeft">
                  <div class="reviewStasticsLeftTop"></div>
                  <div class="reviewStasticsLeftContent">累计评价 <span class="reviewStasticsNumber"> ${p.reviewCount}</span></div>
                  <div class="reviewStasticsLeftFoot"></div>
          </div>
          <div class="reviewStasticsRight">
              <div class="reviewStasticsRightEmpty"></div>
              <div class="reviewStasticsFoot"></div>
          </div>
      </div>       
       
      <c:if test="${param.showonly==true}">
      <div class="reviewDivlistReviews">
          <c:forEach items="${reviews}" var="r">
              <div class="reviewDivlistReviewsEach">
                  <div class="reviewDate"><fmt:formatDate value="${r.createDate}" pattern="yyyy-MM-dd"/></div>
                  <div class="reviewContent">${r.content}</div>
                  <div class="reviewUserInfo pull-right">${r.user.anonymousName}<span class="reviewUserInfoAnonymous">(匿名)</span></div>
              </div>
          </c:forEach>
      </div>
      </c:if>
       
      <c:if test="${param.showonly!=true}">
          <div class="makeReviewDiv">
          <form method="post" action="foredoreview">
              <div class="makeReviewText">其他买家，需要你的建议哦！</div>
              <table class="makeReviewTable">
                  <tr>
                      <td class="makeReviewTableFirstTD">评价商品</td>
                      <td><textarea name="content"></textarea></td>
                  </tr>
              </table>
              <div class="makeReviewButtonDiv">
                  <input type="hidden" name="oid" value="${o.id}">
                  <input type="hidden" name="pid" value="${p.id}">
                  <button type="submit">提交评价</button>
              </div>
          </form>
          </div>   
      </c:if>
   
  </div>
  ```

  ForeController

  

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
  
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total="+total;
}
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
    @RequestMapping("foreconfirmPay")
    public String confirmPay( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("o", o);
        return "fore/confirmPay";
    }
    @RequestMapping("foreorderConfirmed")
    public String orderConfirmed( Model model,int oid) {
        Order o = orderService.get(oid);
        o.setStatus(OrderService.waitReview);
        o.setConfirmDate(new Date());
        orderService.update(o);
        return "fore/orderConfirmed";
    }
    @RequestMapping("foredeleteOrder")
    @ResponseBody
    public String deleteOrder( Model model,int oid){
        Order o = orderService.get(oid);
        o.setStatus(OrderService.delete);
        orderService.update(o);
        return "success";
    }
    @RequestMapping("forereview")
    public String review( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        Product p = o.getOrderItems().get(0).getProduct();
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
        model.addAttribute("p", p);
        model.addAttribute("o", o);
        model.addAttribute("reviews", reviews);
        return "fore/review";
    }
 
}
```



##### 02 提交评价

在评价产品页面点击提交评价，就把数据提交到了/foredoreview路径，导致ForeController.doreview方法被调用

1. ForeController.doreview()
   1.1 获取参数oid
   1.2 根据oid获取订单对象o
   1.3 修改订单对象状态
   1.4 更新订单对象到数据库
   1.5 获取参数pid
   1.6 根据pid获取产品对象
   1.7 获取参数content (评价信息)
   1.8 对评价信息进行转义，道理同注册ForeController.register()
   1.9 从session中获取当前用户
   1.10 创建评价对象review
   1.11 为评价对象review设置 评价信息，产品，时间，用户
   1.12 增加到数据库
   1.13.客户端跳转到/forereview： 评价产品页面，并带上参数showonly=true
2. reviewPage.jsp
   在reviewPage.jsp中，当参数showonly==true，那么就显示当前产品的所有评价信息

```java
package com.how2java.tmall.controller;
 
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.*;
import com.how2java.tmall.service.*;
import comparator.*;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
 
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
 
            return "fore/register";
        }
        userService.add(user);
 
        return "redirect:registerSuccessPage";
    }
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
 
    @RequestMapping("foreproduct")
    public String product( int pid, Model model) {
        Product p = productService.get(pid);
 
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        List<ProductImage> productDetailImages = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImages);
 
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
 
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
 
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    @RequestMapping("forecategory")
    public String category(int cid,String sort, Model model) {
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
 
        if(null!=sort){
            switch(sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date" :
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
 
                case "saleCount" :
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
 
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                    break;
 
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                    break;
            }
        }
 
        model.addAttribute("c", c);
        return "fore/category";
    }
 
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Product> ps= productService.search(keyword);
        productService.setSaleAndReviewNumber(ps);
        model.addAttribute("ps",ps);
        return "fore/searchResult";
    }
    @RequestMapping("forebuyone")
    public String buyone(int pid, int num, HttpSession session) {
        Product p = productService.get(pid);
        int oiid = 0;
 
        User user =(User)  session.getAttribute("user");
        boolean found = false;
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
            oiid = oi.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
 
    @RequestMapping("forebuy")
    public String buy( Model model,String[] oiid,HttpSession session){
        List<OrderItem> ois = new ArrayList<>();
        float total = 0;
 
        for (String strid : oiid) {
            int id = Integer.parseInt(strid);
            OrderItem oi= orderItemService.get(id);
            total +=oi.getProduct().getPromotePrice()*oi.getNumber();
            ois.add(oi);
        }
 
        session.setAttribute("ois", ois);
        model.addAttribute("total", total);
        return "fore/buy";
    }
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(int pid, int num, Model model,HttpSession session) {
        Product p = productService.get(pid);
        User user =(User)  session.getAttribute("user");
        boolean found = false;
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==p.getId().intValue()){
                oi.setNumber(oi.getNumber()+num);
                orderItemService.update(oi);
                found = true;
                break;
            }
        }
 
        if(!found){
            OrderItem oi = new OrderItem();
            oi.setUid(user.getId());
            oi.setNumber(num);
            oi.setPid(pid);
            orderItemService.add(oi);
        }
        return "success";
    }
    @RequestMapping("forecart")
    public String cart( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        model.addAttribute("ois", ois);
        return "fore/cart";
    }
 
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeOrderItem( Model model,HttpSession session, int pid, int number) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
 
        List<OrderItem> ois = orderItemService.listByUser(user.getId());
        for (OrderItem oi : ois) {
            if(oi.getProduct().getId().intValue()==pid){
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
 
        }
        return "success";
    }
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem( Model model,HttpSession session,int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return "fail";
        orderItemService.delete(oiid);
        return "success";
    }
 
@RequestMapping("forecreateOrder")
public String createOrder( Model model,Order order,HttpSession session){
    User user =(User)  session.getAttribute("user");
    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
    order.setOrderCode(orderCode);
    order.setCreateDate(new Date());
    order.setUid(user.getId());
    order.setStatus(OrderService.waitPay);
    List<OrderItem> ois= (List<OrderItem>)  session.getAttribute("ois");
  
    float total =orderService.add(order,ois);
    return "redirect:forealipay?oid="+order.getId() +"&total="+total;
}
 
    @RequestMapping("forepayed")
    public String payed(int oid, float total, Model model) {
        Order order = orderService.get(oid);
        order.setStatus(OrderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        return "fore/payed";
    }
 
    @RequestMapping("forebought")
    public String bought( Model model,HttpSession session) {
        User user =(User)  session.getAttribute("user");
        List<Order> os= orderService.list(user.getId(),OrderService.delete);
 
        orderItemService.fill(os);
 
        model.addAttribute("os", os);
 
        return "fore/bought";
    }
 
    @RequestMapping("foreconfirmPay")
    public String confirmPay( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("o", o);
        return "fore/confirmPay";
    }
    @RequestMapping("foreorderConfirmed")
    public String orderConfirmed( Model model,int oid) {
        Order o = orderService.get(oid);
        o.setStatus(OrderService.waitReview);
        o.setConfirmDate(new Date());
        orderService.update(o);
        return "fore/orderConfirmed";
    }
    @RequestMapping("foredeleteOrder")
    @ResponseBody
    public String deleteOrder( Model model,int oid){
        Order o = orderService.get(oid);
        o.setStatus(OrderService.delete);
        orderService.update(o);
        return "success";
    }
    @RequestMapping("forereview")
    public String review( Model model,int oid) {
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        Product p = o.getOrderItems().get(0).getProduct();
        List<Review> reviews = reviewService.list(p.getId());
        productService.setSaleAndReviewNumber(p);
        model.addAttribute("p", p);
        model.addAttribute("o", o);
        model.addAttribute("reviews", reviews);
        return "fore/review";
    }
    @RequestMapping("foredoreview")
    public String doreview( Model model,HttpSession session,@RequestParam("oid") int oid,@RequestParam("pid") int pid,String content) {
        Order o = orderService.get(oid);
        o.setStatus(OrderService.finish);
        orderService.update(o);
 
        Product p = productService.get(pid);
        content = HtmlUtils.htmlEscape(content);
 
        User user =(User)  session.getAttribute("user");
        Review review = new Review();
        review.setContent(content);
        review.setPid(pid);
        review.setCreateDate(new Date());
        review.setUid(user.getId());
        reviewService.add(review);
 
        return "redirect:forereview?oid="+oid+"&showonly=true";
    }
 
}
```



#### 7.4 index.jsp

tmall_ssm\src\main\webapp\index.jsp

```jsp
<%
    response.sendRedirect("forehome");
%>
```





## 8 项目总结

### 8.1 项目结构

1. 项目名称 tmall_ssm
2. java源代码包结构
   pojo 实体类
   mapper Mapper类
   interceptor 拦截器
   controller 控制层
   service Service层
   test 测试类
   util 工具类
   comparator 比较类
3. web目录
   css css文件
   img 图片资源
   js js文件
   admin 后台管理用到的jsp文件
   fore 前台展示用到的jsp文件
   include 被包含的jsp文件

![项目结构](https://img-blog.csdnimg.cn/20200924120221764.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDU5MzQz,size_16,color_FFFFFF,t_70#pic_center)

### 8.2 典型场景

经过这个项目，我们都完成了如下的一系列典型场景功能

1. 购物车
   立即购买 加入购物车 查看购物车页面 购物车页面操作
2. 订单状态流转
   生成订单 确认支付 后台发货 确认收货 评价
3. CRUD
   后台各种功能
4. 分页
   后台各种功能
5. 一类产品多属性配置
   属性管理
6. 一款产品多图片维护
   产品图片管理
7. 产品展示
   前台首页 前台产品页
8. 搜索查询
   搜索
9. 登录、注册
   注册 登录 退出
10. 登录验证
    登录状态拦截器
11. 事务管理
    ForeController.对createOrder进行事务管理
    等等 。。。

### 8.3 设计模式

1. MVC
   MVC设计模式贯穿于整个后台与前台功能开发始末

2. 重构
   通过发现问题，分析问题，解决问题的三部曲，进行了各种角度的重构。经历这样一个重构过程提高开发效率，降低维护成本
   分页方式 ，分类逆向工程 ，所有逆向工程


3. 统一的分页查询简化开发
   所有的后台都使用同一个分页机制，仅仅需要一份简化的adminPage.jsp即满足了各种分页功能的需求，简化了开发，提升了开发速度。

4. 模块化JSP设计
   从大的JSP文件中，通过JSP包含关系抽象出多个公共文件，并把业务JSP按照功能，设计为多个小的JSP文件，便于维护和理解