import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mussa on 6/3/2018.
 */

public class TopSoilOpenHelper extends SQLiteOpenHelper {

    //define Constants and log Tag
    private static  final String TAG = TopSoilOpenHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "Topsoil";
    private static final String TOPSOIL_TABLE = "Topsoil_entries";
    private static final int DATABASE_VERSION = 1;

    // Column names ...
    public static final String KEY_ID = "_id";
    public static final String KEY_TSLENGTH = "length";
    public static final String KEY_TSBREADTH = "breadth";
    public static final String KEY_TSRATE = "rate";
    public static final String KEY_TSAREA = "area";
    public static final String KEY_TSAMOUNT = "amount";

    //Database instance variables to reference writable and readable DB
    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

    //Array of Columns
    private static final String[] COLUMNS = {KEY_ID, KEY_TSLENGTH, KEY_TSBREADTH, KEY_TSAREA,KEY_TSRATE, KEY_TSAMOUNT};


    //Build the SQL query that creates the table
    private static final String TOPSOIL_TABLE_CREATE = "CREATE TABLE " +TOPSOIL_TABLE+ "(" +
            KEY_ID +" INTEGER PRIMARY KEY, " + KEY_TSLENGTH + " INTEGER, " + KEY_TSBREADTH + " INTEGER, " +KEY_TSAREA+ " INTEGER, "
            + KEY_TSRATE + " INTEGER, " + KEY_TSAMOUNT + " INTEGER );";



    //Define the Constructor
    public TopSoilOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TOPSOIL_TABLE_CREATE); //creates the DB
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
