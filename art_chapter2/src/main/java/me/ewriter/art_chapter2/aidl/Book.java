package me.ewriter.art_chapter2.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zubin on 2016/6/21.
 */
public class Book implements Parcelable{

    public int bookId;
    public String bookName;

    public Book(){}

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    // 反序列化由 CREATOR 来完成
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // 序列化功能
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
}
