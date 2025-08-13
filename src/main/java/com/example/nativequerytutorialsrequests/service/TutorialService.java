package com.example.nativequerytutorialsrequests.service;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface TutorialService {

  List<TutorialDTO> getAllTutorials();

  Page<TutorialDTO> getAllTutorials(Pageable pageable);

  List<TutorialDTO> getTutorialsByPublished(Boolean published);

  List<TutorialDTO> getTutorialsByPublishedAlt(Boolean isPublished);

  List<TutorialDTO> getTutorialsByTitleLike(String title);

  List<TutorialDTO> getTutorialesCaseInsensitiveByTitleLike(String title);

  List<TutorialDTO> getTutorialsByLevelGreaterThan(int level);

  List<TutorialDTO> getTutorialsByLevelLowerOrEqualThan(int level);

  List<TutorialDTO> getTutorialsByLevelBetween(int start, int end);

  List<TutorialDTO> getTutorialsByLevelOrderAsc();

  List<TutorialDTO> getTutorialsByLevelOrderDesc();

  List<TutorialDTO> getTutorialsCreatedByDateGreaterEqualThan(Date date);

  List<TutorialDTO> getTutorialsCreatedByDateBetween(Date start, Date end);

  List<TutorialDTO> getTutorialsCreatedByDateAsc();

  List<TutorialDTO> getTutorialsCreatedByDateDesc();

  List<TutorialDTO> getTutorialesByPublishedAndTitle(Boolean isPublished, String title);

}
