package br.com.school.educanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbVideoCourse;

@Repository
public interface VideoCourseRepository extends JpaRepository<TbVideoCourse, Integer> {
	
	@Query("select c from TbVideoCourse c where c.videoCourseName= :Name")
	TbVideoCourse findByName(@Param("Name") String videoCourseName);
}
