<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="jslib/ystep/css/ystep.css">
<link rel="stylesheet" href="jslib/smartWizard/smart_wizard.css">
<script type="text/javascript" src="jslib/smartWizard/jquery.smartWizard.js"></script>
<script type="text/javascript" src="jslib/ystep/js/ystep.js"></script>
<script type="text/javascript">
	var dg = $('#company_gsgl_datagrid');
	$(function() {
		dg.datagrid({
					title : '公司数据',
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
					url : '${pageContext.request.contextPath}/companyAction!datagrid.action',
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
						field : 'name',
						title : '公司名',
						width : 100,
						sortable : true
					} ] ],
					columns : [ [ {
						field : 'contactMan',
						title : '联系人',
						width : 100,
					
					}, {
						field : 'contactMobile',
						title : '联系电话',
						width : 100
					}, {
						field : 'phone',
						title : '座机 ',
						width : 100
					}, {
						field : 'mobilePhone',
						title : '手机 ',
						width : 100
					},
					{
						title : '邮箱',
						field : 'mail',
						width : 150
						//hidden : true
					}, {
						title : '公司简介',
						field : 'description',
						width : 150
					},{
						title : '要证情况',
						field : 'requireCertificate',
						width : 150,
					},{
						title : '跟踪记录',
						field : 'traceState',
						width : 150,
					}] ],
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							addcompany();
						}
					}, '-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							editcompany();
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
		$('#wizard').smartWizard();
	});
	function _search() {
		var searchForm = $('#company_gsgl_searchForm').form();
		dg.datagrid('load', serializeObject(searchForm));
	}
	function cleanSearch() {
		dg.datagrid('load', {});
		$('#company_gsgl_searchForm input').val('');
	}
	function moreSearchCondition(){
		$('#company_gsgl_searchForm input').hide();
	}
	function addcompany() {
		//$('#company_gsgl_addForm').form('clear');
		//$('#company_gsgl_addDialog').dialog('open');
		
	//	$('#company_gsgl_addDialog').window('refresh', '${pageContext.request.contextPath}/views/company/companyAdd.jsp');
//	$('#company_gsgl_addDialog').window('open');
	var d=	$('#company_gsgl_addDialog').dialog({
		    width:600,
		    height:300,
		    title : '添加',
			href : '${pageContext.request.contextPath}/views/company/companyAdd.jsp',
		   // inline:true,
		    modal:true,
		    buttons : [ {
				text : '保存',
				handler : function(){
					saveCompany(d);
				}
			} ],
			onClose : function() {
				//关闭这里不能销毁
			}
		});
		//$('#company_gsgl_addDialog').window('open');
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
												url : '${pageContext.request.contextPath}/companyAction!delete.action',
												data : {
													ids : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													dg.datagrid('reload');
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
    function saveCompany(d){
    	alert('sdf')
    	$('#company_gsglAdd_form').form('submit',{
			 url:'${pageContext.request.contextPath}/companyAction!add.action',
	            success:function(r){
	            	obj=$.parseJSON(r);
	                 if(obj.success){
	                 d.dialog('close');
	                 dg.datagrid('reload'); 
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
	function editcompany() {
		var rows = dg.datagrid('getChecked');
		if (rows.length == 1) {
			//$('#company_gsgl_editDialog').window('open');
		var d=	$('#company_gsgl_editDialog').dialog({
			    width:600,
			    height:300,
			    title : '编辑简历',
				href : '${pageContext.request.contextPath}/views/company/companyEdit.jsp',
			    inline:true,
			    modal:true,
			    buttons : [ {
					text : '编辑',
					handler : function() {
						$('#company_gsglEdit_Form').form('submit',{
							 url:'${pageContext.request.contextPath}/companyAction!edit.action',
						            success:function(r){
						            	obj=$.parseJSON(r);
						                 if(obj.success){
						                 d.dialog('close');
						                 dg.datagrid('updateRow',{
						                	index:dg.datagrid('getRowIndex',rows[0].id),
						                	row:obj.obj
						                }); 
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
					//关闭这里不能销毁
				},
				onLoad : function() {
				console.log(rows[0])
	                $('#company_gsglEdit_Form').form('load',rows[0]);
				}
			});
		} else {
			$.messager.alert('提示', '请勾选一条要编辑的数据');
		}
	}
	
</script>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north',border:false,title:'过滤条件'"
		style="height: 60px;overflow:auto;" align="left">
		<div id="company_gsgl_toolbar">
			<form id="company_gsgl_searchForm">
				<table class="tableForm datagrid-toolbar"
					style="width:100%;height: 100%;">
					
					<tr>
							<th>公司名</th>
						<td>
						 <input class="easyui-textbox" name='params.name' style="width:120px;">
						</td>
						<th>邮箱</th>
						<td>
						<input class="easyui-textbox" name='params.mail'  style="width:120px;"  >
						</td>
						
					
					<!-- 	<th>关键字</th>
						<td>
						 <input class="easyui-textbox" data-options="prompt:'多关键字用空格隔开'" style="width:120px;">
						</td> -->
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
		<table id="company_gsgl_datagrid"></table>
	</div>
</div>
<div id="company_gsgl_addDialog" 
	
	style="width:90%;height:90%;" align="center">
	
</div>
 <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCompany()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#company_gsgl_addDialog').dialog('close')" style="width:90px">Cancel</a>
    </div>
<div id="ft" style="padding:5px;">
 <div style="width:70%;float:left;">
 		<div class="ystep"></div>
 </div>
 <div style="width:28%;float:left;">
 	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back'">上一步</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="goNext();" data-options="iconCls:'icon-back'">下一步</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">Save</a>
 </div>
</div>
<div id="company_gsgl_editDialog" style="width:90%;height:90%;" align="center">
</div>
