package com.interstellar.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.interstellar.assignment.schema.GetShortestPathRequest;
import com.interstellar.assignment.schema.GetShortestPathResponse;


@Endpoint
public class ShortestRouteEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private ShortestRouteRepository pathRepository;

    @Autowired
    public ShortestRouteEndpoint(ShortestRouteRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getShortestPathRequest")

    @ResponsePayload
    public GetShortestPathResponse getShortestPath(@RequestPayload GetShortestPathRequest request) {
        GetShortestPathResponse response = new GetShortestPathResponse();
        response.setPath(pathRepository.getShortestPath(request.getName()));

        return response;
    }
}