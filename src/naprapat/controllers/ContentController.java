package naprapat.controllers;

import burrito.util.BBCodeCreator;
import lombok.Getter;
import lombok.Setter;
import naprapat.entities.Menu;
import taco.Controller;

public class ContentController implements Controller<Menu> {

	private @Getter @Setter String key;
	
	public Menu execute() {
		
		Menu menu = Menu.findByKey(key);
		
		if(menu != null) {
			menu.setContentText(BBCodeCreator.generateHTML(menu.getContentText()));
		}
		
		return menu;
	}

}
