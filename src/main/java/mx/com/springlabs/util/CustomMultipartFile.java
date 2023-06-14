/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.springlabs.util;

import java.io.*;

import org.springframework.web.multipart.MultipartFile;

/*
Referencia:::
https://www.baeldung.com/java-convert-byte-array-to-multipartfile
 */
public class CustomMultipartFile implements MultipartFile {

    private byte[] input;

    public CustomMultipartFile(byte[] input) {
        this.input = input;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOriginalFilename() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    //We've defined the rest of the interface methods in the next snippet
    //previous methods
    @Override
    public boolean isEmpty() {
        return input == null || input.length == 0;
    }

    @Override
    public long getSize() {
        return input.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return input;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(input);
    }

    @Override
    public void transferTo(File destination) throws IOException, IllegalStateException {
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            fos.write(input);
        }
    }

//    @Override
//    public void transferTo(File destination) throws IOException, IllegalStateException {
//        Path path = Paths.get(destination.getPath());
//        Files.write(path, input);
//    }
//    @Override
//public void transferTo(File destination) throws IOException, IllegalStateException {
//        FileUtils.writeByteArrayToFile(destination, input);
//}
}
