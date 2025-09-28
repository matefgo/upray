package com.upray.dashboard.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.upray.dashboard.web.constants.DashboardPortletKeys;
import jakarta.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

/**
 * @author Matheus Granville
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"jakarta.portlet.display-name=Dashboard",
		"jakarta.portlet.init-param.template-path=/",
		"jakarta.portlet.init-param.view-template=/view.jsp",
		"jakarta.portlet.name=" + DashboardPortletKeys.DASHBOARD,
		"jakarta.portlet.resource-bundle=content.Language",
		"jakarta.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardPortlet extends MVCPortlet {
}