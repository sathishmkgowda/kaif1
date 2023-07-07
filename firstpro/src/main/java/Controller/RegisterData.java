package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterAccess;
import DTO.RegisterCreate;

@WebServlet("/SaveStudent")


public class RegisterData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		long mobile =Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
//		Date dob =Date.valueOf(req.getParameter("DOB"));-+
		String gender =req.getParameter("Gender");
		String country =req.getParameter("Country");
		String address =req.getParameter("address");
		String[] hobbies =req.getParameterValues("hobbies");
		     
		LocalDate today = LocalDate.now();
		LocalDate dob =LocalDate.parse((req.getParameter("DOB")));
		
		Period p = Period.between(today, dob);
		
		resp.getWriter().print("<h1>"
				+ "Name:"+name
				+ "<br>Mobile:"+mobile
				+ "<br>Email:"+email
				+ "<br>DOB:"+dob
				+ "<br>Gender:"+gender
				+ "<br>Country:"+country
				+ "<br>Address:"+address
				+ "<br>Hobbies:"+Arrays.toString(hobbies)
				+ "</h1>");
		
		RegisterCreate student=new RegisterCreate();
		
		student.setName(name);
		student.setAge(p.getYears());
		student.setMobile(mobile);
		student.setEmail(email);
		student.setDob(dob);
		student.setGender(gender);
		student.setCountry(country);
		student.setAddress(address);
		student.setHobbies(hobbies);
		
		  
		RegisterAccess acess = new RegisterAccess();
		acess.insert(student);
		
		
		
		
	}
}
	

