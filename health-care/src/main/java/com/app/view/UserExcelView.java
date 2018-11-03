package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// file name change
		response.addHeader("Content-Disposition", "attachement;filename=USERS.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("USERS");
		// create head
		setHead(sheet);
		// read data
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("users");
		// set body
		setBody(sheet, users);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("CONTACT");
		row.createCell(4).setCellValue("PASSWORD");
		row.createCell(5).setCellValue("ADDRESS");
	}

	private void setBody(Sheet sheet, List<User> users) {
		int rowNum = 1;
		for (User u : users) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUserId());
			row.createCell(1).setCellValue(u.getUserName());
			row.createCell(2).setCellValue(u.getUserEmail());
			row.createCell(3).setCellValue(u.getUserContact());
			row.createCell(4).setCellValue(u.getUserPwd());
			row.createCell(5).setCellValue(u.getUserAddr());

		}
	}

}
