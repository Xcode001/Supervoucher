package com.geekbounty.engineeringinvoice;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geekbounty.engineeringinvoice.dialog.TitleDialog;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StructruralCarcassingActivity extends AppCompatActivity implements TitleDialog.TitleDialogListener{

    private static final String TAG = StructruralCarcassingActivity.class.getSimpleName() ;
    private static final int PERMISSION_REQUEST_CODE = 100;
    EditText rafter75_length_et, rafter75_rate_et,kingpost75_length_et,kingpost75_rate_et,tieBeam_length,tieBeam_rate,wallPlate_length, wallPlate_rate, struts_length,
            struts_rate, purlins_length,purlins_rate,noggings_length,noggings_rate,fasciaBoard_length,fasciaBoard_rate;
    int _rafter75_length_et, _rafter75_rate_et, _kingpost75_length_et, _kingpost75_rate_et, _tieBeam_length, _tieBeam_rate, _wallPlate_length, _wallPlate_rate, _struts_length,
            _struts_rate, _purlins_length, _purlins_rate, _noggings_length, _noggings_rate, _fasciaBoard_length, _fasciaBoard_rate;
    TextView structural_carcassing_title;
    String structuralCarcassingTitle;
    int total_amount,_rafter75_amount,_kingpost75_amount,_tieBeam_amount, _wallPlate_amount, _struts_amount, _purlins_amount, _noggings_amount, _fasciaBoard_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structrural_carcassing);
        structural_carcassing_title = findViewById(R.id.structural_carcassing_title);
        rafter75_length_et = findViewById(R.id.rafter75_length_et);
        rafter75_rate_et = findViewById(R.id.rafter75_rate_et);
        kingpost75_length_et  = findViewById(R.id.kingpost75_length_et);
        kingpost75_rate_et = findViewById(R.id.kingpost75_rate_et);
        tieBeam_length  = findViewById(R.id.tieBeam_length);
        tieBeam_rate  = findViewById(R.id.tieBeam_rate);
        wallPlate_length  = findViewById(R.id.wallPlate_length);
        wallPlate_rate  = findViewById(R.id.wallPlate_rate);
        struts_length  = findViewById(R.id.struts_length);
        struts_rate  = findViewById(R.id.struts_rate);
        purlins_length  = findViewById(R.id.purlins_length );
        purlins_rate  = findViewById(R.id.purlins_rate);
        noggings_length  = findViewById(R.id.noggings_length );
        noggings_rate  = findViewById(R.id.noggings_rate);
        fasciaBoard_length  = findViewById(R.id.fasciaBoard_length);
        fasciaBoard_rate  = findViewById(R.id.fasciaBoard_rate);

    }

    //Generates the pdf Document
    public void createPdf() throws IOException {
        Document document = new Document();   //Creates a Document object
        String outputPath = Environment.getExternalStorageDirectory()+"/"+ structuralCarcassingTitle+ ".pdf"; //Specify the path where the document will be stored

        try {
            if(Build.VERSION.SDK_INT >= 23){
                if(checkPermission()){
                    Log.v(TAG, "Permission is Granted");
                    PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
                    document.open(); //Open to write
                    setDoc(document);
                    /***
                     * Variables for further use....
                     */
                    BaseColor mColorAccent = new BaseColor(69, 69, 69); //Alpha is not added
                    BaseColor mColorAccent2 = new BaseColor(0, 0, 0);
                    float mHeadingFontSize = 16.0f;
                    float mValueFontSize = 18.0f;
                    /**
                     * How to USE FONT....
                     */
                    BaseFont baseFont = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);


                    // LINE SEPARATOR
                    LineSeparator lineSeparator = new LineSeparator();
                    lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

                    // Title Details...
                    // Adding Title....
                    Font mTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
                    Chunk mTitleChunk = new Chunk("NRF-FUT ENERGY-EFFICIENT BUILDING RESEARCH", mTitleFont); // Creating Chunk
                    Paragraph mTitleParagraph = new Paragraph(mTitleChunk);  // Creating Paragraph to add...
                    mTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading

                    Font mSubTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.DARK_GRAY);
                    Chunk mSubTitleChunk = new Chunk("PROPOSED DETACHED 2 - BEDROOM BUNGALOW\n\n", mSubTitleFont); // Creating Chunk
                    Paragraph mSubTitleParagraph = new Paragraph(mSubTitleChunk);  // Creating Paragraph to add...
                    mSubTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading


                    document.add(mTitleParagraph);  // Finally Adding Title chunk
                    document.add(new Paragraph(""));
                    document.add(mSubTitleParagraph);//Adding subtitle paragraph

                    // Fields of Order Details...
                    // Adding Chunks for Title and value
                    Font mOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mOrderIdChunk = new Chunk("ELEMENT 2: ROOF\n\n", mOrderIdFont);
                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                    document.add(mOrderIdParagraph);

                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk = new Chunk("G. STRUCTURAL CARCASSING\n" +
                            "G20.CARPENTRY/TIMBER FRAMING/FIRST FIXING\n\n", mSubOrderIdFont);
                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                    document.add(mSubOrderIdParagraph);

                    Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk2 = new Chunk("Sawn Hardwood: Treated with approved Wood Preservative\n" +
                            "Roof Member\n", mSubOrderIdFont2);
                    Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
                    document.add(mSubOrderIdParagraph2);

                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                    Paragraph listParagraph = new Paragraph(chunk);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l1 = new Chunk("A.  75x150mm Rafter                                       "+_rafter75_length_et+"                 Sq.M      "+ _rafter75_rate_et+"                 " + _rafter75_amount+"", listFont);
                    Paragraph l1Paragraph = new Paragraph(l1);

                    Chunk l12 = new Chunk("B. 75 x 150mm Kingpost                                                "+_kingpost75_length_et+"              Lin.M          "+ _kingpost75_rate_et+"       "+ _kingpost75_amount+"", listFont);
                    Paragraph l1Paragraph2 = new Paragraph(l12);

                    Chunk l13 = new Chunk("C. 50x150mm tie Beam                                                     "+_tieBeam_length+"              Lin.M          "+_tieBeam_rate+"       "+_tieBeam_amount +"", listFont);
                    Paragraph l1Paragraph3 = new Paragraph(l13);

                    Chunk l14 = new Chunk("D.  75 x 100mm Wall plate                                        "+_wallPlate_length+"              Lin.M          "+_wallPlate_rate+"       "+_wallPlate_amount +"", listFont);
                    Paragraph l1Paragraph4 = new Paragraph(l14);

                    Chunk l15 = new Chunk("E.  50 x 100mm Struts                                       "+ _struts_length+"                 Lin.M     "+ _struts_rate+"                 "+ _struts_amount+"", listFont);
                    Paragraph l1Paragraph5 = new Paragraph(l15);

                    Chunk l16 = new Chunk("F. 50 x 100mm purlins                                                "+_purlins_length+"              Lin.M          "+ _purlins_rate+"       "+ _purlins_amount+"", listFont);
                    Paragraph l1Paragraph6 = new Paragraph(l16);

                    Chunk l17 = new Chunk("G. 50 x 50mm Noggings                                               "+ _noggings_length+"              Lin.M          "+ _noggings_rate+"       "+_noggings_amount +"", listFont);
                    Paragraph l1Paragraph7 = new Paragraph(l17);

                    Chunk l18 = new Chunk("H. 25 x 300mm Fascia Board                                      "+_fasciaBoard_length+"              Lin.M          "+_fasciaBoard_rate+"       "+_fasciaBoard_amount +"", listFont);
                    Paragraph l1Paragraph8 = new Paragraph(l18);


                    Chunk l6 = new Chunk("STRUCTURAL CARCASSING TIMBER TO SUMMARY                                        "+total_amount+"", listFont2);
                    Paragraph l6Paragraph = new Paragraph(l6);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    document.add(new Paragraph(""));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Paragraph(""));
                    document.add(listParagraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph2);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph3);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph4);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph5);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph6);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph7);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph8);


                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(l6Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Chunk(lineSeparator));
                    //  document.add(list);

                    document.close();

                    Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
                }else{
                    requestPermission();//Code for permission
                }

            } else {
                Log.v(TAG, "Permission is Granted");
                //TODO: later
                Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Document Setting
    private void setDoc(Document document) {
        document.setPageSize(PageSize.A4);
        document.addCreationDate();
        document.addAuthor("Emmanuel");
        document.addCreator("Emmanuel");
    }
    //
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(StructruralCarcassingActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    //
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(StructruralCarcassingActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(StructruralCarcassingActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(StructruralCarcassingActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }

    //    Metadata Can be viewed in Adobe Reader under File -> Properties
    private static void addMetaData(Document document){
        document.addTitle("Civil Engineering Project");
        document.addSubject("on Android Environment");
        document.addSubject("Java, PDF, iText");
        document.addCreator("Emmanuel");
        document.addCreationDate();
    }
    //
    //Add Empty line(s)
    private static void addEmptyLine(Paragraph paragraph, int number){
        for(int i=0; i < number; i++){
            paragraph.add(new Paragraph(" "));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle item selection
        switch (item.getItemId()){
            case R.id.result:
                //Show dialog
                Toast.makeText(getApplicationContext(), "Result", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add_title:
                showDialog();
                return true;
            case R.id.generate_invoice:
                structuralCarcassingTitle = structural_carcassing_title.getText().toString().trim();
                if(structuralCarcassingTitle.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Input a Title for the Element", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        getValues();
                        createPdf();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getValues() {
        try {
            _rafter75_length_et = Integer.parseInt(rafter75_length_et.getText().toString().trim());
            _rafter75_rate_et = Integer.parseInt(rafter75_rate_et.getText().toString().trim());
            _rafter75_amount = _rafter75_length_et * _rafter75_rate_et;

            _kingpost75_length_et = Integer.parseInt(kingpost75_length_et.getText().toString().trim());
            _kingpost75_rate_et= Integer.parseInt(kingpost75_rate_et.getText().toString().trim());
            _kingpost75_amount = _kingpost75_length_et * _kingpost75_rate_et;

            _tieBeam_length = Integer.parseInt(tieBeam_length.getText().toString().trim());
            _tieBeam_rate = Integer.parseInt(tieBeam_rate.getText().toString().trim());
            _tieBeam_amount = _tieBeam_length *_tieBeam_rate;

            _wallPlate_length = Integer.parseInt(wallPlate_length.getText().toString().trim());
            _wallPlate_rate = Integer.parseInt(wallPlate_rate.getText().toString().trim());
            _wallPlate_amount = _wallPlate_length * _wallPlate_rate;

            _struts_length = Integer.parseInt(struts_length.getText().toString().trim());
            _struts_rate = Integer.parseInt(struts_rate.getText().toString().trim());
            _struts_amount = _struts_length * _struts_rate;

            _purlins_length = Integer.parseInt(purlins_length.getText().toString().trim());
            _purlins_rate = Integer.parseInt(purlins_rate.getText().toString().trim());
            _purlins_amount = _purlins_length * _purlins_rate;

            _noggings_length = Integer.parseInt(noggings_length.getText().toString().trim());
            _noggings_rate = Integer.parseInt(noggings_rate.getText().toString().trim());
            _noggings_amount = _noggings_length * _noggings_rate;

            _fasciaBoard_length = Integer.parseInt( fasciaBoard_length.getText().toString().trim());
            _fasciaBoard_rate = Integer.parseInt(fasciaBoard_rate.getText().toString().trim());
            _fasciaBoard_amount = _fasciaBoard_length * _fasciaBoard_rate;

            total_amount = _rafter75_amount + _kingpost75_amount + _tieBeam_amount + _wallPlate_amount +  _struts_amount +  _purlins_amount + _noggings_amount + _fasciaBoard_amount;
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "All input field must not be empty", Toast.LENGTH_SHORT).show();
        }

    }

    public void showDialog(){
        TitleDialog electricalDialog = new TitleDialog();
        electricalDialog.show(getSupportFragmentManager(), "Floor finishes Dialog");
    }

    @Override
    public void applyTitle(String title) {
        structural_carcassing_title.setText(title);
    }
}
