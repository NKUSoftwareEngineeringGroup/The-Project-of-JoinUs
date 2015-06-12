 <%--
  Copyright (c) 2015 NewDesign, All Rights Reserved.
    文件名:  modify.jsp
    作者:	   蒲孟
    日期:	  02/5/2015
    文件描述: 发布活动业务逻辑
    修改历史:
           日期1 02/6/2015	蒲孟   创建
         

  --%> 
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="edu.newdesign.joinus.vo.ShowActInIndex"%>
<%@page import="java.util.List"%>
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
<link href="/Joinus/css/Joinus.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/Joinus/favicon.ico">
<script type="text/javascript" src="/Joinus/js/yearmonthday.js"></script>
<script type="text/javascript" src="/Joinus/js/city.js"></script>  
<script src="/Joinus/js/jquery.js" type="text/javascript"></script> 
<script src="/Joinus/js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
 function selectAllCheckBox(checkBoxName){
	 // 步骤1：获取复选框对象的集合
	 var lstCusids = document.getElementsByName(checkBoxName);
	 // 步骤2：使用循环便利节点集合对象
	 for(var i=0; i<lstCusids.length; i++){
		 // 步骤3：判断节点是否被选中
		 if(lstCusids[i].checked == false){
			 // 步骤4：选中该节点对象
			 lstCusids[i].checked = true;
		 }
	 }
 }
 function selectReverseCheckBox(checkBoxName){
	 // 步骤1：获取复选框对象的集合
	 var lstCusids = document.getElementsByName(checkBoxName);
	 // 步骤2：使用循环便利节点集合对象
	 for(var i=0; i<lstCusids.length; i++){
		 // 步骤3：判断节点是否被选中
		 if(lstCusids[i].checked == false){
			 // 步骤4：选中该节点对象
			 lstCusids[i].checked = true;
		 }else{
			// 步骤5：取消选中该节点对象
		    lstCusids[i].checked = false;
		 }
	 }
 }
 function showContent(id1,id2){
	  document.getElementById(id1).style.display="none";
	  document.getElementById(id2).style.display="block";

	}
	function hideContent(id1,id2){
	  document.getElementById(id1).style.display="block";
	  document.getElementById(id2).style.display="none";
	}
 </script> 
