JavaWeb

### 1 基本概念

#### 1.1前言

web开发：

+ 静态web：html css
  + 提供给所有人看的数据始终不会发生变化
+ 动态web:
  + 提供给所有人看的数据会发生变化
  + 几乎所有网站都是动态web
  + 常用技术栈：Servlet/JSP ASP PHP 

在java中，动态web资源开发的技术统称为javaweb

#### 1.2 web应用程序

web应用程序：指的是可以提供浏览器访问的程序

+ 平时能访问到的任何一个页面或者资源，都存在于这个世界的某一个角落的计算机上
+ URL
+ 这个同一的web资源都会被放在同一个文件夹下，web应用程序 --》Tomcat:服务器
+ 一个web应用由多部分组成（静态Web \ 动态Web）
  + html css js 
  + jsp servlet
  + java程序
  + jar包
  + 配置文件（properties）

web应用程序编写完成后，若想提供给外界访问：需要一个服务器来统一管理；

#### 1.3 静态Web

+ *.html *.htm 这些都是网页的后缀，如果服务器上一直存在这些东西，我们就可以直接进行读取，

![image-20230216195338788](JavaWeb.assets/image-20230216195338788.png)==静态web存在的缺点==

+ Web页面无法动态更新，所有用户看到的都是同一个页面
+ 轮播图，点击特效：伪动态
  + JavaScript
  + VBscript
+ 无法和数据库交互（数据无法持久化，用户无法交互）

#### 1.4 动态Web

页面会动态展示：“Web的页面展示的效果因人而异”

![image-20230216200434834](JavaWeb.assets/image-20230216200434834.png)

**缺点**：

+ 假如服务器的动态web资源出现了错误，我们需要重新编写我们的**后台程序**，重新发布——停机维护

**优点：**

+ Web页面可以动态更新，所有用户看到都不是同一页面
+ 可以与数据库交互（数据持久化：注册，商品信息，用户信息.....）

![image-20230216200806461](JavaWeb.assets/image-20230216200806461.png)



### 2 Web服务器

#### 2.1 技术相关

ASP:微软做的，国内最早流行的就是ASP.ASP就是在HTML中嵌入了VB脚本，ASP+COM

​		在ASP开发中基本一个页面都有几千行的业务代码，页面及其混乱

​		维护成本高

​		C#

​		IIS

![image-20230216201316418](JavaWeb.assets/image-20230216201316418.png)

 JSP/Servlet:sun公司主推的B/S（浏览和服务器）架构

​						基于java语言的（公司或一些开源的组件都是用java写的）

​						可以承载三高问题带来的影响

​						语法像ASP

 PHP：开发速度快，功能强大，跨平台，代码简单

​			无法承载大量访问的情况

#### 2.2 服务器相关

服务器是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息



**IIS**

![image-20230216203305715](JavaWeb.assets/image-20230216203305715.png)

