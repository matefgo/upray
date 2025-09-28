package com.upray.dashboard.web.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.upray.project.model.Project;
import com.upray.project.service.ProjectLocalServiceUtil;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * @author Matheus Granville
 */
public class DashboardDisplayContext {
    public DashboardDisplayContext(
            HttpServletRequest httpServletRequest, RenderRequest renderRequest,
            RenderResponse renderResponse) {

        _httpServletRequest = httpServletRequest;
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
    }

    public SearchContainer<Project> getSearchContainer()
            throws PortalException {

        if (_searchContainer != null) {
            return _searchContainer;
        }

        SearchContainer<Project> searchContainer =
                new SearchContainer<>(
                        _renderRequest,
                        _renderResponse.createRenderURL(), null,
                        "There are no projects.");

        List<Project> projectsList =
                ProjectLocalServiceUtil.getProjects(
                        _getKeywords(), searchContainer.getStart(), searchContainer.getEnd()
                );

        searchContainer.setResultsAndTotal(projectsList);

        _searchContainer = searchContainer;

        return _searchContainer;
    }

    private String _getKeywords() {
        return ParamUtil.getString(_httpServletRequest, "keywords", "");
    }

    private SearchContainer<Project> _searchContainer;
    private final HttpServletRequest _httpServletRequest;
    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
}
