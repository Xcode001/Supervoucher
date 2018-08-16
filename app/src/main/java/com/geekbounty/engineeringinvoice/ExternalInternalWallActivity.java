//package com.geekbounty.engineeringinvoice;
//
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Environment;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.geekbounty.engineeringinvoice.dialog.TitleDialog;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExternalInternalWallActivity extends AppCompatActivity implements TitleDialog.TitleDialogListener{
//
//    private static final String TAG = MechanicalServicesActivity.class.getSimpleName() ;
//    private static final int PERMISSION_REQUEST_CODE = 100;
//    EditText lintels_generally_area,lintels_generally_rate,ceiling_painting_area,ceiling_painting_rate,bars_norminal_size_area,
//            bars_norminal_size_rate,walls_230m_area,walls_230m_rate,walls_150mm_area,walls_150mm_rate,rectangular_lintel_area,rectangular_lintel_rate;
//    TextView external_int_wall_Title;
//    String external_internal_wallsTitle;
//    int _lintels_generally_area,_lintels_generally_rate,_ceiling_painting_area,_ceiling_painting_rate,_bars_norminal_size_area,_bars_norminal_size_rate,_walls_230m_area,_walls_230m_rate,_walls_150mm_area,_walls_150mm_rate, total_amount,
//            _rectangular_lintel_area,_rectangular_lintel_rate, _lintels_generally_amount,_rectangular_lintel_amount,_ceiling_painting_amount,_bars_norminal_size_amount,_walls_230m_amount,_walls_150mm_amount;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_external_internal_wall);
//        external_int_wall_Title = findViewById(R.id.external_int_wall_Title);
//        lintels_generally_area = findViewById(R.id.lintels_generally_area);
//        lintels_generally_rate = findViewById(R.id.lintels_generally_rate);
//        rectangular_lintel_area = findViewById(R.id.rectangular_lintel_area);
//        rectangular_lintel_rate = findViewById(R.id.rectangular_lintel_rate);
//        ceiling_painting_area = findViewById(R.id.ceiling_painting_area);
//        ceiling_painting_rate = findViewById(R.id.ceiling_painting_rate);
//        bars_norminal_size_area = findViewById(R.id.bars_norminal_size_area);
//        bars_norminal_size_rate = findViewById(R.id.bars_norminal_size_rate);
//        walls_230m_area = findViewById(R.id.walls_230m_area);
//        walls_230m_rate = findViewById(R.id.walls_230m_rate);
//        walls_150mm_area = findViewById(R.id.walls_150mm_area);
//        walls_150mm_rate = findViewById(R.id.walls_150mm_rate);
//    }
//
//
//    //Generates the pdf Document
//    public void createPdf() throws IOException {
//        Document document = new Document();   //Creates a Document object
//        String outputPath = Environment.getExternalStorageDirectory()+"/"+ external_internal_wallsTitle+ ".pdf"; //Specify the path where the document will be stored
//
//        try {
//            if(Build.VERSION.SDK_INT >= 23){
//                if(checkPermission()){
//                    Log.v(TAG, "Permission is Granted");
//                    PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
//                    document.open(); //Open to write
//                    setDoc(document);
//                    /***
//                     * Variables for further use....
//                     */
//                    BaseColor mColorAccent = new BaseColor(69, 69, 69); //Alpha is not added
//                    BaseColor mColorAccent2 = new BaseColor(0, 0, 0);
//                    float mHeadingFontSize = 16.0f;
//                    float mValueFontSize = 18.0f;
//                    /**
//                     * How to USE FONT....
//                     */
//                    BaseFont baseFont = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);
//
//
//                    // LINE SEPARATOR
//                    LineSeparator lineSeparator = new LineSeparator();
//                    lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));
//
//                    // Title Details...
//                    // Adding Title....
//                    Font mTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
//                    Chunk mTitleChunk = new Chunk("NRF-FUT ENERGY-EFFICIENT BUILDING RESEARCH", mTitleFont); // Creating Chunk
//                    Paragraph mTitleParagraph = new Paragraph(mTitleChunk);  // Creating Paragraph to add...
//                    mTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
//
//                    Font mSubTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.DARK_GRAY);
//                    Chunk mSubTitleChunk = new Chunk("PROPOSED DETACHED 2 - BEDROOM BUNGALOW\n\n", mSubTitleFont); // Creating Chunk
//                    Paragraph mSubTitleParagraph = new Paragraph(mSubTitleChunk);  // Creating Paragraph to add...
//                    mSubTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
//
//
//                    document.add(mTitleParagraph);  // Finally Adding Title chunk
//                    document.add(new Paragraph(""));
//                    document.add(mSubTitleParagraph);//Adding subtitle paragraph
//
//                    // Fields of Order Details...
//                    // Adding Chunks for Title and value
//                    Font mOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                    Chunk mOrderIdChunk = new Chunk("ELEMENT 4: EXTERNAL/INTERNAL WALLS\n\n", mOrderIdFont);
//                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
//                    document.add(mOrderIdParagraph);
//
//                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                    Chunk mSubOrderIdChunk = new Chunk("E: INSITU CONCRETE / LARGE PRECAST CONCRETE\n" +
//                            "E10 IN SITU CONCRETE\n\n", mSubOrderIdFont);
//                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
//                    document.add(mSubOrderIdParagraph);
//
//                    Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                    Chunk mSubOrderIdChunk2 = new Chunk("Reinforced: Concrete Grade 21: Developing Minimum\n" +
//                            "21N/mm2 Work Strength in 28 days\n\n", mSubOrderIdFont2);
//                    Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
//                    document.add(mSubOrderIdParagraph2);
//
//                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                    Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
//                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
//                    Paragraph listParagraph = new Paragraph(chunk);
//                    listParagraph.setAlignment(Element.ALIGN_CENTER);
//
//                    Chunk l1 = new Chunk("A.  Lintels generally                                      "+_roof_covering_area+"                 Sq.M      "+_roof_covering_rate+"                 "+_roof_covering_amount
//                            +"", listFont);
//                    Paragraph l1Paragraph = new Paragraph(l1);
//
//                    Chunk l12 = new Chunk("B. Rectangular lintel                                                  "+_ridge_cap_area+"              Lin.M          "+_ridge_cap_rate+"       "+ _ridge_cap_amount+"", listFont);
//                    Paragraph l1Paragraph2 = new Paragraph(l12);
//
//                    Chunk l13 = new Chunk("C. Bars 8 - 12mm nominal size                                                     "+_valley_area+"              Lin.M          "+_valley_rate+"       "+_valley_amount +"", listFont);
//                    Paragraph l1Paragraph3 = new Paragraph(l13);
//
//                    Chunk l14 = new Chunk("D.  Walls 230mm thick                                         "+_eaves_angle_area+"              Lin.M          "+_eaves_angle_rate+"       "+_eaves_angle_amount +"", listFont);
//                    Paragraph l1Paragraph4 = new Paragraph(l14);
//
//
//                    Chunk l15 = new Chunk("C. Bars 8 - 12mm nominal size                                                     "+_valley_area+"              Lin.M          "+_valley_rate+"       "+_valley_amount +"", listFont);
//                    Paragraph l1Paragraph5 = new Paragraph(l15);
//
//                    Chunk l16 = new Chunk("D.  Walls 230mm thick                                         "+_eaves_angle_area+"              Lin.M          "+_eaves_angle_rate+"       "+_eaves_angle_amount +"", listFont);
//                    Paragraph l1Paragraph6 = new Paragraph(l16);
//
//                    Chunk l6 = new Chunk("External/internal walls to Summary:                                          "+total_amount+"", listFont2);
//                    Paragraph l6Paragraph = new Paragraph(l6);
//                    listParagraph.setAlignment(Element.ALIGN_CENTER);
//
//                    document.add(new Paragraph(""));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Paragraph(""));
//                    document.add(listParagraph);
//                    document.add(new Chunk(lineSeparator));
//                    document.add(l1Paragraph);
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(l1Paragraph2);
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(l1Paragraph3);
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(l1Paragraph4);
//
//
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(l6Paragraph);
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    document.add(new Chunk(lineSeparator));
//                    //  document.add(list);
//
//                    document.close();
//
//                    Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
//                }else{
//                    requestPermission();//Code for permission
//                }
//
//            } else {
//                Log.v(TAG, "Permission is Granted");
//                PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
//                document.open(); //Open to write
//                setDoc(document);
//                /***
//                 * Variables for further use....
//                 */
//                BaseColor mColorAccent = new BaseColor(69, 69, 69); //Alpha is not added
//                BaseColor mColorAccent2 = new BaseColor(0, 0, 0);
//                float mHeadingFontSize = 16.0f;
//                float mValueFontSize = 18.0f;
//                /**
//                 * How to USE FONT....
//                 */
//                BaseFont baseFont = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);
//
//
//                // LINE SEPARATOR
//                LineSeparator lineSeparator = new LineSeparator();
//                lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));
//
//                // Title Details...
//                // Adding Title....
//                Font mTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
//                Chunk mTitleChunk = new Chunk("NRF-FUT ENERGY-EFFICIENT BUILDING RESEARCH", mTitleFont); // Creating Chunk
//                Paragraph mTitleParagraph = new Paragraph(mTitleChunk);  // Creating Paragraph to add...
//                mTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
//
//                Font mSubTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.DARK_GRAY);
//                Chunk mSubTitleChunk = new Chunk("PROPOSED DETACHED 2 - BEDROOM BUNGALOW\n\n", mSubTitleFont); // Creating Chunk
//                Paragraph mSubTitleParagraph = new Paragraph(mSubTitleChunk);  // Creating Paragraph to add...
//                mSubTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading
//
//
//                document.add(mTitleParagraph);  // Finally Adding Title chunk
//                document.add(new Paragraph(""));
//                document.add(mSubTitleParagraph);//Adding subtitle paragraph
//
//                // Fields of Order Details...
//                // Adding Chunks for Title and value
//                Font mOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                Chunk mOrderIdChunk = new Chunk("ELEMENT 3:  CLADDING/COVERING\n\n", mOrderIdFont);
//                Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
//                document.add(mOrderIdParagraph);
//
//                Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                Chunk mSubOrderIdChunk = new Chunk("H.CLADDING/COVERING\n" +
//                        "H72. Aluminium STRIP/SHEET COVERINGS/FLASHING\n\n", mSubOrderIdFont);
//                Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
//                document.add(mSubOrderIdParagraph);
//
//                Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                Chunk mSubOrderIdChunk2 = new Chunk("600 x 600 x 12mm thick Particle Ceiling Board fixed to\n" +
//                        "Hardwood Noggings (Measured separately)\n\n", mSubOrderIdFont2);
//                Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
//                document.add(mSubOrderIdParagraph2);
//
//                Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
//                Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
//                Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
//                Paragraph listParagraph = new Paragraph(chunk);
//                listParagraph.setAlignment(Element.ALIGN_CENTER);
//
//                Chunk l1 = new Chunk("A.  Roof Covering                                "+_roof_covering_area+"                 Sq.M      "+_roof_covering_rate+"                 "+_roof_covering_amount
//                        +"", listFont);
//                Paragraph l1Paragraph = new Paragraph(l1);
//
//                Chunk l12 = new Chunk("B. Ridge Cap                          "+_ridge_cap_area+"              Lin.M          "+_ridge_cap_rate+"       "+ _ridge_cap_amount+"", listFont);
//                Paragraph l1Paragraph2 = new Paragraph(l12);
//
//                Chunk l13 = new Chunk("C. Valley                          "+_valley_area+"              Lin.M          "+_valley_rate+"       "+_valley_amount +"", listFont);
//                Paragraph l1Paragraph3 = new Paragraph(l12);
//
//                Chunk l14 = new Chunk("D.  Eaves Angle                          "+_eaves_angle_area+"              Lin.M          "+_eaves_angle_rate+"       "+_eaves_angle_amount +"", listFont);
//                Paragraph l1Paragraph4 = new Paragraph(l12);
//
//
//                Chunk l6 = new Chunk("CLADDING/COVERING TO SUMMARY                                          "+total_amount+"", listFont2);
//                Paragraph l6Paragraph = new Paragraph(l6);
//                listParagraph.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(new Paragraph(""));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Paragraph(""));
//                document.add(listParagraph);
//                document.add(new Chunk(lineSeparator));
//                document.add(l1Paragraph);
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(l1Paragraph2);
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(l1Paragraph3);
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(l1Paragraph4);
//
//
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(l6Paragraph);
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                document.add(new Chunk(lineSeparator));
//                //  document.add(list);
//
//                document.close();
//
//                Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    //Document Setting
//    private void setDoc(Document document) {
//        document.setPageSize(PageSize.A4);
//        document.addCreationDate();
//        document.addAuthor("Emmanuel");
//        document.addCreator("Emmanuel");
//    }
//    //
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(Cladding_and_Covering_Activity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    //
//    private void requestPermission() {
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(Cladding_and_Covering_Activity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            Toast.makeText(Cladding_and_Covering_Activity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
//        } else {
//            ActivityCompat.requestPermissions(Cladding_and_Covering_Activity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Log.e("value", "Permission Granted, Now you can use local drive .");
//                } else {
//                    Log.e("value", "Permission Denied, You cannot use local drive .");
//                }
//                break;
//        }
//    }
//
//    //    Metadata Can be viewed in Adobe Reader under File -> Properties
//    private static void addMetaData(Document document){
//        document.addTitle("Civil Engineering Project");
//        document.addSubject("on Android Environment");
//        document.addSubject("Java, PDF, iText");
//        document.addCreator("Emmanuel");
//        document.addCreationDate();
//    }
//    //
//    //Add Empty line(s)
//    private static void addEmptyLine(Paragraph paragraph, int number){
//        for(int i=0; i < number; i++){
//            paragraph.add(new Paragraph(" "));
//        }
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //handle item selection
//        switch (item.getItemId()){
//            case R.id.result:
//                //Show dialog
//                Toast.makeText(getApplicationContext(), "Result", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.add_title:
//                showDialog();
//                return true;
//            case R.id.generate_invoice:
//                cladding_coveringTitle = cladding_covering_title.getText().toString().trim();
//                if(cladding_coveringTitle.isEmpty()){
//                    Toast.makeText(getApplicationContext(), "Input a Title for the Element", Toast.LENGTH_SHORT).show();
//                }else {
//                    try {
//                        getValues();
//                        createPdf();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private void getValues() {
//        try {
//
//            _lintels_generally_area = Integer.parseInt(lintels_generally_area.getText().toString().trim());
//            _lintels_generally_rate = Integer.parseInt(lintels_generally_rate.getText().toString().trim());
//            _lintels_generally_amount = _lintels_generally_area * _lintels_generally_rate;
//
//            _rectangular_lintel_area =  Integer.parseInt(rectangular_lintel_area.getText().toString().trim());
//            _rectangular_lintel_rate = Integer.parseInt(rectangular_lintel_rate.getText().toString().trim());
//            _rectangular_lintel_amount = _rectangular_lintel_area * _rectangular_lintel_rate;
//
//
//            _ceiling_painting_area = Integer.parseInt(ceiling_painting_area.getText().toString().trim());
//            _ceiling_painting_rate = Integer.parseInt(ceiling_painting_rate.getText().toString().trim());
//            _ceiling_painting_amount = _ceiling_painting_area * _ceiling_painting_rate;
//
//            _bars_norminal_size_area = Integer.parseInt(bars_norminal_size_area.getText().toString().trim());
//            _bars_norminal_size_rate = Integer.parseInt(bars_norminal_size_rate.getText().toString().trim());
//            _bars_norminal_size_amount =  _bars_norminal_size_area  * _bars_norminal_size_rate;
//
//            _walls_230m_area = Integer.parseInt(walls_230m_area.getText().toString().trim());
//            _walls_230m_rate = Integer.parseInt(walls_230m_rate.getText().toString().trim());
//            _walls_230m_amount = _walls_230m_area * _walls_230m_rate ;
//
//            _walls_150mm_area = Integer.parseInt(walls_150mm_area.getText().toString().trim());
//            _walls_150mm_rate = Integer.parseInt(walls_150mm_rate.getText().toString().trim());
//            _walls_150mm_amount = _walls_150mm_area * _walls_150mm_rate ;
//
//            total_amount = _lintels_generally_amount + _rectangular_lintel_amount + _ceiling_painting_amount + _bars_norminal_size_amount + _walls_230m_amount + _walls_150mm_amount;
//
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), "All input field must not be empty", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    public void showDialog(){
//        TitleDialog electricalDialog = new TitleDialog();
//        electricalDialog.show(getSupportFragmentManager(), "Floor finishes Dialog");
//    }
//
//    @Override
//    public void applyTitle(String title) {
//        external_int_wall_Title.setText(title);
//    }
//
//}
