<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
 String personId=""; //用来记录创建的个人信息ID，如果没有创建，就必须先创建简历，才能填写基本信息
%>
<script type="text/javascript">
 
$(document).ready(function(){
	$('#resumeInfoTab').tabs({//判断
		onSelect:function(title){
			if(title!=='个人信息'){
				var personId ="<%=personId%>";
				if(personId==''||personId==null){
					//$('#resumeInfoTab').tabs('select',0);
				//	$.messager.alert('提示','请先填写个人信息并创建简历后再填写'+title+'!','warning');
					//$('#resumeInfoTab').tabs('disableTab', 1);
				}
			}
	    }
	});
	
	
});

//创建简历ajax提交
function createResume(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResume.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				 $.messager.show({
		                title:'操作提示',
		                msg:json.message,
		                timeout:2000,
		                showType:'slide'
		         });
				console.log(json.obj);
				//ad.dialog('close');
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
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeWork.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//保存个人信息ajax提交
function saveOrUpadateResumeProject(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeProject.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//保存求职意向ajax提交
function saveOrUpdateResumeLan(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeLan.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//保存工作经验ajax提交
function saveOrUpdateResumeEdu(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeEdu.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//保存教育经历ajax提交
function saveOrUpdateResumeJobInten(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeJobInten.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}

//保存语言水平ajax提交
function saveOrUpdateResumeOtherInfo(){
	$('#form_resume_create').form('submit', {
		url : '${pageContext.request.contextPath}/resumeAction!saveOrUpdateResumeOtherInfo.action',
		success : function(d) {
			var json = $.parseJSON(d);
			if (json.success) {
				datagrid.datagrid('load');
				//ad.dialog('close');
			}
			$.messager.show({
				msg : json.msg,
				title : '提示'
			});
		}
	});
}



var workToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeWork.action',
			data : {
				ids : ids.join(',')
			},
			dataType : 'json',
			success : function(d) {
				dg.datagrid('load');
				dg.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
    
    }
}];
var projectToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeProject.action',
			data : {
				ids : ids.join(',')
			},
			dataType : 'json',
			success : function(d) {
				dg.datagrid('load');
				dg.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
    
    }
}];
var eduToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeEdu.action',
			data : {
				ids : ids.join(',')
			},
			dataType : 'json',
			success : function(d) {
				dg.datagrid('load');
				dg.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
    
    }
}];
var lanToolbar = [{
    text:'删除',
    iconCls:'icon-remove',
    handler:function(){
    	$.ajax({
			url : '${pageContext.request.contextPath}/resumeAction!deleteResumeLan.action',
			data : {
				ids : ids.join(',')
			},
			dataType : 'json',
			success : function(d) {
				dg.datagrid('load');
				dg.datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : d.msg
				});
			}
		});
    	
    }
}];

//删除简历相关的其他信息
function deleteOtherInfo(){
	$.ajax({
		url : '${pageContext.request.contextPath}/resumeAction!deleteResumeOtherInfo.action',
		data : {
			ids : ids.join(',')
		},
		dataType : 'json',
		success : function(d) {
			dg.datagrid('load');
			dg.datagrid('unselectAll');
			$.messager.show({
				title : '提示',
				msg : d.msg
			});
		}
	});
}

//删除简历相关的求职意向信息
function deleteJobInten(){
	$.ajax({
		url : '${pageContext.request.contextPath}/resumeAction!deleteResumeJobInten.action',
		data : {
			ids : ids.join(',')
		},
		dataType : 'json',
		success : function(d) {
			dg.datagrid('load');
			dg.datagrid('unselectAll');
			$.messager.show({
				title : '提示',
				msg : d.msg
			});
		}
	});
}



</script>

<!-- Start Content -->

