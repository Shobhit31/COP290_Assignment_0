package com.example.shobhit.cop290assignment0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean namechk(String s, int num)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("A member name can contain alphabets and space only!");
        builder.setTitle("Member " + Integer.toString(num) + " Name Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        int i=0,j=0;
        if(s.length()==0)
        {
            builder.setMessage("Please Enter a Name.");
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
        for (i=0;i<s.length();i++)
        {

            j=s.charAt(i);
            if((j>64 && j<91) || (j>96 && j<123) || (j==32))
            {
                continue;
            }
            else
            {

                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        }
        return true;
    }
    public boolean entrychk(String s, int num)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please enter a valid Entry No!");
        builder.setTitle("Member " + Integer.toString(num) + " Entry No Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        int i,j;
        if (s.length()!=11)
        {
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
        for(i=0;i<4;i++)
        {
            j=s.charAt(i);
            if(j>47 && j<58)
            {
                continue;
            }
            else
            {
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        }
        for(i=4;i<6;i++)
        {
            j=s.charAt(i);
            if((j>64 && j<91) || (j>96 && j<123))
            {
                continue;
            }
            else
            {

                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        }
        for(i=6;i<11;i++)
        {
            j=s.charAt(i);
            if(j>47 && j<58)
            {
                continue;
            }
            else
            {
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        }
        return true;
    }


    public void getDetails(View view) {
        EditText e1= (EditText) findViewById(R.id.editText);
        EditText e2= (EditText) findViewById(R.id.editText2);
        EditText e3= (EditText) findViewById(R.id.editText3);
        EditText e4= (EditText) findViewById(R.id.editText4);
        EditText e5= (EditText) findViewById(R.id.editText5);
        EditText e6= (EditText) findViewById(R.id.editText6);
        EditText e7= (EditText) findViewById(R.id.editText7);
        String s1= e1.getText().toString();
        String s2= e2.getText().toString();
        String s3= e3.getText().toString();
        String s4= e4.getText().toString();
        String s5= e5.getText().toString();
        String s6= e6.getText().toString();
        String s7= e7.getText().toString();

        Boolean validName= namechk(s3, 1) && namechk(s5, 2) && namechk(s7, 3);
        Boolean validEntry= entrychk(s2,1) && entrychk(s4,2) && entrychk(s6,3);

        if(validEntry && validName)
        {
            Intent intent = new Intent(this, netwk.class);
            intent.putExtra("s1",s1);
            intent.putExtra("s2",s2);
            intent.putExtra("s3",s3);
            intent.putExtra("s4",s4);
            intent.putExtra("s5",s5);
            intent.putExtra("s6",s6);
            intent.putExtra("s7",s7);
            startActivity(intent);
        }


    }

    public void clearButton(View view) {
        EditText e1= (EditText) findViewById(R.id.editText);
        EditText e2= (EditText) findViewById(R.id.editText2);
        EditText e3= (EditText) findViewById(R.id.editText3);
        EditText e4= (EditText) findViewById(R.id.editText4);
        EditText e5= (EditText) findViewById(R.id.editText5);
        EditText e6= (EditText) findViewById(R.id.editText6);
        EditText e7= (EditText) findViewById(R.id.editText7);

        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lenovo.form1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lenovo.form1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
