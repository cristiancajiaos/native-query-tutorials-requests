package com.example.nativequerytutorialsrequests.controller;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import com.example.nativequerytutorialsrequests.service.TutorialService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tutorials")
public class TutorialController {

  private final TutorialService tutorialService;

  public TutorialController(
      TutorialService tutorialService) {
    this.tutorialService = tutorialService;
  }

  @GetMapping
  public ResponseEntity<List<TutorialDTO>> getAllTutorials() {
    List<TutorialDTO> tutorials = tutorialService.getAllTutorials();
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/published/{published}")
  public ResponseEntity<List<TutorialDTO>> getAllTutorialsByPublished(@PathVariable Boolean published) {
    List<TutorialDTO> tutorials = tutorialService.getAllTutorialsByPublished(published);
    return ResponseEntity.ok(tutorials);
  }
}
