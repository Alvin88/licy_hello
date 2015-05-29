<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard 	
  		$('#wizard').smartWizard();
      
      function onFinishCallback(){
    	  alert('Finish Clicked');
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        alert('Finish Clicked');
      }     
		});
</script>

<!-- Smart Wizard -->
  		<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   	创建简历
                </span>
            </a></li>
           	 	<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   	个人信息<br />
                </span>
            	</a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                   	求职意向<br />
                </span>
            </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                   	工作经验<br />
                </span>                   
             </a></li>
  				<li><a href="#step-5">
                <label class="stepNumber">5</label>
                <span class="stepDesc">
                   	教育经历<br />
                </span>                   
            </a></li>
            <li><a href="#step-6">
                <label class="stepNumber">6</label>
                <span class="stepDesc">
                   	其他信息<br />
                </span>                   
            </a></li>
  			</ul>
  			<div id="step-1">	
            <h2 class="StepTitle">简历创建</h2>
               <div align="center" style="padding:20px;">
                	<form id="resume_create_form" method="post">
					<table>
					<tr>
						<th>编号</th>
						<td><input name="id" readonly="readonly" class="easyui-textbox" style="width:200px;height:24px" /></td>
						<th>登录名称<span style="color:red">*</span></th>
						<td><input name="name" class="easyui-textbox" style="width:200px;height:24px"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<th>登录密码<span style="color:red">*</span></th>
						<td><input name="pwd" class="easyui-textbox" type="password" style="width:200px;height:24px"
							 data-options="required:true" /></td>
						<th>电子邮箱<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" type="text" name="email" style="width:200px;height:24px" data-options="required:true,validType:'email'"></input></td>
						
					</tr>
					<tr>
						<th>QQ号码</th>
						<td><input class="easyui-textbox" style="width:200px;height:24px"></td>
						<th>信息备注</th>
						<td><input class="easyui-textbox" style="width:200px;height:24px"></td>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td><input class="easyui-datetimebox" style="width:200px" readonly="readonly" ></td>
						<th>修改时间</th>
						<td><input class="easyui-datetimebox" style="width:200px" readonly="readonly"></td>
						<th></th>
						<td></td>
					</tr>
					<tr>
					  <th></th>
					 <td align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">创建</a>
					 </td>
					 <th></th>
					 <td align="center" style="width:100px;height:30px;">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
					 </td>
					 </tr>
				</table>
			</form>		
			</div>
        	</div>
        	
        	
  			<div id="step-2">
            <h2 class="StepTitle">个人信息</h2>	
           			               <div align="center" style="padding:20px;">
                	<form id="resume_create_form" method="post">
					<table>
					<tr>
						<th>编号</th>
						<td><input name="id" readonly="readonly" class="easyui-textbox" style="width:200px;height:24px" /></td>
						<th>登录名称<span style="color:red">*</span></th>
						<td><input name="name" class="easyui-textbox" style="width:200px;height:24px"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<th>登录密码<span style="color:red">*</span></th>
						<td><input name="pwd" class="easyui-textbox" type="password" style="width:200px;height:24px"
							 data-options="required:true" /></td>
						<th>电子邮箱<span style="color:red">*</span></th>
						<td><input class="easyui-textbox" type="text" name="email" style="width:200px;height:24px" data-options="required:true,validType:'email'"></input></td>
						
					</tr>
					<tr>
						<th>QQ号码</th>
						<td><input class="easyui-textbox" style="width:200px;height:24px"></td>
						<th>信息备注</th>
						<td><input class="easyui-textbox" style="width:200px;height:24px"></td>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td><input class="easyui-datetimebox" style="width:200px" readonly="readonly" ></td>
						<th>修改时间</th>
						<td><input class="easyui-datetimebox" style="width:200px" readonly="readonly"></td>
						<th></th>
						<td></td>
					</tr>
					
				</table>
				</form>
				</div>	
           			
        	</div>      
        	
        	                
  			<div id="step-3">
            <h2 class="StepTitle">Step 3 Content</h2>	
           		          
       		 </div>
       		 
       		 
  			<div id="step-4">
            <h2 class="StepTitle">Step 4 Content</h2>	
            
        	</div>
        	
        	
        	<div id="step-5">
            <h2 class="StepTitle">Step 5 Content</h2>	
                  
                <table class="easyui-datagrid" title="Basic DataGrid" style="width:100%;height:250px"
            		data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
       			<thead>
	            <tr>
	                <th data-options="field:'itemid',width:80">Item ID</th>
	                <th data-options="field:'productid',width:100">Product</th>
	                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
	                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
	                <th data-options="field:'attr1',width:250">Attribute</th>
	                <th data-options="field:'status',width:60,align:'center'">Status</th>
	            </tr>
		        </thead>
		    </table>
		 
  
    
        	</div>
        	
        	<div id="step-6">
            <h2 class="StepTitle">Step 6 Content</h2>	
            
        	</div>
        	
        	
  		</div>
<!-- End SmartWizard Content -->  		
 		

    		
