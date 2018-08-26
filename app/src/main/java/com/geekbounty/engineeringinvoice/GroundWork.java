package com.geekbounty.engineeringinvoice;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.IntegerRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geekbounty.engineeringinvoice.dialog.TitleDialog;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class GroundWork extends AppCompatActivity implements TitleDialog.TitleDialogListener{

    private static final String TAG =  GroundWork.class.getSimpleName();
    private static final int PERMISSION_REQUEST_CODE = 100;
    EditText topsoilLength, topsoilWidth, topsoilRate, topsoilDesc,
            trenchLength, trenchWidth, trenchDepth, trenchRate, trenchDesc,
            emVolume, emRate, emDesc,
            semVolume, semRate, semDesc,
            edgeofbedLength, edgeofbedRate, edgeofbedDesc,
            isolatedColumnBaseArea, isolatedColumnbaseRate, isolaDesc,
            reinforcementBarSize, reinforcementBarWeight, reinforcementBarRate,
            masonrywallArea, masonryWallrate,
            masonryWall2Area, masonryWall2Rate,
            fVolume, fRate,
            hardcoreVolume, hardcoreRate,
            antiTermiteArea, antiTermiteRate,
            levelCompactBottomArea, levelCompactBottomRate,
            foundationVolume, foundationRate,
            bedsPouredOnLateriteVolume,bedsPouredOnLateriteRate,
            clearPolytheneArea, clearPolytheneRate,
            groundworkSummary;

    int topsoil_length, topsoil_width, topsoil_rate,  trench_length, trench_width, trench_depth, trench_rate, em_volume, em_rate,
            sem_volume, sem_rate, edge_of_bed_length, edge_of_bed_rate, isolated_column_base_area, isolated_column_base_rate, reinforcement_bar_size,
            reinforcement_bar_weight, reinforcement_bar_rate, masonry_wall_area, masonry_wall_rate, masonry_wall2_area, masonry_wall2_rate, f_volume, f_rate, hardcore_volume, hardcore_rate, anti_termite_area, anti_termite_rate, level_compact_bottom_area, level_compact_bottom_rate, foundation_volume, foundation_rate, beds_poured_on_laterite_volume, beds_poured_on_laterite_rate, clear_polythene_area, clear_polythene_rate;
    int topsoil_amount, trench_amount, em_amount, sem_amount, edge_of_bed_amount, isolated_column_base_amount, reinforcement_bar_amount, masonry_wall_amount,
            masonry_wall2_amount, f_amount, hardcore_amount, anti_termite_amount, level_compact_bottom_amount, foundation_amount,
            beds_poured_on_laterite_amount, clear_polythene_amount;

    String topsoil_desc, trench_desc, em_desc, sem_desc, edge_of_bed_desc, isola_desc, ground_work_summary;
    String ground_work_Title;
    TextView ground_workTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_work);
        initViews();

