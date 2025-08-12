package com.example.nativequerytutorialsrequests.service;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import java.util.List;

public interface TutorialService {

  List<TutorialDTO> getAllTutorials();

  List<TutorialDTO> getTutorialsByPublished(Boolean published);

  List<TutorialDTO> getTutorialsByPublishedAlt(Boolean isPublished);

  List<TutorialDTO> getTutorialesByTitleLike(String title);

}
