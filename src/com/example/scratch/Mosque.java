package com.example.scratch;

import android.graphics.Bitmap;
import com.google.common.base.Objects;

/**
 * Created by imrank on 4/01/2014.
 */
public class Mosque {
    private String name;
    private String address;
    private String coordinates;
    private Bitmap imageBitmap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("address", address)
                .add("coordinates", coordinates)
                .toString();
    }
}
