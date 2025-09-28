package com.upray.customer.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.xmlrpc.Response;
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
			response.add(convertToDTO(customer));
		}

		long customersCount = customerLocalService.getCustomersCount(search);

		return Page.of(response, pagination, customersCount);
	}

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		com.upray.customer.model.Customer newCustomer = customerLocalService.addCustomer(customer.getName());

		return convertToDTO(newCustomer);
	}

	@Override
	public Customer deleteCustomer(String customerName) throws Exception {
		com.upray.customer.model.Customer deletedCustomer = customerLocalService.deleteCustomer(customerName);

		return convertToDTO(deletedCustomer);
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer customer) throws Exception {
		com.upray.customer.model.Customer updatedCustomer =
				customerLocalService.updateCustomer(customerId, customer.getName());

		return convertToDTO(updatedCustomer);
	}

	private Customer convertToDTO(com.upray.customer.model.Customer customer) {
		Customer customerDto = new Customer();

		customerDto.setCustomerId(String.valueOf(customer.getCustomerId()));
		customerDto.setName(customer.getName());

		return customerDto;
	}

	@Reference
	private CustomerLocalService customerLocalService;
}