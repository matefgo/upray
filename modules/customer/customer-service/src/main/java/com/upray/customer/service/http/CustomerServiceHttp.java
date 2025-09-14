/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.upray.customer.service.CustomerServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CustomerServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Matheus Granville
 * @generated
 */
public class CustomerServiceHttp {

	public static com.upray.customer.model.Customer addCustomer(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				CustomerServiceUtil.class, "addCustomer",
				_addCustomerParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.customer.model.Customer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.upray.customer.model.Customer updateCustomer(
			HttpPrincipal httpPrincipal, long customerId, String name)
		throws com.upray.customer.exception.NoSuchCustomerException {

		try {
			MethodKey methodKey = new MethodKey(
				CustomerServiceUtil.class, "updateCustomer",
				_updateCustomerParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, customerId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.upray.customer.exception.NoSuchCustomerException) {

					throw (com.upray.customer.exception.NoSuchCustomerException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.customer.model.Customer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.upray.customer.model.Customer deleteCustomer(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				CustomerServiceUtil.class, "deleteCustomer",
				_deleteCustomerParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.customer.model.Customer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.upray.customer.model.Customer getCustomerByName(
		HttpPrincipal httpPrincipal, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				CustomerServiceUtil.class, "getCustomerByName",
				_getCustomerByNameParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.customer.model.Customer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.upray.customer.model.Customer>
		getCustomers(HttpPrincipal httpPrincipal, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				CustomerServiceUtil.class, "getCustomers",
				_getCustomersParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.upray.customer.model.Customer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CustomerServiceHttp.class);

	private static final Class<?>[] _addCustomerParameterTypes0 = new Class[] {
		String.class
	};
	private static final Class<?>[] _updateCustomerParameterTypes1 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _deleteCustomerParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getCustomerByNameParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getCustomersParameterTypes4 = new Class[] {
		int.class, int.class
	};

}