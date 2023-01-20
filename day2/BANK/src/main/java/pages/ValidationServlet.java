package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.userDALImp;
import pojo.user;
import utils.DButils;


@WebServlet(value="/loginServlet",loadOnStartup=-1)
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	userDALImp userdao;
    public ValidationServlet() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init validationServlet");
		try {
			DButils.openConnection();
			userdao=new userDALImp();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void destroy() {
	System.out.println("--inside Destory---");
	try {
		userdao.cleanUp();
		DButils.closeConnection();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside doPost validationServlet---");
		response.setContentType("text/html");
		try(PrintWriter pr=response.getWriter();)
		{
			pr.write("<h1>Welcome to Iacsd</h1>");
			pr.write("<hr>");
			String username=request.getParameter("txtuser");
			String pwd=request.getParameter("txtpwd");
			pr.write("<h3>Welcome :"+username+"</h3>");
			
			user userObj=userdao.ValidateUser(username,pwd);
			
			if(userObj!=null) {
				pr.write("<h3>Valid User:"+username+"</h3>");
				
			}
			else
			{
				pr.write("<h3>Invalid User:"+username+"</h3>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
