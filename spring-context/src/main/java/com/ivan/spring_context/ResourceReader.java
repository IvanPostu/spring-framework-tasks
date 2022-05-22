package com.ivan.spring_context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ivan
 */
public class ResourceReader {

    public static String readFromResources(String path) {

        try ( InputStream stream = ResourceReader.class.getResourceAsStream(path)) {
            String contents = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            
            return contents;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
