<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.new.user"/></title>
	</head>
	<body>
		<s:hidden name="userBean.id" value="%{userBean.id}"/>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<%@ include file="../other/menuAdmin.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.new.user"/></h1>
				<s:form action="UpdateUser" method="post">
					<table>
						<tr><td> </td></tr>
						<tr>
							<td><s:text name="label.firstname"/></td>
							<td><s:textfield name="userBean.firstName"/></td>
							<td class="error"><s:fielderror fieldName="error.firstName" /></td>
						</tr>
						<tr>
							<td><s:text name="label.name"/></td>
							<td><s:textfield name="userBean.name"/></td>
							<td class="error"><s:fielderror fieldName="error.name"/></td>
						</tr>
						<tr>
							<td><s:text name="label.group"/></td>
							<td>
								<s:select id="groupList" list="userBean.arrayGroupName" name="userBean.nameGroup" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td><s:text name="label.email"/></td>
							<td><s:textfield name="userBean.email" /></td>
							<td class="error"><s:fielderror fieldName="error.email"/></td>
						</tr>
						<tr>
							<td><s:text name="label.password.new"/></td>
							<td><s:password name="userBean.newPassword"/></td>
							<td class="error"><s:fielderror fieldName="error.newpassword"/></td>
						</tr>
						<tr>
							<td><s:text name="label.password.confirm"/></td>
							<td><s:password name="userBean.confirmPassword"/></td>
							<td class="error"><s:fielderror fieldName="error.confirmpassword"/></td>
						</tr>
					</table>
					<br/>
					<s:submit key="label.valide"  cssClass="user_button"/>
				</s:form>
				<div class="clear"></div>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>