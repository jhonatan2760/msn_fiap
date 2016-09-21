package br.com.jhonatan2760.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jhonatan2760.conect.Conect;
import br.com.jhonatan2760.model.Usuario;

public class UsuarioDAO {
	
	private final Usuario usuarioReceiver;
	
	public UsuarioDAO(Usuario usuario){
		this.usuarioReceiver = usuario;
	}
	
	
	public void salvar(){
		Conect c = new Conect();
		Connection conn = c.retrieveConection();
		try {
			conn.createStatement().execute(" INSERT INTO User values(1, '"+this.usuarioReceiver.getUsuario()+"','"+this.usuarioReceiver.getNick()+"','"+this.usuarioReceiver.getSenha()+"','"+this.usuarioReceiver.getAvatar()+"', 0) ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
