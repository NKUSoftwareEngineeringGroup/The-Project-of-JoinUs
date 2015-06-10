/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowInActivityCircleServlet.java
 *作者:	          金悦
 *日期:	   2015-05-19
 *文件描述: 发布活动servlet
 *修改历史:
   日期1 2015-05-19     金悦	   创建.
 */
package edu.newdesign.joinus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.newdesign.joinus.biz.IShowActTagBiz;
import edu.newdesign.joinus.biz.impl.ShowActTagBizImpl;
import edu.newdesign.joinus.po.Tags;
import edu.newdesign.joinus.po.Users;
import edu.newdesign.joinus.vo.ShowActTag;

public class ShowInActivityCircleServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInActivityCircleServlet() {
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
		int type=Integer.parseInt(request.getParameter("type"));
		//判断是从哪个表单传到servlet的(index默认传，或选择按时间排序)
		IShowActTagBiz iShowActTagBiz = new ShowActTagBizImpl();
		if(type==0||type==1){		
		List<ShowActTag>  lstActTag = iShowActTagBiz.selectAct(uccid);
		List<Tags> lstActHobby = iShowActTagBiz.selectHobby(uccid);
		Iterator<ShowActTag> iter = lstActTag.iterator();   
		while(iter.hasNext()){   
		    ShowActTag s = iter.next();   
		    if(s.getOwner_id().equals(uccid)){   
		        iter.remove();   
		    }   
		}   	
		request.setAttribute("lstActTag", lstActTag);
		request.setAttribute("lstActHobby", lstActHobby);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activitycircle.jsp");
		dispatcher.forward(request, response);}
		//选择按热度排序
		if(type==2){       
		List<ShowActTag> lstActTag = iShowActTagBiz.selectActByheat(uccid);
		List<Tags> lstActHobby = iShowActTagBiz.selectHobby(uccid);
		Iterator<ShowActTag> iter = lstActTag.iterator();   
		while(iter.hasNext()){   
		    ShowActTag s = iter.next();   
		    if(s.getOwner_id().equals(uccid)){   
		        iter.remove();   
		    }   
		}   
		request.setAttribute("lstActTag", lstActTag);
		request.setAttribute("lstActHobby", lstActHobby);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activitycircle.jsp");
		dispatcher.forward(request, response);	
		}
		if(type==3){       //按评论人数排序
			List<ShowActTag> lstActTag = iShowActTagBiz.selectActBycomm(uccid);
			List<Tags> lstActHobby = iShowActTagBiz.selectHobby(uccid);
			Iterator<ShowActTag> iter = lstActTag.iterator();   
			while(iter.hasNext()){   
			    ShowActTag s = iter.next();   
			    if(s.getOwner_id().equals(uccid)){   
			        iter.remove();   
			    }   
			}   
			request.setAttribute("lstActTag", lstActTag);
			request.setAttribute("lstActHobby", lstActHobby);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activitycircle.jsp");
			dispatcher.forward(request, response);	
			}
		if(type==4){      //按参加人数排序
			List<ShowActTag> lstActTag = iShowActTagBiz.selectActBycurr(uccid);
			List<Tags> lstActHobby = iShowActTagBiz.selectHobby(uccid);
			Iterator<ShowActTag> iter = lstActTag.iterator();   
			while(iter.hasNext()){   
			    ShowActTag s = iter.next();   
			    if(s.getOwner_id().equals(uccid)){   
			        iter.remove();   
			    }   
			}   
			request.setAttribute("lstActTag", lstActTag);
			request.setAttribute("lstActHobby", lstActHobby);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activitycircle.jsp");
			dispatcher.forward(request, response);	
			}
		if(type==5){      //按选择的爱好显示		
			String[] chk = request.getParameterValues("checkbox");
			List<Integer> lstTid =new ArrayList<Integer>();
			if(chk!=null)
			{
			for (int i = 0; i < chk.length; i++) {
				int tid=Integer.parseInt(chk[i]);
				lstTid.add(tid);
			}}
			List<ShowActTag> lstActTag = iShowActTagBiz.selectActByhobby(lstTid);
			List<Tags> lstActHobby = iShowActTagBiz.selectHobby(uccid);
			Iterator<ShowActTag> iter = lstActTag.iterator();   
			while(iter.hasNext()){   
			    ShowActTag s = iter.next();   
			    if(s.getOwner_id().equals(uccid)){   
			        iter.remove();   
			    }   
			}   
			request.setAttribute("lstActTag", lstActTag);
			request.setAttribute("lstActHobby", lstActHobby);
			request.setAttribute("lstTid", lstTid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activitycircle.jsp");
			dispatcher.forward(request, response);	
			}
		
	}

}
