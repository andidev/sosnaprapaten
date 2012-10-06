package naprapat.utils;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.Cookie;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import com.google.appengine.api.utils.SystemProperty;

@Log
public class Environment {
	
	private static final boolean DEV_MODE = "true".equals(System.getProperty("k5.devMode"));
	
	private static ThreadLocal<Environment> env = new ThreadLocal<Environment>() {
		@Override
		protected Environment initialValue() {
			return new Environment();
		}
		
	};
	
	@Setter @Getter
	private String baseUrl = "http://test.se";
	
	@Setter @Getter
	private String serverName;
	
	@Setter @Getter
	private Cookie authCookie;

	private Environment() {
		//förhindra att man kan skapa egna instanser
	}

	public Environment(boolean yesIKnowWhatIAmDoing) {
	}

	/**
	 * Sätter baseUrl för nuvarande tråd/request
	 * 
	 */
	public static void setBaseUrlForThread(String baseUrl) {
		env.get().setBaseUrl(baseUrl);
	}
	
	public static void setAuthCookieForThread(Cookie cookie) {
		env.get().setAuthCookie(cookie);
	}
	
	public static void setServerNameForThread(String serverName) {
		env.get().setServerName(serverName);
	}
	
	/**
	 * Hämtar en instans av Environment-klassen. Denna instans är unik för nuvarande tråd.
	 * 
	 * @return
	 */
	public static Environment getInstance() {
		return env.get();
	}
	
	

	/**
	 * Returnerar <code>true</code> om du startat din server lokalt med
	 * jvm-flaggan "k5.devMode" (Görs automatiskt om du startar servern via
	 * ant-target "runserver")
	 * 
	 * @return
	 */
	public boolean isDevMode() {
		return DEV_MODE;
	}
	
	public String getPlayerURL() {
		return "/flash/StandardPlayer.swf?cache=" + lastModified("\\flash\\StandardPlayer.swf");
	}
	
	public String getLegacyPlayerURL() {
		return "/flash/BasicPlayer.swf?cache=" + lastModified("\\flash\\BasicPlayer.swf");
	}
	
	
	/**
	 * vi behöver hantera latest och olika versioner av sajten.
	 * @return appspot adressen http://latest.kanal5swe.appsot.com tex
	 */
	public String getAppspotUrl(boolean https) {
		if (isDevMode()) {
			return "http://localhost:8089";
		}
		
		String protokoll = (https) ? "https": "http";
		
		if (this.serverName.contains(".kanal5swe.appspot.com")) {
			return "http://" + this.serverName;
		}
		
		if (this.serverName.contains("appspot")) {
			return protokoll + "://" + this.serverName;
		}
		
		return protokoll + "://kanal5swe.appspot.com";
	}
	
	public String lastModified(String pathFromWar) {
		if (isDevMode()) {
			String userDir = System.getProperty("user.dir");
			File file = new File(userDir + pathFromWar);
			long lastModified = file.lastModified();
			return "" + lastModified;
			
		} else  {
			return SystemProperty.applicationVersion.get();
		}
	}

	/**
	 * Skapar en absolut url, t.ex. http://kanal5.tv/player/102 från en relativ sådan, t.ex. /player/102
	 * 
	 * @param relativeUrl
	 * @return
	 */
	public String createAbsoluteUrl(String relativeUrl) {
		if (!relativeUrl.startsWith("/")) {
			relativeUrl = "/" + relativeUrl;
		}
		return baseUrl + relativeUrl;
	}


	
	public Locale getLocale(){
		return Locale.getDefault(); 
		//System.getProperty("user.language");
	}
	
	public TimeZone getTimeZone(){
		return TimeZone.getDefault();
	}
	
	public String getIPAddress(){
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException("Could not get current IP Address. " + e);
		}
	}



}
