package com.example.nativequerytutorialsrequests.controller;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import com.example.nativequerytutorialsrequests.service.TutorialService;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  public ResponseEntity<List<TutorialDTO>> getTutorialsCaseInsensitiveByTitleLike(@PathVariable("title") String tutorialTitle) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialesCaseInsensitiveByTitleLike(tutorialTitle);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/level/greater-than/{level}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByLevelGreaterThan(@PathVariable int level) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByLevelGreaterThan(level);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/level/lower-equal-than/{level}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByLevelLowerOrEqualThan(@PathVariable int level) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByLevelLowerOrEqualThan(level);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/level/between/{start}/{end}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByLevelBetween(@PathVariable int start, @PathVariable int end) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialsByLevelBetween(start, end);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/created-at/greater-equal-than/{date}")
  public ResponseEntity<List<TutorialDTO>> getTutorialesByDateGreaterEqualThan(@PathVariable("date") String dateStr) {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr, new ParsePosition(0));
    List<TutorialDTO> tutoriales = tutorialService.getTutorialsCreatedByDateGreaterEqualThan(date);
    return ResponseEntity.ok(tutoriales);
  }

  @GetMapping("/created-at/between/{start}/{end}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsCreatedByDateBetween(@PathVariable("start") String startDateStr, @PathVariable("end") String endDateStr) {
    String patternStr = "yyyy-MM-dd";
    Date startDate = new SimpleDateFormat(patternStr).parse(startDateStr, new ParsePosition(0));
    Date endDate = new SimpleDateFormat(patternStr).parse(endDateStr, new ParsePosition(0));
    List<TutorialDTO> tutorials = tutorialService.getTutorialsCreatedByDateBetween(startDate, endDate);
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/mixed/{isPublished}/{title}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByPublishedAndTitle(
      @PathVariable("isPublished") Boolean isPublished, @PathVariable String title) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialesByPublishedAndTitle(isPublished, title);
    return ResponseEntity.ok(tutorials);
  }
}
