package merkator.micronaut.services;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;
import merkator.micronaut.domain.Response;
import merkator.micronaut.repository.RequestRepository;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

@Singleton
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;

    @Inject
    public RequestServiceImpl(RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable addRequest(Request request) {
        return repository.addRequest(request.trackId, request);
    }

    @Override
    public Completable addResponse(Response response) {
        return null;
    }

    @Override
    public Single<String> getRequests(String trackId) {
        return UmlRenderer.toUml(repository.getForTrackId(trackId))
                .map(this::renderSvg);
    }

    @Override
    public Flowable<Response> getResponses(String trackId) {
        return null;
    }

    private String renderSvg(String source) throws IOException {
        SourceStringReader reader = new SourceStringReader(source);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();

        reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
        os.close();

        final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));

        return svg;
    }

}
