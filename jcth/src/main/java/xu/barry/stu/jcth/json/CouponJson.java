package xu.barry.stu.jcth.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CouponJson {

    @JsonProperty("code")
    private String code;

    @JsonProperty("fromTime")
    private String fromTime;

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("toTime")
    private String toTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    @Override
    public String toString() {
        return "CouponJson{" +
                "code='" + code + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", toTime='" + toTime + '\'' +
                '}';
    }
}
