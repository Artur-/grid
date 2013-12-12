package org.vaadin.artur.grid;

import org.vaadin.artur.grid.data.DataGenerator;
import org.vaadin.artur.grid.data.Person;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.components.grid.ColumnGroup;
import com.vaadin.ui.components.grid.ColumnGroupRow;
import com.vaadin.ui.components.grid.Grid;
import com.vaadin.ui.components.grid.GridColumn;

public class PersonGrid extends Grid {

	public PersonGrid() {
		super(DataGenerator.createContainer(1000));

		ColumnGroupRow headerGroup = addColumnGroupRow();
		ColumnGroup name = headerGroup.addGroup("firstName", "lastName");
		name.setHeaderCaption("Full name");

		ColumnGroup address = headerGroup.addGroup("address.city",
				"address.country", "address._streetName");

		address.setHeaderCaption("Address");

		GridColumn empId = getColumn("_employeeId");
		empId.setHeaderCaption("Id");
		empId.setWidth(10);

		ColumnGroupRow footer2 = addColumnGroupRow();
		footer2.setHeaderVisible(false);
		footer2.setFooterVisible(true);
		getColumn("_employeeId").setFooterCaption(
				"Count: " + getContainerDatasource().size());
		getColumn("salary").setFooterCaption("Avg: " + getAverageSalary());
		footer2.addGroup("salary").setFooterCaption("Max: " + getMaxSalary());
		setColumnFootersVisible(true);

		getColumn("address._streetName").setWidth(200);
		setLastFrozenPropertyId("_employeeId");
		
		
		getColumn("birthDate").setHeaderCaption("Birth date");
		getColumn("firstName").setHeaderCaption("First");
		getColumn("lastName").setHeaderCaption("Last");
		getColumn("salary").setHeaderCaption("Salary (€)");
		getColumn("address.city").setHeaderCaption("City");
		getColumn("address.country").setHeaderCaption("Country");
		getColumn("address._streetName").setHeaderCaption("Street");
	}

	private double getAverageSalary() {
		double salary = 0.0;
		for (Person b : getContainerDatasource().getItemIds()) {
			salary += b.getSalary().doubleValue();
		}
		return salary / getContainerDatasource().size();
	}

	private double getMaxSalary() {
		double salary = 0.0;
		for (Person b : getContainerDatasource().getItemIds()) {
			salary = Math.max(salary, b.getSalary().doubleValue());
		}
		return salary;
	}

	@Override
	public BeanItemContainer<Person> getContainerDatasource() {
		return (BeanItemContainer<Person>) super.getContainerDatasource();
	}
}
