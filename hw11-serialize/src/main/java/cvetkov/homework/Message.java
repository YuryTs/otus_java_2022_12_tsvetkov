package cvetkov.homework;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    @JsonProperty("ROWID")
    private int rowid;
    @JsonProperty
    private String attributedBody;
    @JsonProperty("belong_number")
    private String belongNumber;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("date_read")
    private Date dateRead;
    @JsonProperty
    private String guid;
    @JsonProperty("handle_id")
    private int handleId;
    @JsonProperty("has_dd_results")
    private int hasDdResults;
    @JsonProperty("is_deleted")
    private int isDeleted;
    @JsonProperty("is_from_me")
    private int isFromMe;
    @JsonProperty("send_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date sendDate;
    @JsonProperty("send_status")
    private int sendStatus;
    @JsonProperty
    private String service;
    @JsonProperty
    private String text;

    public Message(@JsonProperty("ROWID")
                   int rowid,
                   @JsonProperty("attributedBody")
                   String attributedBody,
                   @JsonProperty("belong_number")
                   String belongNumber,
                   @JsonProperty("date")
                   Date date,
                   @JsonProperty("date_read")
                   Date dateRead,
                   @JsonProperty("guid")
                   String guid,
                   @JsonProperty("handle_id")
                   int handleId,
                   @JsonProperty("has_dd_results")
                   int hasDdResults,
                   @JsonProperty("is_deleted")
                   int isDeleted,
                   @JsonProperty("is_from_me")
                   int isFromMe,
                   @JsonProperty("send_date")
                   Date sendDate,
                   @JsonProperty("send_status")
                   int sendStatus,
                   @JsonProperty("service")
                   String service,
                   @JsonProperty("text")
                   String text)
    {
        this.rowid = rowid;
        this.attributedBody = attributedBody;
        this.belongNumber = belongNumber;
        this.date = date;
        this.dateRead = dateRead;
        this.guid = guid;
        this.handleId = handleId;
        this.hasDdResults = hasDdResults;
        this.isDeleted = isDeleted;
        this.isFromMe = isFromMe;
        this.sendDate = sendDate;
        this.sendStatus = sendStatus;
        this.service = service;
        this.text = text;
    }

    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public String getAttributedBody() {
        return attributedBody;
    }

    public void setAttributedBody(String attributedBody) {
        this.attributedBody = attributedBody;
    }

    public String getBelongNumber() {
        return belongNumber;
    }

    public void setBelongNumber(String belongNumber) {
        this.belongNumber = belongNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getHandleId() {
        return handleId;
    }

    public void setHandleId(int handleId) {
        this.handleId = handleId;
    }

    public int getHasDdResults() {
        return hasDdResults;
    }

    public void setHasDdResults(int hasDdResults) {
        this.hasDdResults = hasDdResults;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getIsFromMe() {
        return isFromMe;
    }

    public void setIsFromMe(int isFromMe) {
        this.isFromMe = isFromMe;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "rowid=" + rowid +
                ", attributedBody='" + attributedBody + '\'' +
                ", belongNumber='" + belongNumber + '\'' +
                ", date=" + date +
                ", dateRead=" + dateRead +
                ", guid='" + guid + '\'' +
                ", handleId=" + handleId +
                ", hasDdResults=" + hasDdResults +
                ", isDeleted=" + isDeleted +
                ", isFromMe=" + isFromMe +
                ", sendDate=" + sendDate +
                ", sendStatus=" + sendStatus +
                ", service='" + service + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
