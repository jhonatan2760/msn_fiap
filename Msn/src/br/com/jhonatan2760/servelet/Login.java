package br.com.jhonatan2760.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jhonatan2760.DAO.UsuarioDAO;
import br.com.jhonatan2760.Exception.UserAutenthication;
import br.com.jhonatan2760.model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Serveds at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String login = request.getParameter("login");
		System.out.println(login);
		String senha = request.getParameter("password");
		System.out.println(senha);
		Usuario user = new Usuario();
		user.setUsuario(login);
		user.setSenha(senha);
		UsuarioDAO usuario = new UsuarioDAO(user);
		String locate = "";
		HttpSession sessao = request.getSession();
		try{
			locate = "index.jsp";
			Usuario use = usuario.logar();
			sessao.setAttribute("login", true);
			sessao.setMaxInactiveInterval(9000);
			sessao.setAttribute("usuario", use);
			request.setAttribute("logado", use);
		}catch(UserAutenthication ex){
			System.out.println(login);
			System.out.println(senha);
			ex.printStackTrace();
			locate = "login.jsp?type=err";
			
		}
		
		request.getRequestDispatcher(locate).forward(request, response);
	}

}
