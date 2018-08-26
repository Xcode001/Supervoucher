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

public class WindowsDoorsActivity extends AppCompatActivity implements TitleDialog.TitleDialogListener {

    private static final String TAG = WindowsDoorsActivity.class.getSimpleName() ;
    EditText onsite_600_600_number_et,onsite_600_600_rate_et,onsite_900_600_number_et, onsite_900_600_rate_et,
            onsite1200number,onsite1200rate,onsite1500number, onsite1500rate, onsite2400number, onsite2400rate,
            onsite2000number,onsite2000rate, steeldoorsNumber,steeldoorsRate, internaldoor750number,internaldoor750rate,
            internaldoor900number, internaldoor900rate, internaldoor1200number, internaldoor1200rate;
    TextView windows_doors_title;

    int _onsite_600_600_number_et, _onsite_600_600_rate_et, _onsite_900_600_number_et, _onsite_900_600_rate_et,
            _onsite1200number, _onsite1200rate, _onsite1500number, _onsite1500rate, _onsite2400number, _onsite2400rate,
            _onsite2000number, _onsite2000rate, _steeldoorsNumber, _steeldoorsRate, _internaldoor750number, _internaldoor750rate,
            _internaldoor900number, _internaldoor900rate, _internaldoor1200number, _internaldoor1200rate;

    int _onsite_600_600_amount, _onsite_900_600_amount, _onsite1200amount,_onsite1500amount, _onsite2400amount,
            _onsite200amount, _steeldoorsAmount, _internaldoor750Amount, _internaldoor900Amount, _internaldoor1200Amount;

