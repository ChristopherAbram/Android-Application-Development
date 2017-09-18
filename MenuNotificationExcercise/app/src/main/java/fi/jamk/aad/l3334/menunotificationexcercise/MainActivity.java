package fi.jamk.aad.l3334.menunotificationexcercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView)findViewById(R.id.my_list);

        String[] phones = new String[]{
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu"
        };

        // add data to ArrayList
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < phones.length; ++i) {
            list.add(phones[i]);
        }

        PhoneArrayAdapter adapter = new PhoneArrayAdapter(this, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                // show popup menu;
                openPopUp(view);



            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.go_to:
                Intent phoneDetailsIntent = new Intent(this, PhoneDetailsActivity.class);
                phoneDetailsIntent.putExtra("phone", "Android");
                startActivity(phoneDetailsIntent);
                return true;
            case R.id.do_sth:
                Toast.makeText(getBaseContext(), "Just nothing clever :D", Toast.LENGTH_LONG).show();
                return true;
            case R.id.do_sth_1:
                Toast.makeText(getBaseContext(), "Nothing at all!", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
    }

    public void openPopUp(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }
}
