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

public class WallFinishesActivity extends AppCompatActivity implements TitleDialog.TitleDialogListener {

    private static final String TAG = WallFinishesActivity.class.getSimpleName();
    private static final int PERMISSION_REQUEST_CODE = 100;
    EditText et_walls_over_300m_1_qty, et_walls_over_300m_1_rate, et_block_wide_100_200_qty, et_block_wide_100_200_rate, et_walls_over_300m_2_qty, et_walls_over_300m_2_rate,
            et_gen_surfaces_over_300_girth_qty,et_gen_surfaces_over_300_girth_rate, et_rendered_to_concrete_100_200_qty, et_rendered_to_concrete_100_200_rate;
    TextView tv_wall_fin_title;
    String wall_fin_title;
    int walls_over_300m_1_qty, walls_over_300m_1_rate, block_wide_100_200_qty, block_wide_100_200_rate, walls_over_300m_2_qty, walls_over_300m_2_rate,
            gen_surfaces_over_300_girth_qty, gen_surfaces_over_300_girth_rate, rendered_to_concrete_100_200_qty, rendered_to_concrete_100_200_rate;
    int rendered_to_concrete_100_200_amount, gen_surfaces_over_300_girth_amount, walls_over_300m_2_amount, block_wide_100_200_amount, walls_over_300m_1_amount;
    private int total_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_finishes);
        initViews();
    }

    private void initViews() {
        tv_wall_fin_title = findViewById(R.id.tv_wall_fin_title);
        et_walls_over_300m_1_qty = findViewById(R.id.walls_over_300m_1_qty );
        et_walls_over_300m_1_rate = findViewById(R.id.walls_over_300m_1_rate);
        et_block_wide_100_200_qty = findViewById(R.id.block_wide_100_200_qty);
        et_block_wide_100_200_rate = findViewById(R.id.block_wide_100_200_rate);
        et_walls_over_300m_2_qty = findViewById(R.id.walls_over_300m_2_qty);
        et_walls_over_300m_2_rate = findViewById(R.id.walls_over_300m_2_rate);
        et_gen_surfaces_over_300_girth_qty = findViewById(R.id.gen_surfaces_over_300_girth_qty);
        et_gen_surfaces_over_300_girth_rate = findViewById(R.id.gen_surfaces_over_300_girth_rate);
        et_rendered_to_concrete_100_200_qty = findViewById(R.id.rendered_to_concrete_100_200_qty);
        et_rendered_to_concrete_100_200_rate = findViewById(R.id.rendered_to_concrete_100_200_rate);
    }

    //Generates the pdf Document
    public void createPdf() throws IOException {
        Document document = new Document();   //Creates a Document object
        String outputPath = Environment.getExternalStorageDirectory()+"/"+ wall_fin_title+ ".pdf"; //Specify the path where the document will be stored

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
                    Chunk mOrderIdChunk = new Chunk("ELEMENT 8: WALL FINISHES\n\n", mOrderIdFont);
                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                    document.add(mOrderIdParagraph);

                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk = new Chunk("M. WALL FINISHES\n" +
                            "M SURFACE Finishes\n\n", mSubOrderIdFont);
                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                    document.add(mSubOrderIdParagraph);

                    Font mSubOrderIdFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk2 = new Chunk("M20 PLASTERED/RENDERED/ROUGH CAST COATING\n" +
                            "Render: Cement and Sand (1.3)\n\n", mSubOrderIdFont2);
                    Paragraph mSubOrderIdParagraph2 = new Paragraph(mSubOrderIdChunk2);
                    document.add(mSubOrderIdParagraph2);

                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Font listFont2 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent2);
                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                    Paragraph listParagraph = new Paragraph(chunk);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l1 = new Chunk("A. Walls over 300 wide;\n to concrete or blockwork                              "+walls_over_300m_1_qty+"             Sq.M      "+walls_over_300m_1_rate+"                 "+walls_over_300m_1_amount
                            +"", listFont);
                    Paragraph l1Paragraph = new Paragraph(l1);

                    Chunk l2 = new Chunk("B. 100-200 wide;\n to Concrete or blockwork                              "+block_wide_100_200_qty+"                 Lin.M      "+block_wide_100_200_rate+"                 "+block_wide_100_200_amount
                            +"", listFont);
                    Paragraph l1Paragraph2 = new Paragraph(l2);

                    Font mSubOrderIdFont3 = new Font(baseFont, mHeadingFontSize, Font.BOLD, mColorAccent);
                    Chunk mSubOrderIdChunk3 = new Chunk("N40 STONE/CONCRETE/QUARRY/CERAMIC TILING/MOSAIC\n\n", mSubOrderIdFont3);
                    Paragraph mSubOrderIdParagraph3 = new Paragraph(mSubOrderIdChunk3);
                    Font mSubOrderIdFont4 = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk4 = new Chunk("Ceramic Tiling: glazed Cushioned Edge Tiling of approved\n" +
                            "Colour BS 1281 bedded Cement Mortar on and including\n" + "Screeded backing and pointed in White Cement", mSubOrderIdFont4);
                    Paragraph mSubOrderIdParagraph4 = new Paragraph(mSubOrderIdChunk4);

                    Chunk l3 = new Chunk("C. Walls over 300 wide,\n in size 150 x 150 x 6 to Concrete                          "+walls_over_300m_2_qty+"              Sq.M          "+walls_over_300m_2_rate+"       "+walls_over_300m_2_amount+"", listFont);
                    Paragraph l1Paragraph3 = new Paragraph(l3);

                    Chunk l4 = new Chunk("D. Allow the sum of N 70,000.00 for construction of countertops\n" +
                            "in precast concrete, and finishing same in granolithic paving.                          "+0+"              Sum        "+0+"       "+0 +"", listFont);
                    Paragraph l1Paragraph4 = new Paragraph(l4);

                    Chunk mSubOrderIdChunk5 = new Chunk("M60 PAINTING/CLEAR FINISHING\n\n", mSubOrderIdFont3);
                    Paragraph mSubOrderIdParagraph5 = new Paragraph(mSubOrderIdChunk5);
                    Chunk mSubOrderIdChunk6 = new Chunk("Painting render: prepare, prime and apply one Under Coat\n" +
                            "wall Primer and two Finishing Coat Emulsion Paint\n" , mSubOrderIdFont4);
                    Paragraph mSubOrderIdParagraph6 = new Paragraph(mSubOrderIdChunk6);

                    Chunk l5 = new Chunk("E. General Surfaces over 300 Girth                          "+gen_surfaces_over_300_girth_qty +"              Sq.M          "+gen_surfaces_over_300_girth_rate+"       "+gen_surfaces_over_300_girth_amount +"", listFont);
                    Paragraph l1Paragraph5 = new Paragraph(l5);


                    Chunk l6 = new Chunk("F. 100-200 wide;\n to rendered concrete or blockwork\n" +
                            "in precast concrete, and finishing same in granolithic paving.                          "+rendered_to_concrete_100_200_qty+"              Lin.M        "+rendered_to_concrete_100_200_rate+"       "+rendered_to_concrete_100_200_amount +"", listFont);
                    Paragraph l1Paragraph6 = new Paragraph(l6);

                    Chunk mSubOrderIdChunk7 = new Chunk("WALL CABINETS AND STORE SHELVES\n\n", mSubOrderIdFont3);
                    Paragraph mSubOrderIdParagraph7 = new Paragraph(mSubOrderIdChunk7);

                    Chunk l7 = new Chunk("G. Allow the sum of N 105,400.00\n for construction of built-in\n" +
                            "wardrobes (approximately ---m2 on approach elevation).                       "+0+"              Sum          "+0+"       "+105400+"", listFont);
                    Paragraph l1Paragraph7 = new Paragraph(l7);

                    Chunk l8 = new Chunk("H. 100-200 wide; to rendered concrete or blockwork\n" +
                            "in precast concrete, and finishing\n same in granolithic paving.Allow the sum of N 250,000.00 for construction of wall\n" +
                            "shelves to stores, \n(approximately 60m2 of shelf space).                          "+0+"              Sum        "+0+"       "+250000 +"", listFont);
                    Paragraph l1Paragraph8 = new Paragraph(l8);


                    Chunk l9 = new Chunk("WALL FINISHES TO SUMMARY:                                          "+(total_amount + 105400 + 250000)+"", listFont2);
                    Paragraph l6Paragraph = new Paragraph(l9);
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
                    document.add(mSubOrderIdParagraph3);
                    document.add(mSubOrderIdParagraph4);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph3);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph4);
                    document.add(new Chunk(lineSeparator));
                    document.add(mSubOrderIdParagraph5);
                    document.add(new Chunk(lineSeparator));
                    document.add(mSubOrderIdParagraph6);
                    document.add(l1Paragraph5);
                    document.add(new Chunk(lineSeparator));
                    document.add(l1Paragraph6);
                    document.add(new Chunk(lineSeparator));
                    document.add(mSubOrderIdParagraph7);
                    document.add(mSubOrderIdParagraph6);
                    document.add(l1Paragraph7);
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
                //TODO: For Lower Api's
                Log.v(TAG, "Permission is Granted");
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
        int result = ContextCompat.checkSelfPermission(WallFinishesActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    //
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(WallFinishesActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(WallFinishesActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(WallFinishesActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
                wall_fin_title = tv_wall_fin_title.getText().toString().trim();
                if(wall_fin_title.isEmpty()){
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


    public void getValues(){
        try {
            walls_over_300m_1_qty = Integer.parseInt(et_walls_over_300m_1_qty.getText().toString().trim());
            walls_over_300m_1_rate = Integer.parseInt(et_walls_over_300m_1_rate.getText().toString().trim());
            walls_over_300m_1_amount = walls_over_300m_1_rate * walls_over_300m_1_qty;

            block_wide_100_200_qty = Integer.parseInt(et_block_wide_100_200_qty.getText().toString().trim());
            block_wide_100_200_rate = Integer.parseInt(et_block_wide_100_200_rate.getText().toString().trim());
            block_wide_100_200_amount = block_wide_100_200_qty * block_wide_100_200_rate;

            walls_over_300m_2_qty = Integer.parseInt(et_walls_over_300m_2_qty.getText().toString().trim());
            walls_over_300m_2_rate = Integer.parseInt(et_walls_over_300m_2_rate.getText().toString().trim());
            walls_over_300m_2_amount = walls_over_300m_2_qty * walls_over_300m_2_rate;

            gen_surfaces_over_300_girth_qty  = Integer.parseInt(et_gen_surfaces_over_300_girth_qty.getText().toString().trim());
            gen_surfaces_over_300_girth_rate  = Integer.parseInt(et_gen_surfaces_over_300_girth_rate.getText().toString().trim());
            gen_surfaces_over_300_girth_amount = gen_surfaces_over_300_girth_qty * gen_surfaces_over_300_girth_rate;

            rendered_to_concrete_100_200_qty = Integer.parseInt(et_rendered_to_concrete_100_200_qty.getText().toString().trim() );
            rendered_to_concrete_100_200_rate  = Integer.parseInt(et_rendered_to_concrete_100_200_rate.getText().toString().trim());
            rendered_to_concrete_100_200_amount = rendered_to_concrete_100_200_qty * rendered_to_concrete_100_200_rate;

            total_amount = walls_over_300m_1_amount + block_wide_100_200_amount + walls_over_300m_2_amount + gen_surfaces_over_300_girth_amount + rendered_to_concrete_100_200_amount;
        }catch (Exception e){
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    public void showDialog(){
        TitleDialog electricalDialog = new TitleDialog();
        electricalDialog.show(getSupportFragmentManager(), "Wall finishes Dialog");
    }

    @Override
    public void applyTitle(String title) {
        tv_wall_fin_title.setText(title);
    }

}
