package com.example.otostapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.HashSet;
import java.util.Set;
import java.util.prefs.Preferences;

public class DataBase extends SQLiteOpenHelper {

    private String id = "id";
    //User properties
    private String user = "User";
    private String name = "name";
    private String eMail = "eMail";
    private String password = "password";
    private String bio = "bio";
    private String sex = "sex";
    private String age = "age";
    private Context context;

    //MusicType
    private String  musicType = "MusicType";
    private String type = "type";
    //FilmGenre
    private String filmGenre = "FilmGenre";
    private String genre = "genre";

    private String userId = "UserId";
    //UserMusicType
    private String userMusicType = "UserMusicType";
    private String typeId = "typeId";
    //UserFilmGenre
    private String userFilmGenre = "UserFilmGenre";
    private String genreId = "genreId";

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON");

        String createTableUser = "CREATE TABLE " + user + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + name + " TEXT,"
                + password + " TEXT,"
                + bio + " TEXT,"
                + age + " INTEGER,"
                + sex + " TEXT,"
                + eMail + " TEXT)";
        db.execSQL(createTableUser);

        String createTableMusicType = "CREATE TABLE " + musicType + "("
                + id + " INTEGER PRIMARY KEY,"
                + type + " TEXT)";
        db.execSQL(createTableMusicType);

        String createTableFilmGenre = "CREATE TABLE " + filmGenre + "("
                + id + " INTEGER PRIMARY KEY,"
                + genre + " TEXT)";
        db.execSQL(createTableFilmGenre);

        String createTableUserMusicType = "CREATE TABLE " + userMusicType + "("
                + userId + " INTEGER REFERENCES " + user + "('" + id + "') ON DELETE CASCADE ON UPDATE CASCADE,"
                + typeId + " TEXT REFERENCES " + musicType + "('" + id + "') ON DELETE CASCADE ON UPDATE CASCADE,"
                + "PRIMARY KEY(" + userId + "," + typeId + "))";
        db.execSQL(createTableUserMusicType);

        String createTableUserFilmGenre = "CREATE TABLE " + userFilmGenre + "("
                + userId + " INTEGER REFERENCES " + user + "('" + id + "') ON DELETE CASCADE ON UPDATE CASCADE,"
                + genreId + " TEXT REFERENCES " + filmGenre + "('" + id + "') ON DELETE CASCADE ON UPDATE CASCADE,"
                + "PRIMARY KEY(" + userId + "," + genreId + "))";
        db.execSQL(createTableUserFilmGenre);

        ContentValues values = new ContentValues();
        try {
            values.put(id, 1);
            values.put(type, "Rap");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.musicType, null,values);

        values = new ContentValues();
        try {
            values.put(id, 2);
            values.put(type, "Pop");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.musicType, null,values);

        values = new ContentValues();
        try {
            values.put(id, 3);
            values.put(type, "Blues");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.musicType, null,values);

        values = new ContentValues();
        try {
            values.put(id, 4);
            values.put(type, "Jazz");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.musicType, null,values);

        values = new ContentValues();
        try {
            values.put(id, 1);
            values.put(genre, "Action");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.filmGenre, null,values);

        values = new ContentValues();
        try {
            values.put(id, 2);
            values.put(genre, "Sci-Fi");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.filmGenre, null,values);

        values = new ContentValues();
        try {
            values.put(id, 3);
            values.put(genre, "Horror");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.filmGenre, null,values);

