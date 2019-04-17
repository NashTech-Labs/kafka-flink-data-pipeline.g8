package com.knoldus.demo;

import com.knoldus.demo.flink.FlinkStreamProcessor;

public class StreamDemo {
    
    public static void main(String[] args) throws Exception {
        
        FlinkStreamProcessor streamProcessor = new FlinkStreamProcessor();
        System.out.println("\n\n net runtime is:: " + streamProcessor.capitalize());
    }
}
