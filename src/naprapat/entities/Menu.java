package naprapat.entities;

import java.util.List;

import burrito.annotations.BBCode;
import burrito.annotations.Displayable;

import naprapat.queries.GlobalSettingsQuery;
import naprapat.queries.MenuQuery;


import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;
import lombok.Getter;
import lombok.Setter;

public class Menu extends Model{

	@Id(Generator.AUTO_INCREMENT)
	@Getter
	private Long id;
	
	@Displayable
	private @Getter @Setter String menuKey;
	
	@Getter @Setter
	private String text;
	
	@Displayable
	@BBCode
	@Getter @Setter
	private String contentText;
	
	 static Query<Menu> all() {
	        return Model.all(Menu.class);
	  }
	 
	  public static List<Menu> findAllItemsSortedById() {
	        return all().fetch();
	  }
	 
	  
		public static Menu findOrCreate() {
			Menu settings = new MenuQuery().get();
			if (settings == null) {
				settings = new Menu();
				settings.insert();
			}
			return settings;
		}

		public static Menu findByKey(String menuKey) {
			return new MenuQuery().filterByMenuKey(menuKey).get();
		}
}
