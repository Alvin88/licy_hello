<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="jslib/ystep/css/ystep.css">
<link rel="stylesheet" href="jslib/smartWizard/smart_wizard.css">
<script type="text/javascript" src="jslib/smartWizard/jquery.smartWizard.js"></script>
<script type="text/javascript" src="jslib/ystep/js/ystep.js"></script>
<script type="text/javascript">
	var dg = $('#resume_jlgl_datagrid');
	$(function() {
		dg.datagrid({
					title : '人才数据',
					border : false,
					fitColum : true,
					fit : true,
					nowarp : true,
					sortName : 'name',
					sortOrder : 'desc',
					pageSize : 10,
					checkOnSelect : true,
					selectOnCheck : true,
					pageList : [ 10, 20, 30, 40 ],
					iconCls : 'icon-save',
					url : '${pageContext.request.contextPath}/talentAction!datagrid.action',
					idField : 'id',
					pagePosition : 'bottom',
					pagination : true,
					loadMsg : '正在加载数据当中....',
					fitColumns:true,
					frozenColumns : [ [ {
						field : 'id',
						title : '人才编号',
						width : 100,
						checkbox : true
					}, {
						field : 'name',
						title : '姓名',
						width : 150,
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
						title:'证书类型',
						field:'certificateType',
						width:200
					}, {
						title : '专业',
						field : 'profession',
						width : 200
					},{
						title : '跟进记录',
						field : 'traceRecord',
						width : 200,
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
					},'-',{
						text:'跟进人才',
						iconCls:'icon-add',
						handler:function(){
							addRecord();
						}
					}, '-', {
						text : '取消选中',
						iconCls : 'icon-redo',
						handler : function() {
							dg.datagrid('rejectChanges');
							dg.datagrid('unselectAll');
						}
					}],
					onDblClickRow:function(index,row){
						 console.log("db click ");
					}
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
	//添加跟进记录
	function addRecord(){
		var rows = dg.datagrid('getChecked');
		if (rows.length ==1) {
			var d=$('<div/>').dialog({
				title : '跟进记录',
				href : '${pageContext.request.contextPath}/views/resume/recordAdd.jsp',
				width : 600,
				height : 200,
				modal : true,
				buttons : [ {
					text : '跟进',
					handler : function() {
						$('#resume_record_addForm').form('submit',{
							 url:'${pageContext.request.contextPath}/talentAction!addRecord.action',
						            success:function(r){
						            	obj=$.parseJSON(r);
						                 if(obj.success){
						                 d.dialog('close');
						                 dg.datagrid('load');
										 dg.datagrid('unselectAll');
						            	 $.messager.show({
						            		 title:'提示',
						            		 msg:obj.msg
						            	 });
						                 }else{
						                	 $.messager.alert('提示', obj.msg);
						                 }
								    }
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				},
				onLoad : function() {
					$('#record_talent_id').val(rows[0].id);
				}
			});
			
		}else{
			$.messager.alert('提示', '请勾选一条要跟进的人才数据');
		}
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
												url : '${pageContext.request.contextPath}/talentAction!deleteTalent.action',
												data : {
													talentIds : ids.join(',')
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
	                	"talent.id":rows[0].id,
	                	"talent.code":rows[0].code,
	                	"talent.name":rows[0].name,
	                	"talent.email":rows[0].email,
	                	"talent.gender":rows[0].gender,
	                	"talent.mobile":rows[0].mobile,
	                	"talent.sbArea":rows[0].sbArea,
	                	"talent.qq":rows[0].qq,
	                	"talent.certificateType":rows[0].certificateType,
	                	"talent.profession":rows[0].profession,
	                	"talent.registerResult":rows[0].registerResult,
	                	"talent.traceRecord":rows[0].traceRecord,
	                	"talent.expireDate":rows[0].expireDate,
	                	"talent.remark":rows[0].remark
	                });
	              
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
						<th>证书类型</th>
						<td>
						 <input class="easyui-textbox" name="talent.certificateType" style="width:160px;">
						</td>
						<th>证书专业</th>
						<td>
						  <input class="easyui-textbox" name="talent.profession" style="width:160px;">
						</td>
						<th>所在地区</th>
						<td>
						<input class="easyui-combotree"  name="talent.sbArea" style="width:160px;" data-options="url:'json/area.json',method:'get'" >
						</td>
					
						<td>
					   <a href="javascript:void(0);"
							class="easyui-linkbutton" onclick="_search();">过滤</a> <a
							href="javascript:void(0);" class="easyui-linkbutton"
							onclick="cleanSearch();">取消</a>
						</td>
					</tr>
					<tr>
					
						
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
<div id="resume_jlgl_addDialog"  style="width:500px;height:400px;" align="center">
</div>
<div id="resume_jlgl_editDialog" style="width:500px;height:400px;" align="center">
</div>
<div id="resume_jlgl_showDialog" style="width:500px;height:400px;" align="center">
</div>
