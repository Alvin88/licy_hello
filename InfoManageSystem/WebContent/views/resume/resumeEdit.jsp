<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
 String editResumeId=request.getParameter("editResumeId"); //用来记录创建的个人信息ID，如果没有创建，就必须先创建简历，才能填写基本信息
%>
<script type="text/javascript">
var editworklist = $('#editworklist');
var editprojectlist = $("#editprojectlist");
var editedulist = $("#editedulist");
var editlanlist = $("#editlanlist");

$(document).ready(function(){
	console.log(<%=editResumeId%>);
	$("#edit_input_resume_id").val(<%=editResumeId%>);//设置id
	$('#editworklist').datagrid({
		onClickRow: function(index,row){
			console.log("work");
			//将datagrid中选中的行内容填充到表单
            $('#edit_form_resume_work').form('load',{
            	"resumeWork.workId":row.workId,
            	"resumeWork.resumeId":row.resumeId,
            	"resumeWork.workFromDate":row.workFromDate,
            	"resumeWork.workToDate":row.workToDate,
            	"resumeWork.industry":row.industry,
            	"resumeWork.company":row.company,
            	"resumeWork.companyType":row.companyType,
            	"resumeWork.companySize":row.companySize,
            	"resumeWork.division":row.division,
            	"resumeWork.position":row.position,
            	"resumeWork.leaveReason":row.leaveReason,
            	"resumeWork.responsiblity":row.responsiblity,
            	"resumeWork.achievement":row.achievement
            	
            });
		}
	});
	$('#editprojectlist').datagrid({
		onClickRow: function(index,row){
			  console.log("project");
			  $('#edit_form_resume_project').form('load',{
				  	"resumeProject.projectId":row.projectId,
	            	"resumeProject.resumeId":row.resumeId,
	            	"resumeProject.projectTitle":row.projectTitle,
	            	"resumeProject.projectFromDate":row.projectFromDate,
	            	"resumeProject.projectToDate":row.projectToDate,
	            	"resumeProject.projectManager":row.projectManager,
	            	"resumeProject.otherMembers":row.otherMembers,
	            	"resumeProject.projectDetail":row.projectDetail,
	            	"resumeProject.myAchievement":row.myAchievement
	            });
		}
	});
	$('#editedulist').datagrid({
		onClickRow: function(index,row){
			  console.log("edu");
			  $('#edit_form_resume_edu').form('load',{
				  	"resumeEdu.eduId":row.eduId,
	            	"resumeEdu.resumeId":row.resumeId,
	            	"resumeEdu.eduFromDate":row.eduFromDate,
	            	"resumeEdu.eduToDate":row.eduToDate,
	            	"resumeEdu.degree":row.degree,
	            	"resumeEdu.schoolName":row.schoolName,
	            	"resumeEdu.subMajor":row.subMajor,
	            	"resumeEdu.edu_detail":row.edu_detail
	            	
	            });
		}
	});
	$('#editlanlist').datagrid({
		onClickRow: function(index,row){
			  console.log("lan");
			  $('#edit_form_resume_lan').form('load',{
				    "resumeLan.eduId":row.lanId,
	            	"resumeLan.resumeId":row.resumeId,
	            	"resumeLan.languageCategory":row.languageCategory,
	            	"resumeLan.languageLevel":row.languageLevel,
	            	"resumeLan.master":row.master,
	            	"resumeLan.rwAbility":row.rwAbility,
	            	"resumeLan.lsAbility":row.lsAbility,
	            	"resumeLan.supplement":row.supplement
	            });
		}
	});
	
	
});

