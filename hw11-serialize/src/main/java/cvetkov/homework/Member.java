package cvetkov.homework;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("first")
    private String first;
    @JsonProperty("handle_id")
    private int handleId;
    @JsonProperty("image_path")
    String imagePath;
    @JsonProperty("last")
    String last;
    @JsonProperty("middle")
    String middle;
    @JsonProperty("phone_number")
    String phoneNumber;
    @JsonProperty("service")
    String service;
    @JsonProperty("thumb_path")
    String thumbPath;


    @JsonCreator
    public Member(@JsonProperty("first") String first,
                  @JsonProperty("handle_id") int handleId,
                  @JsonProperty("image_path") String imagePath,
                  @JsonProperty("last") String last,
                  @JsonProperty("middle") String middle,
                  @JsonProperty("phone_number") String phoneNumber,
                  @JsonProperty("service") String service,
                  @JsonProperty("thumb_path") String thumbPath) {
        this.first = first;
        this.handleId = handleId;
        this.imagePath = imagePath;
        this.last = last;
        this.middle = middle;
        this.phoneNumber = phoneNumber;
        this.service = service;
        this.thumbPath = thumbPath;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getHandleId() {
        return handleId;
    }

    public void setHandleId(int handleId) {
        this.handleId = handleId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    @Override
    public String toString() {
        return "Members{" +
                "first='" + first + '\'' +
                ", handleId=" + handleId +
                ", imagePath='" + imagePath + '\'' +
                ", last='" + last + '\'' +
                ", middle='" + middle + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", service='" + service + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                '}';
    }
}
