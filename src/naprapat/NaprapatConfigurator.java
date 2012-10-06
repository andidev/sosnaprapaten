package naprapat;


import naprapat.entities.Menu;
import burrito.BroadcastSettings;

public class NaprapatConfigurator extends burrito.Configurator{

	@Override
	protected BroadcastSettings configureBroadcastSettings() {
		//same as for all other kanal 5/9 websites 
		return new BroadcastSettings("kanal5feeds.appspot.com", "aertuidfhgjhuizsdffuafhiuasfhfuhsdfuhiasudhf");
	}

	@Override
	protected String configureSiteIdentifier() {
		return "naprapat";
	}

	@Override
	protected void init() {
		addCrudable(Menu.class);
//		addCrudable(FikaList.class);
//		addCrudable(Video.class);
//		addCrudable(VideoStream.class);
//		addCrudable(Program.class);
	}


}
