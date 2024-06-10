package br.com.school.educanet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbVideoCourse;
import br.com.school.educanet.repository.VideoCourseRepository;
@RestController
public class VideoCourseController {
	
	@Autowired
	private VideoCourseRepository videoCourseRepository;
	
	
	@PostMapping("/videopost")
	public ResponseEntity<String>saveVideoCourse(@RequestBody TbVideoCourse tbVideoCourse){
		TbVideoCourse existingCourseNameCourse = videoCourseRepository.findByName(tbVideoCourse.getVideoCourseName());
		if(existingCourseNameCourse != null) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Nome já cadastado!");
		}
		  videoCourseRepository.save(tbVideoCourse);
		  return ResponseEntity.status(HttpStatus.CREATED).body("Video Curso Criado");	
	}
	
	
	
	@DeleteMapping("/video/{id}")
	public ResponseEntity<String>deleteVideoCourse(@PathVariable Integer id){
		Optional<TbVideoCourse> existingVideoCourse = videoCourseRepository.findById(id);
		if(existingVideoCourse != null) {
			videoCourseRepository.deleteById(id);
			return ResponseEntity.ok("Usuário apago com sucesso!");
		}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado!");
}
}