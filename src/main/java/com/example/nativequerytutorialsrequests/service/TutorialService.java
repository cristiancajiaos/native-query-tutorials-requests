package com.example.nativequerytutorialsrequests.service;

import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import java.util.List;

public interface TutorialService {

  List<TutorialDTO> getAllTutorials();

  List<TutorialDTO> getAllTutorialsByPublished(Boolean published);

  List<TutorialDTO> getAllTutorialesByPublishedAlt(Boolean isPublished);

}
