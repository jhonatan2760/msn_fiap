package br.com.jhonatan2760.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jhonatan2760.conect.Conect;
import br.com.jhonatan2760.model.Usuario;

public class UsuarioDAO {
	
	private Long id;
	private String usuario;
	private String nick;
	private final Usuario usuarioReceiver;
	
	public UsuarioDAO(Usuario usuario){
		this.usuarioReceiver = usuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public void salvar(){
		Conect c = new Conect();
		Connection conn = c.retrieveConection();
		try {
			conn.createStatement().execute(" INSERT INTO User values('"+this.usuario+"','"+this.nick+"',true) ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
