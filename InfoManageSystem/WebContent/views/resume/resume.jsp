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
						field : 'name',
						title : '姓名',
						width : 100,
						sortable : true
					} ] ],
					columns : [ [ {
						field : 'gender',
						title : '性别',
						width : 100,
						formatter : function(value, rowData, rowIndex) {
							return '******';
						}
					}, {
						field : 'age',
						title : '年龄',
						width : 100
					}, {
						field : 'workYear',
						title : '工作经验',
						width : 100
					},
					{
						title : '学历',
						field : 'degree',
						width : 150
						//hidden : true
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
		$('#wizard').smartWizard();
	});
	function _search() {
		var searchForm = $('#resume_jlgl_searchForm').form();
		dg.datagrid('load', serializeObject(searchForm));
	}
	function cleanSearch() {
		dg.datagrid('load', {});
		$('#resume_jlgl_searchForm input').val('');
	}
	function moreSearchCondition(){
		$('#resume_jlgl_searchForm input').hide();
	}
	function addResume() {
		//$('#resume_jlgl_addForm').form('clear');
		//$('#resume_jlgl_addDialog').dialog('open');
		
		$('#resume_jlgl_addDialog').window('refresh', '${pageContext.request.contextPath}/views/resume/resumeAdd.jsp');
		$('#resume_jlgl_addDialog').window('open');
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
												url : '${pageContext.request.contextPath}/userAction!delete.action',
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
							});
		} else {
			$.messager.alert('提示', '请勾选要删除的数据！');
		}
	}
	function editResume() {
		var rows = dg.datagrid('getChecked');
		if (rows.length == 1) {
			//$('#resume_jlgl_editDialog').window('open');
			$('#resume_jlgl_editDialog').window({
			    width:600,
			    height:300,
			    title : '编辑简历',
				href : '${pageContext.request.contextPath}/views/resume/resumeEdit.jsp',
			    inline:true,
			    modal:true,
			    buttons : [ {
					text : '编辑',
					handler : function() {
						$('#admin_yhglEdit_Form').form('submit',{
							 url:'${pageContext.request.contextPath}/userAction!edit.action',
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
				
	                $('#resume_resumeEdit_Form').form('load',{
	                	id:rows[0].id,
	                	name:'lichunyi',
	                	roleIds:'1,2,3,4',
	                	createdatetime:rows[0].createdatetime,
	                	modifydatetime:rows[0].modifydatetime
	                });
				}
			});
		} else {
			$.messager.alert('提示', '请勾选一条要编辑的数据');
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
<div id="resume_jlgl_addDialog" class="easyui-window"
	data-options="closed:true,modal:true,inline:true,title:'新增简历'"
	style="width:90%;height:95%;" align="center">
	
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
<div id="resume_jlgl_editDialog" style="width:90%;height:90%;" align="center">
</div>
