package com.example.grid;

import com.example.grid.data.Address;
import com.example.grid.data.Country;
import com.example.grid.data.Person;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AddressbookEditor extends CustomComponent {

	VerticalLayout layout = new VerticalLayout();
	PersonGrid grid;
	HorizontalLayout tableActions = new HorizontalLayout();
	Button editButton = new Button("Edit");
	Button deleteButton = new Button("Delete");
	Button newButton = new Button("New");
	GridLayout form = new GridLayout(2, 2);
	FieldGroup fields = new FieldGroup();

	TextField firstName = new TextField("First Name");
	TextField lastName = new TextField("Last Name");
	TextField address = new TextField("Address");
	TextField city = new TextField("City");
	ComboBox country = new ComboBox("Country");
	PopupDateField birthDate = new PopupDateField("Birth date");
	TextField salary = new TextField("Salary");

	HorizontalLayout formActions = new HorizontalLayout();
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");

	public AddressbookEditor() {
		initLayout();
		updateGrid();
		initAddressListActions();
		initForm();
	}

	public static class MyFF extends DefaultFieldGroupFieldFactory {
		@Override
		public void populateWithEnumData(AbstractSelect select,
				Class<? extends Enum> enumClass) {
			super.populateWithEnumData(select, enumClass);
		}
	}

	private void initLayout() {
		setCompositionRoot(layout);

		grid = new PersonGrid();
		grid.setWidth("100%");
		grid.setHeight("350px");

		layout.setWidth("100%");
		layout.setSpacing(true);
		layout.setMargin(true);

		layout.addComponent(grid);
		layout.addComponent(tableActions);
		layout.addComponent(form);
		layout.addComponent(formActions);

		tableActions.setSpacing(true);
		tableActions.addComponent(editButton);
		tableActions.addComponent(deleteButton);
		tableActions.addComponent(newButton);
		layout.setComponentAlignment(tableActions, Alignment.MIDDLE_RIGHT);

		new MyFF().populateWithEnumData(country, Country.class);
		salary.setNullRepresentation("");

		form.setWidth("100%");
		form.addComponent(firstName);
		form.addComponent(birthDate);
		form.addComponent(lastName);
		form.addComponent(salary);
		form.addComponent(address);
		form.space();
		form.addComponent(city);
		form.space();
		form.addComponent(country);
		form.setSpacing(true);

		firstName.setWidth("60%");
		lastName.setWidth("60%");
		address.setWidth("100%");
		// phoneNumber.setWidth("50%");
		// emailAddress.setWidth("70%");

		formActions.setSpacing(true);
		formActions.addComponent(saveButton);
		formActions.addComponent(cancelButton);
		layout.setComponentAlignment(formActions, Alignment.MIDDLE_RIGHT);
	}

	private void updateGrid() {
		// grid.setVisibleColumns("firstName", "lastName", "emailAddress",
		// "phoneNumber");
		// grid.setSelectable(true);
		updateActionVisibility(false);
	}

	private void initAddressListActions() {
		editButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Person p = (Person) grid.getContainerDatasource().getItemIds()
						.iterator().next();
				// Address a = (Address) grid.getValue();
				// if (a != null)
				editPerson(p);
			}
		});
		deleteButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// Address a = (Address) grid.getValue();
				// if (a != null) {
				// service.deleteAddress(a.getId());
				// updateGrid();
				// }
			}
		});
		newButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Person p = new Person();
				p.setAddress(new Address());
				editPerson(p);
				// Address a = service.newAddress();
				// editAddress(a);
			}
		});
		// grid.setImmediate(true);
		// grid.addValueChangeListener(new ValueChangeListener() {
		// public void valueChange(ValueChangeEvent event) {
		// updateActionVisibility(false);
		// }
		// });
	}

	private void updateActionVisibility(boolean editingPerson) {
		// boolean selected = grid.getValue() != null;
		// editButton.setEnabled(selected);
		// deleteButton.setEnabled(selected);

//		grid.setEnabled(!editingPerson);
//		tableActions.setEnabled(!editingPerson);
//		formActions.setEnabled(editingPerson);
//		form.setEnabled(editingPerson);
	}

	private void initForm() {
		fields.bind(firstName, "firstName");
		fields.bind(lastName, "lastName");
		fields.bind(salary, "salary");
		fields.bind(birthDate, "birthDate");
		fields.bind(city, "address.city");
		fields.bind(address, "address.streetName");
		fields.bind(country, "address.country");

		// formActions.setEnabled(false);
		// form.setEnabled(false);

		saveButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					fields.commit();
					// @SuppressWarnings("unchecked")
					// Person p = ((BeanItem<Person>)
					// fields.getItemDataSource())
					// .getBean();
					// grid.getContainerDatasource().
					// service.storeAddress(a);
					BeanItem<Person> item = (BeanItem<Person>) fields
							.getItemDataSource();
					if (!grid.getContainerDatasource().containsId(item)) {
						((BeanItemContainer<Person>) grid
								.getContainerDatasource()).addBean(item
								.getBean());
					}
					updateGrid();
					// fields.
					// grid.select(a);
					// grid.setCurrentPageFirstItemId(a);
				} catch (CommitException ignored) {
				}
				updateActionVisibility(false);
				fields.setItemDataSource(null);
			}
		});

		cancelButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				fields.discard();
				updateActionVisibility(false);
				fields.setItemDataSource(null);
			}
		});
	}

	private void editPerson(Person p) {
		BeanItem<Person> item = new BeanItem<Person>(p);
		item.expandProperty("address");
		// item.addNestedProperty("address", true);
		fields.setItemDataSource(item);
		updateActionVisibility(true);
	}

}
