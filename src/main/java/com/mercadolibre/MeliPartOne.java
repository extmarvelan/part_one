package com.mercadolibre;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mercadolibre.services.PreferenceService;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/preferences")
public class MeliPartOne {
    @ConfigProperty(name = "mercadolibre.token")
    private String token;
    
    @Inject
    @RestClient
    PreferenceService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getPreferences() {
        return service.getPreferences()
            .elements.stream()
            .map(preference->preference.id)
            .collect(Collectors.toSet());
    }
}