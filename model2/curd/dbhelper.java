

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context){

        super(context,"student.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student(rollno int,name varchar(20),dept varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);
    }

    public void insertData(String table,ContentValues values) {
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(table,null,values);
        db.close();

    }


    public void updateData(String table, ContentValues values,String rollno) {
        SQLiteDatabase db= this.getWritableDatabase();
        db.update(table,values,"rollno =?",new String[]{rollno});

    }

    public Cursor rawQuery(String sql, String[] args) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql, args);
        
    }
    public Object readData() {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from student",null);

    }


    public void deleteData(String table, String s) {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(table,"rollno =?",new String[]{s});
        db.close();
    }
}