**Tomcat：**Tomcat是Apache 软件基金会的[Jakarta](https://baike.baidu.com/item/Jakarta/15952232?fromModule=lemma_inlink) 项目中的一个核心项目，由于有了Sun 的参与和支持，最新的Servlet 和[JSP](https://baike.baidu.com/item/JSP/141543?fromModule=lemma_inlink) 规范总是能在Tomcat 中得到体现，Tomcat 技术先进、性能稳定，而且免费，因而成为比较流行的Web [应用服务器](https://baike.baidu.com/item/应用服务器/4971773?fromModule=lemma_inlink)。

​					Tomcat 服务器是一个免费的[开放源代码](https://baike.baidu.com/item/开放源代码/114160?fromModule=lemma_inlink)的[Web](https://baike.baidu.com/item/Web/150564?fromModule=lemma_inlink) 应用服务器，属于轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。

​					Tomcat 实际上运行JSP 页面和Servlet。Tomcat最新版本为10.0.23**。**

### 3 Tomcat

#### 3.1 Tomcat安装

https://tomcat.apache.org/

![image-20230216203953076](JavaWeb.assets/image-20230216203953076.png)



#### 3.2 Tomcat 启动和配置

文件夹信息

![image-20230216204330570](JavaWeb.assets/image-20230216204330570.png)

**启动.关闭Tomcat**

+ bin文件目录下——》startup.bat文件双击启动

![image-20230216204621830](JavaWeb.assets/image-20230216204621830.png)

+ bin文件目录下——》shutdown.bat文件双击关闭

![image-20230216204630975](JavaWeb.assets/image-20230216204630975.png)

**访问测试**：http://localhost:8080/

可能遇到的问题：

+ 1.java环境变量没有配置
+ 闪退问题：需要配置兼容性
+ 乱码：配置文件中设置

#### 3.3 配置

![image-20230216212110472](JavaWeb.assets/image-20230216212110472.png)

**可以配置启动的端口号**

Tomcat默认的端口号：8080

mysql：3306

http：80

https：443



```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

可以配置主机的名称

+ 默认的主机名为：localhost
+ 默认网站应用存放的位置：webapps

```xml
<Host name="localhost"  appBase="webapps"
   unpackWARs="true" autoDeploy="true">
```

==面试题（高难度）==：

网站是如何进行访问的？

1 输入域名——》回车

2 检查本机的C:\Windows\System32\drivers\etc\hosts配置文件下有没有这个域名映射；

![image-20230216214415252](JavaWeb.assets/image-20230216214415252.png)

 		有——》直接返回对应的ip地址，这个地址中有我们需要访问的web程序，可以直接访问

​		没有——》就去DNS服务器找，找到的话就返回，找不到就报错

![image-20230216214454604](JavaWeb.assets/image-20230216214454604.png)

#### 3.4 发布一个Web网站



+ 将自己写的网站放到服务器（Tomcat）中指定的web应用的文件夹（webapps）下就可以访问了，网站应有的结构

  ```java
  --webapps ; Tomcat服务器的web目录
  	-ROOT
  	-kuangstudy：网站的目录名
  		-WEB-INF
  			-classes：java程序
  			-lib：web应用所依赖的jar包
  			-web.xml ; 网站配置文件
  		- index.html 默认的首页
  		- static 
  			- css
  				-style。css
  			-js
  			-img
              - ......
  ```

  

### 4 http

#### 4.1 什么是HTTP

超文本传输协议（Hyper Text [Transfer Protocol](https://baike.baidu.com/item/Transfer Protocol/612755?fromModule=lemma_inlink)，HTTP）是一个简单的请求-响应协议，它通常运行在[TCP](https://baike.baidu.com/item/TCP/33012?fromModule=lemma_inlink)之上。

文本：html,字符串

超文本：图片，音乐，视频....

**http默认端口**：80

**https默认端口**：443（s：secure 安全）

#### **4.2 两个时代**

+ http 1.0

​			http/1.0:客户端可以与web服务器连接，只能获得一个web资源，断开连接

+ http 2.0

​			http/1.1：客户端可以与web服务器连接，可以获得多个web资源

​			

#### 4.3 Http请求

+ 客户端--发请求--服务器

以百度为例

```java
Request URL: https://www.baidu.com/   请求地址
Request Method: GET     get方法/post方法
Status Code: 200 OK     状态码：200
Remote Address: 36.152.44.96:443    远程地址
Referrer Policy: strict-origin-when-cross-origin
```

```java
Accept: text/html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9   语言
Connection: keep-alive

```

1、 **请求行**

+ 请求行中的请求方式：GET
+ 请求方式：GET/POST ，HEAD,DELETE,PUT,TRACT...
  + get：一次请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效
  + post：一次请求能够携带的参数没有限制，大小无限制，不会在浏览器的URL地址栏显示数据内容，安全，但不高效

2、**消息头**

![image-20230217093251480](JavaWeb.assets/image-20230217093251480.png)

```
Accept：告诉浏览器它所支持的类型
Accept-Encoding：支持哪种编码格式   GBK UTF-8 GB2312
Accept-Language：告诉浏览器它的语言环境
Cache-Control：缓存控制
Connection：告诉浏览器，请求完成是断开还是保持连接
HOST：主机。。。
```



#### 4.4 Http响应

+ 服务器--发请求--客户端

以百度为例

```java

Cache-Control: private     缓存控制
Connection: keep-alive     连接
Content-Encoding: gzip		编码
Content-Type: text/html 	类型
```

1 **响应体**

```
Accept：告诉浏览器它所支持的类型
Accept-Encoding：支持哪种编码格式   GBK UTF-8 GB2312
Accept-Language：告诉浏览器它的语言环境
Cache-Control：缓存控制
Connection：告诉浏览器，请求完成是断开还是保持连接
HOST：主机。。。
Reflush：告诉客户端多久刷新，定时刷新
Location：让网页重新定位
```

2 **响应状态码**

200：代表请求成功

3××：请求重定向

404：找不到资源

5××：服务器代码错误

**常见面试题：当浏览器地址栏中输入地址并回车的一瞬间到页面能够展示回来，经历了什么？**



### 5 Maven

#### 5.1 Maven项目架构管理工具

用来方便导入jar包

Maven的核心思想：约定大于配置

+ 制定的规则一定要照做

Maven会规定好如何去编写java代码

#### 5.2 下载安装maven

官网下载完解压即可

#### 5.3 配置环境变量

在系统环境变量中，配置如下配置：

+ M2_HOME  MAVEN目录下的bin目录
+ MAVEN_HOME  maven的目录
+ 在系统的path中配置MAVEN_HOME   bin目录

测试Maven是否安装成功：

+ cmd终端 —— mvn -version

  ![image-20230217095749725](JavaWeb.assets/image-20230217095749725.png)

#### 5.4 阿里云镜像

阿里云镜像

```
	<mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
```

![image-20230217100022938](JavaWeb.assets/image-20230217100022938.png)

#### 5.5 本地仓库

![image-20230217100114627](JavaWeb.assets/image-20230217100114627.png)

#### 5.6 在IDEA中使用Maven

1 启动IDEA

2 创建一个Maven项目

https://blog.csdn.net/hgnuxc_1993/article/details/125427590?ops_request_misc=&request_id=&biz_id=102&utm_term=idea2022%E7%89%88%E5%88%9B%E5%BB%BAmaven%E9%A1%B9%E7%9B%AE&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-125427590.142^v73^insert_down3,201^v4^add_ask,239^v2^insert_chatgpt&spm=1018.2226.3001.4187

3 搭建成功![image-20230217103331868](JavaWeb.assets/image-20230217103331868.png)

![image-20230217103715744](JavaWeb.assets/image-20230217103715744.png)

4 创建一个普通的Maven项目

![image-20230218010738794](JavaWeb.assets/image-20230218010738794.png)



#### 5.7 在IDEA中标记文件夹功能

![image-20230218011012149](JavaWeb.assets/image-20230218011012149.png)

#### 5.8 在IDEA中配置Tomcat

![image-20230218012755676](JavaWeb.assets/image-20230218012755676.png)

![image-20230218012209015](JavaWeb.assets/image-20230218012209015.png)

解决警告问题：

![image-20230218012313279](JavaWeb.assets/image-20230218012313279.png)

==为什么会有这个问题==

我们访问一个网站，需要指定一个文件夹名字（必须要的）

![image-20230218012708919](JavaWeb.assets/image-20230218012708919.png)

![image-20230218012826843](JavaWeb.assets/image-20230218012826843.png)

![image-20230218013510433](JavaWeb.assets/image-20230218013510433.png)

Maven结构：

![image-20230218013904238](JavaWeb.assets/image-20230218013904238.png)

#### 5.9 pom文件

pom.xml是Maven的核心配置文件，

```xml
<!--Ctrl+Shift+/ 快速注释-->
<!--maven版本和头文件 -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <!--这里就是配置的GAV-->
  <groupId>com.lk</groupId>
  <artifactId>maventest</artifactId>
  <!--package：项目的打包方式
  jar：java应用
  war：javaweb应用-->
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>


  <name>maventest Maven Webapp</name>
  <url>http://maven.apache.org</url>

  <!--项目依赖-->
  <dependencies>
    <!--具体依赖的jar包配置文件-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  <!--项目构建用的东西-->
  <build>
    <finalName>maventest</finalName>
  </build>
  
</project>
```

![image-20230218020006049](JavaWeb.assets/image-20230218020006049.png)

Maven由于它的约定大于配置，之后可能会遇到自己写的配置文件无法被导出或者生效的问题，**解决方案**

```xml
<!--在build中配置resources，防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <excludes>
                    <exclude>**/*.properties</exclude>
                    <exclude>**/*.xml</exclude>
                </excludes>
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
```

#### 5.10 Maven配置及Tomcat部署可能碰到的问题 P7

+ IDEA创建maven项目后没有.iml文件
+ 在Terminal中输入命令

```java
mvn idea:module
```

![image-20230218170747213](JavaWeb.assets/image-20230218170747213.png)

+ 

```
Unable to import maven project:see logs for details
```

尝试降低Tomcat版本，重新配置本地仓库，镜像和系统环境变量

+ Tomcat闪退
+ IDEA中每次都要重复配置Maven
  + 在IDEA中的全局默认配置中去配置
+ Maven项目中Tomcat无法配置

+ Maven默认web项目中的web.xml版本问题
  + ![image-20230218104641763](JavaWeb.assets/image-20230218104641763.png)

IDEA中web项目的web-app默认版本是2.3

Tomcat文件夹默认的webapp中的ROOT文件中的web.xml中的配置情况

web-app 版本为4.0

![image-20230218104906679](JavaWeb.assets/image-20230218104906679.png)

将IDEA中webapp版本改为4.0和Tomcat保持一致可以避免某些问题出现。

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
  metadata-complete="true">
```

maven由于约定大于配置，之后会遇到自己写的配置文件，无法被导出或者生效的问题，解决方案

```xml
<!--在build中配置resources，防止资源导出失败的问题-->
<build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

```



+ maven仓库的使用
  + 地址：https://mvnrepository.com/
  + ![image-20230218154920001](JavaWeb.assets/image-20230218154920001.png)

一般选取使用次数多的。

![image-20230218155039161](JavaWeb.assets/image-20230218155039161.png)





### 6 Servlet

#### 6.1 Servlet简介

+ Servlet就是SUn公司开发动态web的一门技术，
+ sun公司在这些API中提供了一个接口叫做：Servlet，如果想要开发一个Servlet程序，只需要完成：
  + 1 编写一个类，实现Servlet接口
  + 2 把开发好的JAVA类部署到WEB服务器当中

**把实现了Servlet接口的java程序叫做Servlet**

#### 6.2 **HelloServlet**

Servlet接口在SUN公司有两个默认的实现类：HttpServlet和GenericServlet

==**1** 创建一个普通的maven项目==，删掉里面的src目录，以后的学习就在这个项目里建立Module：这个空的工程就是Maven的主工程

==2 **关于Maven父子工程的理解**==

父项目中会有

```xml
<modules>
        <module>servlet-01</module>
    </modules>
```

子项目中会有

```xml
 <parent>
        <artifactId>javaweb-02-servlet</artifactId>
        <groupId>com.lk</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
```



父项目中的java子项目可以直接使用

```java
son extends father
```

==3 **Maven环境优化**==

+ 修改子项目中webapp配置文件web.xml为最新配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
</web-app>

```

![image-20230218194849329](JavaWeb.assets/image-20230218194849329.png)

+ 将maven结构搭建完整，新建java 和 resources项目

![image-20230218195120944](JavaWeb.assets/image-20230218195120944.png)

==4  编写Servlet程序==

+ 编写一个普通类

+ 实现Servlet接口，这里直接继承HttpServlet

  ![image-20230218200403321](JavaWeb.assets/image-20230218200403321.png)

```java
public class HelloServlet extends HttpServlet {

    //由于get或者post只是请求实现的不同的方式，可以相互调用，业务逻辑一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletOutputStream outputStream = resp.getOutputStream();
        PrintWriter writer = resp.getWriter();  //响应流

        writer.print("Hello,Servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

```

==5 编写Servlet的映射==

为什么需要映射：写的是Java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以需要在web服务器中注册我们写的Servlet，还需要给他一个浏览器能够访问的路径

```xml
    <!--注册Servlet-->
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.lk.servlet.HelloServlet</servlet-class>
    </servlet>
    <!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```

==6 配置Tomcat==

注意配置项目发布的路径就OK

==7 启动测试==

#### 6.3 运行原理

Servlet是由Web服务器调用，Web服务器在收到浏览器请求之后，会：

![image-20230218210126998](JavaWeb.assets/image-20230218210126998.png)

#### 6.4 Mapping问题

+ 1、一个Servlet可以指定一个映射路径
+ 2、一个Servlet可以指定多个映射路径
+ 3、 一个Servlet可以指定通用映射路径
+ 4、 一个Servlet可以自定义后缀实现请求映射

```xml
    <!--自定义后缀实现请求映射-->
    <!--注意*前面不能加映射的路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>*.lk</url-pattern>
    </servlet-mapping>
```

![image-20230218211037476](JavaWeb.assets/image-20230218211037476.png)

+ 5、优先级问题
+ 指定了固有的映射路径，优先级最高，如果找不到就会走默认的处理i请求

```xml
    <!--404-->
    <servlet>
        <servlet-name>error</servlet-name>
        <servlet-class>com.lk.servlet.ErrorServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>error</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>

    <!--hello-->
 <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.lk.servlet.HelloServlet</servlet-class>
    </servlet>
    <!--Servlet的请求路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```

localhost:8080/s1/hello 访问 HelloServlet

localhost:8080/s1/sjkhjkja 访问 404



#### 6.5 ServletContext

web容器启动的时候，会为每个web程序都创建一个ServletContext对象，代表了当前的web应用

##### **共享数据**

我在这个Servlet中保存的数据，可以在另外一个servlet

![image-20230219095107956](JavaWeb.assets/image-20230219095107956.png)



第一步：存数据   setAttribute("username",username);

```java
  //HelloServlet
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // this.getInitParameter()   初始化参数
       // this.getServletConfig()   Servlet配置
       // this.getServletContext()  Servlet上下文
        ServletContext servletContext = this.getServletContext();
        String username = "胡晓飞";  //数据
        servletContext.setAttribute("username",username);  //将一个数据保存在了ServletContext中，名字 username 值 username
    }
```

第二步：从ServletContext获取数据  页面编码和文本类型需要设置，如果不设置将会显示为问号，字符无法识别

![image-20230219102746101](JavaWeb.assets/image-20230219102746101.png)

==null==：null的原因是因为ServletContex中还没有存储任何东西

```java
//GetServlet
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("名字"+username);
    }
```

HelloServlet 实现存数据，GetServlet实现获取数据

```xml
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.lk.servlet.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>getc</servlet-name>
        <servlet-class>com.lk.servlet.GetServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>getc</servlet-name>
        <url-pattern>/getc</url-pattern>
    </servlet-mapping>
</web-app>
```

##### **获取初始化参数**

```xml
    <!--配置一些web应用的初始化参数-->
	<context-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
    </context-param>
```



从web,xml中获取配置的一些参数

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String url = servletContext.getInitParameter("url");
        resp.getWriter().print(url);
        }
```

![image-20230219110413682](JavaWeb.assets/image-20230219110413682.png)

##### **请求转发**

![image-20230219112250077](JavaWeb.assets/image-20230219112250077.png)

![image-20230219112310706](JavaWeb.assets/image-20230219112310706.png)

```java
//Demo4
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        System.out.println("进入了demo4");
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/url"); //转发的请求路径
        requestDispatcher.forward(req,resp);  //调用forward实现请求转发

    }
}
```

```xml
    <servlet>
        <servlet-name>rd</servlet-name>
        <servlet-class>com.lk.servlet.ServletDemo4</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>rd</servlet-name>
        <url-pattern>/rd</url-pattern>
    </servlet-mapping>
```

访问LocalHost:8080/s2/rd 通过请求转发 实际访问到了 /url

![image-20230219112508729](JavaWeb.assets/image-20230219112508729.png)

##### **读取资源文件**

Properties

+ 在java目录下新建properties
+ 在resources目录下新建properties

​		发现：被打包到了同一个路径下：classes，俗称这个路径为classpath

![image-20230219151505145](JavaWeb.assets/image-20230219151505145.png)

pom文件中添加resources配置，解决自己写的配置文件无法被导出或者生效的问题

配置中包含两个resource，分别指定 src/main/resources 和 src/main/java 两个路径，针对.properties和.xml配置文件，经测试，分别在两个路径下添加properties文件，如下图，

![image-20230219151833468](JavaWeb.assets/image-20230219151833468.png)

运行后发现自己所写的 .properties 文件确实被打包在了classes文件目录下，但只有src/main/java路径下的文件被打包，db.properties文件找不到了

![image-20230219152201853](JavaWeb.assets/image-20230219152201853.png)

解决方法（原因未知）：pom文件中不要配置resources路径，resources路径下写的配置文件本来就会被打包到classes路径下，在pom配置文件中写了反而没有被打包，将第一个resource配置内容删去

![image-20230219152342804](JavaWeb.assets/image-20230219152342804.png)

![image-20230219153603741](JavaWeb.assets/image-20230219153603741.png)



读取资源测试

```java
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("username");
        String pwd = prop.getProperty("password");

        resp.getWriter().print(user + ":" +pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### 6.6 HttpServletResponse

web服务器接收到客户端的Http请求，针对这个请求，分别创建一个代表请求的Request对象，代表响应的一个HttpServletResponse;

+ 如果要获取客户端请求过来的参数，找HttpServletRequest
+ 如果要给客户端响应一些信息，找HttpServletResponse

##### 简单分类

**负责向浏览器发送数据的方法**

```java
 ServletOutputStream getOutputStream() throws IOException;
  PrintWriter getWriter() throws IOException;
```

**负责向浏览器发送响应头的方法**

```java
    void setCharacterEncoding(String var1);

    void setContentLength(int var1);

    void setContentLengthLong(long var1);

    void setContentType(String var1);
    
    void setDateHeader(String var1, long var2);

    void addDateHeader(String var1, long var2);

    void setHeader(String var1, String var2);

    void addHeader(String var1, String var2);

    void setIntHeader(String var1, int var2);

    void addIntHeader(String var1, int var2);
```

状态码字段

```java
 int SC_CONTINUE = 100;
    int SC_SWITCHING_PROTOCOLS = 101;
    int SC_OK = 200;
    int SC_CREATED = 201;
    int SC_ACCEPTED = 202;
    int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    int SC_NO_CONTENT = 204;
    int SC_RESET_CONTENT = 205;
    int SC_PARTIAL_CONTENT = 206;
    int SC_MULTIPLE_CHOICES = 300;
    int SC_MOVED_PERMANENTLY = 301;
    int SC_MOVED_TEMPORARILY = 302;
    int SC_FOUND = 302;
    int SC_SEE_OTHER = 303;
    int SC_NOT_MODIFIED = 304;
    int SC_USE_PROXY = 305;
    int SC_TEMPORARY_REDIRECT = 307;
    int SC_BAD_REQUEST = 400;
    int SC_UNAUTHORIZED = 401;
    int SC_PAYMENT_REQUIRED = 402;
    int SC_FORBIDDEN = 403;
    int SC_NOT_FOUND = 404;
    int SC_METHOD_NOT_ALLOWED = 405;
    int SC_NOT_ACCEPTABLE = 406;
    int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    int SC_REQUEST_TIMEOUT = 408;
    int SC_CONFLICT = 409;
    int SC_GONE = 410;
    int SC_LENGTH_REQUIRED = 411;
    int SC_PRECONDITION_FAILED = 412;
    int SC_REQUEST_ENTITY_TOO_LARGE = 413;
    int SC_REQUEST_URI_TOO_LONG = 414;
    int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    int SC_EXPECTATION_FAILED = 417;
    int SC_INTERNAL_SERVER_ERROR = 500;
    int SC_NOT_IMPLEMENTED = 501;
    int SC_BAD_GATEWAY = 502;
    int SC_SERVICE_UNAVAILABLE = 503;
    int SC_GATEWAY_TIMEOUT = 504;
    int SC_HTTP_VERSION_NOT_SUPPORTED = 505;
```

##### 常见应用

###### 1、 **向浏览器输出消息**（前面一直都在讲）

###### 2、**下载文件**

+ 要获取下载文件的路径

  ![image-20230220110657895](JavaWeb.assets/image-20230220110657895.png)

  通过getRealPath获取

  ![image-20230220110430617](JavaWeb.assets/image-20230220110430617.png)

  通过查看target.classes路径下文件，显示的路径并非预先设定好的文件路径

  ![image-20230220110548590](JavaWeb.assets/image-20230220110548590.png)

  所以直接获取文件所在的绝对路径，如下代码

  

+ 下载的文件名

+ 设置想办法让浏览器能够支持下载我们需要的东西

  setHeader（）中内容通过百度搜索，因为是string字符串，手动输入时也不会提示，需要记住，记不住百度即可。

  ![image-20230220111244522](JavaWeb.assets/image-20230220111244522.png)

  另外如果要下载的文件名是中文，需要另外设置编码格式

  ![image-20230220111005372](JavaWeb.assets/image-20230220111005372.png)

+ 获取下载文件的输入流

+ 创建缓冲区

+ 获取OutoutStream对象

+ 将FileOutputStream流写入到Buffer缓冲区

+ 使用OutputStream将缓冲区中的数据输出到客户端

```java
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         要获取下载文件的路径
        String realPath = "E:\\LearningNotes\\JAVA前端\\javaweb\\代码\\javaweb-02-servlet\\response\\target\\classes\\胡晓飞.png";
        System.out.println("下载的文件路径："+realPath);
//                 下载的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
//                 设置想办法让浏览器能够支持下载我们需要的东西,让中文文件名通过URLEncoder.encode编码，否则可能乱码
        resp.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
//                 获取下载文件的输入流

        FileInputStream in = new FileInputStream(realPath);
//                 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//                 获取OutoutStream对象
        ServletOutputStream out = resp.getOutputStream();
//                 将FileOutputStream流写入到Buffer缓冲区
        while ((len = in.read(buffer))>0){
            out.write(buffer,0,len);

        }
//                 使用OutputStream将缓冲区中的数据输出到客户端
        in.close();
        out.close();

    }


}
```

###### 3、 验证码实现

```java
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器5S自动刷新一次
        resp.setHeader("refresh","3");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics g = (Graphics) image.getGraphics();   //相当于拿到画笔，准备去画图片
        //设置图片的背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器这个请求用图片的方式打开
        resp.setContentType("image/png");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("pragma","no-cache");

        //把图片写给浏览器
         ImageIO.write(image,"png",resp.getOutputStream());



    }
    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;

    }
}
```

![image-20230220195329551](JavaWeb.assets/image-20230220195329551.png)

###### 4、重定向

![image-20230220195151870](JavaWeb.assets/image-20230220195151870.png)

```java
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        resp.setHeader("Location","/r3/image");
        resp.setStatus(302);
        这两行代码相当于下面这一行代码
        */
        resp.sendRedirect("/r3/image");
    }
}
```

![image-20230220195446424](JavaWeb.assets/image-20230220195446424.png)

![image-20230220195414322](JavaWeb.assets/image-20230220195414322.png)

重定向跳转到 /r3/image

![image-20230220195537276](JavaWeb.assets/image-20230220195537276.png)

==重定向和请求转发的区别==

+ 相同点：页面都会实现跳转
+ 不同点：
  + 请求转发的时候，url不会产生变化  307
  + 重定向时候，url地址栏会发生变化  302

#### RequestTest 例子

```java
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入这个请求了");
        //处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+ ":"+password);
        //重定向时候一定注意 路径问题，404说明代码没问题，知识没找到，报错500代码存在错误
        resp.sendRedirect("/r3/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
```

```xml
<%--index.jsp--%>
<html>
<body>
<h2>Hello World!</h2>

<%--这里提交的路径L需要寻找到项目的路径--%>
<%--{pageContext.request.contextPath}代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="password" name="password"> <br>
    <input type="submit">

</form>
</body>
</html>
```

```xml
<%--Success--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Success</h1>
</body>
</html>
```

![image-20230220200056514](JavaWeb.assets/image-20230220200056514.png)

输入用户名和密码，重定向至/r3/success

#### 6.7 HttpServletRequest

HttpServletRequest代表客户端的请求，用户通过Http协议访问服务器，HTTP请求中的所有信息会被封装到HttpServletRequest，通过这个HttpServletRequest的方法，获得客户端的所有信息

```java
 String getContextPath();
 String getRemoteUser();
```

##### 1、获取前端传递的参数

![image-20230220204910092](JavaWeb.assets/image-20230220204910092.png)



##### 2、请求转发

```java
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobbys");
        System.out.println("=========================");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbys));
        System.out.println("==========================");

        //通过请求转发
        req.getRequestDispatcher("E:\\LearningNotes\\JAVA前端\\javaweb\\代码\\javaweb-02-servlet\\request\\src\\main\\webapp\\success.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```



```xml
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>

<div style="text-align: center">
    <%--这里表单所表示的意思，以post方式提交表单，提交到我们的login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username" required> <br>
        密码:<input type="password" name="password"> <br>
        爱好：
        <input type="checkbox" name="hobby" value="女孩">女孩
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="唱歌">唱歌
        <input type="checkbox" name="hobby" value="电影">电影

        <br>
        <input type="submit">
    </form>

</div>
</body>
</html>
```

 请求转发时  报错404

![image-20230221101203430](JavaWeb.assets/image-20230221101203430.png)

后台倒是输出了内容

![image-20230221101313702](JavaWeb.assets/image-20230221101313702.png)

![image-20230221102702894](JavaWeb.assets/image-20230221102702894.png)

而代码中寻找success.jsp文件目录 

![image-20230221102908193](JavaWeb.assets/image-20230221102908193.png)

不需要写成/r/success

### 7 Cookie、Session

#### 7.1 会话

**会话**：用户打开一个浏览器，点击了很多超链接，访问了多个Web资源，关闭浏览器，这个过程可以称为会话

**有状态会话：**一个同学来过教室，下次再来教室，我们会知道这个同学曾经来过

可以在不同的方法调用间保持针对各个客户端的状态 。
与客户端的联系必需被维持；通常开销较大 。
有状态会话Bean会保存客户端的状态 。
–你对ENTITY BEAN的数据操作会被容器维护起来，当其他的用户要用你正在使用的ENTITY BEAN时，里面的数据会被钝化到服务器的磁盘上，例如网上的购物车。



一个网站，怎么证明浏览过？

1、服务端给哭护短一个 “信件”，客户端下次访问服务端带上“信件”就可以了  cookie

2、服务器登记浏览过了，下次浏览的时候服务器来匹配   session



**无状态会话:**

在不同方法调用间不保留任何状态 。
事务处理必须在一个方法中结束 。
通常资源占用较少；可以被共享(因为它是无状态的) 。
无状态Bean不会"专门"保存客户端的状态----(需要强调“专门”是因为无状态会话Bean也会有成员变量，有成员变量就可以保存状态，但它不会专门为特定的客户端保存状态。)。
----你对ENTITY BEAN的数据操作不会被容器维护，当其他的用户要用ENTITY BEAN时，里面的数据不
会被钝化到服务器的磁盘上。也就是被保存起来。

#### 7.2 保存会话的两种技术

**cookie**

+ 客户端技术（响应，请求）

**session**

+ 服务器技术，利用这个技术，可以保存用户的会话信息，我们可以把信息或者数据放在session中



常见例子：网站登录后，下次不用再登录了



#### 7.3 Cookie

1、从请求中拿到cookie信息

服务器响应给客户端cookie

```java
        Cookie[] cookies = req.getCookies();  //获得Cookie
        cookie.getName()   //获得cookie中的key
        cookie.getValue();  //获得key中的值
		new Cookie("lastLoginTime", System.currentTimeMillis() + "");   //新建一个cookie
		cookie.setMaxAge(24*60*60);  //设置cookie有效期
        resp.addCookie(cookie);  //响应给客户端一个cookie
```

![image-20230221170324147](JavaWeb.assets/image-20230221170324147.png)

**cookie一般会保存在本地的用户目录下appdata**

==一个网站cookie是否存在上限？==

+ 一个cookie只能保存一个信息；
+ 一个web站点可以给浏览器发送多个cookie，最多存放20个cookie
+ 浏览器cookie上限大概为300个
+ cookie大小限制4kb



删除COOKIE：

+ 不设置有效期，关闭浏览器，自动失效
+ 将有效期设置为0

```java
//添加cookie并设置存在有效期
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你，你来的时间，把这个时间封装成为一个信件，下次来就知道了

        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();  //这里返回数组，说明cookie可能存在多个

        // 判断cookie是否存在
        if (cookies!=null){
            //如果存在怎么办
            out.write("上次访问的时间是：");
/*            for (Cookie cookie : cookies) {
                
            }*/
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie名字
                if (cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    cookie.getValue();
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());

                }
            }

        }else {
            out.write("这是第一次访问");
        }

        //服务器给客户端响应cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        //cookie有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }


}
```

```java
//手动设置有效时间为0，保证和之前生成的cookie名字一致
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个Cookie，名字必须要和要删除的名字一致
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");

        //将cookie有效期设置为0
        cookie.setMaxAge(0);
        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```



```java
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决请求、响应乱码问题
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if (cookies != null){
            out.write("上次访问时间是");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("name")){
//                    System.out.println(cookie.getValue());

                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                }
            }
        }else {
            out.write("第一次访问");

        }
        //解决cookie乱码问题
        Cookie cookie = new Cookie("name", URLEncoder.encode("胡晓飞","UTF-8"));
//        Cookie cookie = new Cookie("name", "胡晓飞");
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### 7.4 Session

**什么是Session**

服务器会给每一个用户（浏览器）创建一个Session对象

一个Session独占一个浏览器，只要浏览器没有关闭，这个Session就存在

用户登录之后，整个网站它都可以访问（长久保存信息，如购物车、用户信息）

​                                                    ![image-20230221203155894](JavaWeb.assets/image-20230221203155894.png)   

![image-20230221203219685](JavaWeb.assets/image-20230221203219685.png)

**Session 存取数据**

+ 存

```java
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到Session
        HttpSession session = req.getSession();

        //给Session存东西
        session.setAttribute("name","胡晓飞");
        //获取Session的ID
        String id = session.getId();
        //判断Session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("Session创建成功，ID是"+id);
        }else {
            resp.getWriter().write("Session已经在服务器中存在了，ID是"+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

访问效果

![image-20230221203743610](JavaWeb.assets/image-20230221203743610.png)

![image-20230221203839642](JavaWeb.assets/image-20230221203839642.png)

SessionID放在了Cookie里

![image-20230221203951150](JavaWeb.assets/image-20230221203951150.png)

可以看出 SessionID被创建在了Cookie中，那么Session在创建时做了一件什么事情？

```java
        //Session创建的时候做了什么事情
        Cookie cookie = new Cookie("JSESSIONID", "5636EF63FA7DDAE9A82E7AEE961A5A9");
        resp.addCookie(cookie);
        Session就可以理解为属于Cookie的一类
```

+ 取

```java
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到Session
        HttpSession session = req.getSession();

        Person person = (Person) session.getAttribute("name");
        System.out.println(person.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
//这里取得是一个Person对象，Session中可存储数据类型很多，只要是一个对象都可以进行存取
```

![image-20230221210227996](JavaWeb.assets/image-20230221210227996.png)

+ Session注销

  1、手动注销Session

```java
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.removeAttribute("name");
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

依次往Session创建——取Session——注销Session——取Session

![image-20230221210736153](JavaWeb.assets/image-20230221210736153.png)

如果再重新创建一个Session，得到的对象会是一个新的ID

2、自动注销

```xml
 <!--设置Session默认的失效时间,以分钟为单位-->
    <session-config>
        <session-timeout>1</session-timeout>
    </session-config>
```



==Session和Cookie的区别==

+ Cookie是把用户的数据写给用户的浏览器，浏览器保存（可以保存多个）
+ Session把用户得数据写到用户独占Session中，服务器端保存（保存重要得信息，减少服务器资源的浪费）
+ Session对象由服务器创建；



使用场景：

+ 保存一个登录用户的信息
+ 购物车
+ 在整个网站中经常会使用到的数据，我们将它保存在Session中

![image-20230221213729316](JavaWeb.assets/image-20230221213729316.png)

![image-20230221213836546](JavaWeb.assets/image-20230221213836546.png)

![image-20230221213954273](JavaWeb.assets/image-20230221213954273.png)

### 8 JSP

#### 8.1 什么是JSP

Java Server Pages： Java服务器端页面，也和Servlet一样，用于动态Web技术

特点：

+ 写JSP就像在写HTML
+ 区别
  + HTML只给用户提供静态的数据
  + JSP页面中可以嵌入JAVA代码，为用户提供动态数据

#### 8.2 JSP原理

JSP怎么执行的？

+ 代码层面之前一直有在演示

+ 服务器内部工作

  Tomcat中有一个work目录

  IDEA中使用Tomcat的话会在IDEA中生成一个work目录

  ```
  C:\Users\LeeB\.IntelliJIdea\system\tomcat\539b1328-f720-42d8-948d-27760da36845\work\Catalina\localhost\jsc\org\apache\jsp
  ```
  
  ![image-20230222101041838](JavaWeb.assets/image-20230222101041838.png)
  
  发现页面转换成了java程序！
  
  **浏览器向服务器发送请求，不管访问什么资源，其实都是在访问Servlet**
  
  JSP也会被转换成为一个java类
  
  JSP本质上就是一个Servlet
  
  ```java
  //初始化
  public void _jspInit() {
    }
  //销毁
    public void _jspDestroy() {
    }
  //JSPService
    public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {
        
  ```

1、判断请求

2、内置一些对象

```java
    final javax.servlet.jsp.PageContext pageContext;   //页面上下文
    javax.servlet.http.HttpSession session = null;  //Session
    final javax.servlet.ServletContext application;  //ApplicationContext
    final javax.servlet.ServletConfig config;  //config
    javax.servlet.jsp.JspWriter out = null;   //out
    final java.lang.Object page = this;  //page：当前
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;
	HttpServletRequest request   //请求
    HttpServletResponse response  //响应
```

3、 输出页面前增加的代码

```java
      response.setContentType("text/html");   //设置响应的页面类型
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
```

4、以上的这些对象我们可以在JSP页面直接使用

![image-20230222155718047](JavaWeb.assets/image-20230222155718047.png)

在JSP页面中：

只要是JAVA代码就会原封不动的输出

如果是HTML代码，就会被转换为

```java
out.write("<html>\r\n");
```

这样的格式 输出到前端。

==.IntelliJIDEA文件发现不在C盘中解决办法==

![image-20230222101133630](JavaWeb.assets/image-20230222101133630.png)





#### 8.3 JSP基础语法

任何语言都有自己的语法，JAVA中有，JSP中有。JSP作为JAVA技术的一种应用，它拥有一些自己扩充的语法（了解即可），JAVA所有语法都支持



+  JSP表达式

```jsp
 <%--JSP表达式
 作用：将程序的输出，输出到客户端
   <%= 变量或者表达式%>
 --%>
  <%= new java.util.Date()%>

```

![image-20230222211439265](JavaWeb.assets/image-20230222211439265.png)

访问页面结果：

![image-20230222211453242](JavaWeb.assets/image-20230222211453242.png)

+  JSP脚本片段

```xml
<%--JSP脚本片段--%>
  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum += i;
    }
    out.println("<h1>sum="+sum+"</h1>");
  %>
```

![image-20230222213051392](JavaWeb.assets/image-20230222213051392.png)



**脚本片段的再实现**

![image-20230222214021000](JavaWeb.assets/image-20230222214021000.png)

不能定义同一个变量名，和java中一样



```xml
 <%
      int x =10;
      out.println(x);
  %>

  <p>这是一个JSP文档</p>
  <%
    int y = 10;
    out.println(y);
  %>
 <hr>
  <%--在代码嵌入HTML元素--%>
  <%
      for (int i = 0; i < 5; i++) {


  %>
 <h1>Hello,World  <%= i%></h1>
  <%
      } 
  %>
      <%--完整的循环体可以分段，如for循环中的花括号--%>
```

![image-20230222215030196](JavaWeb.assets/image-20230222215030196.png)





+ JSP 声明

  ```xml
  <%!
        static {
            System.out.println("Loading Servlet!");
        }
        private int globalVar = 0;
        public void lk(){
            System.out.println("进入了方法lk");
        }
    %>
  ```

  

在jsp源码文件中被放在了index_jsp 类中，作用域更高

![image-20230223152125207](JavaWeb.assets/image-20230223152125207.png)

JSP声明会被编译到JSP生成的JAVA的类中，而其他的就会被生成到_jspService（）方法中

在JSP中，嵌入java代码即可



```xml
 <%-- EL表达，看着更舒服点？--%>
 <% for (int i = 0; i < 5; i++) { %>
    <%--<h1>Hello,World  <%= i%></h1>--%>
     <h1>Hello,World  ${i}</h1>
  <% } %>
```



总结

```
<%%> 片段
<%=%>表达式输出值
<%！%> 定义全局的方法
<%--注释--%>   jsp的注释不会在客户端被显示
```

#### 8.4 JSP指令

![image-20230223155609446](JavaWeb.assets/image-20230223155609446.png)

==访问错误页面：==

+ 方法一

```jsp
<%@ page errorPage="error/500.jsp" %>
```

访问当前页面时，若发现错误，则跳转到error目录下的500.jsp页面

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="../img/500错误.png" alt="500">
</body>
</html>
```

![image-20230223155141646](JavaWeb.assets/image-20230223155141646.png)

+ 方法二

在web.xml文件配置访问发生错误跳转到指定错误页面

```xml
    <error-page>
        <error-code>404</error-code>
        <location>/error/404.jsp</location>
    </error-page>
    
    <error-page>
        <error-code>500</error-code>
        <location>/error/500.jsp</location>
    </error-page>
```

如此，方法一中指令就无需再写，也能实现页面错误跳转



==导包==

```jsp
<%@page import="java.util.*" %>
```

写jsp语句时，可以直接new一个Date对象

```jsp
<%= new Date()%>
```

否则需要

```jsp
 <%= new java.util.Date()%>
```

![image-20230223155534493](JavaWeb.assets/image-20230223155534493.png)

小细节：每次修改变更jsp内容时可以不重启TOMCAT,选择更新就可以

![image-20230223161433703](JavaWeb.assets/image-20230223161433703.png)

但修改web.xml时，需要重启Tomcat



==页面拼接/合并==

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<%-- <%@include 会将两个页面合二为一 --%>
<%@include file="common/header.jsp"%>
<h1>网页主体</h1>
<%@include file="common/footer.jsp"%>

<hr>

<%--JSP标签
jsp:include 拼接页面，本质还是3个
--%>
  <jsp:include page="/common/header.jsp"/>
  <h1>网页主体</h1>
  <jsp:include page="/common/footer.jsp"/>
</body>
</html>
```

区别体现：在header.jsp中声明一个变量i，jsp3.jsp页面通过==<%@include 会将两个页面合二为一==时，再声明一个i，会报错

![image-20230223162052280](JavaWeb.assets/image-20230223162052280.png)

​				页面报500错误

​				而通过JSP标签声明变量i，并不会报错，页面可以正常显示



​		                                              ![image-20230223162204179](JavaWeb.assets/image-20230223162204179.png)   

#### 8.5 JSP 9大内置对象及作用域



```java
    final javax.servlet.jsp.PageContext pageContext;   //页面上下文
    javax.servlet.http.HttpSession session = null;  //Session
    final javax.servlet.ServletContext application;  //ApplicationContext
    final javax.servlet.ServletConfig config;  //config
    javax.servlet.jsp.JspWriter out = null;   //out
    final java.lang.Object page = this;  //page：当前
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;
	HttpServletRequest request   //请求
    HttpServletResponse response  //响应
```

+ PageContext  存东西

存数据

```jsp
<%

    pageContext.setAttribute("name1","胡晓飞1");//保存的数据只在一个页面中有效
    request.setAttribute("name2","胡晓飞2");//保存的数据只在一次请求中有效。请求转发会携带这个数据
    session.setAttribute("name3","胡晓飞3");//保存的数据只在一次会话中有效，从打开浏览器到关闭服务器
    application.setAttribute("name4","胡晓飞4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>
```

应用场景：

+ request：客户端向服务器发送请求，产生的数据，用户看完就没有用了，比如新闻，用户看完没用的
+ session：客户端向服务器发送请求，产生的数据，用户用完一会儿还有用，比如购物车
+ application：客户端向服务器发送请求，产生的数据，一个用户用完了，其他用户还可能使用，比如：聊天数据

取数据

```jsp
<%	
	//从底层到高层（作用域）  page->request->session->application
//jvm：双亲委派机制：
    //从pageContext取出，我们通过寻找的方式来
  String name1 = (String) pageContext.findAttribute("name1");  
  String name2 = (String) pageContext.findAttribute("name2");  
  String name3 = (String) pageContext.findAttribute("name3");  
  String name4 = (String) pageContext.findAttribute("name4");
  String name5 = (String) pageContext.findAttribute("name5");  //不存在
%>

<%--使用EL表达式输出  ${ } --%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
```



<img src="JavaWeb.assets/image-20230223202008685.png" alt="image-20230223202008685" style="zoom:50%;" />

name5 变量并不存在，通过EL表达式不会取出影响页面内容的数据，而通过==<%= %>==这个方式就会取出值为null的name5

<img src="JavaWeb.assets/image-20230223202131188.png" alt="image-20230223202131188" style="zoom:50%;" />

**所以取值一般都通过EL表达式取**

<img src="JavaWeb.assets/image-20230223203436364.png" alt="image-20230223203436364" style="zoom:67%;" />

**作用域**的关系体现：

“胡晓飞1”和“胡晓飞2”保存在一个页面和一个请求中，通过另外一个页面访问这些数据是拿不到“胡晓飞1”和“胡晓飞2”的

```jsp
<%--创建一个新的JSP。访问先前存储的数据
--%>
<%
  //从pageContext取出，我们通过寻找的方式来
  String name1 = (String) pageContext.findAttribute("name1");
  String name2 = (String) pageContext.findAttribute("name2");
  String name3 = (String) pageContext.findAttribute("name3");
  String name4 = (String) pageContext.findAttribute("name4");
  String name5 = (String) pageContext.findAttribute("name5");
%>
<%--使用EL表达式输出  ${ } --%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
```

访问结果：

<img src="JavaWeb.assets/image-20230223203945480.png" alt="image-20230223203945480" style="zoom:50%;" />

**作用域**

```jsp
<%--
//scope 作用域
    public static final int PAGE_SCOPE = 1;
    public static final int REQUEST_SCOPE = 2;
    public static final int SESSION_SCOPE = 3;
    public static final int APPLICATION_SCOPE = 4;

    public void setAttribute(String name, Object attribute, int scope) {
        switch (scope) {
            case 1:
                this.mPage.put(name, attribute);
                break;
            case 2:
                this.mRequest.put(name, attribute);
                break;
            case 3:
                this.mSession.put(name, attribute);
                break;
            case 4:
                this.mApp.put(name, attribute);
                break;
            default:
                throw new IllegalArgumentException("Bad scope " + scope);
        }

    }
--%>
```

```
<% 上面和下面等效，但一般不建议使用，通常 使用下面方式创建/获取数据
  pageContext.setAttribute("hello1","hello1",PageContext.SESSION_SCOPE);  
  //session.setAttribute("hello1","hello1")
  
    pageContext.setAttribute("hello1","hello1",PageContext.PAGE_SCOPE);
    //pageContext.setAttribute("name1","胡晓飞1");
    
    pageContext.setAttribute("hello1","hello1",PageContext.REQUEST_SCOPE);
    //request.setAttribute("name2","胡晓飞2");
    
    pageContext.setAttribute("hello1","hello1",PageContext.APPLICATION_SCOPE);
    //application.setAttribute("name4","胡晓飞4");
%>
```



```xml
<%
  pageContext.forward("/index.jsp");
  //Servlet后台代码形式
    // request.getRequestDispatcher("/index.jsp").forward(request,response);
%>
```



+ Request   存东西
+ Response
+ Session  存东西
+ Application (ServletContext)   存东西
+ config (ServletConfig)
+ out
+ page
+ excepetion

#### 8.6 JSP、JSTL标签、EL表达式

```xml
 <!--JSTL表达式的依赖-->
        <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl-api</artifactId>
            <version>1.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/taglibs/standard -->

<!--standard标签依赖-->

        <dependency>
            <groupId>taglibs</groupId>
            <artifactId>standard</artifactId>
            <version>1.1.2</version>
        </dependency>
```

**EL表达式： $( )**

+ 获取数据

+ 执行运算

+ 获取web开发的常用对象

  

**JSP标签**

```jsp
<%--jsp:include page=""--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="zhangxiaonan"/>
    <jsp:param name="age" value="12"/>
</jsp:forward>
```

**JSTL表达式**

JSTL标签库的使用就是为了弥补HTML标签的不足，它自定义许多标签，可以供我们使用，标签的功能和java代码一样

+ 核心标签（掌握部分）

  ```jsp
  <%--引入JSTL核心标签库，我们才能使用JSTL标签  "c"代表core 核心--%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  ```

  <img src="JavaWeb.assets/image-20230307160454708.png" alt="image-20230307160454708" style="zoom: 80%;" />

  + ​	

**JSTL使用步骤：**

+ 引入对应的taglib
+ 使用其中方法
+ 在TomCat中也需要引入jstl的包，否则会报错：JSTL解析错误

```jsp
<body>
<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="get">
    <%--EL表达式获取表单中的数据
    ${param.参数名}}
    --%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>

<%--判断如果提交的用户名是管理员，则登录成功--%>
<%--
<%
if (request.getParameter("username").equals("admin")){
    out.print("登录成功");
}
%>
--%>
<c:if test="${param.username == 'admin'}" var="isAdmin" >
    <c:out value="管理员欢迎您！" />
</c:if>
<c:out value="${isAdmin}"></c:out>
</body>
```

<img src="JavaWeb.assets/image-20230307164027114.png" alt="image-20230307164027114" style="zoom:67%;" />

```jsp
<body>
<%--定义一个变量score，值为85--%>
<c:set var="score" value="85"/>
<c:choose>
  <c:when test="${score >=90}">
    你的成绩为优秀
  </c:when>
  <c:when test="${score >= 80}">
    你的成绩还不错
  </c:when>
</c:choose>
</body>
```

<img src="JavaWeb.assets/image-20230307163959326.png" alt="image-20230307163959326" style="zoom:67%;" />



```jsp
<body>
<%
  ArrayList<String> people = new ArrayList<>();
  people.add(0,"zhangsan");
  people.add(1,"wangwu");
  people.add(2,"lisi");
  people.add(3,"zhaoqi");
  request.setAttribute("list",people);
%>

<%--
var ，每一次遍历出来的变量
items ， 要遍历的对象
begin , 哪里开始
end , 到哪里
step , 步长
--%>
<c:forEach var="people" items="${list}">
  <c:out value="${people}"/><br>
</c:forEach>

<hr>
<c:forEach begin="1" end="3" step="2" var="people" items="${list}">
  <c:out value="${people}"></c:out>
</c:forEach>
</body>
```

<img src="JavaWeb.assets/image-20230307170022830.png" alt="image-20230307170022830" style="zoom:67%;" />



+ 格式化标签
+ SQL标签
+ XML标签

#### 8.7 JavaBean

实体类

JavaBean有特定得写法：

+ 必须有一个无参构造

+ 属性必须私有化

+ 必须有对应得get/set方法：

  一般用来和数据库得字段做映射 ORM

  ORM： 对象关系映射

  + 表——> 类
  + 字段——> 属性
  + 行记录——> 对象



  people表

| id   | name          | age  | address |
| ---- | ------------- | ---- | ------- |
| 1    | huxiaofei     | 24   | 西安    |
| 2    | maxiaonan     | 23   | 西安    |
| 3    | zhangxiaoming | 25   | 西安    |

  

```java
class people{
    private int id;
    private String name;
    private int age;
    private String address;
}

class A{
    new people(1,"huxiaofei",24,"西安");
    new people(1,"maxiaonan",23,"西安");
    new people(1,"zhangxiaoming",25,"西安");
}
```

  

  

```jsp
<body>
<%
//    People people = new People();
//    people.setAddress("西安");
//    people.setId(1);
//    people.setAge(24);
//    people.setName("huxiaofei");
    
  
%>
<jsp:useBean id="people" class="com.lk.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="西安"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="24"/>
<jsp:setProperty name="people" property="name" value="huxiaofei"/>

姓名：<jsp:getProperty name="people" property="name"/> <br>
id：<jsp:getProperty name="people" property="id"/>  <br>
年龄：<jsp:getProperty name="people" property="age"/> <br>
地址：<jsp:getProperty name="people" property="address"/>
</body>
```

![image-20230307204309470](JavaWeb.assets/image-20230307204309470.png)

### 9 MVC三层架构

Model View Controller  模型 视图 控制器



**早些年的开发架构**

![image-20230307205210119](JavaWeb.assets/image-20230307205210119.png)

用户直接访问控制层，控制层就可以直接操作数据库

```
servlet——增删改查语句——操作数据库
弊端：程序臃肿，不利于维护，    servlet的代码中：处理请求，响应，视图跳转，处理JDBC，处理业务代码，处理逻辑代码
```

**9.1 三层架构**

![image-20230307210055466](JavaWeb.assets/image-20230307210055466.png)

==**Model**：==

+ 业务处理：业务逻辑（Service）
+ 数据持久层：CRUD(Dao)

==View==：

+ 展示数据
+ 提供链接发起Servlet请求

==Controller==（Servlet）

+ 接收用户请求：(Request Session)
+ 交给业务层处理对应的代码
+ 控制视图的挑战

```
1 | 登录——>接收用户的登录请求——>处理用户的请求（获取用户登录的参数,username password） ————> 交给业务层处理登录业务(判断用户名和密码是否正确)————> Dao层查询用户名和密码是否正确 ————> 数据库
```



### 10 过滤器Filter

Filter：用来过滤网站的数据：

+ 处理中文的乱码

+ 登陆验证

  ![image-20230307214724330](JavaWeb.assets/image-20230307214724330.png)

+ Filter开发步骤：

  + 1 导包

  + 2 编写过滤器

    不要导错包

    ![image-20230308135358018](JavaWeb.assets/image-20230308135358018.png)

实现Filter接口，重写对应的方法即可

```java
public class CharacterEncodingFilter implements Filter {
    //初始化  web服务器启动就已经初始化了
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }


    /*
    过滤器中的所有代码，在过滤特定请求的时候都会执行
    必须要让过滤器继续执行   chain.doFilter(request,response);
    *
    *
    */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前...");
        chain.doFilter(request,response);  //让我们的请求继续走，如果不写，程序到这里就被拦截停止
        System.out.println("CharacterEncodingFilter 执行后...");
    }
    //销毁
    public void destroy(){
        System.out.println("CharacterEncodingFilter销毁");
    }
}
```

Servlet测试，“你好”显示乱码，通过实现的Filter将乱码过滤掉

```java
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");*/
        resp.getWriter().write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

