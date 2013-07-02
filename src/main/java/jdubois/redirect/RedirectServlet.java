package jdubois.redirect;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Filter for redirecting all requests.
 */
public class RedirectServlet  extends HttpServlet {

    private final Logger log = LoggerFactory.getLogger(RedirectServlet.class);

    private static final String REDIRECT_URL = "http://www.google.com";

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("Starting redirect Servlet");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("Redirecting user {} to {}", request.getLocalAddr(), REDIRECT_URL);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_FOUND);
        httpResponse.sendRedirect(REDIRECT_URL);
    }

    @Override
    public void destroy() {
        log.info("Stopping redirect Servlet");
    }
}
