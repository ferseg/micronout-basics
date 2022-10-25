package com.akurey;

import java.util.Random;

import javax.validation.Valid;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;

@Controller("v1/hello")
public class HelloController {

    @Post
    public String sayHello(@Body @Valid Person person,
            @Header(value = "x-guess-age", defaultValue = "false") boolean guessAge) {
        if (guessAge) {
            int guessedAge = Math.round(person.getAge() * (1 + new Random().nextFloat()));

            return String.format("Hello %s %s, hope you're doing well. You are %d, younger than I thought (%d)",
                    person.getName(),
                    person.getLastName(),
                    person.getAge(),
                    guessedAge);
        }
        return String.format("Hello %s %s, hope you're doing well. I see you are %d",
                person.getName(),
                person.getLastName(),
                person.getAge());
    }
}
