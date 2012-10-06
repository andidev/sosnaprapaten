package naprapat.queries;

import naprapat.queries.GenericQuery;

import naprapat.entities.Menu;

public class MenuQuery extends GenericQuery<Menu> {
	
	private static String ID = "id";
	private static String MENU_KEY = "menuKey";
	
	public MenuQuery filterAllItemsSortedById(){
		query.order(ID);
		
		return this;
	}
	
	public MenuQuery filterByMenuKey(String key){
		query.filter(MENU_KEY, key);
		
		return this;
	}
	
	
	

}