Servlet 和 Filter 都要在web.xml文件中配好

```xml
    <servlet>
        <servlet-name>ShowServlet</servlet-name>
        <servlet-class>com.lk.servlet.ShowServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>ShowServlet</servlet-name>
        <url-pattern>/servlet/Show</url-pattern>
    </servlet-mapping>

    <servlet-mapping>
        <servlet-name>ShowServlet</servlet-name>
        <url-pattern>/Show</url-pattern>
    </servlet-mapping>
    
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>com.lk.filter.CharacterEncodingFilter</filter-class>
    </filter>
    
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/servlet/*</url-pattern>
    </filter-mapping>
</web-app>
```

<img src="JavaWeb.assets/image-20230308140151859.png" alt="image-20230308140151859" style="zoom:67%;" />





### 11 **监听器**

实现一个监听器的接口（有挺多种方法）

编写一个监听器：实现监听器的接口——> web.xml中注册配置监听器

+ 实现接口

  ```java
  public class OnlineCountListener implements HttpSessionListener {
  //    创建session监听
      //一旦创建一个session 就会触发一次这个事件
      public void sessionCreated(HttpSessionEvent se) {
          ServletContext ctx = se.getSession().getServletContext();
          System.out.println(se.getSession().getId());
          Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
  
          if (onlineCount == null){
              onlineCount = new Integer(1);
          }else {
              int count = onlineCount.intValue();
              onlineCount = new Integer(count + 1);
          }
  
          ctx.setAttribute("OnlineCount",onlineCount);
      }
  //销毁session监听
      //一旦销毁session就会触发一次这个事件
      public void sessionDestroyed(HttpSessionEvent se) {
          ServletContext ctx = se.getSession().getServletContext();
          se.getSession().invalidate(); //手动销毁session
          Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
  
          if (onlineCount == null){
              onlineCount = new Integer(0);
          }else {
              int count = onlineCount.intValue();
              onlineCount = new Integer(count - 1);
          }
  
          ctx.setAttribute("OnlineCount",onlineCount);
      }
  }
  ```

  

