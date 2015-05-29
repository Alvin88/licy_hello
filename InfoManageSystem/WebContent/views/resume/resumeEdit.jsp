<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div align="center" style="padding: 5px;overflow: hidden;">
	<form id="resume_jlgl_addForm" method="post">
		<table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" /></td>
				<th>登录名称</th>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="pwd" type="password"
					class="easyui-validatebox" data-options="required:true" /></td>
				<th>创建时间</th>
				<td><input  name="createdatetime" readonly="readonly" /></td>
			</tr>
			<tr>
			<th style="width: 55px;">所属角色</th>
				<td><input id="jlgl_combobox" class="easyui-combobox" name="roleIds" data-options="
				url:'${pageContext.request.contextPath}/roleAction!doNotNeedSession_combobox.action',
				  valueField:'id',  
                  textField:'name',  
                   multiple:true,  
                  panelHeight:'auto'  
				" style="width: 145px;"/>
			</td>
				<th>最后修改时间</th>
				<td><input name="modifydatetime" readonly="readonly" /></td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
</div>