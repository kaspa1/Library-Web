package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addbook
 */
@WebServlet("/addbook")
public class addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			String bookname =request.getParameter("bookname");
		    String isbn = request.getParameter("isbn");
			String author = request.getParameter("author");
			String category = request.getParameter("category");
			
			String sql = "insert into book (Book_Name,ISBN ,Author,Category) values (?,?,?,?)";
			
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/itpm_db","root","");
		     
		     PreparedStatement ps = conn.prepareStatement(sql);
		     ps.setString(1, bookname);
		     ps.setString(2, isbn);
		     ps.setString(3, author);
		     ps.setString(4, category);
		     ps.executeUpdate();
		     
		     PrintWriter out = response.getWriter();
		     out.println("Data Successfully Inserted!!");
		     
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
