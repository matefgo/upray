package com.upray.project.web.provider;

import com.liferay.frontend.data.set.provider.FDSDataProvider;
import com.liferay.frontend.data.set.provider.search.FDSKeywords;
import com.liferay.frontend.data.set.provider.search.FDSPagination;
import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.upray.project.model.Project;
import com.upray.project.service.ProjectLocalService;
import com.upray.project.web.constants.ProjectPortletKeys;
import com.upray.project.web.model.ProjectEntry;
import jakarta.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        property = "fds.data.provider.key=" + ProjectPortletKeys.PROJECT,
        service = FDSDataProvider.class
)
public class ProjectFDSDataProvider implements FDSDataProvider<ProjectEntry> {
    @Override
    public List<ProjectEntry> getItems(FDSKeywords fdsKeywords, FDSPagination fdsPagination, HttpServletRequest httpServletRequest, Sort sort) throws PortalException {
        List<Project> results = _projectLocalService.getProjects(
                fdsKeywords.getKeywords(), fdsPagination.getStartPosition(), fdsPagination.getEndPosition());

        return TransformUtil.transform(
                results,
                (project -> new ProjectEntry(
                        project.getName(),
                        project.getOriginalVersion(),
                        project.getUpgradeVersion(),
                        project.getStatus(),
                        project.getPhase()
                ))
        );
    }

    @Override
    public int getItemsCount(FDSKeywords fdsKeywords, HttpServletRequest httpServletRequest) throws PortalException {
        return (int) _projectLocalService.getProjectsCount(
                fdsKeywords.getKeywords()
        );
    }

    @Reference
    private ProjectLocalService _projectLocalService;
}
