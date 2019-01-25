/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsMeta {

    @SerializedName("status")
    @Expose
    private Long status;

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("success")
    @Expose
    private Long success;

    @SerializedName("total")
    @Expose
    private Long total;

    @SerializedName("showing")
    @Expose
    private Long showing;

    @SerializedName("page")
    @Expose
    private Long page;

    @SerializedName("pages")
    @Expose
    private Long pages;

    @SerializedName("total_processing_time")
    @Expose
    private Double totalProcessingTime;

    @SerializedName("cached")
    @Expose
    private Boolean cached;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSuccess() {
        return success;
    }

    public void setSuccess(Long success) {
        this.success = success;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getShowing() {
        return showing;
    }

    public void setShowing(Long showing) {
        this.showing = showing;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Double getTotalProcessingTime() {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime(Double totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }

    public Boolean getCached() {
        return cached;
    }

    public void setCached(Boolean cached) {
        this.cached = cached;
    }

}
