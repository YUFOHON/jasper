package site.zhourui.jasperreportdemo.entity.po;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Description HKID Records Entity
 * @author: Assistant
 * @date 2024/07/04
 */
public class HKIDRecord implements Serializable {
    private Integer id;
    private String type;
    private String tagNo;
    private String referenceNo;
    private Time issuingTime;
    private Time callTime;
    private String counterNo;
    private String status;
    private String issuedFrom;
    private Integer calledRound;
    private String groupIndicator;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Time getIssuingTime() {
        return issuingTime;
    }

    public void setIssuingTime(Time issuingTime) {
        this.issuingTime = issuingTime;
    }

    public Time getCallTime() {
        return callTime;
    }

    public void setCallTime(Time callTime) {
        this.callTime = callTime;
    }

    public String getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuedFrom() {
        return issuedFrom;
    }

    public void setIssuedFrom(String issuedFrom) {
        this.issuedFrom = issuedFrom;
    }

    public Integer getCalledRound() {
        return calledRound;
    }

    public void setCalledRound(Integer calledRound) {
        this.calledRound = calledRound;
    }

    public String getGroupIndicator() {
        return groupIndicator;
    }

    public void setGroupIndicator(String groupIndicator) {
        this.groupIndicator = groupIndicator;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "HKIDRecord{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", tagNo='" + tagNo + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", issuingTime=" + issuingTime +
                ", callTime=" + callTime +
                ", counterNo='" + counterNo + '\'' +
                ", status='" + status + '\'' +
                ", issuedFrom='" + issuedFrom + '\'' +
                ", calledRound=" + calledRound +
                ", groupIndicator='" + groupIndicator + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}