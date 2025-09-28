package com.upray.customer.rest.client.serdes.v1_0;

import com.upray.customer.rest.client.dto.v1_0.Customer;
import com.upray.customer.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import jakarta.annotation.Generated;

/**
 * @author Matheus Granville
 * @generated
 */
@Generated("")
public class CustomerSerDes {

	public static Customer toDTO(String json) {
		CustomerJSONParser customerJSONParser = new CustomerJSONParser();

		return customerJSONParser.parseToDTO(json);
	}

	public static Customer[] toDTOs(String json) {
		CustomerJSONParser customerJSONParser = new CustomerJSONParser();

		return customerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Customer customer) {
		if (customer == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (customer.getCustomerId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerId\": ");

			sb.append("\"");

			sb.append(_escape(customer.getCustomerId()));

			sb.append("\"");
		}

		if (customer.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(customer.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CustomerJSONParser customerJSONParser = new CustomerJSONParser();

		return customerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Customer customer) {
		if (customer == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (customer.getCustomerId() == null) {
			map.put("customerId", null);
		}
		else {
			map.put("customerId", String.valueOf(customer.getCustomerId()));
		}

		if (customer.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(customer.getName()));
		}

		return map;
	}

	public static class CustomerJSONParser extends BaseJSONParser<Customer> {

		@Override
		protected Customer createDTO() {
			return new Customer();
		}

		@Override
		protected Customer[] createDTOArray(int size) {
			return new Customer[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "customerId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			Customer customer, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "customerId")) {
				if (jsonParserFieldValue != null) {
					customer.setCustomerId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					customer.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			sb.append(_toJSON(value));

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _toJSON(Object value) {
		if (value == null) {
			return "null";
		}

		if (value instanceof Map) {
			return _toJSON((Map)value);
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			StringBuilder sb = new StringBuilder("[");

			Object[] values = (Object[])value;

			for (int i = 0; i < values.length; i++) {
				sb.append(_toJSON(values[i]));

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");

			return sb.toString();
		}

		if (value instanceof String) {
			return "\"" + _escape(value) + "\"";
		}

		return String.valueOf(value);
	}

}