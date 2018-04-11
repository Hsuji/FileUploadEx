package com.tbs.fileupload;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileMngUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * 첨부파일 업로드 
	 * 
	 * @param multiRequest
	 * @return
	 * @throws Exception
	 */
	public static void uploadFiles(MultipartHttpServletRequest multiRequest, Boolean multiFlag) throws Exception {
		logger.info("uploadFiles()==========");
		
		final Map<String, MultipartFile> files = multiRequest.getFileMap();

		if (!files.isEmpty()) {
			String storePathString = "/fileupload";
			File saveFolder = new File(WebUtil.filePathBlackList(storePathString));
	
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}
	
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			String filePath = "";
	
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
	
				file = entry.getValue();
				String orginFileName = file.getOriginalFilename();
	
				if (!"".equals(orginFileName)) {
					filePath = storePathString + File.separator + orginFileName;
					file.transferTo(new File(WebUtil.filePathBlackList(filePath)));
					logger.info("This is File Info {}", filePath);
				}
			}
		}
	}
}