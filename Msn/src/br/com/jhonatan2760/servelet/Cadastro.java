package br.com.jhonatan2760.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jhonatan2760.DAO.UsuarioDAO;
import br.com.jhonatan2760.model.Usuario;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet(name = "cadastro.do", urlPatterns = { "/cadastro.do" })
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String usuario = request.getParameter("usuario");
		String nick = request.getParameter("nick");
		String password = request.getParameter("senha");
		String avatar = request.getParameter("avatar");
		System.out.println(" Usuário recebido : "+usuario+" "+nick+" "+password);
		Usuario user = new Usuario();
		user.setNick(nick);
		user.setUsuario(usuario);
		user.setSenha(password);
		user.setAvatar(avatar);
		UsuarioDAO dao = new UsuarioDAO(user);
		
		try{
			dao.salvar();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
