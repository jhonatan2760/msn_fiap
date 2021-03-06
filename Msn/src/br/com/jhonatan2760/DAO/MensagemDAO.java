package br.com.jhonatan2760.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.jhonatan2760.Exception.UserAutenthication;
import br.com.jhonatan2760.conect.Conect;
import br.com.jhonatan2760.model.Mensagem;
import br.com.jhonatan2760.model.Usuario;

public class MensagemDAO {

	private Mensagem m;
	
	public MensagemDAO(){};
	public MensagemDAO(Mensagem mensagem){
		this.m = mensagem;
	}
	
	public void enviarMensagem(){
		Conect c = new Conect();
		Connection cc = c.retrieveConection();
		
		try {
			cc.createStatement().execute(" INSERT into mensagem values("+ (Math.random() * 9999) + 1 +",'"+m.getNick()+"','"+m.getMensagem()+"', '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"', "+m.getUser().getId()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Mensagem> getMensagens(){
		List<Mensagem> m = null;
		Mensagem mm;
		Connection cs = new Conect().retrieveConection();
		try {
			ResultSet rs = cs.createStatement().executeQuery(" SELECT * FROM mensagem ORDER BY data");
			m = new ArrayList<>();
			UsuarioDAO us = null;
			while(rs.next()){
				mm = new Mensagem();
				mm.setIdMensagem(rs.getInt(1));
				mm.setNick(rs.getString(2));
				mm.setMensagem(rs.getString(3));
				mm.setData(rs.getDate(4));
				Usuario s = new Usuario();
				us = new UsuarioDAO(s);
				mm.setUser(us.getById(rs.getLong(5)));
				m.add(mm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UserAutenthication e) {
			e.printStackTrace();
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
}
