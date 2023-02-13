package com.ajith.response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajith.model.DocterModel;

@Component
@ResponseBody
public class Docresponse {

	private DocterModel docterEntry = new DocterModel();

	private String msg;

	public DocterModel getDm() {
		return docterEntry;
	}

	public void setDm(DocterModel dm) {
		this.docterEntry = dm;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
