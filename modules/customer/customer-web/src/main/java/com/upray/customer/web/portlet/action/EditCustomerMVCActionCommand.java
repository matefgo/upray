package com.upray.customer.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
                "mvc.command.name=/customer/edit"
        },
        service = MVCActionCommand.class
)
public class EditCustomerMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        long customerId = ParamUtil.getLong(actionRequest, "customerId");
        String name = ParamUtil.getString(actionRequest, "name");

        if (customerId == 0) {
            CustomerLocalServiceUtil.addCustomer(name);
            return;
        }

        CustomerLocalServiceUtil.updateCustomer(customerId, name);
    }
}