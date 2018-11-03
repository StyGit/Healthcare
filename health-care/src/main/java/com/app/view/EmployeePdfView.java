package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeePdfView extends AbstractPdfView {

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
		Paragraph p=new Paragraph("Employees Details");
		//add to doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<Employee> emps=(List<Employee>)model.get("emps");
		//create table
		PdfPTable table=new PdfPTable(6);
		
		//add Heading columns
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("GENDER");
		table.addCell("ADDRESS");
		table.addCell("COUNTRY");
		table.addCell("LANGUAGES");
		//add db data to table
		for(Employee e:emps)
		{
			table.addCell(e.getEmpId().toString());
			table.addCell(e.getEmpName());
			table.addCell(e.getEmpGen());
			table.addCell(e.getEmpAddr());
			table.addCell(e.getEmpCntry());
			table.addCell(e.getEmpLangs().toString());
		}
		//add to doc
		document.add(table);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
	}

}
