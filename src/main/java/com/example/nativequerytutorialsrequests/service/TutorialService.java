package com.example.nativequerytutorialsrequests.service;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface TutorialService {

  List<TutorialDTO> getAllTutorials();

  List<TutorialDTO> getTutorialsByPublished(Boolean published);

  List<TutorialDTO> getTutorialsByPublishedAlt(Boolean isPublished);

  List<TutorialDTO> getTutorialsByTitleLike(String title);

  List<TutorialDTO> getTutorialesCaseInsensitiveBeTitleLike(String title);

  List<TutorialDTO> getTutorialesByPublishedAndTitle(Boolean isPublished, String title);

}
