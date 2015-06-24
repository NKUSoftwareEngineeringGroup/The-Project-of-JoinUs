/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    LogoutServlet.java
 *作者:	        李宛恒
 *日期:	    May 21, 2015
 *文件描述:   提供注销服务
 *修改历史:
           日期1 21/5/2015  李宛恒  创建
           日期2 29/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.po.Users;


/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤1：通过session获取登录的账号
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		// 步骤2：销毁session
		session.removeAttribute("user");
		session.invalidate();
		// 步骤3：从在线列表中移除当前登录账号
		List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
		usersOnLineList.remove(user.getUccid());  // 移除
		this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);  // 刷新在线列表
		// 步骤4：页面跳转
		response.sendRedirect("jsp/login.jsp");
		
	}

}
