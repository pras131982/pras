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
<TITLE>signup.jsp</TITLE>
</HEAD>
<BODY>
<b>Open A New Account</b>
<BR>
<BR>
<BR>

<jsp:useBean id="addCustomer" class="sample.bank.bean.CustomerBean" scope="session" />

<form action="RoyalBank" method="post">
<TABLE border="0" cellpadding="0" cellspacing="0" width="653"
	height="125">
	<TBODY>
		<TR>
			<TD width="162" height="29" nowrap><B>User Name</B> *</TD>
			<TD height="29" nowrap width="195"><INPUT type="text" name="userId"
				size="20"
				value='<jsp:getProperty name="addCustomer" property="userId" />'></TD>
			<TD width="296"><FONT color="red"><i><jsp:getProperty
				name="addCustomer" property="errUserId" /></i></FONT></TD>
		</TR>
		<TR>
			<TD width="162" height="29"><B>Password</B> *</TD>
			<TD height="29" width="195"><INPUT type="password" name="password"
				size="20"
				value='<jsp:getProperty name="addCustomer" property="password" />'></TD>
			<TD width="296"><FONT color="red"><i><jsp:getProperty name="addCustomer"
				property="errPassword" /></i></FONT></TD>
		</TR>
		<TR>
			<TD width="162" height="29"><B>Address</B></TD>
			<TD height="29" width="195"><INPUT type="text" name="address"
				size="20"
				value='<jsp:getProperty name="addCustomer" property="address" />'></TD>
		</TR>
		<TR>
			<TD width="162" height="29"><B>Opening Balance</B> *</TD>
			<TD height="29" width="195"><INPUT type="text" name="openingBalance"
				size="20"
				value='<jsp:getProperty name="addCustomer" property="openingBalance" />'>
			<FONT size="-1"><B>INR</B></FONT></TD>
			<TD width="296"><FONT color="red"><i><jsp:getProperty name="addCustomer"
				property="errOpeningBalance" /></i></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<FONT size="-1">Fields marked * are necessary</FONT><BR>
<INPUT type="submit" name="action" value="openAccount">

</form>
</BODY>
</HTML>
