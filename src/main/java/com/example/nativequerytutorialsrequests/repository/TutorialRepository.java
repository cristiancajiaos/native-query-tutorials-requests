package com.example.nativequerytutorialsrequests.repository;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
