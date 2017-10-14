package bwphackstl17.smartneighborhood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import bwphackstl17.smartneighborhood.util.Helpers;

@Entity
@Table(name = "users_test")
public class User {
	
	// PROPERTIES -------------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name="user_id", unique=true)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pw_hash")
	private String pwHash;
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	public User() { }
	
	public User(String username, String password) {
		this.username = username;
		this.pwHash = hashPassword(password);
	}
	
	// PRIVATE METHODS --------------------------------------------------------
	
	/*
	 * Hash a password
	 * @param   unhashedPassword  Password (string) to be hashed
	 * @return  Hashed version of password
	 */
	private static String hashPassword(String unhashedPassword) {
		return Helpers.bcryptHash(unhashedPassword); // Return hashed password
	}
	
	// PUBLIC STATIC METHODS --------------------------------------------------
	
	// PUBLIC INSTANCE METHODS ------------------------------------------------
	
	// GETTERS AND SETTERS ----------------------------------------------------
	
	public int getId()          { return this.id; }
	public String getUsername() { return this.username; }
	public String getPwHash()   { return this.pwHash; }
	
	@SuppressWarnings("unused") private void setId(int id)                { this.id = id; }
	@SuppressWarnings("unused") private void setUsername(String username) { this.username = username; }
	@SuppressWarnings("unused") private void setPwHash(String pwHash)     { this.pwHash = pwHash; }
	

}
