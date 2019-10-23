package cn.yhd.base;

import com.fasterxml.jackson.annotation.JsonView;

public class VTopTableModel {
    @JsonView(JSONViewInterface.Video.ViewHot.class)
    private Long vtMid;

    @JsonView(JSONViewInterface.Video.All.class)
    private Long vtId;

    public Long getVtMid() {
        return vtMid;
    }

    public void setVtMid(Long vtMid) {
        this.vtMid = vtMid;
    }

    public Long getVtId() {
        return vtId;
    }

    public void setVtId(Long vtId) {
        this.vtId = vtId;
    }
}