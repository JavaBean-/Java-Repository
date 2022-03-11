package xu.barry.stu.jcth.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedJson {

    @JsonProperty("condition")
    private Map<String, List<String>> condition;

    @JsonProperty("range")
    private Map<String,List<String>> range = new HashMap<>();

    @JsonProperty("categoryId")
    private List<String> categoryId = new ArrayList<>();

    public Map<String, List<String>> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, List<String>> condition) {
        this.condition = condition;
    }

    public Map<String, List<String>> getRange() {
        return range;
    }

    public void setRange(Map<String, List<String>> range) {
        this.range = range;
    }

    public List<String> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<String> categoryId) {
        this.categoryId = categoryId;
    }

}
