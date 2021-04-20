package com.mindtree.company.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.company.exception.NoMindException;
import com.mindtree.company.exception.ServiceException;
import com.mindtree.company.model.Minds;
import com.mindtree.company.model.Track;
import com.mindtree.company.service.ServiceImpl;

@RestController
@RequestMapping(path = "/company")
public class MainController {
	private static final Logger LOG = Logger.getLogger(MainController.class.getName());
	@Autowired
	ServiceImpl service;

	@PostMapping("/addminds/{id}")
	public ResponseEntity<?> createMinds(@RequestBody Minds mind, @PathVariable("id") int id) {
		Minds mind1 = null;
		try {
			mind1 = service.addMinds(mind, id);
			LOG.log(Level.INFO, "Mind Added");
			return new ResponseEntity<>("Data Inserted", HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			LOG.log(Level.INFO, "Mind  failed to Add");
			return new ResponseEntity<>("Failed to insert", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/addtrack")
	public ResponseEntity<?> createTrack(@RequestBody Track track) {
		Track track1 = null;
		try {
			track1 = service.addTrack(track);
			LOG.log(Level.INFO, "Track Added");

		} catch (ServiceException e) {
			LOG.log(Level.INFO, "Track failed to Add");

			return new ResponseEntity<>("Failed to add track ", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>("track inserted", HttpStatus.ACCEPTED);

	}

	@GetMapping(path = "/all/{trackname}")
	public ResponseEntity<?> getAllMinds(@PathVariable("trackname") String trackname) {

		try {
			List<Minds> minds1 = service.getAllMindsData(trackname);
			LOG.log(Level.INFO, "Minds based on Track");

			return new ResponseEntity<>(minds1, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMind(@PathVariable("id") int id) throws ServiceException {
		try {
			service.deleteMindonId(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

		catch (NoMindException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{number}/{id}")
	public ResponseEntity<?> updateMindNumber(@PathVariable("number") String number, @PathVariable("id") Integer id) {
		Minds mind1 = null;
		try {
			mind1 = service.updateMindNumber(number, id);
			return new ResponseEntity<>("Updated", HttpStatus.ACCEPTED);
		} catch (NoMindException e) {
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
		}

	}
}
