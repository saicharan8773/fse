package com.document.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create a Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        // Create a PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        // Create an Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
