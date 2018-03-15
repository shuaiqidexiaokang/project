package com.lzkydh.model;

public class Label {
    private int labelId;
    private String labelMark;
    private String labelName;
    private int searchTimes;

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getLabelMark() {
        return labelMark;
    }

    public void setLabelMark(String labelMark) {
        this.labelMark = labelMark;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public int getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(int searchTimes) {
        this.searchTimes = searchTimes;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", labelMark='" + labelMark + '\'' +
                ", labelName='" + labelName + '\'' +
                ", searchTimes=" + searchTimes +
                '}';
    }
}
