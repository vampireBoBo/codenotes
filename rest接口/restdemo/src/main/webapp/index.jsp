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
		/* 页面加载结束 执行的匿名函数  此时dom对象都已经存在  */
	 	$(document).ready(function() {
	 		/* 显示新增form */
			$('#addorg').on("click",function (){
				$('#selectform').hide();
				$('#addform').show(); //$('#addform').attr("style","");
			});
	 		/* 显示组织列表  */
	 		$('#selectorg').click(function (){
	 			/* 异步获取数据信息 */
	 			$.getJSON("<%=request.getContextPath()%>/org/",);
	 			
	 			$('#addform').hide();
	 			$('#selectform').show();
	 		}); 
	 	}); 
		/* org新增   */
		function subs(){
			var _ono=$('#ono').val();
			var _oname=$('#oname').val();
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
		}
	</script>
	<div align="center">
		<h3>restful API调用测试</h3>
		<div>
			<label><input id="addorg" type="button" value="新增"/></label>
			<label><input id="selectorg" type="button" value="查看"/></label>
		</div>
		<!-- 新增表单 -->
		<div id="addform" class="sydiv" >
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
			<table class="table">
				<caption>组织信息</caption>
				<thead>
					<tr>
						<th>编号</th>
						<th>名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>1</td>
						<td>修改  删除</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
