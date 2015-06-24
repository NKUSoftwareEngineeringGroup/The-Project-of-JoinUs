/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    InParticipateServlet.java
 *作者:	         李宛恒
 *日期:	     May 21, 2015
 *文件描述:   取消发布的活动的操作
 *修改历史:
           日期1 21/5/2015  李宛恒  创建
           日期2 29/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import edu.newdesign.joinus.biz.IParticipateBiz;
import edu.newdesign.joinus.biz.impl.ParticipateBizImpl;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class InParticipateServlet
 */
public class InParticipateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InParticipateServlet() {
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
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		if(iParticipateBiz.cancelUser(uccid, aid)){

		response.sendRedirect("/chengcheng/ShowInIndexServlet");
		}else{
			System.out.println("出错");
		}
	}

}
