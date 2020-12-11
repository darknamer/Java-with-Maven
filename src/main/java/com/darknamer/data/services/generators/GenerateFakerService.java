package com.darknamer.data.services.generators;

import com.darknamer.core.interfaces.IGenerateFakerService;
import com.darknamer.core.viewmodels.UserTextInstance;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateFakerService implements IGenerateFakerService {
    /**
     * Generate file text
     */
    public void Generate() {
        int maxRow = 10000;
        Faker faker;
        List<UserTextInstance> users = new ArrayList<>();
        for (int i = 0; i < maxRow; i++) {
            faker = new Faker();

            UserTextInstance user = new UserTextInstance();
            user.username = faker.name().username();
            user.fullName = faker.name().fullName();
            user.firstName = faker.name().firstName();
            user.lastName = faker.name().lastName();
            user.birthday = faker.date().birthday().toString();

            users.add(user);
        }

        try {
            String pathFile = "D:\\faker_users.txt";
            File file = new File(pathFile);
            if (file.exists()) {
                file.delete();
            }

            FileWriter fw = new FileWriter("D:\\faker_users.txt");
            for (UserTextInstance user : users) {
                List<String> arrayUser = Arrays.asList(
                        user.username,
                        user.fullName,
                        user.firstName,
                        user.lastName,
                        user.birthday);
                String result = String.join("|", arrayUser);
                fw.write(result + "\n");
            }
            fw.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
