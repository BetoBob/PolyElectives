package logic;

import java.io.IOException;

public class PageFactory {
	
	public Page getPage(String pageType) {
		if(pageType == null) {
			return null;
		}
		if(pageType.equalsIgnoreCase("About")) {
			return new About();
		}
		else if(pageType.equalsIgnoreCase("Account")) {
			try {
				return new Account();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(pageType.equalsIgnoreCase("Home")) {
			return new Home();
		}
		else if(pageType.equalsIgnoreCase("Tutorial")) {
			return new Tutorial();
		}
		else if(pageType.equalsIgnoreCase("Quiz")) {
			try {
				return new Quiz();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
