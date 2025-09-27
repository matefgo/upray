/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service.impl;

import com.liferay.portal.aop.AopService;

import com.upray.customer.exception.NoSuchCustomerException;
import com.upray.customer.model.Customer;
import com.upray.project.model.Project;
import com.upray.project.service.base.ProjectServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=project",
		"json.web.service.context.path=Project"
	},
	service = AopService.class
)
public class ProjectServiceImpl extends ProjectServiceBaseImpl {

	public Project addProject(long customerId, String name) {
		return projectLocalService.addProject(customerId, name);
	}

	public Project addProject(
			long customerId,
			String name,
			String originalVersion,
			String upgradeVersion,
			int status,
			int phase,
			Date deadline,
			Date deliveryDate,
			Date contractDate
	) {
		return projectLocalService.addProject(
				customerId,
				name,
				originalVersion,
				upgradeVersion,
				status,
				phase,
				deadline,
				deliveryDate,
				contractDate
		);
	}

	public List<Project> getProjects(String search, int start, int end) {
		return projectLocalService.getProjects(search, start, end);
	}
}