//创建简历ajax提交
function createResume(){
	$('#edit_form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResume.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				//需要设置简历的id
				$("#edit_input_resume_id").val(json.obj);//设置id
				$.messager.show({
	                title:'操作提示',
	                msg:json.message,
	                timeout:2000,
	                showType:'slide'
	        	 });
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//创建简历ajax提交
function saveOrUpdateResumeWork(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editwork_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_work表单中
		$('#edit_form_resume_work').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeWork.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					editworklist.datagrid('load');
					//ad.dialog('close');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加工作经历信息');
	}
	
}

//保存个人信息ajax提交
function saveOrUpadateResumeProject(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editproject_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_project表单中
		$('#edit_form_resume_project').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeProject.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					editprojectlist.datagrid('load');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
					//ad.dialog('close');
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加项目经验信息');
	}
}

//保存求职意向ajax提交
function saveOrUpdateResumeLan(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editlan_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_lan表单中
		$('#edit_form_resume_lan').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeLan.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					editlanlist.datagrid('load');
					//ad.dialog('close');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加语言水平信息');
	}
}

//保存工作经验ajax提交
function saveOrUpdateResumeEdu(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editedu_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_edu表单中
		$('#edit_form_resume_edu').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeEdu.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					editedulist.datagrid('load');
					//ad.dialog('close');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加教育经历信息');
	}
}

//保存教育经历ajax提交
function saveOrUpdateResumeJobInten(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editjobinten_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_jobintension表单中
		$('#edit_form_resume_jobintension').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeJobInten.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					//ad.dialog('close');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加求职意向信息');
	}
}

//保存语言水平ajax提交
function saveOrUpdateResumeOtherInfo(){
	var resumeId = $("#edit_input_resume_id").val();//获取创建的简历id
	if(resumeId!=null&&resumeId!=''){
		$("#editotherinfo_resumeid").val(resumeId);//将获取到的简历id设置到edit_form_resume_otherinfo表单中
		$('#edit_form_resume_otherinfo').form('submit', {
			url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeOtherInfo.action',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					//ad.dialog('close');
					$.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         	});
				}
				$.messager.show({
					msg : json.msg,
					title : '提示'
				});
			}
		});
	}else{
		$.messager.alert('提示', '请先创建简历，在添加其他信息');
	}
}



var workToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	var rows = editworklist.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'请确认',
							'您要删除当前所选项目？',
							function(r) {
								if (r) {
									for ( var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$.ajax({
												url : '${pageContext.request.contextPath}/resumeAction!deleteResumeWork.action',
												data : {
													resumeWorkIds : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													editworklist.datagrid('load');
													editworklist.datagrid('unselectAll');
													$.messager.show({
														title : '提示',
														msg : d.msg
													});
												}
											});
								}
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
    }
}];
var projectToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	var rows = editprojectlist.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'请确认',
							'您要删除当前所选项目？',
							function(r) {
								if (r) {
									for ( var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$.ajax({
												url : '${pageContext.request.contextPath}/resumeAction!deleteResumeProject.action',
												data : {
													resumeProjectIds : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													editprojectlist.datagrid('load');
													editprojectlist.datagrid('unselectAll');
													$.messager.show({
														title : '提示',
														msg : d.msg
													});
												}
											});
								}
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
    }
}];
var eduToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	var rows = editedulist.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'请确认',
							'您要删除当前所选项目？',
							function(r) {
								if (r) {
									for ( var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$.ajax({
												url : '${pageContext.request.contextPath}/resumeAction!deleteResumeEdu.action',
												data : {
													resumeEduIds : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													editedulist.datagrid('load');
													editedulist.datagrid('unselectAll');
													$.messager.show({
														title : '提示',
														msg : d.msg
													});
												}
											});
								}
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
    
    }
}];
var lanToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	var rows = editlanlist.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager
					.confirm(
							'请确认',
							'您要删除当前所选项目？',
							function(r) {
								if (r) {
									for ( var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$.ajax({
												url : '${pageContext.request.contextPath}/resumeAction!deleteResumeLan.action',
												data : {
													resumeLanIds : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													editlanlist.datagrid('load');
													editlanlist.datagrid('unselectAll');
													$.messager.show({
														title : '提示',
														msg : d.msg
													});
												}
											});
								}
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
    }
}];

