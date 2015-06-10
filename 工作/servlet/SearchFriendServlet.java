/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SearchFriendServlet.java
  *作者:	          金悦
 *日期:	   2015-05-25
 *文件描述: 发布活动servlet
 *修改历史:
            日期1 2015-05-25     金悦	   创建.
 */
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
 * Servlet implementation class SearchFriendServlet
 */
public class SearchFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFriendServlet() {
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
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();
		String keyword=new String(request.getParameter("searchfri").getBytes("ISO-8859-1"));
		IFriendBiz friendBiz = new FriendBizImpl();
		List<ShowUserFriend> lstFri = friendBiz.searchFriend(uccid, keyword);
		request.setAttribute("lstFri", lstFri);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/friends.jsp");
		dispatcher.forward(request, response);
	}

}
