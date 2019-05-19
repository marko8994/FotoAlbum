package com.rms.markomladenovic.fotoalbum;

import android.os.Parcel;
import android.os.Parcelable;

public class Travel implements Parcelable {

    private String continent;
    private String country;
    private String place;
    private String dateStart;
    private String dateEnd;
    private String travelType;
    private String friends;

    Travel() {}

    private Travel(Parcel in) {
        continent = in.readString();
        country = in.readString();
        place = in.readString();
        dateStart = in.readString();
        dateEnd = in.readString();
//        dateStart = (java.util.Date) in.readSerializable();
//        dateEnd = (java.util.Date) in.readSerializable();
        travelType = in.readString();
        friends = in.readString();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(continent);
        out.writeString(country);
        out.writeString(place);
        out.writeString(dateStart);
        out.writeString(dateEnd);
        out.writeString(travelType);
        out.writeString(friends);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Travel> CREATOR = new Creator<Travel>() {
        @Override
        public Travel createFromParcel(Parcel in) {
            return new Travel(in);
        }

        @Override
        public Travel[] newArray(int size) {
            return new Travel[size];
        }
    };

    String getContinent() {
        return continent;
    }

    void setContinent(String continent) {
        this.continent = continent;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    String getPlace() {
        return place;
    }

    void setPlace(String place) {
        this.place = place;
    }

    String getDateStart() {
        return dateStart;
    }

    void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    String getDateEnd() {
        return dateEnd;
    }

    void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    String getTravelType() {
        return travelType;
    }

    void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    String getFriends() {
        return friends;
    }

    void setFriends(String friends) {
        this.friends = friends;
    }
}