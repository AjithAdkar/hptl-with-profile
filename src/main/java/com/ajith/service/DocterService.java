package com.ajith.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ajith.dao.DocterRepo;
import com.ajith.dao.Profilerepo;
import com.ajith.model.DocterModel;
import com.ajith.model.ProfilePhoto;
import com.ajith.request.DocterRequest;
import com.ajith.response.Docresponse;

@Service
public class DocterService {

	@Autowired
	DocterRepo db;

	@Autowired
	Profilerepo pdb;

	@Autowired
	Docresponse response;

	public ResponseEntity<Docresponse> save(DocterModel entity) {
		response.setDm(db.save(entity));
		response.setMsg("inserted succesfully");
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Docresponse> get(int id) {
		Optional<DocterModel> buf = db.findById(id);
		response.setDm(buf.orElse(null));
		if (buf.isPresent()) {
			response.setMsg("entry found");
			return new ResponseEntity<Docresponse>(response, HttpStatus.FOUND);
		} else {
			response.setMsg("not found");
			return new ResponseEntity<Docresponse>(response, HttpStatus.NOT_FOUND);
		}
	}

	public List<DocterModel> get() {
		return db.findAll();
	}

	public String delete(int id) {
		if (db.existsById(id)) {
			db.deleteById(id);
			return "entry " + id + " is deleted";
		}
		return "entry not found/ Already deleted";

	}

	public void delete() {
		db.deleteAll();
	}

	public ResponseEntity<Docresponse> update(int id, DocterRequest requestmodel) {
		if (db.existsById(id)) {
			DocterModel buf = get(id).getBody().getDm();
			if (requestmodel.getDocname() != null) {
				buf.setDocname(requestmodel.getDocname());
			}
			if (requestmodel.getExperience() != 0) {
				buf.setExperience(requestmodel.getExperience());
			}
			if (requestmodel.getMailId() != null) {
				buf.setMailId(requestmodel.getMailId());
			}
			System.out.println(buf);
			return save(buf);
		}
		response.setDm(null);
		response.setMsg("no entry found");
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

// profile photo
	public ResponseEntity<Object> upload(MultipartFile profile, int id) {
		if (db.existsById(id)) {
			ProfilePhoto dp = new ProfilePhoto();
			try {
				dp.setImageStream(ImageUtil.compressImage(profile.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			dp.setId(id);
			dp.setName(profile.getName());
			dp.setType(profile.getContentType());
			pdb.save(dp);
			return new ResponseEntity<>("profile uploaded", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("no Docter profile found", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> update(MultipartFile profile, int id) {
		if (pdb.existsById(id)) {
			upload(profile, id);
			return new ResponseEntity<>("profile updted", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("no Docter profile found", HttpStatus.NOT_FOUND);
	}

	public String removeprofile(int docid) {
		if (pdb.existsById(docid)) {
			pdb.deleteById(docid);
			return "entry " + docid + " is deleted";
		}
		return "entry not found/ Already deleted";
	}

	public ProfilePhoto view(int docid) {
		Optional<ProfilePhoto> dp = pdb.findById(docid);
		return dp.orElse(null);
   
	}

}
