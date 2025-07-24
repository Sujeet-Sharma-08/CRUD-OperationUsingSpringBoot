package com.crud.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.crud.Entity.CrudEntity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {

    public static ByteArrayInputStream bookingTicketPdf(CrudEntity entity) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph title = new Paragraph("🎟 Movie Ticket", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Empty line

            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            document.add(new Paragraph("Booking ID: " + entity.getId(), contentFont));
            document.add(new Paragraph("User Name: " + entity.getName(), contentFont));
            document.add(new Paragraph("Movie Name: " + entity.getMovieName(), contentFont));
            document.add(new Paragraph("Movie Date: " + entity.getMovieDate(), contentFont));
            document.add(new Paragraph("Movie Time: " + entity.getMovieTime(), contentFont));
            document.add(new Paragraph("Theater: " + entity.getTheater(), contentFont));
            document.add(new Paragraph("Additional Options: " + entity.getAdditionalOptions(), contentFont));
            document.add(new Paragraph("Payment Type: " + entity.getPaymentType(), contentFont));

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
