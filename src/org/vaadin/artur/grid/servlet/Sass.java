package org.vaadin.artur.grid.servlet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Sass {

	public static String compile(String realFilename) {
		String css = "";
		Runtime runtime = Runtime.getRuntime();
		Process p;
		try {
			// p = runtime.exec("/usr/bin/sass --trace -- " + tmpFile);
			p = runtime.exec("sass -- " + realFilename);
			String output = getString(p.getInputStream());
			String error = getString(p.getErrorStream());
			p.waitFor();
			int exitValue = p.exitValue();
			System.out.println(exitValue);
			String line;
			if (error != null && !error.isEmpty()) {
				System.out.println(error);
				css = "";
			} else {
				css = output;
			}
			p.destroy();
		} catch (Exception e) {
		}
		return css;
	}

	private static String getString(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(stream));
		StringBuilder output = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line);
		}
		return output.toString();
	}

}
