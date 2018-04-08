<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<script src="<%=request.getContextPath()%>/resources/jquery.min.js" type="text/javascript" ></script>
	<script src="<%=request.getContextPath()%>/resources/layer.js"  type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap-table.min.js" type="text/javascript" ></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap.min.js" type="text/javascript" ></script>
	<link href="<%=request.getContextPath()%>/resources/bootstrap.min.css" type="text/css" rel="stylesheet" >
    <link href="<%=request.getContextPath()%>/resources/bootstrap-table.min.css" type="text/css" rel="stylesheet" >
</head>
<body>
	<style type="text/css">
		.sydiv{display: none;margin-top:50px;width:200px;height:200px;}
	</style>
	<script type="text/javascript">
		var _orgInfo='';
		/* 页面加载结束 执行的匿名函数  此时dom对象都已经存在  */
	 	$(document).ready(function() {
	 		/* 显示新增form */
			$('#addorg').on("click",function (){
				$('#selectform').hide();
				$('#addform').show();
			});
	 		/* 显示组织列表  */
	 		$('#selectorg').click(function (){
	 			/* 异步获取数据信息 */
	 			$('#addform').hide();
	 			getOrgInfo();
	 		}); 
	 	})
		/* org新增   */
		function subs(){
			var _ono=$('#ono').val();
			var _oname=$('#oname').val();
			$.ajax({
	            //url: "http://127.0.0.1/restdemo/org/", //该url属于ajax跨域请求  需要进行设置  推荐使用配置服务器代理的方式 
				//若属于同源则可设置成同源请求即可 
	            url:'<%=request.getContextPath()%>/org/',
	            type : "post",
	            dataType : "json",
	            data : {
	                ono : _ono,
	                oname : _oname
	            },
	            success : function(data){
	                layer.alert(data.result);
	                //跳转至列表
					$('#addform').hide();
					getOrgInfo();
	            },
	            error : function(data){
	            	alert('失败啦！');
	            }
	        }) 
		}
		//删除信息
		function del(_ono){
			layer.confirm("是否删除？",{title:'提示信息：'},function(index){
				//如果确认删除
				var _url='<%=request.getContextPath()%>/org/'+_ono;
				$.ajax({
					url:_url,
					type:'delete',
					success:function(data){
						layer.msg('删除成功，请继续其他操作');
						//重新获取列表信息
						getOrgInfo();
					},
					error:function(){
						layer.msg('删除失败，请稍后重试');
					}
				});
			});
		}
		/* 获取组织列表信息  */
		function getOrgInfo(){
			$('#addform').hide();
			$.getJSON("<%=request.getContextPath()%>/org/",function(data){
 				var _orgs=data.orgLists;
 				//遍历数组 信息
 				$.each(_orgs,function (i,val){
 					_orgInfo+='	<tr>';
 					_orgInfo+=' 	<td>'+_orgs[i].ono+'</td>';
 					_orgInfo+=' 	<td>'+_orgs[i].oname+'</td>';
 					_orgInfo+=' 	<td><a href="javaScript:;" onclick=del('+_orgs[i].ono+') >删除</a></td>';
 					_orgInfo+='	</tr>';
 				});
 				
 				//设置html信息 并显示数据table
 				$('tbody').replaceWith('<tbody></tbody>');   //没生效？
 				$('tbody').html(_orgInfo);
 				$('#selectform').show();
 			}); 
		}
		
	</script>
	<div align="center">
		<h3>restful API调用测试</h3>
		<div>
			<label><input id="addorg" type="button" value="新增"/></label>
			<label><input id="selectorg" type="button" value="查看"/></label>
		</div>
		<!-- 新增表单 -->
		<div id="addform" class="sydiv" style="width:400px;">
			<form>
				<caption>新增组织</caption><br/>
				<label>编号</label><input type="text" name="ono" id="ono" /><br/>
				<label>名称</label><input type="text"  name="oname" id="oname"/><br/><br/>
				<input type="button"  value="提交" id="sub" onclick="subs();"/>
				<input type="reset" value="重置">
			</form>
		</div>
		<!-- 查询列表 -->
		<div id="selectform" class="sydiv">
			<table style="width:400px;">
 				<thead>
					<th>编号</th>
					<th>名称</th>
					<th>操作</th>
			   </thead>
			   <tbody>
			   </tbody>
			 </table>
		</div>
	</div>
</body>
</html>