//删除简历相关的其他信息
function deleteOtherInfo(){
	var otherInfoId = $("#editotherinfolist").val();
	if(otherInfoId!=null&&otherInfoId!=''){
		$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeOtherInfo.action',
			data : {
				resumeOtherInfoIds : otherInfoId
			},
			dataType : 'json',
			success : function(d) {
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
	}else{
		$.messager.alert('提示', '目前简历还没有录入求职意向信息，请先录入信息！');
	}
}

//删除简历相关的求职意向信息
function deleteJobInten(){
	var jobIntenId = $("#editjobintenlist").val();
	if(jobIntenId!=null&&jobIntenId!=''){
		$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeJobInten.action',
			data : {
				resumeJobIntenIds :jobIntenId
			},
			dataType : 'json',
			success : function(d) {
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
	}else{
		$.messager.alert('提示', '目前简历还没有录入其他信息，请先录入！');
	}
	
}

//清空表单函数
function cleanFormFun(formId){
	$("#"+formId).form('clear');
}

</script>

<!-- Start Content -->

<div id="editResumeInfoTab" class="easyui-tabs" style="width:100%;height:480px;">
		<div title="个人信息" data-options="iconCls:'icon-help'" style="padding:10px">
			 <div align="center" style="padding:20px;">
                <form id="edit_form_resume_create" method="post">
					<table>
					<tr><td><input id="edit_input_resume_id" name="resume.id" hidden="true" /></td></tr>
					<tr>
						<th>简历编号</th>
						<td><input readonly="readonly" name="resume.code" class="easyui-textbox" style="width:160px;height:24px;"/></td>
						<th>登录名称<span style="color:red">*</span></th>
						<td><input name="resume.loginname" class="easyui-textbox" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>登录密码<span style="color:red">*</span></th>
						<td><input name="resume.loginpwd" class="easyui-textbox" type="password" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>电子邮箱<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resume.email" style="width:160px;height:24px;" data-options="required:true"/></td>
					</tr>
					<tr>
						<th>姓名<span style="color:red">*</span></th>
						<td><input name="resume.realname" class="easyui-textbox" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>性别<span style="color:red">*</span></th>
						<td><select class="easyui-combobox" name="resume.gender" data-options="valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">男</option>
						        <option value="1">女</option>
						    </select>
						</td>
						<th>出生日期</th>
						<td><input class="easyui-datebox" name="resume.birthday" style="width:160px;height:24px;" data-options="" /></td>
						<th>身高(cm)</th>
						<td><input  name="resume.stature" class="easyui-numberbox" style="width:160px;height:24px;" /></td>
					</tr>
					<tr>
						
						<th>籍贯</th>
						<td><input class="easyui-textbox" name="resume.jiguan" style="width:160px;height:24px;" data-options=""/></td>
						<th>婚姻状况</th>
						<td><select class="easyui-combobox" name="resume.marrige"  data-options="valueField:'id',textField:'text'" style="width:160px;height:24px;" >
						        <option value="0">未婚</option>
						        <option value="1">已婚</option>
						        <option value="2">保密</option>
						    </select></td>
						<th>政治面貌</th>
						<td><select class="easyui-combobox" name="resume.politicalStatus"  data-options="valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="1">中共党员</option>
						        <option value="2">中共预备党员</option>
						        <option value="3">共青团员</option>
						        <option value="4">民革党员</option>
						        <option value="5">民盟盟员</option>
						        <option value="6">民建会员</option>
						        <option value="7">民进会员</option>
						        <option value="8">农工党党员</option>
						        <option value="9">致公党党员</option>
						        <option value="10">九三学社社员</option>
						        <option value="11">台盟盟员</option>
						        <option value="12">无党派人士</option>
						        <option value="13">群众</option>
						   </select></td>
						 <th>最高学历</th>
						<td><select class="easyui-combobox" name="resume.highestDegree"  data-options="valueField:'id',textField:'text'" style="width:160px;height:24px;">
							    <option value="0">博士</option>
						        <option value="1">硕士</option>
						        <option value="2">本科</option>
						        <option value="3">大专</option>
						        <option value="4">高中</option>
						        <option value="5">初中</option>
						        <option value="6">小学</option>
						        <option value="7">其他</option>
						    </select></td>
					</tr>
					<tr>
						
						<th>手机号码<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resume.mobile" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>家庭电话</th>
						<td><input class="easyui-textbox"  name="resume.homeTel" style="width:160px;height:24px;" /></td>
						<th>证件类型</th>
						<td><select class="easyui-combobox" name="resume.cardType"  data-options="required:true,valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">身份证</option>
						        <option value="1">学生证</option>
						        <option value="2">工作证</option>
						        <option value="3">士兵证</option>
						        <option value="4">军官证</option>
						        <option value="5">护照</option>
						        <option value="6">户口本</option>
						        <option value="7">其他</option>
						    </select></td>
						<th>证件号码<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resume.idNumber"  data-options="required:true" style="width:160px;height:24px;"/></td>
					</tr>
					<tr>
						<th>QQ号码</th>
					    <td><input class="easyui-textbox" name="resume.qqId" style="width:160px;height:24px;"  /></td>
						<th>目前所在地</th>
						<td><input class="easyui-textbox" name="resume.location" style="width:160px;height:24px;" data-options=""/></td>
						<th>详细地址</th>
						<td><input class="easyui-textbox" name="resume.address" style="width:160px;height:24px;" /></td>
						<th>个人照片</th>
						<td><input class="easyui-filebox" name="resume.photo" data-options="prompt:'选择图片...'" style="width:160px;height:24px;" /></td>
					</tr>
					
					<tr>
						
					    <th>邮政编码</th>
						<td><input class="easyui-textbox" name="resume.zipCode" style="width:160px;height:24px;" /></td>
						<th>工作年限</th>
						<td><input class="easyui-numberbox" name="resume.workYear" style="width:160px;height:24px;"  /></td>
						<th>求职状态</th>
						<td><input class="easyui-textbox" name="resume.currSituation" style="width:160px;height:24px;" data-options="" /></td>
						<th>个人主页</th>
						<td><input class="easyui-textbox" name="resume.homePage" style="width:160px;height:24px;" data-options="" /></td>
					</tr>
					<tr>
						<th>关键字</th>
						<td><input class="easyui-textbox" name="resume.resumeKey" style="width:160px;height:24px;"  /></td>
						<th>创建时间</th>
						<td><input readonly="readonly" class="easyui-datetimebox" name="resume.cdate" style="width:160px;height:24px;" /></td>
						<th></th>
						<td></td>
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
		<div title="求职意向" data-options="iconCls:'icon-help'" style="padding:10px">
			<div align="center" style="padding:20px;">
                	<form id="edit_form_resume_jobintension" method="post">
					<table>
					<tr>
					<td><input hidden="true" id="editjobintenlist" name="resumeJobInten.jobIntenId"></input></td>
					<td><input hidden="true" id="editjobinten_resumeid" name="resumeJobInten.resumeId" ></input></td>
					</tr>
					<tr>
						<th>工作类型<span style="color:red">*</span></th>
						<td><select class="easyui-combobox" name="resumeJobInten.jobTerm"  data-options="required:true,valueField:'id',textField:'text'" style="width:160px;height:24px;">
						        <option value="0">全职</option>
						        <option value="1">兼职</option>
						        <option value="2">实习</option>
						        <option value="3">其他</option>
						    </select></td>
						<th>工作地点<span style="color:red">*</span></th>
						<td><input name="resumeJobInten.jobArea" class="easyui-textbox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
						<th>工作行业</th>
						<td><input name="resumeJobInten.industryType" class="easyui-textbox"  style="width:160px;height:24px;"
							  /></td>
						<th>工作职位</th>
						<td><input class="easyui-textbox" name="resumeJobInten.funType" style="width:160px;height:24px;" data-options=""/></td>
					</tr>
					<tr>
						<th>期望薪水</th>
						<td><input class="easyui-textbox" name="resumeJobInten.salary" style="width:160px;height:24px;" /></td>
						<th>到岗时间</th>
						<td><input class="easyui-datetimebox" name="resumeJobInten.entryDate" style="width:160px;height:24px;" /></td>
						
					</tr>
					<tr>
					<th>自我评价<span style="color:red">*</span></th>
					<td colspan=8><input class="easyui-textbox" name="resumeJobInten.introduction" data-options="multiline:true,required:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
					  <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" onclick="saveOrUpdateResumeJobInten();" data-options="iconCls:'icon-save'">保存</a>
					 </td>
					 <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" onclick="deleteJobInten();" data-options="iconCls:'icon-cancel'">删除</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		<div title="工作经历" data-options="iconCls:'icon-help'">
			<div align="center">
			      <!-- 已经添加的工作经验 -->
					<table class="easyui-datagrid" id="editworklist" style="width:99%;height:200px"
			            data-options="fitColumns:true,rownumbers:true,singleSelect:true,method:'get',toolbar:workToolbar">
			        <thead>
			            <tr>
			            	<th data-options="field:'ck',checkbox:true"></th>
			                <th data-options="field:'workFromDate',width:80,align:'center'">开始日期</th>
			                <th data-options="field:'workToDate',width:80,align:'center'">结束日期</th>
			                <th data-options="field:'industry',width:80,align:'center'">行业</th>
			                <th data-options="field:'company',width:80,align:'center'">公司名称</th>
			                <th data-options="field:'companyType',width:80,align:'center'">公司性质</th>
			                <th data-options="field:'companySize',width:80,align:'center'">公司规模</th>
			                <th data-options="field:'division',width:80,align:'center'">所在部门</th>
			                <th data-options="field:'position',width:80,align:'center'">职位</th>
			                <th data-options="field:'leaveReason',width:80,align:'center'">离职原因</th>
			            </tr>
				     </thead>
				    </table>
			
                	<form id="edit_form_resume_work" method="post">
					<table>
					<tr>
					<td><input hidden="true" name="resumeWork.workId"></input></td>
					<td><input hidden="true" id="editwork_resumeid" name="resumeWork.resumeId"></input></td>
					</tr>
					<tr>
						<th>开始日期<span style="color:red">*</span></th>
						<td><input name="resumeWork.workFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
							data-options="required:true" /></td>
						<th>结束日期<span style="color:red">*</span></th>
						<td><input name="resumeWork.workToDate" class="easyui-datebox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
						<th>行业</th>
						<td><input name="resumeWork.industry" class="easyui-textbox"  style="width:160px;height:24px;"
							 data-options="" /></td>
						<th>公司<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeWork.company" style="width:160px;height:24px;" data-options="required:true"></input></td>
		
					</tr>
					<tr>
						<th>公司性质</th>
						<td><select class="easyui-combobox" name="resumeWork.companyType" style="width:160px;height:24px;">
						        <option value="0">国企</option>
						        <option value="1">民企</option>
						        <option value="2">外企</option>
						        <option value="3">其他</option>
							    </select></td>
						<th>公司规模</th>
						<td><select class="easyui-combobox" name="resumeWork.companySize" style="width:160px;height:24px;">
						        <option value="0">50人以下</option>
						        <option value="1">50-100人</option>
						        <option value="2">100-500人</option>
						        <option value="3">500-1000人</option>
						        <option value="4">1000-2000人</option>
						        <option value="4">2000-5000人</option>
						        <option value="4">5000人以上</option>
							    </select></td>
						<th>所在部门</th>
						<td><input class="easyui-textbox" name="resumeWork.division" style="width:160px;height:24px;" /></td>
						<th>职位</th>
						<td><input class="easyui-textbox" name="resumeWork.position" style="width:160px;height:24px;" /></td>
					</tr>
					<tr>
						<th>离职原因<span style="color:red">*</span></th>
						<td colspan=8><input class="easyui-textbox" name="resumeWork.leaveReason" style="width:100%;height:24px;" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>工作描述<span style="color:red">*</span></th>
						<td colspan=8><input class="easyui-textbox" name="resumeWork.responsiblity" data-options="multiline:true,required:true" style="width:100%;height:60px;"  /></td>
					</tr>
					<tr>
						<th>主要成绩</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeWork.achievement" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					
					</tr>
					<tr>
					  <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton"  onclick="saveOrUpdateResumeWork();" data-options="iconCls:'icon-save'">添加</a>
					 </td>
					 <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" onclick="cleanFormFun('edit_form_resume_work')" data-options="iconCls:'icon-cancel'">清空</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		<div title="项目经验" data-options="iconCls:'icon-help'" >
			<div align="center">
			  <table class="easyui-datagrid"  id="editprojectlist"  style="width:99%;height:200px"
		            data-options="fitColumns:true,rownumbers:true,singleSelect:true,method:'get',toolbar:projectToolbar">
		        <thead>
		            <tr>
		            		<th data-options="field:'ck',checkbox:true"></th>
		               		<th data-options="field:'projectTitle',width:80,align:'center'">项目名称</th>
			                <th data-options="field:'projectFromDate',width:80,align:'center'">开始日期</th>
			                <th data-options="field:'projectToDate',width:80,align:'center'">结束日期</th>
			                <th data-options="field:'projectManager',width:80,align:'center'">项目经理</th>
			                <th data-options="field:'otherMembers',width:80,align:'center'">其他成员</th>
			                <th data-options="field:'projectDetail',width:80,align:'center'">项目描述</th>
			                <th data-options="field:'myAchievement',width:80,align:'center'">我的职责</th>
		            </tr>
			     </thead>
			    </table>
				
                 <form id="edit_form_resume_project" method="post">
					<table>
					<tr>
					<td><input hidden="true" name="resumeProject.projectId"></input></td>
					<td><input hidden="true" id="editproject_resumeid" name="resumeProject.resumeId"></input></td>
					</tr>
					 <tr>
						<th>项目名称<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeProject。projectTitle" data-options="required:true" style="width:160px;height:24px;"></td>
						<th>开始日期<span style="color:red">*</span></th>
						<td><input name="resumeProject。projectFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
							data-options="required:true" /></td>
						<th>结束日期<span style="color:red">*</span></th>
						<td><input name="resumeProject。projectToDate" class="easyui-datebox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<th>项目经理</th>
						<td><input name="resumeProject。projectManager" class="easyui-textbox"  style="width:160px;height:24px;"
							  /></td>
						<th>其他成员</th>
						<td><input class="easyui-textbox" name="resumeProject。otherMembers" style="width:160px;height:24px;" data-options=""></input></td>
					</tr>
					<tr>
						<th>项目描述<span style="color:red">*</span></th>
						<td colspan=8><input class="easyui-textbox" name="resumeProject.projectDetail" data-options="multiline:true,required:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
						<th>我的职责</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeProject.myAchievement" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" onclick="saveOrUpdateResumeProject();" data-options="iconCls:'icon-save'">添加</a>
					 </td>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" onclick="cleanFormFun('edit_form_resume_project')" data-options="iconCls:'icon-cancel'">清空</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		
			
		
		<div title="教育经历" data-options="iconCls:'icon-help'" >
					<div align="center" >
					     <table class="easyui-datagrid"  id="editedulist"  style="width:99%;height:200px"
				            data-options="fitColumns:true,rownumbers:true,singleSelect:true,method:'get',toolbar:eduToolbar">
				        <thead>
				            <tr>
				           		<th data-options="field:'ck',checkbox:true"></th>
				                <th data-options="field:'eduFromDate',width:80,align:'center'">开始日期</th>
				                <th data-options="field:'eduToDate',width:80,align:'center'">结束日期</th>
				                <th data-options="field:'degree',width:80,align:'center'">学历</th>
				                <th data-options="field:'schoolName',width:80,align:'center'">学校</th>
				                <th data-options="field:'subMajor',width:80,align:'center'">专业</th>
				                <th data-options="field:'edu_detail',width:80,align:'center'">详细描述</th>
				            </tr>
					     </thead>
					    </table>
		                	<form id="edit_form_resume_edu" method="post">
							<table>
							<tr>
							<td><input hidden="true" name="resumeEdu.eduId"></input></td>
							<td><input hidden="true" id="editedu_resumeid" name="resumeEdu.resumeId"></input></td>
							</tr>
							<tr>
								<th>开始日期<span style="color:red">*</span></th>
								<td><input name="resumeEdu。eduFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
									data-options="required:true" /></td>
								<th>结束日期<span style="color:red">*</span><span style="color:red">*</span></th>
								<td><input name="resumeEdu。eduToDate" class="easyui-datebox" style="width:160px;height:24px;"
									data-options="required:true" /></td>
								<th>学历<span style="color:red">*</span></th>
								<td><select class="easyui-combobox" name="resumeEdu。degree" data-options="required:true" style="width:160px;height:24px;">
						        <option value="0">博士</option>
						        <option value="1">硕士</option>
						        <option value="2">本科</option>
						        <option value="3">大专</option>
						        <option value="4">高中</option>
						        <option value="5">初中</option>
						        <option value="6">小学</option>
						        <option value="7">其他</option>
							    </select></td>
							    <th>学校<span style="color:red">*</span></th>
								<td><input name="resumeEdu。schoolName" class="easyui-textbox"  style="width:160px;height:24px;"
									 data-options="required:true" /></td>
							</tr>
							<tr>
								<th>专业</th>
								<td><input class="easyui-textbox" name="resumeEdu。subMajor" style="width:160px;height:24px;" data-options="" /></td>
							</tr>
							<tr>
								<th>详细描述</th>
								<td colspan=8><input class="easyui-textbox" name="resumeEdu。edu_detail" data-options="multiline:true" style="width:100%;height:60px;" /></td>
							
							</tr>
							<tr>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" onclick="saveOrUpdateResumeEdu();" data-options="iconCls:'icon-save'">添加</a>
							 </td>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" onclick="cleanFormFun('edit_form_resume_edu')" data-options="iconCls:'icon-cancel'">清空</a>
							 </td>
							 </tr>
						</table>
					</form>		
					</div>
		</div>
		<div title="语言水平" data-options="iconCls:'icon-help'" >
			
					<div align="center" >
					
						<table class="easyui-datagrid"  id="editlanlist"  style="width:99%;height:200px"
				            data-options="fitColumns:true,rownumbers:true,singleSelect:true,method:'get',toolbar:lanToolbar">
				        <thead>
				            <tr>
				            	<th data-options="field:'ck',checkbox:true"></th>
				                <th data-options="field:'languageCategory',width:80,align:'center'">语言类别</th>
				                <th data-options="field:'languageLevel',width:80,align:'center'">语言等级</th>
				                <th data-options="field:'master',width:80,align:'center'">掌握程度</th>
				                <th data-options="field:'rwAbility',width:80,align:'center'">读写能力</th>
				                <th data-options="field:'lsAbility',width:80,align:'center'">听说能力</th>
				                <th data-options="field:'supplement',width:80,align:'center'">语言补充</th>
				            </tr>
					     </thead>
					    </table>
		                	<form id="edit_form_resume_lan" method="post">
							<table>
							<tr>
							<td><input hidden="true" name="resumeLan.lanId" /></td>
							<td><input hidden="true" id="editlan_resumeid" name="resumeLan.resumeId" /></td>
							</tr>
							<tr>
								<th>语言类别<span style="color:red">*</span></th>
								<td><select class="easyui-combobox" name="resumeLan。languageCategory" data-options="required:true" style="width:160px;height:24px">
						        <option value="0">英语</option>
						        <option value="1">日语</option>
						        <option value="2">德语</option>
						        <option value="3">俄语</option>
						        <option value="4">法语</option>
						        <option value="5">西班牙语</option>
						        <option value="6">阿拉伯语</option>
						        <option value="7">普通话</option>
						        <option value="8">其他</option>
							    </select></td>
								<th>语言等级</th>
								<td><input name="resumeEdu。languageLevel" class="easyui-textbox"  style="width:160px;height:24px;"
									  /></td>
								<th>掌握程度<span style="color:red">*</span></th>
								<td><select class="easyui-combobox" name="resumeLan。master" data-options="required:true" style="width:160px;height:24px;">
						         <option value="0">优秀</option>
						         <option value="1">良好</option>
						         <option value="3">一般</option>
							    </select></td>
							</tr>
								<tr>
								<th>读写能力<span style="color:red">*</span></th>
								<td><select class="easyui-combobox" name="resumeLan。rwAbility" data-options="required:true" style="width:160px;height:24px;">
						        <option value="0">优秀</option>
						        <option value="1">良好</option>
						        <option value="3">一般</option>
							    </select></td>
								<th>听说能力<span style="color:red">*</span></th>
								<td><select class="easyui-combobox" name="resumeLan。lsAbility" data-options="required:true" style="width:160px;height:24px;">
						         <option value="0">优秀</option>
						        <option value="1">良好</option>
						        <option value="3">一般</option>
							    </select></td>
							    <th>备注</th>
								<td><input name="resumeLan。supplement" class="easyui-textbox"  style="width:160px;height:24px;" /></td>
							</tr>
							<tr>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" onclick="saveOrUpdateResumeLan();" data-options="iconCls:'icon-save'">添加</a>
							 </td>
							 <td  colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" onclick="cleanFormFun('edit_form_resume_lan')" data-options="iconCls:'icon-cancel'">清空</a>
							 </td>
							 </tr>
						</table>
					</form>		
					</div>
		</div>
		<div title="其他信息" data-options="iconCls:'icon-help'" style="padding:10px">
				<div align="center" style="padding:20px;">
	                <form id="edit_form_resume_otherinfo" method="post">
					<table>
					<tr>
						<td><input hidden="true" id="editotherinfolist" name="resumeOtherInfo.otherId"></input></td>
						<td><input hidden="true" id="editotherinfo_resumeid" name="resumeOtherInfo.resumeId"></input></td>
					</tr>
					<tr>
						<th>个人爱好<span style="color:red">*</span></th>
						<td><input name="resumeOtherInfo。personalHobby" class="easyui-textbox"  style="width:200px;height:24px;"
							 data-options="required:true" /></td>
						<th>个人特长<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeOtherInfo。specialSkill" style="width:200px;height:24px;" data-options="required:true" ></input></td>
						<th>&nbsp</th>
						<td>&nbsp</td>
						<th>&nbsp</th>
						<td>&nbsp</td>	
					</tr>
					<tr>
						<th>个人荣誉</th>
						<td colspan=8><input class="easyui-textbox" name="resumeOtherInfo.personHonor" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
						<th>参加社团/组织</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeOtherInfo.partiGroup" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
						<th>自我评价</th>
						<td colspan=8><input class="easyui-textbox" name="resumeOtherInfo.evaluation" data-options="multiline:true" style="width:100%;height:60px;" /></td>			
					</tr>
					<tr>
					 	<th>其他技能</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeOtherInfo.otherSkill" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
						<tr>
						 <td colspan=4 align="center" style="width:100px;height:30px;">
						 	<a href="#" class="easyui-linkbutton" onclick="saveOrUpdateResumeOtherInfo();" data-options="iconCls:'icon-save'">保存</a>
						 </td>
						 <td colspan=4 align="center" style="width:100px;height:30px;">
						 	<a href="#" class="easyui-linkbutton" onclick="deleteOtherInfo();" data-options="iconCls:'icon-cancel'">删除</a>
						 </td>
						 </tr>
					</table>
				</form>		
				</div>
		</div>
	</div>
<!-- End  Content -->  		
 		

    		