+ 注册监听器

```xml
    <listener>
        <listener-class>com.lk.listener.OnlineCountListener</listener-class>
    </listener>
```





### 12 过滤器、监听器常见应用

==监听器== 在GUI监听关闭事件

```java
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋快乐"); //新建一个窗体
        Panel panel = new Panel(null); //面板
        frame.setLayout(null);  //设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255)); //设置背景颜色

        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,0));  //设置背景颜色

        frame.add(panel);
        frame.setVisible(true);

        //监听事件，监听关闭事件
 /*       frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭Ing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭ed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");

            }
        });*/
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
            }
        });



    }

```

通过鼠标点击，监控激活、关闭等状态



==Filter实现权限拦截==

1. 用户登录后，向Session种放入用户的数据

2.  进入主页的时候要判断用户是否已经登录（在Filter中实现）

   ```java
   public class SysFilter implements Filter {
       @Override
       public void init(FilterConfig filterConfig) throws ServletException {
   
       }
   
       @Override
       public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           // ServletRequest  HttpServletRequest
           HttpServletRequest request1 = (HttpServletRequest) servletRequest;
           HttpServletResponse response1 = (HttpServletResponse) servletResponse;
   
           Object user_session = request1.getSession().getAttribute(Constant.USER_SESSION);
           if (user_session == null){
               response1.sendRedirect("/error.jsp");
           }
   
           filterChain.doFilter(servletRequest,servletResponse);
   
       }
   
       @Override
       public void destroy() {
   
       }
   }
   ```

   

