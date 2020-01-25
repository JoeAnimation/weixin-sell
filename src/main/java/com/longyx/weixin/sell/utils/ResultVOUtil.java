package com.longyx.weixin.sell.utils;

import com.longyx.weixin.sell.VO.ResultVO;

/**
 * @author Mr.Longyx
 * @date 2020年01月20日 13:10
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();

        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    public static  ResultVO success(){
        return success(null);
    }

    public static ResultVO failure(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg );

        return resultVO;
    }
}
