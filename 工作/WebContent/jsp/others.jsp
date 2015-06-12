 <%--
  Copyright (c) 2015 NewDesign, All Rights Reserved.
    文件名:  others.jsp
    作者:	   蒲孟
    日期:	   01/6/2015
    文件描述: 发布活动业务逻辑
    修改历史:
           日期1 01/6/2015 蒲孟	   创建
           

  --%> 
<%@page import="edu.newdesign.joinus.vo.ShowUserFriend"%>
<%@page import="edu.newdesign.joinus.biz.impl.FriendBizImpl"%>
<%@page import="edu.newdesign.joinus.biz.IFriendBiz"%>
<%@page import="edu.newdesign.joinus.po.Users"%>
<%@page import="edu.newdesign.joinus.dao.impl.UsersDaoImpl"%>
<%@page import="edu.newdesign.joinus.dao.IUsersDao"%>
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
<script type="text/javascript">
function addFriend(fccid){
	location="/Joinus/WantFriendServlet?uccid="+fccid;
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
<div id="templatemo_body_wrapper3">
  <div id="templatemo_wrapper3">
    <div id="templatemo_header">
     <div id="site_title"> <a href="#" ><img src="/Joinus/images/logo.png" width="103" height="97" /><span>Joinus</span> </a> </div>
    </div>
    <!-- end of templatemo_header -->
    <div id="templatemo_menu3">
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
        <li><a href="/Joinus/ShowInPersonalServlet"class="current">个人主页</a></li>
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
          <% 
          Users users = (Users)session.getAttribute("user");
          List<ShowActInIndex> lstAct =(List<ShowActInIndex>) request.getAttribute("lstAct"); 
          ShowActInIndex act = lstAct.get(0);
          IUsersDao iUsersDao = new UsersDaoImpl();
          Users u = iUsersDao.selectById(act.getUccid());
          IFriendBiz iFriendBiz = new FriendBizImpl();
  		  List<ShowUserFriend> lstFri = iFriendBiz.showFriend(users.getUccid());
          %>
            <p><span> <img src="/Joinus/upload/images/photo/<%=act.getUphoto()%>" width=100% height="158" /><img src="/Joinus/images/xrw.png" width="27" height="29" /><%=act.getUname() %></span></p>
          <%for(int i =0;i<lstFri.size();i++){
        	  if(lstFri.get(i).getFccid().equals(act.getUccid())){%>
        		  <p><img src="/Joinus/images/bfri1.png" width="100%" height="31"  alt=""/></p>
         <%	 break; }else{
        	 if(i==lstFri.size()-1){%>
        		 <p><img src="/Joinus/images/bfri.png" width="100%" height="31" onClick="javascript:addFriend('<%=act.getUccid() %>');" alt=""/></p>
        <%	 }
         }
          } %>  
        </div>
        </div>
          <div class="sidebar_box">
            <h2>详细资料</h2>
          <table width="200" border="0" style="margin:auto">
            <%if(u.getUorg()!=null){ %>
                <tr>
                  <td width="57">学校/单位</td>
                  <td width="133"><%=u.getUorg() %></td>
                </tr>
             <%} %>
             <%if(u.getUbirth()!=null){ %>
                <tr>
                  <td>出生日期</td>
                  <td><%=u.getUbirth() %></td>
                </tr>
             <%} %>
             <%if(u.getUtele()!=null){ %>
                <tr>
                  <td>电话号码</td>
                  <td><%=u.getUtele() %></td>
                </tr>
             <%} %>   
             <%if(u.getUqq()!=null){ %>
                <tr>
                  <td>qq号码</td>
                  <td><%=u.getUqq() %></td>
                </tr>
             <%} %>
             <%if(u.getUcity()!=null){ %>
                <tr>
                  <td>现居城市</td>
                  <td><%=u.getUcity() %></td>
                </tr>
             <%} %>
             <%if(u.getUadd()!=null){ %>
                <tr>
            
                  <td>详细住址</td>
                  <td><%=u.getUadd() %></td>
                </tr>
            <%} %>
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
           <h3>行程表</h3>
          <c:if test="${!empty requestScope.lstAct1}">
           <table width="100%" border="0">
          <%List<ShowActInIndex> lstAct1 = (List<ShowActInIndex>)request.getAttribute("lstAct1");
          int i=0;
           for (ShowActInIndex act1 : lstAct1){
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
           String n = formatter.format(new Date()) ;
           if((formatter.format(act1.getAdate()).compareTo(n))>0){ 
           if(act1.getPtype()==1){%>
              <tr>
               <td width="14%" align="left"><%=act1.getPdate() %></td>
               <td width="55%"><div><a href="/Joinus/ShowInOthersServlet?uccid=<%=act1.getUccid() %>"></a><span><%=act1.getUname() %>参加由<%=act1.getOwner_id() %>发布的：<%=act1.getAname() %></span></div></td>
               <td width="31%" align="center"><a href="/Joinus/ToCommentServlet?aid=<%=act1.getAid() %>">查看详细内容</a></td>
              </tr>
            <%}else{if(act1.getPtype()==0){%>
             <tr>
               <td align="left"><%=act1.getPdate() %></td>
               <td><div><a href="/Joinus/ShowInOthersServlet?uccid=<%=act1.getUccid() %>"></a><span><%=act1.getUname() %>发布了将在<%=act1.getAdate() %>进行的：<%=act1.getAname() %></span></div></td>
               <td align="center"><a href="/Joinus/ToCommentServlet?aid=<%=act1.getAid() %>">查看详细内容</a></td>
             </tr>
            <%}}%>
          </table> 
       <%}
           else{if(i==(lstAct1.size()-1)){%> 
        	   <table width="720" border="0" style="border:none">
               <tr>
                 <td>你还没有活动哦，赶快去<a href="/Joinus/ShowInActivityCircleServlet?type=0">活动圈</a>找一找有趣的活动吧！</td>
               </tr>
              </table>
         <%  }}i++;} %> 
      </c:if>
         <c:if test="${empty requestScope.lstAct1}">
          <table width="720" border="0" style="border:none">
            <tr>
              <td>你还没有活动哦，赶快去<a href="/Joinus/ShowInActivityCircleServlet?type=0">活动圈</a>找一找有趣的活动吧！</td>
            </tr>
           </table>
         </c:if>
         </div>
      <div id="content_bottom"></div>
      <div id="content_top"></div>
        <div id="content_middle">
          <h3>我的活动</h3>
          <c:if test="${!empty requestScope.lstAct}">
           <c:forEach items="${requestScope.lstAct}" var="act">
       <table width="720" border="1">
            <tr>
              <td>
          <div><img src="/Joinus/upload/images/photo/${act.uphoto}" width="50" height="50"  alt=""/><span>${act.uname }于${act.pdate }参加了由${act.owner_id }发布的：</span></div>
         <div>
           <table width="501" border="0" align="center">
             <tr>
               <td width="495"><a href="/Joinus/ToCommentServlet?aid=${act.aid }">活动名称：${act.aname }</a></td>
             </tr>
             <tr>
               <td>活动主题：${act.atopic }</td>
             </tr>
           
           </table>
           
         </div>
            </td>
            </tr>
           </table>
         </c:forEach>
           </c:if>
          <c:if test="${empty requestScope.lstAct}">
          <table width="720" border="0" style="border:none">
            <tr>
              <td>
              </td>
            </tr>
           </table>
         </c:if>
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
  <!-- end of templatemo_wrapper3 -->
  <div class="cleaner"></div>
</div>
<!-- end of templatemo_body_wrapper3 -->
<div id="templatemo_footer_wrapper3">
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