![image-20230308163715358](JavaWeb.assets/image-20230308163715358.png)



### 13 JDBC

#### 13.1 java连接、操作数据库

<img src="JavaWeb.assets/image-20230308165620141.png" alt="image-20230308165620141" style="zoom:67%;" />

**需要 jar 包的支持：**

+ java.sql
+ javax.sql
+ mysql-connecter-java ..  链接驱动



+ 实验环境搭建：

```mysql
CREATE TABLE users(
	id INT PRIMARY KEY,
	`name` VARCHAR(40),
	`password` VARCHAR(40),
	email VARCHAR (60),
	birthday DATE 
);

INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(1,'张三','1234','zs@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(2,'李四','1234','ls@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(3,'王五','1234','ww@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(4,'老六','1234','ll@qq.com','2000-01-01');

SELECT * FROM users
```

+ 导入数据库依赖

```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
```

+ IDEA中连接数据库

![image-20230308190135284](JavaWeb.assets/image-20230308190135284.png)

+ JDBC固定步骤

1 加载驱动

2 连接数据库

3 向数据库发送SQL的对象statement CRUD

4 编写SQL

5 执行SQL

6 关闭连接

```java
public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取配置信息
        //useUnicode = true &characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode = true  & useSSL = true";
        String username = "root";
        String password = "root";

        // 1加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2连接数据库  代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3像数据库发送SQL的对象Statement
        Statement statement = connection.createStatement();

        //4 编写SQL
        String sql = "select * from users";

        //5 执行查询SQL 返回一个ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("password = " + resultSet.getObject("password"));
            System.out.println("email = " + resultSet.getObject("email"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
        }

        //6 关闭连接，释放资源 （原则——先开后关）
        resultSet.close();
        statement.close();
        connection.close();

    }
}
```



