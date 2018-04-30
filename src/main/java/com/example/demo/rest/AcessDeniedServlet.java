package com.example.demo.rest;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.idm.authorization.Permission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/access-denied")
public class AcessDeniedServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    final StringBuilder sb = new StringBuilder("<P>Acess Denied</P>");
    String url = "/demo/logout";
    sb.append(String.format("<a href=\"%s\">Logout</a>", url));
    sb.append("<br/>Your permissions are \n\n");
    sb.append(getPermissions(req));
    resp.getWriter().write(sb.toString());
  }


  private String getPermissions(HttpServletRequest request) {
    StringBuilder sb = new StringBuilder("<ul>");
    KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
    for (Permission permission : authzContext.getPermissions()) {
      sb.append(String.format("<li>\n" +
              "                <p>Resource: %s</p>\n" +
              "                <p>ID: %s</p>\n" +
              "                <p>Scopes: %s</p>\n" +
              "            </li>", permission.getResourceSetName(), permission.getResourceSetId(), permission.getScopes()));
    }
    if (authzContext.getPermissions().size() == 0) {
      sb.append("<li>none</li>");
    }
    sb.append("</ul>");
    return sb.toString();
  }

}
