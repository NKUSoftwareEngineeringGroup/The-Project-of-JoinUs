/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  RegisterhServlet.java
 *作者:	   金悦
 *日期:	   2015-05-19
 *文件描述: 发布活动servlet
 *修改历史:
          日期1 2015-05-19     金悦	   创建.
 */
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.newdesign.joinus.biz.IHobbiesBiz;
import edu.newdesign.joinus.biz.impl.HobbiesBizImpl;
import edu.newdesign.joinus.po.Hobbies;
import edu.newdesign.joinus.po.Users;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterhServlet() {
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
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/images/photo");
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
				Hobbies hobby =new Hobbies();
				Users user = new Users();

				// 4-2:将解析到的二进制文件封装到FileItem的对象中
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				String ubirth=null;
				for (FileItem fileItem : fileItems) {
					// 扩展3：判断当前解析的请求数据是否为普通表单数据
					if (fileItem.isFormField()) {
						// 获取客户端表单输入元素的name属性的值
						String name = fileItem.getFieldName().trim();
					
						// 判断数据为哪个字段数据
						if ("uccid".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUccid(value);
							System.out.println("测试-注册账号：> " + value);
						}
						if ("upwd".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUpwd(value);
							System.out.println("测试-注册密码：> " + value);
						}
						if ("uname".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUname(value);
							System.out.println("测试-用户真实姓名：> " + value);
						}
		
						if ("ubirthyear".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							ubirth=value;
						}
						if ("ubirthmonth".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							int i = Integer.parseInt(value);
							if(i>=10) ubirth+=value;
							else ubirth+="0"+value;
						}
						if ("ubirthday".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							int i = Integer.parseInt(value);
							if(i>=10) ubirth+=value;
							else ubirth+="0"+value;
							SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
							Date birthdate=sdf.parse(ubirth);
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUbirth(birthdate);
							System.out.println("测试-用户出生年月日：> " + birthdate);
						}
						
						if ("ucity".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUcity(value);
							System.out.println("测试-用户所在城市：> " + value);
						}
						if ("uorg".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUorg(value);
							System.out.println("测试-用户单位或学校：> " + value);
						}
						if ("utele".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUtele(value);
							System.out.println("测试-用户电话号码：> " + value);
						}
						if ("uadd".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUadd(value);
							System.out.println("测试-用户具体地址：> " + value);
						}
						if ("uQQ".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUqq(value);
							System.out.println("测试-用户QQ号：> " + value);
						}
						if ("checkbox".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							//user.setUqq(value);
							IHobbiesBiz hobbiesBiz = new HobbiesBizImpl();
							hobby.setHuser(user.getUccid());
							hobby.setHtag(Integer.parseInt(value));
							hobbiesBiz.add(hobby);
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
	
						user.setUphoto(fileName);
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
							user.setUphoto(fileName);
						}
				}
		}
				// 测试封装对象
				user.setUstate(1);
					// 跳转至登录页面
					request.setAttribute("uccid", user.getUccid());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/login.jsp");
					dispatcher.forward(request, response);
				
				
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

