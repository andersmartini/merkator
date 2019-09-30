package merkator.micronaut.controllers;

import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;
import merkator.micronaut.services.RequestService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExternalControllerImpl implements ExternalController {

    private final RequestService requestService;

    @Inject
    public ExternalControllerImpl(RequestService requestService){
        this.requestService = requestService;
    }

    @Override
    public Single<String> getRequests(String trackId) {
        return requestService.getRequests(trackId);
    }
}
