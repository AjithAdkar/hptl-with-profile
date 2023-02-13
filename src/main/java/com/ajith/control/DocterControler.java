package com.ajith.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ajith.model.DocterModel;
import com.ajith.model.ProfilePhoto;
import com.ajith.request.DocterRequest;
import com.ajith.response.Docresponse;
import com.ajith.service.DocterService;

@RestController
@RequestMapping("/Doc")
public class DocterControler {

	@Autowired
	DocterService service;

	@GetMapping("/get")
	private List<DocterModel> getall() {
		System.out.println("invoked");
		return service.get();
	}

	@GetMapping("/get/{id}")
	private ResponseEntity<Docresponse> getid(@PathVariable int id) {
		return service.get(id);
	}

	@PostMapping("/save")
	private ResponseEntity<Docresponse> save(@RequestBody(required = true) DocterModel requestmodel) {
		return service.save(requestmodel);

	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Docresponse> update(@RequestBody(required = true) DocterRequest requestmodel,
			@PathVariable int id) {
		return service.update(id, requestmodel);
	}

	@DeleteMapping("/deleteAll")
	private String delete() {
		service.delete();
		return "database is cleared";
	}

	@DeleteMapping("/delete/{id}")
	private String delete(@PathVariable int id) {
		return service.delete(id);

	}
// profile photo 
	
	@PostMapping("/upload/{id}")
	private ResponseEntity<Object> addprofile(@RequestParam("file") MultipartFile profile, @PathVariable int id) {
		System.out.println(profile.getSize());
		if (profile.isEmpty()) {
			return new ResponseEntity<>("no file found", HttpStatus.BAD_REQUEST);
		}
		System.out.println("not emt");
		return service.upload(profile, id);
	}

	@PutMapping("/change/{id}")
	private ResponseEntity<Object> Updateprofile(@RequestParam("file") MultipartFile profile, @PathVariable int id) {
		if (profile.isEmpty())
			return new ResponseEntity<>("no file found", HttpStatus.BAD_REQUEST);
		return service.update(profile, id);

	}

	@DeleteMapping("/remove/{id}")
	private String deleteprofile(@PathVariable(name = "id") int docid) {
		return service.removeprofile(docid);
	}

	@GetMapping("/view/{id}")
	private ProfilePhoto viewprofile(@PathVariable(name = "id") int docid) {
		return service.view(docid);
	}
}
