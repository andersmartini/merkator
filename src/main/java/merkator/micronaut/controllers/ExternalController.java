package merkator.micronaut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.reactivex.Single;

@Controller("/")
public interface ExternalController {

    @Get("/{trackId}")
    Single<ModelAndView> getRequests(String trackId);

}
