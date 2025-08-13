package com.example.nativequerytutorialsrequests.controller;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import com.example.nativequerytutorialsrequests.service.TutorialService;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /* Actualizaciones */

  @PutMapping("/publish-tutorial/{id}")
  public ResponseEntity<TutorialDTO> publishTutorial(@PathVariable Long id) {
    TutorialDTO tutorial = tutorialService.publishTutorial(id);
    return ResponseEntity.ok(tutorial);
  }

  /* Consultas */

  @GetMapping
  public ResponseEntity<List<TutorialDTO>> getAllTutorials() {
    List<TutorialDTO> tutorials = tutorialService.getAllTutorials();
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/id/order")
  public ResponseEntity<List<TutorialDTO>> getAllTutorialsOrderById() {
    List<TutorialDTO> tutorials = tutorialService.getAllTutorialsOrderById();
    return ResponseEntity.ok(tutorials);
  }

  @GetMapping("/paging")
  public ResponseEntity<Page<TutorialDTO>> getAllTutorials(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size
  ) {
    Pageable pageable = PageRequest.of(page, size);
    Page<TutorialDTO> pagedTutorials = tutorialService.getAllTutorials(pageable);
    return ResponseEntity.ok(pagedTutorials);
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

  @GetMapping("/published-paged/{isPublished}")
  public ResponseEntity<Page<TutorialDTO>> getTutorialsByPublishedPaged(
      @PathVariable Boolean isPublished,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "published") String sortBy,
      @RequestParam(defaultValue = "true") boolean ascending) {
    Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<TutorialDTO> tutorials = tutorialService.getTutorialsByPublishedPaged(isPublished, pageable);
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

  @GetMapping("/level/order/{order}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByLevelOrder(@PathVariable String order) {
    List<TutorialDTO> tutorials = new ArrayList<TutorialDTO>();
    try {
      if (order.equals("asc")) {
        tutorials = tutorialService.getTutorialsByLevelOrderAsc();
      } else if (order.equals("desc")) {
        tutorials = tutorialService.getTutorialsByLevelOrderDesc();
      } else {
        throw new Error("Invalid order parameter");
      }
      return ResponseEntity.ok(tutorials);
    } catch(Exception e) {
      System.err.println("Error: " + e);
      return ResponseEntity.badRequest().build();
    }
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

  @GetMapping("/created-at/order/{order}")
  public ResponseEntity<List<TutorialDTO>> getTutorialesCreatedByDateOrder(@PathVariable("order") String order) {
    List<TutorialDTO> tutorials = new ArrayList<>();
    try {
      if (order.equals("asc")) {
        tutorials = tutorialService.getTutorialsCreatedByDateAsc();
      } else if (order.equals("desc")) {
        tutorials = tutorialService.getTutorialsCreatedByDateDesc();
      } else {
        throw new Error("Invalid order parameter");
      }
      return ResponseEntity.ok(tutorials);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/mixed/{isPublished}/{title}")
  public ResponseEntity<List<TutorialDTO>> getTutorialsByPublishedAndTitle(
      @PathVariable("isPublished") Boolean isPublished, @PathVariable String title) {
    List<TutorialDTO> tutorials = tutorialService.getTutorialesByPublishedAndTitle(isPublished, title);
    return ResponseEntity.ok(tutorials);
  }
}
