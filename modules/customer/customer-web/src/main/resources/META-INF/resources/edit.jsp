<%@ include file="/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    long customerId = ParamUtil.getLong(request, "customerId");
    String name = ParamUtil.getString(request, "customerName");
%>

<portlet:actionURL name="/customer/edit" var="actionURL" />

<aui:form action="<%= actionURL %>" method="post" name="fm">
    <aui:input name="customerId" type="hidden" value="<%= customerId %>" />
    <aui:fieldset>
        <aui:input name="name" value="<%= name %>" />
    </aui:fieldset>
    <aui:button type="submit" />
    <aui:button href="<%= redirect %>" type="cancel" />
</aui:form>
