/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IsSamePwdServlet.java
 *作者:	         李宛恒
 *日期:	     May 21, 2015
 *文件描述:   判断两次输入的密码是否一致的服务
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

import edu.newdesign.joinus.biz.IRegisterBiz;
import edu.newdesign.joinus.biz.impl.RegisterBizImpl;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class IsDoubleServlet
 */
public class IsSamePwdServlet  extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IsSamePwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {

	  response.reset();
	  request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	 //业务根据uccid查询是否已经存在,以及原密码是否正确
	  IRegisterBiz registerBiz = new RegisterBizImpl();
	  HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		String uccid = user.getUccid();
		System.out.println(uccid);
	  String upwdformer=request.getParameter("upwdformer");
	  System.out.println(upwdformer);
	  if(registerBiz.checkUpwd(uccid, upwdformer))
    	  response.getWriter().print(true);
      else response.getWriter().print(false);
	 }
	}
