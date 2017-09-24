package com.example.igroup.viewpager.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by iGroup on 3/19/2017.
 */
public class Clients implements Parcelable {

    public  int clientId;
    public String firstName;
    public String lastName;
    public String email;



    public Clients(Parcel in) {
        clientId = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();

    }
    public Clients() {
    }

    public static final Creator<Clients> CREATOR = new Creator<Clients>() {
        @Override
        public Clients createFromParcel(Parcel in) {
            return new Clients(in);
        }

        @Override
        public Clients[] newArray(int size) {
            return new Clients[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(clientId);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);

    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
