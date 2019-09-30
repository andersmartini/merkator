package merkator.micronaut.services;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;
import merkator.micronaut.domain.Response;

public interface RequestService {

    Completable addRequest(Request request);

    Completable addResponse(Response response);

    Single<String> getRequests(String trackId);

    Flowable<Response> getResponses(String trackId);

}
