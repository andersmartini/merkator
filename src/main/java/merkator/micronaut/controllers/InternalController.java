package merkator.micronaut.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import merkator.micronaut.domain.Message;
import merkator.micronaut.services.RequestService;

import javax.inject.Singleton;

@Singleton
@Controller("/internal")
public class InternalController {

    private final RequestService requestService;

    public InternalController(RequestService requestService) {
        this.requestService = requestService;
    }

    @Post
    public Single<HttpResponse> addRequest(@Body Message message) {
        return requestService.addRequest(message)
                .andThen(Single.just(HttpResponse.accepted()));
    }

    @Get
    public Single<String> test() {
        return Single.just("it works!");
    }
}
