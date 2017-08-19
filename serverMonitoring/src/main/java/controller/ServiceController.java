package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Server;
import service.ServerProviderFromJsonFileService;
import service.ServerProviderFromXMLService;


@WebServlet("")
public class ServiceController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		
		
		List<Server> servers = new ServerProviderFromXMLService().getAllServers();
		
		System.out.println(servers);
		
		
		req.setAttribute("servers", servers);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
