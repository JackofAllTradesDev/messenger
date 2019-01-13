
package com.xlog.blackboxmobile.Model.TrasanctionsList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("origin_country")
    @Expose
    private String originCountry;
    @SerializedName("destination_country")
    @Expose
    private String destinationCountry;
    @SerializedName("link_prefixed_id")
    @Expose
    private String linkPrefixedId;
    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getLinkPrefixedId() {
        return linkPrefixedId;
    }

    public void setLinkPrefixedId(String linkPrefixedId) {
        this.linkPrefixedId = linkPrefixedId;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
