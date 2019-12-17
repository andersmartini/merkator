package merkator.micronaut.repository;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface RequestRepository {

    Flowable<Request> getForTrackId(String trackId);

    Completable addRequest(String trackId, Request request);

    Completable removeTrackId(String trackId);
}
