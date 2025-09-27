/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Project_Project&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectTable extends BaseTable<ProjectTable> {

	public static final ProjectTable INSTANCE = new ProjectTable();

	public final Column<ProjectTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> originalVersion = createColumn(
		"originalVersion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> upgradeVersion = createColumn(
		"upgradeVersion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Integer> phase = createColumn(
		"phase", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> deadline = createColumn(
		"deadline", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> deliveryDate = createColumn(
		"deliveryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> contractDate = createColumn(
		"contractDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProjectTable() {
		super("Project_Project", ProjectTable::new);
	}

}