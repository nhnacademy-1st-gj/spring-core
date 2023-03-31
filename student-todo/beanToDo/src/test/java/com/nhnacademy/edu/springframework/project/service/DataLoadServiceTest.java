package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.RepositoryConfig;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfig.class})
class DataLoadServiceTest {

   @Autowired
   private DataLoadService dataLoadService;

   @Autowired
   private Students students;

   @Autowired
   private Scores scores;



   @Test
   void loadAndMerge() {

      dataLoadService.loadAndMerge();

      Assertions.assertThat(scores.findAll()).isNotEmpty();
      Assertions.assertThat(students.findAll()).isNotEmpty();
   }

}