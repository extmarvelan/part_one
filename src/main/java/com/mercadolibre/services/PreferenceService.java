package com.mercadolibre.services;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.mercadolibre.models.ResponsePreference;

@RegisterRestClient
@ClientHeaderParam(name = "Authorization", value = "{getAuthorizationHeader}")
public interface PreferenceService {
    default String getAuthorizationHeader(){
        final Config config = ConfigProvider.getConfig();
        return "Bearer "+config.getValue("mercadolibre.token", String.class);
    }
    @GET
    @Path("/checkout/preferences/search")
    ResponsePreference getPreferences();
}