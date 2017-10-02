package fi.jamk.aad.l3334.shoppinglistwithsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Krzysztof on 02.10.2017.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PTM_database";
    public static final String DATABASE_TABLE = "item";

    public static final String ID = "_id";

    public static final String PRODUCT = "product";
    public static final String COUNT = "count";
    public static final String PRICE = "price";

    public DatabaseOpenHelper(Context context) {
        // Context, database name, optional cursor factory, database version
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a new table
        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PRODUCT+" TEXT, "+COUNT+" UNSIGNED INT, "+PRICE+" REAL);");
        // create sample data
        /*ContentValues values = new ContentValues();
        values.put(NAME, "Kirsi Kernel");
        values.put(SCORE, 5000.0);
        // insert data to database, name of table, "Nullcolumnhack", values
        db.insert(DATABASE_TABLE, null, values);
        // a more data...
        values.put(NAME, "Pekka Peloton");
        values.put(SCORE, 2000.0);
        db.insert(DATABASE_TABLE, null, values);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);
    }
}