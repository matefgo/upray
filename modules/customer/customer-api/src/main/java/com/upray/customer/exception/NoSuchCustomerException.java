/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.upray.customer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Matheus Granville
 */
public class NoSuchCustomerException extends NoSuchModelException {

	public NoSuchCustomerException() {
	}

	public NoSuchCustomerException(String msg) {
		super(msg);
	}

	public NoSuchCustomerException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCustomerException(Throwable throwable) {
		super(throwable);
	}

}