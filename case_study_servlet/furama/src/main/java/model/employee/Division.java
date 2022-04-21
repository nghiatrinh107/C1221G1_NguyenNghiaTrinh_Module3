package model.employee;

public class Division {
    private Integer divisionId;
    private String divisionName;

    public Division() {
    }

    public Division(Integer divisionId, String divisionName) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
