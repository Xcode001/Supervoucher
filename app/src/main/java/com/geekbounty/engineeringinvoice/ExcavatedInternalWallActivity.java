package com.geekbounty.engineeringinvoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExcavatedInternalWallActivity extends AppCompatActivity {

    //Variables from groundwork
    int topsoilLength, topsoilWidth, topsoilRate, trenchLength, trenchWidth, trenchDepth,trenchRate, emVolume, emRate, semVolume, semRate,
            edgeOfBedLength, edgeOfBedRate, isolatedColumnBaseArea, isolatedColumnBaseRate, reinforcementBarSize, reinforcementBarWeight,
            reinforcementBarRate, masonryWallArea, masonryWallRate, mansonryWall2Area, masonryWall2Rate, fVolume, fRate, hardcoreVolume,
            hardcoreRate, antiTermiteArea, antiTermiteRate, levelCompactBottomArea, levelCompactBottomRate, foundationVolume,
            foundationRate, bedsPouredOnLateriteVolume, bedsPouredOnLateriteRate, clearPolytheneArea, clearPolytheneRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excavated_internal_wall);

        Intent intent = getIntent();
         topsoilLength = intent.getExtras().getInt("topsoilLength");
         topsoilWidth = intent.getExtras().getInt("topsoilWidth");
         topsoilRate = intent.getExtras().getInt("topsoilRate");

         trenchLength = intent.getExtras().getInt("trenchLength");
         trenchWidth = intent.getExtras().getInt("trenchWidth");
         trenchDepth = intent.getExtras().getInt("trenchDepth");
         trenchRate = intent.getExtras().getInt("trenchRate");

         emVolume = intent.getExtras().getInt("emVolume");
         emRate = intent.getExtras().getInt("emRate");
         semVolume = intent.getExtras().getInt("semVolume");
         semRate = intent.getExtras().getInt("semRate");

         edgeOfBedLength = intent.getExtras().getInt("edgeOfBedLength");
         edgeOfBedRate = intent.getExtras().getInt("edgeOfBedRate");

         isolatedColumnBaseArea = intent.getExtras().getInt("isolatedColumnBaseArea");
         isolatedColumnBaseRate = intent.getExtras().getInt("isolatedColumnBaseRate");

         reinforcementBarSize = intent.getExtras().getInt("reinforcementBarSize");
         reinforcementBarWeight = intent.getExtras().getInt("reinforcementBarWeight");
         reinforcementBarRate = intent.getExtras().getInt("reinforcementBarRate");

         masonryWallArea = intent.getExtras().getInt("masonryWallArea");
         masonryWallRate = intent.getExtras().getInt("masonryWallRate");
         mansonryWall2Area = intent.getExtras().getInt("mansonryWall2Area");
         masonryWall2Rate = intent.getExtras().getInt("masonryWall2Rate");

         fVolume = intent.getExtras().getInt("fVolume");
         fRate = intent.getExtras().getInt("fRate");
         hardcoreVolume = intent.getExtras().getInt("hardcoreVolume");
         hardcoreRate = intent.getExtras().getInt("hardcoreRate");

         antiTermiteArea = intent.getExtras().getInt("antiTermiteArea");
         antiTermiteRate = intent.getExtras().getInt("antiTermiteRate");
         levelCompactBottomArea = intent.getExtras().getInt("levelCompactBottomArea");
         levelCompactBottomRate = intent.getExtras().getInt("levelCompactBottomRate");

         foundationVolume = intent.getExtras().getInt("foundationVolume");
         foundationRate = intent.getExtras().getInt("foundationRate");
         bedsPouredOnLateriteVolume = intent.getExtras().getInt("bedsPouredOnLateriteVolume");
         bedsPouredOnLateriteRate = intent.getExtras().getInt("bedsPouredOnLateriteRate");

         clearPolytheneArea = intent.getExtras().getInt("clearPolytheneArea");
         clearPolytheneRate = intent.getExtras().getInt("clearPolytheneRate");

    }
}
