package com.example.achat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> purshaslist;
    ArrayList<purshase> purshaslist1;
    ArrayAdapter<String>adapter;
    EditText product;
    EditText qut;
    SwipeMenuListView listview;
   // ListView listview;
    MyAdapter adapter1;
    Button add;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (SwipeMenuListView) findViewById(R.id.listView);
        product = (EditText) findViewById(R.id.product);
        qut = (EditText)findViewById(R.id.quantity);
        add = (Button)findViewById(R.id.ajouter);

        purshaslist1= new ArrayList<>();

        purshaslist1.add(new purshase("Farin","10 Kg"));
        purshaslist1.add(new purshase("Huile","10 L"));
        purshaslist1.add(new purshase("Tomate","4 Kg"));
        purshaslist1.add(new purshase("euvres","10 L"));
        purshaslist1.add(new purshase("Eau","10 L"));
        purshaslist1.add(new purshase("Extrait de vanille","1"));
        purshaslist1.add(new purshase("Poivre Noire","100 g"));
        purshaslist1.add(new purshase("Olives Noires","200 g"));

        purshaslist = new ArrayList<>();
        purshaslist.add("10 Kg Fraine");
        purshaslist.add("10 L Huile");
        purshaslist.add("4 Kg Tomate");
        purshaslist.add("10 L euvres");
        purshaslist.add("10 L Eau");
        purshaslist.add("1 Extrait de vanille");
        purshaslist.add("100 g Poivre Noire");
        purshaslist.add("200 g Olives Noires");

        //adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,purshaslist);
         adapter1 = new MyAdapter(this,R.layout.my_ligne,purshaslist1);


        listview.setAdapter(adapter1);

       SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem edititem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                edititem.setBackground(new ColorDrawable(Color.rgb(0x5b, 0xd6,
                        0x0a)));
                // set item width
                edititem.setWidth(170);
                // set item title fontsize
                edititem.setTitleSize(18);
                // set item title font color
                edititem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(edititem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xfd,
                        0x03, 0x03)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                edititem.setIcon(R.drawable.ic_edit);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        listview.setMenuCreator(creator);


        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // edit

                        break;
                    case 1:
                        // delete
                        purshaslist1.remove(position);
                        adapter1.notifyDataSetChanged();

                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }

        });

    }



    public void buClick(View view) {

        if(product.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"You must enter product name",Toast.LENGTH_SHORT).show();
               }
        else{
            if (qut.getText().toString().equals("")){
            //purshaslist.add(0,product.getText().toString());
            purshaslist1.add(new purshase(product.getText().toString(),""));
            adapter1.notifyDataSetChanged();
            product.setText("");}
            else
            {
                //purshaslist.add(0,qut.getText().toString() + " "+ product.getText().toString());
               purshaslist1.add(new purshase(product.getText().toString(),qut.getText().toString()));
                adapter1.notifyDataSetChanged();
                product.setText("");
                qut.setText("");
            }
        }

    }


}
