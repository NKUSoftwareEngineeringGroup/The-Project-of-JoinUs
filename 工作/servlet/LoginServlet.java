/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    LoginServlet.java
 *作者:	       李宛恒
 *日期:	     May 21, 2015
 *文件描述:   提供登陆服务
 *修改历史:
           日期1 21/5/2015  李宛恒  创建
           日期2 29/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.ILoginBiz;
import edu.newdesign.joinus.biz.impl.LoginBizImpl;
import edu.newdesign.joinus.po.Users;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		// 获取客户端传入的数据
		String uccid = request.getParameter("uccid").trim();
		String upwd = request.getParameter("upwd").trim();
		HttpSession session = request.getSession();
		String rand = (String)session.getAttribute("rand"); 
		String input = request.getParameter("rand"); 
		if(rand.equals(input)){
		// 单点登录验证
		// 获取全局Application级别的用户在线列表
		List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
		if(usersOnLineList == null){
			usersOnLineList = new ArrayList<String>();
		}
		// 判断当前登录用户是否存在于该在线列表中
		boolean singleLoginFlag;
		if(usersOnLineList.contains(uccid)){
			singleLoginFlag = true;
		}else{
			singleLoginFlag = false;			
		}
		
		if(!singleLoginFlag){
			// 调用Biz层实现数据库验证
			ILoginBiz loginBiz = new LoginBizImpl();
			Users user = loginBiz.isLogin(uccid, upwd);
			// 响应客户端		
			int msgcode = user == null ? 101 : 102;
			String url = "";
			switch (msgcode) {
			case 101:
				url = "jsp/login.jsp";
				request.setAttribute("msgcode", msgcode);
				break;
			case 102:
				url = "ShowInIndexServlet";
			
				// 将登录的用户添加到在线列表中
				usersOnLineList.add(user.getUccid());
				// 刷新在线用户列表
				this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);
				session.setAttribute("user", user);
				break;
			default:
				break;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			int msgcode = 103;
			request.setAttribute("msgcode", msgcode);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		}else{ 
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请输入正确的验证码！');location='/chengcheng/jsp/login.jsp';</script>"); 
		} 
		

	}

}
