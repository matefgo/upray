/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomerService}.
 *
 * @author Matheus Granville
 * @see CustomerService
 * @generated
 */
public class CustomerServiceWrapper
	implements CustomerService, ServiceWrapper<CustomerService> {

	public CustomerServiceWrapper() {
		this(null);
	}

	public CustomerServiceWrapper(CustomerService customerService) {
		_customerService = customerService;
	}

	@Override
	public com.upray.customer.model.Customer addCustomer(String name) {
		return _customerService.addCustomer(name);
	}

	@Override
	public com.upray.customer.model.Customer deleteCustomer(String name) {
		return _customerService.deleteCustomer(name);
	}

	@Override
	public com.upray.customer.model.Customer getCustomerByName(String name) {
		return _customerService.getCustomerByName(name);
	}

	@Override
	public java.util.List<com.upray.customer.model.Customer> getCustomers(
		int start, int end) {

		return _customerService.getCustomers(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerService.getOSGiServiceIdentifier();
	}

	@Override
	public com.upray.customer.model.Customer updateCustomer(
			long customerId, String name)
		throws com.upray.customer.exception.NoSuchCustomerException {

		return _customerService.updateCustomer(customerId, name);
	}

	@Override
	public CustomerService getWrappedService() {
		return _customerService;
	}

	@Override
	public void setWrappedService(CustomerService customerService) {
		_customerService = customerService;
	}

	private CustomerService _customerService;

}