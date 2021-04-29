package com.kevin.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import com.kevin.DAO.ClsUsuario;
import com.kevin.entidades.Loguin;
import com.kevin.entidades.usuario;
import com.kevin.negocio.clsLoguin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ControllerAcceso")
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
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
		HttpSession session = request.getSession(true);
		
		String btncerrar = request.getParameter("btncerrar");
		response.sendRedirect("index.jsp");
		session.invalidate();
		
		
		
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		usuario log = new usuario();
		clsLoguin clsL = new clsLoguin();
		
		log.setUsuario(user);
		log.setPass(pass);
		
		 int valordeacceso = clsL.acceso(log);
		 
		 if (valordeacceso==1) {
			 System.out.println("Welcome");
			 ClsUsuario cls = new ClsUsuario();
			 ArrayList<usuario> clsuser = new ArrayList<>();
			 response.sendRedirect("Saludo,jsp");
			 session.setAttribute("usuario", valordeacceso);
			 
			for(var iteracion:cls.ListadoUSUARIOS()) {			
				System.out.println("idUsuario");
				System.out.println("Usuario");
				System.out.println("PassWord");
				System.out.println("tipoUsuario");
			}
			 
			 response.sendRedirect("Saludo.jsp");
			 
			 
		}else if (valordeacceso==2){
			
			System.out.println("Usuario Normal");
			response.sendRedirect("standard.jsp");
			
		}else{
			
			System.out.println("ERROR");
			 response.sendRedirect("Error.jsp");
		}
			
			
		 
		 
		 
	}

}
