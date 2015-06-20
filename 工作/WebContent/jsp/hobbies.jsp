<%-- 
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    hobbies.jsp
 *作者:	   李东池
 *日期:	 22/05/2015 
 *文件描述:   选择爱好的页面
 *修改历史:
           日期1 22/05/2015    李东池	   创建.
           日期2 25/05/2015  蒲孟  修改--%>
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
         <form action="/Joinus/RegisterhServlet" method="post" enctype="multipart/form-data" name="form2" id="form2">
             <fieldset>
             <legend>请填入真实信息</legend>
             <table width="788" border="0" align="center">
             <tr>
             <td colspan="2" >您的城程号：
              <c:if test="${empty requestScope.uccid }">
      	          	<input type="text" name="uccid" readonly id="uccid">
              	</c:if>
              	<c:if test="${!empty requestScope.uccid }">
      				<input type="text" name="uccid" readonly id="uccid" value="${requestScope.uccid }"></c:if>
      				</td></tr>
              <tr>
                <td height="28"><div align="right">爱好</div></td>
                <td height="28">
               <p>&nbsp;</p>
                <p>休闲娱乐：
                  <label><input type="checkbox" name="checkbox" id="checkbox" value="1" />逛街&nbsp; &nbsp;</label> 
                  <label><input type="checkbox" name="checkbox" id="checkbox2" value="2"/> KTV&nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox3" value="3" />游乐游艺&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox4" value="4"/>养生&nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox5" value="5"/>DIY手工</label>
                <label><input type="checkbox" name="checkbox" id="checkbox6" value="6"/></label><label>其他</label>
                </p>
                <p>音乐：            
                  <label> &nbsp; &nbsp; &nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox7" value="7"/></label>演唱会
                <label><input type="checkbox" name="checkbox" id="checkbox8" value="8"/></label>演奏会
                  <label><input type="checkbox" name="checkbox" id="checkbox9" value="9"/></label>组乐队
                  <label><input type="checkbox" name="checkbox" id="checkbox10" value="10"/>组舞团</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox11" value="11"/></label>其他
                  </p>
                <p>
                  <label> </label>体育：&nbsp; &nbsp;&nbsp; &nbsp;<label>
                  <input type="checkbox" name="checkbox" id="checkbox12" value="12"/></label>看球赛 <label>
                  <input type="checkbox" name="checkbox" id="checkbox13" value="13"/></label>组球队 <label>
                  <input type="checkbox" name="checkbox" id="checkbox14" value="14"/></label>健身&nbsp; &nbsp;<label>
                  <input type="checkbox" name="checkbox" id="checkbox15" value="15"/></label>其他
                  </p>
                <p>
                  <label>学业：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox16" value="16"/></label>听讲座 
                  <label><input type="checkbox" name="checkbox" id="checkbox17" value="17"/></label>组自习 
                  <label><input type="checkbox" name="checkbox" id="checkbox18" value="18"/></label>找课友 
                  <label><input type="checkbox" name="checkbox" id="checkbox19" value="19"/></label>参赛组队
                  <label><input type="checkbox" name="checkbox" id="checkbox20" value="20"/></label>其他
                  </p>
                <p>
                  <label>美食：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox21" value="21"/>美食</label>
                </p>
                <p>
                  <label>购物：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox22" value="22"/>购物</label>
                  <label>&nbsp; &nbsp; &nbsp; </label>
                  <label>&nbsp;</label>
                </p>
                <p>
                  <label>出游：&nbsp; &nbsp; &nbsp;&nbsp; </label>
                  <label><input type="checkbox" name="checkbox" id="checkbox23" value="23" />出游 </label>
                </p>
                <p>合租：
                  <label>&nbsp; &nbsp; &nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox24" value="24"/>合租 </label>
				</p>
                <p>其他：
                  <label>&nbsp; &nbsp; &nbsp;</label>
                  <label><input type="checkbox" name="checkbox" id="checkbox25" value="25"/>其他</label>
<label><br/>
</label>
              </p></td>
              </tr>
            <tr  align="center"><td>
            		<input type="button" name="btnSelelectAll" id="btnSelelectAll" onClick="javascript:selectAllCheckBox('checkbox');" value="全选"/>&nbsp;
  					<input type="button" name="btnReverseSelelect" id="btnReverseSelelect" onClick="javascript:selectReverseCheckBox('checkbox');" value="反选"/>&nbsp;
            
            </td></tr>
              <tr >
                <td height="28" colspan="2"><label>
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
              <input type="submit" name="button" id="button" class="tj"value="" />
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