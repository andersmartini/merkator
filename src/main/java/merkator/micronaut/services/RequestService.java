package merkator.micronaut.services;

import io.reactivex.Completable;
import io.reactivex.Single;
import merkator.micronaut.domain.Message;
import merkator.micronaut.repository.RequestRepository;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.nio.charset.Charset;

@Singleton
public class RequestService {

    private final RequestRepository repository;

    @Inject
    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }
    
    public Completable addRequest(Message message) {
        return repository.addRequest(message.trackId, message);
    }

    
    public Single<String> getFlowchart(String trackId) {
        return UmlRenderer.toUml(repository.getForTrackId(trackId))
                .map(this::renderSvg);
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

}
