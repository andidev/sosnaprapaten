package naprapat;

import naprapat.controllers.ContentController;
import naprapat.controllers.CreateContentController;
import naprapat.controllers.VoidController;
import burrito.Configurator;
import burrito.controller.AdminController;



public class NaprapatRouter extends taco.Router {

	@Override
	public void init() {
		route("/menu").through(ContentController.class).renderAsJson();
		route("/").through(VoidController.class).renderedBy(publicJsp("index.jsp"));
		route("/admin/setup").through(CreateContentController.class);
		//route("/").through(VoidController.class).renderedBy(publicJsp("test.jsp"));
//		route("/getList").through(FikaListSchemeController.class).renderAsJson();
//		route("/refresh").through(FikaListUpdateController.class).renderedBy(publicJsp("fikaLista.jsp"));
////		
////		route("/admin").through(ApproveVideosController.class).renderedBy("approveVideos.jsp").protect(Configurator.getAdminProtector());
		route("/admin").through(AdminController.class).renderedBy(adminJsp("burritoAdmin.jsp")).protect(Configurator.getAdminProtector());
		route("/admin/burrito").through(AdminController.class).renderedBy(adminJsp("burritoAdmin.jsp")).protect(Configurator.getAdminProtector());
//		route("/admin/create").through(FikaListCreatorController.class).protect(Configurator.getAdminProtector());
//		route("/api").renderedBy("apiSummary.jsp");
//		route("/api/addVideo").through(AddVideoController.class).renderAsJson();
//		route("/api/addWonXml").through(AddWonXmlController.class).renderAsJson();
//		
//		route("/api/addVideo/form").renderedBy("/api/addVideoForm.jsp");
//		route("/api/listVideos").through(ListVideosApiController.class).renderAsJson();
//
//		route("/job/qbrickSync").through(QbrickSyncController.class).renderAsJson();
//		route("/job/devData").through(DevDataController.class).renderAsJson();
//		
//		route("/testJS").renderedBy("test/Videotest.jsp");
	}
	
	private static String adminJsp(String fileName) {
		return jsp("admin", fileName);
	}
	
	private static String publicJsp(String fileName) {
		return jsp("public", fileName);
	}
	
	private static String jsp(String folder, String fileName) {
		return "/WEB-INF/jsp/" + folder + "/" + fileName;
	}
	
}
