package com.example.grid;

import com.example.grid.data.DataGenerator;
import com.example.grid.data.Person;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.components.grid.Grid;

public class PersonGrid extends Grid {

	public PersonGrid() {
		super(DataGenerator.createContainer(1000));
		setLastFrozenPropertyId("_employeeId");
	}

	@Override
	public BeanItemContainer<Person> getContainerDatasource() {
		return (BeanItemContainer<Person>) super.getContainerDatasource();
	}
}
