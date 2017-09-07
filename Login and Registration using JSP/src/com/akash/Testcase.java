package com.akash;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
public class Testcase {

	
    
    @Test
    public void testDoGet() throws Exception 
    {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
        ServletOutputStream mockOutput = mock(ServletOutputStream.class);
       
        RequestDispatcher re = mock(RequestDispatcher.class);
        
        		
        when(mockRequest.getParameter("name")).thenReturn("satya123");
        when(mockRequest.getParameter("email")).thenReturn("s3@gmail.com");
        when(mockRequest.getParameter("mobile")).thenReturn("961510322311");
        when(mockRequest.getParameter("password")).thenReturn("12345");       
        when(mockRequest.getParameter("address")).thenReturn("bridgelaabz");        
        when(mockRequest.getRequestDispatcher("/Registration.jsp")).thenReturn(re);

  /*      StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        
        when(mockResponse.getWriter()).thenReturn(out);
    */    
       // when(mockResponse.getOutputStream()).thenReturn(mockOutput);

       new InsertData().doGet(mockRequest, mockResponse);
        
       verify(mockRequest).getRequestDispatcher("/Registration.jsp");
       verify(re).include(mockRequest, mockResponse);
    	
    	
       
       // new Loginvalidatation().doGet(mockRequest, mockResponse);
       
       // verify(mockResponse).setContentType("text/html");
       // verify(mockResponse).sendRedirect("login.jsp");
        
      //  verify(mockResponse).sendRedirect("login.jsp");
        
        
       /* Result result = JUnitCore.runClasses(.class);
        
        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        
        System.out.println(result.wasSuccessful());*/
       // verify(rd).include(mockRequest, mockResponse);
        
       //verify(mockResponse).getContentType().isEmpty();
    }
    
    
    
    
    
    
    /**
     * 
     * @throws Exception
     */
    @Test
    public void testDoGet1() throws Exception {
    
    	HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
        ServletOutputStream mockOutput = mock(ServletOutputStream.class);
        
        RequestDispatcher re = mock(RequestDispatcher.class);

        // Setting request parameter
        when(mockRequest.getParameter("name")).thenReturn("satya123");
        when(mockRequest.getParameter("email")).thenReturn("s3@gmail.com");
        when(mockRequest.getParameter("mobile")).thenReturn("9615103223");
        when(mockRequest.getParameter("password")).thenReturn("12345");       
        when(mockRequest.getParameter("address")).thenReturn("bridgelaabz");        
        when(mockRequest.getRequestDispatcher("/Registration.jsp")).thenReturn(re);

  /*      StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        
        when(mockResponse.getWriter()).thenReturn(out);
    */    
       // when(mockResponse.getOutputStream()).thenReturn(mockOutput);

       new InsertData().doGet(mockRequest, mockResponse);
        
       //verify(mockRequest).getRequestDispatcher("/Registration.jsp");
       //verify(re).include(mockRequest, mockResponse);
    	
    	
       
       // new Loginvalidatation().doGet(mockRequest, mockResponse);
       
       // verify(mockResponse).setContentType("text/html");
       // verify(mockResponse).sendRedirect("login.jsp");
        
        verify(mockResponse).sendRedirect("login.jsp");
        
        
       /* Result result = JUnitCore.runClasses(.class);
        
        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        
        System.out.println(result.wasSuccessful());*/
       // verify(rd).include(mockRequest, mockResponse);
        
       //verify(mockResponse).getContentType().isEmpty();
    }
    
    
    
}