//        getSupportActionBar().hide();
//
//        topsoilLength = (EditText) findViewById(R.id.topsoil_length_et);
//        topsoilWidth = (EditText) findViewById(R.id.topsoil_width_et);
//        topSoilRate = (EditText)findViewById(R.id.rate_et);
//        generateGroundWorkReport = (Button)findViewById(R.id.groundwork_generate);
//
//
//        generateGroundWorkReport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//
//                    //Gets the User Input
//                    final int topsoilLength_num = Integer.parseInt(topsoilLength.getText().toString().trim());
//                    final int topsoilWidth_num = Integer.parseInt(topsoilWidth.getText().toString().trim());
//                    final int topsoilRate_num = Integer.parseInt(topSoilRate.getText().toString().trim());
//
//
//                    createPdf(topsoilLength_num, topsoilWidth_num, topsoilRate_num);
//                    Toast.makeText(getApplicationContext(), "PDF File Created", Toast.LENGTH_SHORT).show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        /*if(getTopsoilLength.length() >= 1 && getTopsoilWidth.length() >= 1){
            //convert to numbers and sum the numbers together
            int topsoilLength_num = Integer.parseInt(getTopsoilLength);
            int topsoilWidth_num = Integer.parseInt(getTopsoilWidth);
            int sum = topsoilLength_num + topsoilWidth_num;
        }*/

    }
    //    Initialise all the views
    private void initViews() {
        ground_workTitle = findViewById(R.id.ground_work_title_tv);
        topsoilLength = findViewById(R.id.topsoil_length_et);
        topsoilWidth = findViewById(R.id.topsoil_width_et);
        topsoilRate = findViewById(R.id.topsoil_rate_et);
        trenchLength = findViewById(R.id.trench_length_et);
        trenchWidth = findViewById(R.id.trench_width_et);
        trenchDepth = findViewById(R.id.trench_depth_et);
        trenchRate = findViewById(R.id.trench_rate_et);
        emVolume = findViewById(R.id.et_emVolume);
        emRate = findViewById(R.id.et_emRate);
        emDesc = findViewById(R.id.em_desc);
        semVolume = findViewById(R.id.et_semVolume);
        semRate = findViewById(R.id.et_semRate);
        semDesc = findViewById(R.id.sem_desc);
        edgeofbedLength =  findViewById(R.id.et_edge_of_bedLength);
        edgeofbedRate = findViewById(R.id.et_edge_of_bedRate);
        edgeofbedDesc = findViewById(R.id.edge_of_bed_desc);
        isolatedColumnBaseArea = findViewById(R.id.et_isolated_column_base_area);
        isolatedColumnbaseRate = findViewById(R.id.et_isolated_column_base_rate);
        isolaDesc = findViewById(R.id.isola_desc);
        reinforcementBarSize = findViewById(R.id.et_reinforcementbarsize_size);
        reinforcementBarWeight = findViewById(R.id.et_reinforcementbarsize_weight);
        reinforcementBarRate = findViewById(R.id.et_reinforcementbarsize_rate);
        masonrywallArea = findViewById(R.id.et_masonry_wall_area);
        masonryWallrate = findViewById(R.id.et_masonry_wall_rate);
        masonryWall2Area = findViewById(R.id.et_masonry_wall2_area);
        masonryWall2Rate = findViewById(R.id.et_masonry_wall2_area_rate);
        fVolume = findViewById(R.id.et_fVolume);
        fRate = findViewById(R.id.et_fRate);
        hardcoreVolume = findViewById(R.id.et_hardcoreVolume);
        hardcoreRate = findViewById(R.id.et_hardcoreRate);
        antiTermiteArea = findViewById(R.id.et_anti_termite_area);
        antiTermiteRate = findViewById(R.id.et_anti_termite_rate);
        levelCompactBottomArea = findViewById(R.id.et_level_compact_bottom_area);
        levelCompactBottomRate = findViewById(R.id.et_level_compact_bottom_rate);
        foundationVolume = findViewById(R.id.et_foundationVolume);
        foundationRate = findViewById(R.id.et_foundationRate);
        bedsPouredOnLateriteVolume = findViewById(R.id.et_beds_poured_on_lateriteVolume);
        bedsPouredOnLateriteRate = findViewById(R.id.et_beds_poured_on_lateriteRate);
        clearPolytheneArea = findViewById(R.id.et_clear_polythene_area);
        clearPolytheneRate = findViewById(R.id.et_clear_polythene_rate);
        groundworkSummary = findViewById(R.id.groundwork_summary);
    }



    public void generateGroundWork(View view) {

        try {
            createPdf();
            Toast.makeText(getApplicationContext(), "File Generated", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
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
                ground_work_Title = ground_workTitle.getText().toString().trim();
                if(ground_work_Title.isEmpty()){
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

    // get values from the the input input field
    private void getValues() {

        //Get integers and text from the edittext
        try{
            topsoil_length = Integer.parseInt(topsoilLength.getText().toString());
            topsoil_width = Integer.parseInt(topsoilWidth.getText().toString().trim());
            topsoil_rate = Integer.parseInt(topsoilRate.getText().toString().trim());
            topsoil_amount = topsoil_length * topsoil_width * topsoil_rate;

            trench_length = Integer.parseInt(trenchLength.getText().toString().trim());
            trench_width = Integer.parseInt(trenchWidth.getText().toString().trim());
            trench_depth = Integer.parseInt(trenchDepth.getText().toString().trim());
            trench_rate = Integer.parseInt(trenchRate.getText().toString().trim());
            trench_amount = trench_length * trench_width * trench_depth * trench_rate;


            em_volume =  Integer.parseInt(emVolume.getText().toString().trim());
            em_rate = Integer.parseInt(emRate.getText().toString().trim());
            em_amount = em_volume * em_rate;

            sem_volume = Integer.parseInt(semVolume.getText().toString().trim());
            sem_rate = Integer.parseInt(semRate.getText().toString());
            sem_amount = sem_volume * sem_rate;

            edge_of_bed_length = Integer.parseInt(edgeofbedLength.getText().toString().trim());
            edge_of_bed_rate = Integer.parseInt(edgeofbedRate.getText().toString().trim());
            edge_of_bed_amount = edge_of_bed_length * edge_of_bed_rate;

            isolated_column_base_area = Integer.parseInt(isolatedColumnBaseArea.getText().toString().trim());
            isolated_column_base_rate = Integer.parseInt(isolatedColumnbaseRate.getText().toString().trim());
            isolated_column_base_amount = isolated_column_base_area *isolated_column_base_area;

            reinforcement_bar_size = Integer.parseInt(reinforcementBarSize.getText().toString().trim());
            reinforcement_bar_weight = Integer.parseInt(reinforcementBarWeight.getText().toString().trim());
            reinforcement_bar_rate = Integer.parseInt(reinforcementBarRate.getText().toString().trim());
            reinforcement_bar_amount = reinforcement_bar_size * reinforcement_bar_weight * reinforcement_bar_rate;

            masonry_wall_area = Integer.parseInt(masonrywallArea.getText().toString().trim());
            masonry_wall_rate = Integer.parseInt(masonryWallrate.getText().toString().trim());
            masonry_wall_amount = masonry_wall_area * masonry_wall_rate;

            masonry_wall2_area = Integer.parseInt(masonryWall2Area.getText().toString().trim());
            masonry_wall2_rate = Integer.parseInt(masonryWall2Rate.getText().toString().trim());
            masonry_wall2_amount = masonry_wall2_area * masonry_wall2_rate;

            f_volume = Integer.parseInt(fVolume.getText().toString().trim());
            f_rate = Integer.parseInt(fRate.getText().toString().trim());
            f_amount = f_volume * f_rate;


            hardcore_volume = Integer.parseInt(hardcoreVolume.getText().toString().trim());
            hardcore_rate =  Integer.parseInt(hardcoreRate.getText().toString().trim());
            hardcore_amount = hardcore_volume * hardcore_rate;

            anti_termite_area = Integer.parseInt(antiTermiteArea.getText().toString().trim());
            anti_termite_rate = Integer.parseInt(antiTermiteRate.getText().toString().trim());
            anti_termite_amount = anti_termite_area * anti_termite_rate;

            level_compact_bottom_area = Integer.parseInt(levelCompactBottomArea.getText().toString().trim());
            level_compact_bottom_rate = Integer.parseInt(levelCompactBottomRate.getText().toString().trim());
            level_compact_bottom_amount = level_compact_bottom_rate * level_compact_bottom_area;

            foundation_volume = Integer.parseInt(foundationVolume.getText().toString().trim());
            foundation_rate = Integer.parseInt(foundationRate.getText().toString().trim());
            foundation_amount = foundation_volume * foundation_rate;

            beds_poured_on_laterite_volume = Integer.parseInt(bedsPouredOnLateriteVolume.getText().toString().trim());
            beds_poured_on_laterite_rate = Integer.parseInt(bedsPouredOnLateriteRate.getText().toString().trim());
            beds_poured_on_laterite_amount = beds_poured_on_laterite_volume * beds_poured_on_laterite_rate;

            clear_polythene_area = Integer.parseInt(clearPolytheneArea.getText().toString().trim());
            clear_polythene_rate = Integer.parseInt(clearPolytheneRate.getText().toString().trim());
            clear_polythene_amount = clear_polythene_area * clear_polythene_rate;

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "All input field must not be empty", Toast.LENGTH_SHORT).show();
        }

    }

    public void showDialog(){
        TitleDialog electricalDialog = new TitleDialog();
        electricalDialog.show(getSupportFragmentManager(), "Groundwork Dialog");
    }



    public void createPdf() throws IOException {
        Document document = new Document();   //Creates a Document object
        String outputPath = Environment.getExternalStorageDirectory() +"/"+ ground_work_Title + ".pdf"; //Specify the path where the document will be stored

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
                    BaseColor mColorAccent = new BaseColor(69, 69, 69);
                    float mHeadingFontSize = 16.0f;
                    float mValueFontSize = 20.0f;
                    /**
                     * How to USE FONT....
                     */
                    BaseFont baseFont = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);


                    // LINE SEPARATOR
                    LineSeparator lineSeparator = new LineSeparator();
                    lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

                    // Title Details...
                    // Adding Title....
                    Font mTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.GREEN);
                    Chunk mTitleChunk = new Chunk("NRF-FUT ENERGY-EFFICIENT BUILDING RESEARCH", mTitleFont); // Creating Chunk
                    Paragraph mTitleParagraph = new Paragraph(mTitleChunk);  // Creating Paragraph to add...
                    mTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading

                    Font mSubTitleFont = new Font(baseFont, mValueFontSize, Font.NORMAL, BaseColor.GREEN);
                    Chunk mSubTitleChunk = new Chunk("PROPOSED DETACHED 2 - BEDROOM BUNGALOW", mSubTitleFont); // Creating Chunk
                    Paragraph mSubTitleParagraph = new Paragraph(mSubTitleChunk);  // Creating Paragraph to add...
                    mSubTitleParagraph.setAlignment(Element.ALIGN_CENTER); // Setting Alignment for Heading


                    document.add(mTitleParagraph);  // Finally Adding Title chunk
                    document.add(new Paragraph(""));
                    document.add(mSubTitleParagraph);//Adding subtitle paragraph

                    // Fields of Order Details...
                    // Adding Chunks for Title and value
                    Font mOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mOrderIdChunk = new Chunk("ELEMENT 1: GROUNDWORK:", mOrderIdFont);
                    Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                    document.add(mOrderIdParagraph);

                    Font mSubOrderIdFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk mSubOrderIdChunk = new Chunk("D20 Excavating and Filling", mSubOrderIdFont);
                    Paragraph mSubOrderIdParagraph = new Paragraph(mSubOrderIdChunk);
                    document.add(mSubOrderIdParagraph);

                    Font excavatingFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk excavatingChunk = new Chunk("Excavating", excavatingFont);
                    Paragraph excavatingParagraph = new Paragraph(excavatingChunk);
                    document.add(excavatingParagraph);

                    Font listFont = new Font(baseFont, mHeadingFontSize, Font.NORMAL, mColorAccent);
                    Chunk chunk = new Chunk("Description                                    QTY              UNIT      RATE     AMOUNT ", listFont);
                    Paragraph listParagraph = new Paragraph(chunk);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

//                  ,
                    Chunk l1 = new Chunk("A. Top Soil for Preservation                    115              Sq.M          +tprate+          " +   topsoil_amount, listFont);
                    Paragraph l1Paragraph = new Paragraph(l1);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);
//
                    Chunk l2 = new Chunk("B. Trenches from stripped level                 115              Sq.M          120           "+ trench_amount, listFont);
                    Paragraph l2Paragraph = new Paragraph(l2);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

//                    , , edge_of_bed_amount, isolated_column_base_amount
                    Chunk l3 = new Chunk("C. Pits from Stripped level                     0              Sq.M          0           "+0, listFont);
                    Paragraph l3Paragraph = new Paragraph(l3);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l4 = new Chunk("Disposal", listFont);
                    Paragraph l4Paragraph = new Paragraph(l4);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l5 = new Chunk("D. Excavated Material off-site                  115              Sq.M          120           "+ em_amount, listFont);
                    Paragraph l5Paragraph = new Paragraph(l5);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l6 = new Chunk("E. Filling to excavation obtained from on-site  115              Sq.M          120           "+ sem_amount, listFont);
                    Paragraph l6Paragraph = new Paragraph(l6);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l7 = new Chunk("Filling", listFont);
                    Paragraph l7Paragraph = new Paragraph(l7);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l8 = new Chunk("F. Filling to excavation obtained off-site      115              Sq.M          120           13800", listFont);
                    Paragraph l8Paragraph = new Paragraph(l8);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l9 = new Chunk("Hardcore", listFont);
                    Paragraph l9Paragraph = new Paragraph(l9);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l0 = new Chunk("G. Filling to make up levels obtained off-site  115              Sq.M          120           13800", listFont);
                    Paragraph l10Paragraph = new Paragraph(l0);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l11 = new Chunk("H. Anti-termite solution to sides and bottom of excavation                  115              Sq.M          120           13800", listFont);
                    Paragraph l11Paragraph = new Paragraph(l11);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l12 = new Chunk("I. Level and Compact the bottom of excavation to receive concrete                    115              Sq.M          120           13800", listFont);
                    Paragraph l12Paragraph = new Paragraph(l12);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l13 = new Chunk("In-Situ Concrete ", listFont);
                    Paragraph l13Paragraph = new Paragraph(l13);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l14 = new Chunk("Plain: Concrete (1:3:6 - all in aggregate", listFont);
                    Paragraph l14Paragraph = new Paragraph(l14);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l15 = new Chunk("J. Foundation generally                    115              Sq.M          120           13800", listFont);
                    Paragraph l15Paragraph = new Paragraph(l15);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    Chunk l16 = new Chunk("K. Beds, poured on laterite earth                    115              Sq.M          120           13800", listFont);
                    Paragraph l16Paragraph = new Paragraph(l16);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);
