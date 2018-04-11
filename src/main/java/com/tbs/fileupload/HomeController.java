package com.tbs.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("home()==========");
		
		model.addAttribute("fileuploadFlag", "n");
		
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(Model model, final MultipartHttpServletRequest multiRequest) {
		logger.info("fileUpload()==========");
		
		try {
			FileMngUtil.uploadFiles(multiRequest, true);
			model.addAttribute("fileuploadFlag", "y");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
}
