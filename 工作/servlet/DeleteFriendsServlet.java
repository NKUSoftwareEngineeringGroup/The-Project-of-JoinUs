/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    DeleteFriendsServlet.java
 *作者:	       李宛恒
 *日期:	    May 20, 2015
 *文件描述: 提供删除好友的服务
 *修改历史:
           日期1 20/5/2015  李宛恒  创建
           日期2 28/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IAddFriendsBiz;
import edu.newdesign.joinus.biz.impl.AddFriendsBizImpl;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class deleteFriendsServlet
 */
public class DeleteFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("werwerwer");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		System.out.println("1111111111");
		String uccid = user.getUccid();		
        String ufid = request.getParameter("uccid").trim();
        System.out.println("sdfsdfsdf");
        IAddFriendsBiz addFriendsBiz = new AddFriendsBizImpl();
        if(addFriendsBiz.deleteFriends(uccid, ufid))
        	response.sendRedirect("/chengcheng/FriendServlet");
        System.out.println("删除好友出错");
        	
	}

}
