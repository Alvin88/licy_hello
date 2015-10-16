<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <form id="resume_record_addForm" method="post">
		<table>
			<tr>
			 <td><input name="talentRecord.talentId" hidden="true" id="record_talent_id" /></td>
			</tr>
			<tr>
			<th>跟进内容<span style="color:red">*</span></th>
			<td colspan=8><input class="easyui-textbox" name="talentRecord.record" data-options="multiline:true,required:true" style="width:300px;height:60px;" /></td>
			</tr>
		</table>
	</form>