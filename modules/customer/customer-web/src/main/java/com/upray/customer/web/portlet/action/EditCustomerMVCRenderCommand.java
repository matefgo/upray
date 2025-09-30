package com.upray.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.upray.customer.web.constants.CustomerPortletKeys;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

/**
 * @author Matheus Granville
 */
@Component(
        property = {
                "jakarta.portlet.name=" + CustomerPortletKeys.CUSTOMER,
                "mvc.command.name=/customer/edit"
        },
        service = MVCRenderCommand.class
)
public class EditCustomerMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {
        return "/edit.jsp";
    }

}