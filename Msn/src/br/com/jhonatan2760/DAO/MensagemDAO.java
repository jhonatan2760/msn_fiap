package br.com.jhonatan2760.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jhonatan2760.conect.Conect;
import br.com.jhonatan2760.model.Mensagem;

public class MensagemDAO {

	private Mensagem m;
	
	public MensagemDAO(){};
	public MensagemDAO(Mensagem mensagem){
		this.m = mensagem;
	}
	
	public void enviarMensagem(){
		Conect c = new Conect();
		try {
			c.retrieveConection().createStatement().execute(" INSERT into mensagem values("+ (Math.random() * 9999) + 1 +",'"+m.getNick()+"','"+m.getMensagem()+"', '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Mensagem> getMensagens(){
		List<Mensagem> m = null;
		Mensagem mm;
		
		try {
			ResultSet rs = new Conect().retrieveConection().createStatement().executeQuery(" SELECT * FROM mensagem ORDER BY data");
			m = new ArrayList<>();
			while(rs.next()){
				mm = new Mensagem();
				mm.setIdMensagem(rs.getInt(1));
				mm.setNick(rs.getString(2));
				mm.setMensagem(rs.getString(3));
				mm.setData(rs.getDate(4));
				m.add(mm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
