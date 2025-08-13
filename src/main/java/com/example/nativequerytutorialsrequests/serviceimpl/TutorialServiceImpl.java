package com.example.nativequerytutorialsrequests.serviceimpl;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import com.example.nativequerytutorialsrequests.record.TutorialDTO;
import com.example.nativequerytutorialsrequests.repository.TutorialRepository;
import com.example.nativequerytutorialsrequests.service.TutorialService;
import java.util.Date;
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

  @Override
  public List<TutorialDTO> getAllTutorials() {
    return tutorialRepository.getAllTutorials().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByPublished(Boolean published) {
    return tutorialRepository.getTutorialsByPublished(published).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByPublishedAlt(Boolean isPublished) {
    return tutorialRepository.getTutorialsByPublishedAlt(isPublished).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByTitleLike(String title) {
    return tutorialRepository.getTutorialsByTitleLike(title).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialesCaseInsensitiveBeTitleLike(String title) {
    return tutorialRepository.getTutorialsCaseInsensitiveByTitleLike(title).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByLevelGreaterThan(int level) {
    return tutorialRepository.getTutorialsByLevelGreaterThan(level).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByLevelLowerOrEqualThan(int level) {
    return tutorialRepository.getTutorialsByLevelLowerOrEqualThan(level).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialsByLevelBetween(int start, int end) {
    return tutorialRepository.getTutorialsByLevelBetween(start, end).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialesCreatedByDateGreaterEqualThan(Date date) {
    return tutorialRepository.getTutorialsByDateGreaterEqualThan(date).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<TutorialDTO> getTutorialesByPublishedAndTitle(Boolean isPublished, String title) {
    return tutorialRepository.getTutorialsByPublishedAndTitle(isPublished, title).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  private Tutorial convertToEntity(TutorialDTO tutorialDTO) {
    return new Tutorial(tutorialDTO.id(), tutorialDTO.title(), tutorialDTO.description(), tutorialDTO.level(), tutorialDTO.published(), tutorialDTO.createdAt());
  }

  private TutorialDTO convertToDTO(Tutorial tutorial) {
    return new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.getLevel(), tutorial.isPublished(), tutorial.getCreatedAt());
  }
}
