package com.geekbounty.engineeringinvoice;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    int[] images = {R.drawable.ground_work, R.drawable.roof, R.drawable.cladding, R.drawable.external_wall, R.drawable.windows_doors, R.drawable.wall_finishes, R.drawable.floor_finishes, R.drawable.ceiling_finishes, R.drawable.mechanical_services, R.drawable.electrical_services };

    String[] elements = {"Element 1", "Element 2", "Element 3", "Element 4", "Element 5", "Element 6", "Element 7", "ELement 8", "Element 9", "Element 10" };

    String[] elemDesc = {"Groundwork", "Roof", "Cladding/Covering", "External/Internal walls", "Windows and Doors", "Wall finishes", "Floor finishes", "Ceiling finishes", "Mechanical Intallations", "Electrical installations"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        getSupportActionBar().setTitle("Generate Invoice");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent ground_intent = new Intent(getApplicationContext(), GroundWork.class);
                        startActivity(ground_intent);
                        break;
                    case 1:
                        Intent roof_intent = new Intent(getApplicationContext(), StructruralCarcassingActivity.class);
                        startActivity(roof_intent);
                        break;
                    case 2:
                        Intent covering_intent = new Intent(getApplicationContext(), Cladding_and_Covering_Activity.class);
                        startActivity(covering_intent);
                        break;
                    case 3:
                        Intent external_intent = new Intent(getApplicationContext(), ExternalInternalWallActivity.class);
                        startActivity(external_intent);
                        break;
                    case 4:
                        Intent windows_intent = new Intent(getApplicationContext(), WindowsDoorsActivity.class);
                        startActivity(windows_intent);
                        break;
                    case 5:
                        Intent wall_intent = new Intent(getApplicationContext(), WallFinishesActivity.class);
                        startActivity(wall_intent);
                        break;
                    case 6:
                        Intent floor_intent = new Intent(getApplicationContext(), FloorFinishesActivity.class);
                        startActivity(floor_intent);
                        break;
                    case 7:
                        Intent ceiling_intent = new Intent(getApplicationContext(), CeilingFinishesActivity.class);
                        startActivity(ceiling_intent);
                        break;
                    case 8:
                        Intent mech_intent = new Intent(getApplicationContext(), MechanicalServicesActivity.class);
                        startActivity(mech_intent);
                        break;
                    case 9:
                        Intent electrical_intent = new Intent(getApplicationContext(), ElectricalServicesActivity.class);
                        startActivity(electrical_intent);
                        break;
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.home_item, null);

            ImageView element_image = (ImageView)convertView.findViewById(R.id.element_image);
            TextView  element  = convertView.findViewById(R.id.element);
            TextView element_name = convertView.findViewById(R.id.element_name);

            element_image.setImageResource(images[position]);
            element.setText(elements[position]);
            element_name.setText(elemDesc[position]);

            return convertView;
        }
    }

}