预编译SQL

```mysql
public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取配置信息
        //useUnicode = true &characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode = true  & useSSL = true";
        String username = "root";
        String password = "root";

        // 1加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2连接数据库  代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3像数据库发送SQL的对象Statement
        Statement statement = connection.createStatement();

        //4 编写SQL
        String sql = "select * from users";

        //5 执行查询SQL 返回一个ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("password = " + resultSet.getObject("password"));
            System.out.println("email = " + resultSet.getObject("email"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
        }

        //6 关闭连接，释放资源 （原则——先开后关）
        resultSet.close();
        statement.close();
        connection.close();

    }
}
```

#### 13.2 事务

要么都成功，要么都失败

```
开启事务
事务提交  commit()
事务回滚  rollback()
关闭事务


```



Junit单元测试

```xml
依赖
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
```

所有方法可直接测试，不用再new一个类，再调用方法

<img src="JavaWeb.assets/image-20230308193034507.png" alt="image-20230308193034507" style="zoom:67%;" />

@Test 只有在方法上有效，只要加了这个注解方法，就可以直接运行





搭建一个环境测试事务

```java
public class Testdbc3 {
    @Test
    public void test()  {
        //获取配置信息
        //useUnicode = true &characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode = true  & useSSL = true";
        String username = "root";
        String password = "root";
        Connection connection = null;
        // 1加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

        //2连接数据库  代表数据库
        connection = DriverManager.getConnection(url, username, password);
        //3 通知数据库开启事务 false 开启
        connection.setAutoCommit(false);
        String sql1 = "update account set money = money -100 where name = 'A'";
        connection.prepareStatement(sql1).executeUpdate();

        //制造错误
       // int i = 1/0;
        String sql2 = "update account set money = money +100 where name = 'B'";
        connection.prepareStatement(sql2).executeUpdate();

        connection.commit();  //以上两条SQL都执行成功了，就提交事务
        System.out.println("success");
    }catch (Exception e) {
            try {
            //如果出现异常，通知数据库回滚事务
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
    }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
```

