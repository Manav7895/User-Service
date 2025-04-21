package com.UserService.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manav Rajput Java Developer
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseApiResponse {
    private int success;
    private String status;
    private String message;
    private Object data;
}
