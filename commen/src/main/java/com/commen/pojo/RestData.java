package com.commen.pojo;

import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestData {

  private int code;

  private String message;

  private Object detail;

  public static RestData builderOfSuccess(){
      RestData restData = new RestData();
      return restData.success().successMessage();
  }

  public static RestData builderOfFail(){
        RestData restData = new RestData();
        return restData.fail().failMessage();
  }


  public RestData success(){
    this.code = BaseHttpCode.SUCCESS.getCode();
    return this;
  }

  public RestData fail(){
    this.code = BaseHttpCode.FAIL.getCode();
    return this;
  }

  public RestData successMessage(){
    this.message = BaseHttpMessage.SUCCESS.getMessage();
    return this;
  }

  public RestData failMessage(){
    this.message = BaseHttpMessage.FAIL.getMessage();
    return this;
  }

  public RestData details(Object data){
      this.detail = data;
      return this;
  }
}
