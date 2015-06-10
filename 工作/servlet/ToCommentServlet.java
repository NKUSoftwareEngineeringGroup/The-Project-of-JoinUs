/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ToCommentServlet.java
*作者:	          金悦
 *日期:	   2015-05-20
 *文件描述: 发布活动servlet
 *修改历史:
    日期1 2015-05-20     金悦	   创建.
 */
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.newdesign.joinus.biz.IActivityCommentBiz;
import edu.newdesign.joinus.biz.IShowActInIndexBiz;
import edu.newdesign.joinus.biz.impl.ActivityCommentBizImpl;
import edu.newdesign.joinus.biz.impl.ShowActInIndexBizImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.vo.ShowActInIndex;

/**
 * Servlet implementation class ToCommentServlet
 */
public class ToCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToCommentServlet() {
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
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    IActivityCommentBiz   iActivityCommentBiz = new   ActivityCommentBizImpl();
	    Activities act = iActivityCommentBiz.toComment(aid);
	    request.setAttribute("act", act);
	    IShowActInIndexBiz 	iShowActInIndexBiz = new ShowActInIndexBizImpl();
		List<ShowActInIndex>  lstp = iShowActInIndexBiz.selectActByAid(aid);
		request.setAttribute("lstp", lstp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/comments.jsp");
		dispatcher.forward(request, response);
	}

}
