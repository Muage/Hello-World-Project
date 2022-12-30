<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<% GregorianCalendar now = new GregorianCalendar(); %>
[현재의 시각] <%= String.format("%TF %TT", now, now) %>