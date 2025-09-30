package com.upray.customer.web.portlet;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.Portal;
import com.upray.customer.web.constants.CustomerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.upray.customer.web.display.context.CustomerDisplayContext;
import jakarta.portlet.Portlet;

import jakarta.portlet.PortletException;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * @author Matheus Granville
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"jakarta.portlet.display-name=Customer",
		"jakarta.portlet.init-param.template-path=/",
		"jakarta.portlet.init-param.view-template=/view.jsp",
		"jakarta.portlet.name=" + CustomerPortletKeys.CUSTOMER,
		"jakarta.portlet.resource-bundle=content.Language",
		"jakarta.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomerPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		CustomerDisplayContext customerDisplayContext =
				new CustomerDisplayContext(
						_portal.getHttpServletRequest(renderRequest), _language,
						renderRequest, renderResponse);

		renderRequest.setAttribute(
				CustomerPortletKeys.DISPLAY_CONTEXT, customerDisplayContext);

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;
}