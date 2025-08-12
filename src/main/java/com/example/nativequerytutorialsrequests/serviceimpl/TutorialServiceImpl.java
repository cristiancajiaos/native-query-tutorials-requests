package com.example.nativequerytutorialsrequests.serviceimpl;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import com.example.nativequerytutorialsrequests.repository.TutorialRepository;
import com.example.nativequerytutorialsrequests.service.TutorialService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TutorialServiceImpl implements TutorialService {

  private final TutorialRepository tutorialRepository;

  public TutorialServiceImpl(
      TutorialRepository tutorialRepository) {
    this.tutorialRepository = tutorialRepository;
  }

  private Tutorial convertToEntity(TutorialDTO tutorialDTO) {
    return new Tutorial(tutorialDTO.id(), tutorialDTO.title(), tutorialDTO.description(), tutorialDTO.level(), tutorialDTO.published(), tutorialDTO.createdAt());
  }

  private TutorialDTO convertToDTO(Tutorial tutorial) {
    return new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.getLevel(), tutorial.isPublished(), tutorial.getCreatedAt());
  }

  @Override
  public List<TutorialDTO> getAllTutorials() {
    return tutorialRepository.getAllTutorials().stream().map(this::convertToDTO).collect(Collectors.toList());
  }
}
