 <%--
  Copyright (c) 2015 NewDesign, All Rights Reserved.
    文件名:  register.jsp
    作者:	   蒲孟
    日期:	    29/5/2015
    文件描述: 发布活动业务逻辑
    修改历史:
           日期1 29/5/2015 蒲孟	   创建
          
  --%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
<title>Joinus</title>
<meta name="keywords" content="活动,交友,出游,购物" />
<meta name="description" content="立足活动圈，管理休闲时间，找到活动同伴" />
<link href="/Joinus/css/Joinus_index.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/Joinus/favicon.ico">
<script type="text/javascript" src="/Joinus/js/yearmonthday.js"></script> 
<script type="text/javascript" src="/Joinus/js/city.js"></script> 
<script src="/Joinus/js/jquery.js" type="text/javascript"></script> 
<script src="/Joinus/js/jquery.validate.js" type="text/javascript"></script> 
<script>
//	$.validator.setDefaults({
//		submitHandler: function() {
//			alert("恭喜你，注册成功!");
//		}
//	});

	$().ready(function() {
		// validate the comment form when it is submitted
		//$("#form2").validate();

		// validate signup form on keyup and submit
		$("#form2").validate({
			rules: {
				uccid: {
					required: true,
					minlength: 3,
					maxlength: 11,
				     remote:{                                          //验证用户名是否存在
			               type:"POST",
			               url:"/Joinus/IsDoubleServlet",             //servlet
			               data:{
			                 uccid:function(){return $("#uccid").val();}
			               } 
			              }
		
				},
				upwd: {
					required: true,
					minlength: 6
				},
				reupwd: {
					required: true,
					minlength: 6,
					equalTo: "#upwd"
				},
				uname: {
					required: true,
					minlength: 2
				},
				uorg: {
					required: true
				},
				agree: "required"
			
			},
			messages: {
				uccid: {
					required: "请输入城程号！",
					minlength: "城程号长度应大于2位",
					maxlength: "城程号太长了，换一个吧",
					remote: "该城程号已经被注册",
				},
				upwd: {
					required: "请输入密码！",
					minlength: "密码长度应大于5位"
				},
				reupwd: {
					required: "请输入密码！",
					minlength: "密码长度应大于5位",
					equalTo: "两次输入密码不一致哦"
				},
				uname: {
					required: "请输入姓名！",
					minlength: "请填入真实姓名"
				},
				uorg: {
					required: "请输入所在单位或学校！"
				},
				agree:{
					required: ""
				}
				
			},

			success:function(label) 
			{  

			label.html("&nbsp;").addClass("valid").text('  ok！'); 			} 

		});	
	});
	$("#form2").validate({

        
		success:"valid",

		        submitHandler:function() 
		{ alert("Submitted!"); }

		});
	
	</script>
</head>

