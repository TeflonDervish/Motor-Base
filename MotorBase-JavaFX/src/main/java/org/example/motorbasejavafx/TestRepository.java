package org.example.motorbasejavafx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.motorbasejavafx.repository.UsersRepository;
import org.example.motorbasejavafx.serilize.LocalDateDeserializer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;
import org.example.motorbasejavafx.model.Users;

public class TestRepository {

    public static void main(String[] args) throws IOException, InterruptedException {
        UsersRepository usersRepository = new UsersRepository();
        System.out.println(usersRepository.getAll());

        System.out.println(usersRepository.getById(2L));
    }
}
