/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectWrapper
	extends BaseModelWrapper<Project>
	implements ModelWrapper<Project>, Project {

	public ProjectWrapper(Project project) {
		super(project);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());
		attributes.put("originalVersion", getOriginalVersion());
		attributes.put("upgradeVersion", getUpgradeVersion());
		attributes.put("status", getStatus());
		attributes.put("phase", getPhase());
		attributes.put("deadline", getDeadline());
		attributes.put("deliveryDate", getDeliveryDate());
		attributes.put("contractDate", getContractDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String originalVersion = (String)attributes.get("originalVersion");

		if (originalVersion != null) {
			setOriginalVersion(originalVersion);
		}

		String upgradeVersion = (String)attributes.get("upgradeVersion");

		if (upgradeVersion != null) {
			setUpgradeVersion(upgradeVersion);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer phase = (Integer)attributes.get("phase");

		if (phase != null) {
			setPhase(phase);
		}

		Date deadline = (Date)attributes.get("deadline");

		if (deadline != null) {
			setDeadline(deadline);
		}

		Date deliveryDate = (Date)attributes.get("deliveryDate");

		if (deliveryDate != null) {
			setDeliveryDate(deliveryDate);
		}

		Date contractDate = (Date)attributes.get("contractDate");

		if (contractDate != null) {
			setContractDate(contractDate);
		}
	}

	@Override
	public Project cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contract date of this project.
	 *
	 * @return the contract date of this project
	 */
	@Override
	public Date getContractDate() {
		return model.getContractDate();
	}

	/**
	 * Returns the create date of this project.
	 *
	 * @return the create date of this project
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this project.
	 *
	 * @return the customer ID of this project
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the deadline of this project.
	 *
	 * @return the deadline of this project
	 */
	@Override
	public Date getDeadline() {
		return model.getDeadline();
	}

	/**
	 * Returns the delivery date of this project.
	 *
	 * @return the delivery date of this project
	 */
	@Override
	public Date getDeliveryDate() {
		return model.getDeliveryDate();
	}

	/**
	 * Returns the modified date of this project.
	 *
	 * @return the modified date of this project
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this project.
	 *
	 * @return the name of this project
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the original version of this project.
	 *
	 * @return the original version of this project
	 */
	@Override
	public String getOriginalVersion() {
		return model.getOriginalVersion();
	}

	/**
	 * Returns the phase of this project.
	 *
	 * @return the phase of this project
	 */
	@Override
	public int getPhase() {
		return model.getPhase();
	}

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the status of this project.
	 *
	 * @return the status of this project
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the upgrade version of this project.
	 *
	 * @return the upgrade version of this project
	 */
	@Override
	public String getUpgradeVersion() {
		return model.getUpgradeVersion();
	}

	/**
	 * Returns the user ID of this project.
	 *
	 * @return the user ID of this project
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this project.
	 *
	 * @return the user name of this project
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this project.
	 *
	 * @return the user uuid of this project
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this project.
	 *
	 * @return the uuid of this project
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contract date of this project.
	 *
	 * @param contractDate the contract date of this project
	 */
	@Override
	public void setContractDate(Date contractDate) {
		model.setContractDate(contractDate);
	}

	/**
	 * Sets the create date of this project.
	 *
	 * @param createDate the create date of this project
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this project.
	 *
	 * @param customerId the customer ID of this project
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the deadline of this project.
	 *
	 * @param deadline the deadline of this project
	 */
	@Override
	public void setDeadline(Date deadline) {
		model.setDeadline(deadline);
	}

	/**
	 * Sets the delivery date of this project.
	 *
	 * @param deliveryDate the delivery date of this project
	 */
	@Override
	public void setDeliveryDate(Date deliveryDate) {
		model.setDeliveryDate(deliveryDate);
	}

	/**
	 * Sets the modified date of this project.
	 *
	 * @param modifiedDate the modified date of this project
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this project.
	 *
	 * @param name the name of this project
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the original version of this project.
	 *
	 * @param originalVersion the original version of this project
	 */
	@Override
	public void setOriginalVersion(String originalVersion) {
		model.setOriginalVersion(originalVersion);
	}

	/**
	 * Sets the phase of this project.
	 *
	 * @param phase the phase of this project
	 */
	@Override
	public void setPhase(int phase) {
		model.setPhase(phase);
	}

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the status of this project.
	 *
	 * @param status the status of this project
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the upgrade version of this project.
	 *
	 * @param upgradeVersion the upgrade version of this project
	 */
	@Override
	public void setUpgradeVersion(String upgradeVersion) {
		model.setUpgradeVersion(upgradeVersion);
	}

	/**
	 * Sets the user ID of this project.
	 *
	 * @param userId the user ID of this project
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this project.
	 *
	 * @param userName the user name of this project
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this project.
	 *
	 * @param userUuid the user uuid of this project
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this project.
	 *
	 * @param uuid the uuid of this project
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProjectWrapper wrap(Project project) {
		return new ProjectWrapper(project);
	}

}