    String _windows_doors_title;
    private int total_amount;
    private static final int PERMISSION_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_doors);
        getSupportActionBar().setTitle("Windows and doors");
        windows_doors_title = findViewById(R.id.win_doors_title);
        onsite_600_600_number_et = findViewById(R.id.onsite_600_600_number_et);
        onsite_600_600_rate_et = findViewById(R.id.onsite_600_600_rate_et);
                onsite_900_600_number_et = findViewById(R.id.onsite_900_600_number_et);
        onsite_900_600_rate_et = findViewById(R.id.onsite_900_600_rate_et);
                onsite1200number = findViewById(R.id.onsite1200number);
        onsite1200rate = findViewById(R.id.onsite1200rate);
                onsite1500number = findViewById(R.id.onsite1500number);
        onsite1500rate = findViewById(R.id.onsite1500rate);
                onsite2400number = findViewById(R.id.onsite2400number);
        onsite2400rate = findViewById(R.id.onsite2400rate);
                onsite2000number = findViewById(R.id.onsite2000number);
        onsite2000rate = findViewById(R.id.onsite2000rate);
                steeldoorsNumber = findViewById(R.id.steeldoorsNumber);
        steeldoorsRate = findViewById(R.id.steeldoorsRate);
                internaldoor750number = findViewById(R.id.internaldoor750number);
        internaldoor750rate = findViewById(R.id.internaldoor750rate);
                internaldoor900number = findViewById(R.id.internaldoor900number);
        internaldoor900rate = findViewById(R.id.internaldoor900rate);
                internaldoor1200number = findViewById(R.id.internaldoor1200number);
        internaldoor1200rate = findViewById(R.id.internaldoor1200rate);
    }



    //Generates the pdf Document
    public void createPdf() throws IOException {
        Document document = new Document();   //Creates a Document object
        String outputPath = Environment.getExternalStorageDirectory()+"/"+ _windows_doors_title+ ".pdf"; //Specify the path where the document will be stored

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
                    Chunk mOrderIdChunk = new Chunk("ELEMENT 5: WINDOWS AND DOORS\n\n", mOrderIdFont);
                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                    document.add(mOrderIdParagraph);

                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk = new Chunk("L. WINDOWS & DOORS\n" +
                            "\n", mSubOrderIdFont);
                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                    document.add(mSubOrderIdParagraph);

                    Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk2 = new Chunk("Bronze anodised Aluminium Sliding Window with accessories\n" +
                            "", mSubOrderIdFont2);
                    Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
                    document.add(mSubOrderIdParagraph2);

                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                    Paragraph listParagraph = new Paragraph(chunk);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l1 = new Chunk("A. 600 x 600 high overall                       "+_onsite_600_600_number_et+"                 Nr.      "+_onsite_600_600_rate_et+"                 "+_onsite_600_600_amount
                            +"", listFont);
                    Paragraph l1Paragraph = new Paragraph(l1);

                    Chunk l12 = new Chunk("B. 900 x 600 high overall                    "+_onsite_900_600_number_et +"              Nr.             "+_onsite_900_600_rate_et +"           "+_onsite_900_600_amount +"", listFont);
                    Paragraph l1Paragraph2 = new Paragraph(l12);

                    Chunk l13 = new Chunk("C.  1200 x 1200 high overall                     "+ _onsite1200number+"              Nr.          "+ _onsite1200rate+"       "+ _onsite1200amount +"", listFont);
                    Paragraph l1Paragraph3 = new Paragraph(l13);

                    Chunk l14 = new Chunk("D. Ditto 1500 x 1200 high overall                "+_onsite1500number+"              Nr.          "+_onsite1500rate+"       "+_onsite1500amount +"", listFont);
                    Paragraph l1Paragraph4 = new Paragraph(l14);

                    Chunk l15 = new Chunk("E. Ditto 2400 x 1200 high overall                "+_onsite2400number+"              Nr.          "+ _onsite2400rate+"       "+_onsite2400amount +"", listFont);
                    Paragraph l1Paragraph5 = new Paragraph(l15);

                    Chunk l16 = new Chunk("F. Ditto 2400 x 600 high overall                 "+_onsite2000number+"              Nr.          "+_onsite2000rate+"       "+_onsite200amount +"", listFont);
                    Paragraph l1Paragraph6 = new Paragraph(l16);

                    Chunk l17 = new Chunk("Steel Doors", listFont);
                    Paragraph l1Paragraph7 = new Paragraph(l17);

                    Chunk l18 = new Chunk("G. Steel double leaf double swing door complete with Frame\n" +
                            "and Accessories in size 1200 x 2100mm high as directed                 "+_steeldoorsNumber+"              Nr.          "+_steeldoorsRate+"       "+_steeldoorsAmount+"", listFont);
                    Paragraph l1Paragraph8 = new Paragraph(l18);

                    Font mSubOrderIdFont3 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk3 = new Chunk("INTERNAL DOORS TIMBER\nDOORS/SHUTTERS/HATCHES", mSubOrderIdFont3);
                    Paragraph mSubOrderIdParagraph3 = new Paragraph(mSubOrderIdChunk3);

                    Font mSubOrderIdFont4 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk4 = new Chunk("Flush: Solid core flush door with full Jamb, Frame, Subframe and Architrave\n\nDoors", mSubOrderIdFont4);
                    Paragraph mSubOrderIdParagraph4 = new Paragraph(mSubOrderIdChunk4);

                    Chunk l19 = new Chunk("F. 750 x 2100mm high overall                       "+_internaldoor750number+"              Nr.          "+_internaldoor750rate+"       "+_internaldoor750Amount+"", listFont);
                    Paragraph l1Paragraph9 = new Paragraph(l19);

                    Chunk l20 = new Chunk("G. 900 x 2100mm high overall                       "+_internaldoor900number+"              Nr.          "+_internaldoor900rate+"       "+_internaldoor900Amount +"", listFont);
                    Paragraph l1Paragraph10 = new Paragraph(l20);

                    Chunk l21 = new Chunk("H. 1200 x 2100mm high overall                      "+_internaldoor1200number+"              Nr.          "+_internaldoor1200rate+"       "+_internaldoor1200Amount+"", listFont);
                    Paragraph l1Paragraph11 = new Paragraph(l21);



                    Chunk l6 = new Chunk("Windows and Doors to Summary:                                                          "+total_amount+"", listFont2);
                    Paragraph l6Paragraph = new Paragraph(l6);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    document.add(new Paragraph(""));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Paragraph(""));
                    document.add(listParagraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph2);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph3);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph4);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph5);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph6);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph7);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph8);
                    document.add(new Chunk(lineSeparator));
                    document.add(mSubOrderIdParagraph3);
                    document.add(mSubOrderIdParagraph4);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph9);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph10);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph11);

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
                    //TODO: later done
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
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    //
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(WindowsDoorsActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(WindowsDoorsActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(WindowsDoorsActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
                _windows_doors_title = windows_doors_title.getText().toString().trim();
                if(_windows_doors_title.isEmpty()){
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void getValues() {
        try {
            _onsite_600_600_number_et = Integer.parseInt(onsite_600_600_number_et.getText().toString().trim());
            _onsite_600_600_rate_et = Integer.parseInt(onsite_600_600_rate_et.getText().toString().trim());
            _onsite_600_600_amount = _onsite_600_600_number_et * _onsite_600_600_rate_et;

            _onsite_900_600_number_et =  Integer.parseInt(onsite_900_600_number_et.getText().toString().trim());
            _onsite_900_600_rate_et = Integer.parseInt(onsite_900_600_rate_et.getText().toString().trim());
            _onsite_900_600_amount = _onsite_900_600_number_et * _onsite_900_600_rate_et;

            _onsite1200number = Integer.parseInt(onsite1200number.getText().toString().trim());
            _onsite1200rate = Integer.parseInt(onsite1200rate.getText().toString().trim());
            _onsite1200amount =_onsite1200number * _onsite1200rate;

            _onsite1500number = Integer.parseInt(onsite1500number.getText().toString().trim());
            _onsite1500rate = Integer.parseInt(onsite1500rate.getText().toString().trim());
            _onsite1500amount = _onsite1500number * _onsite1500rate;

            _onsite2400number = Integer.parseInt(onsite2400number.getText().toString().trim());
            _onsite2400rate = Integer.parseInt(onsite2400rate.getText().toString().trim());
            _onsite2400amount = _onsite2400number * _onsite2400rate;

            _onsite2000number = Integer.parseInt( onsite2000number.getText().toString().trim());
            _onsite2000rate = Integer.parseInt(onsite2000rate.getText().toString().trim());
            _onsite200amount = _onsite2000number * _onsite2000rate;

            _steeldoorsNumber = Integer.parseInt(steeldoorsNumber.getText().toString().trim());
            _steeldoorsRate = Integer.parseInt(steeldoorsRate.getText().toString().trim());
            _steeldoorsAmount = _steeldoorsNumber * _steeldoorsRate;

            _internaldoor750number = Integer.parseInt(internaldoor750number.getText().toString().trim());
            _internaldoor750rate = Integer.parseInt(internaldoor750rate.getText().toString().trim());
            _internaldoor750Amount = _internaldoor750number * _internaldoor750rate;

            _internaldoor900number = Integer.parseInt(internaldoor900number.getText().toString().trim());
            _internaldoor900rate = Integer.parseInt(internaldoor900rate.getText().toString().trim());
            _internaldoor900Amount = _internaldoor900number * _internaldoor900rate;

            _internaldoor1200number = Integer.parseInt(internaldoor1200number.getText().toString().trim());
            _internaldoor1200rate = Integer.parseInt(internaldoor1200rate.getText().toString().trim());
            _internaldoor1200Amount = _internaldoor1200number * _internaldoor1200rate;

            total_amount = _onsite1200amount + _onsite_900_600_amount + _onsite_600_600_amount + _onsite1500amount
                    + _onsite2400amount + _onsite200amount + _steeldoorsAmount + _internaldoor750Amount + _internaldoor900Amount + _internaldoor1200Amount;

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
        windows_doors_title.setText(title);
    }
}
