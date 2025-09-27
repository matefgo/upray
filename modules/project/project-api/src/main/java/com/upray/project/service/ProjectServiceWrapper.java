/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectService
 * @generated
 */
public class ProjectServiceWrapper
	implements ProjectService, ServiceWrapper<ProjectService> {

	public ProjectServiceWrapper() {
		this(null);
	}

	public ProjectServiceWrapper(ProjectService projectService) {
		_projectService = projectService;
	}

	@Override
	public com.upray.project.model.Project addProject(
		long customerId, String name) {

		return _projectService.addProject(customerId, name);
	}

	@Override
	public com.upray.project.model.Project addProject(
		long customerId, String name, String originalVersion,
		String upgradeVersion, int status, int phase, java.util.Date deadline,
		java.util.Date deliveryDate, java.util.Date contractDate) {

		return _projectService.addProject(
			customerId, name, originalVersion, upgradeVersion, status, phase,
			deadline, deliveryDate, contractDate);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.upray.project.model.Project> getProjects(
		String search, int start, int end) {

		return _projectService.getProjects(search, start, end);
	}

	@Override
	public ProjectService getWrappedService() {
		return _projectService;
	}

	@Override
	public void setWrappedService(ProjectService projectService) {
		_projectService = projectService;
	}

	private ProjectService _projectService;

}