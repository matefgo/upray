package com.upray.customer.rest.client.function;

import jakarta.annotation.Generated;

/**
 * @author Matheus Granville
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}