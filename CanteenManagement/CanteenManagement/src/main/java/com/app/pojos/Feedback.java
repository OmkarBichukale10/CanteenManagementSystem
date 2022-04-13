package com.app.pojos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fid;
	private String name;
	private String feedback;
	public Feedback(){
		
	}
	public Feedback(int fid, String name, String feedback) {
		super();
		this.fid = fid;
		this.name = name;
		this.feedback = feedback;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", name=" + name + ", feedback=" + feedback + "]";
	}
	
	
	
	

}
