<%-- 
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    comments.jsp
 *作者:	   李东池
 *日期:	 22/05/2015     
 *文件描述:   讨论组页面
 *修改历史:
           日期1 22/05/2015      李东池	   创建.
           日期2 23/05/2015     蒲孟  修改
           日期3 25/05/2015  李东池  修改    
           日期3 27/05/2015  蒲孟    修改            --%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="edu.newdesign.joinus.dao.impl.ShowActTagDaoImpl"%>
<%@page import="edu.newdesign.joinus.vo.ShowActTag"%>
<%@page import="edu.newdesign.joinus.dao.IShowActTagDao"%>
<%@page import="edu.newdesign.joinus.dao.impl.UsersDaoImpl"%>
<%@page import="edu.newdesign.joinus.dao.IUsersDao"%>
<%@page import="edu.newdesign.joinus.vo.ShowUserCommAct"%>
<%@page import="edu.newdesign.joinus.po.Activities"%>
<%@page import="edu.newdesign.joinus.dao.impl.ShowUserCommActDaoImpl"%>
<%@page import="edu.newdesign.joinus.dao.IShowUserCommActDao"%>
<%@page import="edu.newdesign.joinus.po.Users"%>
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
<link rel="shortcut icon" href="/Joinus/favicon.ico">
<link href="/Joinus/css/Joinus.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function addShare(aid){
	location="/Joinus/ShareServlet?aid="+aid;
}
function addPart(aid){
	location="/Joinus/ParticipateServlet?aid="+aid;
}

function message(id,bid,bid1){
	// 获取页面中所有的消息回复表单行对象的集合
	var lstTr = document.getElementsByName("text");
	var lstTrb = document.getElementsByName("button");
	var lstTrb1 = document.getElementsByName("button1");
	// 使用循环遍历每个对象将其显示属性设置为none
	for(var i=0; i<lstTr.length; i++){
		lstTr[i].style.display = "none";
	}
	for(var i=0; i<lstTrb.length; i++){
		lstTrb[i].style.display = "none";
	}
	for(var i=0; i<lstTrb1.length; i++){
		lstTrb1[i].style.display = "none";
	}
	// 将需要显示的回复表单行对象进行显示
	document.getElementById(id).style.display = "block";
	document.getElementById(bid).style.display = "block";
	document.getElementById(bid1).style.display = "block";
}
function stopmessage(id,bid,bid1){
	document.getElementById(id).style.display = "none";
	document.getElementById(bid).style.display = "none";
	document.getElementById(bid1).style.display = "none";
}
</script>
</head>
<body>
<c:if test="${empty sessionScope.user }">
	<script>
		alert("你怎么不登陆，快去登录！！！！");
		location="/Joinus/jsp/login.jsp";
	</script>
</c:if>

<div id="templatemo_body_wrapper2">
  <div id="templatemo_wrapper2">
    <div id="templatemo_header">
      <div id="site_title"> <a href="#" ><img src="/Joinus/images/logo.png" width="103" height="97" /><span>Joinus</span> </a> </div>
    </div>
    <!-- end of templatemo_header -->
    <div id="templatemo_menu2">
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
         <li><a href="/Joinus/ShowInIndexServlet" class="current">首页</a></li>
        <li><a href="/Joinus/ShowInPersonalServlet">个人主页</a></li>
        <li><a href="/Joinus/FriendServlet">好友</a></li>
        <li></li>
        <li><a href="/Joinus/ShowInActivityCircleServlet?type=0">活动</a></li>
        <li><a href="/Joinus/jsp/chatrooms.jsp">聊天室</a></li>
        <li>   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;                               
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp; </li>   
          <span> <a href="/Joinus/LogoutServlet">退出登录</a></span>
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
              <div class="discount">更多</div>
          </div>
          <div class="sidebar_box">
            <h2>城程应用</h2>
              <div class="sidebar_box_content">
              <ul class="categories_list">
             <li><a href="/Joinus/jsp/publishactivity.jsp">发活动</a></li>
                <li><a href="/Joinus/ShowInActivityCircleServlet?type=0">活动圈</a></li>
                <li><a href="/Joinus/ShowInAboutMeServlet">与我相关</a></li>
                <li><a href="/Joinus/FriendServlet">好友</a></li>
                <li><a href="/Joinus/ShowActByAdminServlet">活动广场</a></li>
              </ul>
            </div>
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
          <!--活动信息部分-->
