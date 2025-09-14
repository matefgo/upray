/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service.impl;

import com.liferay.portal.aop.AopService;
import com.upray.customer.exception.NoSuchCustomerException;
import com.upray.customer.model.Customer;
import com.upray.customer.service.base.CustomerServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Matheus Granville
 */
@Component(
	property = {
		"json.web.service.context.name=customer",
		"json.web.service.context.path=Customer"
	},
	service = AopService.class
)
public class CustomerServiceImpl extends CustomerServiceBaseImpl {

	public Customer addCustomer(String name) {
		return customerLocalService.addCustomer(name);
	}

	public Customer updateCustomer(long customerId, String name) throws NoSuchCustomerException {
		return customerLocalService.updateCustomer(customerId, name);
	}

	public Customer deleteCustomer(String name) {
		return customerLocalService.deleteCustomer(name);
	}

	public Customer getCustomerByName(String name) {
		return customerLocalService.getCustomer(name);
	}

	public List<Customer> getCustomers(int start, int end) {
		return customerLocalService.getCustomers(start, end);
	}
}