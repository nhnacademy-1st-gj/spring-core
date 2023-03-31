package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultStudentService implements StudentService {
   private final Students studentRepository;

   public DefaultStudentService(Students studentRepository) {
      this.studentRepository = studentRepository;
   }

   @Override
   public Collection<Student> getPassedStudents() {
      return studentRepository.findAll().stream().filter(x -> !(x.getScore().isFail())).collect(Collectors.toList());
   }

   @Override
   public Collection<Student> getStudentsOrderByScore() {
      List<Student> collect = studentRepository.findAll().stream().sorted(Comparator.comparingInt(s -> s.getScore().getScore())).collect(Collectors.toList());
      Collections.reverse(collect);
      return collect;
   }

}
