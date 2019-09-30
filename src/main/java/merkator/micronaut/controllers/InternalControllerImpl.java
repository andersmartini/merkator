package merkator.micronaut.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;
import merkator.micronaut.domain.Response;
import merkator.micronaut.services.RequestService;

import javax.inject.Singleton;

@Singleton
public class InternalControllerImpl implements InternalController {

    private final RequestService requestService;

    public InternalControllerImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public Single<HttpResponse> addRequest(@Body Request request) {
        return requestService.addRequest(request)
                .andThen(Single.just(HttpResponse.accepted()));
    }

    @Override
    public Single<HttpResponse> addResponse(@Body Response response) {
        return requestService.addResponse(response)
                .andThen(Single.just(HttpResponse.accepted()));
    }

    @Override
    public Single<String> test() {
        return Single.just("it works!");
    }
}
