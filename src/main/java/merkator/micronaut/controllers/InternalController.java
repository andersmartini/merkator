package merkator.micronaut.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;
import merkator.micronaut.domain.Response;

@Controller("/internal")
public interface InternalController {

    @Post("/request")
    Single<HttpResponse> addRequest(Request request);

    @Post("/response")
    Single<HttpResponse> addResponse(Response response);

    @Get("/")
    Single<String> test();

}
