package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Formatters {

    public void formatJson (String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            Object json = objectMapper.readValue(new File(inputFile), Object.class);
            objectMapper.writeValue(new File(outputFile), json);
            System.out.println("Formatted JSON saved as: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error formatting JSON: " + e.getMessage());
        }
    }

}
