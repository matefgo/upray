package com.upray.customer.web.display.context;

import com.liferay.frontend.data.set.model.FDSActionDropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class CustomerDisplayContext {

    public CustomerDisplayContext(
            HttpServletRequest httpServletRequest, Language language,
            RenderRequest renderRequest, RenderResponse renderResponse) {

        _language = language;
        _httpServletRequest = httpServletRequest;
        _renderResponse = renderResponse;
        _themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    public String getApiURL() {
        return "/o/customer-rest/v1.0/customer";
    }

    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addDropdownItem(
                        dropdownItem -> {
                            dropdownItem.setHref(
                                    _renderResponse.createRenderURL(),
                                    "mvcRenderCommandName",
                                    "/customer/edit",
                                    "redirect",
                                    _themeDisplay.getURLCurrent()
                            );
                            dropdownItem.setLabel(
                                    _language.get(
                                            _httpServletRequest, "create-new-customer"));
                        }).build();
    }

    public List<FDSActionDropdownItem> getFDSActionDropdownItems() {
        return ListUtil.fromArray(
                new FDSActionDropdownItem(
                        PortletURLBuilder.createRenderURL(
                                _renderResponse
                        ).setMVCRenderCommandName(
                                "/customer/edit"
                        ).setRedirect(
                                _themeDisplay.getURLCurrent()
                        ).setParameter(
                            "customerId", "{customerId}"
                        ).setParameter(
                            "customerName", "{name}"
                        ).buildString(),
                        "pencil",
                        "edit",
                        _language.get(_httpServletRequest, "edit"),
                        "get",
                        "",
                        null),
                new FDSActionDropdownItem(
                        PortletURLBuilder.createActionURL(
                                _renderResponse
                        ).setActionName(
                                "/customer/delete"
                        ).setRedirect(
                                _themeDisplay.getURLCurrent()
                        ).setParameter(
                                "customerName", "{name}"
                        ).buildString(),
                        "trash",
                        "delete",
                        _language.get(_httpServletRequest, "delete"),
                        "post",
                        "",
                        "async")
              );
    }

    private  final Language _language;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _renderResponse;
    private final ThemeDisplay _themeDisplay;
}
