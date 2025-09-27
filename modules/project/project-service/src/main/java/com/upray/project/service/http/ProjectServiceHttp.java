/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.upray.project.service.ProjectServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ProjectServiceUtil</code> service
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
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectServiceHttp {

	public static com.upray.project.model.Project addProject(
		HttpPrincipal httpPrincipal, long customerId, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				ProjectServiceUtil.class, "addProject",
				_addProjectParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, customerId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.project.model.Project)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.upray.project.model.Project addProject(
		HttpPrincipal httpPrincipal, long customerId, String name,
		String originalVersion, String upgradeVersion, int status, int phase,
		java.util.Date deadline, java.util.Date deliveryDate,
		java.util.Date contractDate) {

		try {
			MethodKey methodKey = new MethodKey(
				ProjectServiceUtil.class, "addProject",
				_addProjectParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, customerId, name, originalVersion, upgradeVersion,
				status, phase, deadline, deliveryDate, contractDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.upray.project.model.Project)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.upray.project.model.Project> getProjects(
		HttpPrincipal httpPrincipal, String search, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ProjectServiceUtil.class, "getProjects",
				_getProjectsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, search, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.upray.project.model.Project>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProjectServiceHttp.class);

	private static final Class<?>[] _addProjectParameterTypes0 = new Class[] {
		long.class, String.class
	};
	private static final Class<?>[] _addProjectParameterTypes1 = new Class[] {
		long.class, String.class, String.class, String.class, int.class,
		int.class, java.util.Date.class, java.util.Date.class,
		java.util.Date.class
	};
	private static final Class<?>[] _getProjectsParameterTypes2 = new Class[] {
		String.class, int.class, int.class
	};

}