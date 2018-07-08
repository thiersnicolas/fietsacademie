package be.vdab.servlets.docenten;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.DocentService;
import be.vdab.util.StringUtils;

/**
 * Servlet implementation class ZoekenServlet
 */
@WebServlet("/docenten/zoeken.htm")
public class ZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/docenten/zoeken.jsp";
	private final transient DocentService docentService = new DocentService();
	private final static String REDIRECT_URL = "%s/docenten/zoeken.htm?id=%d";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			if (StringUtils.isLong(id)) {
				docentService.read(Long.parseLong(id)).ifPresent(docent -> request.setAttribute("docent", docent));
			} else {
				request.setAttribute("fouten", Collections.singletonMap("id", "tik een getal"));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		if (request.getParameter("verwijderen")==null) {
			bijnamenToevoegen(request, response, id);
		} else {
			bijnamenVerwijderen(request, response, id);
		}
	}
	
	private void bijnamenVerwijderen(HttpServletRequest request, HttpServletResponse response, long id) throws  IOException {
		String[] bijnamen = request.getParameterValues("bijnaam");
		if (bijnamen!=null) {
			docentService.bijnamenVerwijderen(id, bijnamen);
		}
		response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath(), id)));
	}
	
	private void bijnamenToevoegen(HttpServletRequest request, HttpServletResponse response, long id) throws IOException, ServletException {
		String bijnaam = request.getParameter("bijnaam");
		if (bijnaam == null || bijnaam.trim().isEmpty()) {
			request.setAttribute("fouten", Collections.singletonMap("bijnaam", "verplicht"));
			docentService.read(id).ifPresent(docent -> request.setAttribute("docent", docent));
			request.getRequestDispatcher(VIEW).forward(request, response);
		} else {
			docentService.bijnaamToevoegen(id, bijnaam);
			response.sendRedirect(
					response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath(), id)));
		}
	}
	

}
