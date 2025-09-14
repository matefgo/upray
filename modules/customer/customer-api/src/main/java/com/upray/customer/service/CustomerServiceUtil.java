/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import com.upray.customer.model.Customer;

import java.util.List;

/**
 * Provides the remote service utility for Customer. This utility wraps
 * <code>com.upray.customer.service.impl.CustomerServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Matheus Granville
 * @see CustomerService
 * @generated
 */
public class CustomerServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.upray.customer.service.impl.CustomerServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Customer addCustomer(String name) {
		return getService().addCustomer(name);
	}

	public static Customer deleteCustomer(String name) {
		return getService().deleteCustomer(name);
	}

	public static Customer getCustomerByName(String name) {
		return getService().getCustomerByName(name);
	}

	public static List<Customer> getCustomers(int start, int end) {
		return getService().getCustomers(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Customer updateCustomer(long customerId, String name)
		throws com.upray.customer.exception.NoSuchCustomerException {

		return getService().updateCustomer(customerId, name);
	}

	public static CustomerService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CustomerService> _serviceSnapshot =
		new Snapshot<>(CustomerServiceUtil.class, CustomerService.class);

}