<body>
<div id="templatemo_body_wrapper">
  <div id="templatemo_wrapper">
   
    <!-- end of templatemo_header -->
    <div id="templatemo_menu">
     
   </div>
    <!-- end of templatemo_menu -->
    <div id="templatemo_content_wrapper">
      <div class="templatemo_sidebar_wrapper float_l">
        <div class="templatemo_sidebar_top"></div>
        <div class="templatemo_sidebar">
          <div class="sidebar_box">
          
            <h2>Joinus</h2>
            <div class="sidebar_box_content">
                <form name="form1" method="post" action="/Joinus/LoginServlet">
              <table width="150" border="0">
               <tr>
                 <td colspan="2">账号：</td>
                 </tr>
               <tr>
                 <td colspan="2"><input type="text" name="uccid" id="uccid2" /></td>
                 </tr>
               <tr>
                 <td colspan="2">密码：</td>
                 </tr>
               <tr>
                 <td colspan="2"><input type="password" name="upwd" id="upwd2" /></td>
                 </tr>
               <tr>
                 <td colspan="2"><font size="2">还没有一个账号？</font><a href="/Joinus/jsp/register.jsp"><font size="2">注册</font></a></td>
                 </tr>
               <tr align="center" valign="middle">
                 <td ><input type="text" name="rand" size="10" /></td>
               <td height="32" ><img src="/Joinus/jsp/image.jsp" alt="code..." name="randImage" width="72" height="19" id="randImage" ></td>
               
                 
               </tr>
               <tr align="center">
                 <td colspan="2"><input type="submit" name="submit" id="submit"class="login" value="" />
                   <a href="javascript:loadimage();"><font size="1">&nbsp; 看不清点我</font></a></td>
               </tr>
             </table>
             <p>&nbsp;</p>
           </form>
            </div>
          </div>
          <div class="sidebar_box">
           <img src="/Joinus/images/jxw.gif" width="200" height="200" style="border:0;"/>
          </div>
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div id="templatemo_content">
        <div id="content_top">
          
        </div>
        <div id="content_middle">
         <form action="/Joinus/RegisterServlet" method="post" enctype="multipart/form-data" name="form2" id="form2">
             <fieldset>
             <legend>请填入真实信息</legend>
             <table width="788" border="0" align="center">
              <tr>
                <td width="109" height="28"> <div align="right">城程号*</div></td>
                <td width="669" height="28"><input type="text" name="uccid" id="uccid"/></td> 
              </tr>
              <tr>
                <td height="28"><div align="right">密码*</div></td>
                <td height="28"><input type="password" name="upwd" id="upwd"/></td>
              </tr>
              <tr>
                <td height="28"><div align="right">确认密码*</div></td>
                <td height="28"><input type="password" name="reupwd" id="reupwd" /></td>
              </tr>
              <tr>
                <td height="28"><div align="right">真实姓名*</div></td>
                <td height="28"><input type="text" name="uname" id="uname" /></td>
              </tr>
              <tr>
                <td height="28"><div align="right">性别*</div></td>
                <td height="28"><label>
                  <input type="radio" name="ugender" id="radio" value="男" checked="true"/>
                  男
                  <input type="radio" name="ugender" id="radio2" value="女" />
                  女
                </label></td>
              </tr>
              <tr>
                <td height="28"><div align="right">出生年月日*</div></td>
                <td height="28">
                
                <select name="ubirthyear" id="selYear"></select> 年 
				<select name="ubirthmonth" id="selMonth"></select> 月
				<select name="ubirthday" id="selDay"></select> 日
			<script type="text/javascript"> 
			var selYear = window.document.getElementById("selYear"); 
			var selMonth = window.document.getElementById("selMonth"); 
			var selDay = window.document.getElementById("selDay"); 
			// 新建一个DateSelector类的实例，将三个select对象传进去 
			//var dt=new Date(2014,8,7);
			new DateSelector(selYear, selMonth, selDay,new Date().getFullYear(),new Date().getMonth()+1,new Date().getDate()); 
			</script>      
                </td>
              </tr>
              <tr> 
                <td height="28"><div align="right">城市*</div></td>
                <td height="28"><label>
                 <select id="province" name="province" onchange="selectcity()" style="font-size:12px;width:100px;" /></select> 省
                </label>
				<select id="city" name="city" style="font-size:12px;width:100px;" /></select> 市
				</td>
				</tr>
 				<script type="text/javascript">
				 init();
				</script> 
              
              <tr>
                <td height="28"><div align="right">在所在单位/学校*</div></td>
                <td height="28"><input type="text" name="uorg" id="uorg" /></td>
              </tr>
              <tr>
                <td height="28"><div align="right">电话</div></td>
                <td height="28"><input type="text" name="utele" id="utele" /></td>
              </tr>
              </tr>
              <tr>
                <td height="28"><div align="right">地址</div></td>
                <td height="28"><input type="text" name="uadd" id="uadd" /></td>
              </tr>
              <tr>
                <td height="28"><div align="right">QQ号</div></td>
                <td height="28"><input type="text" name="uQQ" id="uQQ" /></td>
              </tr>
              <tr>
                <td height="28"><div align="right">上传头像</div></td>
                <td height="28"><label>
                  <input type="file" name="uphoto" id="uphoto" />
                </label></td>
              </tr>
             
              <tr>
                <td height="28" colspan="2"><p>
                  <label>
                    <textarea name="textarea" cols="80" rows="5" readonly id="textarea" >《Joinus服务条款》
					最后更新时间：2014年8月16日【注意】欢迎申请使用Joinus提供的服务。请您仔细阅读以下全部内容。如用户不同意本服务条款任意内容，请勿注册或使用城程服务。如用户通过进入注册程序并勾选“我同意Joinus服务条款”，即表示用户与NewDesign团队已达成协议，自愿接受本服务条款的所有内容。此后，用户不得以未阅读本服务条款内容作任何形式的抗辩。
					服务条款的确认和接纳Joinus服务涉及到的所有权以及相关软件的知识产权归NewDesign团队所有。用户在享受NewDesign团队任何单项服务时，应当受本服务条款的约束。</textarea>
                  </label>
                </p></td>
              </tr>
              <tr>
                <td height="28" colspan="2"><input type="checkbox" name="agree" id="agree" />我同意Joinus服务条款</td>
        
              </tr>
              <tr align="center">
                <td height="28" colspan="2"><label>
               <input type="submit" name="button" id="button" class="register"value="" />
                </label></td>
              </tr>
            </table>
            </fieldset>
          </form>
        </div>
<div id="content_bottom"></div>
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div class="cleaner"></div>
    </div>
    <!-- end of templatemo_content_wrapper -->
  </div>
  <!-- end of templatemo_wrapper -->
  <div class="cleaner"></div>
</div>
<!-- end of templatemo_body_wrapper -->
<div id="templatemo_footer_wrapper">
  <div id="templatemo_footer">
    <ul class="footer_menu">
      <li>Copyright © 2015&nbsp; <a href="#">NewDesign</a>| 
    Designed by NewDesign| 
    Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a></li></ul>
    <div class="cleaner"></div>
  </div>
  <!-- end of footer -->
</div>
<!-- end of templatmeo_footer_wrapper -->
</body>
</html>