package Util;

import Util.MyStringUtils;

public class MyStringUtils {
	
	public static String repeat(String elmnt, int length) {
		String result = "";
		for(int i = 0; i < length; i++) {
			result += elmnt;
		}
	return result;
	}

	public static Object centre(String string, int cellSize) {
		String x = "";
		switch (cellSize - string.length()) {
		case 0: x = string;
			break;
		case 1: x = " " + string;
			break;
		case 2: x = " " + string + " ";
			break;
		case 3: x = " " + string + "  ";
			break;
		case 4: x = "  " + string + "  ";
			break;
		case 5: x = "  " + string + "   ";
			break;
		case 6: x = "   " + string + "   ";
			break;
		case 7: x = "   " + string + "    ";
			break;
		case 8: x = "        " ;
			break;
			
		}
		return x;
	}
}