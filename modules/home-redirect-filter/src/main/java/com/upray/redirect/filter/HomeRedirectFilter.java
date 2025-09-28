package com.upray.redirect.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.PortalUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.osgi.service.component.annotations.Component;

@Component(
		property = {
				"after-filter=Absolute Redirects Filter",
				"servlet-context-name=",
				"servlet-filter-name=Home Redirect Filter",
				"url-pattern=/",
				"url-pattern=/home"
		},
		service = Filter.class
)
public class HomeRedirectFilter extends BaseFilter {

	@Override
	protected void processFilter(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws Exception {

		long userId = PortalUtil.getUserId(httpServletRequest);
		User user = null;
		if (userId > 0) {
			user = UserLocalServiceUtil.getUser(userId);
		}
		boolean signedIn = (user != null);

		if (signedIn) {
			httpServletResponse.sendRedirect("/dashboard");
			return;
		}

		processFilter(
				HomeRedirectFilter.class.getName(), httpServletRequest,
				httpServletResponse, filterChain);
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private static final Log _log = LogFactoryUtil.getLog(HomeRedirectFilter.class);
}