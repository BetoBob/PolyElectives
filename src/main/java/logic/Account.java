package logic;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Account extends Base implements Page {
	
	public static final int ID_PAGE = 4;
	private VBox root;
	private Menu menu;
	private Scene scene;
	private static VBox subPage;
	private static String fontType = "Tahoma";
	private String goldBG = "-fx-background-color: #B5A76C;";
	private static String greenBG = "-fx-background-color: #035642;";
	private static String blackBG = "-fx-border-color: black;";
	private static Map<String, Map<String, String>> accounts;
	private static String currAccount = "";
	private static int updated = 0;
	private static final String NO_ACCOUNT = "No Account? Create New Account";
	public Account() throws IOException {
		renderPage();
	}
	
	public void renderPage() throws IOException{
		
        accounts = new HashMap<String, Map<String, String>>();
        parseAccounts();    
		
		root = new VBox();		
		subPage = createSub(root);      
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		scene = new Scene(root, 1200, 800);
		
		final GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		final GridPane grid2 = new GridPane();
		grid2.setAlignment(Pos.CENTER);
		grid2.setHgap(10);
		grid2.setVgap(10);
		
		final Label userName = new Label("User Name:");
		userName.setTextFill(Color.BLACK);
		userName.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		grid.add(userName, 0, 24);

		final TextField userTextField = new TextField();
		userTextField.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		grid.add(userTextField, 1, 24);
		
		final Label badInput = new Label("");
		badInput.setTextFill(Color.RED);
		grid.add(badInput, 1, 29);
		
		final Label firstName = new Label("First Name:");
		firstName.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		firstName.setTextFill(Color.BLACK);
		final TextField firstNameTextField = new TextField();
		firstNameTextField.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		final Label lastName = new Label("Last Name:");
		lastName.setTextFill(Color.BLACK);
		lastName.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		final TextField lastNameTextField = new TextField();
		lastNameTextField.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		final Label email = new Label("Email:");
		email.setTextFill(Color.BLACK);
		email.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		final TextField emailTextField = new TextField();
		emailTextField.setFont(Font.font(fontType, FontWeight.NORMAL, 20));

		final Label pw = new Label("Password:");
		pw.setTextFill(Color.BLACK);
		pw.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		grid.add(pw, 0, 25);

		final PasswordField pwBox = new PasswordField();
		pwBox.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		grid.add(pwBox, 1, 25);
		
		final Label pw2 = new Label("Retype Password:");
		pw2.setTextFill(Color.BLACK);
		pw2.setFont(Font.font(fontType, FontWeight.NORMAL, 20));

		final PasswordField pwBox2 = new PasswordField();
		pwBox2.setFont(Font.font(fontType, FontWeight.NORMAL, 20));

		final BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(50));
		
		final Button btn = new Button("Sign in");
		btn.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		btn.setStyle(blackBG+goldBG);
		btn.setTextFill(Color.BLACK);
		final HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		        String username = userTextField.getText();
		        String password = pwBox.getText();
		        badInput.setText("");
		        
		        HashMap<String, String> mapPassword = (HashMap<String, String>) accounts.get(username);
		        if(mapPassword == null) {
		        	badInput.setText("Incorrect Username or Password");
		        }
		        else if(mapPassword.get("pwd").equals(password)) {
		        	currAccount = username;
		        	subPage.getChildren().remove(0);
		        	pane.setCenter(grid2);
		        	displayAccount(username, grid2);
		        	subPage.getChildren().addAll(pane);
					loadResults();
		        }
		        else {
		        	badInput.setText("Incorrect Username or Password");
		        }
		    }
		});
		
		final Button logout = new Button("Logout");
		logout.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		logout.setStyle(blackBG+goldBG);
		logout.setTextFill(Color.BLACK);
		final HBox logoutBtn = new HBox(10);
		logoutBtn.setAlignment(Pos.CENTER_LEFT);
		logoutBtn.getChildren().add(logout);
		
		pane.setTop(logoutBtn);
		
		logout.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	subPage.getChildren().remove(pane);
		    	subPage.getChildren().addAll(grid);
		    	userTextField.setText("");
		        pwBox.setText("");
		        currAccount = "";
		        updated = 0;
		    }
		});
		
		final Button back = new Button("Back to Sign In");
		back.setStyle(blackBG+goldBG);
		back.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		back.setTextFill(Color.BLACK);
		final HBox backBtn = new HBox(10);
		
		final Button newA = new Button(NO_ACCOUNT);
		newA.setStyle(blackBG+goldBG);
		newA.setFont(Font.font(fontType, FontWeight.NORMAL, 20));
		newA.setTextFill(Color.BLACK);
		final HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(newA);
		newA.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	badInput.setText("");
		        	        
		        if (newA.getText().equals(NO_ACCOUNT)) {
		           userTextField.setText("");
		           pwBox.setText("");
		           firstNameTextField.setText("");
		           lastNameTextField.setText("");
		           emailTextField.setText("");
		           pwBox2.setText("");      
		        
		           grid.getChildren().remove(hbBtn);
		           grid.add(pwBox2, 1, 26);
		           grid.add(pw2, 0, 26);
		           newA.setText("Create Account");
		           grid.add(firstName, 0, 22);
		           grid.add(firstNameTextField, 1, 22);
		           grid.add(lastName, 0, 23);
		           grid.add(lastNameTextField, 1, 23);
		           grid.add(email, 0, 27);
		           grid.add(emailTextField, 1, 27);
		           grid.add(back, 0, 35);    
		        }
		        else {
		        	//here we will check if the user name is already in the hash map
		        	//if it is just say a simple message else
		        	//reset the login page so they can login
		        	String username = userTextField.getText();
			        String password = pwBox.getText();
			        String passwordVerify = pwBox2.getText();
			        String firstN = firstNameTextField.getText();
			        String lastN = lastNameTextField.getText();
			        String emails = emailTextField.getText();
			        
			        HashMap<String, String> inIt = (HashMap<String, String>) accounts.get(username);
			        if(inIt != null) {
			        	badInput.setText("                               Username Already In Use");
			        }
			        else if(!password.equals(passwordVerify)) {
			        	badInput.setText("                               Passwords Do Not Match");
			        }
			        else if(username.equals("") || password.equals("") || firstN.equals("") || lastN.equals("") || emails.equals("")) {
			        	badInput.setText("                               Please Complete All Fields");
			        }
			        else {
			        	HashMap<String, String> temp = new HashMap<String, String>();
			        	temp.put("pwd", password);
			        	temp.put("firstN", firstN);
			        	temp.put("lastN", lastN);
			        	temp.put("email", emails);
			        	accounts.put(username, temp);
			        	addNewAccount(username, temp);
			        	userTextField.setText("");
			        	pwBox.setText("");
			        	newA.setText(NO_ACCOUNT);
			        	grid.add(hbBtn, 1, 28);
			        	grid.getChildren().remove(pwBox2);
			        	grid.getChildren().remove(pw2);
			        	grid.getChildren().remove(firstName);
			        	grid.getChildren().remove(firstNameTextField);
			        	grid.getChildren().remove(lastName);
			        	grid.getChildren().remove(lastNameTextField);
			        	grid.getChildren().remove(email);
			        	grid.getChildren().remove(emailTextField);
			        	grid.getChildren().remove(back);
			        }
		        }
		        	
		    }
		});
		
		grid.add(hbBtn, 1, 28);
		grid.add(hbBtn2, 1, 35);
		
		backBtn.setAlignment(Pos.BOTTOM_RIGHT);
		backBtn.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	badInput.setText("");
		        	  
		    	newA.setText(NO_ACCOUNT);
		    	pwBox.setText("");
			    userTextField.setText("");
			    
			    grid.getChildren().remove(email);
			    grid.getChildren().remove(pwBox2);
			    grid.getChildren().remove(firstName);
			    grid.add(hbBtn, 1, 28);
			    grid.getChildren().remove(lastName);
			    grid.getChildren().remove(pw2);
			    grid.getChildren().remove(back);
			    grid.getChildren().remove(firstNameTextField);
			    grid.getChildren().remove(emailTextField);
			    grid.getChildren().remove(lastNameTextField); 
		    }
		});
		
		

		
		subPage.getChildren().addAll(grid);
	}
	
	@Override
	public VBox getRoot() {
		return root;
	}
	
	@Override
	public Menu getMenu() {
		return menu;
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
	
	public void displayAccount(String username, GridPane grid2) {
		HashMap<String, String> currA = (HashMap<String, String>) accounts.get(username);
		
		Label acct = new Label("Account Information");
		acct.setMinWidth(500);
		acct.setMinHeight(50);
		acct.setTextFill(Color.BLACK);
		acct.setStyle(blackBG+goldBG);
		acct.setAlignment(Pos.CENTER);
		acct.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label name = new Label("Name");
		name.setMinWidth(250);
		name.setMinHeight(50);
		name.setTextFill(Color.BLACK);
		name.setStyle(blackBG+greenBG);
		name.setAlignment(Pos.CENTER);
		name.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label fullname = new Label(currA.get("firstN") + " " + currA.get("lastN"));
		fullname.setMinWidth(250);
		fullname.setMinHeight(50);
		fullname.setTextFill(Color.BLACK);
		fullname.setAlignment(Pos.CENTER);
		fullname.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label email = new Label("Email");
		email.setMinWidth(250);
		email.setMinHeight(50);
		email.setTextFill(Color.BLACK);
		email.setStyle(blackBG+greenBG);
		email.setAlignment(Pos.CENTER);
		email.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label fullemail = new Label(currA.get("email"));
		fullemail.setMinWidth(250);
		fullemail.setMinHeight(50);
		fullemail.setTextFill(Color.BLACK);
		fullemail.setAlignment(Pos.CENTER);
		fullemail.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label results = new Label("Results");
		results.setMinWidth(250);
		results.setMinHeight(50);
		results.setTextFill(Color.BLACK);
		results.setStyle(blackBG+greenBG);
		results.setAlignment(Pos.CENTER);
		results.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label temp = new Label("");
		
		Label results1 = new Label("");
		results1.setMinWidth(250);
		results1.setMinHeight(50);
		results1.setTextFill(Color.BLACK);
		results1.setAlignment(Pos.CENTER);
		results1.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label results2 = new Label("");
		results2.setMinWidth(250);
		results2.setMinHeight(50);
		results2.setTextFill(Color.BLACK);
		results2.setAlignment(Pos.CENTER);
		results2.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		Label results3 = new Label("");
		results3.setMinWidth(250);
		results3.setMinHeight(50);
		results3.setTextFill(Color.BLACK);
		results3.setAlignment(Pos.CENTER);
		results3.setFont(Font.font(fontType, FontWeight.NORMAL, 25));
		
		grid2.add(acct,  3,  7, 3, 1);
		grid2.add(name, 3, 10);
		grid2.add(fullname, 5, 10);
		grid2.add(email, 3, 12);
		grid2.add(fullemail,  5,  12);
		grid2.add(results, 3, 14);
		grid2.add(results1, 5, 14);
		grid2.add(results2, 5, 16);
		grid2.add(results3, 5, 18);
		grid2.add(temp, 3, 35);
		
	}
	
	public static String createFullAccountString(Map<String, String> info) {
		StringBuilder secondLine = new StringBuilder("");
		
		for (Map.Entry<String, String> obj : info.entrySet()) {
			String key = obj.getKey();
			String value = info.get(key);
			secondLine = secondLine.append(createAccountItem(key, value));
		}
		
		return secondLine.toString().substring(1);
	}
	
	public static String createAccountItem(String key, String value) {
		if(key.equals("pwd")) {
			return "," + key + "," + encryption(value, "encrypt");
		}
		else {
		   return "," + key + "," + value;
		}
	}
	
	public void addNewAccount(String username, Map<String, String> info) {
		StringBuilder secondLine = new StringBuilder(createFullAccountString(info));
		
		try
		{
		    FileWriter fw = new FileWriter("./src/main/java/logic/accounts.txt",true); //the true will append the new data
		    fw.write("\n" + username + "\n" + secondLine);//appends the string to the file
		    fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String encryption(String input, String type) {
		StringBuilder crypted = new StringBuilder("");
		int offset;
		int newAsci;
		
		if(type.equals("encrypt")) {
			offset = 5;
		}
		else {
			offset = -5;
		}
		
		for(int i = 0; i < input.length(); i++) {
			newAsci = ((int) input.charAt(i)) + offset;
			if(newAsci > 126) {
				newAsci = (newAsci % 126) + 33;
			}
			crypted = crypted.append((char) (newAsci));
		}
		
		return crypted.toString();
	}
	
	public static void parseAccounts() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./src/main/java/logic/accounts.txt"));
		    String line = null;
		    String username = null;

		    while ((line = br.readLine())!= null) {
		    	if (line.contains(",")) {
		    		accounts.put(username, parseLine(line));
		    	}
		    	else {
		    		username = line;
		    	}
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			if (br != null) br.close();
		}
	}
	
	public static Map<String, String> parseLine(String line) {
	    Map<String, String> temp = null;
    	String[] splitty = line.split(",");
    	
    	if(splitty.length % 2 != 0) return temp;
    	temp = parseAccountInfo(splitty);
    	return temp;
	}
	
	public static Map<String, String> parseAccountInfo(String[] splitty) {
		Map<String, String> temp = new HashMap<String, String>();
		
    	for(int i = 0; i < splitty.length; i += 2) {
    		if(splitty[i].equals("pwd")) {
    			temp.put(splitty[i], encryption(splitty[i+1],"decrypt"));
    		}
    		else {
    		   temp.put(splitty[i], splitty[i+1]);
    		}
    	}
    	return temp;
	}
	
	public static void loadResults() {
		BufferedReader br = null;
		
		if(currAccount.equals("")) {
			return;
		}
		if(updated == 1) {
			return;
		}
		
		try {
			br = new BufferedReader(new FileReader("./src/main/java/logic/results.txt"));
		    String line = null;

		    line = br.readLine();
		    if(line == null)
		    	return;
		    
            String[] ssplit = line.split(",");

		    Label one = (Label) ((GridPane) ((BorderPane) subPage.getChildren().get(0)).getCenter()).getChildren().get(6);
		    one.setText(ssplit[0].split("\\.")[0]);
		    Label two = (Label) ((GridPane) ((BorderPane) subPage.getChildren().get(0)).getCenter()).getChildren().get(7);
		    two.setText(ssplit[1].split("\\.")[0]);
		    Label three = (Label) ((GridPane) ((BorderPane) subPage.getChildren().get(0)).getCenter()).getChildren().get(8);
		    three.setText(ssplit[2].split("\\.")[0]);
		    updated = 1;
		    
		    br.close();
		    
            File f = new File("./src/main/java/logic/results.txt");
            f.delete();
		    
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
		finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
		}
		
	}
	
}
