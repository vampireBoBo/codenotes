======================学习指南======================

一、概念
	REST 指的是一组架构约束条件和原则，其核心是面向资源，使用不同的url对资源进行操作，设计中url不应该出现动词。满足这些约束条件和原则的应用程序或设计就是 RESTful。
	
二、请求方式：
	post（新增） delete（删除）  put（修改） get(查看)
	
三、使用步骤
	1、controller层中restful风格的接口设计
		A、pom文件中添加依赖
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
		B、controller层注解的使用（restful接口为了扩展，只提供了返回结果，不需要返回视图。）
			1） @RestController（使用该注解，springmvc的视图解析器失效，具体的返回结果为return 之后的内容）
			2） @Controller + @ResponseBody （使用@controller则会返回视图，但接口外放需要的只是数据库，故使用@responseBody将其进行转换）
			3）controller层的注解使用1）或2）其中一种即可，该类添加@RequestMapping(resourceName)  resourceName:为资源名称视为资源唯一标识符，而该类则是针对于该资源的增删该查。	
 		C、不同请求方式的接口设计：
			@RequestMapping(value="/",method=RequestMethod.POST, produces = "application/json;charset=utf-8")
			@RequestMapping(value="/",method=RequestMethod.PUT,produces="application/json;charset=utf-8")
			@RequestMapping(value="/",method=RequestMethod.GET,produces="application/json;charset=utf-8")
			@RequestMapping(value="/{ono}",method=RequestMethod.DELETE)	 
		D、若请求内容为实体 ，则需使用@RequestBody 进行参数的传递，相应内容为实体可用@ResponseBody,@RequestMapping指定访问url，@RequestMapping(value="/",method=RequestMethod.POST, produces = "application/json;charset=utf-8")method指定访问方式是post，即可表示这是一个对资源新增的操作，produces中的application/json指定该接口调用完毕的返回数据格式为json，chartset指定了返回参数的编码方式
	2、前台调用restful接口
		A、http协议只支持get post请求方式，故如果是delete put请求时  需要进行转换。但目前使用ajax请求方式，只需要执行访问方式即可。例如：
		$.ajax({
	            url: "http://127.0.0.1:8080/restdemo/org/",
	            type : "post",
	            dataType : "json",
	            data : {
	                ono : _ono,
	                oname : _oname
	            },
	            success : function(data){
	                layer.msg(data.result);
	                //layer.alert(data.result);
	                //confirm();
	            },
	            error : function(data){
	            	layer.alert('失败啦！');
	            }
	        }) 
	        
三、外部测试工具（该方式提供的接口，不需要进行外放，只需要启动服务，通过指定的url和参数即可获取数据信息。）
	测试工具选择其中一种即可，推荐使用第二种：
	1.测试时可使用火狐的RESTClient插件进行测试 ：
		https://addons.mozilla.org/zh-CN/firefox/addon/restclient/
	2.下载RESTClient组件
		下载路径：http://blog.csdn.net/loongshawn/article/details/69267494?locationNum=1&fps=1   
		安装步骤：https://jingyan.baidu.com/article/dca1fa6f7cba4cf1a44052a0.html
		使用文档：https://wenku.baidu.com/view/3b6d4acd5f0e7cd185253653.html
		
四、restClient注意事项：
	1.使用post请求新增时，需要设置：restClient窗口---》body---》String body---》contenttype=application/json;charset=utf-8
	2.若添加的数据库的中文是乱码需要在连接数据库时指定编码方式，譬如：jdbc:mysql://192.168.9.19:3306/demo?useUnicode=true&characterEncoding=UTF-8 
	3.若接口的调用返回结果中文乱码，需要在接口调用的RequestMapping中指定编码参数：produces = "application/json;charset=utf-8"


