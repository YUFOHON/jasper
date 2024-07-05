package site.zhourui.jasperreportdemo.entity.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description Pledge Record Entity
 * @author: Assistant
 * @date 2024/07/05
 */
public class PledgeRecord implements Serializable {
    private String name;
    private String email;
    private Long pledgeType;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPledgeType() {
        return pledgeType;
    }

    public void setPledgeType(Long pledgeType) {
        this.pledgeType = pledgeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PledgeRecord{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pledgeType=" + pledgeType +
                ", amount=" + amount +
                '}';
    }
}