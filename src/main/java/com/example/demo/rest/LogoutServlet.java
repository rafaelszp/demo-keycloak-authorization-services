package com.example.demo.rest;

import org.keycloak.common.util.KeycloakUriBuilder;
import org.keycloak.constants.ServiceUrlConstants;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/logout")
public class LogoutServlet extends HttpServlet {


  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String url = "";
    try {
      String scheme = req.getScheme();
      String host = req.getServerName();
      int port = req.getServerPort();
      String contextPath = req.getContextPath();
      String redirectUri = scheme + "://" + host + ":" + port + contextPath;
      String authURL = getKeycloakJson(req).getString("auth-server-url");
      String realmName = getKeycloakJson(req).getString("realm");
      url = KeycloakUriBuilder.fromUri(authURL).path(ServiceUrlConstants.TOKEN_SERVICE_LOGOUT_PATH)
              .queryParam("redirect_uri", redirectUri).build(realmName).toString();

      req.getSession(false).invalidate();
      req.logout();
    } catch (ServletException | NullPointerException ignored) {
    } finally {
      resp.sendRedirect(url);
    }
  }

  private JsonObject getKeycloakJson(HttpServletRequest req) {
    JsonObject json = null;
    try {
      JsonReader reader = Json.createReader(req.getServletContext().getResourceAsStream("/WEB-INF/keycloak.json"));
      json = reader.readObject();
      reader.close();
    } catch (Exception e) {
    }
    return json;
  }

}
