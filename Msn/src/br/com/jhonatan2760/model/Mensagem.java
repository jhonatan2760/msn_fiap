package br.com.jhonatan2760.model;

import java.sql.Date;
import java.util.List;

import br.com.jhonatan2760.DAO.MensagemDAO;

public class Mensagem extends MensagemDAO {

	public Mensagem(){
		super();
	}
	
	private int idMensagem;
	private String nick;
	private String mensagem;
	private Date data;
	
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Mensagem> getMensages(){
		return this.getMensagens();
	}
}
