<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
 String editResumeId=request.getParameter("editResumeId"); //用来记录创建的个人信息ID，如果没有创建，就必须先创建简历，才能填写基本信息
%>
<script type="text/javascript">
$(document).ready(function(){
	console.log(<%=editResumeId%>);
});

//创建简历ajax提交
function createResume(){
	$('#add_form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/talentAction!saveOrUpdateTalent.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				//需要设置简历的id
				$('#resume_jlgl_addDialog').dialog('close');
				$("#add_input_resume_id").val(json.obj);//设置id
				$.messager.show({
	                title:'操作提示',
	                msg:json.message,
	                timeout:2000,
	                showType:'slide'
	        	 });
				dg.datagrid('load');
				dg.datagrid('unselectAll');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}


//清空表单函数
function cleanFormFun(formId){
	$("#"+formId).form('clear');
}

</script>

<!-- Start Content -->

<div id="addResumeInfoTab" class="easyui-tabs" style="width:100%;height:400px;">
		<div title="个人信息" data-options="iconCls:'icon-help'" style="padding:10px">
			 <div align="center" style="padding:20px;">
                <form id="add_form_resume_create" method="post">
					<table>
					<tr><td><input id="add_input_resume_id" name="talent.id" hidden="true" /></td></tr>
					<tr>
						<th>姓名<span style="color:red">*</span></th>
						<td><input name="talent.name" class="easyui-textbox" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>性别<span style="color:red">*</span></th>
						<td><select class="easyui-combobox" name="talent.gender" data-options="valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">男</option>
						        <option value="1">女</option>
						    </select>
						</td>
						<th>社保所在地区</th>
						<td><input class="easyui-textbox" name="talent.sbArea" style="width:160px;height:24px;" data-options=""/></td>
					</tr>
					<tr>
					    <th>联系方式<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="talent.mobile" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>电子邮箱</th>
						<td><input class="easyui-textbox" name="talent.email" style="width:160px;height:24px;" /></td>	
						<th>QQ号码</th>
					    <td><input class="easyui-textbox" name="talent.qq" style="width:160px;height:24px;"  /></td>
			        </tr>
					<tr>
					    <th>证书类型<span style="color:red">*</span></th>
						<td><select class="easyui-combobox" name="talent.certificateType"  data-options="required:true,valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">建造师</option>
						        <option value="1">职称证</option>
						        <option value="2">软件架构师</option>
						        <option value="3">软件设计师</option>
						        <option value="4">其他</option>
						    </select></td>
						<th>专业</th>
						<td><input class="easyui-textbox" name="talent.profession"  style="width:160px;height:24px;"/></td>
						<th>注册情况</th>
						<td><select class="easyui-combobox" name="talent.registerResult"  data-options="required:true,valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">初始</option>
						        <option value="1">转注</option>
						        <option value="4">其他</option>
						    </select></td>
					 </tr>
					<tr>
					    <th>跟进记录</th>
						<td><input class="easyui-textbox" name="talent.traceRecord" style="width:160px;height:24px;" /></td>
						<th>到期日期<span style="color:red">*</span></th>
						<td><input class="easyui-datebox" name="talent.expireDate" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>备注</th>
						<td><input class="easyui-textbox" name="talent.remark" style="width:160px;height:24px;" data-options="" /></td>
					</tr>
					<tr>
					 <td align="center" style="width:100px;height:30px;" colspan=8>
					 	<a href="#" class="easyui-linkbutton" onclick="createResume();" data-options="iconCls:'icon-save'">保存</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		
	
	</div>
<!-- End  Content -->  		
 		

    		
