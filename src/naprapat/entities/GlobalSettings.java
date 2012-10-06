package naprapat.entities;

import naprapat.queries.GlobalSettingsQuery;
import lombok.Getter;
import siena.Generator;
import siena.Id;
import siena.Model;

public class GlobalSettings extends Model {
	@Id(Generator.AUTO_INCREMENT)
	private @Getter Long id;

	
	public static GlobalSettings findOrCreate() {
		GlobalSettings settings = new GlobalSettingsQuery().get();
		if (settings == null) {
			settings = new GlobalSettings();
			settings.insert();
		}
		return settings;
	}
}
