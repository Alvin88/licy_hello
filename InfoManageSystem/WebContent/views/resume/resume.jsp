<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="jslib/ystep/css/ystep.css">
<link rel="stylesheet" href="jslib/smartWizard/smart_wizard.css">
<script type="text/javascript" src="jslib/smartWizard/jquery.smartWizard.js"></script>
<script type="text/javascript" src="jslib/ystep/js/ystep.js"></script>
<script type="text/javascript">
	var dg = $('#resume_jlgl_datagrid');
	$(function() {
		dg.datagrid({
					title : '简历数据',
					border : false,
					fitColum : true,
					fit : true,
					nowarp : true,
					sortName : 'name',
					sortOrder : 'desc',
					pageSize : 10,
					checkOnSelect : false,
					selectOnCheck : false,
					pageList : [ 10, 20, 30, 40 ],
					iconCls : 'icon-save',
					url : '${pageContext.request.contextPath}/resumeAction!datagrid.action',
					idField : 'id',
					pagePosition : 'bottom',
					pagination : true,
					loadMsg : '正在加载数据当中....',
					fitColumns:true,
					frozenColumns : [ [ {
						field : 'id',
						title : '编号',
						width : 100,
						checkbox : true
					}, {
						field : 'realname',
						title : '姓名',
						width : 100,
						sortable : true
					} ] ],
					columns : [ [ {
						field : 'gender',
						title : '性别',
						width : 100,
						formatter : function(value, rowData, rowIndex) {
							if(value===0){
								return '男';
							}else{
								return '女';
							}
						}
					}, {
						field : 'birthday',
						title : '出生日期',
						formatter : function(value, rowData, rowIndex) {
							return value;
						},
						width : 100
					}, {
						field : 'workYear',
						title : '工作经验',
						width : 100,
						formatter : function(value, rowData, rowIndex) {
							if(value!=null&&value!=""){
								return value+"年";
							}
							return value;
						},
					},
					{
						title : '学历',
						field : 'highestDegree',
						width : 150,
						formatter : function(value, rowData, rowIndex) {
							switch(value){
								case 0:return '博士';
								case 1:return '硕士';
								case 2:return '本科';
								case 3:return '大专';
								case 4:return '高中';
								case 5:return '初中';
								case 6:return '小学';
								case 7:return '其他';
								default:return '未知';
							}
						}
					}, {
						title : '专业',
						field : 'subMajor',
						width : 150
					},{
						title : '现在地区',
						field : 'location',
						width : 150,
					}] ],
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							addResume();
						}
					}, '-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							editResume();
						}
					}, '-', {
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							remove();
						}
					}, '-', {
						text : '取消选中',
						iconCls : 'icon-redo',
						handler : function() {
							dg.datagrid('rejectChanges');
							dg.datagrid('unselectAll');
						}
					} ]
				});
	});
	function _search() {
		var searchForm = $('#resume_jlgl_searchForm').form();
		dg.datagrid('load', serializeObject(searchForm));
	}
	function cleanSearch() {
		dg.datagrid('load', {});
		$('#resume_jlgl_searchForm input').val('');
	}

	function addResume() {		
		$('#resume_jlgl_addDialog').window({
		    width:1000,
		    height:500,
		    title : '新增简历',
			href : '${pageContext.request.contextPath}/views/resume/resumeAdd.jsp',
		    inline:true,
		    modal:true,
			onClose : function() {
				//关闭这里不能销毁
			},
			onLoad : function() {
				//先设置resume表单的值为空
				$('#form_resume_create input').val('');
			}
		});
	}
	function remove() {
		var rows = dg.datagrid('getChecked');
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
												url : '${pageContext.request.contextPath}/resumeAction!deleteResume.action',
												data : {
													resumeIds : ids.join(',')
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
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
	}
	function editResume() {
		var rows = dg.datagrid('getChecked');
		if (rows.length == 1) {
			$('#resume_jlgl_editDialog').window({
			    width:1000,
			    height:500,
			    title : '编辑简历',
				href : '${pageContext.request.contextPath}/views/resume/resumeEdit.jsp?editResumeId='+rows[0].id,
			    inline:true,
			    modal:true,
				onClose : function() {
					//关闭这里不能销毁
				},
				onLoad : function() {
					var resumeId = rows[0].id;//就是有值表示是修改，否则表示新增
					//设置五个form表单的值
					//首先设置form_resume_create表单
					
					$('#edit_form_resume_create').form('clear');
	                $('#edit_form_resume_create').form('load',{
	                	"resume.id":rows[0].id,
	                	"resume.code":rows[0].code,
	                	"resume.loginname":rows[0].loginname,
	                	"resume.loginpwd":'',//密码需要置为空，只要填写了就是新密码
	                	"resume.email":rows[0].email,
	                	"resume.realname":rows[0].realname,
	                	"resume.gender":rows[0].gender,
	                	"resume.birthday":rows[0].birthday,
	                	"resume.stature":rows[0].stature,
	                	"resume.jiguan":rows[0].jiguan,
	                	"resume.marrige":rows[0].marrige,
	                	"resume.politicalStatus":rows[0].politicalStatus,
	                	"resume.highestDegree":rows[0].highestDegree,
	                	"resume.mobile":rows[0].mobile,
	                	"resume.homeTel":rows[0].homeTel,
	                	"resume.cardType":rows[0].cardType,
	                	"resume.idNumber":rows[0].idNumber,
	                	"resume.qqId":rows[0].qqId,
	                	"resume.location":rows[0].location,
	                	"resume.address":rows[0].address,
	                	"resume.photo":rows[0].photo,
	                	"resume.zipCode":rows[0].zipCode,
	                	"resume.workYear":rows[0].workYear,
	                	"resume.currSituation":rows[0].currSituation,
	                	"resume.homePage":rows[0].homePage,
	                	"resume.resumeKey":rows[0].resumeKey,
	                	"resume.cdate":rows[0].cdate
	                });
	                
					//简历求职意向表单form_resume_jobintension
					$('#edit_form_resume_jobintension').form('clear');
					console.dir(rows[0]);
	                $('#edit_form_resume_jobintension').form('load',{
	                	"resumeJobInten.jobIntenId":rows[0].jobInten.jobIntenId,
	                	"resumeJobInten.resumeId":rows[0].jobInten.resumeId,
	                	"resumeJobInten.jobTerm":rows[0].jobInten.jobTerm,
	                	"resumeJobInten.jobArea":rows[0].jobInten.jobArea,
	                	"resumeJobInten.industryType":rows[0].jobInten.industryType,
	                	"resumeJobInten.funType":rows[0].jobInten.funType,
	                	"resumeJobInten.salary":rows[0].jobInten.salary,
	                	"resumeJobInten.entryDate":rows[0].jobInten.entryDate,
	                	"resumeJobInten.introduction":rows[0].jobInten.introduction
	                });
	                
	               //简历其他信息表单form_resume_otherinfo
	               $('#edit_form_resume_otherinfo').form('clear');
	                $('#edit_form_resume_otherinfo').form('load',{
	                	"resumeOtherInfo.otherId":rows[0].otherInfo.otherId,
	                	"resumeOtherInfo.resumeId":rows[0].otherInfo.resumeId,
	                	"resumeOtherInfo.personalHobby":rows[0].otherInfo.personalHobby,
	                	"resumeOtherInfo.specialSkill":rows[0].otherInfo.specialSkill,
	                	"resumeOtherInfo.personHonor":rows[0].otherInfo.personHonor,
	                	"resumeOtherInfo.partiGroup":rows[0].otherInfo.partiGroup,
	                	"resumeOtherInfo.evaluation":rows[0].otherInfo.evaluation,
	                	"resumeOtherInfo.otherSkill":rows[0].otherInfo.otherSkill
	                });
	                
	               
	               	 //简历工作经历列表赋值
	               	 var workQueryParams = $('#editworklist').datagrid('options').queryParams;  
	               	 workQueryParams.resumeId = resumeId;  
         			 $('#editworklist').datagrid('options').queryParams=workQueryParams;      
         			 $('#editworklist').datagrid('options').url='${pageContext.request.contextPath}/resumeAction!workdatagrid.action';
         			 $("#editworklist").datagrid('reload'); 
	               
	               	
	               	//简历项目经验列表取值
	                 var projectQueryParams = $('#editprojectlist').datagrid('options').queryParams;  
	                 projectQueryParams.resumeId = resumeId;  
         			 $('#editprojectlist').datagrid('options').queryParams=projectQueryParams;      
         			 $('#editprojectlist').datagrid('options').url='${pageContext.request.contextPath}/resumeAction!projectdatagrid.action';
         			 $("#editprojectlist").datagrid('reload'); 
	               	
	               	//简历教育经历列表取值
	                var eduQueryParams = $('#editedulist').datagrid('options').queryParams;  
	                eduQueryParams.resumeId = resumeId;  
         			 $('#editedulist').datagrid('options').queryParams=eduQueryParams;      
         			 $('#editedulist').datagrid('options').url='${pageContext.request.contextPath}/resumeAction!edudatagrid.action';
         			 $("#editedulist").datagrid('reload'); 
         			 
	               	//简历语言水平列表取值
         			var lanQueryParams = $('#editlanlist').datagrid('options').queryParams;  
         			lanQueryParams.resumeId = resumeId;  
        			 $('#editlanlist').datagrid('options').queryParams=lanQueryParams;      
        			 $('#editlanlist').datagrid('options').url='${pageContext.request.contextPath}/resumeAction!landatagrid.action';
        			 $("#editlanlist").datagrid('reload'); 
        			 console.dir("%%%%%%%%%%%%%%%%%%%%%%%%%%");
				}
			});
		} else {
			$.messager.alert('提示', '请勾选一条要修改的数据');
		}
	}
	
</script>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north',border:false,title:'过滤条件'"
		style="height: 110px;overflow:auto;" align="left">
		<div id="resume_jlgl_toolbar">
			<form id="resume_jlgl_searchForm">
				<table class="tableForm datagrid-toolbar"
					style="width:100%;height: 100%;">
					<tr>
						<th>姓名</th>
						<td>
						 <input class="easyui-textbox" style="width:120px;">
						</td>
						<th>电子邮箱</th>
						<td>
						  <input class="easyui-textbox" data-options="validType:'email'" style="width:120px;">
						</td>
						
						<th>性别要求</th>
						<td>
						<select class="easyui-combobox" name="state" style="width:120px;">
        					<option value="AL">不限</option>
       						<option value="AK">男</option>
        					<option value="AZ">女</option>
        				</select>
						</td>
						<th>年龄要求</th>
						<td><input class="easyui-numberbox" value="18" style="width:120px;"></input>至
						<input class="easyui-numberbox" value="60" style="width:120px;"></input>岁
						</td>
						
						
					</tr>
					<tr>
						<th>希望工作地</th>
						<td>
						<input class="easyui-combotree" style="width:120px;" data-options="url:'json/area.json',method:'get'" >
						</td>
						<th>目前所在地</th>
						<td>
						<input class="easyui-combotree"  style="width:120px;" data-options="url:'json/area.json',method:'get'" >
						</td>
						<th>户口所在地</th>
						<td>
						<input class="easyui-combotree" style="width:120px;" data-options="url:'json/area.json',method:'get'" >
						</td>
						<th>毕业院校</th>
						<td>
						<input class="easyui-textbox" style="width:120px;">
						</td>
					</tr>
					<tr>
						<th>学历要求</th>
						<td>
						<select class="easyui-combobox" name="state" style="width:120px;" >
        					<option value="AL">不限</option>
       						<option value="AK">博士</option>
        					<option value="AZ">硕士</option>
        					<option value="AR">本科</option>
        					<option value="AR">大专</option>
        					<option value="AR">中专</option>
        					<option value="AR">中技</option>
        					<option value="AR">高中</option>
        					<option value="AR">初中</option>
        				</select>
						</td>
						<th>关键字</th>
						<td>
						 <input class="easyui-textbox" data-options="prompt:'多关键字用空格隔开'" style="width:120px;">
						</td>
						<th></th>
						<td>
					<a href="javascript:void(0);"
							class="easyui-linkbutton" onclick="_search();">过滤</a> <a
							href="javascript:void(0);" class="easyui-linkbutton"
							onclick="cleanSearch();">取消</a>
						</td>
						
					</tr>
					
				</table>
			</form>
		</div>
	</div>
	<div data-options="region:'center',border:false"
		style="overflow: hidden;">
		<table id="resume_jlgl_datagrid"></table>
	</div>
</div>
<div id="resume_jlgl_addDialog"  style="width:90%;height:90%;" align="center">
</div>
<div id="resume_jlgl_editDialog" style="width:90%;height:90%;" align="center">
</div>