<table width="700" border="1" align="center">
  <tr>
    <td colspan="3" valign="top"><h1>活动详细信息：
      <%IUsersDao iUsersDao = new UsersDaoImpl();
        Activities ac = (Activities)request.getAttribute("act");
    	String id = ac.getOwner_id();
    	int aid=ac.getAid();
    	String content = ac.getAcontent();
    	Users u = iUsersDao.selectById(id);
  	%>
    </h1>
      <div><img src="/Joinus/upload/images/photo/<%=u.getUphoto()%>"  alt="" width="50" height="50" align="middle"/><span><%=u.getUname()%>发布了：</span></div>
      <table width="80%" border="0" align="center">
        <tr>
          <td width="25%" align="center" valign="middle">活动名称：</td>
          <td>${ requestScope.act.aname}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">活动主题：</td>
          <td>${ requestScope.act.atopic}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">活动地点：</td>
          <td>${ requestScope.act.aaddress}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">活动发布时间：</td>
          <td>${ requestScope.act.adate}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">报名截止时间：</td>
          <td>${ requestScope.act.adeadline}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">最多人数：</td>
          <td>${ requestScope.act.amax_num}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">最少人数：</td>
          <td>${ requestScope.act.amin_num}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">当前人数：</td>
          <td>${ requestScope.act.acurr_num}</td>
          </tr>
        <tr>
          <td width="25%" align="center" valign="middle">活动内容：</td>
          <%if(content==null){ %>
          <td>${ requestScope.act.acontent}</td>
          <%}else{ %>
          <td>暂无有关活动的详细描述</td>
          <%} %>
          </tr>
          <%SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
           String n = formatter.format(new Date()) ;
           if((formatter.format(ac.getAdeadline()).compareTo(n))>0){%>
        	 <tr>
               <td width="25%" align="center" valign="middle">活动状态：</td>
               <td>活动未开始</td>
               </tr>
             <tr>
          <% }
           else{
        	   if((formatter.format(ac.getAdate()).compareTo(n))>0){%>
       		      <tr>
                   <td width="25%" align="center" valign="middle">活动状态：</td>
                   <td>报名已停止</td>
                  </tr>
                 <tr>
           <% }
        	   else{%>
       			  <tr>
                       <td width="25%" align="center" valign="middle">活动状态：</td>
                       <td>活动已结束</td>
                  </tr>
                     <tr>
     <%}}%>
         <td width="25%" align="center" valign="middle">活动标签：</td>
         <td>
          <%IShowActTagDao iShowActTagDao = new ShowActTagDaoImpl();
            List<ShowActTag> lstt = iShowActTagDao.selectById(ac.getAid());
            if(lstt.size()==0){%>
            	暂无标签&nbsp;
         <%}
            else{
          for(int i=0;i<lstt.size();i++){
            	String tname = lstt.get(i).getTname();%>
           <%=tname %>&nbsp;
          <%} }%>
          </td>
          
          </tr>
        </table>
      <p>&nbsp;</p></td>
  </tr>
  <tr>
    <td width="91" align="center" valign="middle">活动参与者:</td>
    <td width="560" align="left" valign="middle"><table width="50" height="50" border="1" style="border:none">
      <% int p = 0;%>
      <c:forEach items="${ requestScope.lstp}" var="joiner">
      <c:if test="${joiner.ptype!='2'}">
        <% if(p%5==0) out.println("<tr align='center'>");%>
        <td width="247" align="center" valign="top">
         <img src="/Joinus/upload/images/photo/${joiner.uphoto}"  alt="" width="110" height="110" align="bottom"/>
          <div >
            <p align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${joiner.uname }</p>
            <div>
              <input type="button" name="news" id="news" onclick="javascript:message('text${joiner.uccid}','button${joiner.uccid}','button1${joiner.uccid}');" value="发消息">
            </div>
            <div>
            <table width="50" height="10" align="center" border="0" style="border:none">
                 <tr id="message${joiner.uccid}" align="center" valign="middle" name="message" style="display:none;">
                 <form name="form2" method="post" action="/Joinus/SendcomMessageServlet">
                 <input type="hidden" id="nuser" name="nuser" value="${joiner.uccid}">
                 <input type="hidden" id="aid" name="aid" value="${joiner.aid}">
                 <p align="center">
                   <label>
                     <textarea name="text" id="text${joiner.uccid}" cols="10" rows="2" style="display:none;"></textarea>
                      </label>
                 </p>
                 <p align="center">
                 <div align="center">
                  <input type="submit" name="button" id="button${joiner.uccid}" value="发送" style="display:none;">
                     <input type="button" name="button1" id="button1${joiner.uccid}" onClick="javascript:stopmessage('text${joiner.uccid}','button${joiner.uccid}','button1${joiner.uccid}');" value="关闭" style="display:none;">
                   
                   </div>
                 </p>
                 </form>
                </tr>
                </table>
                </div>
          </div></td>
          <% if(p%5==4) out.println("</tr>");p++;%>
       </c:if>
       </c:forEach>
    </table></td>
    <td width="27" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="51" colspan="3" valign="bottom">
   
      <p>
        <input type="button" name="button2" id="button2" onClick="javascript:addzan('<%=ac.getAid()%>');" value="  赞  " >
        &nbsp; 
        <input type="button" name="button4" id="button"  value=" 分享 " onClick="addShare('<%=ac.getAid()%>')">
          &nbsp; 
        <input type="button" name="button3" id="button3"  value=" 参与 " onClick="addPart('<%=ac.getAid()%>')">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 已有${ requestScope.act.aproise_num}人点赞；已有${ requestScope.act.ashare_num}人分享&nbsp;&nbsp;</p>

