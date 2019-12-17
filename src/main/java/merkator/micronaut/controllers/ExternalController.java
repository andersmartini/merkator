package merkator.micronaut.controllers;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import io.micronaut.views.ModelAndView;
import merkator.micronaut.services.RequestService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Controller("/")
public class ExternalController {

    private final RequestService requestService;

    @Inject
    public ExternalController(RequestService requestService){
        this.requestService = requestService;
    }

    @Get("/{trackId}")
    public Single<ModelAndView> getRequests(String trackId) {
        return requestService.getFlowchart(trackId)
                .map(svg -> svg.substring(55))
                .map(svg -> CollectionUtils.mapOf("trackId", trackId, "svg",svg))
                .map(m -> new ModelAndView<>("flowchart", m));
    }
}
