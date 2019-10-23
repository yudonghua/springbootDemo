package cn.yhd.base;

import cn.yhd.bean.SignatureReviewCountDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhuadong
 * @date 2019/9/16
 */
public class Amain {
    public static void main(String[] args){
        List<SignatureReviewCountDTO> list = new ArrayList<>();
        SignatureReviewCountDTO signatureReviewCountDTO = new SignatureReviewCountDTO();
        signatureReviewCountDTO.setPoolCode(1);
        signatureReviewCountDTO.setPoolName("注册提交签名");
        signatureReviewCountDTO.setTodayUnReview(1L);
        signatureReviewCountDTO.setTodayReview(1L);
        signatureReviewCountDTO.setTotalUnReview(1L);
        list.add(signatureReviewCountDTO);
        System.out.println(JSONObject.toJSONString(ResponseCodeUtils.getSuccessResponseModel(list)));
    }
}
