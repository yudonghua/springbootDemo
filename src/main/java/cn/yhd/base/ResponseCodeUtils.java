package cn.yhd.base;


/**
 * @author Leon Chen
 */
public class ResponseCodeUtils {

    /**
     * return success Model without Data
     * @return
     */
    public static final ResponseModel getSuccessResponseModel(){
        return new ResponseModel(Boolean.TRUE, 10001, "");
    }

    /**
     * return success Model
     * @param data
     * @param <T>
     * @return
     */
    public static final <T> ResponseModel getSuccessResponseModel(T data){
        ResponseModel<T> model = new ResponseModel<T>();
        model.setCode(10001);
        model.setData(data);
        return model;
    }

    /**
     * return error Model
     * @param <T>
     * @return
     */
    public static final <T> ResponseModel getErrorResponseModel(){
        return getErrorResponseModel("抱歉，开小差了!");
    }

    /**
     * return error Model
     * @param <T>
     * @return
     */
    public static final <T> ResponseModel getErrorResponseModel(String message){
        ResponseModel<T> model = new ResponseModel<>();
        model.setSuccess(false);
        model.setCode(10001);
        model.setMessage(message);
        return model;
    }

    /**
     * return parameter Model
     * @param <T>
     * @return
     */
    public static final <T> ResponseModel getParamErrorResponseModel() {
        ResponseModel<T> model = new ResponseModel<>();
        model.setSuccess(false);
        model.setCode(10001);
        model.setMessage("Soul星球最帅七叔提醒您：参数千万个，谨慎第一位。<参数填错了>，七叔两行泪！");
        return model;
    }

    /**
     * return duplicate key Model
     * @param <T>
     * @return
     */
    public static final <T> ResponseModel getDuplicateKeyErrorResponseModel() {
        ResponseModel<T> model = new ResponseModel<>();
        model.setSuccess(false);
        model.setCode(10001);
        model.setMessage("重复数据!");
        return model;
    }

}
