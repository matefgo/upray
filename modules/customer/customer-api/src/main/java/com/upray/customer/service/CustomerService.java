/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.upray.customer.exception.NoSuchCustomerException;
import com.upray.customer.model.Customer;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Customer. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Matheus Granville
 * @see CustomerServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CustomerService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.upray.customer.service.impl.CustomerServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the customer remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CustomerServiceUtil} if injection and service tracking are not available.
	 */
	public Customer addCustomer(String name);

	public Customer deleteCustomer(String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Customer getCustomerByName(String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Customer> getCustomers(int start, int end);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Customer updateCustomer(long customerId, String name)
		throws NoSuchCustomerException;

}