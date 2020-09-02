<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>	
	<acme:form-textarea code="investor.funding.list.label.description" path="description"/>
	<acme:form-submit method="get" code="investor.funding.form.button.investmentRound" action="/investor/investment-round/show-mine-2?fundingId=${id}"/>
	<acme:form-return code="investor.funding.form.button.return"/>
</acme:form>