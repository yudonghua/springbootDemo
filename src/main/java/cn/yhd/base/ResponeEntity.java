package cn.yhd.base;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class ResponeEntity implements Serializable {

    @JsonView(JSONViewInterface.Base.class)
    private int errorid;

    @JsonView(JSONViewInterface.Base.class)
    private String errordesc;
    
    @JsonView(JSONViewInterface.Base.class)
    private Object vdata;

    public int getErrorid() {
        return errorid;
    }

    public void setErrorid(int errorid) {
        this.errorid = errorid;
    }

    public String getErrordesc() {
        return errordesc;
    }

    public void setErrordesc(String errordesc) {
        this.errordesc = errordesc;
    }

    public Object getVdata() {
        return vdata;
    }

    public void setVdata(Object vdata) {
        this.vdata = vdata;
    }
}