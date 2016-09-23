package br.com.jhonatan2760.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jhonatan2760.Exception.UserAutenthication;
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
			conn.createStatement().execute(" INSERT INTO User values("+System.nanoTime()+", '"+this.usuarioReceiver.getUsuario()+"','"+this.usuarioReceiver.getNick()+"','"+this.usuarioReceiver.getSenha()+"','"+this.usuarioReceiver.getAvatar()+"', 0) ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Usuario getById(Long id) throws UserAutenthication{
		Conect c = new Conect();
		Connection cc = c.retrieveConection();
		
		try {
			ResultSet rs = cc.createStatement().executeQuery(" SELECT idUsuario,usuario,nick,avatar FROM User where idUsuario = "+id+" ");
			Usuario receiver = new Usuario();
			
			if(rs.next()){
				receiver.setId(rs.getLong(1));
				receiver.setUsuario(rs.getString(2));
				receiver.setNick(rs.getString(3));
				receiver.setAvatar(rs.getString(4));
				
				return receiver;
			}else{
				throw new UserAutenthication();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public Usuario logar() throws UserAutenthication{
		
		Conect c = new Conect();
		Connection cc = c.retrieveConection();
		try {
			ResultSet rs = cc.createStatement().executeQuery(" SELECT idUsuario,usuario,nick,avatar FROM User where usuario = '"+this.usuarioReceiver.getUsuario()+"' and password='"+this.usuarioReceiver.getSenha()+"' ");
			Usuario receiver = new Usuario();
			
			if(rs.next()){
				receiver.setId(rs.getLong(1));
				receiver.setUsuario(rs.getString(2));
				receiver.setNick(rs.getString(3));
				receiver.setAvatar(rs.getString(4));
				
				return receiver;
			}else{
				throw new UserAutenthication();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public List<Usuario> getUsuarios(){
		System.out.println("Carregando usuários");
		Conect c = new Conect();
		Connection cc = c.retrieveConection();
		
		try{
			ResultSet rs = cc.createStatement().executeQuery(" SELECT idUsuario,usuario,nick,avatar from User ");
			Usuario receiver;
			List<Usuario> us = new ArrayList<>();
			while(rs.next()){
				receiver = new Usuario();
				receiver.setId(rs.getLong(1));
				receiver.setUsuario(rs.getString(2));
				receiver.setNick(rs.getString(3));
				receiver.setAvatar(rs.getString(4));
				us.add(receiver);
			}
			
			return us;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				cc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
}
