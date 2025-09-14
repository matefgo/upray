/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.upray.customer.service.persistence.test;

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

import com.upray.customer.exception.NoSuchCustomerException;
import com.upray.customer.model.Customer;
import com.upray.customer.service.CustomerLocalServiceUtil;
import com.upray.customer.service.persistence.CustomerPersistence;
import com.upray.customer.service.persistence.CustomerUtil;

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
public class CustomerPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.upray.customer.service"));

	@Before
	public void setUp() {
		_persistence = CustomerUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Customer> iterator = _customers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Customer customer = _persistence.create(pk);

		Assert.assertNotNull(customer);

		Assert.assertEquals(customer.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Customer newCustomer = addCustomer();

		_persistence.remove(newCustomer);

		Customer existingCustomer = _persistence.fetchByPrimaryKey(
			newCustomer.getPrimaryKey());

		Assert.assertNull(existingCustomer);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCustomer();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Customer newCustomer = _persistence.create(pk);

		newCustomer.setUuid(RandomTestUtil.randomString());

		newCustomer.setCompanyId(RandomTestUtil.nextLong());

		newCustomer.setUserId(RandomTestUtil.nextLong());

		newCustomer.setUserName(RandomTestUtil.randomString());

		newCustomer.setCreateDate(RandomTestUtil.nextDate());

		newCustomer.setModifiedDate(RandomTestUtil.nextDate());

		newCustomer.setName(RandomTestUtil.randomString());

		_customers.add(_persistence.update(newCustomer));

		Customer existingCustomer = _persistence.findByPrimaryKey(
			newCustomer.getPrimaryKey());

		Assert.assertEquals(existingCustomer.getUuid(), newCustomer.getUuid());
		Assert.assertEquals(
			existingCustomer.getCustomerId(), newCustomer.getCustomerId());
		Assert.assertEquals(
			existingCustomer.getCompanyId(), newCustomer.getCompanyId());
		Assert.assertEquals(
			existingCustomer.getUserId(), newCustomer.getUserId());
		Assert.assertEquals(
			existingCustomer.getUserName(), newCustomer.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCustomer.getCreateDate()),
			Time.getShortTimestamp(newCustomer.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCustomer.getModifiedDate()),
			Time.getShortTimestamp(newCustomer.getModifiedDate()));
		Assert.assertEquals(existingCustomer.getName(), newCustomer.getName());
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
		Customer newCustomer = addCustomer();

		Customer existingCustomer = _persistence.findByPrimaryKey(
			newCustomer.getPrimaryKey());

		Assert.assertEquals(existingCustomer, newCustomer);
	}

	@Test(expected = NoSuchCustomerException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Customer> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Customer_Customer", "uuid", true, "customerId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Customer newCustomer = addCustomer();

		Customer existingCustomer = _persistence.fetchByPrimaryKey(
			newCustomer.getPrimaryKey());

		Assert.assertEquals(existingCustomer, newCustomer);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Customer missingCustomer = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCustomer);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Customer newCustomer1 = addCustomer();
		Customer newCustomer2 = addCustomer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomer1.getPrimaryKey());
		primaryKeys.add(newCustomer2.getPrimaryKey());

		Map<Serializable, Customer> customers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, customers.size());
		Assert.assertEquals(
			newCustomer1, customers.get(newCustomer1.getPrimaryKey()));
		Assert.assertEquals(
			newCustomer2, customers.get(newCustomer2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Customer> customers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(customers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Customer newCustomer = addCustomer();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomer.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Customer> customers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, customers.size());
		Assert.assertEquals(
			newCustomer, customers.get(newCustomer.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Customer> customers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(customers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Customer newCustomer = addCustomer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomer.getPrimaryKey());

		Map<Serializable, Customer> customers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, customers.size());
		Assert.assertEquals(
			newCustomer, customers.get(newCustomer.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CustomerLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Customer>() {

				@Override
				public void performAction(Customer customer) {
					Assert.assertNotNull(customer);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Customer newCustomer = addCustomer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Customer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"customerId", newCustomer.getCustomerId()));

		List<Customer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Customer existingCustomer = result.get(0);

		Assert.assertEquals(existingCustomer, newCustomer);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Customer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"customerId", RandomTestUtil.nextLong()));

		List<Customer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Customer newCustomer = addCustomer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Customer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("customerId"));

		Object newCustomerId = newCustomer.getCustomerId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"customerId", new Object[] {newCustomerId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCustomerId = result.get(0);

		Assert.assertEquals(existingCustomerId, newCustomerId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Customer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("customerId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"customerId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Customer addCustomer() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Customer customer = _persistence.create(pk);

		customer.setUuid(RandomTestUtil.randomString());

		customer.setCompanyId(RandomTestUtil.nextLong());

		customer.setUserId(RandomTestUtil.nextLong());

		customer.setUserName(RandomTestUtil.randomString());

		customer.setCreateDate(RandomTestUtil.nextDate());

		customer.setModifiedDate(RandomTestUtil.nextDate());

		customer.setName(RandomTestUtil.randomString());

		_customers.add(_persistence.update(customer));

		return customer;
	}

	private List<Customer> _customers = new ArrayList<Customer>();
	private CustomerPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}