/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.upray.customer.model.Customer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Customer. This utility wraps
 * <code>com.upray.customer.service.impl.CustomerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Matheus Granville
 * @see CustomerLocalService
 * @generated
 */
public class CustomerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.upray.customer.service.impl.CustomerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was added
	 */
	public static Customer addCustomer(Customer customer) {
		return getService().addCustomer(customer);
	}

	public static Customer addCustomer(String name) {
		return getService().addCustomer(name);
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	public static Customer createCustomer(long customerId) {
		return getService().createCustomer(customerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was removed
	 */
	public static Customer deleteCustomer(Customer customer) {
		return getService().deleteCustomer(customer);
	}

	/**
	 * Deletes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws PortalException if a customer with the primary key could not be found
	 */
	public static Customer deleteCustomer(long customerId)
		throws PortalException {

		return getService().deleteCustomer(customerId);
	}

	public static Customer deleteCustomer(String name) {
		return getService().deleteCustomer(name);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.upray.customer.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.upray.customer.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Customer fetchCustomer(long customerId) {
		return getService().fetchCustomer(customerId);
	}

	/**
	 * Returns the customer with the matching UUID and company.
	 *
	 * @param uuid the customer's UUID
	 * @param companyId the primary key of the company
	 * @return the matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchCustomerByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchCustomerByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the customer with the primary key.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws PortalException if a customer with the primary key could not be found
	 */
	public static Customer getCustomer(long customerId) throws PortalException {
		return getService().getCustomer(customerId);
	}

	public static Customer getCustomer(String name) {
		return getService().getCustomer(name);
	}

	/**
	 * Returns the customer with the matching UUID and company.
	 *
	 * @param uuid the customer's UUID
	 * @param companyId the primary key of the company
	 * @return the matching customer
	 * @throws PortalException if a matching customer could not be found
	 */
	public static Customer getCustomerByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getCustomerByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.upray.customer.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	public static List<Customer> getCustomers(int start, int end) {
		return getService().getCustomers(start, end);
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	public static int getCustomersCount() {
		return getService().getCustomersCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was updated
	 */
	public static Customer updateCustomer(Customer customer) {
		return getService().updateCustomer(customer);
	}

	public static Customer updateCustomer(long customerId, String name)
		throws com.upray.customer.exception.NoSuchCustomerException {

		return getService().updateCustomer(customerId, name);
	}

	public static CustomerLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CustomerLocalService> _serviceSnapshot =
		new Snapshot<>(
			CustomerLocalServiceUtil.class, CustomerLocalService.class);

}