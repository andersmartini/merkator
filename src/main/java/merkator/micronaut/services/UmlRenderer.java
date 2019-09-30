package merkator.micronaut.services;

import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Request;

public class UmlRenderer {


    public static String renderRequest(Request request) {
        return String.format("%s -> %s : %s", request.sender, request.receiver, request.body);
    }

    public static String wrapInStartAndEndStatements(String uml) {
        return String.format("@startuml\n%s\n@enduml", uml);
    }

    public static Single<String> toUml(Flowable<Request> reqs) {
        return reqs.map(UmlRenderer::renderRequest)
                .toList()
                .map(list -> String.join("\n", list))
                .map(UmlRenderer::wrapInStartAndEndStatements);
    }


}
