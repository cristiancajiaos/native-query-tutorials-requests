package com.example.nativequerytutorialsrequests.repository;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials t", nativeQuery = true)
  List<Tutorial> getAllTutorials();

  @Query(value = "SELECT * FROM tutorials t WHERE t.published = ?1", nativeQuery = true)
  List<Tutorial> getTutorialsByPublished(Boolean published);

  @Query(value = "select * FROM tutorials t WHERE t.published = :isPublished", nativeQuery = true)
  List<Tutorial> getTutorialsByPublishedAlt(@Param("isPublished") Boolean isPublished);

  @Query(value = "select * FROM tutorials t WHERE t.title LIKE %?1%", nativeQuery = true)
  List<Tutorial> getTutorialsByTitleLike(String title);

  @Query(value = "select * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :title, '%'))", nativeQuery = true)
  List<Tutorial> getTutorialsCaseInsensitiveByTitleLike(@Param("title") String title);

  @Query(value = "select * FROM tutorials t WHERE t.level > :level", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelGreaterThan(@Param("level") int level);

  @Query(value = "select * FROM tutorials t WHERE t.level <= :level", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelLowerOrEqualThan(@Param("level") int level);

  @Query(value = "select * FROM tutorials t WHERE t.published = :isPublished AND t.title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
  List<Tutorial> getTutorialsByPublishedAndTitle(@Param("isPublished") Boolean isPublished, @Param("title") String title);

}
