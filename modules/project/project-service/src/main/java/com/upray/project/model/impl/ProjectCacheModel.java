/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.upray.project.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectCacheModel)) {
			return false;
		}

		ProjectCacheModel projectCacheModel = (ProjectCacheModel)object;

		if (projectId == projectCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", originalVersion=");
		sb.append(originalVersion);
		sb.append(", upgradeVersion=");
		sb.append(upgradeVersion);
		sb.append(", status=");
		sb.append(status);
		sb.append(", phase=");
		sb.append(phase);
		sb.append(", deadline=");
		sb.append(deadline);
		sb.append(", deliveryDate=");
		sb.append(deliveryDate);
		sb.append(", contractDate=");
		sb.append(contractDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (uuid == null) {
			projectImpl.setUuid("");
		}
		else {
			projectImpl.setUuid(uuid);
		}

		projectImpl.setProjectId(projectId);
		projectImpl.setCompanyId(companyId);
		projectImpl.setUserId(userId);

		if (userName == null) {
			projectImpl.setUserName("");
		}
		else {
			projectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectImpl.setCreateDate(null);
		}
		else {
			projectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectImpl.setModifiedDate(null);
		}
		else {
			projectImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectImpl.setCustomerId(customerId);

		if (name == null) {
			projectImpl.setName("");
		}
		else {
			projectImpl.setName(name);
		}

		if (originalVersion == null) {
			projectImpl.setOriginalVersion("");
		}
		else {
			projectImpl.setOriginalVersion(originalVersion);
		}

		if (upgradeVersion == null) {
			projectImpl.setUpgradeVersion("");
		}
		else {
			projectImpl.setUpgradeVersion(upgradeVersion);
		}

		projectImpl.setStatus(status);
		projectImpl.setPhase(phase);

		if (deadline == Long.MIN_VALUE) {
			projectImpl.setDeadline(null);
		}
		else {
			projectImpl.setDeadline(new Date(deadline));
		}

		if (deliveryDate == Long.MIN_VALUE) {
			projectImpl.setDeliveryDate(null);
		}
		else {
			projectImpl.setDeliveryDate(new Date(deliveryDate));
		}

		if (contractDate == Long.MIN_VALUE) {
			projectImpl.setContractDate(null);
		}
		else {
			projectImpl.setContractDate(new Date(contractDate));
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		originalVersion = objectInput.readUTF();
		upgradeVersion = objectInput.readUTF();

		status = objectInput.readInt();

		phase = objectInput.readInt();
		deadline = objectInput.readLong();
		deliveryDate = objectInput.readLong();
		contractDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(customerId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (originalVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(originalVersion);
		}

		if (upgradeVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(upgradeVersion);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(phase);
		objectOutput.writeLong(deadline);
		objectOutput.writeLong(deliveryDate);
		objectOutput.writeLong(contractDate);
	}

	public String uuid;
	public long projectId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public String name;
	public String originalVersion;
	public String upgradeVersion;
	public int status;
	public int phase;
	public long deadline;
	public long deliveryDate;
	public long contractDate;

}