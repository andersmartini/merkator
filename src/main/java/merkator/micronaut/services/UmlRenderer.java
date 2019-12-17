package merkator.micronaut.services;

import io.reactivex.Flowable;
import io.reactivex.Single;
import merkator.micronaut.domain.Message;

public class UmlRenderer {


    public static String renderRequest(Message message) {
        return String.format("%s -> %s : %s", message.sender, message.receiver, message.body);
    }

    public static String wrapInStartAndEndStatements(String uml) {
        return String.format("@startuml\n%s\n@enduml", uml);
    }

    public static Single<String> toUml(Flowable<Message> reqs) {
        return reqs.map(UmlRenderer::renderRequest)
                .toList()
                .map(list -> String.join("\n", list))
                .map(UmlRenderer::wrapInStartAndEndStatements);
    }
}
