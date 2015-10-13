<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>


#company_gsglEdit_Form div label{
display : inline-block;
width: 80px;
}
</style>
<div align="center" style="padding: 5px; overflow: hidden;">
	<form id="company_gsglAddRecord_Form" method="post">
		<div>
			<label>编号</label> <input name="id" readonly="readonly" />

		</div>
		
		<div>
			<label for="traceState">跟进记录:</label>
			<textarea class="easyui-validatebox" name='text'
				data-options="required:true" />
		</div>
		
	
	</form>
</div>