/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import com.upray.project.model.Project;

import java.util.List;

/**
 * Provides the remote service utility for Project. This utility wraps
 * <code>com.upray.project.service.impl.ProjectServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectService
 * @generated
 */
public class ProjectServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.upray.project.service.impl.ProjectServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Project addProject(long customerId, String name) {
		return getService().addProject(customerId, name);
	}

	public static Project addProject(
		long customerId, String name, String originalVersion,
		String upgradeVersion, int status, int phase, java.util.Date deadline,
		java.util.Date deliveryDate, java.util.Date contractDate) {

		return getService().addProject(
			customerId, name, originalVersion, upgradeVersion, status, phase,
			deadline, deliveryDate, contractDate);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Project> getProjects(String search, int start, int end) {
		return getService().getProjects(search, start, end);
	}

	public static ProjectService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ProjectService> _serviceSnapshot =
		new Snapshot<>(ProjectServiceUtil.class, ProjectService.class);

}