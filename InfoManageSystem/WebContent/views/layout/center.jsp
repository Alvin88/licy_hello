<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	function addTabs(opts) {
		var t = $('#layout_center_centerTabs');
		if(t.tabs('exists',opts.title)){
			t.tabs('select',opts.title);
		}else{
			t.tabs('add', opts);
		}
	}
</script>
<div id="layout_center_centerTabs" class="easyui-tabs" data-options="border:false,fit:true">
	
	<div title="首页">
    
    <div id="p" class="easyui-panel" title="Basic Panel" style="width:100%;height:50%;padding:10px;">
        <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
        <ul>
            <li>easyui is a collection of user-interface plugin based on jQuery.</li>
            <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
            <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
            <li>complete framework for HTML5 web page.</li>
            <li>easyui save your time and scales while developing your products.</li>
            <li>easyui is very easy but powerful.</li>
        </ul>
    </div>
    
     <div id="p" class="easyui-panel" title="Basic Panel" style="width:100%;height:50%;padding:10px;">
        <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
        <ul>
            <li>easyui is a collection of user-interface plugin based on jQuery.</li>
            <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
            <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
            <li>complete framework for HTML5 web page.</li>
            <li>easyui save your time and scales while developing your products.</li>
            <li>easyui is very easy but powerful.</li>
        </ul>
    </div>
    
	</div>
	
</div>