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
import adminregister.model.adminregister;

/**
 *
 * @author User
 */
@WebServlet("/AddController")
public class add extends HttpServlet {
    private static final long serialVersionUID=1L;
    private adminregisterDAO dao;
    
    public add(){
        super();
        dao = new adminregisterDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		adminregister a = new adminregister();
		dao.addaddminregister(a);
		
		request.setAttribute("adminregister", adminregisterDAO.getAlladminregister());
		RequestDispatcher view = request.getRequestDispatcher("addminregister.jsp");
		view.forward(request, response);
	}
}

