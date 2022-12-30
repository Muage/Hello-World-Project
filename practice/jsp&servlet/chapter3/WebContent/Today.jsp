<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% GregorianCalendar now = new GregorianCalendar(); %>
<%= String.format("%TY년 %Tm월 %Td일", now, now, now) %>