package naprapat.controllers;

import naprapat.entities.Menu;
import taco.Controller;

public class CreateContentController implements Controller<Integer> {

	public Integer execute() {
		
		createMenu();
		
		return 0;
	}
	
	private void createMenu(){
		Menu kontakt = new Menu();
		kontakt.setContentText("naprapat test");
		kontakt.setMenuKey("kontakt");
		kontakt.insert();
		
		Menu naprapati = new Menu();
		naprapati.setContentText("naprapati test");
		naprapati.setMenuKey("naprapati");
		naprapati.insert();
		
		Menu behandlning = new Menu();
		behandlning.setContentText("behandlning test");
		behandlning.setMenuKey("behandlning");
		behandlning.insert();
		
		Menu foretag = new Menu();
		foretag.setContentText("foretag test");
		foretag.setMenuKey("foretag");
		foretag.insert();
		
		Menu priser = new Menu();
		priser.setContentText("priser test");
		priser.setMenuKey("priser");
		priser.insert();
	}

}
