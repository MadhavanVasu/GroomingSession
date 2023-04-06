package com.mv.week3;

import java.io.FileOutputStream;
import java.io.IOException;


// Byte streams in Java are used to perform input and output operations of 8-bit bytes
// While the Character stream is used to perform input and output operations for 16-bits Unicode.
// Character streams are useful in reading or writing text files which are processed character by character.
// Byte Streams are useful to read/write data from raw binary files.

public class FileInputAndOutputStream {
    public static void main(String[] args) {

        String fileContent = "Welcome to geeksforgeeks";
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("File_Op_Stream.txt");

            Student s1 = new Student("Maddy", 22);

            byte[] strToBytes = fileContent.getBytes();

            outputStream.write(strToBytes);

            System.out.print("File is created successfully with the content.");
        } catch (IOException e) {

            System.out.print(e.getMessage());
        } finally {

            if (outputStream != null) {

                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.print(e.getMessage());
                }
            }
        }
    }
}