</td>
  </tr>
</table>
<p>&nbsp;</p>
<script type="text/javascript">
function addzan(aid){
   location="/Joinus/AddZanServlet?aid="+aid;
}
</script>
<script language="javascript">
function comments(id){
	var lstTr = document.getElementsByName("comments");
	for(var i=0; i<lstTr.length; i++){
		lstTr[i].style.display = "none";
	}
	document.getElementById(id).style.display="block";
}
function stopcomments(id){
	
	document.getElementById(id).style.display="none";
}
</script>
<!--显示已有的评论部分-->
<table width="700" border="0" align="center">
  <tr>
    <td colspan="4"><h2>评论区：</h2></td>
  </tr>
  <%IShowUserCommActDao show = new ShowUserCommActDaoImpl();
    Activities act = (Activities)request.getAttribute("act");
	List<ShowUserCommAct> lstShowUserCommAct = show.selectByAid(act.getAid());
	Collections.sort(lstShowUserCommAct,new Comparator<ShowUserCommAct>(){
		public int compare(ShowUserCommAct o1, ShowUserCommAct o2) {
			// TODO Auto-generated method stub
			return o1.getCdate().compareTo(o2.getCdate());
		}
	});%>
  <tr>
    <td colspan="4" bgcolor="#FFFFFF">已有<%=act.getAcomm_num() %>人评论</td>
  </tr>
