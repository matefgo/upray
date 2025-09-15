package com.upray.customer.rest.client.dto.v1_0;

import com.upray.customer.rest.client.function.UnsafeSupplier;
import com.upray.customer.rest.client.serdes.v1_0.CustomerSerDes;

import java.io.Serializable;

import java.util.Objects;

import jakarta.annotation.Generated;

/**
 * @author Matheus Granville
 * @generated
 */
@Generated("")
public class Customer implements Cloneable, Serializable {

	public static Customer toDTO(String json) {
		return CustomerSerDes.toDTO(json);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerId(
		UnsafeSupplier<Long, Exception> customerIdUnsafeSupplier) {

		try {
			customerId = customerIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long customerId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public Customer clone() throws CloneNotSupportedException {
		return (Customer)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Customer)) {
			return false;
		}

		Customer customer = (Customer)object;

		return Objects.equals(toString(), customer.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CustomerSerDes.toJSON(this);
	}

}