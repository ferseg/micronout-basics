package com.akurey;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * AdminController
 */
@Controller("v1/admin")
public class AdminController {

    @Get("/secret")
    public String getAdminInformation() {
        return "Super secret information";
    }

}
