<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>


#company_gsglEdit_Form div label{
display : inline-block;
width: 80px;
}
</style>
<div align="center" style="padding: 5px; overflow: hidden;">
	<form id="company_gsglEdit_Form" method="post">
		<div>
			<label>编号</label> <input name="id" readonly="readonly" />

		</div>
		<div>
			<label for="name">公司全名:</label> <input class="easyui-validatebox"
				type="text" name="name" data-options="required:true" />
		</div>
		<div>
			<label for="email">联系人:</label> <input class="easyui-validatebox"
				type="text" name="contactMan" data-options="required:true" />
		</div>
		<div>
			<label for="contactMobilev">联系电话:</label> <input
				class="easyui-validatebox" type="text" name="contactMobilev"
				data-options="required:true" />
		</div>
		<div>
			<label for="phone">座机:</label> <input class="easyui-validatebox"
				type="text" name="phone" />
		</div>
		<div>
			<label for="mobilePhone">手机:</label> <input
				class="easyui-validatebox" type="text" name="mobilePhone"
				data-options="required:true" />
		</div>
		<div>
			<label for="email">邮箱:</label> <input class="easyui-validatebox"
				type="text" name="mail" data-options="validType:'email'" />
		</div>

		<div>
			<label for="requireCertificate">要证情况:</label> <input
				class="easyui-validatebox" type="text" name="requireCertificate" />
		</div>
		<div>
			<label for="level">客户等级:</label> <input class="easyui-validatebox"
				type="text" name="level" />
		</div>
		<div>
			<label for="traceDateCount">跟进天数:</label> <input
				class="easyui-validatebox" type="text" name="traceDateCount" />
		</div>
		<br />
		<div>
			<label for="traceState">跟进记录:</label>
			<textarea class="easyui-validatebox" name='traceState'
				data-options="required:true" />
		</div>
		<div>
			<label for="description">公司简介:</label>
			<textarea class="easyui-validatebox" type="text" name="description"
				data-options="required:true" />
		</div>
		</table>
	</form>
</div>