package com.twehs.utils.filter;

import java.io.IOException;   

import javax.servlet.FilterChain;   
import javax.servlet.ServletException;   
import javax.servlet.ServletRequest;   
import javax.servlet.ServletResponse;   
import javax.servlet.http.HttpServletRequest;   
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter; 
//自定义的servelet 对应的过滤器
@SuppressWarnings("deprecation")  
public class FCKFilter extends StrutsPrepareAndExecuteFilter{
	public void doFilter(ServletRequest req,ServletResponse res, FilterChain chain) throws IOException, ServletException {     
        HttpServletRequest request = (HttpServletRequest) req;    
        String URI = request.getRequestURI();   
        String[] uriArray = URI.split("/ckfinder/core/connector/java/*/");   
        int arrayLen = uriArray.length;   
        if (arrayLen >= 2) {   
            chain.doFilter(req, res);    
        }else {   
            super.doFilter(req, res, chain);     
        }   
    }    
	

}
