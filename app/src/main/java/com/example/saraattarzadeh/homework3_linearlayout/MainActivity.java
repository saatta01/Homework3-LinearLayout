package com.example.saraattarzadeh.homework3_linearlayout;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    // declare the UI elements
    Button mButton;
    EditText nameEdit;
    EditText cityEdit;
    EditText stateEdit;
    EditText zipcodeEdit;

    //public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hw3Linear";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI component
        mButton = (Button) findViewById(R.id.submitButton);
        // set the listener for this button
        mButton.setOnClickListener(this);

    }

    // my horrible attempt at saving the inputs to a txt file. It didn't work :(
    /* public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            try
            {
                for (int i = 0; i < data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i <data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    } */

    @Override
    public void onClick(View view) {
        //creating edit text variables
        nameEdit= (EditText)findViewById(R.id.nameEditText);
        cityEdit= (EditText)findViewById(R.id.cityEditText);
        stateEdit= (EditText)findViewById(R.id.stateEditText);
        zipcodeEdit= (EditText)findViewById(R.id.zipEditText);

        //grabbing the inputs and setting them to string variables
        String nameField = nameEdit.getText().toString();
        String cityField = cityEdit.getText().toString();
        String stateField = stateEdit.getText().toString();
        String zipcodeField = zipcodeEdit.getText().toString();

        //adding all the editable text components (now string variables) together in one variable
        String userInfo = nameField + "," + cityField +  "," + stateField + "," + zipcodeField;

        /*This portion (writing to a file) drove me crazy. More of my attempt to log inputs to a file. I included the read/write permissions in the manifest, but I had to remove them later. ugh, please explain.
        String [] userInfoArray = {nameField, cityField, stateField, zipcodeField};
        File dir = new File(path);
        dir.mkdirs();

       File file = new File (path + "/savedFile.txt"); */


        //log to ensure the right shit is happening, i.e. the app is allowing input and then capturing that input.
        Log.d("userInfo", userInfo);

        //Save (file, userInfoArray);

        //signify that it worked with a popup
        Toast toast = Toast.makeText(this, "Your data was submitted", Toast.LENGTH_SHORT);
        toast.show();

    }



}
