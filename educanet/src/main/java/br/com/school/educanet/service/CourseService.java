package br.com.school.educanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	
	public TbCourse SaveCourse(TbCourse tbCourse) {
		if (courseRepository.findByName(tbCourse.getCouserName()) != null) {
			throw new RuntimeException("Já existe curso com este nome!");
		}
		return courseRepository.save(tbCourse);
	}

	
	public void DeleteCourse(Integer couserId ) {
			if(courseRepository.findById(couserId) != null){
			 courseRepository.deleteById(couserId);
			}
            throw new RuntimeException("Curso não encontrado!");
	}
	
	
	public TbCourse updateCourse(Integer courseId, TbCourse updatedCourse) {
        TbCourse existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        if (updatedCourse.getCouserName() != null) {
            existingCourse.setCouserName(updatedCourse.getCouserName());
        }
        if (updatedCourse.getWorkload() != null) {
            existingCourse.setWorkload(updatedCourse.getWorkload());
        }
        if (updatedCourse.getDescrpition() != null) {
            existingCourse.setDescrpition(null);
        }
        if (updatedCourse.getCourseClass() != null) {
            existingCourse.setCourseClass(updatedCourse.getCourseClass());
        }
        return courseRepository.save(existingCourse);
	}
}