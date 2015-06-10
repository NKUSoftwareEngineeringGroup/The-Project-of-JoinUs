/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SearchNewFriendServlet.java
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

import edu.newdesign.joinus.biz.ISearchNewFriendBiz;
import edu.newdesign.joinus.biz.impl.SearchNewFriendBizImpl;
import edu.newdesign.joinus.po.Users;


/**
 * Servlet implementation class SearchNewFriendServlet
 */
public class SearchNewFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNewFriendServlet() {
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
		System.out.println("sdfsdfsgsegtrsht"+keyword);
	    ISearchNewFriendBiz searchNewFriendBiz = new SearchNewFriendBizImpl();
	    List<Users> lsts = searchNewFriendBiz.addNew(uccid, keyword);
		request.setAttribute("lsts", lsts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/FindFriends.jsp");
		dispatcher.forward(request, response);
	}

}
