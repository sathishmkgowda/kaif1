package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterAccess;
import DTO.RegisterCreate;

@WebServlet("/fetchid")
public class fetchid extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int id =Integer.parseInt(req.getParameter("id"));
		
		RegisterAccess accessbyid = new RegisterAccess();
		RegisterCreate student= accessbyid.fetchid(id);
		
		PrintWriter out =resp.getWriter();
		
		if(student==null)
		{
			out.print("<h> DATA NOT FOUND CHECK ID</h>");
		}else {
		
		out.print("<h1> Student Details </h1>");
		out.print("<table border='1' ");
		out.print("<tr>");
		out.print("<th>ID</th>");
		out.print("<th>NAME</th>");
		out.print("<th>MOBILE</th>");
		out.print("<th>EMAIL ID</th>");
		out.print("<th>DOB</th>");
		out.print("<th>GENDER</th>");
		out.print("<th>COUNTRY</th>");
		out.print("<th>ADDRESS</th>");
		out.print("<th>HOBBIES</th>");
		out.print("<th>AGE</th>");
		out.print("</tr>");
		
		
			out.print("<tr>");
			out.print("<th>"+student.getId()+"</th>");
			out.print("<th>"+student.getName()+"</th>");
			out.print("<th>"+student.getMobile()+"</th>");
			out.print("<th>"+student.getEmail()+"</th>");
			out.print("<th>"+student.getDob()+"</th>");
			out.print("<th>"+student.getGender()+"</th>");
			out.print("<th>"+student.getCountry()+"</th>");
			out.print("<th>"+student.getAddress()+"</th>");
			out.print("<th>"+Arrays.toString(student.getHobbies())+"</th>");
			out.print("<th>"+student.getAge()+"</th>");
			out.print("</tr>");
		
				out.print("</table");
		}	
		
	}
}