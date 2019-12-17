package merkator.micronaut.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;
import merkator.micronaut.domain.Message;
import merkator.micronaut.services.RequestService;

import javax.inject.Singleton;

@Singleton
public class InternalControllerImpl {

    private final RequestService requestService;

    public InternalControllerImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public Single<HttpResponse> addRequest(@Body Message message) {
        return requestService.addRequest(message)
                .andThen(Single.just(HttpResponse.accepted()));
    }

    @Override
    public Single<String> test() {
        return Single.just("it works!");
    }
}
