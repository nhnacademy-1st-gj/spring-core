package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CsvStudents implements Students {

   List<Student> studentList = new ArrayList<>();

   @Override
   public void load() {
      String[] line;
      String path = "src/main/resources/data/student.csv";

      try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
         while ((line = csvReader.readNext()) != null) {
            studentList.add(new Student(Integer.parseInt(line[0]), line[1]));
         }
      } catch (CsvException e) {
         throw new RuntimeException(e);
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

   }

   @Override
   public Collection<Student> findAll() {
      return studentList;
   }

   @Override
   public void merge(Collection<Score> scores) {
      for (Student student : studentList) {
         for (Score score : scores) {
            if (student.getSeq() == score.getStudentSeq()) {
               student.setScore(score);
            }
         }
      }

   }
}
