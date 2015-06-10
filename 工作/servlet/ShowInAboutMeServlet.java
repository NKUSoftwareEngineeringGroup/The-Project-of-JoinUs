/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowInAboutMeServlet.java
 *作者:	          金悦
 *日期:	   2015-05-19
 *文件描述: 发布活动servlet
 *修改历史:
    日期1 2015-05-19     金悦	   创建.
 */
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IShowInMeBiz;
import edu.newdesign.joinus.biz.impl.ShowInMeBizImpl;
import edu.newdesign.joinus.po.News;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class ShowInAboutMe
 */
public class ShowInAboutMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInAboutMeServlet() {
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
		List<News> lstNews = new ArrayList<News>();
		IShowInMeBiz showInMeBiz = new ShowInMeBizImpl();
         lstNews = showInMeBiz.showInMe(uccid);
         if(lstNews!=null){
            request.setAttribute("lstNews", lstNews);
     	    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/aboutme.jsp");
		    dispatcher.forward(request, response);
         }else{
        	 System.out.println("出错");
         }
	}

}
