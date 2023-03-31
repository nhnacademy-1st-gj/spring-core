package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultGradeQueryService implements GradeQueryService {

   private final Students studentsRepository;
   private final Scores scoresRepository;

   public DefaultGradeQueryService(Students studentsRepository, Scores scoresRepository) {
      this.studentsRepository = studentsRepository;
      this.scoresRepository = scoresRepository;
   }


   @Override
   public List<Score> getScoreByStudentName(String name) {
      return studentsRepository.findAll().stream().filter(x -> x.getName().equals(name)).map(x -> x.getScore()).collect(Collectors.toList());
   }

   @Override
   public Score getScoreByStudentSeq(int seq) {
      return scoresRepository.findAll().stream().filter(x -> x.getStudentSeq() == seq).findFirst().orElseThrow(IllegalArgumentException::new);
   }
}
