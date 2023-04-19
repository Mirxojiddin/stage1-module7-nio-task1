package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name;
        String email;
        int age;
        long phone;
        String ress = "";
        try (FileInputStream fis = new FileInputStream(new File(file.getAbsolutePath()))) {
            byte[] bytes = new byte[8192];
            while (fis.read(bytes) != -1)
                ress += new String(bytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arrayString = ress.split("\n");
        String[] arrOfStr = arrayString[0].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        name = arrOfStr[1];
        arrOfStr = arrayString[1].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        age = Integer.parseInt(arrOfStr[1]);
        arrOfStr = arrayString[2].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        email = arrOfStr[1];
        arrOfStr = arrayString[3].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        phone = Long.parseLong(arrOfStr[1]);

        return new Profile(name, age, email, phone);
    }
}