//                    reinforcement_bar_amount, masonry_wall_amount,
//                            masonry_wall2_amount, f_amount, hardcore_amount, anti_termite_amount, level_compact_bottom_amount, foundation_amount,
//                            beds_poured_on_laterite_amount, clear_polythene_amount;
                    Chunk l17 = new Chunk("To Collection                                              13800", listFont);
                    Paragraph l17Paragraph = new Paragraph(l17);
                    listParagraph.setAlignment(Element.ALIGN_CENTER);

                    document.add(new Paragraph(""));
                    document.add(new Chunk(lineSeparator));
                    document.add(new Paragraph(""));
                    document.add(listParagraph);
                    document.add(new Chunk(lineSeparator));
//                    document.add(l1Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l2Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l3Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l4Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l5Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l6Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l7Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l8Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l8Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l9Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l10Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l11Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l12Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l13Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l14Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l15Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l16Paragraph);
                    document.add(new Chunk(lineSeparator));
                    document.add(l17Paragraph);
                    document.close();

                    List list = new List();
                    list.setListSymbol("\u2022");
                    list.setSymbolIndent(12);
                    list.setNumbered(true);
                    Toast.makeText(getApplicationContext(), "Pdf File Created", Toast.LENGTH_SHORT).show();
                }else{
                    requestPermission();//Code for permission
                }

            } else {
                //Code for API < 23
                Log.v(TAG, "Permission is Granted");
                PdfWriter.getInstance(document, new FileOutputStream(outputPath)); //Writes to the Pdf
                document.open();
//                addTitlePage(document);
//                addContent(document);
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
        int result = ContextCompat.checkSelfPermission(GroundWork.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    //
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(GroundWork.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(GroundWork.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(GroundWork.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
//    private static void addMetaData(Document document){
//        document.addTitle("My FIrst PDF");
//        document.addSubject("using iText");
//        document.addSubject("Java, PDF, iText");
//        document.addCreator("Musa Musa A.");
//        document.addCreationDate();
//    }
//
//    //    Adds A TItle Page Separately to the PDF file
//    private static void addTitlePage(Document document) throws DocumentException{
//        Paragraph preface = new Paragraph();
//        //We add an Empty line
//        addEmptyLine(preface, 1);
//        //Lets Write a big header
//        preface.add(new Paragraph("Title of the Document"));
//
//        addEmptyLine(preface, 1);
//        //Will create: Report generated by: _name, _date
//        preface.add(new Paragraph(
//                "Report generated by: " +
//                        System.getProperty("user.name")+", "+ new Date()));
//
//        addEmptyLine(preface, 3);
//        preface.add(new Paragraph("This document describes something which is very important"));
//
//        addEmptyLine(preface, 8);
//        preface.add(new Paragraph(new Paragraph(
//                "This document is a preliminary version and not subject to your license agreeement or any other agreement with Musa A.")));
//        document.add(preface);
//
//        document.newPage(); // starting a new page
//    }
//    //
//    private static  void addContent(Document document) throws DocumentException{
//        Anchor anchor = new Anchor("First Chapter");
//        anchor.setName("First Chapter");
//
//        // Second parameter is the number of the chapters
//        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//
//        Paragraph subPara = new Paragraph("Subcategory 1");
//        Section subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Paragraph 1"));
//        subCatPart.add(new Paragraph("Paragraph 2"));
//        subCatPart.add(new Paragraph("Paragraph 3"));
//
//        // add a list
//        createList(subCatPart);
//        Paragraph paragraph = new Paragraph();
//        addEmptyLine(paragraph, 5);
//        subCatPart.add(paragraph);
//
//        // add a table
//        createTable(subCatPart);
//
//        // now add all this to the document
//        document.add(catPart);
//
//        // Next section
//        anchor = new Anchor("Second Chapter");
//        anchor.setName("Second Chapter");
//
//        // Second parameter is the number of the chapter
//        catPart = new Chapter(new Paragraph(anchor), 1);
//
//        subPara = new Paragraph("Subcategory");
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("This is a very important message"));
//    }
//
//    private static void createTable(Section subCatPart) throws BadElementException {
//        PdfPTable table = new PdfPTable(3);
//
//        // t.setBorderColor(BaseColor.GRAY);
//        // t.setPadding(4);
//        // t.setSpacing(4);
//        // t.setBorderWidth(1);
//
//        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//
//        c1 = new PdfPCell(new Phrase("Table Header 2"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//
//        c1 = new PdfPCell(new Phrase("Table Header 3"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//        table.setHeaderRows(1);
//
//        table.addCell("1.0");
//        table.addCell("1.1");
//        table.addCell("1.2");
//        table.addCell("2.1");
//        table.addCell("2.2");
//        table.addCell("2.3");
//
//        subCatPart.add(table);
//
//    }
//    //
//    private static void createList(Section subCatPart) {
//        List list = new List(true, false, 10);
//        list.add(new ListItem("First point"));
//        list.add(new ListItem("Second point"));
//        list.add(new ListItem("Third point"));
//        subCatPart.add(list);
//    }
//    //
////
//    //Add Empty line(s)
//    private static void addEmptyLine(Paragraph paragraph, int number){
//        for(int i=0; i < number; i++){
//            paragraph.add(new Paragraph(" "));
//        }
//    }

    @Override
    public void applyTitle(String title) {
        ground_workTitle.setText(title);
    }
//
//    int area(int a, int b){
//        return a * b;
//    }

}
