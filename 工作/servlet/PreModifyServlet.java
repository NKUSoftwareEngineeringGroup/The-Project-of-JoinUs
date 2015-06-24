/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    PreModifyServlet.java
 *作者:	       李宛恒
 *日期:	    May 21, 2015
 *文件描述: 提供修改个人信息的服务
 *修改历史:
            日期1 21/5/2015  李宛恒  创建
            日期2 29/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import edu.newdesign.joinus.po.Users;


/**
 * Servlet implementation class RegisterServlet
 */
public class PreModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreModifyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤1：设置上传文件的参数
		// 1-1：设置服务器接受上传文件的位置（服务器的文件夹）
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

	
			try {		
				// 准备modify页面之前的用户信息
				HttpSession session = request.getSession();
				Users user=(Users) session.getAttribute("user");
				String uccid = user.getUccid();
				String uname = user.getUname();
				String uorg = user.getUorg();
				String utele = user.getUtele();
				String uadd = user.getUadd();
				String uQQ = user.getUqq();
				// 根据返回值结果进行页面跳转
			
					// 跳转至登录页面
					request.setAttribute("uccid", uccid);
					request.setAttribute("uname",uname);
					request.setAttribute("uorg",uorg);
					request.setAttribute("utele",utele);
					request.setAttribute("uadd",uadd);
					request.setAttribute("uQQ",uQQ);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/modify.jsp");
					dispatcher.forward(request, response);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

}
}
