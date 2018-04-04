======================学习指南======================

一、概念
	REST 指的是一组架构约束条件和原则，其核心是面向资源，使用不同的url对资源进行操作，设计中url不应该出现动词。满足这些约束条件和原则的应用程序或设计就是 RESTful。
	
二、请求方式：
	post（新增） delete（删除）  put（修改） get(查看)
	1.测试时可使用火狐的RESTClient插件进行测试 ：https://addons.mozilla.org/zh-CN/firefox/addon/restclient/
	2.下载RESTClient组件
		下载路径：http://blog.csdn.net/loongshawn/article/details/69267494?locationNum=1&fps=1   
		安装步骤：https://jingyan.baidu.com/article/dca1fa6f7cba4cf1a44052a0.html
		使用文档：https://wenku.baidu.com/view/3b6d4acd5f0e7cd185253653.html

三、使用步骤
	1.pom文件中添加依赖
	<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.8.0</version>
	</dependency>
	<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.8.0</version> 
	</dependency>
	2.若请求内容为实体 ，则需使用@RequestBody 进行参数的传递，相应内容为实体可用@ResponseBody 
	
	2、web.xml中配置HiddenHttpMethodFilter 。因为通常的浏览器都只是支持post跟get，这时候就需要HiddenHttpMethodFilter 过滤器来将post请求转换为put跟delete请求。
	过滤器将post请求转换为我们对应的put跟delete请求的时候需要有一个name为_method的参数才行。
	
	2、

四、restClient注意事项：
	1.使用post请求新增时，需要设置：restClient窗口---》body---》String body---》contenttype=application/json;charset=utf-8
	2.若添加的数据库的中文是乱码需要在连接数据库时指定编码方式，譬如：jdbc:mysql://192.168.9.19:3306/demo?useUnicode=true&characterEncoding=UTF-8 
	3.若接口的调用返回结果中文乱码，需要在接口调用的RequestMapping中指定参数：produces = "application/json;charset=utf-8"


