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

public class CeilingFinishesActivity extends AppCompatActivity implements TitleDialog.TitleDialogListener {

    private static final String TAG = MechanicalServicesActivity.class.getSimpleName() ;
    private static final int PERMISSION_REQUEST_CODE = 100;
    EditText ceil_fin_gen_area_et,ceil_fin_gen_rate_et, ceiling_painting_area,ceiling_painting_rate;
    TextView ceil_finTitle;
    String mechanical_servicesTitle;
    int ceil_fin_gen_area,ceil_fin_gen_rate,ceil_fin_gen_amount, ceiling_painting_area_,ceiling_painting_rate_, ceiling_painting_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceiling_finishes);
        ceil_finTitle = findViewById(R.id.ceil_finTitle);
        ceil_fin_gen_area_et = findViewById(R.id.ceil_fin_gen_area_et);
        ceil_fin_gen_rate_et = findViewById(R.id.ceil_fin_gen_rate_et);
        ceiling_painting_area = findViewById(R.id.ceiling_painting_area);
        ceiling_painting_rate = findViewById(R.id.ceiling_painting_rate);
    }


    //Generates the pdf Document
    public void createPdf() throws IOException {
        Document document = new Document();   //Creates a Document object
        String outputPath = Environment.getExternalStorageDirectory()+"/"+ mechanical_servicesTitle+ ".pdf"; //Specify the path where the document will be stored

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
                    Chunk mOrderIdChunk = new Chunk("ELEMENT 8: CEILING FINISHES\n\n", mOrderIdFont);
                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                    document.add(mOrderIdParagraph);

                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk = new Chunk("CEILING FINISHES\n" +
                            "SURFACE FINISHES", mSubOrderIdFont);
                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                    document.add(mSubOrderIdParagraph);

                    Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk2 = new Chunk("600 x 600 x 12mm thick Particle Ceiling Board fixed to\n" +
                            "Hardwood Noggings (Measured separately)\n\n", mSubOrderIdFont2);
                    Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
                    document.add(mSubOrderIdParagraph2);

                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                    Paragraph listParagraph = new Paragraph(chunk);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l1 = new Chunk("A. Ceiling generally                                                          132 Sq.M 1800 237,600.00", listFont);
                    Paragraph l1Paragraph = new Paragraph(l1);

                    Font mSubOrderIdFont3 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk3 = new Chunk("M60 PAINTING/CLEAR FINISHING", mSubOrderIdFont3);
                    Paragraph mSubOrderIdParagraph3 = new Paragraph(mSubOrderIdChunk3);
                    document.add(mSubOrderIdParagraph3);

                    Font mSubOrderIdFont4 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk4 = new Chunk("Painting render, prepare, prime and apply one undercoat\n" +
                            "Wall Primer and two Finishing Coats Emulsion Paint\n\n", mSubOrderIdFont4);
                    Paragraph mSubOrderIdParagraph4 = new Paragraph(mSubOrderIdChunk4);
                    document.add(mSubOrderIdParagraph4);

                    Chunk l12 = new Chunk("B Ceiling over 300 wide                                                      132 Sq.M 550 72,600.00", listFont);
                    Paragraph l1Paragraph2 = new Paragraph(l12);


                    Chunk l6 = new Chunk("CEILING FINISHES TO SUMMARY:                                          10000", listFont2);
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
                //Code for API < 23
                Log.v(TAG, "Permission is Granted");
                PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
                document.open();
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
                Chunk mOrderIdChunk = new Chunk("ELEMENT 7: FLOOR FINISHES", mOrderIdFont);
                Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                document.add(mOrderIdParagraph);

                Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                Chunk mSubOrderIdChunk = new Chunk("Floor Finishes", mSubOrderIdFont);
                Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                document.add(mSubOrderIdParagraph);

                Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                Chunk mSubOrderIdChunk2 = new Chunk("Lininq/Sheetinq/Dry Partitioning\n\n", mSubOrderIdFont2);
                Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
                document.add(mSubOrderIdParagraph2);


                Font excavatingFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                Chunk excavatingChunk = new Chunk("SURFACE FINISHES\n\n", excavatingFont);
                Paragraph excavatingParagraph = new Paragraph(excavatingChunk);
                document.add(excavatingParagraph);

                Font excavatingFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                Chunk excavatingChunk2 = new Chunk("25mm thick glazed vitrified ceramic tiling on 25mm thick\n" +
                        "Cement Mortar screeded Bed", excavatingFont2);
                Paragraph excavatingParagraph2 = new Paragraph(excavatingChunk2);
                document.add(excavatingParagraph2);


                Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
                Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                Paragraph listParagraph = new Paragraph(chunk);
                listParagraph.setAlignment(Element.ALIGN_CENTER);

                Chunk l1 = new Chunk("A. Level or to falls not exceeding \n   15 degrees from horizontal                 100              " +
                        "Sq.M           60           78000", listFont);
                Paragraph l1Paragraph = new Paragraph(l1);
//
                Chunk l2 = new Chunk("B. Skirting 100 high                               115              Lin.M          120           13800", listFont);
                Paragraph l2Paragraph = new Paragraph(l2);
                listParagraph.setAlignment(Element.ALIGN_CENTER);

                Chunk l6 = new Chunk("FLOOR FINISHES TO SUMMARY                                                 13800", listFont2);
                Paragraph l6Paragraph = new Paragraph(l6);
                listParagraph.setAlignment(Element.ALIGN_CENTER);

                document.add(new Paragraph(""));
                document.add(new Chunk(lineSeparator));
                document.add(new Paragraph(""));
                document.add(listParagraph);
                document.add(new Chunk(lineSeparator));
                document.add(l1Paragraph);
                document.add(new Chunk(lineSeparator));
                document.add(l2Paragraph);
                document.add(new Chunk(lineSeparator));
                document.add(new Chunk(lineSeparator));
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
                document.close();
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
        int result = ContextCompat.checkSelfPermission(CeilingFinishesActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    //
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(CeilingFinishesActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(CeilingFinishesActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(CeilingFinishesActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
                mechanical_servicesTitle = ceil_finTitle.getText().toString().trim();
                if(mechanical_servicesTitle.isEmpty()){
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
            ceil_fin_gen_area = Integer.parseInt(ceil_fin_gen_area_et.getText().toString().trim());
            ceil_fin_gen_rate = Integer.parseInt(ceil_fin_gen_rate_et.getText().toString().trim());
            ceil_fin_gen_amount = ceil_fin_gen_area * ceil_fin_gen_rate;

            ceiling_painting_area_ = Integer.parseInt(ceiling_painting_area.getText().toString().trim());
            ceiling_painting_rate_ = Integer.parseInt(ceiling_painting_rate.getText().toString().trim());
            ceiling_painting_amount = ceiling_painting_area_ * ceiling_painting_rate_;

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
        ceil_finTitle.setText(title);
    }
}
