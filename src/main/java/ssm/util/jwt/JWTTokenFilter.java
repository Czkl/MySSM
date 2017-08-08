package ssm.util.jwt;


import ssm.dao.base.Dao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTTokenFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Token过滤器");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;

        String url = rq.getRequestURI();
        if(url.equals("/WebSSM/access/token")){
            chain.doFilter(request,response);
        }

        String author =  rq.getHeader("Authorization");
        if(author == null || author.equals("")){
            System.out.println("Authorization：无值");
            return;
        }

        String[] jwt = author.split(":");
        String tokenSign ="";

        if(jwt[0].equals("JWT") || jwt[0].equals("jwt") || jwt[0].equals("Jwt")
               || jwt[0].equals("jWt") || jwt[0].equals("jwT")|| jwt[0].equals("JWt")
                || jwt[0].equals("JwT")|| jwt[0].equals("jWT")){
            tokenSign = jwt[1];
        }

        if(JwtHelper.isLegalToken(tokenSign) != 200){
            System.err.println("认证失败");
        }

        chain.doFilter(request,response);

    }


    public void destroy() {
        System.out.println("Token过滤器被销毁");
    }
}
