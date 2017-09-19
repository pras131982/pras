<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>login.html</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="customers" class="sample.bank.data.Customers" scope="application" />
<jsp:useBean id="login" class="sample.bank.bean.Login" scope="session" />


<FORM action="RoyalBank" method="post" >


<b>Welcome to the Royal Bank Corporation</b><BR>
<BR>
<TABLE border="0" height="45">
	<TBODY>
		<TR>
			<TD width="102">

<B>UserName</B></TD>
			<TD width="186"><INPUT type="text" name="userId" size="23"></TD>
		</TR>
		<TR>
			<TD width="102">
<B>Password</B></TD>
			<TD width="186"><INPUT type="password" name="password" size="23"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD width="291"><I><FONT color="red"><jsp:getProperty name="login"
				property="errMsg" /></FONT></I></TD>
		</TR>
	</TBODY>
</TABLE><i></i>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD width="64"><INPUT type="submit" name="action" value="login"></TD>
			<TD width="79"><INPUT type="submit" name="action" value="signup"></TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<jsp:setProperty name="login" property="errMsg" value=""/>
<% 
String facebookId = (String)request.getSession().getAttribute("faceBookId");

if(facebookId == null){

%>
<i> To use Facebook Id  click <a href ="https://www.facebook.com/dialog/oauth?client_id=646657215481679&redirect_uri=http://royalbank.mybluemix.net/RoyalBank/SendFacebookNotification"> here </a></i>
<%} else{ %>

<i>Hello <%=request.getSession().getAttribute("name") %> ,You will receive notifications from our App.Like us on Facebook. </i>

<%} %>
<BR></form><br>
<br>

</body>
</html>