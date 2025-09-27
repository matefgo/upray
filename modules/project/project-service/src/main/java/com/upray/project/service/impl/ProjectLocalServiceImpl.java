/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.upray.customer.model.Customer;
import com.upray.customer.service.CustomerLocalService;
import com.upray.project.model.Project;
import com.upray.project.service.base.ProjectLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.upray.project.model.Project",
	service = AopService.class
)
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {

	@Override
	public Project addProject(long customerId, String name) {
		Date currentDate = new Date();
		return addProject(
				customerId,
				name,
				"",
				"",
				0,
				0,
				currentDate,
				currentDate,
				currentDate);
	}

	@Override
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
		validateCustomerId(customerId);
		validateName(name);

		Project project = projectPersistence.create(counterLocalService.increment());

		project.setCustomerId(customerId);
		project.setName(name);
		project.setOriginalVersion(originalVersion);
		project.setUpgradeVersion(upgradeVersion);
		project.setStatus(status);
		project.setPhase(phase);
		project.setDeadline(deadline);
		project.setDeliveryDate(deliveryDate);
		project.setContractDate(contractDate);

		return projectPersistence.update(project);
	}

	@Override
	public List<Project> getProjects(String search, int start, int end) {
		DynamicQuery query = projectsDynamicQuery(search);
		return projectPersistence.findWithDynamicQuery(query, start, end);
	}

	@Override
	public long getProjectsCount(String search) {
		DynamicQuery query = projectsDynamicQuery(search);
		return projectPersistence.countWithDynamicQuery(query);
	}

	private DynamicQuery projectsDynamicQuery(String search) {
		if (Validator.isNull(search)) {
			search = "";
		}

		DynamicQuery query = dynamicQuery();

		query.add(
				RestrictionsFactoryUtil.ilike("name", "%" + search + "%")
		);

		return query;
	}

	private void validateName(String name) {
		if (Validator.isNull(name)) {
			throw new IllegalArgumentException("Please enter a valid project name.");
		}
	}

	private void validateCustomerId(long id) {
		Customer customer = _customerLocalService.fetchCustomer(id);

		if (Validator.isNull(customer)) {
			throw new IllegalArgumentException("No customer was found with the ID = " + id + ".");
		}
	}

	@Reference
	private CustomerLocalService _customerLocalService;
}