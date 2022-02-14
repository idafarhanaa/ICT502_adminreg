/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admincontroller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import adminregister.dao.adminregisterDAO;
/**
 *
 * @author User
 */
@WebServlet("/DeleteController")
public class delete extends HttpServlet{
      private static final long serialVersionUID = 1L;
    private adminregisterDAO dao;
    
    public delete(){
        super();
        dao = new adminregisterDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteadminregister(id);
		
		request.setAttribute("adminregister", adminregisterDAO.getAlladminregister());
		RequestDispatcher view = request.getRequestDispatcher("adminregister.jsp");
		view.forward(request,response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

