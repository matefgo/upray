package com.upray.customer.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.upray.customer.rest.dto.v1_0.Customer;
import com.upray.customer.rest.resource.v1_0.CustomerResource;

import com.upray.customer.service.CustomerLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matheus Granville
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/customer.properties",
	scope = ServiceScope.PROTOTYPE, service = CustomerResource.class
)
public class CustomerResourceImpl extends BaseCustomerResourceImpl {

	@Override
	public Page<Customer> getCustomers(String search, Pagination pagination) throws Exception {
		List<com.upray.customer.model.Customer> customersLists =
				customerLocalService.getCustomers(search, pagination.getStartPosition(), pagination.getEndPosition());

		List<Customer> response = new ArrayList<>();

		for (com.upray.customer.model.Customer customer : customersLists) {
			Customer responseCustomer = new Customer();
			responseCustomer.setCustomerId(customer.getCustomerId());
			responseCustomer.setName(customer.getName());
			response.add(responseCustomer);
		}

		int customersCount = customerLocalService.getCustomersCount();

		return Page.of(response, pagination, customersCount);
	}

	@Reference
	private CustomerLocalService customerLocalService;
}