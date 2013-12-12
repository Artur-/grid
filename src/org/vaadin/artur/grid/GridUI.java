package org.vaadin.artur.grid;

import javax.servlet.annotation.WebServlet;

import org.vaadin.artur.grid.servlet.ThemeServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("grid-demo")
public class GridUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = GridUI.class)
	public static class Servlet extends ThemeServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		setContent(new AddressbookEditor());
	}

}