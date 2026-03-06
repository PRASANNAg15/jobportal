package com.example.JobPortal.UpdateDto;

import com.example.JobPortal.Utils.AppUtils;
import lombok.Data;

@Data
public class ApplicationUpdateDto {


    private AppUtils.status status;

    public AppUtils.status getStatus() {
        return status;
    }

    public void setStatus(AppUtils.status status) {
        this.status = status;
    }
}
