package com.example.todoapi.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TodoDTO {
    private Long id;
    
    @NotBlank(message = "标题不能为空")
    @Size(min = 1, max = 100, message = "标题长度必须在1-100之间")
    private String title;
    
    @Size(max = 500, message = "描述不能超过500字符")
    private String description;
    
    private Boolean completed;
    private String createdAt;
    private String updatedAt;
}