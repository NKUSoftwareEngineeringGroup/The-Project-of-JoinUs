 <%--
  Copyright (c) 2015 NewDesign, All Rights Reserved.
    文件名:  login.jsp
    作者:	   蒲孟
    日期:	   02/6/2015
    文件描述: 发布活动业务逻辑
    修改历史:
           日期1 02/6/2015 蒲孟	   创建
           

  --%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="活动,交友,出游,购物" />
<meta name="description" content="立足活动圈，管理休闲时间，找到活动同伴" />
<link rel="shortcut icon" href="/Joinus/favicon.ico">
<link href="/Joinus/css/Joinus_index.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/Joinus/favicon.ico">
<title>Joinus</title>
<script> 
function loadimage(){ 
document.getElementById("randImage").src = "/Joinus/jsp/image.jsp?"+Math.random(); 
} 
</script> 
</head>
<body>
<c:if test="${!empty requestScope.msgcode }">
	<%
		int msgcode = Integer.parseInt(request.getAttribute("msgcode").toString());
		switch(msgcode){
		case 101:
			out.print("<script>alert('账号或密码错误，登录失败！');</script>");
			break;
		case 103:
			out.print("<script>alert('当前账号已经登录！');</script>");
			break;
		default:
			break;
		}
	%>
</c:if>
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
                 <td colspan="2">账号：
                 <c:if test="${empty requestScope.uccid }">
      	          	<input type="text" name="uccid" id="uccid">
              	</c:if>
              	<c:if test="${!empty requestScope.uccid }">
      				<input type="text" name="uccid" id="uccid" value="${requestScope.uccid }">
      	        </c:if>      	
                 </td>
                 </tr>
                 <td colspan="2">密码：</td>
                 </tr>
               <tr>
                 <td colspan="2"><input type="password" name="upwd" id="upwd" /></td>
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
           </form>
            <table width="160" border="0">
            <tr align="center">
                  <img src="/chengcheng/images/jxw.gif" width="250" height="250" style="border:0;"/>
               </tr>
           </table>
            </div>
          </div>
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div id="templatemo_content">
        <div id="banner"> <img src="/Joinus/images/loginp1.png"  width="880" height="260"/></div>
        <div id="content_top"></div>
        <div id="content_middle">
         <img src="/Joinus/images/loginp2.png"  alt="" width="850" height="240" usemap="#Map" border="0"/>
          <map name="Map" id="Map">
            <area shape="rect" coords="418,175,598,214" href="#" />
          </map>

          <div class="cleaner"></div>
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