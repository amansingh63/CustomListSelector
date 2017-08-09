
package com.click_labs.customlistselector.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatesApp {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("stateName")
    @Expose
    private String stateName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }


    public int describeContents() {
        return 0;
    }

}
