package com.upray.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.upray.customer.service.CustomerLocalServiceUtil;
import com.upray.customer.web.constants.CustomerPortletKeys;
import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

/**
 * @author Matheus Granville
 */
@Component(
        property = {
                "jakarta.portlet.name=" + CustomerPortletKeys.CUSTOMER,
                "mvc.command.name=/customer/delete"
        },
        service = MVCActionCommand.class
)
public class DeleteCustomerMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        String customerName = ParamUtil.getString(actionRequest, "customerName");

        CustomerLocalServiceUtil.deleteCustomer(customerName);
    }
}