package controller;

import db.DataBase;
import http.request.HttpRequest;
import http.response.HttpResponse;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHandler;

public class CreateUserController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    @Override
    protected void doPost(HttpRequest request, HttpResponse response) {
        User user = new User(request.getParameter("userId"), request.getParameter("password"), request.getParameter("name"), request.getParameter("email"));
        log.debug("user {}", user);
        DataBase.addUser(user);
        response.sendRedirect("/index.html");
    }
}
