package com.upray.dashboard.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Matheus Granville
 */
public class DashboardManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
    public DashboardManagementToolbarDisplayContext(HttpServletRequest httpServletRequest, LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, SearchContainer<?> searchContainer) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse, searchContainer);
    }

    @Override
    public String getSearchActionURL() {
        return PortletURLBuilder.createActionURL(
                liferayPortletResponse
        ).buildString();
    }

    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.createRenderURL(
                liferayPortletResponse
        ).buildString();
    }

    @Override
    public Boolean isSelectable() {
        return false;
    }
}
