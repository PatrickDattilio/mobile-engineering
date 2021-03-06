package com.dattilio.reader;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    Avatar avatar;
    String username;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeParcelable(this.avatar, flags);
        dest.writeString(this.username);
    }

    private User(Parcel in) {
        this.name = in.readString();
        this.avatar = in.readParcelable(Avatar.class.getClassLoader());
        this.username = in.readString();
    }

    public static Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
