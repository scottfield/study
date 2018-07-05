package com.jackie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonTokenId;

public class ReadLargeJsonDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.json");
//        write(file);
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(file);
        int counter = 0;
        while(parser.nextToken() != JsonToken.END_ARRAY){
            String fieldname = parser.getCurrentName();
            if("username".equals(fieldname) && parser.currentTokenId() == JsonTokenId.ID_STRING){
//                parser.nextToken();
                counter++;
                System.out.println(parser.getValueAsString());
            }
        }
        parser.close();
        System.out.println(counter);

    }

    private static void write(File file) throws IOException {
        try(FileOutputStream os = new FileOutputStream(file)){
            JsonFactory factory = new JsonFactory();
            JsonGenerator generator = factory.createGenerator(os);
            generator.writeStartArray();
            for(int i = 0; i < 10; i++){
                generator.writeStartObject();
                generator.writeObjectField("username", "jackie");
                generator.writeObjectField("money", i);
                generator.writeEndObject();
            }
            generator.writeEndArray();
            generator.close();
        }
    }
}