<div id="resumeInfoTab" class="easyui-tabs" style="width:100%;height:480px;">
		<div title="个人信息" data-options="iconCls:'icon-help'" style="padding:10px">
			 <div align="center" style="padding:20px;">
                <form id="form_resume_create" method="post">
					<table>
					<tr><td><input name="resume.id" hidden="true" /></td></tr>
					<tr>
						<th>简历编号</th>
						<td><input readonly="readonly" name="resume.code" class="easyui-textbox" style="width:160px;height:24px;"/></td>
						<th>登录名称<span style="color:red">*</span></th>
						<td><input name="resume.loginname" class="easyui-textbox" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>登录密码<span style="color:red">*</span></th>
						<td><input name="resume.loginpwd" class="easyui-textbox" type="password" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>电子邮箱</th>
						<td><input class="easyui-textbox" name="resume.email" style="width:160px;height:24px;" data-options=""/></td>
					</tr>
					<tr>
						<th>姓名<span style="color:red">*</span></th>
						<td><input name="resume.realname" class="easyui-textbox" style="width:160px;height:24px;" data-options="required:true" /></td>
						<th>性别<span style="color:red">*</span></th>
						<td><select class="easyui-combobox" name="resume.gender" style="width:160px;height:24px;">
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
						<td><select class="easyui-combobox" name="resume.marrige" style="width:160px;height:24px;">
						        <option value="0">未婚</option>
						        <option value="1">已婚</option>
						        <option value="2">保密</option>
						    </select></td>
						<th>政治面貌</th>
						<td><select class="easyui-combobox" name="resume.politicalStatus" style="width:160px;height:24px;">
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
						<td><select class="easyui-combobox" name="resume.highestDegree" style="width:160px;height:24px;">
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
						<td><input class="easyui-textbox"  name="resume.homeTel" style="width:160px;height:24px;" data-options=""/></td>
						<th>证件类型</th>
						<td><select class="easyui-combobox" name="resume.cardType" style="width:160px;height:24px;">
						        <option value="0">身份证</option>
						        <option value="1">学生证</option>
						        <option value="2">工作证</option>
						        <option value="3">士兵证</option>
						        <option value="4">军官证</option>
						        <option value="5">护照</option>
						        <option value="6">户口本</option>
						        <option value="7">其他</option>
						    </select></td>
						<th>证件号码</th>
						<td><input class="easyui-textbox" name="resume.idNumber" style="width:160px;height:24px;"/></td>
					</tr>
					<tr>
						<th>QQ号码</th>
					    <td><input class="easyui-textbox" name="resume.QQID" style="width:160px;height:24px;"  /></td>
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
						<td><input class="easyui-datetimebox" name="resume.cdate" style="width:160px;height:24px;" /></td>
						<th></th>
						<td></td>
					</tr>
					<tr>
					 <td align="center" style="width:100px;height:30px;" colspan=4>
					 	<a href="#" class="easyui-linkbutton" onclick="createResume();" data-options="iconCls:'icon-save'">创建</a>
					 </td>
					 <td align="center" style="width:100px;height:30px;" colspan=4>
					 	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		<div title="求职意向" data-options="iconCls:'icon-help'" style="padding:10px">
			<div align="center" style="padding:20px;">
                	<form id="form_resume_jobintension" method="post">
					<table>
					<tr>
					<td><input hidden="true" name="resumeJobInten.jobIntenId"></input></td>
					<td><input hidden="true" name="resumeJobInten.resumeId"></input></td>
					</tr>
					<tr>
						<th>工作类型</th>
						<td><select class="easyui-combobox" name="resumeJobInten.jobTerm" style="width:160px;height:24px;">
						        <option value="0">全职</option>
						        <option value="1">兼职</option>
						        <option value="2">实习</option>
						        <option value="3">其他</option>
						    </select></td>
						<th>工作地点<span style="color:red">*</span></th>
						<td><input name="resumeJobInten.jobArea" class="easyui-textbox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
						<th>工作行业<span style="color:red">*</span></th>
						<td><input name="resumeJobInten.industryType" class="easyui-textbox"  style="width:160px;height:24px;"
							 data-options="required:true" /></td>
						<th>工作职位<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeJobInten.funType" style="width:160px;height:24px;" data-options=""/></td>
					</tr>
					<tr>
						<th>期望薪水</th>
						<td><input class="easyui-textbox" name="resumeJobInten.salary" style="width:160px;height:24px;" /></td>
						<th>到岗时间</th>
						<td><input class="easyui-datetimebox" name="resumeJobInten.entryDate" style="width:160px;height:24px;" /></td>
						
					</tr>
					<tr>
					<th>自我评价</th>
					<td colspan=8><input class="easyui-textbox" name="resumeJobInten.introduction" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
					  <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
					 </td>
					 <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		<div title="工作经历" data-options="iconCls:'icon-help'">
			<div align="center">
			      <!-- 已经添加的工作经验 -->
					<table class="easyui-datagrid" id="workList" style="width:99%;height:200px"
			            data-options="fitColumns:true,rownumbers:true,singleSelect:true,url:'datagrid_data2.json',method:'get',toolbar:workToolbar">
			        <thead>
			            <tr>
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
			
                	<form id="form_resume_work" method="post">
					<table>
					<tr>
					<td><input hidden="true" name="resumeWork.workId"></input></td>
					<td><input hidden="true" name="resumeWork.resumeId"></input></td>
					</tr>
					<tr>
						<th>开始日期</th>
						<td><input name="resumeWork.workFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
							data-options="required:true" /></td>
						<th>结束日期<span style="color:red">*</span></th>
						<td><input name="resumeWork.workToDate" class="easyui-datebox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
						<th>行业<span style="color:red">*</span></th>
						<td><input name="resumeWork.industry" class="easyui-textbox"  style="width:160px;height:24px;"
							 data-options="required:true" /></td>
						<th>公司<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeWork.company" style="width:160px;height:24px;" data-options=""></input></td>
		
					</tr>
					<tr>
						<th>公司性质</th>
						<td><input class="easyui-textbox" name="resumeWork.companyType" style="width:160px;height:24px;" /></td>
						<th>公司规模</th>
						<td><input class="easyui-textbox" name="resumeWork.companySize" style="width:160px;height:24px;" /></td>
						<th>所在部门</th>
						<td><input class="easyui-textbox" name="resumeWork.division" style="width:160px;height:24px;" /></td>
						<th>职位</th>
						<td><input class="easyui-textbox" name="resumeWork.position" style="width:160px;height:24px;" /></td>
					</tr>
					<tr>
						<th>离职原因</th>
						<td colspan=8><input class="easyui-textbox" name="resumeWork.leaveReason" style="width:100%;height:24px;" /></td>
					</tr>
					<tr>
						<th>工作描述</th>
						<td colspan=8><input class="easyui-textbox" name="resumeWork.responsiblity" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
						<th>主要成绩</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeWork.achievement" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					
					</tr>
					<tr>
					  <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
					 </td>
					 <th></th>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		<div title="项目经验" data-options="iconCls:'icon-help'" >
			<div align="center">
			  <table class="easyui-datagrid"  id="projectList"  style="width:99%;height:200px"
		            data-options="fitColumns:true,rownumbers:true,singleSelect:true,url:'datagrid_data3.json',method:'get',toolbar:projectToolbar">
		        <thead>
		            <tr>
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
				
                 <form id="form_resume_project" method="post">
					<table>
					<tr>
					<td><input hidden="true" name="resumeProject.projectId"></input></td>
					<td><input hidden="true" name="resumeProject.resumeId"></input></td>
					</tr>
					 <tr>
						<th>项目名称</th>
						<td><input class="easyui-textbox" name="resumeProject。projectTitle" style="width:160px;height:24px;"></td>
						<th>开始日期</th>
						<td><input name="resumeProject。projectFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
							data-options="required:true" /></td>
						<th>结束日期<span style="color:red">*</span></th>
						<td><input name="resumeProject。projectToDate" class="easyui-datebox" style="width:160px;height:24px;"
							data-options="required:true" /></td>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<th>项目经理<span style="color:red">*</span></th>
						<td><input name="resumeProject。projectManager" class="easyui-textbox"  style="width:160px;height:24px;"
							 data-options="required:true" /></td>
						<th>其他成员<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeProject。otherMembers" style="width:160px;height:24px;" data-options=""></input></td>
					</tr>
					<tr>
						<th>项目描述</th>
						<td colspan=8><input class="easyui-textbox" name="resumeProject.projectDetail" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
						<th>我的职责</th>
						<td colspan=8> <input class="easyui-textbox" name="resumeProject.myAchievement" data-options="multiline:true" style="width:100%;height:60px;" /></td>
					</tr>
					<tr>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
					 </td>
					 <td colspan=4 align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
		</div>
		
			
		
		<div title="教育经历" data-options="iconCls:'icon-help'" >
					<div align="center" >
					     <table class="easyui-datagrid"  id="eduList"  style="width:99%;height:200px"
				            data-options="fitColumns:true,rownumbers:true,singleSelect:true,url:'datagrid_data4.json',method:'get',toolbar:eduToolbar">
				        <thead>
				            <tr>
				                <th data-options="field:'eduFromDate',width:80,align:'center'">开始日期</th>
				                <th data-options="field:'eduToDate',width:80,align:'center'">结束日期</th>
				                <th data-options="field:'degree',width:80,align:'center'">学历</th>
				                <th data-options="field:'schoolName',width:80,align:'center'">学校</th>
				                <th data-options="field:'subMajor',width:80,align:'center'">专业</th>
				                <th data-options="field:'edu_detail',width:80,align:'center'">详细描述</th>
				            </tr>
					     </thead>
					    </table>
		                	<form id="form_resume_edu" method="post">
							<table>
							<tr>
							<td><input hidden="true" name="resumeEdu.eduId"></input></td>
							<td><input hidden="true" name="resumeEdu.resumeId"></input></td>
							</tr>
							<tr>
								<th>开始日期</th>
								<td><input name="resumeEdu。eduFromDate"  class="easyui-datebox" style="width:160px;height:24px;" 
									data-options="required:true" /></td>
								<th>结束日期<span style="color:red">*</span></th>
								<td><input name="resumeEdu。eduToDate" class="easyui-datebox" style="width:160px;height:24px;"
									data-options="required:true" /></td>
								<th>学历</th>
								<td><select class="easyui-combobox" name="resumeEdu。degree" style="width:160px;height:24px;">
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
								<th>专业<span style="color:red">*</span></th>
								<td><input class="easyui-textbox" name="resumeEdu。subMajor" style="width:160px;height:24px;" data-options="" /></td>
							</tr>
							<tr>
								<th>详细描述</th>
								<td colspan=8><input class="easyui-textbox" name="resumeEdu。edu_detail" data-options="multiline:true" style="width:100%;height:60px;" /></td>
							
							</tr>
							<tr>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
							 </td>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
							 </td>
							 </tr>
						</table>
					</form>		
					</div>
		</div>
		<div title="语言水平" data-options="iconCls:'icon-help'" >
			
					<div align="center" >
					
						<table class="easyui-datagrid"  id="lanList"  style="width:99%;height:200px"
				            data-options="fitColumns:true,rownumbers:true,singleSelect:true,url:'datagrid_data5.json',method:'get',toolbar:lanToolbar">
				        <thead>
				            <tr>
				                <th data-options="field:'languageCategory',width:80,align:'center'">语言类别</th>
				                <th data-options="field:'languageLevel',width:80,align:'center'">语言等级</th>
				                <th data-options="field:'master',width:80,align:'center'">掌握程度</th>
				                <th data-options="field:'rwAbility',width:80,align:'center'">读写能力</th>
				                <th data-options="field:'lsAbility',width:80,align:'center'">听说能力</th>
				                <th data-options="field:'supplement',width:80,align:'center'">语言补充</th>
				            </tr>
					     </thead>
					    </table>
		                	<form id="form_resume_language" method="post">
							<table>
							<tr>
							<td><input hidden="true" name="resumeLan.lanId" /></td>
							<td><input hidden="true" name="resumeLan.resumeId" /></td>
							</tr>
							<tr>
								<th>语言类别</th>
								<td><select class="easyui-combobox" name="resumeLan。languageCategory" style="width:160px;height:24px">
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
									 data-options="required:true" /></td>
								<th>掌握程度</th>
								<td><select class="easyui-combobox" name="resumeLan。master" style="width:160px;height:24px;">
						         <option value="0">优秀</option>
						         <option value="1">良好</option>
						         <option value="3">一般</option>
							    </select></td>
							</tr>
								<tr>
								<th>读写能力</th>
								<td><select class="easyui-combobox" name="resumeLan。rwAbility" style="width:160px;height:24px;">
						        <option value="0">优秀</option>
						        <option value="1">良好</option>
						        <option value="3">一般</option>
							    </select></td>
								<th>听说能力</th>
								<td><select class="easyui-combobox" name="resumeLan。lsAbility" style="width:160px;height:24px;">
						         <option value="0">优秀</option>
						        <option value="1">良好</option>
						        <option value="3">一般</option>
							    </select></td>
							    <th>备注</th>
								<td><input name="resumeLan。supplement" class="easyui-textbox"  style="width:160px;height:24px;" /></td>
							</tr>
							<tr>
							 <td colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
							 </td>
							 <td  colspan=4 align="center" style="width:100px;height:30px;">
							 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
							 </td>
							 </tr>
						</table>
					</form>		
					</div>
		</div>
		<div title="其他信息" data-options="iconCls:'icon-help'" style="padding:10px">
				<div align="center" style="padding:20px;">
	                <form id="form_resume_otherinfo" method="post">
					<table>
					<tr>
						<td><input hidden="true" name="resumeOtherInfo.otherId"></input></td>
						<td><input hidden="true" name="resumeOtherInfo.resumeId"></input></td>
					</tr>
					<tr>
						<th>个人爱好<span style="color:red">*</span></th>
						<td><input name="resumeOtherInfo。personalHobby" class="easyui-textbox"  style="width:200px;height:24px;"
							 data-options="required:true" /></td>
						<th>个人特长<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" name="resumeOtherInfo。specialSkill" style="width:200px;height:24px;" data-options=""></input></td>
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
						 	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
						 </td>
						 <td colspan=4 align="center" style="width:100px;height:30px;">
						 	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
						 </td>
						 </tr>
					</table>
				</form>		
				</div>
		</div>
	</div>
<!-- End  Content -->  		
 		

    		
