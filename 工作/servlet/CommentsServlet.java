/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    CommentsServlet.java
 *作者:	        李宛恒
 *日期:	     May 20, 2015
 *文件描述:   为评论这一行为服务
 *修改历史:
           日期1 20/5/2015  李宛恒  创建
           日期2 28/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IActivityCommentBiz;
import edu.newdesign.joinus.biz.ICommentsBiz;
import edu.newdesign.joinus.biz.IShowActInIndexBiz;
import edu.newdesign.joinus.biz.impl.ActivityCommentBizImpl;
import edu.newdesign.joinus.biz.impl.CommentsBizImpl;
import edu.newdesign.joinus.biz.impl.ShowActInIndexBizImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.Comments;
import edu.newdesign.joinus.po.Users;
import edu.newdesign.joinus.vo.ShowActInIndex;

/**
 * Servlet implementation class CommentsServlet
 */
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServlet() {
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
		
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    int cuser_to = Integer.parseInt(request.getParameter("cuser_to"));
	    
	    String content = request.getParameter("content").trim();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String cuser = user.getUccid();
		
		Date cdate = new Date();
		
		Comments comments = new Comments();
		comments.setCact(aid);
		comments.setCcontent(content);
		comments.setCuser_from(cuser);
		comments.setCuser_to(cuser_to);
		comments.setCdate(cdate);
		
		ICommentsBiz commentsBiz = new CommentsBizImpl();
		boolean flag = commentsBiz.comments(comments);
		
		if (flag) {
			
			IActivityCommentBiz  iActivityCommentBiz = new  ActivityCommentBizImpl();
			//判断评论是回复给用户的还是评论活动的
			if(cuser_to!=0){
			  if(  !iActivityCommentBiz.toYou(aid, cuser, cuser_to))
			     System.out.println("出错");
			
			}else{
				 if(! iActivityCommentBiz.toYourActivity(aid, cuser))
				  System.out.println("出错");
			}
			iActivityCommentBiz.tocom(aid);
		    Activities act = iActivityCommentBiz.toComment(aid);
		    request.setAttribute("act", act);
		    IShowActInIndexBiz 	iShowActInIndexBiz = new ShowActInIndexBizImpl();
			List<ShowActInIndex>  lstp = iShowActInIndexBiz.selectActByAid(aid);
			request.setAttribute("lstp", lstp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/comments.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("回复失败！");
		}
	}
}
