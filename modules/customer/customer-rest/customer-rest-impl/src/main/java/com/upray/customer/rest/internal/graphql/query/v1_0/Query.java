package com.upray.customer.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.upray.customer.rest.dto.v1_0.Customer;
import com.upray.customer.rest.resource.v1_0.CustomerResource;

import java.util.Map;
import java.util.function.BiFunction;

import jakarta.annotation.Generated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Matheus Granville
 * @generated
 */
@Generated("")
public class Query {

	public static void setCustomerResourceComponentServiceObjects(
		ComponentServiceObjects<CustomerResource>
			customerResourceComponentServiceObjects) {

		_customerResourceComponentServiceObjects =
			customerResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {customers(page: ___, pageSize: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CustomerPage customers(
			@GraphQLName("search") String search,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_customerResourceComponentServiceObjects,
			this::_populateResourceContext,
			customerResource -> new CustomerPage(
				customerResource.getCustomers(
					search, Pagination.of(page, pageSize))));
	}

	@GraphQLName("CustomerPage")
	public class CustomerPage {

		public CustomerPage(Page customerPage) {
			actions = customerPage.getActions();

			items = customerPage.getItems();
			lastPage = customerPage.getLastPage();
			page = customerPage.getPage();
			pageSize = customerPage.getPageSize();
			totalCount = customerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<Customer> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(CustomerResource customerResource)
		throws Exception {

		customerResource.setContextAcceptLanguage(_acceptLanguage);
		customerResource.setContextCompany(_company);
		customerResource.setContextHttpServletRequest(_httpServletRequest);
		customerResource.setContextHttpServletResponse(_httpServletResponse);
		customerResource.setContextUriInfo(_uriInfo);
		customerResource.setContextUser(_user);
		customerResource.setGroupLocalService(_groupLocalService);
		customerResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CustomerResource>
		_customerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction
		<Object, String, com.liferay.portal.kernel.search.filter.Filter>
			_filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, com.liferay.portal.kernel.search.Sort[]>
		_sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}