/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SendcomMessageServlet.java
 *作者:	          金悦
 *日期:	   2015-05-26
 *文件描述: 发布活动servlet
 *修改历史:
     日期1 2015-05-26     金悦	   创建.
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

import edu.newdesign.joinus.biz.IActivityCommentBiz;
import edu.newdesign.joinus.biz.IShowActInIndexBiz;
import edu.newdesign.joinus.biz.impl.ActivityCommentBizImpl;
import edu.newdesign.joinus.biz.impl.ShowActInIndexBizImpl;
import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.NewsDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.News;
import edu.newdesign.joinus.po.Users;
import edu.newdesign.joinus.vo.ShowActInIndex;

/**
 * Servlet implementation class SendcomMessageServlet
 */
public class SendcomMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendcomMessageServlet() {
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

		
		INewsDao inewsDao = new NewsDaoImpl();
		int flag = inewsDao.insert(news);
		
		if(flag>0){
			int aid = Integer.parseInt(request.getParameter("aid"));
		    IActivityCommentBiz   iActivityCommentBiz = new   ActivityCommentBizImpl();
		    Activities act = iActivityCommentBiz.toComment(aid);
		    request.setAttribute("act", act);
		    IShowActInIndexBiz 	iShowActInIndexBiz = new ShowActInIndexBizImpl();
			List<ShowActInIndex>  lstp = iShowActInIndexBiz.selectActByAid(aid);
			request.setAttribute("lstp", lstp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/comments.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("回复失败！");
		}
	}
}
