<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    <acme:form-textbox code="investor.offer.form.label.offer" path="offer" />
    <acme:form-password code="investor.offer.form.label.password" path="password" />
    <acme:form-textarea code="investor.offer.form.label.link" path="link" />
    
    <acme:form-return code="investor.offer.form.button.return" />
</acme:form>