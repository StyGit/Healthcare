package com.app.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
	private IDocumentService service;

	// 1.show upload page
	@RequestMapping("/show")
	public String show(ModelMap map) {
		List<Object[]> docs = service.getDocumentNameAndId();
		map.addAttribute("document", new Document());
		map.addAttribute("docs", docs);
		return "Documents";
	}

	// 2.upload file
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam MultipartFile file, ModelMap map) throws IOException {
		if (file != null) {
			Document doc = new Document();
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			int fileId = service.saveDocument(doc);
			List<Object[]> docs = service.getDocumentNameAndId();
			map.addAttribute("docs", docs);
			map.addAttribute("message", "Uploaded '" + fileId + "' Successfully");
			// claer data
			map.addAttribute("document", new Document());
		}
		return "Documents";
	}

	// 3.Download file
	@RequestMapping("/download")
	public void fileDownload(@RequestParam("docId") Integer docId, HttpServletResponse res) {
		// read documents from db using document Id

		Document doc = service.getOneDocumentById(docId);

		// set response header
		res.setHeader("Content-Disposition", "attachment;filename=" + doc.getFileName());

		// copy body
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// class
