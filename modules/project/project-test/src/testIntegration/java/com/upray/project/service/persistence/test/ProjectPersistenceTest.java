/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.project.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.upray.project.exception.NoSuchProjectException;
import com.upray.project.model.Project;
import com.upray.project.service.ProjectLocalServiceUtil;
import com.upray.project.service.persistence.ProjectPersistence;
import com.upray.project.service.persistence.ProjectUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ProjectPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.upray.project.service"));

	@Before
	public void setUp() {
		_persistence = ProjectUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Project> iterator = _projects.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Project project = _persistence.create(pk);

		Assert.assertNotNull(project);

		Assert.assertEquals(project.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Project newProject = addProject();

		_persistence.remove(newProject);

		Project existingProject = _persistence.fetchByPrimaryKey(
			newProject.getPrimaryKey());

		Assert.assertNull(existingProject);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProject();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Project newProject = _persistence.create(pk);

		newProject.setUuid(RandomTestUtil.randomString());

		newProject.setCompanyId(RandomTestUtil.nextLong());

		newProject.setUserId(RandomTestUtil.nextLong());

		newProject.setUserName(RandomTestUtil.randomString());

		newProject.setCreateDate(RandomTestUtil.nextDate());

		newProject.setModifiedDate(RandomTestUtil.nextDate());

		newProject.setCustomerId(RandomTestUtil.nextLong());

		newProject.setName(RandomTestUtil.randomString());

		newProject.setOriginalVersion(RandomTestUtil.randomString());

		newProject.setUpgradeVersion(RandomTestUtil.randomString());

		newProject.setStatus(RandomTestUtil.nextInt());

		newProject.setPhase(RandomTestUtil.nextInt());

		newProject.setDeadline(RandomTestUtil.nextDate());

		newProject.setDeliveryDate(RandomTestUtil.nextDate());

		newProject.setContractDate(RandomTestUtil.nextDate());

		_projects.add(_persistence.update(newProject));

		Project existingProject = _persistence.findByPrimaryKey(
			newProject.getPrimaryKey());

		Assert.assertEquals(existingProject.getUuid(), newProject.getUuid());
		Assert.assertEquals(
			existingProject.getProjectId(), newProject.getProjectId());
		Assert.assertEquals(
			existingProject.getCompanyId(), newProject.getCompanyId());
		Assert.assertEquals(
			existingProject.getUserId(), newProject.getUserId());
		Assert.assertEquals(
			existingProject.getUserName(), newProject.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProject.getCreateDate()),
			Time.getShortTimestamp(newProject.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProject.getModifiedDate()),
			Time.getShortTimestamp(newProject.getModifiedDate()));
		Assert.assertEquals(
			existingProject.getCustomerId(), newProject.getCustomerId());
		Assert.assertEquals(existingProject.getName(), newProject.getName());
		Assert.assertEquals(
			existingProject.getOriginalVersion(),
			newProject.getOriginalVersion());
		Assert.assertEquals(
			existingProject.getUpgradeVersion(),
			newProject.getUpgradeVersion());
		Assert.assertEquals(
			existingProject.getStatus(), newProject.getStatus());
		Assert.assertEquals(existingProject.getPhase(), newProject.getPhase());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProject.getDeadline()),
			Time.getShortTimestamp(newProject.getDeadline()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProject.getDeliveryDate()),
			Time.getShortTimestamp(newProject.getDeliveryDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProject.getContractDate()),
			Time.getShortTimestamp(newProject.getContractDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Project newProject = addProject();

		Project existingProject = _persistence.findByPrimaryKey(
			newProject.getPrimaryKey());

		Assert.assertEquals(existingProject, newProject);
	}

	@Test(expected = NoSuchProjectException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Project> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Project_Project", "uuid", true, "projectId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "customerId", true, "name", true,
			"originalVersion", true, "upgradeVersion", true, "status", true,
			"phase", true, "deadline", true, "deliveryDate", true,
			"contractDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Project newProject = addProject();

		Project existingProject = _persistence.fetchByPrimaryKey(
			newProject.getPrimaryKey());

		Assert.assertEquals(existingProject, newProject);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Project missingProject = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProject);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Project newProject1 = addProject();
		Project newProject2 = addProject();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProject1.getPrimaryKey());
		primaryKeys.add(newProject2.getPrimaryKey());

		Map<Serializable, Project> projects = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, projects.size());
		Assert.assertEquals(
			newProject1, projects.get(newProject1.getPrimaryKey()));
		Assert.assertEquals(
			newProject2, projects.get(newProject2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Project> projects = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(projects.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Project newProject = addProject();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProject.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Project> projects = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, projects.size());
		Assert.assertEquals(
			newProject, projects.get(newProject.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Project> projects = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(projects.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Project newProject = addProject();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProject.getPrimaryKey());

		Map<Serializable, Project> projects = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, projects.size());
		Assert.assertEquals(
			newProject, projects.get(newProject.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProjectLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Project>() {

				@Override
				public void performAction(Project project) {
					Assert.assertNotNull(project);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Project newProject = addProject();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Project.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("projectId", newProject.getProjectId()));

		List<Project> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Project existingProject = result.get(0);

		Assert.assertEquals(existingProject, newProject);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Project.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("projectId", RandomTestUtil.nextLong()));

		List<Project> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Project newProject = addProject();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Project.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("projectId"));

		Object newProjectId = newProject.getProjectId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"projectId", new Object[] {newProjectId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingProjectId = result.get(0);

		Assert.assertEquals(existingProjectId, newProjectId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Project.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("projectId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"projectId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Project addProject() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Project project = _persistence.create(pk);

		project.setUuid(RandomTestUtil.randomString());

		project.setCompanyId(RandomTestUtil.nextLong());

		project.setUserId(RandomTestUtil.nextLong());

		project.setUserName(RandomTestUtil.randomString());

		project.setCreateDate(RandomTestUtil.nextDate());

		project.setModifiedDate(RandomTestUtil.nextDate());

		project.setCustomerId(RandomTestUtil.nextLong());

		project.setName(RandomTestUtil.randomString());

		project.setOriginalVersion(RandomTestUtil.randomString());

		project.setUpgradeVersion(RandomTestUtil.randomString());

		project.setStatus(RandomTestUtil.nextInt());

		project.setPhase(RandomTestUtil.nextInt());

		project.setDeadline(RandomTestUtil.nextDate());

		project.setDeliveryDate(RandomTestUtil.nextDate());

		project.setContractDate(RandomTestUtil.nextDate());

		_projects.add(_persistence.update(project));

		return project;
	}

	private List<Project> _projects = new ArrayList<Project>();
	private ProjectPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}