<script>
	$().ready(function() {
		$("#form1").validate({
			rules: {
				upwdformer: {
					required: true,
					remote:{                                          //验证用户原密码是否正确
			               type:"POST",
			               url:"/Joinus/IsSamePwdServlet",             //servlet
			               data:{
			                 upwdformer:function(){return $("#upwdformer").val();}
			               } 
			              } 
				},
				upwdlater: {
					required: true,
					minlength: 6
				},
				reupwdlater: {
					required: true,
					minlength: 6,
					equalTo: "#upwdlater"
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
				upwdformer: {
					required: "请输入原密码!",
					remote: "原密码不正确诶，请重新填写"
				},
				upwdlater: {
					required: "请输入密码！",
					minlength: "密码长度应大于5位"
				},
				reupwdlater: {
					required: "请输入密码!",
					minlength: "密码长度应大于5位",
					equalTo: "两次输入密码不一致哦"
				},
				uname: {
					required: "请输入姓名!",
					minlength: "请填入真实姓名"
				},
				uorg: {
					required: "请输入所在单位或学校!"
				},
				agree:{
					required: ""
				}
				
			}
		});

		
	});
	</script>
</head>
<body>
<c:if test="${empty sessionScope.user }">
	<script>
		alert("你怎么不登陆，快去登录！！！！");
		location="/Joinus/jsp/login.jsp";
	</script>
</c:if>
<div id="templatemo_body_wrapper8">
  <div id="templatemo_wrapper8">
    <div id="templatemo_header">
     <div id="site_title"> <a href="#" ><img src="/Joinus/images/logo.png" width="103" height="97" /><span>Joinus</span> </a> </div>
    </div>
    <!-- end of templatemo_header -->
    <div id="templatemo_menu8">
      <div id="search_box">
         <form action="/Joinus/SearchActServlet" method="get">
          <input type="text" value="" name="search" size="45" id="search" title="usernmae" />
          <label>
            <select name="select" id="select">
              <option value="actname" selected>活动名称</option>
              <option value="acttopic">活动主题</option>
              <option value="actcontent">活动内容</option>
            </select>
          </label>
          <input type="submit" name="login" value="找活动" alt="login" id="submit_btn" title="Login" />
        </form>
      </div>
      <ul>
       <li><a href="/Joinus/ShowInIndexServlet"> 首页</a></li>
        <li><a href="/Joinus/ShowInPersonalServlet">个人主页</a></li>
        <li><a href="/Joinus/FriendServlet">好友</a></li>
        <li></li>
           <li><a href="/Joinus/ShowInActivityCircleServlet?type=0">活动</a></li>
        <li><a href="/Joinus/jsp/chatrooms.jsp">聊天室</a></li>
        <li><a href="/Joinus/PreModifyServlet"class="current">修改资料</a></li>                               
         <li>  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;                               
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp; </li>   
          <span> <a href="/Joinus/jsp/login.jsp">退出登录</a></span>
    </ul>
    </div>
    <!-- end of templatemo_menu -->
   <div id="templatemo_content_wrapper">
      <div class="templatemo_sidebar_wrapper float_l">
        <div class="templatemo_sidebar_top"></div>
        <div class="templatemo_sidebar">
          <div class="sidebar_box">
            <h2>个人信息</h2>
        <div class="sidebar_box_content">
          <div>
            <span> <img src="/Joinus/upload/images/photo/${sessionScope.user.uphoto}" width="150" height="158" /><img src="/Joinus/images/xrw.png" width="27" height="29" /> ${sessionScope.user.uname}</span>
        </div>
        </div>
          <div class="templatemo_sidebar_bottom"></div>
          <div class="sidebar_box">
            <h2>详细资料</h2>
             <table width="200" border="0" style="margin:auto">
            <c:if test="${!empty sessionScope.user.uorg}">
                <tr>
                  <td width="57">学校/单位</td>
                  <td width="133">${ sessionScope.user.uorg}</td>
                </tr>
            </c:if>
              <c:if test="${!empty sessionScope.user.ubirth}">
                <tr>
                  <td>出生日期</td>
                  <td>${ sessionScope.user.ubirth}</td>
                </tr>
              </c:if>
                <c:if test="${!empty sessionScope.user.utele}">
                <tr>
                  <td>电话号码</td>
                  <td>${ sessionScope.user.utele}</td>
                </tr>
               </c:if>
                 <c:if test="${!empty sessionScope.user.uqq}">
                <tr>
                  <td>qq号码</td>
                  <td>${ sessionScope.user.uqq}</td>
                </tr>
              </c:if>
                <c:if test="${!empty sessionScope.user.ucity}">
                <tr>
                  <td>现居城市</td>
                  <td>${ sessionScope.user.ucity}</td>
                </tr>
                </c:if>
               <c:if test="${!empty sessionScope.user.uadd}">
                <tr>
            
                  <td>详细住址</td>
                  <td>${ sessionScope.user.uadd}</td>
                </tr>
              </c:if>
              </table>
          </div>
          </div>
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div id="templatemo_content">
      <div id="content_top"></div>
       <div id="content_middle"> 
           <h2>修改资料</h2>
           <form action="/Joinus/ModifyServlet?type=1" method="post" enctype="multipart/form-data" name="form1" id="form1" >
             <table width="1000" border="0" align="center">
             <tr><td width="147">
             <input type="hidden" name="uccid" id="uccid" value="${requestScope.uccid }"/>
             </td></tr>
             
             
             
             <tr  align="right"><td>
             <a href="/Joinus/jsp/modifypwd.jsp">修改密码?点这里</a>
              </tr>
              <tr>
                <td height="28"><div align="right">真实姓名 </div></td>
                <td width="843" height="28"> &nbsp; &nbsp;   
 				<c:if test="${empty requestScope.uname }">
      	          	<input type="text" name="uname"  id="uname"></c:if>
              	<c:if test="${!empty requestScope.uname }">
      				<input type="text" name="uname"  id="uname" value="${requestScope.uname }"></c:if>
                
                </td>
              </tr>
              <tr>
                <td height="28"><div align="right">性别</div></td>
                <td height="28"><label>
                 &nbsp; &nbsp;   
                   <input type="radio" name="ugender" id="radio" value="男" checked="true"/> 男
                  <input type="radio" name="ugender" id="radio2" value="女" />女
                </label></td>
              </tr>
              <tr>
                <td height="28"><div align="right">出生年月日</div></td>
                <td height="28">
                  &nbsp;&nbsp;&nbsp;
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
                &nbsp; &nbsp; 
                 <select id="province" name="province" onChange="selectcity()" style="font-size:12px;width:100px;" /></select> 省
                </label>
				<select id="city" name="city" style="font-size:12px;width:100px;" /></select> 市
				</td>
				</tr>
 				<script type="text/javascript">
				 init();
				</script> 
              <tr>
              <tr>
                <td height="28"><div align="right">在所在单位/学校</div></td>
                <td height="28">&nbsp; &nbsp;   
                <c:if test="${empty requestScope.uname }">
      	          	<input type="text" name="uorg" id="uorg"></c:if>
              	<c:if test="${!empty requestScope.uname }">
      				<input type="text" name="uorg" id="uorg" value="${requestScope.uorg }"></c:if></td>
              </tr>
              <tr>
                <td height="28"><div align="right">电话</div></td>
                <td height="28">&nbsp; &nbsp;   
                <c:if test="${empty requestScope.utele }">
      	          	<input type="text" name="utele" id="utele"></c:if>
              	<c:if test="${!empty requestScope.utele }">
      				<input type="text" name="utele" id="utele" value="${requestScope.utele }"></c:if></td>
              </tr>
                <tr>
                <td height="28"><div align="right">QQ号</div></td>
                <td height="28">&nbsp; &nbsp;   
                <c:if test="${empty requestScope.uQQ }">
      	          	<input type="text" name="uQQ" id="uQQ"></c:if>
              	<c:if test="${!empty requestScope.uQQ }">
      				<input type="text" name="uQQ" id="uQQ" value="${requestScope.uQQ }"></c:if></td>
              </tr>
              <tr>
                <td height="28"><div align="right">地址</div></td>
                <td height="28">&nbsp; &nbsp;   
                <c:if test="${empty requestScope.uadd }">
      	          	<input type="text" name="uadd" id="uadd"></c:if>
              	<c:if test="${!empty requestScope.uadd }">
      				<input type="text" name="uadd" id="uadd" value="${requestScope.uadd }"></c:if></td>
              </tr>          
              <tr>
                <td height="28"><div align="right">头像</div></td>
                <td height="28"><label>
                 &nbsp; &nbsp; 
                  <input type="file" name="uphoto" id="uphoto" />
                </label></td>
              </tr>
              <tr>
                <td height="28"><div align="right">爱好</div></td>
                <td height="28">
               <p>&nbsp;</p>
                 <p>&nbsp;&nbsp; 休闲娱乐：
                   <label><input type="checkbox" name="checkbox" id="checkbox" value="1" />逛街&nbsp; &nbsp;</label> 
                  <label><input type="checkbox" name="checkbox" id="checkbox2" value="2"/> KTV&nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox3" value="3" />游乐游艺&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox4" value="4"/>养生&nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox5" value="5"/>DIY手工</label>
                <label><input type="checkbox" name="checkbox" id="checkbox6" value="6"/></label><label>其他</label>
                </p>
                <p>&nbsp;&nbsp; 音乐：            
                  <label> &nbsp; &nbsp; &nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox7" value="7"/></label>演唱会
                <label><input type="checkbox" name="checkbox" id="checkbox8" value="8"/></label>演奏会
                  <label><input type="checkbox" name="checkbox" id="checkbox9" value="9"/></label>组乐队
                  <label><input type="checkbox" name="checkbox" id="checkbox10" value="10"/>组舞团</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox11" value="11"/></label>其他
                  </p>
                <p>
                  <label> </label> 
                 &nbsp;&nbsp; 体育：&nbsp; &nbsp;&nbsp; &nbsp;
                  <label>
                  <input type="checkbox" name="checkbox" id="checkbox12" value="12"/></label>看球赛 <label>
                  <input type="checkbox" name="checkbox" id="checkbox13" value="13"/></label>组球队 <label>
                  <input type="checkbox" name="checkbox" id="checkbox14" value="14"/></label>健身&nbsp; &nbsp;<label>
                  <input type="checkbox" name="checkbox" id="checkbox15" value="15"/></label>其他
                  </p>
                <p>
                  <label>&nbsp;&nbsp; 学业：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox16" value="16"/></label>听讲座 
                  <label><input type="checkbox" name="checkbox" id="checkbox17" value="17"/></label>组自习 
                  <label><input type="checkbox" name="checkbox" id="checkbox18" value="18"/></label>找课友 
                  <label><input type="checkbox" name="checkbox" id="checkbox19" value="19"/></label>参赛组队
                  <label><input type="checkbox" name="checkbox" id="checkbox20" value="20"/></label>其他
                  </p>
                <p>
                  <label>&nbsp;&nbsp; 美食：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox21" value="21"/>美食</label></p><p>
                  <label>&nbsp;&nbsp; 购物：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox22" value="22"/>购物</label>
                  <label>&nbsp; &nbsp; &nbsp; </label>
                  <label>&nbsp;</label></p>
                <p>
                  <label>&nbsp;&nbsp; 出游：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox23" value="23" />出游 </label></p>
                <p>&nbsp;&nbsp; 合租：
                  <label>&nbsp; &nbsp; &nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox23" value="24" />合租 </label></p>
                <p>&nbsp;&nbsp; 其他：
                  <label>&nbsp; &nbsp; &nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox25" value="25"/>其他</label>
                
<label><br />
</label>
              </p></td>
              </tr>
              <tr>
                <td height="28" colspan="2">&nbsp; &nbsp;   
            		  &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
   		              <input type="button" name="btnSelelectAll" id="btnSelelectAll" value="全选" onClick="javascript:selectAllCheckBox('checkbox');" onMouseOver="this.style.borderColor='#75cd02'" onMouseOut="this.style.borderColor='#dcdcdc'" class="btn1 pbtn1" />
  					<input type="button" name="btnReverseSelelect" id="btnReverseSelelect" value="反选" onClick="javascript:selectReverseCheckBox('checkbox');" onMouseOver="this.style.borderColor='#f76b00'" onMouseOut="this.style.borderColor='#dcdcdc'"  class="btn2 pbtn1" />
            
            </td></tr>
              
              <tr>
                <td height="28" colspan="2"> &nbsp;
                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                   <p>
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                      &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                     <input type="submit" name="submit" id="submit" value="提交修改" class="btn10" onMouseOver="this.style.backgroundPosition='left -40px'" onMouseOut="this.style.backgroundPosition='left top'" />
                  </p></td>
              </tr>
            </table>
          </form> 
        </div>       
        <div id="content_bottom"></div>
      </div>
      <div class="templatemo_sidebar_wrapper float_r">
        <div class="templatemo_sidebar_top"></div>
        <div class="templatemo_sidebar">
          <div class="sidebar_box">
            <h2>推送</h2>
            <div class="sidebar_box_content">
              <div class="news_box">
                <h4><a href="/Joinus/FindFriendsServlet">好友推荐</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="javascript:divrefresh();" value="换一批" />
                <a href="/Joinus/FindFriendsServlet">更多</a></h4>           
<div id="f1" style="display:block;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar1 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar1>2) break;%>
      <% if(ar1%3==0) out.println("<tr align='center'>");%>
   
         
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/Joinus/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
            
       <%if(ar1%3==2) out.println("</tr>");ar1++;%> 
   </c:forEach>
</table>
</div>

<div id="f2" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar2 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar2>2&&ar2<=5) {
	   if(ar2%3==0) 
		   out.println("<tr align='center'>");%>
       
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/Joinus/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
         
       <%
	   if(ar2%3==2) out.println("</tr>");
	   }ar2++;%>
   </c:forEach>
