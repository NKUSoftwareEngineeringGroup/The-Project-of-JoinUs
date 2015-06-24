/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    FindFriendsServlet.java
 *作者:	        李宛恒
 *日期:	     May 20, 2015
 *文件描述:  系统推荐同单位和好友的好友的服务
 *修改历史:
           日期1 20/5/2015  李宛恒  创建
           日期2 28/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IFindFriendsBiz;
import edu.newdesign.joinus.biz.impl.FindFriendsBizImpl;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class FindFriendsServlet
 */
public class FindFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFriendsServlet() {
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
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();
		IFindFriendsBiz findFriendBiz = new FindFriendsBizImpl();
		List<Users> lsts = findFriendBiz.findFriends(uccid);
		request.setAttribute("lsts", lsts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/FindFriends.jsp");

		dispatcher.forward(request, response);
	}

}
