package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Employee;
import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, 
									Object> model, 
									Document document, 
									PdfWriter writer,
									HttpServletRequest request, 
									HttpServletResponse response) 
											throws Exception {
		//download option with file name
		response.addHeader("Content-Disposition", "attachement;filename=Employees.pdf");
		//create Element
		Paragraph p=new Paragraph("Users Details");
		//add to doc
		document.add(p);
		//read data from map
		List<User> users=(List<User>)model.get("users");
		//create table
		PdfPTable table=new PdfPTable(6);
		
		//add Heading columns
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("EMAIL");
		table.addCell("CONTACT");
		table.addCell("PASSWORD");
		table.addCell("ADDRESS");
		//add db data to table
		for(User u:users)
		{
			table.addCell(u.getUserId().toString());
			table.addCell(u.getUserName());
			table.addCell(u.getUserEmail());
			table.addCell(u.getUserContact());
			table.addCell(u.getUserPwd());
			table.addCell(u.getUserAddr());
		}
		//add to doc
		document.add(table);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
	}

}
