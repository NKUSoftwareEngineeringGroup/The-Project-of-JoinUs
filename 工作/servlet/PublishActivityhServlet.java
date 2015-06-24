/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    PublishActivityhServlet.java
 *作者:	        李宛恒
 *日期:	     May 21, 2015
 *文件描述:  提供发布活动的服务
 *修改历史:
            日期1 21/5/2015  李宛恒  创建
            日期2 29/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//import com.icode.chengcheng.po.Resources;



import edu.newdesign.joinus.biz.IBelongBiz;
import edu.newdesign.joinus.biz.impl.BelongBizImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.Belong;
import edu.newdesign.joinus.po.Participate;
import edu.newdesign.joinus.po.Users;

/**
 * Servlet implementation class PublishActivityServlet
 */
public class PublishActivityhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishActivityhServlet() {
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
		
		// 1-1：设置服务器接受上传文件的位置（服务器的文件夹）
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				response.setHeader("Content-Type", "text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				String fileUploadPath = this.getServletContext().getRealPath(
						"/upload/resources");
				System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的位置是："
						+ fileUploadPath);
				// 1-2：设置服务器临时缓冲区的位置（临时缓冲的文件夹）
				File fileUploadTempPath = new File(this.getServletContext()
						.getRealPath("/tempDir"));
				if (!fileUploadTempPath.exists()) {
					// 创建一个全新的
					fileUploadTempPath.mkdir();
				}
				System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的临时位置是："
						+ fileUploadTempPath.getPath());

				// 步骤2：判断表单是否符合上传要求
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				if (isMultipart) {
					// 步骤3：设置文件上传缓冲区对象
					DiskFileItemFactory factory = new DiskFileItemFactory();
					// 3-1:缓冲区对象与磁盘物理位置的绑定
					factory.setRepository(fileUploadTempPath);
					// 3-2：设置缓冲区对象的大小（4*1024 字节）
					factory.setSizeThreshold(4 * 1024);
					System.out
							.println("[SingleFileUploadServlet] 初始化服务器接受客户端上传文件的临时位置完毕！");

					// 步骤4：解析客户端表单待上传的数据
					// 4-1:创建一个ServletFileUpload对象完成对二进制表单数据的解析，并实现服务器上传功能
					ServletFileUpload sfu = new ServletFileUpload(factory);

					try {
						// ★★特别注意★★ 在循环遍历表单数据之前创建实体类对象
						Participate participate=new Participate();
						Activities activity=new Activities();
						Belong belong = new Belong();
						//Resources resource = new Resources();
						// 4-2:将解析到的二进制文件封装到FileItem的对象中
						@SuppressWarnings("unchecked")
						List<FileItem> fileItems = sfu.parseRequest(request);
						String adate=null;
						String adeadlinedate=null;
						HttpSession session = request.getSession();
						for (FileItem fileItem : fileItems) {
							// 扩展3：判断当前解析的请求数据是否为普通表单数据
							if (fileItem.isFormField()) {
								// 获取客户端表单输入元素的name属性的值
								String name = fileItem.getFieldName().trim();
							
								// 判断数据为哪个字段数据
								Users user=(Users) session.getAttribute("user");
								String owner_id=user.getUccid();
								activity.setOwner_id(owner_id);
								participate.setPuser(owner_id);
								System.out.println("测试-owner_id: >"+ owner_id);

								if ("aname".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAname(value);
									System.out.println("测试-活动名称：> " + value);
								}
								
								if ("adateyear".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									adate=value;
								}
								if ("adatemonth".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									int i = Integer.parseInt(value);
									if(i>=10) adate+=value;
									else adate+="0"+value;
								}
								if ("adateday".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									int i = Integer.parseInt(value);
									if(i>=10) adate+=value;
									else adate+="0"+value;
								}
								if ("adatehour".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									adate+=value;
								}
								if ("adatemin".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									adate+=value;
									SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmm");
									Date actdate=sdf.parse(adate);
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAdate(actdate);
									System.out.println("测试-活动时间：> " + actdate);
								}
								if ("aaddress".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAaddress(value);
									System.out.println("测试-活动地址：> " + value);
								}
								
								if ("adeadlineyear".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									adeadlinedate=value;
								}
								if ("adeadlinemonth".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									int i = Integer.parseInt(value);
									if(i>=10) adeadlinedate+=value;
									else adeadlinedate+="0"+value;
								}
								if ("adeadlineday".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									int i = Integer.parseInt(value);
									if(i>=10) adeadlinedate+=value;
									else adeadlinedate+="0"+value;
									SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
									Date actdeadlinedate=sdf.parse(adeadlinedate);
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAdeadline(actdeadlinedate);
									System.out.println("测试-活动时间：> " + actdeadlinedate);
								}
								
								
								if ("amin_num".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAmin_num(Integer.parseInt(value));
									System.out.println("测试-活动最少人数：> " + value);
								}
								if ("amax_num".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAmax_num(Integer.parseInt(value));
									System.out.println("测试-活动最多人数：> " + value);
								}
								if ("atopic".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAtopic(value);
									System.out.println("测试-活动主题：> " + value);
								}
								if ("acontent".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									activity.setAcontent(value);
									System.out.println("测试-活动详细内容：> " + value);
								}
								if ("checkbox".equalsIgnoreCase(name)) {
									String value = fileItem.getString();
									value = new String(value.getBytes("iso8859-1"),
											"UTF-8");
									//user.setUqq(value);
									 String actid = request.getParameter("aid");
									//String aid=null;
									//aid=request.getParameter("aid").trim();
									System.out.println("测试aid： >"+actid);
									IBelongBiz belongBiz = new BelongBizImpl();
									belong.setBact(Integer.parseInt(actid));
									belong.setBtag(Integer.parseInt(value));
									belongBiz.add(belong);									
									System.out.println("测试-用户checkbox：> " + value);
								}
							}
							
							else{
								String fileName = fileItem.getName().trim();
								long fileSize = fileItem.getSize();
								if(!(fileName.equals("")&&fileSize==0)){
								String[] allowedTypes = new String[] { ".jpg", ".jpeg",
										".png", ".bmp" };
								Arrays.sort(allowedTypes);
								int searchIndex = Arrays.binarySearch(allowedTypes,
										fileName);
								if (searchIndex < 0) {
									System.out.println("[SingleFileUploadServlet] 该类型文件不允许上传！");
								}
							
								String fileExtName = fileName.substring(fileName.lastIndexOf("."));
								fileName = generateUnqieName() + fileExtName;
			
								//user.setUphoto(fileName);
								System.out.println(fileName);
						
								
								System.out
										.println("[SingleFileUploadServlet] 获取上传文件的名称为: "
												+ fileName);
								// 4-4:封装上传文件对象并写入到服务器
								File saveFile = new File(fileUploadPath, fileName);
								fileItem.write(saveFile);
								System.out.println("[SingleFileUploadServlet] 上传文件成功！");
								}else{
									fileName = "defaultphoto.png";
								//	user.setUphoto(fileName);
								}
						}
				}
						//默认初始活动状态为已发布未进行
						activity.setAstate("1");
						// 调用Biz层的方法完成发布功能
					//	IPublishActivityBiz publishBiz = new PublishActivityBizImpl();
					//	boolean flag = publishBiz.publish(activity);
						// 根据返回值结果进行页面跳转
						
							// 跳转至主页面
							//IParticipateBiz participateBiz =new ParticipateBizImpl();
							//int pact = participateBiz.selectAid(activity);
							//System.out.println(pact);
							//participate.setPact(pact);
							//participate.setPtype(0);
							//调用Biz层的方法完成participate功能
							//boolean flag2 = participateBiz.participate(participate);
							//if(flag2)
							//{
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("ShowInIndexServlet");
								dispatcher.forward(request, response);
							//}
							//else{
								//System.out.println("添加participate失败！");
							//}
						
						
						
					} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("客户端表单不符合上传要求！");
					
				}
				
			}

			// 自定义方法完成上传文件名称的自动生成
			private synchronized String generateUnqieName() {
				return String.valueOf(System.nanoTime());
			}

}

