package com.example.igroup.viewpager.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by iGroup on 12/23/2016.
 */
public class Clients implements Parcelable {

    public  int clientId;
    public String firstName;
    public String lastName;
    public String programName;
    public Date lastWorkoutDate;
    public int clientImage;
    public int days;
    public String dateString;
    public String email;
    public String gender;
    public String height;
    public String last_Workout_Date_String;
    public String photo;
    public String status;
    public String units;

    protected Clients(Parcel in) {
        clientId = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        programName = in.readString();
        clientImage = in.readInt();
        days = in.readInt();
        dateString = in.readString();
        email = in.readString();
        gender = in.readString();
        height = in.readString();
        last_Workout_Date_String = in.readString();
        photo = in.readString();
        status = in.readString();
        units = in.readString();
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
        dest.writeString(programName);
        dest.writeInt(clientImage);
        dest.writeInt(days);
        dest.writeString(dateString);
        dest.writeString(email);
        dest.writeString(gender);
        dest.writeString(height);
        dest.writeString(last_Workout_Date_String);
        dest.writeString(photo);
        dest.writeString(status);
        dest.writeString(units);
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

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Date getLastWorkoutDate() {
        return lastWorkoutDate;
    }

    public void setLastWorkoutDate(Date lastWorkoutDate) {
        this.lastWorkoutDate = lastWorkoutDate;
    }

    public int getClientImage() {
        return clientImage;
    }

    public void setClientImage(int clientImage) {
        this.clientImage = clientImage;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLast_Workout_Date_String() {
        return last_Workout_Date_String;
    }

    public void setLast_Workout_Date_String(String last_Workout_Date_String) {
        this.last_Workout_Date_String = last_Workout_Date_String;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
