package utils;

public class Parser {

	public static double parseDouble(String e) {

		if (e.isEmpty()) {

			return 0;
		} else {

			return Double.parseDouble(e);
		}

	}

}
