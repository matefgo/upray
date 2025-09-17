/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.upray.customer.exception.NoSuchCustomerException;
import com.upray.customer.model.Customer;
import com.upray.customer.service.base.CustomerLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Matheus Granville
 */
@Component(
	property = "model.class.name=com.upray.customer.model.Customer",
	service = AopService.class
)
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {

	@Override
	public List<Customer> getCustomers(String search, int start, int end) {
		DynamicQuery query = customersDynamicQuery(search);
		return customerPersistence.findWithDynamicQuery(query, start, end);
	}

	@Override
	public long getCustomersCount(String search) {
		DynamicQuery query = customersDynamicQuery(search);
		return customerPersistence.countWithDynamicQuery(query);
	}

	@Override
	public Customer addCustomer(String name) {
		validateName(name);

		List<Customer> customers = customerPersistence.findByName(name);

		if (!customers.isEmpty()) {
			throw new IllegalArgumentException("A customer named \"" + name + "\" already exists in the database");
		}

		Customer customer = customerPersistence.create(counterLocalService.increment());

		customer.setName(name);

		return customerPersistence.update(customer);
	}

	@Override
	public Customer getCustomer(String name) {
		validateName(name);

		return customerPersistence.findByName(name).getFirst();
	}

	@Override
	public Customer updateCustomer(long customerId, String name) throws NoSuchCustomerException {
		validateName(name);

		if (Validator.isNull(customerId)) {
			throw new IllegalArgumentException("Please insert a valid customer ID");
		}

		Customer customer = customerPersistence.findByPrimaryKey(customerId);

		customer.setName(name);

		return customerPersistence.update(customer);
	}

	@Override
	public Customer deleteCustomer(String name) {
		validateName(name);

		Customer customer = customerPersistence.findByName(name).getFirst();

		return customerPersistence.remove(customer);
	}

	private DynamicQuery customersDynamicQuery(String search) {
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
			throw new IllegalArgumentException("Please enter a valid customer name.");
		}
	}
}