</table>
</div>

<div id="f3" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar3 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar3>5&&ar3<=8) {
	   if(ar3%3==0) 
		   out.println("<tr align='center'>");%>
       
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/Joinus/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
            
       <%
       if(ar3%3==2) out.println("</tr>");
       }ar3++;%>
   </c:forEach>
</table>
</div>

<script type="text/javascript">
function divrefresh(){
   var m1=document.getElementById('f1');
   var m2=document.getElementById('f2');
   var m3=document.getElementById('f3');
   if(m1.style.display=='block'){
      m1.style.display='none';
      m2.style.display='block';
   }else if(m2.style.display=='block'){
      m2.style.display='none';
      m3.style.display='block';
   }else{
      m3.style.display='none';
      m1.style.display='block';
   }
}
</script>
              </div>
              <div class="news_box">
                            <h4><a href="/Joinus/ShowActByAdminServlet">活动推荐</a> 
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="javascript:divrefresh2();" value="换一批" />
                <a href="/Joinus/ShowActByAdminServlet">更多</a></h4>          
<div id="c1" style="display:block;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr1 = 0; %>   
  <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr1>2) break;%>
      <% if(cr1%3==0) out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/Joinus/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%if(cr1%3==2) out.println("</tr>");cr1++;%> 
   </c:forEach>
