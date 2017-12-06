package com.quitz.test.db;


import java.io.File;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper {
public static ArrayList<String[]> DATA = new ArrayList<String[]>();
private static final String DATABASE_NAME = "friendmapper.db";
private static final int DATABASE_VERSION = 1;
private static final String STUDENT_TABLE = "friend";
private static final String STUDENT_TABLE1 = "company";
private static final String STUDENT_TABLE2 = "joppost";
private static final String STUDENT_TABLE3 = "apply";
private Context context;
private SQLiteDatabase db = null;
OpenHelper openHelper;

public SQLiteHelper(Context context) {
this.context = context;

if (db != null)
if (db.isOpen())
db.close();

openHelper = new OpenHelper(this.context);
this.db = openHelper.getWritableDatabase();
}

public void close() {
if (openHelper != null) {
openHelper.close();
}
}

public int insertData(String name, String pw,String em,String mn,String sex,String gr,String ex,String ks,String cn )  {
int entryId = 0;
ContentValues values = new ContentValues();
values.put("name", name);

values.put("pw", pw);
values.put("em", em);
values.put("mn", mn);
values.put("sex", sex);
values.put("gr", gr);
values.put("ex", ex);
values.put("ks", ks);
values.put("cn", cn);
values.put("cn1", "no avable");
entryId = (int) this.db.insert(STUDENT_TABLE, null, values);
return entryId;
}
public int insertData1(String name, String pw )  {
int entryId = 0;
ContentValues values = new ContentValues();
values.put("cn", name);

values.put("pw", pw);

entryId = (int) this.db.insert(STUDENT_TABLE1, null, values);
return entryId;
}
public int insertData2( String pw,String em,String mn,String sex,String gr,String ex,String ks )  {
int entryId = 0;
ContentValues values = new ContentValues();


values.put("cn", pw);
values.put("el", em);
values.put("ex", mn);
values.put("po", sex);
values.put("id", gr);
values.put("sa", ex);
values.put("lo", ks);

entryId = (int) this.db.insert(STUDENT_TABLE2, null, values);
return entryId;
}

public ArrayList<String[]> selectdatabase(String search) {
Cursor c = null;
DATA.clear();
String[] columns = new String[] { "seat" };
c = db.query(STUDENT_TABLE, columns,
"travels=", new String[] { search,
search, search }, null, null, "id DESC");
if (c.moveToFirst()) {
do {
if (c.getColumnCount() == 4) {
String[] str = new String[3];
str[0] = c.getString(1);
str[1] = c.getString(2);
str[2] = c.getString(3);
DATA.add(str);
}
} while (c.moveToNext());
}

if (c != null && !c.isClosed()) {
c.close();
}
return DATA;
}
public void cr(String k,String k1)
{
	ContentValues values=new ContentValues();
	values.put("cn1",k);
	

	int id=db.update(STUDENT_TABLE,values,"name=?",new String[]{k1});

}
public String loginData(String h,String h1) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	DATA.clear();
	String[] columns = new String[] { "name" ,"pw"};

	c1 = db.query(STUDENT_TABLE, columns,"name=? AND pw=?  ", new String[] {h,h1}, null,null,null);
	if (c1.moveToNext()) {

String n=c1.getString(0);
	return "ok";
	}
	else
	{
	return "no";
	}
	}

public String loginData1(String h,String h1) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	DATA.clear();
	String[] columns = new String[] { "cn" ,"pw"};

	c1 = db.query(STUDENT_TABLE1, columns,"cn=? AND pw=?  ", new String[] {h,h1}, null,null,null);
	if (c1.moveToNext()) {

String n=c1.getString(0);
	return "ok";
	}
	else
	{
	return "no";
	}
	}

public ArrayList<String[]> selectalldatabase() {
Cursor c = null;
DATA.clear();
String[] columns = new String[] { "id", "cn", "el", "ex","po","id","sa","lo" };
c = db.query(STUDENT_TABLE2, columns, null, null, null, null, "id DESC");
if (c.moveToFirst()) {
do {
if (c.getColumnCount() == 8) {
String[] str = new String[7];
str[0] = c.getString(1);
str[1] = c.getString(2);
str[2] = c.getString(3);
str[3] = c.getString(4);
str[4] = c.getString(5);
str[5] = c.getString(6);
str[6] = c.getString(7);


DATA.add(str);
}
} while (c.moveToNext());
}

if (c != null && !c.isClosed()) {
c.close();
}

return DATA;
}
public ArrayList<String[]> selectalldatabase1() {
Cursor c = null;
DATA.clear();
String[] columns = new String[] { "ke", "name", "em", "mn","sex","gr","ex","ks" };
c = db.query(STUDENT_TABLE, columns, null, null, null, null, "ke DESC");
if (c.moveToFirst()) {
do {
if (c.getColumnCount() == 8) {
String[] str = new String[7];
str[0] = c.getString(1);
str[1] = c.getString(2);
str[2] = c.getString(3);
str[3] = c.getString(4);
str[4] = c.getString(5);
str[5] = c.getString(6);
str[6] = c.getString(7);


DATA.add(str);
}
} while (c.moveToNext());
}

if (c != null && !c.isClosed()) {
c.close();
}

return DATA;
}








static class OpenHelper extends SQLiteOpenHelper {

OpenHelper(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

@Override
public void onCreate(SQLiteDatabase db) {


	db.execSQL("CREATE TABLE " + STUDENT_TABLE + "("+ "ke INTEGER PRIMARY KEY," + "name TEXT, "+"pw TEXT,"+"em TEXT,"+"mn TEXT,"+"sex TEXT,"+"gr TEXT,"+"ex TEXT,"+"ks TEXT,"+"cn TEXT,"
			 + " cn1 TEXT)");
	db.execSQL("CREATE TABLE " + STUDENT_TABLE1+ "("+ "cn TEXT, " + "pw TEXT)");
		
	db.execSQL("CREATE TABLE " + STUDENT_TABLE2+ "("+ "ke INTEGER PRIMARY KEY,"+ "cn TEXT, " +"el TEXT,"+"ex TEXT,"+"po TEXT,"+"id TEXT,"+"sa TEXT,"+ " lo TEXT)");
	
			
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
Log.w("Catch DB",
"Upgrading database, this will drop tables and recreate.");
db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE1);
db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE2);
onCreate(db);
}
}



public SQLiteDatabase getWritableDatabase() {
	// TODO Auto-generated method stub
	return null;
}

}
