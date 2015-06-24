/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    AddFriendsServlet.java
 *作者:	        李宛恒
 *日期:	     May 20, 2015
 *文件描述:  同意添加好友服务
 *修改历史:
           日期1 20/5/2015  李宛恒  创建
           日期2 28/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IAddFriendsBiz;
import edu.newdesign.joinus.biz.INewsBiz;
import edu.newdesign.joinus.biz.IWantFriendBiz;
import edu.newdesign.joinus.biz.impl.AddFriendsBizImpl;
import edu.newdesign.joinus.biz.impl.NewsBizImpl;
import edu.newdesign.joinus.biz.impl.WantFriendBizImpl;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class AddFriendsServlet
 */
public class AddFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();		
        String ufid = request.getParameter("uccid").trim();
        int type = Integer.parseInt(request.getParameter("type").trim());
     
	    if(type==0){
			IAddFriendsBiz addFriendsBiz = new AddFriendsBizImpl();
			addFriendsBiz.addFriends(ufid, uccid);
			int msgcode =  addFriendsBiz.addFriends(uccid, ufid);
			
			if(msgcode==0)
				System.out.println("添加好友失败");
			//之前不是好友则添加成功，之前若是好友则提醒用户
			else if(msgcode==1){
                 PrintWriter out = response.getWriter();
                 INewsBiz newsBiz =new NewsBizImpl();
                if( newsBiz.deleteFri(ufid)>0){
                	IWantFriendBiz wantFriendBiz = new WantFriendBizImpl();
                	if(wantFriendBiz.agreeToMakeFriend(uccid, ufid)){
                   out.println("<script>alert('添加好友成功！')</script>");
				   out.println("<script>location='/chengcheng/ShowInAboutMeServlet'</script>");
				   out.flush();
				   out.close();}
                	System.out.println("出错");
                }
               System.out.println("出错");
			}else{
				   String url= request.getHeader("Referer");
				   PrintWriter out = response.getWriter();
				   INewsBiz newsBiz =new NewsBizImpl();
				   newsBiz.deleteFri(ufid);
				   out.println("<script>alert('您和该用户已经是好友了！')</script>");
				  
				   out.println("<script>location="+url+"</script>");
				   out.flush();
				   out.close();
			}
	    }else{
	    	 PrintWriter out = response.getWriter();
            INewsBiz newsBiz =new NewsBizImpl();
            if( newsBiz.deleteFri(ufid)>0){
            	IWantFriendBiz wantFriendBiz = new WantFriendBizImpl();
            	if(wantFriendBiz.refuseToMakeFriend(uccid, ufid)){
            	 out.println("<script>location='/chengcheng/ShowInAboutMeServlet'</script>");
				   out.flush();
				   out.close();}
            	System.out.println("出错");
            	
            }
            System.out.println("出错");
	    }
		
	}

}
