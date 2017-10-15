package bwphackstl17.unleashed.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="events_test")
public class Event {
	
	// PROPERTIES -------------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name="event_id", unique=true)
	private int id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="latitude")
	private double lat;
	
	@NotNull
	@Column(name="longitude")
	private double lng;
	
	@NotNull @Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="duration")
	private int duration; // In minutes
	
	@ManyToOne @JsonIgnoreProperties("events")
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="color")
	private String color;
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	// Empty constructor (for Hibernate)
	public Event() { }
	
	public Event(String name, String description, double lat, double lng, Date startTime, int duration, User user) {
		this.name = name;
		this.description = description;
		this.lat = lat;
		this.lng = lng;
		this.startTime = startTime;
		this.duration = duration;
		this.user = user;
	}
	
	// PRIVATE METHODS --------------------------------------------------------
	
	// PUBLIC STATIC METHODS --------------------------------------------------
	
	// PUBLIC INSTANCE METHODS ------------------------------------------------
	
	// GETTERS AND SETTERS ----------------------------------------------------
	
	// Getters
	public int getId()             { return this.id; }
	public String getName()        { return this.name; }
	public String getDescription() { return this.description; }
	public double getLat()         { return this.lat; }
	public double getLng()         { return this.lng; }
	public Date getStartTime()     { return this.startTime; }
	public int getDuration()       { return this.duration; }
	public User getUser()          { return this.user; }
	public String getColor()       { return this.color; }
	
	// Setters (for Hibernate)
	@SuppressWarnings("unused") private void setId(int id)                { this.id = id; }
	@SuppressWarnings("unused") private void setName(String name)         { this.name = name; }
	@SuppressWarnings("unused") private void setDescription(String description)
			{ this.description = description; }
	@SuppressWarnings("unused") private void setLat(double lat)           { this.lat = lat; }
	@SuppressWarnings("unused") private void setLng(double lng)           { this.lng = lng; }
	@SuppressWarnings("unused") private void setStartTime(Date startTime) { this.startTime = startTime; }
	@SuppressWarnings("unused") private void setDuration(int duration)    { this.duration = duration; }
	@SuppressWarnings("unused") private void setUser(User user)           { this.user = user; }
	@SuppressWarnings("unused") private void setColor(String color)       { this.color = color; }

}
