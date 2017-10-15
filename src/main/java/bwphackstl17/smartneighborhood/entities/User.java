package bwphackstl17.smartneighborhood.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bwphackstl17.smartneighborhood.util.Helpers;

@Entity
@Table(name = "users_test")
public class User {
	
	// PROPERTIES -------------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name="user_id", unique=true)
	private int id;
	
	@Column(name="username", unique=true)
	private String username;
	
	@Column(name="pw_hash")
	private String pwHash;
	
	@OneToMany(mappedBy="user")
	private List<Event> events;
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	public User() { }
	
	public User(String username, String password) {
		this.username = username;
		this.pwHash = hashPassword(password);
	}
	
	// PRIVATE METHODS --------------------------------------------------------
	
	private static String hashPassword(String password) {
		return encoder.encode(password);
	}
	
	// PUBLIC STATIC METHODS --------------------------------------------------
	
	public static boolean isValidUsername(String username) {
		return Helpers.isRegexMatch("[a-zA-Z0-9_-]{3,15}", username);
	}
	
	public static boolean isValidPassword(String password) {
		return Helpers.isRegexMatch("([1-zA-Z0-1@.\\s]{2,10})", password);
	}
	
	// PUBLIC INSTANCE METHODS ------------------------------------------------
	
	public boolean isPasswordMatch(String password) {
		return encoder.matches(password, pwHash);
	}
	
	// GETTERS AND SETTERS ----------------------------------------------------
	
	// Getters
	public int getId()             { return this.id; }
	public String getUsername()    { return this.username; }
	public String getPwHash()      { return this.pwHash; }
	public List<Event> getEvents() { return this.events; }
	
	// Setters
	@SuppressWarnings("unused") private void setId(int id)                 { this.id = id; }
	@SuppressWarnings("unused") private void setUsername(String username)  { this.username = username; }
	@SuppressWarnings("unused") private void setPwHash(String pwHash)      { this.pwHash = pwHash; }
	@SuppressWarnings("unused") private void setEvents(List<Event> events) { this.events = events; }
	

}
