package fi.jamk.aad.l3334.menunotificationexcercise;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PhoneDetailsActivity extends AppCompatActivity {

    private String phone = "";
    private int notification_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        Bundle extras = getIntent().getExtras();
        phone = extras.getString("phone");

        ImageView imageView = (ImageView)findViewById(R.id.phone_image);
        switch (phone) {
            case "Android": imageView.setImageResource(R.drawable.android); break;
            case "iPhone": imageView.setImageResource(R.drawable.ios); break;
            case "WindowsMobile": imageView.setImageResource(R.drawable.windows); break;
            case "Blackberry": imageView.setImageResource(R.drawable.blackberry); break;
            case "WebOS": imageView.setImageResource(R.drawable.webos); break;
            case "Ubuntu": imageView.setImageResource(R.drawable.ubuntu); break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.google_search:
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, phone);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"No activity to handle intent.", Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.exit:
                ExitDialogFragment eDialog = new ExitDialogFragment();
                eDialog.show(getFragmentManager(), "exit");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendNotification(View view){
        createNotification(Notification.VISIBILITY_PUBLIC, "Text");
        Toast.makeText(getApplicationContext(),"Notification has been sent!", Toast.LENGTH_LONG).show();
    }

    public void createNotification(int visibility, String text) {
        // create a new notification
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("PTM notification")
                .setContentIntent(null)
                .setContentText(text)
                .setSmallIcon(R.drawable.ptm)
                .setAutoCancel(true)
                .setVisibility(visibility).build();
        // connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // make a new notification with a new unique id
        notification_id++;
        notificationManager.notify(notification_id, notification);
    }

}
