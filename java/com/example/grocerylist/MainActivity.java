package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
static ListView listView;
static ArrayList<String> arrayList;
EditText input;
static CustomAdapter arrayAdapter;
ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listview);
         input=(EditText)findViewById(R.id.input);
         enter=(ImageView)findViewById(R.id.add);


    arrayList =new ArrayList<>();
    arrayList.add("Apple");
    arrayList.add("Mango");
    arrayList.add("Orange");
    arrayList.add("Cucumber");

LayoutInflater inflater=getLayoutInflater();
        arrayAdapter=new CustomAdapter(inflater,arrayList);
    listView.setAdapter(arrayAdapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
    }
});

listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Removed: "+arrayList.get(position), Toast.LENGTH_SHORT).show();
        removeItem(position);
        return false;
    }
});
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item=input.getText().toString();
                if(item.equals("")){
                    makeToast("Enter an Item");
                }else{

                    addItem(item);
                    input.setText("");
                    makeToast("Added:  "+item);
                }
            }
        });


    }

    public static void removeItem(int position) {
        arrayList.remove(position);
        arrayAdapter.notifyDataSetChanged();

    }


    public  static void  addItem(String item) {

        arrayList.add(item);
       arrayAdapter.notifyDataSetChanged();

    }
    public void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}