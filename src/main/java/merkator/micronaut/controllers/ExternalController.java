package merkator.micronaut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/")
public interface ExternalController {

    @Get("/{trackId}")
    Single<String> getRequests(String trackId);

}
