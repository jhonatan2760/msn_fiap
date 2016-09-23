package br.com.jhonatan2760.Exception;

public class UserAutenthication extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAutenthication() {
		super("Login/Senha incorreto(s)");
	}
}
