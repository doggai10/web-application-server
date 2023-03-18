package webserver;

import org.junit.Test;
import webserver.request.RequestLine;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestLineTest {
    @Test
    public void create_get_method() {
        //given & when
        RequestLine line = new RequestLine("GET /index.html HTTP/1.1");

        //then
        assertEquals(HttpMethod.GET, line.getMethod());
        assertEquals("/index.html", line.getPath());
    }

    @Test
    public void create_post_method() {
        //given & when
        RequestLine line = new RequestLine("POST /index.html HTTP/1.1");

        //then
        assertEquals(HttpMethod.POST, line.getMethod());
        assertEquals("/index.html", line.getPath());
    }

    @Test
    public void create_path_and_params() {
        //given & when
        RequestLine line = new RequestLine("GET /user/create?userId=javajigi&password=pass HTTP/1.1");

        //then
        assertEquals(HttpMethod.GET, line.getMethod());
        assertEquals("/user/create", line.getPath());
        Map<String, String> params = line.getParams();
        assertEquals(2, params.size());
    }
}