        values = new ContentValues();
        try {
            values.put(id, 4);
            values.put(genre, "Musical");
        } catch (Exception e) {
            throw e;
        }
        db.insert(this.filmGenre, null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Boolean addUser(User user) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {
            String selectQuery = "SELECT * FROM " + this.user + " WHERE " + this.eMail + " = " + "'" + user.geteMail() + "'";
            try (Cursor cursor = db.rawQuery(selectQuery, null)) {
                ContentValues values = new ContentValues();
                try {
                    values.put(name, user.getName());
                    values.put(password, user.getPassword());
                    values.put(bio, user.getBio());
                    values.put(age, user.getAge());
                    values.put(sex, String.valueOf(user.getSex()));
                    System.out.println(user.geteMail());
                    System.out.println(user.getPassword());
                    values.put(eMail, user.geteMail());
                } catch (Exception e) {
                    throw e;
                }
                if (cursor.getCount() == 0) {
                    long id = db.insert(this.user, null, values);
                    user.setId(id);
                    addUserMusicType(user, db);
                    addUserFilmGenre(user, db);
                    return true;
                }
                return false;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addUserMusicType(User user, SQLiteDatabase db)
    {

            for(MusicType musicType : user.getMusicTypes())
            {
                ContentValues values = new ContentValues();
                values.put(userId, user.getId());
                values.put(typeId, (int)getMusicTypeWithType(musicType.type,db).getId());
                values.put(typeId, 1);

                    db.insert(this.userMusicType, null, values);


            }


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addUserFilmGenre(User user, SQLiteDatabase db)
    {

            for(FilmGenre filmGenre : user.getFilmGenres())
            {
                ContentValues values = new ContentValues();
                values.put(userId, user.getId());
                System.out.println(filmGenre.genre);
                values.put(genreId, getFilmGenreWithGenre(filmGenre.genre, db).getId());
                db.insert(this.userFilmGenre, null, values);

            }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public User getUser(String eMail, String password)
    {
        System.out.println(eMail + "    " + password);
        Set<MusicType> musicTypeSet;
        Set<FilmGenre> filmGenreSet;
        User user;
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String query = "SELECT * FROM " + this.user +
                    " WHERE " + this.eMail + " = " + "'" + eMail + "'" +
                    " and " + this.password + " = " + "'" + password + "'";;
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    System.out.println("CURSORA GİRDİ-----------------------------------------------");
                    long id = cursor.getLong(cursor.getColumnIndex(this.id));
                    String name = cursor.getString(cursor.getColumnIndex(this.name));
                    Sex sex = Sex.valueOf(cursor.getString(cursor.getColumnIndex(this.sex)));
                    int age = cursor.getInt(cursor.getColumnIndex(this.name));
                    String bio = cursor.getString(cursor.getColumnIndex(this.name));

                    musicTypeSet = getUserMusicType(id);
                    filmGenreSet = getUserFilmGenre(id);
                    user = new User(name,eMail,password,sex,age,bio,filmGenreSet,musicTypeSet);


                    return user;
                } else{

                        return null;
                    }

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Set<FilmGenre> getUserFilmGenre(long userId)
    {
        Set<FilmGenre> filmGenreSet = new HashSet<>();
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String query = "SELECT * FROM " + userFilmGenre +
                    " WHERE " + this.userId + " = " + userId;
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    do {
                        FilmGenre filmGenre = getFilmGenre(
                                cursor.getLong(cursor.getColumnIndex(this.genreId)
                                ));

                        filmGenreSet.add(filmGenre);
                    } while (cursor.moveToNext());

                    return filmGenreSet;
                } else
                    {

                        return null;
                    }

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Set<MusicType> getUserMusicType(long userId)
    {
        Set<MusicType> musicTypeSet = new HashSet<>();
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String query = "SELECT * FROM " + userMusicType +
                    " WHERE " + this.userId + " = " + userId;
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    do {
                        MusicType musicType = getMusicType(
                                cursor.getLong(cursor.getColumnIndex(this.typeId)
                                ));

                        musicTypeSet.add(musicType);
                    } while (cursor.moveToNext());

                    return musicTypeSet;
                } else
                    {
                        return null;
                    }

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public MusicType getMusicTypeWithType(String type, SQLiteDatabase db) {
        MusicType musicType = new MusicType();


            String query = "SELECT * FROM " + this.musicType +
                    " WHERE " + this.type + " = '" + type + "'";
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    long id = cursor.getLong(cursor.getColumnIndex(this.id));
                    System.out.println("ASDASDASDASDASDASDASD = " + String.valueOf(id));
                    musicType.setId(id);
                    musicType.setType(type);

                    return musicType;
                } else
                    {
                        return null;
                    }


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public FilmGenre getFilmGenreWithGenre(String genre, SQLiteDatabase db) {
        FilmGenre filmGenre = new FilmGenre();
        System.out.println(genre);

            String query = "SELECT * FROM " + this.filmGenre +
                    " WHERE " + this.genre + " = '" + genre + "'";
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    System.out.println("Filmwith genre cursora girdi");
                    long id = cursor.getLong(cursor.getColumnIndex(this.id));
                    filmGenre.setId(id);
                    filmGenre.setGenre(genre);
                    return filmGenre;
                } else
                {
                    return null;
                }

            }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public MusicType getMusicType(long typeId)
    {
        MusicType musicType = new MusicType();

        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String query = "SELECT * FROM " + this.musicType +
                    " WHERE " + this.id + " = " + typeId;
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    long id = cursor.getLong(cursor.getColumnIndex(this.id));
                    String type = cursor.getString(cursor.getColumnIndex(this.type));
                    musicType.setId(id);
                    musicType.setType(type);
                    return musicType;
                } else
                    {
                        return null;
                    }

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public FilmGenre getFilmGenre(long genreId)
    {
        FilmGenre filmGenre = new FilmGenre();

        try (SQLiteDatabase db = this.getReadableDatabase()) {
            String query = "SELECT * FROM " + this.filmGenre +
                    " WHERE " + this.id + " = " + genreId;
            try (Cursor cursor = db.rawQuery(query, null)) {
                if (cursor.moveToFirst()) {
                    long id = cursor.getLong(cursor.getColumnIndex(this.id));
                    String genre = cursor.getString(cursor.getColumnIndex(this.genre));
                    filmGenre.setId(id);
                    filmGenre.setGenre(genre);

                    return filmGenre;
                } else
                    {
                        return null;
                    }

            }
        }
    }
}
