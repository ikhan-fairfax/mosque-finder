package com.example.scratch;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by imrank on 4/01/2014.
 */
public class MosqueResponse {
    private List<Mosque> mosques;

    public List<Mosque> getMosques() {
        return mosques;
    }

    public void setMosques(List<Mosque> mosques) {
        this.mosques = mosques;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mosques", mosques)
                .toString();
    }
}
