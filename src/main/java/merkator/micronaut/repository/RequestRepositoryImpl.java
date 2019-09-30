package merkator.micronaut.repository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class RequestRepositoryImpl implements RequestRepository {

    private Map<String, List<Request>> requests = new HashMap<>();

    @Override
    public Flowable<Request> getForTrackId(String trackId) {
        return Flowable.fromIterable(requests.getOrDefault(trackId,new ArrayList()));
    }

    @Override
    public Completable addRequest(String trackId, Request request) {
        return Single.just(requests.getOrDefault(trackId, new ArrayList<>()))
                .flatMapCompletable(l -> {
                    l.add(request);
                    requests.put(trackId, l);
                    return Completable.complete();
                });
    }

    @Override
    public Completable removeTrackId(String trackId) {
        requests.remove(trackId);
        return Completable.complete();
    }

}