</table>
</div>

<div id="c2" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr2 = 0; %>    
   <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr2>2&&cr2<=5) {
	   if(cr2%3==0) out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/Joinus/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%
	   if(cr2%3==2) out.println("</tr>");
	   }cr2++;%>
   </c:forEach>
</table>
</div>

<div id="c3" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr3 = 0; %>    
   <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr3>5&&cr3<=8) {
	   if(cr3%3==0) 
		   out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
              <td width="50" align="center" valign="middle">
              <p><img src="/Joinus/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/Joinus/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%
       if(cr3%3==2) out.println("</tr>");
       }cr3++;%>
   </c:forEach>
</table>
</div>


<script type="text/javascript">
function divrefresh2(){
   var m1=document.getElementById('c1');
   var m2=document.getElementById('c2');
   var m3=document.getElementById('c3');
   if(m1.style.display=='block'){
      m1.style.display='none';
      m2.style.display='block';
   }else if(m2.style.display=='block'){
      m2.style.display='none';
      m3.style.display='block';
   }else{
      m3.style.display='none';
      m1.style.display='block';
   }
}
</script>
             </div>
              <div class="news_box">
      <h4><a href="/Joinus/ShowInPersonalServlet">近日行程表</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/Joinus/ShowInPersonalServlet">更多</a></h4>
      <tr>
        <td>日程太空？去<a href="/Joinus/ShowInActivityCircleServlet?type=0">活动圈</a>逛逛吧！</td>
      </tr>
      <tr>
        <td></td>
      </tr>
             <div id="c1" style="display:block;">
