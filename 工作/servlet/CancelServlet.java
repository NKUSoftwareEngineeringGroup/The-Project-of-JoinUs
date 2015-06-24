/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:     CancelServlet.java
 *作者:	          李宛恒
 *日期:	      May 20, 2015
 *文件描述:   取消发布的活动服务
 *修改历史:
           日期1 20/5/2015  李宛恒  创建
           日期2 28/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import edu.newdesign.joinus.biz.IActivitiesBiz;
import edu.newdesign.joinus.biz.IBelongBiz;
import edu.newdesign.joinus.biz.ICommentsBiz;
import edu.newdesign.joinus.biz.IParticipateBiz;
import edu.newdesign.joinus.biz.impl.ActivitiesBizImpl;
import edu.newdesign.joinus.biz.impl.BelongBizImpl;
import edu.newdesign.joinus.biz.impl.CommentsBizImpl;
import edu.newdesign.joinus.biz.impl.ParticipateBizImpl;



/**
 * Servlet implementation class CancelServlet
 */
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelServlet() {
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
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    String url= request.getHeader("Referer");
	    //System.out.println("url");
	    IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		iParticipateBiz.cancelActivity(aid);
		IActivitiesBiz activitiesBiz =new ActivitiesBizImpl();
	    IBelongBiz belongBiz = new BelongBizImpl();
	    ICommentsBiz commentsBiz = new CommentsBizImpl();
	    if(belongBiz.delete(aid)&& commentsBiz.deleteComments(aid)){
		if(activitiesBiz.deleteActivities(aid)>0){
	        response.sendRedirect(url);
		}else{
			System.out.println("出错");
		}
	    }
	}

}
