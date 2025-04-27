package com.model;

public abstract class DataConstants {
  // User JSON constants
  protected static final String USER_FILE_NAME = "json/users.json";
  protected static final String USER_ID = "id";
  protected static final String USER_USER_NAME = "userName";
  protected static final String USER_FIRST_NAME = "firstName";
  protected static final String USER_LAST_NAME = "lastName";
  protected static final String USER_EMAIL = "email";
  protected static final String USER_ACCOUNT_TYPE = "isTeacher";
  protected static final String USER_PASSWORD = "password";

  // Lesson JSON constants
  protected static final String LESSON_FILE_NAME = "json/lessons.json";
  protected static final String LESSON_ID = "id";
  protected static final String LESSON_TITLE = "title";
  protected static final String LESSON_DESCRIPTION = "description";
  protected static final String LESSON_CONTENT = "content";
  protected static final String LESSON_FLASHCARDS = "flashcards";
  protected static final String LESSON_QUIZ = "quiz";
  protected static final String LESSON_SONG = "song";

  // Flashcard JSON constants
  protected static final String FLASHCARD_TERM = "term";
  protected static final String FLASHCARD_DEFINITION = "definition";

  // Quiz JSON constants
  protected static final String QUIZ_QUESTION = "question";
  protected static final String QUIZ_OPTIONS = "options";
  protected static final String QUIZ_ANSWER = "answer";

  // Song JSON constants
  protected static final String SONG_FILE_NAME = "json/songs.json";
  protected static final String SONG_ID = "id";
  protected static final String SONG_TITLE = "title";
  protected static final String SONG_ARTIST = "artist";
  protected static final String SONG_AUTHOR = "author";
  protected static final String SONG_GENRE = "genre";
  protected static final String SONG_DURATION = "duration";
  protected static final String SONG_TEMPO = "tempo";
  protected static final String SONG_DEF_TIME_SIG_NUMER = "defTimeSigNumer";
  protected static final String SONG_DEF_TIME_SIG_DENOM = "defTimeSigDenom";
  protected static final String SONG_DEF_KEY_SIG = "defKeySig";
  protected static final String SONG_MEASURE_LIST = "measureList";

  // Measure JSON constants
  protected static final String MEASURE_BEAT_AMOUNT = "beatAmount";
  protected static final String MEASURE_CLEF = "clef";
  protected static final String MEASURE_IS_REPEAT = "isRepeat";
  protected static final String MEASURE_NOTES = "notes";

  // Note JSON constants
  protected static final String NOTE_PITCH = "pitch";
  protected static final String NOTE_ACCIDENTAL = "accidental";
  protected static final String NOTE_OCTAVE = "octave";
  protected static final String NOTE_LENGTH = "length";

  public static boolean isJUnitTest() {
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      if (element.getClassName().startsWith("org.junit.")) {
        return true;
      }
    }
    return false;
  }
}
