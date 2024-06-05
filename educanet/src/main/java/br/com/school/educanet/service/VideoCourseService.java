package br.com.school.educanet.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.school.educanet.model.TbVideoCourse;
import br.com.school.educanet.repository.VideoCourseRepository;

public class VideoCourseService {
		
	@Autowired
		VideoCourseRepository videoCourseRepository;
		
	
		
		public TbVideoCourse saveVideoCourse(TbVideoCourse tbVideoCourse ) {
			if (videoCourseRepository.findByName(tbVideoCourse.getVideoCourseName()) == null) {
				return videoCourseRepository.save(tbVideoCourse);
			}
			return null;		
		}
		
		
		
		public void deleteVideoCourse(Integer id ) {
			if (videoCourseRepository.findById(id) != null) {
			 videoCourseRepository.deleteById(id);
			}
            throw new RuntimeException("video não encontrado!");
		}
		
		
		
		public TbVideoCourse updateVideoCourse(Integer courseId, TbVideoCourse updatedCourse) {
	        TbVideoCourse existingCourse = videoCourseRepository.findById(courseId)
	                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

	        if (updatedCourse.getVideoCourseDescription() != null) {
	            existingCourse.setVideoCourseDescription(updatedCourse.getVideoCourseDescription());
	        }
	        if (updatedCourse.getTbCourse() != null) {
	            existingCourse.setTbCourse(updatedCourse.getTbCourse());
	        }
	        if (updatedCourse.getVideoCourseUrlId() != null) {
	            existingCourse.setVideoCourseUrlId(updatedCourse.getVideoCourseUrlId());
	        }
	        if (updatedCourse.getVideoCourseName() != null) {
	            existingCourse.setVideoCourseName(updatedCourse.getVideoCourseName());
	        }
	        return videoCourseRepository.save(existingCourse);
		}
		
}