<%	for (ShowUserCommAct showUserCommAct : lstShowUserCommAct) {
	System.out.println(showUserCommAct);
    if(showUserCommAct.getCuser_to()==0){
    	System.out.println(showUserCommAct);
	   %>
	   <table width=700" border="0" align="center">
	   <tr>
	    <td width="11%" height="34" align="center" bgcolor="#FFFFFF">
	     <img src="/Joinus/upload/images/photo/<%=showUserCommAct.getPhoto() %>" width="50" height="50"  alt=""/>
	    </td>
	    <td width="20%" align="center" bgcolor="#FFFFFF"><%=showUserCommAct.getUname() %></td>
	    <td width="40%" bgcolor="#FFFFFF"><%=showUserCommAct.getCcontent() %></td>
	    <td width="20%" bgcolor="#FFFFFF"><%=showUserCommAct.getCdate() %></td>
	    <td width="10%" align="center" bgcolor="#FFFFFF"><a href="javascript:comments('comments<%=showUserCommAct.getCdate() %>');">回复</a></td>
	  </tr>
	  </table>
<%	   for (ShowUserCommAct s : lstShowUserCommAct) {
		   if(s.getCuser_to()!=0){
			   System.out.println(s);
			   if(s.getCuser_to()==showUserCommAct.getCid()){
				   System.out.println(s);
%>
  <table width=700" border="0" align="center">
  <tr>
  <td width="35%" height="34" align="right" bgcolor="#FFFFFF">
	     <img src="/Joinus/upload/images/photo/<%=s.getPhoto() %>" width="50" height="50" align="middle" alt=""/><%=s.getUname() %>回复<%=showUserCommAct.getUname() %>：
	    </td>
    <td width="51%" align="left" valign="middle" bgcolor="#FFFFFF"><%=s.getCcontent() %></td>
    <td width="22%" bgcolor="#FFFFFF"><%=s.getCdate() %></td>
  </tr></table>
  <%}}}}%>
<!--回复信息部分-->
<table width=700" border="0" align="center">
  <tr id="comments<%=showUserCommAct.getCdate() %>" name="comments" style="display:none;">
    <td align="center" valign="middle" bgcolor="#FFFFFF">
    <form name="form2" method="post" action="/Joinus/CommentsServlet">
      <p>
      <input type="hidden" id="aid" name="aid" value="<%=ac.getAid() %>">
      <input type="hidden" id="cuser_to" name="cuser_to" value="<%=showUserCommAct.getCid() %>">
        <label>
          <textarea name="content" id="content" cols="70" rows="5"></textarea>
        </label>
      </p>
      <p>
        <label>
          <input type="submit" name="submit" id="submit" value="  评论  ">
        </label>
     &nbsp; &nbsp;&nbsp; &nbsp;
      </p>
    </form>
    <p>
    <label>
       <input type="button" name="button5" id="button5" onClick="javascript:stopcomments('comments<%=showUserCommAct.getCdate() %>');" value="  关闭  ">
     </label>
     </p>
    </td>
  </tr>	
</table>
<%} %>
</table>
 
<p>&nbsp;</p>
<p>&nbsp;</p>		
<!--用户进行评论的部分-->
<table width="700" border="0" align="center">
  <tr>
    <td width="13%" align="center" valign="middle" bgcolor="#FFFFFF">
     <img src="/Joinus/upload/images/photo/${sessionScope.user.uphoto}" width="50" height="50"  alt=""/>
    </td>
    <td width="9%" align="center" valign="middle" bgcolor="#FFFFFF">${sessionScope.user.uname}</td>
    <td width="78%" align="right" valign="middle" bgcolor="#FFFFFF">
    <form name="form3" method="post" action="/Joinus/CommentsServlet">
      <p>
      <input type="hidden" id="aid" name="aid" value="<%=ac.getAid() %>"/>
      <input type="hidden" id="cuser_to" name="cuser_to" value="<%=0 %>">
        <label>
          <textarea name="content" id="content" cols="47" rows="5"></textarea>
        </label>
      </p>
      <p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
        <label>
          <input type="submit" name="button3" id="button3" value="  评论  ">
        </label>
      </p>
    </form></td>
  </tr>
</table>
<p>&nbsp;</p>
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
                <h4><a href="#">天气预报</a></h4>
                
<iframe allowtransparency="true" frameborder="0" width="180" height="203" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=0&v=1&d=2&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=140&h=203&align=center"></iframe>

</div>
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
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    String n1 = formatter1.format(new Date()) ;
    if((formatter.format(myact.getAdate()).compareTo(n1))>0){ %>
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
<!-- end of templatemo_body_wrapper2 -->
<div id="templatemo_footer_wrapper2">
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