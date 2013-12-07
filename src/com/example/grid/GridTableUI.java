//package com.example.grid;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//
//import com.example.grid.data.DataGenerator;
//import com.vaadin.annotations.Theme;
//import com.vaadin.annotations.VaadinServletConfiguration;
//import com.vaadin.data.Container.Indexed;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.server.VaadinServlet;
//import com.vaadin.ui.Component;
//import com.vaadin.ui.Table;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.components.grid.ColumnGroup;
//import com.vaadin.ui.components.grid.ColumnGroupRow;
//import com.vaadin.ui.components.grid.Grid;
//
//@SuppressWarnings("serial")
//@Theme("grid")
//public class GridTableUI extends UI {
//
//	@WebServlet(value = "/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = GridTableUI.class)
//	public static class Servlet extends VaadinServlet {
//
//		@Override
//		protected void servletInitialized() throws ServletException {
//			super.servletInitialized();
//		}
//	}
//
//	@Override
//	protected void init(VaadinRequest request) {
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setSizeFull();
//		layout.setMargin(true);
//		setContent(layout);
//		Indexed container = DataGenerator.createContainer(1000);
//
//		Component gridOrTable;
//		String path = request.getPathInfo();
//		if (path.startsWith("/table")) {
//			Table table = new Table();
//			table.setContainerDataSource(container);
//			table.setSizeFull();
//
//			gridOrTable = table;
//		} else {
//			Grid grid;
//
//			grid = new Grid(container);
//			grid.setSizeFull();
//			ColumnGroupRow groupRow = grid.addColumnGroupRow();
//			ColumnGroup group = groupRow.addGroup("firstName", "lastName");
//			group.setHeaderCaption("Full name");
//			grid.setLastFrozenPropertyId("_id");
//
//			gridOrTable = grid;
//		}
//		gridOrTable.setWidth("550px");
//		layout.addComponent(gridOrTable);
//		layout.setExpandRatio(gridOrTable, 1);
//	}
//
//}