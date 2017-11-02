/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectjava;

/**
 *
 * @author Deemantha
 */
public class Console {
        private String consoleId = new String();
	private String company = new String();
	private String name = new String();
	private String gameType = new String();
	private int year;
	private double price;
	private int gameLibrary;

	public Console(String consoleId) {
	this.consoleId = consoleId;
	}

	public String getConsole (){
	return this.consoleId;
	}

	public void setCompany(String company){
	this.company = company;
	}

	public String getCompany(){
	return this.company;
	}

	public void setName(String name){
	this.name = name;
	}

	public String getName(){
	return this.name;
	}

	public void setGameType(String gameType){
	this.gameType = gameType;
	}

	public String getGameType(){
	return this.gameType;
	}

	public void setYear(int year){
	this.year = year;
	}
	
	public int getYear(){
	return this.year;
	}

	public void setPrice(double price){
	this.price = price;
	}

	public double getPrice(){
	return this.price;
	}

	public void setGameLibrary(int gameLibrary){
	this.gameLibrary = gameLibrary;
	}

	public int getGameLibrary(){
	return this.gameLibrary;
	}
}

