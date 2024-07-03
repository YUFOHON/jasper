package site.zhourui.jasperreportdemo.controller;

import  site.zhourui.jasperreportdemo.entity.enums.ResponseCodeEnum;;
import  site.zhourui.jasperreportdemo.entity.vo.ResponseVO;;
public class ABaseController {
    protected static final String STATUS_SUCCESS="success";
    protected static final String STATUS_ERROR="error";
    protected <T>ResponseVO getSuccessResponseVo(T t){
        ResponseVO<T>responseVO=new ResponseVO<>();
        responseVO.setStatus(STATUS_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }
 }
