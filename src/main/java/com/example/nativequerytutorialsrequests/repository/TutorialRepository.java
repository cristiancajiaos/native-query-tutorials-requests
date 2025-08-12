package com.example.nativequerytutorialsrequests.repository;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials t", nativeQuery = true)
  List<Tutorial> getAllTutorials();

}
