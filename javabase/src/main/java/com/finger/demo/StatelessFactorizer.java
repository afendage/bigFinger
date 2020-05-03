package com.finger.demo;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 无状态类
 */
public class StatelessFactorizer extends GenericServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    BigInteger extractFromRequest(ServletRequest req) {    //从请求中得到数值，内部代码并不具这功能
        return new BigInteger("7");
    }
    BigInteger[] factor(BigInteger i) {
        // 只是演示，不具因数分解功能
        return new BigInteger[] { i };
    }
    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
