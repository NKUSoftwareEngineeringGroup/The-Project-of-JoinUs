/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    FriendServlet.java
 *作者:	        李宛恒
 *日期:	     May 21, 2015
 *文件描述:  提供返回全部好友信息的服务
 *修改历史:
           日期1 21/5/2015  李宛恒  创建
           日期2 29/5/2015  李宛恒  修改
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

import edu.newdesign.joinus.biz.IFriendBiz;
import edu.newdesign.joinus.biz.impl.FriendBizImpl;
import edu.newdesign.joinus.po.Users;
import edu.newdesign.joinus.vo.ShowUserFriend;

/**
 * Servlet implementation class FriendServlet
 */
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();
		IFriendBiz iFriendBiz = new FriendBizImpl();
		List<ShowUserFriend> lstFri = iFriendBiz.showFriend(uccid);
		request.setAttribute("lstFri", lstFri);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/friends.jsp");
		dispatcher.forward(request, response);
		
	}

}
