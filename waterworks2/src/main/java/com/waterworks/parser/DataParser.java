package com.waterworks.parser;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

public interface DataParser {
   public PriorityQueue<List<String>> parseCsvToQueue(String path) throws IOException;
}
