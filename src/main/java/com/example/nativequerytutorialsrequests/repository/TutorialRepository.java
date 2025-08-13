package com.example.nativequerytutorialsrequests.repository;

import com.example.nativequerytutorialsrequests.entity.Tutorial;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>, PagingAndSortingRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials t", nativeQuery = true)
  List<Tutorial> getAllTutorials();

  @Query(value = "SELECT * FROM tutorials t WHERE t.published = ?1", nativeQuery = true)
  List<Tutorial> getTutorialsByPublished(Boolean published);

  @Query(value = "select * FROM tutorials t WHERE t.published = :isPublished", nativeQuery = true)
  List<Tutorial> getTutorialsByPublishedAlt(@Param("isPublished") Boolean isPublished);

  @Query(value = "select * FROM tutorials t WHERE t.published = :isPublished", nativeQuery = true)
  Page<Tutorial> getTutorialesByPublishedPaged(@Param("isPublished") Boolean isPublished, Pageable pageable);

  @Query(value = "select * FROM tutorials t WHERE t.title LIKE %?1%", nativeQuery = true)
  List<Tutorial> getTutorialsByTitleLike(String title);

  @Query(value = "select * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :title, '%'))", nativeQuery = true)
  List<Tutorial> getTutorialsCaseInsensitiveByTitleLike(@Param("title") String title);

  @Query(value = "select * FROM tutorials t WHERE t.level > :level", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelGreaterThan(@Param("level") int level);

  @Query(value = "select * FROM tutorials t WHERE t.level <= :level", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelLowerOrEqualThan(@Param("level") int level);

  // Between incluye ambas fechas límite
  @Query(value = "select * FROM tutorials t WHERE t.level BETWEEN :start AND :end", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelBetween(@Param("start") int start, @Param("end") int end);

  @Query(value = "select * FROM tutorials t ORDER BY t.level ASC", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelOrderAsc();

  @Query(value = "select * FROM tutorials t ORDER BY t.level DESC", nativeQuery = true)
  List<Tutorial> getTutorialsByLevelOrderDesc();

  @Query(value = "select * FROM tutorials t WHERE t.created_at >= :date", nativeQuery = true)
  List<Tutorial> getTutorialsCreatedByDateGreaterEqualThan(@Param("date") Date date);

  // Between incluye ambas fechas límite
  @Query(value = "select * FROM tutorials t WHERE t.created_at BETWEEN :startDate AND :endDate", nativeQuery = true)
  List<Tutorial> getTutorialsCreatedByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

  @Query(value = "select * FROM tutorials t ORDER BY t.created_at ASC", nativeQuery = true)
  List<Tutorial> getTutorialsCreatedByDateAsc();

  @Query(value = "select * FROM tutorials t ORDER BY t.created_at DESC", nativeQuery = true)
  List<Tutorial> getTutorialsCreatedByDateDesc();

  @Query(value = "select * FROM tutorials t WHERE t.published = :isPublished AND t.title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
  List<Tutorial> getTutorialsByPublishedAndTitle(@Param("isPublished") Boolean isPublished, @Param("title") String title);

}
