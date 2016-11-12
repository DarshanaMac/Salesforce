package com.leons.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leons.checks.Validations;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("form-username");
        String password = request.getParameter("form-password");
        
        if(Validations.checkUser(username, password))
        {
        	System.out.println("Came here");
            RequestDispatcher rs = request.getRequestDispatcher("DashBoard.html");
            rs.forward(request, response);
        }
        else
        {
        	System.out.println("faliure");
            response.setContentType("text/html");  
            out.println("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <title>Help Desk Login</title>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
            "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n" +
            "  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
            "  <script type=\"text/javascript\">\n" +
            "    $(window).load(function(){\n" +
            "        $('#myModal').modal('show');\n" +
            "    });\n" +
            "</script>\n" +
            "\n" +
            "  <style>\n" +
            "  .modal-header, h4, .close {\n" +
            "      background-color: #222;\n" +
            "      color:red !important;\n" +
            "      text-align: center;\n" +
            "      font-size: 30px;\n" +
            "      opacity:0.7;\n" +
            "  }\n" +
            "  .modal-footer {\n" +
            "      background-color: #222;\n" +
            "      opacity:0.7;\n" +
            "  }\n" +
            " .modal-body {\n" +
            "      background-color:#222;\n" +
            "      color:white !important;\n" +
            "      text-align: center;\n" +
            "      opacity:0.7;\n" +
            "  }\n" +
            "  </style>\n" +
            "\n" +
            "</head>");  
            out.println("<body>\n" +
            "<!-- Modal -->\n" +
            "  <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n" +
            "    <div class=\"modal-dialog modal-sm\">\n" +
            "    \n" +
            "      <!-- Modal content-->\n" +
            "      <div class=\"modal-content\">\n" +
            "        <div class=\"modal-header\">\n" +
            "          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
            "          <h4 class=\"modal-title\">Error!</h4>\n" +
            "        </div>\n" +
            "        <div class=\"modal-body\">\n" +
            "          <p>Invalid Username or Password</p>\n" +
            "        </div>\n" +
            "        <div class=\"modal-footer\">\n" +
            "          <button type=\"button\" class=\"btn-sm btn-danger\" data-dismiss=\"modal\">Close</button>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "      \n" +
            "    </div>\n" +
            "  </div>\n" +
            "  \n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html>");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
	}

}
