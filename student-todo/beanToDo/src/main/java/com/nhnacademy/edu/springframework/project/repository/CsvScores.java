package com.nhnacademy.edu.springframework.project.repository;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvScores implements Scores {

   List<Score> scoreList = new ArrayList<>();

   @Override
   public void load() {

      String[] line;
      String path = "src/main/resources/data/score.csv";

      try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
         while ((line = csvReader.readNext()) != null) {
            scoreList.add(new Score(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
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
   public List<Score> findAll() {
      return scoreList;
   }
}
