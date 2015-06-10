/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SearchActServlet.java
  *作者:	          金悦
 *日期:	   2015-05-25
 *文件描述: 发布活动servlet
 *修改历史:
           日期1 2015-05-25     金悦	   创建.
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

//import com.icode.chengcheng.po.Resources;

















import edu.newdesign.joinus.biz.ISearchBiz;
import edu.newdesign.joinus.biz.IShowActTagBiz;
import edu.newdesign.joinus.biz.impl.SearchBizImpl;
import edu.newdesign.joinus.biz.impl.ShowActTagBizImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.vo.ShowActTag;

/**
 * Servlet implementation class PublishActivityServlet
 */
public class SearchActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchActServlet() {
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
		String searchcont=new String(request.getParameter("search").getBytes("ISO-8859-1"));
		//下拉菜单选择按活动名称找
		String selectcont=new String(request.getParameter("select").getBytes("ISO-8859-1"));
		if(selectcont.equals("actname")){
		List<Integer> lstAid =new ArrayList<Integer>();
		IShowActTagBiz iShowActTagBiz = new ShowActTagBizImpl();

         //调用Biz层的方法完成搜索功能
		 ISearchBiz iSearchBiz = new SearchBizImpl();
		 System.out.println("测试: >"+searchcont);
		 List<Activities> lstAct = iSearchBiz.search(searchcont);
		 for(Activities a:lstAct){
			 lstAid.add(a.getAid());
		 }
		 List<ShowActTag> lstActTag = iShowActTagBiz.selectActByaid(lstAid);
		 request.setAttribute("lstActTag", lstActTag);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchactivity.jsp");
		 dispatcher.forward(request, response);	
		 }
		if(selectcont.equals("acttopic")){
			List<Integer> lstAid =new ArrayList<Integer>();
			IShowActTagBiz iShowActTagBiz = new ShowActTagBizImpl();
	         //调用Biz层的方法完成搜索功能
			 ISearchBiz iSearchBiz = new SearchBizImpl();
			 System.out.println("测试: >"+searchcont);
			 List<Activities> lstAct = iSearchBiz.searchBytopic(searchcont);
			 for(Activities a:lstAct){
				 lstAid.add(a.getAid());
			 }
			 List<ShowActTag> lstActTag = iShowActTagBiz.selectActByaid(lstAid);
			 request.setAttribute("lstActTag", lstActTag);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchactivity.jsp");
			 dispatcher.forward(request, response);	
			 }
		if(selectcont.equals("actcontent")){
			List<Integer> lstAid =new ArrayList<Integer>();
			IShowActTagBiz iShowActTagBiz = new ShowActTagBizImpl();
	         //调用Biz层的方法完成搜索功能
			 ISearchBiz iSearchBiz = new SearchBizImpl();
			 System.out.println("测试: >"+searchcont);
			 List<Activities> lstAct = iSearchBiz.searchBycontent(searchcont);
			 for(Activities a:lstAct){
				 lstAid.add(a.getAid());
			 }
			 List<ShowActTag> lstActTag = iShowActTagBiz.selectActByaid(lstAid);
			 request.setAttribute("lstActTag", lstActTag);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchactivity.jsp");
			 dispatcher.forward(request, response);	
			 }
	}
}

