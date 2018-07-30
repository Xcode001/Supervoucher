//package com.geekbounty.engineeringinvoice;
//
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Environment;
//import android.support.annotation.IntegerRes;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.inputmethod.EditorInfo;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.itextpdf.text.Anchor;
//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chapter;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.List;
//import com.itextpdf.text.ListItem;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Section;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//public class GroundWork extends AppCompatActivity {
//
////    private static final int PERMISSION_REQUEST_CODE = 1;
////
////    EditText topsoilLength, topsoilWidth, topSoilRate;
////    TextView topsoilArea;
////    Button generateGroundWorkReport;
////
////    //    Fonts
////    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
////    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
////    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
////    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
////    private static final String TAG = "GroundWork";
////
////    private int topsoilQty = 115;
////    private int topsoilRate = 120;
////    private int topsoilAmount = topsoilQty * topsoilRate;
////    private String squM_unit = "Sq.M";
////    private String cuM_unit = "Cu.M";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ground_work);
////        getSupportActionBar().hide();
////
////        topsoilLength = (EditText) findViewById(R.id.topsoil_length_et);
////        topsoilWidth = (EditText) findViewById(R.id.topsoil_width_et);
////        topSoilRate = (EditText)findViewById(R.id.rate_et);
////        generateGroundWorkReport = (Button)findViewById(R.id.groundwork_generate);
////
////
////        generateGroundWorkReport.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                try {
////
////                    //Gets the User Input
////                    final int topsoilLength_num = Integer.parseInt(topsoilLength.getText().toString().trim());
////                    final int topsoilWidth_num = Integer.parseInt(topsoilWidth.getText().toString().trim());
////                    final int topsoilRate_num = Integer.parseInt(topSoilRate.getText().toString().trim());
////
////
////                    createPdf(topsoilLength_num, topsoilWidth_num, topsoilRate_num);
////                    Toast.makeText(getApplicationContext(), "PDF File Created", Toast.LENGTH_SHORT).show();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
//
//        /*if(getTopsoilLength.length() >= 1 && getTopsoilWidth.length() >= 1){
//            //convert to numbers and sum the numbers together
//            int topsoilLength_num = Integer.parseInt(getTopsoilLength);
//            int topsoilWidth_num = Integer.parseInt(getTopsoilWidth);
//            int sum = topsoilLength_num + topsoilWidth_num;
//        }*/
//
//    }
//
//
////    public void createPdf(int tpLength, int tpBreadth, int tprate ) throws IOException {
////        Document document = new Document();   //Creates a Document object
////        String outputPath = Environment.getExternalStorageDirectory()+"/newSample44.pdf"; //Specify the path where the document will be stored
////
////        try {
////            if(Build.VERSION.SDK_INT >= 23){
////                if(checkPermission()){
////                    Log.v(TAG, "Permission is Granted");
////                    PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
////                    document.open(); //Open to write
////                    setDoc(document);
////                    /***
////                     * Variables for further use....
////                     */
////                    BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
////                    float mHeadingFontSize = 16.0f;
////                    float mValueFontSize = 20.0f;
////                    /**
////                     * How to USE FONT....
////                     */
////                    BaseFont baseFont = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);
////
////
////                    // LINE SEPARATOR
////                    LineSeparator lineSeparator = new LineSeparator();
////                    lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));
////
////                    // Title Details...
////                    // Adding Title....
////                    Font mTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.GREEN);
////                    Chunk mTitleChunk = new Chunk("NRF-FUT ENERGY-EFFICIENT BUILDING RESEARCH", mTitleFont); // Creating Chunk
////                    Paragraph mTitleParagraph = new Paragraph(mTitleChunk);  // Creating Paragraph to add...
////                    mTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
////
////                    Font mSubTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.GREEN);
////                    Chunk mSubTitleChunk = new Chunk("PROPOSED DETACHED 2 - BEDROOM BUNGALOW", mSubTitleFont); // Creating Chunk
////                    Paragraph mSubTitleParagraph = new Paragraph(mSubTitleChunk);  // Creating Paragraph to add...
////                    mSubTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
////
////
////                    document.add(mTitleParagraph);  // Finally Adding Title chunk
////                    document.add(new Paragraph(""));
////                    document.add(mSubTitleParagraph);//Adding subtitle paragraph
////
////                    // Fields of Order Details...
////                    // Adding Chunks for Title and value
////                    Font mOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
////                    Chunk mOrderIdChunk = new Chunk("ELEMENT 1: GROUNDWORK:", mOrderIdFont);
////                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
////                    document.add(mOrderIdParagraph);
////
////                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
////                    Chunk mSubOrderIdChunk = new Chunk("D20 Excavating and Filling", mSubOrderIdFont);
////                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
////                    document.add(mSubOrderIdParagraph);
////
////                    Font excavatingFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
////                    Chunk excavatingChunk = new Chunk("Excavating", excavatingFont);
////                    Paragraph excavatingParagraph = new Paragraph(excavatingChunk);
////                    document.add(excavatingParagraph);
////
////                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
////                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
////                    Paragraph listParagraph = new Paragraph(chunk);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l1 = new Chunk("A. Top Soil for Preservation                    115              Sq.M          "+tprate+"           "+ (tpLength * tpBreadth *tprate), listFont);
////                    Paragraph l1Paragraph = new Paragraph(l1);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l2 = new Chunk("B. Trenches from stripped level                 115              Sq.M          120           13800", listFont);
////                    Paragraph l2Paragraph = new Paragraph(l2);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l3 = new Chunk("C. Pits from Stripped level                     115              Sq.M          120           13800", listFont);
////                    Paragraph l3Paragraph = new Paragraph(l3);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l4 = new Chunk("Disposal", listFont);
////                    Paragraph l4Paragraph = new Paragraph(l4);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l5 = new Chunk("D. Excavated Material off-site                  115              Sq.M          120           13800", listFont);
////                    Paragraph l5Paragraph = new Paragraph(l5);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l6 = new Chunk("E. Filling to excavation obtained from on-site  115              Sq.M          120           13800", listFont);
////                    Paragraph l6Paragraph = new Paragraph(l6);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l7 = new Chunk("Filling", listFont);
////                    Paragraph l7Paragraph = new Paragraph(l7);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l8 = new Chunk("F. Filling to excavation obtained off-site      115              Sq.M          120           13800", listFont);
////                    Paragraph l8Paragraph = new Paragraph(l8);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l9 = new Chunk("Hardcore", listFont);
////                    Paragraph l9Paragraph = new Paragraph(l9);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l0 = new Chunk("G. Filling to make up levels obtained off-site  115              Sq.M          120           13800", listFont);
////                    Paragraph l10Paragraph = new Paragraph(l0);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l11 = new Chunk("H. Anti-termite solution to sides and bottom of excavation                  115              Sq.M          120           13800", listFont);
////                    Paragraph l11Paragraph = new Paragraph(l11);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l12 = new Chunk("I. Level and Compact the bottom of excavation to receive concrete                    115              Sq.M          120           13800", listFont);
////                    Paragraph l12Paragraph = new Paragraph(l12);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l13 = new Chunk("In-Situ Concrete ", listFont);
////                    Paragraph l13Paragraph = new Paragraph(l13);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l14 = new Chunk("Plain: Concrete (1:3:6 - all in aggregate", listFont);
////                    Paragraph l14Paragraph = new Paragraph(l14);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l15 = new Chunk("J. Foundation generally                    115              Sq.M          120           13800", listFont);
////                    Paragraph l15Paragraph = new Paragraph(l15);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l16 = new Chunk("K. Beds, poured on laterite earth                    115              Sq.M          120           13800", listFont);
////                    Paragraph l16Paragraph = new Paragraph(l16);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    Chunk l17 = new Chunk("To Collection                                              13800", listFont);
////                    Paragraph l17Paragraph = new Paragraph(l17);
////                    listParagraph.setAlignment(Element.ALIGN_CENTER);
////
////                    document.add(new Paragraph(""));
////                    document.add(new Chunk(lineSeparator));
////                    document.add(new Paragraph(""));
////                    document.add(listParagraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l1Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l2Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l3Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l4Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l5Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l6Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l7Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l8Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l8Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l9Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l10Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l11Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l12Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l13Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l14Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l15Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l16Paragraph);
////                    document.add(new Chunk(lineSeparator));
////                    document.add(l17Paragraph);
////                    //  document.add(list);
////
////                    document.close();
////
////                    List list = new List();
////                    list.setListSymbol("\u2022");
////                    list.setSymbolIndent(12);
////                    list.setNumbered(true);
////
////                    //Add List Item Objects
////                    list.add(new ListItem("  "));
////                    list.add(new ListItem("D20 EXCAVATING AND FILLING" ));
////                    list.add(new ListItem("Excavating"));
////                    list.add(new Paragraph("This is a new Paragraph String"));
////                    list.add(new ListItem("A. Top Soil for Preservation" + topsoilQty + " " +topsoilRate + " " + topsoilAmount));
////                    list.add(new ListItem("B. Trenches from Stripped level"));
////                    list.add(new ListItem("C. Pits from Stripped level"));
////                    list.add(new ListItem("Disposal"));
////                    list.add(new ListItem("D.   Excavated material off site"));
////                    list.add(new ListItem("Selected Excavated Material"));
////                    list.add(new ListItem("E.   Filling to excavations on-site"));
////                    list.add(new ListItem("Filling"));
////                    list.add(new ListItem("F.   Filling to excavation off-site"));
////                    list.add(new ListItem("Hardcore"));
////                    list.add(new ListItem("G.   Filling to make up levels over 250 average thick obtained off site"));
////                    list.add(new ListItem("H.   Apply anti-termite solution to sides and bottom of excavation"));
////                    list.add(new ListItem("I.   Level and Compact the bottom of excavation to receive concrete"));
////                    list.add(new ListItem("     In-Situ Concrete"));
////                    list.add(new ListItem("     Plain: Concrete (1:3:6 - all in aggregate)"));
////                    list.add(new ListItem("J    Foundation generally"));
////                    list.add(new ListItem("K    Beds, poured on laterite earth"));
////                    list.add(new ListItem("To Collection"));
////                    list.add(new ListItem("Reinforced: Concrete Grade 25.5: Developing Minimum"));
////                    list.add(new ListItem("25.5N/mm2 Work Strength in 28 days in:"));
////                    list.add(new ListItem("A Columns Bases 0 Cu.M 0 0.00"));
////                    list.add(new ListItem("B Column Generally 0 Cu.M 0 0.00"));
////                    list.add(new ListItem("E20 Formwork for In Situ Concrete"));
////                    list.add(new ListItem("Formwork: Sawn Formwork to:"));
////                    list.add(new ListItem("C Edge of Bed not exceeding 250 high 45 Lin.M 750 33,750.00"));
////                    list.add(new ListItem("D Isolated Columns Rectangular 0 Sq.M 0 0.00"));
////                    list.add(new ListItem("E30 Reinforcement for In Situ Concrete"));
////                    list.add(new ListItem("Reinforcement: Mild Steel Reinforcement to BS 4449 Grade 250"));
////                    list.add(new ListItem("E Bars 12 mm nominal size 0 Tonne 0 0.00"));
////                    list.add(new ListItem("F Bars 8mm nominal size 0 Tonne 0 0.00"));
////                    list.add(new ListItem("F. Masonry"));
////                    list.add(new ListItem("F10 Brick/Block Walling"));
////                    list.add(new ListItem("Blockwork; Hollow Sandcrete Blockwork in Cement"));
////                    list.add(new ListItem("Mortar(1;6) filled solid with concrete"));
////                    list.add(new ListItem("G Walls 225mm thick 0 Sq.M 0 0.00"));
////                    list.add(new ListItem("H Walls 150mm thick 64 Sq.M 3000 192,000.00"));
////                    list.add(new ListItem("Clear Polytene Sheet Damp Proof Membrane (1000g/m2)"));
////                    list.add(new ListItem("J 0.26mm Damp Proof Membrane laid with lapped joints on"));
////                    list.add(new ListItem("and including 10mm layer of Fine Sand (measured nett)"));
////                    list.add(new ListItem("To Collection 254,500.00"));
////                    list.add(new ListItem("Collection"));
////                    list.add(new ListItem("Page1 755,150.00"));
////                    list.add(new ListItem("Page 2 254,500.00"));
////                    list.add(new ListItem("Substructure to Summary: 1,009,650.00"));
////
////
////                    Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
////                }else{
////                    requestPermission();//Code for permission
////                }
////
////            } else {
////                //Code for API < 23
////                Log.v(TAG, "Permission is Granted");
////                PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
////                document.open();
////                addTitlePage(document);
////                addContent(document);
////                document.close();
////                Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
////            }
////        } catch (DocumentException e) {
////            e.printStackTrace();
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////
////    }
//
//    //Document Setting
////    private void setDoc(Document document) {
////        document.setPageSize(PageSize.A4);
////        document.addCreationDate();
////        document.addAuthor("Emmanuel");
////        document.addCreator("Emmanuel");
////    }
////
////    private boolean checkPermission() {
////        int result = ContextCompat.checkSelfPermission(GroundWork.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
////        if (result == PackageManager.PERMISSION_GRANTED) {
////            return true;
////        } else {
////            return false;
////        }
////    }
////
////    private void requestPermission() {
////
////        if (ActivityCompat.shouldShowRequestPermissionRationale(GroundWork.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
////            Toast.makeText(GroundWork.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
////        } else {
////            ActivityCompat.requestPermissions(GroundWork.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
////        }
////    }
////
////    @Override
////    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
////        switch (requestCode) {
////            case PERMISSION_REQUEST_CODE:
////                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                    Log.e("value", "Permission Granted, Now you can use local drive .");
////                } else {
////                    Log.e("value", "Permission Denied, You cannot use local drive .");
////                }
////                break;
////        }
////    }
////
////    //    Metadata Can be viewed in Adobe Reader under File -> Properties
////    private static void addMetaData(Document document){
////        document.addTitle("My FIrst PDF");
////        document.addSubject("using iText");
////        document.addSubject("Java, PDF, iText");
////        document.addCreator("Musa Musa A.");
////        document.addCreationDate();
////    }
////
////    //    Adds A TItle Page Separately to the PDF file
////    private static void addTitlePage(Document document) throws DocumentException{
////        Paragraph preface = new Paragraph();
////        //We add an Empty line
////        addEmptyLine(preface, 1);
////        //Lets Write a big header
////        preface.add(new Paragraph("Title of the Document", catFont));
////
////        addEmptyLine(preface, 1);
////        //Will create: Report generated by: _name, _date
////        preface.add(new Paragraph(
////                "Report generated by: " +
////                        System.getProperty("user.name")+", "+ new Date(), smallBold));
////
////        addEmptyLine(preface, 3);
////        preface.add(new Paragraph("This document describes something which is very important", smallBold));
////
////        addEmptyLine(preface, 8);
////        preface.add(new Paragraph(new Paragraph(
////                "This document is a preliminary version and not subject to your license agreeement or any other agreement with Musa A.", redFont
////        )));
////        document.add(preface);
////
////        document.newPage(); // starting a new page
////    }
////
////    private static  void addContent(Document document) throws DocumentException{
////        Anchor anchor = new Anchor("First Chapter", catFont);
////        anchor.setName("First Chapter");
////
////        // Second parameter is the number of the chapters
////        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
////
////        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
////        Section subCatPart = catPart.addSection(subPara);
////        subCatPart.add(new Paragraph("Paragraph 1"));
////        subCatPart.add(new Paragraph("Paragraph 2"));
////        subCatPart.add(new Paragraph("Paragraph 3"));
////
////        // add a list
////        createList(subCatPart);
////        Paragraph paragraph = new Paragraph();
////        addEmptyLine(paragraph, 5);
////        subCatPart.add(paragraph);
////
////        // add a table
////        createTable(subCatPart);
////
////        // now add all this to the document
////        document.add(catPart);
////
////        // Next section
////        anchor = new Anchor("Second Chapter", catFont);
////        anchor.setName("Second Chapter");
////
////        // Second parameter is the number of the chapter
////        catPart = new Chapter(new Paragraph(anchor), 1);
////
////        subPara = new Paragraph("Subcategory", subFont);
////        subCatPart = catPart.addSection(subPara);
////        subCatPart.add(new Paragraph("This is a very important message"));
////    }
//
////    private static void createTable(Section subCatPart) throws BadElementException {
////        PdfPTable table = new PdfPTable(3);
////
////        // t.setBorderColor(BaseColor.GRAY);
////        // t.setPadding(4);
////        // t.setSpacing(4);
////        // t.setBorderWidth(1);
////
////        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
////        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
////        table.addCell(c1);
////
////        c1 = new PdfPCell(new Phrase("Table Header 2"));
////        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
////        table.addCell(c1);
////
////        c1 = new PdfPCell(new Phrase("Table Header 3"));
////        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
////        table.addCell(c1);
////        table.setHeaderRows(1);
////
////        table.addCell("1.0");
////        table.addCell("1.1");
////        table.addCell("1.2");
////        table.addCell("2.1");
////        table.addCell("2.2");
////        table.addCell("2.3");
////
////        subCatPart.add(table);
////
////    }
////
////    private static void createList(Section subCatPart) {
////        List list = new List(true, false, 10);
////        list.add(new ListItem("First point"));
////        list.add(new ListItem("Second point"));
////        list.add(new ListItem("Third point"));
////        subCatPart.add(list);
////    }
////
////
////    //Add Empty line(s)
////    private static void addEmptyLine(Paragraph paragraph, int number){
////        for(int i=0; i < number; i++){
////            paragraph.add(new Paragraph(" "));
////        }
////    }
////
////    int area(int a, int b){
////        return a * b;
////    }
//
//}
////