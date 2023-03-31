package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.RepositoryConfig;
import com.nhnacademy.edu.springframework.project.service.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfig.class})
class StudentsTest {

   static Students students;

   @BeforeAll
   public static void init() {
      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RepositoryConfig.class);
      students = applicationContext.getBean(CsvStudents.class);
   }

   @Test
   void load() throws NoSuchFieldException, IllegalAccessException {

      students.load();
      Field field = CsvStudents.class.getDeclaredField("studentList");
      field.setAccessible(true);
      List<Student> studentList = (List<Student>) field.get(students);
      Assertions.assertThat(studentList).isNotEmpty();
   }

   @Test
   void findAll() throws NoSuchFieldException, IllegalAccessException {
      List<Student> studentList = new ArrayList<>();
      char charNum = 65;
      for (int i = 0; i < 10; i++) {
         Student tempStudent = new Student(i, String.valueOf((char) charNum));
         studentList.add(tempStudent);
         charNum++;
      }

      Field field = CsvStudents.class.getDeclaredField("studentList");

      field.set(students, studentList);

      Collection<Student> all = students.findAll();
      Assertions.assertThat(all).isEqualTo(studentList);
   }

   @Test
   void merge() throws NoSuchFieldException, IllegalAccessException {
      List<Student> studentList = new ArrayList<>();
      char charNum = 65;
      for (int i = 0; i < 10; i++) {
         Student tempStudent = new Student(i, String.valueOf((char) charNum));
         studentList.add(tempStudent);
         charNum++;
      }
      List<Score> scoreList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         Score tempScore = new Score(i, 10 * i);
         scoreList.add(tempScore);
      }
      Field field = CsvStudents.class.getDeclaredField("studentList");
      field.setAccessible(true);
      field.set(students, studentList);

      students.merge(scoreList);

      List<Student> finalStudentList = (List<Student>) field.get(students);
      for (Student student : finalStudentList) {
         Assertions.assertThat(student.getScore().getStudentSeq()).isEqualTo(student.getSeq());

      }


   }
}