package br.com.jhonatan2760.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.jhonatan2760.DAO.MensagemDAO;
import br.com.jhonatan2760.model.Mensagem;
import br.com.jhonatan2760.model.Usuario;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson g = new Gson();
		response.getWriter().append(g.toJson(new Mensagem().getMensagens()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Mensagem m = new Mensagem();
		m.setData(new java.sql.Date(new java.util.Date().getTime()));
		m.setIdMensagem(0);
		m.setMensagem(request.getParameter("mensagem"));
		m.setNick(request.getParameter("nick"));
		Usuario uss = (Usuario) request.getSession().getAttribute("usuario");
		m.setUser(uss);
		new MensagemDAO(m).enviarMensagem();
	}

}
