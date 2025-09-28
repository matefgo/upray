<%@ include file="/init.jsp" %>

<%
    DashboardDisplayContext dashboardDisplayContext = new DashboardDisplayContext(request, renderRequest, renderResponse);
    DashboardManagementToolbarDisplayContext dashboardManagementToolbarDisplayContext = new DashboardManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, dashboardDisplayContext.getSearchContainer());
%>

<clay:management-toolbar
	managementToolbarDisplayContext="<%= dashboardManagementToolbarDisplayContext %>"
/>

<liferay-ui:search-container
    searchContainer="<%= dashboardDisplayContext.getSearchContainer() %>"
>
     <liferay-ui:search-container-row
        className="com.upray.project.model.Project"
        modelVar="project"
     >
        <liferay-ui:search-container-column-text
            name="name"
            value="<%= project.getName() %>"
        />
        <liferay-ui:search-container-column-text
            name="deadline"
            value="<%= String.valueOf(project.getDeadline()) %>"
        />
        <liferay-ui:search-container-column-text
            name="status"
            value="<%= String.valueOf(project.getStatus()) %>"
        />
     </liferay-ui:search-container-row>
     <liferay-ui:search-iterator />
</liferay-ui:search-container>
