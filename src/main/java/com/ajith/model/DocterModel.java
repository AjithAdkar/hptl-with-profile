package com.ajith.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Docter")
public class DocterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int docid;

	@Column(name = "DocterName", length = 15)
	@NotNull
	private String Docname;

	@Column(name = "Experience")
	@NotNull
	private int experience = 0;

	@Column(name = "Mail_ID", length = 30, unique = true)
	@Email
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
		return "DocterModel [docid=" + docid + ", Docname=" + Docname + ", experience=" + experience + ", mailId="
				+ mailId + "]";
	}

}
