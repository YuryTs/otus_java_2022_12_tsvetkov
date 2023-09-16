package cvetkov.homework;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LightMessage implements Serializable {
    @JsonIgnore
    transient private String belongNumber;
    @JsonProperty("send_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date sendDate;
    @JsonProperty
    private String text;


    public LightMessage(@JsonProperty("belong_number") String belongNumber,
                        @JsonProperty("send_date") Date sendDate,
                        @JsonProperty("text") String text)
    {
        this.belongNumber = belongNumber;
        this.sendDate = sendDate;
        this.text = text;
    }

    public String getBelongNumber() {
        return belongNumber;
    }

    public void setBelongNumber(String belongNumber) {
        this.belongNumber = belongNumber;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightMessage that = (LightMessage) o;
        return Objects.equals(belongNumber, that.belongNumber) &&
                Objects.equals(sendDate, that.sendDate) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(belongNumber, sendDate, text);
    }

    @Override
    public String toString() {
        return "LightMessage{" +
                "belongNumber='" + belongNumber + '\'' +
                ", sendDate=" + sendDate +
                ", text='" + text + '\'' +
                '}';
    }
}
