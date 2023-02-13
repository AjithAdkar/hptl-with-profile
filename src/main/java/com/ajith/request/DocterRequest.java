package com.ajith.request;

import org.springframework.stereotype.Component;

@Component
public class DocterRequest {
	
	private int docid;
	private String Docname;
	private int experience;
	private String mailId;

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getDocname() {
		return Docname;
	}

	public void setDocname(String docname) {
		Docname = docname;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "DocterRequest [docid=" + docid + ", Docname=" + Docname + ", experience=" + experience + "]";
	}

}
