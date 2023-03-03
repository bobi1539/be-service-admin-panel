package com.zero.admin.panel.dto.response;

import lombok.Data;

@Data
public class ResponseWithData<T> extends ABaseResponse{
    private T data;

    public ResponseWithData(int code, String message, T data){
        super(code, message);
        this.data = data;
    }
}
