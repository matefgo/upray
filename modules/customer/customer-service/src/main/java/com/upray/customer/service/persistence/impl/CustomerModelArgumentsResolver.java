/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.upray.customer.model.CustomerTable;
import com.upray.customer.model.impl.CustomerImpl;
import com.upray.customer.model.impl.CustomerModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Customer.
 *
 * @author Matheus Granville
 * @generated
 */
@Component(
	property = {
		"class.name=com.upray.customer.model.impl.CustomerImpl",
		"table.name=Customer_Customer"
	},
	service = ArgumentsResolver.class
)
public class CustomerModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		CustomerModelImpl customerModelImpl = (CustomerModelImpl)baseModel;

		long columnBitmask = customerModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(customerModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= customerModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(CustomerPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(customerModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CustomerImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CustomerTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CustomerModelImpl customerModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = customerModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = customerModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= CustomerModelImpl.getColumnBitmask("name");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}