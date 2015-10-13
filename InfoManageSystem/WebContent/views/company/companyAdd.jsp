<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>

#company_gsglAdd_form div{
display : inline-block;
}
#company_gsglAdd_form div label{
display : inline-block;
width: 80px;
}
</style>
<form id="company_gsglAdd_form" method="post">
    <div>
        <label for="name">公司全名:</label>
        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
    </div>
    <div>
        <label for="email">联系人:</label>
        <input class="easyui-validatebox" type="text" name="contactMan" data-options="required:true" />
    </div>
        <div>
        <label for="contactMobilev">联系电话:</label>
        <input class="easyui-validatebox" type="text" name="contactMobilev" data-options="required:true" />
    </div>
    <div>
        <label for="phone">座机:</label>
        <input class="easyui-validatebox" type="text" name="phone"  />
    </div>
        <div>
        <label for="mobilePhone">手机:</label>
        <input class="easyui-validatebox" type="text" name="mobilePhone" data-options="required:true" />
    </div>
    <div>
        <label for="email">邮箱:</label>
        <input class="easyui-validatebox" type="text" name="mail"  data-options="validType:'email'"/>
    </div>
    
    <div>
        <label for="requireCertificate">要证情况:</label>
        <input class="easyui-validatebox" type="text" name="requireCertificate"  />
  </div>
    <div>
        <label for="level">客户等级:</label>
        
        <select id="cc" class="easyui-combobox" name="companyLevel" style="width:150px;">
       <option value="A">A</option>
       <option value="B">B</option>
       <option value="C">C</option>
       <option value="D">D</option>
</select>
    </div>
      <div>
        <label for="traceDateCount">公司地址:</label>
        <input class="easyui-validatebox" type="text" name="address"  />
    </div>
    
      <!--   <div>
        <label for="traceState">跟进记录:</label>
        <textarea class="easyui-validatebox"  name='traceState' data-options="required:true" />
    </div> -->
        <div>
        <label for="description">公司简介:</label>
        <textarea class="easyui-validatebox" type="text" name="description" data-options="required:true" />
    </div>
</form>	
 		

    		
