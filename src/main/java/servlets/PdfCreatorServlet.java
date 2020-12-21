package servlets;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Book;
import dao.BookList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PdfCreatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document doc = new Document();
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(doc, baos);
            doc.open();

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {3f, 3f, 1f};
            table.setWidths(columnWidths);

           BookList bookList = new BookList();
            List<Book> booksList = bookList.listBooks();

            String fontName = "/fonts/Autoproject.ttf";
            BaseFont bf = BaseFont.createFont(fontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font f = new Font(bf, 12);

            for (Book s: booksList) {

                Paragraph paragraph1 = new Paragraph(s.getName(), f);
                PdfPCell cell1 = new PdfPCell(paragraph1);
                cell1.setBorderColor(BaseColor.BLACK);
                cell1.setPaddingLeft(2);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph2 = new Paragraph(s.getContent(), f);
                PdfPCell cell2 = new PdfPCell(paragraph2);
                cell1.setBorderColor(BaseColor.BLACK);
                cell2.setPaddingLeft(2);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph3 = new Paragraph(String.valueOf(s.getPageCount()), f);
                PdfPCell cell3 = new PdfPCell(paragraph3);
                cell1.setBorderColor(BaseColor.BLACK);
                cell3.setPaddingLeft(2);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph4 = new Paragraph(String.valueOf(s.getIsbn()), f);
                PdfPCell cell4 = new PdfPCell(paragraph4);
                cell1.setBorderColor(BaseColor.BLACK);
                cell4.setPaddingLeft(2);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph5 = new Paragraph(s.getGenre(), f);
                PdfPCell cell5 = new PdfPCell(paragraph5);
                cell1.setBorderColor(BaseColor.BLACK);
                cell5.setPaddingLeft(2);
                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph6 = new Paragraph(s.getAuthor(), f);
                PdfPCell cell6 = new PdfPCell(paragraph6);
                cell1.setBorderColor(BaseColor.BLACK);
                cell6.setPaddingLeft(2);
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph7 = new Paragraph(String.valueOf(s.getPublishDate()), f);
                PdfPCell cell7 = new PdfPCell(paragraph7);
                cell1.setBorderColor(BaseColor.BLACK);
                cell7.setPaddingLeft(2);
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph8 = new Paragraph(s.getPublisher(), f);
                PdfPCell cell8 = new PdfPCell(paragraph8);
                cell1.setBorderColor(BaseColor.BLACK);
                cell8.setPaddingLeft(2);
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);

                Paragraph paragraph9 = new Paragraph(s.getImage(), f);
                PdfPCell cell9 = new PdfPCell(paragraph9);
                cell1.setBorderColor(BaseColor.BLACK);
                cell9.setPaddingLeft(2);
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
            }

            doc.add(table);
            doc.close();
            pdfWriter.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        resp.setHeader("Expires", "0");
        resp.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        resp.setHeader("Pragma", "public");
        resp.setContentType("application/pdf");
        resp.setContentLength(baos.size());
        OutputStream os = resp.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();

    }
}
