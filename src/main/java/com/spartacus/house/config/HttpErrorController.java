package com.spartacus.house.config;

import com.spartacus.house.result.GlobalResult;
import com.spartacus.house.result.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author spartacus
 */
@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PREFIX = "error_";
    private final static String ERROR_PATH = "/error";


    @RequestMapping(value = ERROR_PATH)
    public Object errorJson(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        String key = ERROR_PREFIX + statusCode;


        GlobalResult<ResultCode> result = new GlobalResult<>();
        result.setCode(ResultCode.NOT_FOUND.getCode());
//        result.setMessage(statusCode);
        result.setSuccess(false);
        return result;

//        return HttpStatusEnum.valueOf(key).Json();
    }

//    @Override
//    public String getErrorPath() {
//        return ERROR_PATH;
//    }
}
