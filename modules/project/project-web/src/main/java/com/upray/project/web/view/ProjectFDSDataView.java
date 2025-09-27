package com.upray.project.web.view;

import com.liferay.frontend.data.set.view.FDSView;
import com.liferay.frontend.data.set.view.table.BaseTableFDSView;
import com.liferay.frontend.data.set.view.table.FDSTableSchema;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilder;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilderFactory;
import com.upray.project.web.constants.ProjectPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        property = "frontend.data.set.name=" + ProjectPortletKeys.PROJECT,
        service = FDSView.class
)
public class ProjectFDSDataView extends BaseTableFDSView {
    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder =
                _fdsTableSchemaBuilderFactory.create();

        return fdsTableSchemaBuilder.add(
                "name", "name"
        ).add(
                "originalVersion", "Original version"
        ).add(
                "upgradeVersion", "Upgrade version"
        ).add(
                "status", "Status"
        ).add(
                "phase", "Current phase"
        ).build();
    }

    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;
}
