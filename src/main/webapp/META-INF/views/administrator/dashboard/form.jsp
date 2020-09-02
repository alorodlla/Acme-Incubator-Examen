<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    
    <acme:form-double code="administrator.dashboard.form.label.investmentRoundsWithFunding" path="investmentRoundsWithFunding"/>
    <acme:form-double code="administrator.dashboard.form.label.applicationWithOffer" path="applicationWithOffer"/>
    <acme:form-double code="administrator.dashboard.form.label.applicationsAccepted" path="applicationsAccepted"/>
    
    <acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>