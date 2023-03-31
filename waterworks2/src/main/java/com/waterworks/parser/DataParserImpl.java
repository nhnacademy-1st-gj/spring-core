package com.waterworks.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
public class DataParserImpl implements DataParser{

   PriorityQueue<List<String>> rateQueue = new PriorityQueue<>(new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {

         String[] o1Split = o1.get(0).split(",");
         String[] o2Split = o2.get(0).split(",");
         int firstValue = Integer.parseInt(o1Split[6]);
         int secondValue = Integer.parseInt(o2Split[6]);
         if(firstValue == secondValue){
            return Integer.compare(secondValue,firstValue);
         }
         return Integer.compare(firstValue,secondValue);
      }
   });

   @Override
   public PriorityQueue<List<String>> parseCsvToQueue(String path) throws IOException {
      File file = new File(path);
      try{
         BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()));
         while((bufferedReader.readLine())!=null){
            List<String> getSingleList = new ArrayList<>();
            String[] split = bufferedReader.readLine().split(",");
            for(int i =0; i<split.length;i++){
               getSingleList.add(split[i]);
            }
            
//            getSingleList.add(bufferedReader.readLine());
            rateQueue.add(getSingleList);
         }
         
         while(true){
            List<String> poll = rateQueue.poll();
            for (String s : poll) {
               
            }
            
         }

      }catch (RuntimeException e){
         e.printStackTrace();
      }
      return rateQueue;
   }

   public static void main(String[] args) throws IOException {
      DataParserImpl dataParser = new DataParserImpl();
      dataParser.parseCsvToQueue("src/main/resources/Tariff_20220331.csv");
   }


   /*
}
   PriorityQueue<List<String>> rateQueue = new PriorityQueue<>(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
         int firstValue = Integer.parseInt(o1[6]);
         int secondValue = Integer.parseInt(o2[6]);
         if(firstValue == secondValue){
            return Integer.compare(secondValue,firstValue);
         }
         return Integer.compare(firstValue,secondValue);
      }
   });

   @Override
   public PriorityQueue<String[]> parseCsvToQueue(String path) throws IOException {
      /*
      try(CSVReader csvReader = new CSVReader(new FileReader(path))) {
         while(csvReader.readNext() != null){
            rateQueue.add(csvReader.readNext());
         }
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      } catch (CsvValidationException e) {
         throw new RuntimeException(e);
      }

      return rateQueue;

   }

      File file = new File(path);
      BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()));
      String line="";
      while((line= bufferedReader.readLine())!=null){
         rateQueue.add(bufferedReader.readLine());
      }
      */

}


