package com.upray.customer.web.frontend.data.set.view.table;

import com.liferay.frontend.data.set.view.FDSView;
import com.liferay.frontend.data.set.view.table.BaseTableFDSView;
import com.liferay.frontend.data.set.view.table.FDSTableSchema;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilder;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilderFactory;
import com.upray.customer.web.constants.CustomerPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        property = "frontend.data.set.name=" + CustomerPortletKeys.CUSTOMER,
        service = FDSView.class
)
public class CustomerTableFDSView extends BaseTableFDSView {
    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder =
                _fdsTableSchemaBuilderFactory.create();

        return fdsTableSchemaBuilder.add(
                "name",
                "name"
        ).build();
    }

    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;
}
