package cc.fbksy.eduspringboot.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ddd")
public class DemoClass {
	
	private String name;
	private String addRess;
	private String email;
	private List<ClassScore>  scoreList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<ClassScore> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<ClassScore> scoreList) {
		this.scoreList = scoreList;
	}
	
	
}
