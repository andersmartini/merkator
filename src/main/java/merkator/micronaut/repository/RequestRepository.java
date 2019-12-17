package merkator.micronaut.repository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Message;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class RequestRepository {

    private Map<String, List<Message>> requests = new HashMap<>();

    public Flowable<Message> getForTrackId(String trackId) {
        return Flowable.fromIterable(requests.getOrDefault(trackId,new ArrayList()));
    }

    public Completable addRequest(String trackId, Message message) {
        return Single.just(requests.getOrDefault(trackId, new ArrayList<>()))
                .flatMapCompletable(l -> {
                    l.add(message);
                    requests.put(trackId, l);
                    return Completable.complete();
                });
    }

    public Completable removeTrackId(String trackId) {
        requests.remove(trackId);
        return Completable.complete();
    }

}
