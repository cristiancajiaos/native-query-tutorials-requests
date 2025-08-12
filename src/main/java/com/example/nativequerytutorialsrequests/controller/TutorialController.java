package com.example.nativequerytutorialsrequests.controller;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
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
  public ResponseEntity<List<TutorialDTO>> getTutorialsByPublished(@PathVariable Boolean published) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByPublished(published);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/published-alt/{isPublished}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByPublishedAlt(@PathVariable Boolean isPublished) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByPublishedAlt(isPublished);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/title/{title}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByTitleLike(@PathVariable String title) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByTitleLike(title);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/title-ci/{title}")
  public ResponseEntity<List<TutorialDTO>> getTutorialesCaseInsensitiveByTitleLike(@PathVariable("title") String tutorialTitle) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialesCaseInsensitiveBeTitleLike(tutorialTitle);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/mixed/{isPublished}/{title}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByPublishedAndTitle(
      @PathVariable("isPublished") Boolean isPublished, @PathVariable String title) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialesByPublishedAndTitle(isPublished, title);
    return ResponseEntity.ok(tutorials);
  }
}
