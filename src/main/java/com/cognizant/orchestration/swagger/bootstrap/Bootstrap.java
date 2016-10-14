package com.cognizant.orchestration.swagger.bootstrap;

import com.sun.jersey.spi.resource.Singleton;

import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import io.swagger.mule.ApiListingJSON;

@Singleton
public class Bootstrap {
  /** Run on app init by Spring */
  public void start() {
    Info info = new Info()
      .title("Swagger  App")
      .description("This is swagger interface for Booking Engine.");

    Swagger swagger = new Swagger().info(info);
    swagger.basePath("/service/swagger");
    swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));


    ApiListingJSON.init(swagger);
  }
}