<table width="170" height="50" border="1" style="border:none">
 <%int m = 0; %>  
 <c:if test="${!empty sessionScope.lstmyAct}">  
  <%List<ShowActInIndex> lstmyAct = (List<ShowActInIndex>)session.getAttribute("lstmyAct");
    for (ShowActInIndex myact : lstmyAct){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    String n = formatter.format(new Date()) ;
    if((formatter.format(myact.getAdate()).compareTo(n))>0){ %>
   <% if(m>2) break;%>
      <% if(m%3==0) out.println("<tr align='center'>");%>
         <%if(myact.getPtype()==1){%>
              <tr>
              <td>
               <p><a href="/Joinus/ShowInOthersServlet?uccid=<%=myact.getUccid() %>"></a><%=myact.getAdate() %></p>
             
                <p><%=myact.getUname() %>将参加<%=myact.getOwner_id() %>发布的：<%=myact.getAname() %></p>
              
                <p align="center"><a href="/Joinus/ToCommentServlet?aid=<%=myact.getAid() %>">查看详细内容</a></p>
                </td>
              </tr>
         <%}else{if(myact.getPtype()==0){%>
             <tr>
             <td>
               <p><a href="/Joinus/ShowInOthersServlet?uccid=<%=myact.getUccid() %>"></a><%=myact.getPdate() %></p>
             
               <p><%=myact.getUname() %>发布活动：<%=myact.getAname() %></p>
             
               <p align="center"><a href="/Joinus/ToCommentServlet?aid=<%=myact.getAid() %>">查看详细内容</a></p>
               </td>
             </tr>
         <%}}%>
       <%if(m%3==2) out.println("</tr>");m++;%> 
      <%}} %>
   </c:if>
         <c:if test="${empty sessionScope.lstmyAct}">
          <table width="720" border="0" style="border:none">
            <tr>
              <td>你还没有活动哦，赶快去活动圈找一找有趣的活动吧！
              </td>
            </tr>
           </table>
         </c:if>
</table>
</div>
</div>
            </div>
            <!-- end of sidebar_box_content -->
          </div>
          <!-- end of sidebar_box ( news ) -->
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div class="cleaner"></div>
    </div>
    <!-- end of templatemo_content_wrapper -->
  </div>
  <!-- end of templatemo_wrapper -->
  <div class="cleaner"></div>
</div>
<!-- end of templatemo_body_wrapper3 -->
<div id="templatemo_footer_wrapper8">
  <div id="templatemo_footer">
    <ul class="footer_menu">
      <li>
      Copyright © 2015&nbsp; <a href="#">NewDesign</a>| 
    Designed by NewDesign| 
    Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a></li>
      <!-- end of footer -->
</ul>
</div>
</div>
<!-- end of templatmeo_footer_wrapper -->
</body>
</html>