报错 1/0前 A账户先减少100， 1/0后B账户再增加100，如果不开启事务，报错后，A账户少100但B账户不变，开启事务后，1/0报错，A和B账户金额都不变，即要么同时成功，要么同时失败



### 14 SMBMS

![image-20230309083744717](JavaWeb.assets/image-20230309083744717.png)

<img src="JavaWeb.assets/image-20230309084503265.png" alt="image-20230309084503265" style="zoom:80%;" />



项目 如何搭建？

考虑使不使用maven？ ——依赖/jar包



#### 14.1 项目搭建

##### **1 搭建一个maven web项目**

##### **2 配置Tomcat**

##### **3 测试项目是否能够跑起来**

##### **4 导入项目中会遇到的jar包**

​	jsp Servlet mysql驱动

##### **5 创建包项目结构**

![image-20230309094404067](JavaWeb.assets/image-20230309094404067.png)

##### **6 编写实体类**

![image-20230309105751333](JavaWeb.assets/image-20230309105751333.png)

​	ORM映射：表—类映射

##### **7 编写基础公共类**

​		1 数据库基础文件

```properties
driver = com.mysql.jdbc.Driver
url = jdbc:mysql://localhost:3306?useUnicode=true
user = root
password = root
```

​		2 编写数据库的公共类

```java
//操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，类加载的时候就初始化了
    static {
        Properties properties = new Properties();
        //通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        driver = properties.getProperty("url");
        driver = properties.getProperty("username");
        driver = properties.getProperty("password");

    }

    //获取数据库的连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //编写查询公共类
    public static ResultSet execute(Connection connection,String sql,Object[] params,ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException {
        //预编译的sql，在后面直接执行就可以了
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject 占位符从1开始，但是数组是从0开始，i+1
            preparedStatement.setObject(i+1,params[i]);
        }
        resultSet = preparedStatement.executeQuery(sql);
        return resultSet;
    }

    //编写增 删 改 公共方法
    public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject 占位符从1开始，但是数组是从0开始，i+1
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate(sql);
        return updateRows;
    }

    //释放资源
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;

        if (resultSet != null){
            try {
                resultSet.close();
                // GC回收
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            flag = false;
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
                // GC回收
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            flag = false;
        }

        if (connection != null){
            try {
                connection.close();
                // GC回收
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            flag = false;
        }
        return flag;
    }
}

```

​	3 编写字符编码过滤器

```java
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
```

##### 8 导入静态资源

![image-20230309105738841](JavaWeb.assets/image-20230309105738841.png)



#### 14.2 登录功能实现

![image-20230309110042268](JavaWeb.assets/image-20230309110042268.png)



##### 1 编写前端页面

![image-20230309110414741](JavaWeb.assets/image-20230309110414741.png)

##### 2 设置首页

```xml
    <welcome-file-list>
        <welcome-file>login.jsp</welcome-file>
    </welcome-file-list>
```

##### 3 编写dao层登录用户登录的接口

```java
public interface UserDao {
    //得到要登录的用户

    public User getLoginUser(Connection connection,String userCode) throws SQLException;
}
```



##### 4 编写Dao接口的实现类

```java
public class UserDaoimpl implements UserDao {
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};


            rs = BaseDao.execute(connection, sql, params, rs, pstm);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("craetedBy"));
                user.setCreationDate(rs.getDate("creationDate"));
                user.setModifyBy(rs.getInt("creationDate"));
                user.setModifyDate(rs.getDate("modifyDate"));

            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }
}

```

##### 5 业务层接口

```java
public interface UserService {

    //用户登录
    public User login(String usercode,String password);

}
```



##### 6 业务层实现类

```java
public class UserServiceImpl implements UserService{
    // 业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoimpl();
    }
    public User login(String usercode, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体的数据库操作
            user=userDao.getLoginUser(connection,usercode);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
    return user;
    }
/*    @Test
    public void test(){
        UserServiceImpl userServiceimpl = new UserServiceImpl();
        User admin = userServiceimpl.login("admin","1234567");
        System.out.println(admin.getUserPassword());
    }*/


}
```

