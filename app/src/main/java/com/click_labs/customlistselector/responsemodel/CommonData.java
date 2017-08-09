
package com.click_labs.customlistselector.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommonData {


    @SerializedName("STATES_APP")
    @Expose
    private List<StatesApp> statesApps = null;

    public List<StatesApp> getSTATESAPP() {
        return statesApps;
    }

    public void setStatesApps(List<StatesApp> sTATESAPP) {
        this.statesApps = sTATESAPP;
    }

}
