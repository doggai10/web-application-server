package webserver.response;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HttpResponseTest {
    private String testDirectory = "./src/test/resources/";

    @Test
    public void responseForward() throws Exception {
        //when
        HttpResponse response = new HttpResponse(createOutputStream("Http_Forward.txt"));

        //then
        response.forward("/index.html");
    }

    @Test
    public void responseRedirect() throws Exception {
        //when
        HttpResponse response = new HttpResponse(createOutputStream("Http_Redirect.txt"));

        //then
        response.sendRedirect("/index.html");
    }

    @Test
    public void responseCookies() throws Exception {
        //when
        HttpResponse response = new HttpResponse(createOutputStream("Http_Cookie.txt"));

        //then
        response.addHeader("Set-Cookie", "logined=true");
        response.sendRedirect("/index.html");
    }

    private OutputStream createOutputStream(String fileName) throws FileNotFoundException {
        return new FileOutputStream(new File(testDirectory + fileName));
    }
}