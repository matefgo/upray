<%@ include file="/init.jsp" %>

<%
    CustomerDisplayContext customerDisplayContext = (CustomerDisplayContext)request.getAttribute(CustomerPortletKeys.DISPLAY_CONTEXT);
%>

<frontend-data-set:headless-display
    apiURL="<%= customerDisplayContext.getApiURL() %>"
	creationMenu="<%= customerDisplayContext.getCreationMenu() %>"
	fdsActionDropdownItems="<%= customerDisplayContext.getFDSActionDropdownItems() %>"
	id="<%= CustomerPortletKeys.CUSTOMER %>"
	propsTransformer="{CustomerPropsTransformer} from customer-web"
/>
