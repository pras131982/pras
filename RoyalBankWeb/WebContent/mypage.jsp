<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
	<%@ page import="sample.bank.bean.CustomerBean" %>
<TITLE>mypage.jsp</TITLE>
</HEAD>
<BODY>

<% CustomerBean customer = (CustomerBean) request.getSession().getAttribute("loggedCustomer"); %>

<b> Welcome to Sample Bank <%= customer.getUserId() %>
<br>
<br>
<b> Your Account Details Are As Follows </b>
<br>



</B>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD width="129">UserName</TD>
			<TD width="161"><i><%= customer.getUserId()%></i></TD>
		</TR>
		<TR>
			<TD width="129">Password</TD>
			<TD width="161"><i><%= customer.getPassword() %></i></TD>
		</TR>
		<TR>
			<TD width="129">Address</TD>
			<TD width="161"><i><%= customer.getAddress() %></i></TD>
		</TR>
		<TR>
			<TD width="129">AccountBalance</TD>
			<TD width="161"><i><%= customer.getAccountBalance() %></i></TD>
		</TR>
	</TBODY>
</TABLE>
<% session.setAttribute("loggedCustomer", null); %> <br><br>

<i> To log-out click <a href ="first.jsp"> here </a></i>
</BODY>
</HTML>
