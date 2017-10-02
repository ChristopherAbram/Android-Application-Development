package fi.jamk.aad.l3334.shoppinglistwithsqlite;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements AddProductFragment.DialogListener {

    private final int DELETE_ID = 0;
    private SQLiteDatabase db;
    private Cursor cursor;
    private ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find list view
        itemList = (ListView)  findViewById(R.id.itemList);
        // register listView's context menu (to delete row)
        registerForContextMenu(itemList);

        // get database instance
        db = (new DatabaseOpenHelper(this)).getWritableDatabase();
        // get data with own made queryData method
        queryData();

        // calculate total points in highscores
        /*float points = 0f;
        if (cursor.moveToFirst()) {
            do {
                float score = cursor.getFloat(2); // columnIndex
                points += score;
            } while(cursor.moveToNext());
            Toast.makeText(getBaseContext(), "Total points: " + points, Toast.LENGTH_SHORT).show();
        }*/

    }

    public void queryData() {

        // get data with query
        String[] resultColumns = new String[]{DatabaseOpenHelper.ID, DatabaseOpenHelper.PRODUCT, DatabaseOpenHelper.COUNT, DatabaseOpenHelper.PRICE};
        cursor = db.query(DatabaseOpenHelper.DATABASE_TABLE,resultColumns,null,null,null,null,DatabaseOpenHelper.PRODUCT + " ASC",null);

        // add data to adapter
        ListAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.item, cursor,
                new String[] {DatabaseOpenHelper.PRODUCT, DatabaseOpenHelper.COUNT, DatabaseOpenHelper.PRICE},      // from
                new int[] {R.id.product, R.id.count, R.id.price}    // to
                ,0);  // flags

        // show data in listView
        itemList.setAdapter(adapter);
    }

    public float sumPrices(){
        float sum = 0.0f;
        float price = 0.0f;
        int count = 0;
        if (cursor.moveToFirst()) {
            do {
                price = cursor.getFloat(3); // columnIndex
                count = cursor.getInt(2);
                sum += count * price;
            } while(cursor.moveToNext());
        }
        return sum;
    }

    protected void showTotalPrice(){
        Toast.makeText(getBaseContext(), "Total price: " + sumPrices(), Toast.LENGTH_LONG).show();
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                AddProductFragment eDialog = new AddProductFragment();
                eDialog.show(getFragmentManager(), "Add a new product");
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_ID:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                String[] args = {String.valueOf(info.id)};
                db.delete(DatabaseOpenHelper.DATABASE_TABLE, "_id=?", args);
                queryData();
                showTotalPrice();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String product, int count, float price) {
        ContentValues values = new ContentValues(3);
        values.put(DatabaseOpenHelper.PRODUCT, product);
        values.put(DatabaseOpenHelper.COUNT, count);
        values.put(DatabaseOpenHelper.PRICE, price);
        long id = db.insert(DatabaseOpenHelper.DATABASE_TABLE, null, values);
        if(id != -1) {
            queryData();
            showTotalPrice();
        }
        else
            Toast.makeText(getBaseContext(), "Unable to add new item..", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
