package com.example.android.popular_movies_app.db;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author harshita.k
 */
public final class MovieContracts {

    public static final String CONTENT_AUTHORITY = "com.example.android.popular_movies_app";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class FAVOURITES_TABLE implements BaseColumns {
        public static final String TABLE_NAME = "favourites";

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();

        public static final Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        // ID OF THE MOVIE AS RETURNED BY THE API
        public static final String _ID = "id";

        // THE TITLE OF THE MOVIE
        public static final String COLUMN_TITLE = "title";

        // A SHORT DESCRIPTION OF THE MOVIE
        public static final String COLUMN_OVERVIEW = "overview";

        // THE POSTER IMAGE OF THE MOVIE
        public static final String COLUMN_POSTER_IMAGE = "poster_image";

        // THE RELEASE DATE OF THE MOVIE
        public static final String COLUMN_RELEASE_DATE = "release_date";

        // POPULARITY OF THE MOVIE
        public static final String COLUMN_POPULARITY = "popularity";

        // THE COUNT OF THE VOTES BY USERS GIVEN TO THE MOVIE
        public static final String COLUMN_VOTE_COUNT = "vote_count";

        public static String getMovieIDFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}
