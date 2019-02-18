//判断有没有登录
function islogin(){
	name = getCookie("name");
	status = getCookie("status");
	if(name !== 'undefined' && status !== 'undefined' && name !== 'null'){
		return true;
	}else{
		return false;
	}
}

//获取用户信息
function getUser(){
	name = getCookie("name");
	status = getCookie("status");
	user = {
		name:name,
		status:status
	};
	return user;
}

//写入信息
function login(name,status){
	setCookie("name",name);
	setCookie("status",status);
}

//注销
function logout(){
	delCookie("name");
	delCookie("status");
	var href = window.location.href;
	if(href.indexOf("?") != -1){
		href = href.substring(0,href.indexOf("?"));
	}
	window.location = href;
}

/**
 * Cookie的相关操作
 */

//设置cookies
function setCookie(name,value) 
{ 
    var  Days = 1;//1天
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/"; 
} 

//读取cookies 
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 

//删除cookies 
function delCookie(name) 
{
    document.cookie= name + "=0;expires=" + new Date(0).toUTCString() + ";path=/";
}