##### 7 编写Servlet

```java
public class LoginServlet extends HttpServlet {
    //Servlet 控制层，调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start.....");

        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库中的密码进行对比，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);  //这里已经把登录的人查出来了

        if (user != null&& user.getUserPassword().equals(userPassword)){  //查有此人，可以登录
            //将用户的信息放入Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);

            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else { //查无此人，无法登陆，转发回登录页面，顺带提示它用户名或者密码错误
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

##### 8 注册Servlet

```xml
    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.lk.servlet.user.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login.do</url-pattern>
    </servlet-mapping>
```

##### 9 测试访问

<img src="JavaWeb.assets/image-20230309201646972.png" alt="image-20230309201646972" style="zoom:67%;" />

#### 14.3 登录功能优化

##### 注销功能

思路：移除Session。返回登录页面

```java
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除用户session
        req.getSession().removeAttribute(Constants.USER_SESSION);
        resp.sendRedirect("/login.jsp");  //返回登录页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```



注册 

```xml
<servlet>
        <servlet-name>LogoutServlet</servlet-name>
        <servlet-class>com.lk.servlet.user.LogoutServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LogoutServlet</servlet-name>
        <url-pattern>/jsp/logout.do</url-pattern>
    </servlet-mapping>
```

##### 登录拦截优化

编写一个过滤器并注册

```java
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //过滤器，从Session中获取用户
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (user ==null){ //已经被移除或者注销了，或者未登录
            response.sendRedirect("/smbms/error.jsp");

        }else {
            filterChain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
```

过滤器

```xml
    <filter>
        <filter-name>SysFilter</filter-name>
        <filter-class>com.lk.filter.SysFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>SysFilter</filter-name>
        <url-pattern>/jsp/*</url-pattern>
    </filter-mapping>
```

##### 密码修改

**1 导入前端素材**

```jsp
<li><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">密码修改</a></li>
```

**2 项目从底层向上写**

<img src="JavaWeb.assets/image-20230316095533723.png" alt="image-20230316095533723" style="zoom:67%;" />

**3 UserDao**

```java
 public int updatePwd(Connection connection,int id,int password) throws SQLException;
```

**4 UserDao 接口实现类**

```java
public int updatePwd(Connection connection,int id, int password) throws SQLException{
        PreparedStatement pstm = null;
        int execute = 0;
        if (connection != null){
        String sql = "update smbms_user set userPassword = ? where id = ?";
        Object params[] = {password,id};
        execute = BaseDao.execute(connection, sql, params, pstm);
        BaseDao.closeResource(connection,pstm,null);
        }
        return execute;
    }
}
```

**5 UserService层**

```java
public boolean updatePwd( int id, int password) throws SQLException;
```

**6 UserService实现类**

```java
    public boolean updatePwd(int id, int password) throws SQLException {
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();

        //修改密码
        if (userDao.updatePwd(connection,id,password)>0){
            flag = true;
        }
        BaseDao.closeResource(connection,null,null);
        return flag;
    }
```

7 UserServlet（此处注册省略）

==实现复用，需要提取出方法==

```java
//实现Servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("savepwd") && method != null){
            this.updatePwd(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //通过封装 实现Servlet复用
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从Session里面拿ID
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");

        System.out.println("UserServlet" + newpassword);

        boolean flag = false;
        if (o != null && !StringUtils.isNullOrEmpty(newpassword)){
            UserServiceImpl userService = new UserServiceImpl();

            flag = userService.updatePwd(((User) o).getId(), newpassword);
            if (flag){
                req.setAttribute("message","修改成功");
                //密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                //密码修改失败
                req.setAttribute("message","修改失败");
            }


        }else {
            req.setAttribute("message","新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

##### 优化密码修改（使用Ajax）

```java
 // 验证旧密码，session中有用户的密码
    public void pwdModify(HttpServletRequest req,HttpServletResponse resp){
        //从Session里面拿ID
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
// 万能Map :结果集
        HashMap<String,String> resultMap = new HashMap<String,String>();

        if (o == null){ //Session 失效/过期了
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){ //输入的密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) o).getUserPassword(); //Session 中用户的密码
            if (oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }


        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray 阿里巴巴的JSON工具类，转换格式
            /*
            resultMap = ["result","sessionerror","result","error"]
            Json格式 = {key,value}
            */
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

#### 14.4 用户管理实现

![image-20230318101842641](JavaWeb.assets/image-20230318101842641.png)

1 导入分页的工具类

2 用户列表页面导入

##### 3 获取用户数量

==UserDao==

```java
    //查询用户总数
    public int getUserCount(Connection connection,String username,int userRole) throws SQLException;

```

==UserDaoImpl==

```java
public int getUserCount(Connection connection,String username,int userRole)throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u ,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();//存放参数

            if (!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.username like ?");
                list.add("%"+username+"%"); //index: 0

            }

            if (userRole > 0 ){
                sql.append(" and u.userRole = ?");
                list.add(userRole);  //index:1
            }
            //把list转换为数组
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl -> getUserCount" + sql.toString());   //输出最后完整的sql语句

            rs  = BaseDao.execute(connection, sql.toString(), params, rs, pstm);
            if (rs.next()){
                count = rs.getInt("count");  //从结果集中获取最终的数量
            }
            BaseDao.closeResource(null,pstm,rs);

        }
    return count;
    }
```

==UserService==

```java
    //查询记录数
    public int getUserCount(String username,int userRole);
```



==UserServiceImpl==

```java
    public int getUserCount(String username,int userRole){
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null,null );
        }
        return count;
    }
```

##### 4 获取用户列表

==UserDao==

```java
    //获取用户列表
    List<User> getUserList(Connection con, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;
```

==UserDaoImpl==

```java
    //获取用户列表
    @Override
    public List<User> getUserList(Connection connection, String username, int userRole, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if (connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u ,smbms_role r where u.userRole=r.id");
            ArrayList<Object> list = new ArrayList<>();  //存放参数
            if (! StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ?");
                list.add("%" + username + "%");
            }
            if (userRole >0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            // 在Mysql数据库中，分页使用 limit startIndex pageSize; 总数
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;

            list.add(currentPageNo);
            list.add(pageSize) ;

            Object[] params = list.toArray();

            rs = BaseDao.execute(connection, sql.toString(), params, rs, pstm);

            while (rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return userList;
    }
```

==UserService==

```java
    //根据条件查询用户表
    public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo,int pagesize);
```

==UserServiceImpl==

```java
    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pagesize) {
        Connection connection = null;
        List<User> userList = null;

        System.out.println("queryUserName ------>" + queryUserName);
        System.out.println("queryUserRole ------>" + queryUserRole);
        System.out.println("currentPageNo ------>" + currentPageNo);
        System.out.println("pagesize ------>" + pagesize);

        connection = BaseDao.getConnection();
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pagesize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return userList;
    }
```

##### 5 获取角色操作

`为了职责统一，可以把角色的操作单独放在一个包中，和POJO类对应`

==RoleDao==

```java
    public List<Role> getRoleList(Connection connection) throws SQLException;
```

==RoleDaoImpl==

```java
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Role> rolelist = new ArrayList<>();

        if (connection != null){
            String sql ="select * from smbms_role";
            Object[] params = {};

            rs = BaseDao.execute(connection, sql, params, rs, pstm);

            while (rs.next()){
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleName(rs.getString("roleName"));
                _role.setRoleCode(rs.getString("roleCode"));
                rolelist.add(_role);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return rolelist;
    }
```

==RoleService==

```java
    public List<Role> getRoleList() ;
```

==RoleServiceImpl==

```java
public class RoleServiceimpl implements RoleService{
    // 引入Dao
    private RoleDao roleDao;
    public RoleServiceimpl() {
        roleDao = new RoleDaoimpl();
    }
    @Override
    public List<Role> getRoleList()  {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
}
```

```java
 //重点，处理请求
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        //查询用户列表

        //从前端获取数据
        String queryUserName = req.getParameter("queryname");
        System.out.println(queryUserName);
        String temp = req.getParameter("queryUserRole"); //queryUserRole
        System.out.println(temp);
        String pageIndex = req.getParameter("pageIndex");
        System.out.println(pageIndex);

        int queryUserRole = 0;

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;

        //第一次走这个请求，一定是第一页，页面大小是固定的
        int pageSize = 5; //可以把这个写到配置文件中，方便后期修改
        int currentPageNo = 1;

        if (queryUserName == null){
            queryUserName = "";
        }
        if (temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);  //给查询赋值 0，1，2
        }
        if (pageIndex !=null){
            try{
                currentPageNo = Integer.parseInt(pageIndex);
            }catch (Exception e){
                try {
                    resp.sendRedirect("error.jsp");
                } catch (IOException ex) {
                    e.printStackTrace();
                }
            }
        }

        //获取用户总数(分页：   上一页，下一页)
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalPageCount(totalCount);

        int totalPageCount = ((int)(totalCount/pageSize)) + 1;

        //控制首页和尾页
        //如果页面要小于1了，就显示第一页的东西
        if (totalPageCount < 1){
            currentPageNo = 1;
        }else if (currentPageNo>totalPageCount){ //当前页面大于了最后一页
            currentPageNo = totalPageCount;
        }

        //获取用户列表展示
        userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
        req.setAttribute("userlist",userList);
       


        RoleServiceimpl roleService = new RoleServiceimpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("rolelist",roleList);

        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);

        //返回前端

        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

```

