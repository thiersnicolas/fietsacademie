package be.vdab.servlets.docenten;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.DocentServices;
import be.vdab.util.StringUtils;

/**
 * Servlet implementation class ZoekenServlet
 */
@WebServlet("/docenten/zoeken.htm")
public class ZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/docenten/zoeken.jsp";
	private final transient DocentServices docentServices = new DocentServices();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (StringUtils.isLong(id)) {
			docentServices.read(Long.parseLong(id)).ifPresent(docent -> request.setAttribute("docent", docent));
		} else {
			request.setAttribute("fouten", Collections.singletonMap("id", "tik een getal"));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	

}
