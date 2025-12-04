package com.kondratiev.st.reader.impl;

import com.kondratiev.st.exception.TextOperatingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.kondratiev.st.reader.TextReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public String readFile(String path) throws TextOperatingException {
        try {
            URL resource = getClass().getClassLoader().getResource(path);

            if (resource == null) {
                throw new TextOperatingException("File not found: " + path);
            }

            Path filePath = Path.of(resource.toURI());
            String result = Files.readString(filePath);
            logger.info("File {} read successfully", filePath);
            return result;

        } catch (IOException e) {
            throw new TextOperatingException("IO problem while reading file "+path, e);
        } catch (URISyntaxException e) {
            throw new TextOperatingException("Uri problem for file "+path, e);
        }
    }
}
