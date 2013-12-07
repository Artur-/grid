package com.example.grid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.example.grid.data.DataGenerator;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container.Indexed;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.ColumnGroup;
import com.vaadin.ui.components.grid.ColumnGroupRow;
import com.vaadin.ui.components.grid.Grid;

@SuppressWarnings("serial")
@Theme("grid")
public class GridUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = GridUI.class)
	public static class Servlet extends VaadinServlet {

		@Override
		protected void servletInitialized() throws ServletException {
			super.servletInitialized();
		}
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.setMargin(true);
		setContent(layout);
		Indexed container = DataGenerator.createContainer(1000);

		Grid grid = new Grid(container);
		grid.setSizeFull();
		ColumnGroupRow groupRow = grid.addColumnGroupRow();
		ColumnGroup group = groupRow.addGroup("firstName", "lastName");
		group.setHeaderCaption("Full name");

		ColumnGroup addressGroup = groupRow.addGroup("address.city",
				"address.country", "address.streetName");
		addressGroup.setHeaderCaption("Address");

		grid.getColumnGroupRows().get(0).getGroups().get(0)
				.setFooterCaption("an");
		// grid.setColumnAlignment("salary",RIGHT);
		// grid.setColumnFootersVisible(true);
		// grid.setfooter("age",averageAge);
		// grid.setfooter("salary",averageSalary);
		grid.setLastFrozenPropertyId("_employeeId");

		grid.setWidth("550px");
		layout.addComponent(grid);
		layout.setExpandRatio(grid, 1);

		setContent(new AddressbookEditor());
	}

}