/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.upray.project.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProjectException extends NoSuchModelException {

	public NoSuchProjectException() {
	}

	public NoSuchProjectException(String msg) {
		super(msg);
	}

	public NoSuchProjectException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchProjectException(Throwable throwable) {
		super(throwable);
	}

}