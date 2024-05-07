package com.jovisco.basics.files;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkWithFilesTest {

    private final String FILE_NAME = "./testfile.txt";

    private Path path = Paths.get(FILE_NAME);

    private final String text = "Das ist ein Test mit Umlauten: ä,ö,ü und ß.";

    @BeforeEach
    @AfterEach
    void beforeEach() throws IOException {
        Files.deleteIfExists(path);
    }

    @Test
    void testCreateFile() throws IOException {
        Path file = Files.createFile(path);
        assertThat(file).isNotNull();
        Files.writeString(file, text);
        String result = Files.readString(file);
        assertThat(text).isEqualTo(result);
    }

    @Test
    void testCreateFileOutputStream() throws IOException {
        // write the text
        try (
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos)
        ) {
            dos.writeUTF(text);
        }
        // ... and read the text
        try (
            FileInputStream fis = new FileInputStream(FILE_NAME);
            DataInputStream dis = new DataInputStream(fis)
        ) {
            var result = dis.readUTF();
            System.out.println(result);
            System.out.flush();
            assertThat(result).isEqualTo(text);
        }
    }
}
