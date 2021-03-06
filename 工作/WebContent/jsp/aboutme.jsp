<%-- 
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    aboutme.jsp
 *作者:	   李东池
 *日期:	   23/05/2015     
 *文件描述:   个人主页页面
 *修改历史:
           日期1 23/05/2015          李东池	   创建
           日期2 24/05/2015  蒲孟  修改--%>
<%@page import="edu.newdesign.joinus.vo.ShowActInIndex"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="edu.newdesign.joinus.po.News"%>
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
<script type="text/javascript">
function deleteMessage(id){
	if(confirm("确定删除该信息吗?删除后将无法还原")){
	location="/Joinus/DeleteNewsServlet?nid="+id;
	}
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
        <form action="#" method="get">
          <input type="text" value="" name="username" size="10" id="input_field" title="usernmae" />
          <input type="submit" name="login" value="Search" alt="login" id="submit_btn" title="Login" />
        </form>
      </div>
      <ul>
        <li><a href="/Joinus/ShowInIndexServlet"> 首页</a></li>
        <li><a href="/Joinus/ShowInPersonalServlet">个人主页</a></li>
        <li><a href="/Joinus/FriendServlet">好友</a></li>
        <li></li>
           <li><a href="/Joinus/ShowInActivityCircleServlet?type=0">活动</a></li>
        <li><a href="/Joinus/jsp/chatrooms.jsp">聊天室</a></li>
       <li>   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;                               
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
      </div>      <!-- end of templatemo_sidebar_wrapper -->
      <div id="templatemo_content">
       <div id="content_top"></div>
        <div id="content_middle">
          <h3>与我相关</h3>
           <%
          List<News> lstNews = (List<News>) request.getAttribute("lstNews");
       	Collections.sort(lstNews, new Comparator<News>() {
			@Override
			public int compare(News o1, News o2) {
				// TODO Auto-generated method stub
				return o2.getNdate().compareTo(o1.getNdate());
			}
		});
          if(lstNews!=null&&!lstNews.isEmpty()){
        	  
          for(News news:lstNews){
            int type = news.getNtype();
           
            %>
            <table width="720" border="1" style="border-style:none;">
            <tr>
              <td>
            <% if(type==1){	
            	 String[] content = news.getNcontent().split("/");
                 String uccid = content[0];
                 String uname = content[1];
             	String uphoto = content[2];
             	int aid = Integer.parseInt(content[3]);
             	String aname  = content[4];
          	  %>
         <div>提醒：<a href="/Joinus/ShowInOthersServlet?uccid=<%=uccid%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>参加了您参加的<a href="/Joinus/ToCommentServlet?aid=<%=aid%>"><%=aname %></a>活动</div>  
                    </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
         <%}else if(type==2){
         String[] content = news.getNcontent().split("/");
         String uccid = content[0];
         String uname = content[1];
     	 String uphoto = content[2];
     	 int aid = Integer.parseInt(content[3]);
     	 String aname  = content[4]; %>
         <div>提醒： <a href="/Joinus/ShowInOthersServlet?uccid=<%=uccid%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate()%>在您发布的<a href="/Joinus/ToCommentServlet?aid=<%=aid%>"><%=aname %></a>活动下留了新留言</div>  
                   </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
 
          <%}else if(type==3) {
        	String[] content = news.getNcontent().split("/");
            String uccid = content[0];
            String uname = content[1];
        	String uphoto = content[2];
        	int aid = Integer.parseInt(content[3]);
        	String aname  = content[4];%>
          <div>提醒： <a href="/Joinus/ShowInOthersServlet?uccid=<%=uccid%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>回复了您在<a href="/Joinus/ToCommentServlet?aid=<%=aid%>"><%=aname %></a>活动中的留言</div>  
                     </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
          <%}else if(type==0){
        	  String[] content = news.getNcontent().split("/");
        	  String uname = content[0];
        	  String uphoto = content[1];
        	  String ncontent= content[2];%>
     <div>好友： <a href="/Joinus/ShowInOthersServlet?uccid=<%=news.getNfrom()%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>悄悄告诉你：<%=ncontent %></div>  
                       </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
          <%}else if(type==4){ 
        	  String[] content = news.getNcontent().split("/");
        	  String uname = content[0];
        	  String uphoto = content[1];
           %><div>好友： <a href="/Joinus/ShowInOthersServlet?uccid=<%=news.getNfrom()%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>想要加您为好友 </div> 
            </td><td width="50">
            <input type="button" id="friend" name="friend" onclick="location = '/Joinus/AddFriendsServlet?uccid=<%=news.getNfrom() %>&type=0';" value="同意">
            <input type="button" id="friend2" name="friend2" onclick="location = '/Joinus/AddFriendsServlet?uccid=<%=news.getNfrom() %>&type=1';" value="不同意">
            
           <%}else if(type==5){ 
        	  String[] content = news.getNcontent().split("/");
         	  String uname = content[0];
         	  String uphoto = content[1];
            %><div>好友： <a href="/Joinus/ShowInOthersServlet?uccid=<%=news.getNfrom()%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>同意加您为好友</div>  
        	           </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
        	<%}else if(type==6){ 
        		  String[] content = news.getNcontent().split("/");
             	  String uname = content[0];
             	  String uphoto = content[1];
                %>
              <div>好友： <a href="/Joinus/ShowInOthersServlet?uccid=<%=news.getNfrom()%>"> <img src="/Joinus/upload/images/photo/<%=uphoto%>"  alt="" width="50" height="50" align="middle"/></a><%=uname %>于<%=news.getNdate() %>拒绝加您为好友</div>  
                       </td>
           <td width="50">
           <input type="button" name="delete" id="delete" value="删除消息" onclick="javascript:deleteMessage('<%=news.getNid()%>')">
            <%} %>
 
           </td>
            </tr>
           </table>
         <%}}else{%>
          <table width="720" border="0" style="border-style:none;">
            <tr>
              <td>
               </td>
            </tr>
           </table>
         <%} %>
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
                <a href="/Joinus/ShowActByAdminServlet">更多</a> </h4>          
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