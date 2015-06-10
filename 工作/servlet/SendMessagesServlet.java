/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SendMessagesServlet.java
 *作者:	          金悦
 *日期:	   2015-05-26
 *文件描述: 发布活动servlet
 *修改历史:
         日期1 2015-05-26     金悦	   创建.
 */
package edu.newdesign.joinus.servlet;

import java.io.IOException;





















import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.NewsDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.News;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class SendMessagesServlet
 */
public class SendMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessagesServlet() {
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
		
	    String nuser=request.getParameter("nuser");
	    String content = request.getParameter("text").trim();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String nfrom = user.getUccid();
		
		int type=0;
		
		IUsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.selectById(nfrom);
		content = users.getUname()+"/"+users.getUphoto()+"/"+content;
		News news=new News();
		news.setNfrom(nfrom);
		news.setNuser(nuser);
		news.setNcontent(content);
		news.setNtype(type);
     
		
		INewsDao inewsDao =new NewsDaoImpl();
		int flag = inewsDao.insert(news);
		if(flag>0){
			String url = "/FriendServlet";
//			response.sendRedirect(url);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/friends.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("回复失败！");
		}
	}

}
