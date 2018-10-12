/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.freeter.interceptor;


import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.freeter.annotation.Login;
import com.freeter.common.exception.RRException;
import com.freeter.form.ResponseResultForm;
import com.freeter.utils.JwtUtil;

import io.jsonwebtoken.Claims;

/**
 * 权限(Token)验证
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtils;
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
    
    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
         }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证，header中token
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new RRException("token不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        Claims claims = jwtUtils.getClaimByToken(token);
//        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
        if(claims == null){
            //throw new RRException("token失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        	response.reset();
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Max-Age", "3600");
        	HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(response);
        	ResponseResultForm responseResult = new ResponseResultForm(401,false,"token过期,请重新登陆",null);
        	mappingJackson2HttpMessageConverter.write(responseResult, MediaType.APPLICATION_JSON_UTF8, httpOutputMessage);
        	return false;
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));
        String userid= request.getAttribute(USER_KEY).toString();
          return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
//        vary: Origin
//        Vary: Access-Control-Request-Method
//        Vary: Access-Control-Request-Headers
//        Access-Control-Allow-Origin: *
    }
    
}
